package com.ht.controller;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ht.model.ProductDomain;
import com.ht.model.UserDomain;
import com.ht.service2.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;


@Controller
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    private ObjectMapper objectMapper=new ObjectMapper();

    @PostMapping("/add")
    public ResponseEntity<Integer> addProductWithImage(
            @RequestParam(name = "productData", required = true) String productData,
            @RequestParam(value = "imageFile", required = false) MultipartFile file) throws Exception {

        // 将 JSON 转换为 ProductDomain 对象
        ProductDomain product = objectMapper.readValue(productData, ProductDomain.class);

        // 图片处理
        if (file != null && !file.isEmpty()) {
            // 验证文件类型
            List<String> allowedTypes = Arrays.asList("image/jpeg", "image/png");
            if (!allowedTypes.contains(file.getContentType())) {
                throw new IllegalArgumentException("Invalid file type. Only JPEG and PNG are allowed.");
            }

            // 服务器上的存储路径，从配置文件中读取
            String uploadDir = "/var/www/images/";
            File uploadDirFile = new File(uploadDir);
            if (!uploadDirFile.exists()) {
                uploadDirFile.mkdirs(); // 如果目录不存在，则创建
            }

            // 生成唯一文件名（UUID 避免重复）
            String originalExtension = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
            String uniqueFileName = UUID.randomUUID().toString() + originalExtension;

            // 保存文件到服务器路径
            File savedFile = new File(uploadDir, uniqueFileName);
            file.transferTo(savedFile.toPath());

            // 将图片的相对路径存储到数据库
            product.setMainImageUrl("/images/" + uniqueFileName);
        }

        // 保存产品信息到数据库
        int productId = productService.addProduct(product);
        product.setProductId(productId);

        // 返回产品 ID
        return ResponseEntity.ok(product.getProductId());
    }

    @ResponseBody
    @GetMapping("/all")
    public Object findAllProduct(
            @RequestParam(name = "pageNum", required = false, defaultValue = "1") int pageNum,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize,
            @RequestParam(name = "query", required = false) String query
            ) {
        // 将查询条件封装到 Map 中
        Map<String, Object> params = new HashMap<>();
        params.put("query", query);
        return productService.findAllProduct(pageNum, pageSize,params);
    }
    @ResponseBody
    @GetMapping("/random")
    public Object findRandomProducts(
            @RequestParam(name = "pageNum", required = false, defaultValue = "1") int pageNum,
            @RequestParam(name = "pageSize", required = false, defaultValue = "15") int pageSize) {
        return productService.findRandomProducts(pageNum, pageSize);
    }


    @ResponseBody
    @PostMapping("/del")
    public int delProduct(@RequestParam(name = "productId") Integer productId) {
        return productService.delProduct(productId);
    }
    @ResponseBody
    @PutMapping("/update")
    public int updateProduct(ProductDomain product) {
        return productService.updateProduct(product);
    }
    @ResponseBody
    @GetMapping("/{id}")
    public ResponseEntity<ProductDomain> getProductById(@PathVariable("id") Integer productId) {
        ProductDomain product = productService.getProductById(productId);
        if (product != null) {
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }


}

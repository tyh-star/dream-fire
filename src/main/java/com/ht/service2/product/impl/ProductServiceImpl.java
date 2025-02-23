package com.ht.service2.product.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ht.dao.ProductDao;
import com.ht.dao.UserDao;
import com.ht.model.ProductDomain;
import com.ht.service2.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

@Service(value="productService")
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public int addProduct(ProductDomain product) {
        return productDao.insert(product);
    }
    @Override
    public int delProduct(Integer productId) {
        return productDao.del(productId);
    }
    @Override
    public int updateProduct(ProductDomain product) {
        return productDao.update(product);
    }
    @Override
    public PageInfo<ProductDomain> findAllProduct(int pageNum, int pageSize,Map<String,Object> params) {
        // 开始分页
        PageHelper.startPage(pageNum, pageSize);

        // 获取分页后的商品列表
        List<ProductDomain> products = productDao.selectProduct(params);

        // 封装结果到 PageInfo 对象
        return new PageInfo<>(products);
    }
    @Override
    public PageInfo<ProductDomain> findRandomProducts(int pageNum, int pageSize) {
        // 开启分页
        PageHelper.startPage(pageNum, pageSize);

        // 查询随机商品
        List<ProductDomain> products = productDao.findRandomProducts();

        // 封装结果到 PageInfo 对象
        return new PageInfo<>(products);
    }
    @Override
    public ProductDomain getProductById(Integer productId) {
        return productDao.findProductById(productId);
    }
}


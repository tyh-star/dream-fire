package com.ht.service2.product;
import com.github.pagehelper.PageInfo;
import com.ht.model.ProductDomain;

import java.util.Map;

public interface ProductService {
    int addProduct(ProductDomain product);
    PageInfo<ProductDomain> findAllProduct(int pageNum, int pageSize, Map<String,Object> params);
    PageInfo<ProductDomain> findRandomProducts(int pageNum,int pageSize);
    int delProduct(Integer productId);
    int updateProduct(ProductDomain product);
    ProductDomain getProductById(Integer productId);
}

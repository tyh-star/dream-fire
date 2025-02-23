package com.ht.dao;
import com.ht.model.ProductDomain;
import java.util.List;
import java.util.Map;
public interface ProductDao {
    int insert(ProductDomain record);
    List<ProductDomain> selectProduct(Map<String, Object> params);
    int del(Integer productId);
    int update(ProductDomain record);
    List<ProductDomain> findRandomProducts();
    ProductDomain findProductById(Integer productId);
}

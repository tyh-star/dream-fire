package com.ht.model;

public class ProductDomain {
    private Integer productId;          // 商品ID
    private String productName;         // 商品名称
    private Double price;               // 商品价格
    private String description;         // 商品描述
    private Integer stock;              // 库存数量
    private String mainImageUrl;
    private String imageUrl1;
    private String imageUrl2;
    private String imageUrl3;
    private String imageUrl4;
    private String imageUrl5;// 主图URL
    private String category;            // 商品类型

    // Getter 和 Setter 方法

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getMainImageUrl() {
        return mainImageUrl;
    }

    public void setMainImageUrl(String mainImageUrl) {
        this.mainImageUrl = mainImageUrl == null ? null : mainImageUrl.trim();
    }

    public String getImageUrl1() {
        return imageUrl1;
    }
    public void setImageUrl1(String imageUrl1) {
        this.imageUrl1 = imageUrl1 == null ? null : imageUrl1.trim();
    }
    public String getImageUrl2() {
        return imageUrl2;
    }
    public void setImageUrl2(String imageUrl2) {
        this.imageUrl2 = imageUrl2 == null ? null : imageUrl2.trim();
    }
    public String getImageUrl3() {
        return imageUrl3;
    }
    public void setImageUrl3(String imageUrl3) {
        this.imageUrl3 = imageUrl3 == null ? null : imageUrl3.trim();
    }
    public String getImageUrl4() {
        return imageUrl4;
    }
    public void setImageUrl4(String imageUrl4) {
        this.imageUrl4 = imageUrl4 == null ? null : imageUrl4.trim();
    }
    public String getImageUrl5() {
        return imageUrl5;
    }
    public void setImageUrl5(String imageUrl5) {
        this.imageUrl5 = imageUrl5 == null ? null : imageUrl5.trim();
    }
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

    // 重写 toString 方法，方便调试时查看对象的详细信息
    @Override
    public String toString() {
        return "ProductDomain{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", stock=" + stock +
                ", mainImageUrl='" + mainImageUrl + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}


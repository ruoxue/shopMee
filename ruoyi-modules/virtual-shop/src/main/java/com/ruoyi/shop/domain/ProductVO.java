package com.ruoyi.shop.domain;

public class ProductVO  extends  Product{
    private  String categoryName;
    private  String shopName;
    private Long categoryId;
    private String formateName;
    private String formateDesc;

    public String getFormateDesc() {
        return formateDesc;
    }

    public void setFormateDesc(String formateDesc) {
        this.formateDesc = formateDesc;
    }

    public String getFormateName() {
        return formateName;
    }

    public void setFormateName(String formateName) {
        this.formateName = formateName;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }
}

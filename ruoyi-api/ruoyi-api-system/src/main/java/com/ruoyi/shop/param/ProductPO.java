package com.ruoyi.shop.param;

import com.ruoyi.shop.domain.Product;
import com.ruoyi.shop.domain.ProductSku;

import java.util.List;

public class ProductPO extends Product {

    private  Long UserId;
    private Long categoryId;

    private  Long formate_id;

    private  List<ProductSpec> specArr;
    private  List<ProductSku> skus;

    public List<ProductSku> getSkus() {
        return skus;
    }

    public void setSkus(List<ProductSku> skus) {
        this.skus = skus;
    }

    public List<ProductSpec> getSpecArr() {
        return specArr;
    }

    public void setSpecArr(List<ProductSpec> specArr) {
        this.specArr = specArr;
    }

    public Long getFormate_id() {
        return formate_id;
    }

    public void setFormate_id(Long formate_id) {
        this.formate_id = formate_id;
    }

    public Long getUserId() {
        return UserId;
    }

    public void setUserId(Long userId) {
        UserId = userId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        return "ProductPO{" +super.toString()+";"+
                "categoryId=" + categoryId +
                ", UserId=" + UserId +
                '}';
    }
}

package com.ruoyi.shop.param;

import com.ruoyi.shop.domain.Product;

import java.util.List;

public class ProductPO extends Product {

    private  Long UserId;
    private Long categoryId;



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

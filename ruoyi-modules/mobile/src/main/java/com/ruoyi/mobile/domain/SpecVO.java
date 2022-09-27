package com.ruoyi.mobile.domain;

import com.ruoyi.shop.domain.ProductSpecTitle;

import java.util.List;

public class SpecVO {
    private String name;
    private List<ProductSpecTitle> list;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ProductSpecTitle> getList() {
        return list;
    }

    public void setList(List<ProductSpecTitle> list) {
        this.list = list;
    }
}

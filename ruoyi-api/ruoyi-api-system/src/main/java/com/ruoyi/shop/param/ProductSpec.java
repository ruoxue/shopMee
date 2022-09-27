package com.ruoyi.shop.param;

import java.io.Serializable;
import java.util.List;

public class ProductSpec implements Serializable {
    private  String name;
    private List<String> conName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getConName() {
        return conName;
    }

    public void setConName(List<String> conName) {
        this.conName = conName;
    }
}

package com.ruoyi.shop.domain;


import com.ruoyi.shop.domain.BuyerItem;
import com.ruoyi.shop.domain.BuyerOrder;

import java.util.List;

public class OrderPO extends BuyerOrder {
    private List<BuyerItem> buyerItems;
    private String shopName;
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

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public List<BuyerItem> getBuyerItems() {
        return buyerItems;
    }

    public void setBuyerItems(List<BuyerItem> buyerItems) {
        this.buyerItems = buyerItems;
    }
}

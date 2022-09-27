package com.ruoyi.shop.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 商品规格项对象 product_spec_title
 * 
 * @author xiaoming
 * @date 2022-08-07
 */
public class ProductSpecTitle extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 自增主键ID */
    private Long id;

    /** 店铺ID */
    @Excel(name = "店铺ID")
    private Long shopId;

    /** 商品ID */
    @Excel(name = "商品ID")
    private Long goodsId;

    /** 商品规格项名称 */
    @Excel(name = "商品规格项名称")
    private String title;

    /** 展示顺序 越小越靠前 */
    @Excel(name = "展示顺序 越小越靠前")
    private Long displayOrder;

    private Long psoSpecId ;
    private Long psoId ;
    private String name ;


    public Long getPsoSpecId() {
        return psoSpecId;
    }

    public void setPsoSpecId(Long psoSpecId) {
        this.psoSpecId = psoSpecId;
    }

    public Long getPsoId() {
        return psoId;
    }

    public void setPsoId(Long psoId) {
        this.psoId = psoId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setShopId(Long shopId) 
    {
        this.shopId = shopId;
    }

    public Long getShopId() 
    {
        return shopId;
    }
    public void setGoodsId(Long goodsId)
    {
        this.goodsId = goodsId;
    }

    public Long getGoodsId()
    {
        return goodsId;
    }
    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }
    public void setDisplayOrder(Long displayOrder) 
    {
        this.displayOrder = displayOrder;
    }

    public Long getDisplayOrder() 
    {
        return displayOrder;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("shopId", getShopId())
            .append("goodsId", getGoodsId())
            .append("title", getTitle())
            .append("displayOrder", getDisplayOrder())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}

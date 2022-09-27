package com.ruoyi.shop.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 商品规格项对象 product_spec_option
 * 
 * @author xiaoming
 * @date 2022-08-07
 */
public class ProductSpecOption extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 自增主键ID */
    private String id;

    /** 店铺ID */
    @Excel(name = "店铺ID")
    private Long shopId;

    /** 商品ID */
    @Excel(name = "商品ID")
    private Long goodsId;

    /** 商品规格项id 关联product_spec_title表主键ID */
    @Excel(name = "商品规格项id 关联product_spec_title表主键ID")
    private Long specId;

    /** 商品规格项取值 */
    @Excel(name = "商品规格项取值")
    private String name;

    /** 展示顺序 越小越靠前 */
    @Excel(name = "展示顺序 越小越靠前")
    private Long displayOrder;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
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
    public void setSpecId(Long specId)
    {
        this.specId = specId;
    }

    public Long getSpecId()
    {
        return specId;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
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
            .append("specId", getSpecId())
            .append("name", getName())
            .append("displayOrder", getDisplayOrder())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}

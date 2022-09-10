package com.ruoyi.shop.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

import java.util.List;

/**
 * 商品分类对象 product_category
 * 
 * @author xiaoming
 * @date 2022-08-07
 */
public class ProductCategory extends BaseEntity
{
    private static final long serialVersionUID = 1L;
    private List<ProductCategory> children;

    /** 主键ID */
    private Long id;

    private  Integer tree;

    /** 店铺ID */
    @Excel(name = "店铺ID")
    private Long shopId;

    /** 分类名称 */
    @Excel(name = "分类名称")
    private String name;

    /** 父分类id */
    @Excel(name = "父分类id")
    private Long parentId;

    /** 分类图片 */
    @Excel(name = "分类图片")
    private String thumb;

    /** 分类等级（一级、二级、三级分类） */
    @Excel(name = "分类等级", readConverterExp = "一=级、二级、三级分类")
    private Long level;

    /** 展示顺序 越小越靠前 */
    @Excel(name = "展示顺序 越小越靠前")
    private Long displayOrder;

    /** 状态 1:正常 0:无效 */
    @Excel(name = "状态 1:正常 0:无效")
    private Integer status;

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
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setParentId(Long parentId) 
    {
        this.parentId = parentId;
    }

    public Long getParentId() 
    {
        return parentId;
    }
    public void setThumb(String thumb) 
    {
        this.thumb = thumb;
    }

    public String getThumb() 
    {
        return thumb;
    }
    public void setLevel(Long level) 
    {
        this.level = level;
    }

    public Long getLevel() 
    {
        return level;
    }
    public void setDisplayOrder(Long displayOrder) 
    {
        this.displayOrder = displayOrder;
    }

    public Long getDisplayOrder() 
    {
        return displayOrder;
    }
    public void setStatus(Integer status) 
    {
        this.status = status;
    }

    public Integer getStatus() 
    {
        return status;
    }

    public Integer getTree() {
        return tree;
    }

    public void setTree(Integer tree) {
        this.tree = tree;
    }

    public List<ProductCategory> getChildren() {
        return children;
    }

    public void setChildren(List<ProductCategory> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("shopId", getShopId())
            .append("name", getName())
            .append("parentId", getParentId())
            .append("thumb", getThumb())
            .append("level", getLevel())
            .append("displayOrder", getDisplayOrder())
            .append("status", getStatus())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}

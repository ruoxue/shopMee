package com.ruoyi.shop.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 商户店铺对象 product_shop
 * 
 * @author xiaoming
 * @date 2022-08-10
 */
public class ProductShop extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** mallID */
    private Long shopId;

    /** 用户名称 */
    @Excel(name = "用户名称")
    private String shopName;

    /** 签名 */
    @Excel(name = "签名")
    private String shopInfo;

    /** 头像图片 */
    @Excel(name = "头像图片")
    private String avatar;

    /** 保证金 */
    @Excel(name = "保证金")
    private Long promAmount;

    /** 状态 */
    @Excel(name = "状态")
    private String shopStatus;

    /** 用户打分 */
    @Excel(name = "用户打分")
    private Long userScore;

    /** 最后登录时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "最后登录时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date lastLoginTime;

    /** 创建人 */
    @Excel(name = "创建人")
    private String createdBy;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createdTime;

    /** 更新人 */
    @Excel(name = "更新人")
    private String updatedBy;
    @Excel(name = "uid")
    private Integer userId;
    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "更新时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date updatedTime;

    public void setShopId(Long shopId) 
    {
        this.shopId = shopId;
    }

    public Long getShopId() 
    {
        return shopId;
    }
    public void setShopName(String shopName) 
    {
        this.shopName = shopName;
    }

    public String getShopName() 
    {
        return shopName;
    }
    public void setShopInfo(String shopInfo) 
    {
        this.shopInfo = shopInfo;
    }

    public String getShopInfo() 
    {
        return shopInfo;
    }
    public void setAvatar(String avatar) 
    {
        this.avatar = avatar;
    }

    public String getAvatar() 
    {
        return avatar;
    }
    public void setPromAmount(Long promAmount) 
    {
        this.promAmount = promAmount;
    }

    public Long getPromAmount() 
    {
        return promAmount;
    }
    public void setShopStatus(String shopStatus) 
    {
        this.shopStatus = shopStatus;
    }

    public String getShopStatus() 
    {
        return shopStatus;
    }
    public void setUserScore(Long userScore) 
    {
        this.userScore = userScore;
    }

    public Long getUserScore() 
    {
        return userScore;
    }
    public void setLastLoginTime(Date lastLoginTime) 
    {
        this.lastLoginTime = lastLoginTime;
    }

    public Date getLastLoginTime() 
    {
        return lastLoginTime;
    }
    public void setCreatedBy(String createdBy) 
    {
        this.createdBy = createdBy;
    }

    public String getCreatedBy() 
    {
        return createdBy;
    }
    public void setCreatedTime(Date createdTime) 
    {
        this.createdTime = createdTime;
    }

    public Date getCreatedTime() 
    {
        return createdTime;
    }
    public void setUpdatedBy(String updatedBy) 
    {
        this.updatedBy = updatedBy;
    }

    public String getUpdatedBy() 
    {
        return updatedBy;
    }
    public void setUpdatedTime(Date updatedTime) 
    {
        this.updatedTime = updatedTime;
    }

    public Date getUpdatedTime() 
    {
        return updatedTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("shopId", getShopId())
            .append("shopName", getShopName())
            .append("shopInfo", getShopInfo())
            .append("avatar", getAvatar())
            .append("promAmount", getPromAmount())
            .append("shopStatus", getShopStatus())
            .append("userScore", getUserScore())
            .append("lastLoginTime", getLastLoginTime())
            .append("createdBy", getCreatedBy())
            .append("createdTime", getCreatedTime())
            .append("updatedBy", getUpdatedBy())
            .append("updatedTime", getUpdatedTime())
            .toString();
    }
}

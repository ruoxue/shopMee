package com.ruoyi.mobile.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 商户店铺对象 MER_MALL
 * 
 * @author xiaoming
 * @date 2022-08-08
 */
public class MerMall extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** mallID */
    private Long merMallId;

    /** 用户名称 */
    @Excel(name = "用户名称")
    private String merMallName;

    /** 个性签名 */
    @Excel(name = "个性签名")
    private String merMallIntro;

    /** 头像图片 */
    @Excel(name = "头像图片")
    private String avatar;

    /** 保证金 */
    @Excel(name = "保证金")
    private Long promAmount;

    /** 状态 */
    @Excel(name = "状态")
    private String userStatus;

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

    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "更新时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date updatedTime;

    public void setMerMallId(Long merMallId) 
    {
        this.merMallId = merMallId;
    }

    public Long getMerMallId() 
    {
        return merMallId;
    }
    public void setMerMallName(String merMallName) 
    {
        this.merMallName = merMallName;
    }

    public String getMerMallName() 
    {
        return merMallName;
    }
    public void setMerMallIntro(String merMallIntro) 
    {
        this.merMallIntro = merMallIntro;
    }

    public String getMerMallIntro() 
    {
        return merMallIntro;
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
    public void setUserStatus(String userStatus) 
    {
        this.userStatus = userStatus;
    }

    public String getUserStatus() 
    {
        return userStatus;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("merMallId", getMerMallId())
            .append("merMallName", getMerMallName())
            .append("merMallIntro", getMerMallIntro())
            .append("avatar", getAvatar())
            .append("promAmount", getPromAmount())
            .append("userStatus", getUserStatus())
            .append("userScore", getUserScore())
            .append("lastLoginTime", getLastLoginTime())
            .append("createdBy", getCreatedBy())
            .append("createdTime", getCreatedTime())
            .append("updatedBy", getUpdatedBy())
            .append("updatedTime", getUpdatedTime())
            .toString();
    }
}

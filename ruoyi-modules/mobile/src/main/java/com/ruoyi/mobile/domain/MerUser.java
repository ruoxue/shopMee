package com.ruoyi.mobile.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 商户对象 MER_USER
 * 
 * @author xiaoming
 * @date 2022-08-08
 */
public class MerUser extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 用户ID */
    private Long merId;

    /** 用户名称 */
    @Excel(name = "用户名称")
    private String merName;

    /** 用户昵称 */
    @Excel(name = "用户昵称")
    private String nickName;

    /** 个性签名 */
    @Excel(name = "个性签名")
    private String merIntro;

    /** 头像图片 */
    @Excel(name = "头像图片")
    private String avatar;

    /** 邮件地址 */
    @Excel(name = "邮件地址")
    private String email;

    /** 手机号 */
    @Excel(name = "手机号")
    private String phone;

    /** 密码 */
    @Excel(name = "密码")
    private String merPass;

    /** 密码盐 */
    @Excel(name = "密码盐")
    private String passSalt;

    /** 状态 */
    @Excel(name = "状态")
    private String merStatus;

    /** 用户打分 */
    @Excel(name = "用户打分")
    private Long merScore;

    /** 累计消费金额 */
    @Excel(name = "累计消费金额")
    private BigDecimal totalCostAmt;

    /** 最后登录时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "最后登录时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date lastLoginTime;

    /** 乐观锁 */
    @Excel(name = "乐观锁")
    private Long revision;

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

    public void setMerId(Long merId) 
    {
        this.merId = merId;
    }

    public Long getMerId() 
    {
        return merId;
    }
    public void setMerName(String merName) 
    {
        this.merName = merName;
    }

    public String getMerName() 
    {
        return merName;
    }
    public void setNickName(String nickName) 
    {
        this.nickName = nickName;
    }

    public String getNickName() 
    {
        return nickName;
    }
    public void setMerIntro(String merIntro) 
    {
        this.merIntro = merIntro;
    }

    public String getMerIntro() 
    {
        return merIntro;
    }
    public void setAvatar(String avatar) 
    {
        this.avatar = avatar;
    }

    public String getAvatar() 
    {
        return avatar;
    }
    public void setEmail(String email) 
    {
        this.email = email;
    }

    public String getEmail() 
    {
        return email;
    }
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }
    public void setMerPass(String merPass) 
    {
        this.merPass = merPass;
    }

    public String getMerPass() 
    {
        return merPass;
    }
    public void setPassSalt(String passSalt) 
    {
        this.passSalt = passSalt;
    }

    public String getPassSalt() 
    {
        return passSalt;
    }
    public void setMerStatus(String merStatus) 
    {
        this.merStatus = merStatus;
    }

    public String getMerStatus() 
    {
        return merStatus;
    }
    public void setMerScore(Long merScore) 
    {
        this.merScore = merScore;
    }

    public Long getMerScore() 
    {
        return merScore;
    }
    public void setTotalCostAmt(BigDecimal totalCostAmt) 
    {
        this.totalCostAmt = totalCostAmt;
    }

    public BigDecimal getTotalCostAmt() 
    {
        return totalCostAmt;
    }
    public void setLastLoginTime(Date lastLoginTime) 
    {
        this.lastLoginTime = lastLoginTime;
    }

    public Date getLastLoginTime() 
    {
        return lastLoginTime;
    }
    public void setRevision(Long revision) 
    {
        this.revision = revision;
    }

    public Long getRevision() 
    {
        return revision;
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
            .append("merId", getMerId())
            .append("merName", getMerName())
            .append("nickName", getNickName())
            .append("merIntro", getMerIntro())
            .append("avatar", getAvatar())
            .append("email", getEmail())
            .append("phone", getPhone())
            .append("merPass", getMerPass())
            .append("passSalt", getPassSalt())
            .append("merStatus", getMerStatus())
            .append("merScore", getMerScore())
            .append("totalCostAmt", getTotalCostAmt())
            .append("lastLoginTime", getLastLoginTime())
            .append("revision", getRevision())
            .append("createdBy", getCreatedBy())
            .append("createdTime", getCreatedTime())
            .append("updatedBy", getUpdatedBy())
            .append("updatedTime", getUpdatedTime())
            .toString();
    }
}

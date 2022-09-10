package com.ruoyi.mobile.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 买家对象 BUYER_USER
 * 
 * @author xiaoming
 * @date 2022-08-08
 */
public class BuyerUser extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 用户ID */
    private String userId;

    /** 用户名称 */
    @Excel(name = "用户名称")
    private String userName;

    /** 用户昵称 */
    @Excel(name = "用户昵称")
    private String nickName;

    /** 个性签名 */
    @Excel(name = "个性签名")
    private String userIntro;

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
    private String userPass;

    /** 密码盐 */
    @Excel(name = "密码盐")
    private String passSalt;

    /** 用户状态 */
    @Excel(name = "用户状态")
    private String userStatus;

    /** 用户打分 */
    @Excel(name = "用户打分")
    private Long userScore;

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

    public void setUserId(String userId) 
    {
        this.userId = userId;
    }

    public String getUserId() 
    {
        return userId;
    }
    public void setUserName(String userName) 
    {
        this.userName = userName;
    }

    public String getUserName() 
    {
        return userName;
    }
    public void setNickName(String nickName) 
    {
        this.nickName = nickName;
    }

    public String getNickName() 
    {
        return nickName;
    }
    public void setUserIntro(String userIntro) 
    {
        this.userIntro = userIntro;
    }

    public String getUserIntro() 
    {
        return userIntro;
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
    public void setUserPass(String userPass) 
    {
        this.userPass = userPass;
    }

    public String getUserPass() 
    {
        return "";
    }
    public void setPassSalt(String passSalt) 
    {
        this.passSalt = passSalt;
    }

    public String getPassSalt() 
    {
        return "";
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
            .append("userId", getUserId())
            .append("userName", getUserName())
            .append("nickName", getNickName())
            .append("userIntro", getUserIntro())
            .append("avatar", getAvatar())
            .append("email", getEmail())
            .append("phone", getPhone())
            .append("userPass", getUserPass())
            .append("passSalt", getPassSalt())
            .append("userStatus", getUserStatus())
            .append("userScore", getUserScore())
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

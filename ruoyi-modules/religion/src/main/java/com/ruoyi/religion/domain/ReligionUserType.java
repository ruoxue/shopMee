package com.ruoyi.religion.domain;

import java.util.List;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 用户类型对象 religion_user_type
 * 
 * @author xiaoming
 * @date 2022-10-22 02:57:31
 */
public class ReligionUserType extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号;编号 */
    private Long id;

    /** 名称;名称 */
    @Excel(name = "名称;名称")
    private String name;

    /** 租户号 */
    private String tenantId;

    /** 状态（1正常） */
    @Excel(name = "状态", readConverterExp = "1=正常")
    private Long status;

    /** 删除（0正常 1删除） */
    private Long deleted;

    /** 备注;备注 */
    private String remake;

    /** 宗教人员信息 */
    private List<ReligionUser> religionUserList;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setTenantId(String tenantId) 
    {
        this.tenantId = tenantId;
    }

    public String getTenantId() 
    {
        return tenantId;
    }
    public void setStatus(Long status) 
    {
        this.status = status;
    }

    public Long getStatus() 
    {
        return status;
    }
    public void setDeleted(Long deleted) 
    {
        this.deleted = deleted;
    }

    public Long getDeleted() 
    {
        return deleted;
    }
    public void setRemake(String remake) 
    {
        this.remake = remake;
    }

    public String getRemake() 
    {
        return remake;
    }

    public List<ReligionUser> getReligionUserList()
    {
        return religionUserList;
    }

    public void setReligionUserList(List<ReligionUser> religionUserList)
    {
        this.religionUserList = religionUserList;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("tenantId", getTenantId())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("status", getStatus())
            .append("deleted", getDeleted())
            .append("remake", getRemake())
            .append("religionUserList", getReligionUserList())
            .toString();
    }
}

package com.ruoyi.religion.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 财务数据对象 religion_finance
 * 
 * @author xiaoming
 * @date 2022-10-22 09:17:31
 */
public class ReligionFinance extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long id;

    /** 名称 */
    @Excel(name = "名称")
    private String name;

    /** 租户号 */
    private String tenantId;

    /** 类型 */
    @Excel(name = "类型")
    private Long financeType;

    /** 状态 */
    @Excel(name = "状态")
    private Long status;

    /** 财务文件 */
    @Excel(name = "财务文件")
    private String financeFile;

    /** 删除 */
    private Long deleted;

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
    public void setFinanceType(Long financeType) 
    {
        this.financeType = financeType;
    }

    public Long getFinanceType() 
    {
        return financeType;
    }
    public void setStatus(Long status) 
    {
        this.status = status;
    }

    public Long getStatus() 
    {
        return status;
    }
    public void setFinanceFile(String financeFile) 
    {
        this.financeFile = financeFile;
    }

    public String getFinanceFile() 
    {
        return financeFile;
    }
    public void setDeleted(Long deleted) 
    {
        this.deleted = deleted;
    }

    public Long getDeleted() 
    {
        return deleted;
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
            .append("financeType", getFinanceType())
            .append("status", getStatus())
            .append("financeFile", getFinanceFile())
            .append("deleted", getDeleted())
            .append("remark", getRemark())
            .toString();
    }
}

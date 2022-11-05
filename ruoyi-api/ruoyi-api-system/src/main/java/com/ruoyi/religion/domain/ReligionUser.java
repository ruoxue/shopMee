package com.ruoyi.religion.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 宗教人员对象 religion_user
 * 
 * @author xiaoming
 * @date 2022-10-22 09:17:33
 */
public class ReligionUser extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long id;

    /** 姓名 */
    @Excel(name = "姓名")
    private String name;

    /** 租户号 */
    private String tenantId;

    /** 状态 */
    @Excel(name = "状态")
    private Long status;

    /** 删除 */
    private Long deleted;

    /** 用户账号 */
    @Excel(name = "用户账号")
    private String userName;

    /** 法名 */
    @Excel(name = "法名")
    private String nickName;

    /** 用户邮箱 */
    @Excel(name = "用户邮箱")
    private String email;

    /** 联系方式 */
    @Excel(name = "联系方式")
    private String phonenumber;

    /** 用户性别（0男 1女 2未知） */
    @Excel(name = "用户性别", readConverterExp = "0=男,1=女,2=未知")
    private String sex;

    /** 头像地址 */
    @Excel(name = "头像地址")
    private String avatar;

    /** 密码 */
    @Excel(name = "密码")
    private String password;

    /** 宗教类别 */
    @Excel(name = "宗教类别")
    private Long religionType;

    /** 宗教派别 */
    @Excel(name = "宗教派别")
    private Long religionSect;

    /** 具体地址 */
    @Excel(name = "具体地址")
    private String areaDetail;

    /** 所属区域 */
    @Excel(name = "所属区域")
    private Long areaId;

    /** 是否民族管理人 */
    @Excel(name = "是否民族管理人")
    private Long nationSubMain;

    /** 是否民族负责人 */
    @Excel(name = "是否民族负责人")
    private Long nationMain;

    /** 民族 */
    @Excel(name = "民族")
    private Long nationId;

    /** 职别 */
    @Excel(name = "职别")
    private Long position;

    /** 教育程度 */
    @Excel(name = "教育程度")
    private Long educ;

    /** 毕业院校 */
    @Excel(name = "毕业院校")
    private Long graduatedFrom;

    /** 是否团体管理班子 */
    @Excel(name = "是否团体管理班子")
    private Long teamSubMain;

    /** 是否团体负责人 */
    @Excel(name = "是否团体负责人")
    private Long teamMain;

    /** 团体 */
    @Excel(name = "团体")
    private Long teamId;

    /** 类型 */
    @Excel(name = "类型")
    private Long type;

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
    public void setEmail(String email) 
    {
        this.email = email;
    }

    public String getEmail() 
    {
        return email;
    }
    public void setPhonenumber(String phonenumber) 
    {
        this.phonenumber = phonenumber;
    }

    public String getPhonenumber() 
    {
        return phonenumber;
    }
    public void setSex(String sex) 
    {
        this.sex = sex;
    }

    public String getSex() 
    {
        return sex;
    }
    public void setAvatar(String avatar) 
    {
        this.avatar = avatar;
    }

    public String getAvatar() 
    {
        return avatar;
    }
    public void setPassword(String password) 
    {
        this.password = password;
    }

    public String getPassword() 
    {
        return password;
    }
    public void setReligionType(Long religionType) 
    {
        this.religionType = religionType;
    }

    public Long getReligionType() 
    {
        return religionType;
    }
    public void setReligionSect(Long religionSect) 
    {
        this.religionSect = religionSect;
    }

    public Long getReligionSect() 
    {
        return religionSect;
    }
    public void setAreaDetail(String areaDetail) 
    {
        this.areaDetail = areaDetail;
    }

    public String getAreaDetail() 
    {
        return areaDetail;
    }
    public void setAreaId(Long areaId) 
    {
        this.areaId = areaId;
    }

    public Long getAreaId() 
    {
        return areaId;
    }
    public void setNationSubMain(Long nationSubMain) 
    {
        this.nationSubMain = nationSubMain;
    }

    public Long getNationSubMain() 
    {
        return nationSubMain;
    }
    public void setNationMain(Long nationMain) 
    {
        this.nationMain = nationMain;
    }

    public Long getNationMain() 
    {
        return nationMain;
    }
    public void setNationId(Long nationId) 
    {
        this.nationId = nationId;
    }

    public Long getNationId() 
    {
        return nationId;
    }
    public void setPosition(Long position) 
    {
        this.position = position;
    }

    public Long getPosition() 
    {
        return position;
    }
    public void setEduc(Long educ) 
    {
        this.educ = educ;
    }

    public Long getEduc() 
    {
        return educ;
    }
    public void setGraduatedFrom(Long graduatedFrom) 
    {
        this.graduatedFrom = graduatedFrom;
    }

    public Long getGraduatedFrom() 
    {
        return graduatedFrom;
    }
    public void setTeamSubMain(Long teamSubMain) 
    {
        this.teamSubMain = teamSubMain;
    }

    public Long getTeamSubMain() 
    {
        return teamSubMain;
    }
    public void setTeamMain(Long teamMain) 
    {
        this.teamMain = teamMain;
    }

    public Long getTeamMain() 
    {
        return teamMain;
    }
    public void setTeamId(Long teamId) 
    {
        this.teamId = teamId;
    }

    public Long getTeamId() 
    {
        return teamId;
    }
    public void setType(Long type) 
    {
        this.type = type;
    }

    public Long getType() 
    {
        return type;
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
            .append("userName", getUserName())
            .append("nickName", getNickName())
            .append("email", getEmail())
            .append("phonenumber", getPhonenumber())
            .append("sex", getSex())
            .append("avatar", getAvatar())
            .append("password", getPassword())
            .append("religionType", getReligionType())
            .append("religionSect", getReligionSect())
            .append("areaDetail", getAreaDetail())
            .append("areaId", getAreaId())
            .append("nationSubMain", getNationSubMain())
            .append("nationMain", getNationMain())
            .append("nationId", getNationId())
            .append("position", getPosition())
            .append("educ", getEduc())
            .append("graduatedFrom", getGraduatedFrom())
            .append("teamSubMain", getTeamSubMain())
            .append("teamMain", getTeamMain())
            .append("teamId", getTeamId())
            .append("type", getType())
            .append("remark", getRemark())
            .toString();
    }
}

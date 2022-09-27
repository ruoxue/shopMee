package com.ruoyi.order.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.TreeEntity;

/**
 * 商户菜单权限对象 user_menu
 *
 * @author xiaoming
 * @date 2022-09-18
 */
public class UserMenu extends TreeEntity {
    private static final long serialVersionUID = 1L;
    private Integer tree;
    /**
     * 菜单ID
     */
    private Long menuId;

    /**
     * 菜单名称
     */
    @Excel(name = "菜单名称")
    private String menuName;

    /**
     * 路由地址
     */
    @Excel(name = "路由地址")
    private String path;

    /**
     * 组件路径
     */
    @Excel(name = "组件路径")
    private String component;

    /**
     * 路由参数
     */
    @Excel(name = "路由参数")
    private String query;

    /**
     * 是否为外链（0是 1否）
     */
    @Excel(name = "是否为外链", readConverterExp = "0=是,1=否")
    private Long isFrame;

    /**
     * 是否缓存（0缓存 1不缓存）
     */
    @Excel(name = "是否缓存", readConverterExp = "0=缓存,1=不缓存")
    private Long isCache;

    /**
     * 菜单类型（M目录 C菜单 F按钮）
     */
    @Excel(name = "菜单类型", readConverterExp = "M=目录,C=菜单,F=按钮")
    private String menuType;

    /**
     * 菜单状态（0显示 1隐藏）
     */
    @Excel(name = "菜单状态", readConverterExp = "0=显示,1=隐藏")
    private String visible;

    /**
     * 菜单状态（0正常 1停用）
     */
    @Excel(name = "菜单状态", readConverterExp = "0=正常,1=停用")
    private String status;

    /**
     * 权限标识
     */
    @Excel(name = "权限标识")
    private String perms;

    /**
     * 菜单图标
     */
    @Excel(name = "菜单图标")
    private String icon;

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public String getComponent() {
        return component;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }

    public void setIsFrame(Long isFrame) {
        this.isFrame = isFrame;
    }

    public Long getIsFrame() {
        return isFrame;
    }

    public void setIsCache(Long isCache) {
        this.isCache = isCache;
    }

    public Long getIsCache() {
        return isCache;
    }

    public void setMenuType(String menuType) {
        this.menuType = menuType;
    }

    public String getMenuType() {
        return menuType;
    }

    public void setVisible(String visible) {
        this.visible = visible;
    }

    public String getVisible() {
        return visible;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setPerms(String perms) {
        this.perms = perms;
    }

    public String getPerms() {
        return perms;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getIcon() {
        return icon;
    }

    public Integer getTree() {
        return tree;
    }

    public void setTree(Integer tree) {
        this.tree = tree;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("menuId", getMenuId())
                .append("menuName", getMenuName())
                .append("parentId", getParentId())
                .append("orderNum", getOrderNum())
                .append("path", getPath())
                .append("component", getComponent())
                .append("query", getQuery())
                .append("isFrame", getIsFrame())
                .append("isCache", getIsCache())
                .append("menuType", getMenuType())
                .append("visible", getVisible())
                .append("status", getStatus())
                .append("perms", getPerms())
                .append("icon", getIcon())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("remark", getRemark())
                .toString();
    }
}

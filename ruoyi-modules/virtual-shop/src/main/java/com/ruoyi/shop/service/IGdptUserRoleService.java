package com.ruoyi.shop.service;

import java.util.List;
import com.ruoyi.shop.domain.GdptUserRole;

/**
 * 用户角色Service接口
 * 
 * @author xiaoming
 * @date 2022-08-07
 */
public interface IGdptUserRoleService 
{
    /**
     * 查询用户角色
     * 
     * @param id 用户角色主键
     * @return 用户角色
     */
    public GdptUserRole selectGdptUserRoleById(String id);

    /**
     * 查询用户角色列表
     * 
     * @param gdptUserRole 用户角色
     * @return 用户角色集合
     */
    public List<GdptUserRole> selectGdptUserRoleList(GdptUserRole gdptUserRole);

    /**
     * 新增用户角色
     * 
     * @param gdptUserRole 用户角色
     * @return 结果
     */
    public int insertGdptUserRole(GdptUserRole gdptUserRole);

    /**
     * 修改用户角色
     * 
     * @param gdptUserRole 用户角色
     * @return 结果
     */
    public int updateGdptUserRole(GdptUserRole gdptUserRole);

    /**
     * 批量删除用户角色
     * 
     * @param ids 需要删除的用户角色主键集合
     * @return 结果
     */
    public int deleteGdptUserRoleByIds(String[] ids);

    /**
     * 删除用户角色信息
     * 
     * @param id 用户角色主键
     * @return 结果
     */
    public int deleteGdptUserRoleById(String id);
}

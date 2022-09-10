package com.ruoyi.shop.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.shop.mapper.GdptUserRoleMapper;
import com.ruoyi.shop.domain.GdptUserRole;
import com.ruoyi.shop.service.IGdptUserRoleService;

/**
 * 用户角色Service业务层处理
 * 
 * @author xiaoming
 * @date 2022-08-07
 */
@Service
public class GdptUserRoleServiceImpl implements IGdptUserRoleService 
{
    @Autowired
    private GdptUserRoleMapper gdptUserRoleMapper;

    /**
     * 查询用户角色
     * 
     * @param id 用户角色主键
     * @return 用户角色
     */
    @Override
    public GdptUserRole selectGdptUserRoleById(String id)
    {
        return gdptUserRoleMapper.selectGdptUserRoleById(id);
    }

    /**
     * 查询用户角色列表
     * 
     * @param gdptUserRole 用户角色
     * @return 用户角色
     */
    @Override
    public List<GdptUserRole> selectGdptUserRoleList(GdptUserRole gdptUserRole)
    {
        return gdptUserRoleMapper.selectGdptUserRoleList(gdptUserRole);
    }

    /**
     * 新增用户角色
     * 
     * @param gdptUserRole 用户角色
     * @return 结果
     */
    @Override
    public int insertGdptUserRole(GdptUserRole gdptUserRole)
    {
        return gdptUserRoleMapper.insertGdptUserRole(gdptUserRole);
    }

    /**
     * 修改用户角色
     * 
     * @param gdptUserRole 用户角色
     * @return 结果
     */
    @Override
    public int updateGdptUserRole(GdptUserRole gdptUserRole)
    {
        return gdptUserRoleMapper.updateGdptUserRole(gdptUserRole);
    }

    /**
     * 批量删除用户角色
     * 
     * @param ids 需要删除的用户角色主键
     * @return 结果
     */
    @Override
    public int deleteGdptUserRoleByIds(String[] ids)
    {
        return gdptUserRoleMapper.deleteGdptUserRoleByIds(ids);
    }

    /**
     * 删除用户角色信息
     * 
     * @param id 用户角色主键
     * @return 结果
     */
    @Override
    public int deleteGdptUserRoleById(String id)
    {
        return gdptUserRoleMapper.deleteGdptUserRoleById(id);
    }
}

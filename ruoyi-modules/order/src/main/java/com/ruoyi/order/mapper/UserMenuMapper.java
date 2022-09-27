package com.ruoyi.order.mapper;

import java.util.List;
import com.ruoyi.order.domain.UserMenu;

/**
 * 商户菜单权限Mapper接口
 * 
 * @author xiaoming
 * @date 2022-09-18
 */
public interface UserMenuMapper 
{
    /**
     * 查询商户菜单权限
     * 
     * @param menuId 商户菜单权限主键
     * @return 商户菜单权限
     */
    public UserMenu selectUserMenuByMenuId(Long menuId);

    /**
     * 查询商户菜单权限列表
     * 
     * @param userMenu 商户菜单权限
     * @return 商户菜单权限集合
     */
    public List<UserMenu> selectUserMenuList(UserMenu userMenu);

    /**
     * 新增商户菜单权限
     * 
     * @param userMenu 商户菜单权限
     * @return 结果
     */
    public int insertUserMenu(UserMenu userMenu);

    /**
     * 修改商户菜单权限
     * 
     * @param userMenu 商户菜单权限
     * @return 结果
     */
    public int updateUserMenu(UserMenu userMenu);

    /**
     * 删除商户菜单权限
     * 
     * @param menuId 商户菜单权限主键
     * @return 结果
     */
    public int deleteUserMenuByMenuId(Long menuId);

    /**
     * 批量删除商户菜单权限
     * 
     * @param menuIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteUserMenuByMenuIds(Long[] menuIds);
}

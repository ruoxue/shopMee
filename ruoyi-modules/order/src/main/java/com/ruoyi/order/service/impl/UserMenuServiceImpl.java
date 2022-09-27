package com.ruoyi.order.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.ruoyi.common.core.utils.DateUtils;
import com.ruoyi.shop.domain.ProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.order.mapper.UserMenuMapper;
import com.ruoyi.order.domain.UserMenu;
import com.ruoyi.order.service.IUserMenuService;

/**
 * 商户菜单权限Service业务层处理
 *
 * @author xiaoming
 * @date 2022-09-18
 */
@Service
public class UserMenuServiceImpl implements IUserMenuService {
    @Autowired
    private UserMenuMapper userMenuMapper;

    /**
     * 查询商户菜单权限
     *
     * @param menuId 商户菜单权限主键
     * @return 商户菜单权限
     */
    @Override
    public UserMenu selectUserMenuByMenuId(Long menuId) {
        return userMenuMapper.selectUserMenuByMenuId(menuId);
    }

    /**
     * 查询商户菜单权限列表
     *
     * @param userMenu 商户菜单权限
     * @return 商户菜单权限
     */
    @Override
    public List<UserMenu> selectUserMenuList(UserMenu userMenu) {


        if (userMenu.getTree() != null && userMenu.getTree() == 1) {
            Long parentId = userMenu.getParentId();
            userMenu.setParentId(null);
            List<UserMenu> productCategories = userMenuMapper.selectUserMenuList(userMenu);
            List<UserMenu> catalogueList = new ArrayList<>();
            catalogueList.addAll(productCategories.parallelStream().filter(v ->
                    Objects.equals(v.getParentId(), parentId)).collect(Collectors.toList()));
            for (UserMenu userMenu1 : productCategories) {
                buildChildren(userMenu1, productCategories);
            }
            return catalogueList;

        } else {
            return userMenuMapper.selectUserMenuList(userMenu);

        }


    }

    private UserMenu buildChildren(UserMenu rootNode, List<UserMenu> cList) {

            // 构建子树 层级不建议过大
            List<UserMenu> childrenTree = new ArrayList<>();
            for (UserMenu catalogue : cList) {
                Long pid = catalogue.getParentId();
                Long id = rootNode.getMenuId();
                if (pid.equals(id)&&id!=0) {
                    UserMenu o = buildChildren(catalogue, cList);
                    childrenTree.add(o);
                }
            }
            rootNode.setChildren(childrenTree);
            return rootNode;
        }


    /**
     * 新增商户菜单权限
     *
     * @param userMenu 商户菜单权限
     * @return 结果
     */
    @Override
    public int insertUserMenu(UserMenu userMenu) {
        userMenu.setCreateTime(DateUtils.getNowDate());
        return userMenuMapper.insertUserMenu(userMenu);
    }

    /**
     * 修改商户菜单权限
     *
     * @param userMenu 商户菜单权限
     * @return 结果
     */
    @Override
    public int updateUserMenu(UserMenu userMenu) {
        userMenu.setUpdateTime(DateUtils.getNowDate());
        return userMenuMapper.updateUserMenu(userMenu);
    }

    /**
     * 批量删除商户菜单权限
     *
     * @param menuIds 需要删除的商户菜单权限主键
     * @return 结果
     */
    @Override
    public int deleteUserMenuByMenuIds(Long[] menuIds) {
        return userMenuMapper.deleteUserMenuByMenuIds(menuIds);
    }

    /**
     * 删除商户菜单权限信息
     *
     * @param menuId 商户菜单权限主键
     * @return 结果
     */
    @Override
    public int deleteUserMenuByMenuId(Long menuId) {
        return userMenuMapper.deleteUserMenuByMenuId(menuId);
    }
}

package com.ruoyi.order.controller;

import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.security.annotation.RequiresLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.log.annotation.Log;
import com.ruoyi.common.log.enums.BusinessType;
import com.ruoyi.common.security.annotation.RequiresPermissions;
import com.ruoyi.order.domain.UserMenu;
import com.ruoyi.order.service.IUserMenuService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;

/**
 * 商户菜单权限Controller
 * 
 * @author xiaoming
 * @date 2022-09-18
 */
@RestController
@RequestMapping("/userMenu")
public class UserMenuController extends BaseController
{
    @Autowired
    private IUserMenuService userMenuService;

    /**
     * 查询商户菜单权限列表
     */
    @RequiresLogin
    @GetMapping("/list")
    public AjaxResult list(UserMenu userMenu)
    {
        List<UserMenu> list = userMenuService.selectUserMenuList(userMenu);
        return AjaxResult.success(list);
    }

    /**
     * 导出商户菜单权限列表
     */
    @RequiresPermissions("order:userMenu:export")
    @Log(title = "商户菜单权限", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, UserMenu userMenu)
    {
        List<UserMenu> list = userMenuService.selectUserMenuList(userMenu);
        ExcelUtil<UserMenu> util = new ExcelUtil<UserMenu>(UserMenu.class);
        util.exportExcel(response, list, "商户菜单权限数据");
    }

    /**
     * 获取商户菜单权限详细信息
     */
    @RequiresPermissions("order:userMenu:query")
    @GetMapping(value = "/{menuId}")
    public AjaxResult getInfo(@PathVariable("menuId") Long menuId)
    {
        return AjaxResult.success(userMenuService.selectUserMenuByMenuId(menuId));
    }

    /**
     * 新增商户菜单权限
     */
    @RequiresPermissions("order:userMenu:add")
    @Log(title = "商户菜单权限", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody UserMenu userMenu)
    {
        return toAjax(userMenuService.insertUserMenu(userMenu));
    }

    /**
     * 修改商户菜单权限
     */
    @RequiresPermissions("order:userMenu:edit")
    @Log(title = "商户菜单权限", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody UserMenu userMenu)
    {
        return toAjax(userMenuService.updateUserMenu(userMenu));
    }

    /**
     * 删除商户菜单权限
     */
    @RequiresPermissions("order:userMenu:remove")
    @Log(title = "商户菜单权限", businessType = BusinessType.DELETE)
	@DeleteMapping("/{menuIds}")
    public AjaxResult remove(@PathVariable Long[] menuIds)
    {
        return toAjax(userMenuService.deleteUserMenuByMenuIds(menuIds));
    }
}

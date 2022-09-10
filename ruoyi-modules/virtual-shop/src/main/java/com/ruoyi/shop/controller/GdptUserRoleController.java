package com.ruoyi.shop.controller;

import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
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
import com.ruoyi.shop.domain.GdptUserRole;
import com.ruoyi.shop.service.IGdptUserRoleService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 用户角色Controller
 * 
 * @author xiaoming
 * @date 2022-08-07
 */
@RestController
@RequestMapping("/gdptUserRole")
public class GdptUserRoleController extends BaseController
{
    @Autowired
    private IGdptUserRoleService gdptUserRoleService;

    /**
     * 查询用户角色列表
     */
    @RequiresPermissions("shop:gdptUserRole:list")
    @GetMapping("/list")
    public TableDataInfo list(GdptUserRole gdptUserRole)
    {
        startPage();
        List<GdptUserRole> list = gdptUserRoleService.selectGdptUserRoleList(gdptUserRole);
        return getDataTable(list);
    }

    /**
     * 导出用户角色列表
     */
    @RequiresPermissions("shop:gdptUserRole:export")
    @Log(title = "用户角色", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, GdptUserRole gdptUserRole)
    {
        List<GdptUserRole> list = gdptUserRoleService.selectGdptUserRoleList(gdptUserRole);
        ExcelUtil<GdptUserRole> util = new ExcelUtil<GdptUserRole>(GdptUserRole.class);
        util.exportExcel(response, list, "用户角色数据");
    }

    /**
     * 获取用户角色详细信息
     */
    @RequiresPermissions("shop:gdptUserRole:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return AjaxResult.success(gdptUserRoleService.selectGdptUserRoleById(id));
    }

    /**
     * 新增用户角色
     */
    @RequiresPermissions("shop:gdptUserRole:add")
    @Log(title = "用户角色", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody GdptUserRole gdptUserRole)
    {
        return toAjax(gdptUserRoleService.insertGdptUserRole(gdptUserRole));
    }

    /**
     * 修改用户角色
     */
    @RequiresPermissions("shop:gdptUserRole:edit")
    @Log(title = "用户角色", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody GdptUserRole gdptUserRole)
    {
        return toAjax(gdptUserRoleService.updateGdptUserRole(gdptUserRole));
    }

    /**
     * 删除用户角色
     */
    @RequiresPermissions("shop:gdptUserRole:remove")
    @Log(title = "用户角色", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(gdptUserRoleService.deleteGdptUserRoleByIds(ids));
    }
}

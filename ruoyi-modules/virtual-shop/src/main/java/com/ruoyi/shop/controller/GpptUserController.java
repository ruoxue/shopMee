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
import com.ruoyi.shop.domain.GpptUser;
import com.ruoyi.shop.service.IGpptUserService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 用户Controller
 * 
 * @author xiaoming
 * @date 2022-08-07
 */
@RestController
@RequestMapping("/gpptUser")
public class GpptUserController extends BaseController
{
    @Autowired
    private IGpptUserService gpptUserService;

    /**
     * 查询用户列表
     */
    @RequiresPermissions("shop:gpptUser:list")
    @GetMapping("/list")
    public TableDataInfo list(GpptUser gpptUser)
    {
        startPage();
        List<GpptUser> list = gpptUserService.selectGpptUserList(gpptUser);
        return getDataTable(list);
    }

    /**
     * 导出用户列表
     */
    @RequiresPermissions("shop:gpptUser:export")
    @Log(title = "用户", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, GpptUser gpptUser)
    {
        List<GpptUser> list = gpptUserService.selectGpptUserList(gpptUser);
        ExcelUtil<GpptUser> util = new ExcelUtil<GpptUser>(GpptUser.class);
        util.exportExcel(response, list, "用户数据");
    }

    /**
     * 获取用户详细信息
     */
    @RequiresPermissions("shop:gpptUser:query")
    @GetMapping(value = "/{userId}")
    public AjaxResult getInfo(@PathVariable("userId") String userId)
    {
        return AjaxResult.success(gpptUserService.selectGpptUserByUserId(userId));
    }

    /**
     * 新增用户
     */
    @RequiresPermissions("shop:gpptUser:add")
    @Log(title = "用户", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody GpptUser gpptUser)
    {
        return toAjax(gpptUserService.insertGpptUser(gpptUser));
    }

    /**
     * 修改用户
     */
    @RequiresPermissions("shop:gpptUser:edit")
    @Log(title = "用户", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody GpptUser gpptUser)
    {
        return toAjax(gpptUserService.updateGpptUser(gpptUser));
    }

    /**
     * 删除用户
     */
    @RequiresPermissions("shop:gpptUser:remove")
    @Log(title = "用户", businessType = BusinessType.DELETE)
	@DeleteMapping("/{userIds}")
    public AjaxResult remove(@PathVariable String[] userIds)
    {
        return toAjax(gpptUserService.deleteGpptUserByUserIds(userIds));
    }
}

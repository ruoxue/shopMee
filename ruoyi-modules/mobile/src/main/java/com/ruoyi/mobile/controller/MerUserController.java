package com.ruoyi.mobile.controller;

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
import com.ruoyi.mobile.domain.MerUser;
import com.ruoyi.mobile.service.IMerUserService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 商户Controller
 * 
 * @author xiaoming
 * @date 2022-08-08
 */
@RestController
@RequestMapping("/merUser")
public class MerUserController extends BaseController
{
    @Autowired
    private IMerUserService merUserService;

    /**
     * 查询商户列表
     */
    @RequiresPermissions("mobile:merUser:list")
    @GetMapping("/list")
    public TableDataInfo list(MerUser merUser)
    {
        startPage();
        List<MerUser> list = merUserService.selectMerUserList(merUser);
        return getDataTable(list);
    }

    /**
     * 导出商户列表
     */
    @RequiresPermissions("mobile:merUser:export")
    @Log(title = "商户", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MerUser merUser)
    {
        List<MerUser> list = merUserService.selectMerUserList(merUser);
        ExcelUtil<MerUser> util = new ExcelUtil<MerUser>(MerUser.class);
        util.exportExcel(response, list, "商户数据");
    }

    /**
     * 获取商户详细信息
     */
    @RequiresPermissions("mobile:merUser:query")
    @GetMapping(value = "/{merId}")
    public AjaxResult getInfo(@PathVariable("merId") Long merId)
    {
        return AjaxResult.success(merUserService.selectMerUserByMerId(merId));
    }

    /**
     * 新增商户
     */
    @RequiresPermissions("mobile:merUser:add")
    @Log(title = "商户", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MerUser merUser)
    {
        return toAjax(merUserService.insertMerUser(merUser));
    }

    /**
     * 修改商户
     */
    @RequiresPermissions("mobile:merUser:edit")
    @Log(title = "商户", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MerUser merUser)
    {
        return toAjax(merUserService.updateMerUser(merUser));
    }

    /**
     * 删除商户
     */
    @RequiresPermissions("mobile:merUser:remove")
    @Log(title = "商户", businessType = BusinessType.DELETE)
	@DeleteMapping("/{merIds}")
    public AjaxResult remove(@PathVariable Long[] merIds)
    {
        return toAjax(merUserService.deleteMerUserByMerIds(merIds));
    }
}

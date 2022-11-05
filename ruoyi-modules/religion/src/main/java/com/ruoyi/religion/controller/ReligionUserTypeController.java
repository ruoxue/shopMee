package com.ruoyi.religion.controller;

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
import com.ruoyi.religion.domain.ReligionUserType;
import com.ruoyi.religion.service.IReligionUserTypeService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 用户类型Controller
 * 
 * @author xiaoming
 * @date 2022-10-22 02:57:31
 */
@RestController
@RequestMapping("/religionUserType")
public class ReligionUserTypeController extends BaseController
{
    @Autowired
    private IReligionUserTypeService religionUserTypeService;

    /**
     * 查询用户类型列表
     */
    @RequiresPermissions("religion:religionUserType:list")
    @GetMapping("/list")
    public TableDataInfo list(ReligionUserType religionUserType)
    {
        startPage();
        List<ReligionUserType> list = religionUserTypeService.selectReligionUserTypeList(religionUserType);
        return getDataTable(list);
    }

    /**
     * 导出用户类型列表
     */
    @RequiresPermissions("religion:religionUserType:export")
    @Log(title = "用户类型", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ReligionUserType religionUserType)
    {
        List<ReligionUserType> list = religionUserTypeService.selectReligionUserTypeList(religionUserType);
        ExcelUtil<ReligionUserType> util = new ExcelUtil<ReligionUserType>(ReligionUserType.class);
        util.exportExcel(response, list, "用户类型数据");
    }

    /**
     * 获取用户类型详细信息
     */
    @RequiresPermissions("religion:religionUserType:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(religionUserTypeService.selectReligionUserTypeById(id));
    }

    /**
     * 新增用户类型
     */
    @RequiresPermissions("religion:religionUserType:add")
    @Log(title = "用户类型", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ReligionUserType religionUserType)
    {
        return toAjax(religionUserTypeService.insertReligionUserType(religionUserType));
    }

    /**
     * 修改用户类型
     */
    @RequiresPermissions("religion:religionUserType:edit")
    @Log(title = "用户类型", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ReligionUserType religionUserType)
    {
        return toAjax(religionUserTypeService.updateReligionUserType(religionUserType));
    }

    /**
     * 删除用户类型
     */
    @RequiresPermissions("religion:religionUserType:remove")
    @Log(title = "用户类型", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(religionUserTypeService.deleteReligionUserTypeByIds(ids));
    }
}

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
import com.ruoyi.religion.domain.ReligionEmergencyType;
import com.ruoyi.religion.service.IReligionEmergencyTypeService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 场所突发应急管理Controller
 * 
 * @author xiaoming
 * @date 2022-10-22 09:17:31
 */
@RestController
@RequestMapping("/religionEmergencyType")
public class ReligionEmergencyTypeController extends BaseController
{
    @Autowired
    private IReligionEmergencyTypeService religionEmergencyTypeService;

    /**
     * 查询场所突发应急管理列表
     */
    @RequiresPermissions("religion:religionEmergencyType:list")
    @GetMapping("/list")
    public TableDataInfo list(ReligionEmergencyType religionEmergencyType)
    {
        startPage();
        List<ReligionEmergencyType> list = religionEmergencyTypeService.selectReligionEmergencyTypeList(religionEmergencyType);
        return getDataTable(list);
    }

    /**
     * 导出场所突发应急管理列表
     */
    @RequiresPermissions("religion:religionEmergencyType:export")
    @Log(title = "场所突发应急管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ReligionEmergencyType religionEmergencyType)
    {
        List<ReligionEmergencyType> list = religionEmergencyTypeService.selectReligionEmergencyTypeList(religionEmergencyType);
        ExcelUtil<ReligionEmergencyType> util = new ExcelUtil<ReligionEmergencyType>(ReligionEmergencyType.class);
        util.exportExcel(response, list, "场所突发应急管理数据");
    }

    /**
     * 获取场所突发应急管理详细信息
     */
    @RequiresPermissions("religion:religionEmergencyType:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(religionEmergencyTypeService.selectReligionEmergencyTypeById(id));
    }

    /**
     * 新增场所突发应急管理
     */
    @RequiresPermissions("religion:religionEmergencyType:add")
    @Log(title = "场所突发应急管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ReligionEmergencyType religionEmergencyType)
    {
        return toAjax(religionEmergencyTypeService.insertReligionEmergencyType(religionEmergencyType));
    }

    /**
     * 修改场所突发应急管理
     */
    @RequiresPermissions("religion:religionEmergencyType:edit")
    @Log(title = "场所突发应急管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ReligionEmergencyType religionEmergencyType)
    {
        return toAjax(religionEmergencyTypeService.updateReligionEmergencyType(religionEmergencyType));
    }

    /**
     * 删除场所突发应急管理
     */
    @RequiresPermissions("religion:religionEmergencyType:remove")
    @Log(title = "场所突发应急管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(religionEmergencyTypeService.deleteReligionEmergencyTypeByIds(ids));
    }
}

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
import com.ruoyi.religion.domain.ReligionDynamicInfo;
import com.ruoyi.religion.service.IReligionDynamicInfoService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 动态信息Controller
 * 
 * @author xiaoming
 * @date 2022-10-22 09:17:31
 */
@RestController
@RequestMapping("/religionDynamicInfo")
public class ReligionDynamicInfoController extends BaseController
{
    @Autowired
    private IReligionDynamicInfoService religionDynamicInfoService;

    /**
     * 查询动态信息列表
     */
    @RequiresPermissions("religion:religionDynamicInfo:list")
    @GetMapping("/list")
    public TableDataInfo list(ReligionDynamicInfo religionDynamicInfo)
    {
        startPage();
        List<ReligionDynamicInfo> list = religionDynamicInfoService.selectReligionDynamicInfoList(religionDynamicInfo);
        return getDataTable(list);
    }

    /**
     * 导出动态信息列表
     */
    @RequiresPermissions("religion:religionDynamicInfo:export")
    @Log(title = "动态信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ReligionDynamicInfo religionDynamicInfo)
    {
        List<ReligionDynamicInfo> list = religionDynamicInfoService.selectReligionDynamicInfoList(religionDynamicInfo);
        ExcelUtil<ReligionDynamicInfo> util = new ExcelUtil<ReligionDynamicInfo>(ReligionDynamicInfo.class);
        util.exportExcel(response, list, "动态信息数据");
    }

    /**
     * 获取动态信息详细信息
     */
    @RequiresPermissions("religion:religionDynamicInfo:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(religionDynamicInfoService.selectReligionDynamicInfoById(id));
    }

    /**
     * 新增动态信息
     */
    @RequiresPermissions("religion:religionDynamicInfo:add")
    @Log(title = "动态信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ReligionDynamicInfo religionDynamicInfo)
    {
        return toAjax(religionDynamicInfoService.insertReligionDynamicInfo(religionDynamicInfo));
    }

    /**
     * 修改动态信息
     */
    @RequiresPermissions("religion:religionDynamicInfo:edit")
    @Log(title = "动态信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ReligionDynamicInfo religionDynamicInfo)
    {
        return toAjax(religionDynamicInfoService.updateReligionDynamicInfo(religionDynamicInfo));
    }

    /**
     * 删除动态信息
     */
    @RequiresPermissions("religion:religionDynamicInfo:remove")
    @Log(title = "动态信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(religionDynamicInfoService.deleteReligionDynamicInfoByIds(ids));
    }
}

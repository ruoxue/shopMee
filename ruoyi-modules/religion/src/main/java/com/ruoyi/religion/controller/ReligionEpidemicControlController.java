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
import com.ruoyi.religion.domain.ReligionEpidemicControl;
import com.ruoyi.religion.service.IReligionEpidemicControlService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 疫情防控检查Controller
 * 
 * @author xiaoming
 * @date 2022-10-22 09:17:31
 */
@RestController
@RequestMapping("/religionEpidemicControl")
public class ReligionEpidemicControlController extends BaseController
{
    @Autowired
    private IReligionEpidemicControlService religionEpidemicControlService;

    /**
     * 查询疫情防控检查列表
     */
    @RequiresPermissions("religion:religionEpidemicControl:list")
    @GetMapping("/list")
    public TableDataInfo list(ReligionEpidemicControl religionEpidemicControl)
    {
        startPage();
        List<ReligionEpidemicControl> list = religionEpidemicControlService.selectReligionEpidemicControlList(religionEpidemicControl);
        return getDataTable(list);
    }

    /**
     * 导出疫情防控检查列表
     */
    @RequiresPermissions("religion:religionEpidemicControl:export")
    @Log(title = "疫情防控检查", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ReligionEpidemicControl religionEpidemicControl)
    {
        List<ReligionEpidemicControl> list = religionEpidemicControlService.selectReligionEpidemicControlList(religionEpidemicControl);
        ExcelUtil<ReligionEpidemicControl> util = new ExcelUtil<ReligionEpidemicControl>(ReligionEpidemicControl.class);
        util.exportExcel(response, list, "疫情防控检查数据");
    }

    /**
     * 获取疫情防控检查详细信息
     */
    @RequiresPermissions("religion:religionEpidemicControl:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(religionEpidemicControlService.selectReligionEpidemicControlById(id));
    }

    /**
     * 新增疫情防控检查
     */
    @RequiresPermissions("religion:religionEpidemicControl:add")
    @Log(title = "疫情防控检查", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ReligionEpidemicControl religionEpidemicControl)
    {
        return toAjax(religionEpidemicControlService.insertReligionEpidemicControl(religionEpidemicControl));
    }

    /**
     * 修改疫情防控检查
     */
    @RequiresPermissions("religion:religionEpidemicControl:edit")
    @Log(title = "疫情防控检查", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ReligionEpidemicControl religionEpidemicControl)
    {
        return toAjax(religionEpidemicControlService.updateReligionEpidemicControl(religionEpidemicControl));
    }

    /**
     * 删除疫情防控检查
     */
    @RequiresPermissions("religion:religionEpidemicControl:remove")
    @Log(title = "疫情防控检查", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(religionEpidemicControlService.deleteReligionEpidemicControlByIds(ids));
    }
}

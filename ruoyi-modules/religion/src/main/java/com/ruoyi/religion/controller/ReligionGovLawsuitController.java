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
import com.ruoyi.religion.domain.ReligionGovLawsuit;
import com.ruoyi.religion.service.IReligionGovLawsuitService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 行政诉讼登记Controller
 * 
 * @author xiaoming
 * @date 2022-10-22 09:17:32
 */
@RestController
@RequestMapping("/religionGovLawsuit")
public class ReligionGovLawsuitController extends BaseController
{
    @Autowired
    private IReligionGovLawsuitService religionGovLawsuitService;

    /**
     * 查询行政诉讼登记列表
     */
    @RequiresPermissions("religion:religionGovLawsuit:list")
    @GetMapping("/list")
    public TableDataInfo list(ReligionGovLawsuit religionGovLawsuit)
    {
        startPage();
        List<ReligionGovLawsuit> list = religionGovLawsuitService.selectReligionGovLawsuitList(religionGovLawsuit);
        return getDataTable(list);
    }

    /**
     * 导出行政诉讼登记列表
     */
    @RequiresPermissions("religion:religionGovLawsuit:export")
    @Log(title = "行政诉讼登记", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ReligionGovLawsuit religionGovLawsuit)
    {
        List<ReligionGovLawsuit> list = religionGovLawsuitService.selectReligionGovLawsuitList(religionGovLawsuit);
        ExcelUtil<ReligionGovLawsuit> util = new ExcelUtil<ReligionGovLawsuit>(ReligionGovLawsuit.class);
        util.exportExcel(response, list, "行政诉讼登记数据");
    }

    /**
     * 获取行政诉讼登记详细信息
     */
    @RequiresPermissions("religion:religionGovLawsuit:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(religionGovLawsuitService.selectReligionGovLawsuitById(id));
    }

    /**
     * 新增行政诉讼登记
     */
    @RequiresPermissions("religion:religionGovLawsuit:add")
    @Log(title = "行政诉讼登记", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ReligionGovLawsuit religionGovLawsuit)
    {
        return toAjax(religionGovLawsuitService.insertReligionGovLawsuit(religionGovLawsuit));
    }

    /**
     * 修改行政诉讼登记
     */
    @RequiresPermissions("religion:religionGovLawsuit:edit")
    @Log(title = "行政诉讼登记", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ReligionGovLawsuit religionGovLawsuit)
    {
        return toAjax(religionGovLawsuitService.updateReligionGovLawsuit(religionGovLawsuit));
    }

    /**
     * 删除行政诉讼登记
     */
    @RequiresPermissions("religion:religionGovLawsuit:remove")
    @Log(title = "行政诉讼登记", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(religionGovLawsuitService.deleteReligionGovLawsuitByIds(ids));
    }
}

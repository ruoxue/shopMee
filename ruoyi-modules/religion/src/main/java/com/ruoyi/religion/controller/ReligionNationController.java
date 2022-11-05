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
import com.ruoyi.religion.domain.ReligionNation;
import com.ruoyi.religion.service.IReligionNationService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 民族Controller
 * 
 * @author xiaoming
 * @date 2022-10-22 09:17:32
 */
@RestController
@RequestMapping("/religionNation")
public class ReligionNationController extends BaseController
{
    @Autowired
    private IReligionNationService religionNationService;

    /**
     * 查询民族列表
     */
    @RequiresPermissions("religion:religionNation:list")
    @GetMapping("/list")
    public TableDataInfo list(ReligionNation religionNation)
    {
        startPage();
        List<ReligionNation> list = religionNationService.selectReligionNationList(religionNation);
        return getDataTable(list);
    }

    /**
     * 导出民族列表
     */
    @RequiresPermissions("religion:religionNation:export")
    @Log(title = "民族", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ReligionNation religionNation)
    {
        List<ReligionNation> list = religionNationService.selectReligionNationList(religionNation);
        ExcelUtil<ReligionNation> util = new ExcelUtil<ReligionNation>(ReligionNation.class);
        util.exportExcel(response, list, "民族数据");
    }

    /**
     * 获取民族详细信息
     */
    @RequiresPermissions("religion:religionNation:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(religionNationService.selectReligionNationById(id));
    }

    /**
     * 新增民族
     */
    @RequiresPermissions("religion:religionNation:add")
    @Log(title = "民族", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ReligionNation religionNation)
    {
        return toAjax(religionNationService.insertReligionNation(religionNation));
    }

    /**
     * 修改民族
     */
    @RequiresPermissions("religion:religionNation:edit")
    @Log(title = "民族", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ReligionNation religionNation)
    {
        return toAjax(religionNationService.updateReligionNation(religionNation));
    }

    /**
     * 删除民族
     */
    @RequiresPermissions("religion:religionNation:remove")
    @Log(title = "民族", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(religionNationService.deleteReligionNationByIds(ids));
    }
}

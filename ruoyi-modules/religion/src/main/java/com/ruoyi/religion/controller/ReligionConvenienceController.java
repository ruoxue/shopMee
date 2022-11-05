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
import com.ruoyi.religion.domain.ReligionConvenience;
import com.ruoyi.religion.service.IReligionConvenienceService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 便民服务Controller
 * 
 * @author xiaoming
 * @date 2022-10-22 09:17:31
 */
@RestController
@RequestMapping("/religionConvenience")
public class ReligionConvenienceController extends BaseController
{
    @Autowired
    private IReligionConvenienceService religionConvenienceService;

    /**
     * 查询便民服务列表
     */
    @RequiresPermissions("religion:religionConvenience:list")
    @GetMapping("/list")
    public TableDataInfo list(ReligionConvenience religionConvenience)
    {
        startPage();
        List<ReligionConvenience> list = religionConvenienceService.selectReligionConvenienceList(religionConvenience);
        return getDataTable(list);
    }

    /**
     * 导出便民服务列表
     */
    @RequiresPermissions("religion:religionConvenience:export")
    @Log(title = "便民服务", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ReligionConvenience religionConvenience)
    {
        List<ReligionConvenience> list = religionConvenienceService.selectReligionConvenienceList(religionConvenience);
        ExcelUtil<ReligionConvenience> util = new ExcelUtil<ReligionConvenience>(ReligionConvenience.class);
        util.exportExcel(response, list, "便民服务数据");
    }

    /**
     * 获取便民服务详细信息
     */
    @RequiresPermissions("religion:religionConvenience:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(religionConvenienceService.selectReligionConvenienceById(id));
    }

    /**
     * 新增便民服务
     */
    @RequiresPermissions("religion:religionConvenience:add")
    @Log(title = "便民服务", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ReligionConvenience religionConvenience)
    {
        return toAjax(religionConvenienceService.insertReligionConvenience(religionConvenience));
    }

    /**
     * 修改便民服务
     */
    @RequiresPermissions("religion:religionConvenience:edit")
    @Log(title = "便民服务", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ReligionConvenience religionConvenience)
    {
        return toAjax(religionConvenienceService.updateReligionConvenience(religionConvenience));
    }

    /**
     * 删除便民服务
     */
    @RequiresPermissions("religion:religionConvenience:remove")
    @Log(title = "便民服务", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(religionConvenienceService.deleteReligionConvenienceByIds(ids));
    }
}

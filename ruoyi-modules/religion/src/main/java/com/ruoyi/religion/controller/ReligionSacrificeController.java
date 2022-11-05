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
import com.ruoyi.religion.domain.ReligionSacrifice;
import com.ruoyi.religion.service.IReligionSacrificeService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 民间烧香点Controller
 * 
 * @author xiaoming
 * @date 2022-10-22 09:17:32
 */
@RestController
@RequestMapping("/religionSacrifice")
public class ReligionSacrificeController extends BaseController
{
    @Autowired
    private IReligionSacrificeService religionSacrificeService;

    /**
     * 查询民间烧香点列表
     */
    @RequiresPermissions("religion:religionSacrifice:list")
    @GetMapping("/list")
    public TableDataInfo list(ReligionSacrifice religionSacrifice)
    {
        startPage();
        List<ReligionSacrifice> list = religionSacrificeService.selectReligionSacrificeList(religionSacrifice);
        return getDataTable(list);
    }

    /**
     * 导出民间烧香点列表
     */
    @RequiresPermissions("religion:religionSacrifice:export")
    @Log(title = "民间烧香点", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ReligionSacrifice religionSacrifice)
    {
        List<ReligionSacrifice> list = religionSacrificeService.selectReligionSacrificeList(religionSacrifice);
        ExcelUtil<ReligionSacrifice> util = new ExcelUtil<ReligionSacrifice>(ReligionSacrifice.class);
        util.exportExcel(response, list, "民间烧香点数据");
    }

    /**
     * 获取民间烧香点详细信息
     */
    @RequiresPermissions("religion:religionSacrifice:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(religionSacrificeService.selectReligionSacrificeById(id));
    }

    /**
     * 新增民间烧香点
     */
    @RequiresPermissions("religion:religionSacrifice:add")
    @Log(title = "民间烧香点", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ReligionSacrifice religionSacrifice)
    {
        return toAjax(religionSacrificeService.insertReligionSacrifice(religionSacrifice));
    }

    /**
     * 修改民间烧香点
     */
    @RequiresPermissions("religion:religionSacrifice:edit")
    @Log(title = "民间烧香点", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ReligionSacrifice religionSacrifice)
    {
        return toAjax(religionSacrificeService.updateReligionSacrifice(religionSacrifice));
    }

    /**
     * 删除民间烧香点
     */
    @RequiresPermissions("religion:religionSacrifice:remove")
    @Log(title = "民间烧香点", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(religionSacrificeService.deleteReligionSacrificeByIds(ids));
    }
}

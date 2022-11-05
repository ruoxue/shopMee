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
import com.ruoyi.religion.domain.ReligionNationBuild;
import com.ruoyi.religion.service.IReligionNationBuildService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 民族团结进步创建Controller
 * 
 * @author xiaoming
 * @date 2022-10-22 09:17:32
 */
@RestController
@RequestMapping("/religionNationBuild")
public class ReligionNationBuildController extends BaseController
{
    @Autowired
    private IReligionNationBuildService religionNationBuildService;

    /**
     * 查询民族团结进步创建列表
     */
    @RequiresPermissions("religion:religionNationBuild:list")
    @GetMapping("/list")
    public TableDataInfo list(ReligionNationBuild religionNationBuild)
    {
        startPage();
        List<ReligionNationBuild> list = religionNationBuildService.selectReligionNationBuildList(religionNationBuild);
        return getDataTable(list);
    }

    /**
     * 导出民族团结进步创建列表
     */
    @RequiresPermissions("religion:religionNationBuild:export")
    @Log(title = "民族团结进步创建", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ReligionNationBuild religionNationBuild)
    {
        List<ReligionNationBuild> list = religionNationBuildService.selectReligionNationBuildList(religionNationBuild);
        ExcelUtil<ReligionNationBuild> util = new ExcelUtil<ReligionNationBuild>(ReligionNationBuild.class);
        util.exportExcel(response, list, "民族团结进步创建数据");
    }

    /**
     * 获取民族团结进步创建详细信息
     */
    @RequiresPermissions("religion:religionNationBuild:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(religionNationBuildService.selectReligionNationBuildById(id));
    }

    /**
     * 新增民族团结进步创建
     */
    @RequiresPermissions("religion:religionNationBuild:add")
    @Log(title = "民族团结进步创建", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ReligionNationBuild religionNationBuild)
    {
        return toAjax(religionNationBuildService.insertReligionNationBuild(religionNationBuild));
    }

    /**
     * 修改民族团结进步创建
     */
    @RequiresPermissions("religion:religionNationBuild:edit")
    @Log(title = "民族团结进步创建", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ReligionNationBuild religionNationBuild)
    {
        return toAjax(religionNationBuildService.updateReligionNationBuild(religionNationBuild));
    }

    /**
     * 删除民族团结进步创建
     */
    @RequiresPermissions("religion:religionNationBuild:remove")
    @Log(title = "民族团结进步创建", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(religionNationBuildService.deleteReligionNationBuildByIds(ids));
    }
}

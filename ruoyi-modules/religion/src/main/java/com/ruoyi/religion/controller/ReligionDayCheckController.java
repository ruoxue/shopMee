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
import com.ruoyi.religion.domain.ReligionDayCheck;
import com.ruoyi.religion.service.IReligionDayCheckService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 日常检查Controller
 * 
 * @author xiaoming
 * @date 2022-10-22 23:25:24
 */
@RestController
@RequestMapping("/religionDayCheck")
public class ReligionDayCheckController extends BaseController
{
    @Autowired
    private IReligionDayCheckService religionDayCheckService;

    /**
     * 查询日常检查列表
     */
    @RequiresPermissions("religion:religionDayCheck:list")
    @GetMapping("/list")
    public TableDataInfo list(ReligionDayCheck religionDayCheck)
    {
        startPage();
        List<ReligionDayCheck> list = religionDayCheckService.selectReligionDayCheckList(religionDayCheck);
        return getDataTable(list);
    }

    /**
     * 导出日常检查列表
     */
    @RequiresPermissions("religion:religionDayCheck:export")
    @Log(title = "日常检查", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ReligionDayCheck religionDayCheck)
    {
        List<ReligionDayCheck> list = religionDayCheckService.selectReligionDayCheckList(religionDayCheck);
        ExcelUtil<ReligionDayCheck> util = new ExcelUtil<ReligionDayCheck>(ReligionDayCheck.class);
        util.exportExcel(response, list, "日常检查数据");
    }

    /**
     * 获取日常检查详细信息
     */
    @RequiresPermissions("religion:religionDayCheck:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(religionDayCheckService.selectReligionDayCheckById(id));
    }

    /**
     * 新增日常检查
     */
    @RequiresPermissions("religion:religionDayCheck:add")
    @Log(title = "日常检查", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ReligionDayCheck religionDayCheck)
    {
        return toAjax(religionDayCheckService.insertReligionDayCheck(religionDayCheck));
    }

    /**
     * 修改日常检查
     */
    @RequiresPermissions("religion:religionDayCheck:edit")
    @Log(title = "日常检查", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ReligionDayCheck religionDayCheck)
    {
        return toAjax(religionDayCheckService.updateReligionDayCheck(religionDayCheck));
    }

    /**
     * 删除日常检查
     */
    @RequiresPermissions("religion:religionDayCheck:remove")
    @Log(title = "日常检查", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(religionDayCheckService.deleteReligionDayCheckByIds(ids));
    }
}

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
import com.ruoyi.religion.domain.ReligionFinance;
import com.ruoyi.religion.service.IReligionFinanceService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 财务数据Controller
 * 
 * @author xiaoming
 * @date 2022-10-22 09:17:31
 */
@RestController
@RequestMapping("/religionFinance")
public class ReligionFinanceController extends BaseController
{
    @Autowired
    private IReligionFinanceService religionFinanceService;

    /**
     * 查询财务数据列表
     */
    @RequiresPermissions("religion:religionFinance:list")
    @GetMapping("/list")
    public TableDataInfo list(ReligionFinance religionFinance)
    {
        startPage();
        List<ReligionFinance> list = religionFinanceService.selectReligionFinanceList(religionFinance);
        return getDataTable(list);
    }

    /**
     * 导出财务数据列表
     */
    @RequiresPermissions("religion:religionFinance:export")
    @Log(title = "财务数据", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ReligionFinance religionFinance)
    {
        List<ReligionFinance> list = religionFinanceService.selectReligionFinanceList(religionFinance);
        ExcelUtil<ReligionFinance> util = new ExcelUtil<ReligionFinance>(ReligionFinance.class);
        util.exportExcel(response, list, "财务数据数据");
    }

    /**
     * 获取财务数据详细信息
     */
    @RequiresPermissions("religion:religionFinance:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(religionFinanceService.selectReligionFinanceById(id));
    }

    /**
     * 新增财务数据
     */
    @RequiresPermissions("religion:religionFinance:add")
    @Log(title = "财务数据", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ReligionFinance religionFinance)
    {
        return toAjax(religionFinanceService.insertReligionFinance(religionFinance));
    }

    /**
     * 修改财务数据
     */
    @RequiresPermissions("religion:religionFinance:edit")
    @Log(title = "财务数据", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ReligionFinance religionFinance)
    {
        return toAjax(religionFinanceService.updateReligionFinance(religionFinance));
    }

    /**
     * 删除财务数据
     */
    @RequiresPermissions("religion:religionFinance:remove")
    @Log(title = "财务数据", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(religionFinanceService.deleteReligionFinanceByIds(ids));
    }
}

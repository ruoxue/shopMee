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
import com.ruoyi.religion.domain.ReligionWork;
import com.ruoyi.religion.service.IReligionWorkService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 工单Controller
 * 
 * @author xiaoming
 * @date 2022-10-22 09:17:33
 */
@RestController
@RequestMapping("/religionWork")
public class ReligionWorkController extends BaseController
{
    @Autowired
    private IReligionWorkService religionWorkService;

    /**
     * 查询工单列表
     */
    @RequiresPermissions("religion:religionWork:list")
    @GetMapping("/list")
    public TableDataInfo list(ReligionWork religionWork)
    {
        startPage();
        List<ReligionWork> list = religionWorkService.selectReligionWorkList(religionWork);
        return getDataTable(list);
    }

    /**
     * 导出工单列表
     */
    @RequiresPermissions("religion:religionWork:export")
    @Log(title = "工单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ReligionWork religionWork)
    {
        List<ReligionWork> list = religionWorkService.selectReligionWorkList(religionWork);
        ExcelUtil<ReligionWork> util = new ExcelUtil<ReligionWork>(ReligionWork.class);
        util.exportExcel(response, list, "工单数据");
    }

    /**
     * 获取工单详细信息
     */
    @RequiresPermissions("religion:religionWork:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(religionWorkService.selectReligionWorkById(id));
    }

    /**
     * 新增工单
     */
    @RequiresPermissions("religion:religionWork:add")
    @Log(title = "工单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ReligionWork religionWork)
    {
        return toAjax(religionWorkService.insertReligionWork(religionWork));
    }

    /**
     * 修改工单
     */
    @RequiresPermissions("religion:religionWork:edit")
    @Log(title = "工单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ReligionWork religionWork)
    {
        return toAjax(religionWorkService.updateReligionWork(religionWork));
    }

    /**
     * 删除工单
     */
    @RequiresPermissions("religion:religionWork:remove")
    @Log(title = "工单", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(religionWorkService.deleteReligionWorkByIds(ids));
    }
}

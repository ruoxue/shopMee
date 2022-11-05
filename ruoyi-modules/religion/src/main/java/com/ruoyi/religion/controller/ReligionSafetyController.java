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
import com.ruoyi.religion.domain.ReligionSafety;
import com.ruoyi.religion.service.IReligionSafetyService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 消防场所Controller
 * 
 * @author xiaoming
 * @date 2022-10-22 09:17:32
 */
@RestController
@RequestMapping("/religionSafety")
public class ReligionSafetyController extends BaseController
{
    @Autowired
    private IReligionSafetyService religionSafetyService;

    /**
     * 查询消防场所列表
     */
    @RequiresPermissions("religion:religionSafety:list")
    @GetMapping("/list")
    public TableDataInfo list(ReligionSafety religionSafety)
    {
        startPage();
        List<ReligionSafety> list = religionSafetyService.selectReligionSafetyList(religionSafety);
        return getDataTable(list);
    }

    /**
     * 导出消防场所列表
     */
    @RequiresPermissions("religion:religionSafety:export")
    @Log(title = "消防场所", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ReligionSafety religionSafety)
    {
        List<ReligionSafety> list = religionSafetyService.selectReligionSafetyList(religionSafety);
        ExcelUtil<ReligionSafety> util = new ExcelUtil<ReligionSafety>(ReligionSafety.class);
        util.exportExcel(response, list, "消防场所数据");
    }

    /**
     * 获取消防场所详细信息
     */
    @RequiresPermissions("religion:religionSafety:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(religionSafetyService.selectReligionSafetyById(id));
    }

    /**
     * 新增消防场所
     */
    @RequiresPermissions("religion:religionSafety:add")
    @Log(title = "消防场所", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ReligionSafety religionSafety)
    {
        return toAjax(religionSafetyService.insertReligionSafety(religionSafety));
    }

    /**
     * 修改消防场所
     */
    @RequiresPermissions("religion:religionSafety:edit")
    @Log(title = "消防场所", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ReligionSafety religionSafety)
    {
        return toAjax(religionSafetyService.updateReligionSafety(religionSafety));
    }

    /**
     * 删除消防场所
     */
    @RequiresPermissions("religion:religionSafety:remove")
    @Log(title = "消防场所", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(religionSafetyService.deleteReligionSafetyByIds(ids));
    }
}

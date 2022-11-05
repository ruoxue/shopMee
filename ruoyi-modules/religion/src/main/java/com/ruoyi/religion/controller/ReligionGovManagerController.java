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
import com.ruoyi.religion.domain.ReligionGovManager;
import com.ruoyi.religion.service.IReligionGovManagerService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 行政许可备案Controller
 * 
 * @author xiaoming
 * @date 2022-10-22 09:17:32
 */
@RestController
@RequestMapping("/religionGovManager")
public class ReligionGovManagerController extends BaseController
{
    @Autowired
    private IReligionGovManagerService religionGovManagerService;

    /**
     * 查询行政许可备案列表
     */
    @RequiresPermissions("religion:religionGovManager:list")
    @GetMapping("/list")
    public TableDataInfo list(ReligionGovManager religionGovManager)
    {
        startPage();
        List<ReligionGovManager> list = religionGovManagerService.selectReligionGovManagerList(religionGovManager);
        return getDataTable(list);
    }

    /**
     * 导出行政许可备案列表
     */
    @RequiresPermissions("religion:religionGovManager:export")
    @Log(title = "行政许可备案", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ReligionGovManager religionGovManager)
    {
        List<ReligionGovManager> list = religionGovManagerService.selectReligionGovManagerList(religionGovManager);
        ExcelUtil<ReligionGovManager> util = new ExcelUtil<ReligionGovManager>(ReligionGovManager.class);
        util.exportExcel(response, list, "行政许可备案数据");
    }

    /**
     * 获取行政许可备案详细信息
     */
    @RequiresPermissions("religion:religionGovManager:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(religionGovManagerService.selectReligionGovManagerById(id));
    }

    /**
     * 新增行政许可备案
     */
    @RequiresPermissions("religion:religionGovManager:add")
    @Log(title = "行政许可备案", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ReligionGovManager religionGovManager)
    {
        return toAjax(religionGovManagerService.insertReligionGovManager(religionGovManager));
    }

    /**
     * 修改行政许可备案
     */
    @RequiresPermissions("religion:religionGovManager:edit")
    @Log(title = "行政许可备案", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ReligionGovManager religionGovManager)
    {
        return toAjax(religionGovManagerService.updateReligionGovManager(religionGovManager));
    }

    /**
     * 删除行政许可备案
     */
    @RequiresPermissions("religion:religionGovManager:remove")
    @Log(title = "行政许可备案", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(religionGovManagerService.deleteReligionGovManagerByIds(ids));
    }
}

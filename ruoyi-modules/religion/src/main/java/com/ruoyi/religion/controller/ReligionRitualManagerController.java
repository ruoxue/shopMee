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
import com.ruoyi.religion.domain.ReligionRitualManager;
import com.ruoyi.religion.service.IReligionRitualManagerService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 法事登记备案Controller
 * 
 * @author xiaoming
 * @date 2022-10-22 09:17:32
 */
@RestController
@RequestMapping("/religionRitualManager")
public class ReligionRitualManagerController extends BaseController
{
    @Autowired
    private IReligionRitualManagerService religionRitualManagerService;

    /**
     * 查询法事登记备案列表
     */
    @RequiresPermissions("religion:religionRitualManager:list")
    @GetMapping("/list")
    public TableDataInfo list(ReligionRitualManager religionRitualManager)
    {
        startPage();
        List<ReligionRitualManager> list = religionRitualManagerService.selectReligionRitualManagerList(religionRitualManager);
        return getDataTable(list);
    }

    /**
     * 导出法事登记备案列表
     */
    @RequiresPermissions("religion:religionRitualManager:export")
    @Log(title = "法事登记备案", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ReligionRitualManager religionRitualManager)
    {
        List<ReligionRitualManager> list = religionRitualManagerService.selectReligionRitualManagerList(religionRitualManager);
        ExcelUtil<ReligionRitualManager> util = new ExcelUtil<ReligionRitualManager>(ReligionRitualManager.class);
        util.exportExcel(response, list, "法事登记备案数据");
    }

    /**
     * 获取法事登记备案详细信息
     */
    @RequiresPermissions("religion:religionRitualManager:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(religionRitualManagerService.selectReligionRitualManagerById(id));
    }

    /**
     * 新增法事登记备案
     */
    @RequiresPermissions("religion:religionRitualManager:add")
    @Log(title = "法事登记备案", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ReligionRitualManager religionRitualManager)
    {
        return toAjax(religionRitualManagerService.insertReligionRitualManager(religionRitualManager));
    }

    /**
     * 修改法事登记备案
     */
    @RequiresPermissions("religion:religionRitualManager:edit")
    @Log(title = "法事登记备案", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ReligionRitualManager religionRitualManager)
    {
        return toAjax(religionRitualManagerService.updateReligionRitualManager(religionRitualManager));
    }

    /**
     * 删除法事登记备案
     */
    @RequiresPermissions("religion:religionRitualManager:remove")
    @Log(title = "法事登记备案", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(religionRitualManagerService.deleteReligionRitualManagerByIds(ids));
    }
}

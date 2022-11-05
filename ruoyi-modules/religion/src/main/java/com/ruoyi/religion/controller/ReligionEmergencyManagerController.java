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
import com.ruoyi.religion.domain.ReligionEmergencyManager;
import com.ruoyi.religion.service.IReligionEmergencyManagerService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 应急预案管理Controller
 * 
 * @author xiaoming
 * @date 2022-10-22 09:17:31
 */
@RestController
@RequestMapping("/religionEmergencyManager")
public class ReligionEmergencyManagerController extends BaseController
{
    @Autowired
    private IReligionEmergencyManagerService religionEmergencyManagerService;

    /**
     * 查询应急预案管理列表
     */
    @RequiresPermissions("religion:religionEmergencyManager:list")
    @GetMapping("/list")
    public TableDataInfo list(ReligionEmergencyManager religionEmergencyManager)
    {
        startPage();
        List<ReligionEmergencyManager> list = religionEmergencyManagerService.selectReligionEmergencyManagerList(religionEmergencyManager);
        return getDataTable(list);
    }

    /**
     * 导出应急预案管理列表
     */
    @RequiresPermissions("religion:religionEmergencyManager:export")
    @Log(title = "应急预案管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ReligionEmergencyManager religionEmergencyManager)
    {
        List<ReligionEmergencyManager> list = religionEmergencyManagerService.selectReligionEmergencyManagerList(religionEmergencyManager);
        ExcelUtil<ReligionEmergencyManager> util = new ExcelUtil<ReligionEmergencyManager>(ReligionEmergencyManager.class);
        util.exportExcel(response, list, "应急预案管理数据");
    }

    /**
     * 获取应急预案管理详细信息
     */
    @RequiresPermissions("religion:religionEmergencyManager:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(religionEmergencyManagerService.selectReligionEmergencyManagerById(id));
    }

    /**
     * 新增应急预案管理
     */
    @RequiresPermissions("religion:religionEmergencyManager:add")
    @Log(title = "应急预案管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ReligionEmergencyManager religionEmergencyManager)
    {
        return toAjax(religionEmergencyManagerService.insertReligionEmergencyManager(religionEmergencyManager));
    }

    /**
     * 修改应急预案管理
     */
    @RequiresPermissions("religion:religionEmergencyManager:edit")
    @Log(title = "应急预案管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ReligionEmergencyManager religionEmergencyManager)
    {
        return toAjax(religionEmergencyManagerService.updateReligionEmergencyManager(religionEmergencyManager));
    }

    /**
     * 删除应急预案管理
     */
    @RequiresPermissions("religion:religionEmergencyManager:remove")
    @Log(title = "应急预案管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(religionEmergencyManagerService.deleteReligionEmergencyManagerByIds(ids));
    }
}

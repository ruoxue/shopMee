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
import com.ruoyi.religion.domain.ReligionSafetyManager;
import com.ruoyi.religion.service.IReligionSafetyManagerService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 场所消防检查Controller
 * 
 * @author xiaoming
 * @date 2022-10-22 09:17:32
 */
@RestController
@RequestMapping("/religionSafetyManager")
public class ReligionSafetyManagerController extends BaseController
{
    @Autowired
    private IReligionSafetyManagerService religionSafetyManagerService;

    /**
     * 查询场所消防检查列表
     */
    @RequiresPermissions("religion:religionSafetyManager:list")
    @GetMapping("/list")
    public TableDataInfo list(ReligionSafetyManager religionSafetyManager)
    {
        startPage();
        List<ReligionSafetyManager> list = religionSafetyManagerService.selectReligionSafetyManagerList(religionSafetyManager);
        return getDataTable(list);
    }

    /**
     * 导出场所消防检查列表
     */
    @RequiresPermissions("religion:religionSafetyManager:export")
    @Log(title = "场所消防检查", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ReligionSafetyManager religionSafetyManager)
    {
        List<ReligionSafetyManager> list = religionSafetyManagerService.selectReligionSafetyManagerList(religionSafetyManager);
        ExcelUtil<ReligionSafetyManager> util = new ExcelUtil<ReligionSafetyManager>(ReligionSafetyManager.class);
        util.exportExcel(response, list, "场所消防检查数据");
    }

    /**
     * 获取场所消防检查详细信息
     */
    @RequiresPermissions("religion:religionSafetyManager:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(religionSafetyManagerService.selectReligionSafetyManagerById(id));
    }

    /**
     * 新增场所消防检查
     */
    @RequiresPermissions("religion:religionSafetyManager:add")
    @Log(title = "场所消防检查", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ReligionSafetyManager religionSafetyManager)
    {
        return toAjax(religionSafetyManagerService.insertReligionSafetyManager(religionSafetyManager));
    }

    /**
     * 修改场所消防检查
     */
    @RequiresPermissions("religion:religionSafetyManager:edit")
    @Log(title = "场所消防检查", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ReligionSafetyManager religionSafetyManager)
    {
        return toAjax(religionSafetyManagerService.updateReligionSafetyManager(religionSafetyManager));
    }

    /**
     * 删除场所消防检查
     */
    @RequiresPermissions("religion:religionSafetyManager:remove")
    @Log(title = "场所消防检查", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(religionSafetyManagerService.deleteReligionSafetyManagerByIds(ids));
    }
}

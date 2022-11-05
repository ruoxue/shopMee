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
import com.ruoyi.religion.domain.ReligionBuildingManager;
import com.ruoyi.religion.service.IReligionBuildingManagerService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 场所建设登记管理Controller
 * 
 * @author xiaoming
 * @date 2022-10-22 09:17:31
 */
@RestController
@RequestMapping("/religionBuildingManager")
public class ReligionBuildingManagerController extends BaseController
{
    @Autowired
    private IReligionBuildingManagerService religionBuildingManagerService;

    /**
     * 查询场所建设登记管理列表
     */
    @RequiresPermissions("religion:religionBuildingManager:list")
    @GetMapping("/list")
    public TableDataInfo list(ReligionBuildingManager religionBuildingManager)
    {
        startPage();
        List<ReligionBuildingManager> list = religionBuildingManagerService.selectReligionBuildingManagerList(religionBuildingManager);
        return getDataTable(list);
    }

    /**
     * 导出场所建设登记管理列表
     */
    @RequiresPermissions("religion:religionBuildingManager:export")
    @Log(title = "场所建设登记管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ReligionBuildingManager religionBuildingManager)
    {
        List<ReligionBuildingManager> list = religionBuildingManagerService.selectReligionBuildingManagerList(religionBuildingManager);
        ExcelUtil<ReligionBuildingManager> util = new ExcelUtil<ReligionBuildingManager>(ReligionBuildingManager.class);
        util.exportExcel(response, list, "场所建设登记管理数据");
    }

    /**
     * 获取场所建设登记管理详细信息
     */
    @RequiresPermissions("religion:religionBuildingManager:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(religionBuildingManagerService.selectReligionBuildingManagerById(id));
    }

    /**
     * 新增场所建设登记管理
     */
    @RequiresPermissions("religion:religionBuildingManager:add")
    @Log(title = "场所建设登记管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ReligionBuildingManager religionBuildingManager)
    {
        return toAjax(religionBuildingManagerService.insertReligionBuildingManager(religionBuildingManager));
    }

    /**
     * 修改场所建设登记管理
     */
    @RequiresPermissions("religion:religionBuildingManager:edit")
    @Log(title = "场所建设登记管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ReligionBuildingManager religionBuildingManager)
    {
        return toAjax(religionBuildingManagerService.updateReligionBuildingManager(religionBuildingManager));
    }

    /**
     * 删除场所建设登记管理
     */
    @RequiresPermissions("religion:religionBuildingManager:remove")
    @Log(title = "场所建设登记管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(religionBuildingManagerService.deleteReligionBuildingManagerByIds(ids));
    }
}

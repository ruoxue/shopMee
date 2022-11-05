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
import com.ruoyi.religion.domain.ReligionBuildsafeInfoManager;
import com.ruoyi.religion.service.IReligionBuildsafeInfoManagerService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 建筑隐患信息上报Controller
 * 
 * @author xiaoming
 * @date 2022-10-22 09:17:31
 */
@RestController
@RequestMapping("/religionBuildsafeInfoManager")
public class ReligionBuildsafeInfoManagerController extends BaseController
{
    @Autowired
    private IReligionBuildsafeInfoManagerService religionBuildsafeInfoManagerService;

    /**
     * 查询建筑隐患信息上报列表
     */
    @RequiresPermissions("religion:religionBuildsafeInfoManager:list")
    @GetMapping("/list")
    public TableDataInfo list(ReligionBuildsafeInfoManager religionBuildsafeInfoManager)
    {
        startPage();
        List<ReligionBuildsafeInfoManager> list = religionBuildsafeInfoManagerService.selectReligionBuildsafeInfoManagerList(religionBuildsafeInfoManager);
        return getDataTable(list);
    }

    /**
     * 导出建筑隐患信息上报列表
     */
    @RequiresPermissions("religion:religionBuildsafeInfoManager:export")
    @Log(title = "建筑隐患信息上报", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ReligionBuildsafeInfoManager religionBuildsafeInfoManager)
    {
        List<ReligionBuildsafeInfoManager> list = religionBuildsafeInfoManagerService.selectReligionBuildsafeInfoManagerList(religionBuildsafeInfoManager);
        ExcelUtil<ReligionBuildsafeInfoManager> util = new ExcelUtil<ReligionBuildsafeInfoManager>(ReligionBuildsafeInfoManager.class);
        util.exportExcel(response, list, "建筑隐患信息上报数据");
    }

    /**
     * 获取建筑隐患信息上报详细信息
     */
    @RequiresPermissions("religion:religionBuildsafeInfoManager:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(religionBuildsafeInfoManagerService.selectReligionBuildsafeInfoManagerById(id));
    }

    /**
     * 新增建筑隐患信息上报
     */
    @RequiresPermissions("religion:religionBuildsafeInfoManager:add")
    @Log(title = "建筑隐患信息上报", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ReligionBuildsafeInfoManager religionBuildsafeInfoManager)
    {
        return toAjax(religionBuildsafeInfoManagerService.insertReligionBuildsafeInfoManager(religionBuildsafeInfoManager));
    }

    /**
     * 修改建筑隐患信息上报
     */
    @RequiresPermissions("religion:religionBuildsafeInfoManager:edit")
    @Log(title = "建筑隐患信息上报", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ReligionBuildsafeInfoManager religionBuildsafeInfoManager)
    {
        return toAjax(religionBuildsafeInfoManagerService.updateReligionBuildsafeInfoManager(religionBuildsafeInfoManager));
    }

    /**
     * 删除建筑隐患信息上报
     */
    @RequiresPermissions("religion:religionBuildsafeInfoManager:remove")
    @Log(title = "建筑隐患信息上报", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(religionBuildsafeInfoManagerService.deleteReligionBuildsafeInfoManagerByIds(ids));
    }
}

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
import com.ruoyi.religion.domain.ReligionIllegalManager;
import com.ruoyi.religion.service.IReligionIllegalManagerService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 非法活动管理Controller
 * 
 * @author xiaoming
 * @date 2022-10-22 09:17:32
 */
@RestController
@RequestMapping("/religionIllegalManager")
public class ReligionIllegalManagerController extends BaseController
{
    @Autowired
    private IReligionIllegalManagerService religionIllegalManagerService;

    /**
     * 查询非法活动管理列表
     */
    @RequiresPermissions("religion:religionIllegalManager:list")
    @GetMapping("/list")
    public TableDataInfo list(ReligionIllegalManager religionIllegalManager)
    {
        startPage();
        List<ReligionIllegalManager> list = religionIllegalManagerService.selectReligionIllegalManagerList(religionIllegalManager);
        return getDataTable(list);
    }

    /**
     * 导出非法活动管理列表
     */
    @RequiresPermissions("religion:religionIllegalManager:export")
    @Log(title = "非法活动管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ReligionIllegalManager religionIllegalManager)
    {
        List<ReligionIllegalManager> list = religionIllegalManagerService.selectReligionIllegalManagerList(religionIllegalManager);
        ExcelUtil<ReligionIllegalManager> util = new ExcelUtil<ReligionIllegalManager>(ReligionIllegalManager.class);
        util.exportExcel(response, list, "非法活动管理数据");
    }

    /**
     * 获取非法活动管理详细信息
     */
    @RequiresPermissions("religion:religionIllegalManager:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(religionIllegalManagerService.selectReligionIllegalManagerById(id));
    }

    /**
     * 新增非法活动管理
     */
    @RequiresPermissions("religion:religionIllegalManager:add")
    @Log(title = "非法活动管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ReligionIllegalManager religionIllegalManager)
    {
        return toAjax(religionIllegalManagerService.insertReligionIllegalManager(religionIllegalManager));
    }

    /**
     * 修改非法活动管理
     */
    @RequiresPermissions("religion:religionIllegalManager:edit")
    @Log(title = "非法活动管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ReligionIllegalManager religionIllegalManager)
    {
        return toAjax(religionIllegalManagerService.updateReligionIllegalManager(religionIllegalManager));
    }

    /**
     * 删除非法活动管理
     */
    @RequiresPermissions("religion:religionIllegalManager:remove")
    @Log(title = "非法活动管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(religionIllegalManagerService.deleteReligionIllegalManagerByIds(ids));
    }
}

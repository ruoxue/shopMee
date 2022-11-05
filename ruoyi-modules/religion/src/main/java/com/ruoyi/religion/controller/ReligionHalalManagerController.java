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
import com.ruoyi.religion.domain.ReligionHalalManager;
import com.ruoyi.religion.service.IReligionHalalManagerService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 清真食品备案Controller
 * 
 * @author xiaoming
 * @date 2022-10-22 09:17:32
 */
@RestController
@RequestMapping("/religionHalalManager")
public class ReligionHalalManagerController extends BaseController
{
    @Autowired
    private IReligionHalalManagerService religionHalalManagerService;

    /**
     * 查询清真食品备案列表
     */
    @RequiresPermissions("religion:religionHalalManager:list")
    @GetMapping("/list")
    public TableDataInfo list(ReligionHalalManager religionHalalManager)
    {
        startPage();
        List<ReligionHalalManager> list = religionHalalManagerService.selectReligionHalalManagerList(religionHalalManager);
        return getDataTable(list);
    }

    /**
     * 导出清真食品备案列表
     */
    @RequiresPermissions("religion:religionHalalManager:export")
    @Log(title = "清真食品备案", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ReligionHalalManager religionHalalManager)
    {
        List<ReligionHalalManager> list = religionHalalManagerService.selectReligionHalalManagerList(religionHalalManager);
        ExcelUtil<ReligionHalalManager> util = new ExcelUtil<ReligionHalalManager>(ReligionHalalManager.class);
        util.exportExcel(response, list, "清真食品备案数据");
    }

    /**
     * 获取清真食品备案详细信息
     */
    @RequiresPermissions("religion:religionHalalManager:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(religionHalalManagerService.selectReligionHalalManagerById(id));
    }

    /**
     * 新增清真食品备案
     */
    @RequiresPermissions("religion:religionHalalManager:add")
    @Log(title = "清真食品备案", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ReligionHalalManager religionHalalManager)
    {
        return toAjax(religionHalalManagerService.insertReligionHalalManager(religionHalalManager));
    }

    /**
     * 修改清真食品备案
     */
    @RequiresPermissions("religion:religionHalalManager:edit")
    @Log(title = "清真食品备案", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ReligionHalalManager religionHalalManager)
    {
        return toAjax(religionHalalManagerService.updateReligionHalalManager(religionHalalManager));
    }

    /**
     * 删除清真食品备案
     */
    @RequiresPermissions("religion:religionHalalManager:remove")
    @Log(title = "清真食品备案", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(religionHalalManagerService.deleteReligionHalalManagerByIds(ids));
    }
}

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
import com.ruoyi.religion.domain.ReligionFrenchManager;
import com.ruoyi.religion.service.IReligionFrenchManagerService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 法会登记备案Controller
 * 
 * @author xiaoming
 * @date 2022-10-22 09:17:32
 */
@RestController
@RequestMapping("/religionFrenchManager")
public class ReligionFrenchManagerController extends BaseController
{
    @Autowired
    private IReligionFrenchManagerService religionFrenchManagerService;

    /**
     * 查询法会登记备案列表
     */
    @RequiresPermissions("religion:religionFrenchManager:list")
    @GetMapping("/list")
    public TableDataInfo list(ReligionFrenchManager religionFrenchManager)
    {
        startPage();
        List<ReligionFrenchManager> list = religionFrenchManagerService.selectReligionFrenchManagerList(religionFrenchManager);
        return getDataTable(list);
    }

    /**
     * 导出法会登记备案列表
     */
    @RequiresPermissions("religion:religionFrenchManager:export")
    @Log(title = "法会登记备案", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ReligionFrenchManager religionFrenchManager)
    {
        List<ReligionFrenchManager> list = religionFrenchManagerService.selectReligionFrenchManagerList(religionFrenchManager);
        ExcelUtil<ReligionFrenchManager> util = new ExcelUtil<ReligionFrenchManager>(ReligionFrenchManager.class);
        util.exportExcel(response, list, "法会登记备案数据");
    }

    /**
     * 获取法会登记备案详细信息
     */
    @RequiresPermissions("religion:religionFrenchManager:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(religionFrenchManagerService.selectReligionFrenchManagerById(id));
    }

    /**
     * 新增法会登记备案
     */
    @RequiresPermissions("religion:religionFrenchManager:add")
    @Log(title = "法会登记备案", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ReligionFrenchManager religionFrenchManager)
    {
        return toAjax(religionFrenchManagerService.insertReligionFrenchManager(religionFrenchManager));
    }

    /**
     * 修改法会登记备案
     */
    @RequiresPermissions("religion:religionFrenchManager:edit")
    @Log(title = "法会登记备案", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ReligionFrenchManager religionFrenchManager)
    {
        return toAjax(religionFrenchManagerService.updateReligionFrenchManager(religionFrenchManager));
    }

    /**
     * 删除法会登记备案
     */
    @RequiresPermissions("religion:religionFrenchManager:remove")
    @Log(title = "法会登记备案", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(religionFrenchManagerService.deleteReligionFrenchManagerByIds(ids));
    }
}

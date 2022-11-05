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
import com.ruoyi.religion.domain.ReligionMemorialManager;
import com.ruoyi.religion.service.IReligionMemorialManagerService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 牌位登记备案Controller
 * 
 * @author xiaoming
 * @date 2022-10-22 09:17:32
 */
@RestController
@RequestMapping("/religionMemorialManager")
public class ReligionMemorialManagerController extends BaseController
{
    @Autowired
    private IReligionMemorialManagerService religionMemorialManagerService;

    /**
     * 查询牌位登记备案列表
     */
    @RequiresPermissions("religion:religionMemorialManager:list")
    @GetMapping("/list")
    public TableDataInfo list(ReligionMemorialManager religionMemorialManager)
    {
        startPage();
        List<ReligionMemorialManager> list = religionMemorialManagerService.selectReligionMemorialManagerList(religionMemorialManager);
        return getDataTable(list);
    }

    /**
     * 导出牌位登记备案列表
     */
    @RequiresPermissions("religion:religionMemorialManager:export")
    @Log(title = "牌位登记备案", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ReligionMemorialManager religionMemorialManager)
    {
        List<ReligionMemorialManager> list = religionMemorialManagerService.selectReligionMemorialManagerList(religionMemorialManager);
        ExcelUtil<ReligionMemorialManager> util = new ExcelUtil<ReligionMemorialManager>(ReligionMemorialManager.class);
        util.exportExcel(response, list, "牌位登记备案数据");
    }

    /**
     * 获取牌位登记备案详细信息
     */
    @RequiresPermissions("religion:religionMemorialManager:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(religionMemorialManagerService.selectReligionMemorialManagerById(id));
    }

    /**
     * 新增牌位登记备案
     */
    @RequiresPermissions("religion:religionMemorialManager:add")
    @Log(title = "牌位登记备案", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ReligionMemorialManager religionMemorialManager)
    {
        return toAjax(religionMemorialManagerService.insertReligionMemorialManager(religionMemorialManager));
    }

    /**
     * 修改牌位登记备案
     */
    @RequiresPermissions("religion:religionMemorialManager:edit")
    @Log(title = "牌位登记备案", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ReligionMemorialManager religionMemorialManager)
    {
        return toAjax(religionMemorialManagerService.updateReligionMemorialManager(religionMemorialManager));
    }

    /**
     * 删除牌位登记备案
     */
    @RequiresPermissions("religion:religionMemorialManager:remove")
    @Log(title = "牌位登记备案", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(religionMemorialManagerService.deleteReligionMemorialManagerByIds(ids));
    }
}

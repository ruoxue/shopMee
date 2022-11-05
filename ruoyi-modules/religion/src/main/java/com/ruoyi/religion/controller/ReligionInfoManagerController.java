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
import com.ruoyi.religion.domain.ReligionInfoManager;
import com.ruoyi.religion.service.IReligionInfoManagerService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 信息登记Controller
 * 
 * @author xiaoming
 * @date 2022-10-22 23:25:25
 */
@RestController
@RequestMapping("/religionInfoManager")
public class ReligionInfoManagerController extends BaseController
{
    @Autowired
    private IReligionInfoManagerService religionInfoManagerService;

    /**
     * 查询信息登记列表
     */
    @RequiresPermissions("religion:religionInfoManager:list")
    @GetMapping("/list")
    public TableDataInfo list(ReligionInfoManager religionInfoManager)
    {
        startPage();
        List<ReligionInfoManager> list = religionInfoManagerService.selectReligionInfoManagerList(religionInfoManager);
        return getDataTable(list);
    }

    /**
     * 导出信息登记列表
     */
    @RequiresPermissions("religion:religionInfoManager:export")
    @Log(title = "信息登记", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ReligionInfoManager religionInfoManager)
    {
        List<ReligionInfoManager> list = religionInfoManagerService.selectReligionInfoManagerList(religionInfoManager);
        ExcelUtil<ReligionInfoManager> util = new ExcelUtil<ReligionInfoManager>(ReligionInfoManager.class);
        util.exportExcel(response, list, "信息登记数据");
    }

    /**
     * 获取信息登记详细信息
     */
    @RequiresPermissions("religion:religionInfoManager:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(religionInfoManagerService.selectReligionInfoManagerById(id));
    }

    /**
     * 新增信息登记
     */
    @RequiresPermissions("religion:religionInfoManager:add")
    @Log(title = "信息登记", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ReligionInfoManager religionInfoManager)
    {
        return toAjax(religionInfoManagerService.insertReligionInfoManager(religionInfoManager));
    }

    /**
     * 修改信息登记
     */
    @RequiresPermissions("religion:religionInfoManager:edit")
    @Log(title = "信息登记", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ReligionInfoManager religionInfoManager)
    {
        return toAjax(religionInfoManagerService.updateReligionInfoManager(religionInfoManager));
    }

    /**
     * 删除信息登记
     */
    @RequiresPermissions("religion:religionInfoManager:remove")
    @Log(title = "信息登记", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(religionInfoManagerService.deleteReligionInfoManagerByIds(ids));
    }
}

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
import com.ruoyi.religion.domain.ReligionWarnManager;
import com.ruoyi.religion.service.IReligionWarnManagerService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 场所消防设施分布Controller
 * 
 * @author xiaoming
 * @date 2022-10-22 09:17:33
 */
@RestController
@RequestMapping("/religionWarnManager")
public class ReligionWarnManagerController extends BaseController
{
    @Autowired
    private IReligionWarnManagerService religionWarnManagerService;

    /**
     * 查询场所消防设施分布列表
     */
    @RequiresPermissions("religion:religionWarnManager:list")
    @GetMapping("/list")
    public TableDataInfo list(ReligionWarnManager religionWarnManager)
    {
        startPage();
        List<ReligionWarnManager> list = religionWarnManagerService.selectReligionWarnManagerList(religionWarnManager);
        return getDataTable(list);
    }

    /**
     * 导出场所消防设施分布列表
     */
    @RequiresPermissions("religion:religionWarnManager:export")
    @Log(title = "场所消防设施分布", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ReligionWarnManager religionWarnManager)
    {
        List<ReligionWarnManager> list = religionWarnManagerService.selectReligionWarnManagerList(religionWarnManager);
        ExcelUtil<ReligionWarnManager> util = new ExcelUtil<ReligionWarnManager>(ReligionWarnManager.class);
        util.exportExcel(response, list, "场所消防设施分布数据");
    }

    /**
     * 获取场所消防设施分布详细信息
     */
    @RequiresPermissions("religion:religionWarnManager:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(religionWarnManagerService.selectReligionWarnManagerById(id));
    }

    /**
     * 新增场所消防设施分布
     */
    @RequiresPermissions("religion:religionWarnManager:add")
    @Log(title = "场所消防设施分布", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ReligionWarnManager religionWarnManager)
    {
        return toAjax(religionWarnManagerService.insertReligionWarnManager(religionWarnManager));
    }

    /**
     * 修改场所消防设施分布
     */
    @RequiresPermissions("religion:religionWarnManager:edit")
    @Log(title = "场所消防设施分布", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ReligionWarnManager religionWarnManager)
    {
        return toAjax(religionWarnManagerService.updateReligionWarnManager(religionWarnManager));
    }

    /**
     * 删除场所消防设施分布
     */
    @RequiresPermissions("religion:religionWarnManager:remove")
    @Log(title = "场所消防设施分布", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(religionWarnManagerService.deleteReligionWarnManagerByIds(ids));
    }
}

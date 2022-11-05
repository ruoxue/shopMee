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
import com.ruoyi.religion.domain.ReligionIllegalUseManager;
import com.ruoyi.religion.service.IReligionIllegalUseManagerService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 违法用地场所Controller
 * 
 * @author xiaoming
 * @date 2022-10-22 09:17:30
 */
@RestController
@RequestMapping("/religionIllegalUseManager")
public class ReligionIllegalUseManagerController extends BaseController
{
    @Autowired
    private IReligionIllegalUseManagerService religionIllegalUseManagerService;

    /**
     * 查询违法用地场所列表
     */
    @RequiresPermissions("religion:religionIllegalUseManager:list")
    @GetMapping("/list")
    public TableDataInfo list(ReligionIllegalUseManager religionIllegalUseManager)
    {
        startPage();
        List<ReligionIllegalUseManager> list = religionIllegalUseManagerService.selectReligionIllegalUseManagerList(religionIllegalUseManager);
        return getDataTable(list);
    }

    /**
     * 导出违法用地场所列表
     */
    @RequiresPermissions("religion:religionIllegalUseManager:export")
    @Log(title = "违法用地场所", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ReligionIllegalUseManager religionIllegalUseManager)
    {
        List<ReligionIllegalUseManager> list = religionIllegalUseManagerService.selectReligionIllegalUseManagerList(religionIllegalUseManager);
        ExcelUtil<ReligionIllegalUseManager> util = new ExcelUtil<ReligionIllegalUseManager>(ReligionIllegalUseManager.class);
        util.exportExcel(response, list, "违法用地场所数据");
    }

    /**
     * 获取违法用地场所详细信息
     */
    @RequiresPermissions("religion:religionIllegalUseManager:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(religionIllegalUseManagerService.selectReligionIllegalUseManagerById(id));
    }

    /**
     * 新增违法用地场所
     */
    @RequiresPermissions("religion:religionIllegalUseManager:add")
    @Log(title = "违法用地场所", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ReligionIllegalUseManager religionIllegalUseManager)
    {
        return toAjax(religionIllegalUseManagerService.insertReligionIllegalUseManager(religionIllegalUseManager));
    }

    /**
     * 修改违法用地场所
     */
    @RequiresPermissions("religion:religionIllegalUseManager:edit")
    @Log(title = "违法用地场所", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ReligionIllegalUseManager religionIllegalUseManager)
    {
        return toAjax(religionIllegalUseManagerService.updateReligionIllegalUseManager(religionIllegalUseManager));
    }

    /**
     * 删除违法用地场所
     */
    @RequiresPermissions("religion:religionIllegalUseManager:remove")
    @Log(title = "违法用地场所", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(religionIllegalUseManagerService.deleteReligionIllegalUseManagerByIds(ids));
    }
}

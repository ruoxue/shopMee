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
import com.ruoyi.religion.domain.ReligionBuilding;
import com.ruoyi.religion.service.IReligionBuildingService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 宗教建筑物Controller
 * 
 * @author xiaoming
 * @date 2022-10-22 09:17:31
 */
@RestController
@RequestMapping("/religionBuilding")
public class ReligionBuildingController extends BaseController
{
    @Autowired
    private IReligionBuildingService religionBuildingService;

    /**
     * 查询宗教建筑物列表
     */
    @RequiresPermissions("religion:religionBuilding:list")
    @GetMapping("/list")
    public TableDataInfo list(ReligionBuilding religionBuilding)
    {
        startPage();
        List<ReligionBuilding> list = religionBuildingService.selectReligionBuildingList(religionBuilding);
        return getDataTable(list);
    }

    /**
     * 导出宗教建筑物列表
     */
    @RequiresPermissions("religion:religionBuilding:export")
    @Log(title = "宗教建筑物", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ReligionBuilding religionBuilding)
    {
        List<ReligionBuilding> list = religionBuildingService.selectReligionBuildingList(religionBuilding);
        ExcelUtil<ReligionBuilding> util = new ExcelUtil<ReligionBuilding>(ReligionBuilding.class);
        util.exportExcel(response, list, "宗教建筑物数据");
    }

    /**
     * 获取宗教建筑物详细信息
     */
    @RequiresPermissions("religion:religionBuilding:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(religionBuildingService.selectReligionBuildingById(id));
    }

    /**
     * 新增宗教建筑物
     */
    @RequiresPermissions("religion:religionBuilding:add")
    @Log(title = "宗教建筑物", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ReligionBuilding religionBuilding)
    {
        return toAjax(religionBuildingService.insertReligionBuilding(religionBuilding));
    }

    /**
     * 修改宗教建筑物
     */
    @RequiresPermissions("religion:religionBuilding:edit")
    @Log(title = "宗教建筑物", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ReligionBuilding religionBuilding)
    {
        return toAjax(religionBuildingService.updateReligionBuilding(religionBuilding));
    }

    /**
     * 删除宗教建筑物
     */
    @RequiresPermissions("religion:religionBuilding:remove")
    @Log(title = "宗教建筑物", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(religionBuildingService.deleteReligionBuildingByIds(ids));
    }
}

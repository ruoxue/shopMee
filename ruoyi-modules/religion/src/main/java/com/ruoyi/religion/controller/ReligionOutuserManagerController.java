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
import com.ruoyi.religion.domain.ReligionOutuserManager;
import com.ruoyi.religion.service.IReligionOutuserManagerService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 临时人员登记Controller
 * 
 * @author xiaoming
 * @date 2022-10-22 09:17:32
 */
@RestController
@RequestMapping("/religionOutuserManager")
public class ReligionOutuserManagerController extends BaseController
{
    @Autowired
    private IReligionOutuserManagerService religionOutuserManagerService;

    /**
     * 查询临时人员登记列表
     */
    @RequiresPermissions("religion:religionOutuserManager:list")
    @GetMapping("/list")
    public TableDataInfo list(ReligionOutuserManager religionOutuserManager)
    {
        startPage();
        List<ReligionOutuserManager> list = religionOutuserManagerService.selectReligionOutuserManagerList(religionOutuserManager);
        return getDataTable(list);
    }

    /**
     * 导出临时人员登记列表
     */
    @RequiresPermissions("religion:religionOutuserManager:export")
    @Log(title = "临时人员登记", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ReligionOutuserManager religionOutuserManager)
    {
        List<ReligionOutuserManager> list = religionOutuserManagerService.selectReligionOutuserManagerList(religionOutuserManager);
        ExcelUtil<ReligionOutuserManager> util = new ExcelUtil<ReligionOutuserManager>(ReligionOutuserManager.class);
        util.exportExcel(response, list, "临时人员登记数据");
    }

    /**
     * 获取临时人员登记详细信息
     */
    @RequiresPermissions("religion:religionOutuserManager:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(religionOutuserManagerService.selectReligionOutuserManagerById(id));
    }

    /**
     * 新增临时人员登记
     */
    @RequiresPermissions("religion:religionOutuserManager:add")
    @Log(title = "临时人员登记", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ReligionOutuserManager religionOutuserManager)
    {
        return toAjax(religionOutuserManagerService.insertReligionOutuserManager(religionOutuserManager));
    }

    /**
     * 修改临时人员登记
     */
    @RequiresPermissions("religion:religionOutuserManager:edit")
    @Log(title = "临时人员登记", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ReligionOutuserManager religionOutuserManager)
    {
        return toAjax(religionOutuserManagerService.updateReligionOutuserManager(religionOutuserManager));
    }

    /**
     * 删除临时人员登记
     */
    @RequiresPermissions("religion:religionOutuserManager:remove")
    @Log(title = "临时人员登记", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(religionOutuserManagerService.deleteReligionOutuserManagerByIds(ids));
    }
}

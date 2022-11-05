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
import com.ruoyi.religion.domain.ReligionEmergencyRecord;
import com.ruoyi.religion.service.IReligionEmergencyRecordService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 突发事件记录Controller
 * 
 * @author xiaoming
 * @date 2022-10-22 09:17:31
 */
@RestController
@RequestMapping("/religionEmergencyRecord")
public class ReligionEmergencyRecordController extends BaseController
{
    @Autowired
    private IReligionEmergencyRecordService religionEmergencyRecordService;

    /**
     * 查询突发事件记录列表
     */
    @RequiresPermissions("religion:religionEmergencyRecord:list")
    @GetMapping("/list")
    public TableDataInfo list(ReligionEmergencyRecord religionEmergencyRecord)
    {
        startPage();
        List<ReligionEmergencyRecord> list = religionEmergencyRecordService.selectReligionEmergencyRecordList(religionEmergencyRecord);
        return getDataTable(list);
    }

    /**
     * 导出突发事件记录列表
     */
    @RequiresPermissions("religion:religionEmergencyRecord:export")
    @Log(title = "突发事件记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ReligionEmergencyRecord religionEmergencyRecord)
    {
        List<ReligionEmergencyRecord> list = religionEmergencyRecordService.selectReligionEmergencyRecordList(religionEmergencyRecord);
        ExcelUtil<ReligionEmergencyRecord> util = new ExcelUtil<ReligionEmergencyRecord>(ReligionEmergencyRecord.class);
        util.exportExcel(response, list, "突发事件记录数据");
    }

    /**
     * 获取突发事件记录详细信息
     */
    @RequiresPermissions("religion:religionEmergencyRecord:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(religionEmergencyRecordService.selectReligionEmergencyRecordById(id));
    }

    /**
     * 新增突发事件记录
     */
    @RequiresPermissions("religion:religionEmergencyRecord:add")
    @Log(title = "突发事件记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ReligionEmergencyRecord religionEmergencyRecord)
    {
        return toAjax(religionEmergencyRecordService.insertReligionEmergencyRecord(religionEmergencyRecord));
    }

    /**
     * 修改突发事件记录
     */
    @RequiresPermissions("religion:religionEmergencyRecord:edit")
    @Log(title = "突发事件记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ReligionEmergencyRecord religionEmergencyRecord)
    {
        return toAjax(religionEmergencyRecordService.updateReligionEmergencyRecord(religionEmergencyRecord));
    }

    /**
     * 删除突发事件记录
     */
    @RequiresPermissions("religion:religionEmergencyRecord:remove")
    @Log(title = "突发事件记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(religionEmergencyRecordService.deleteReligionEmergencyRecordByIds(ids));
    }
}

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
import com.ruoyi.religion.domain.ReligionMessage;
import com.ruoyi.religion.service.IReligionMessageService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 预警Controller
 * 
 * @author xiaoming
 * @date 2022-10-22 09:17:32
 */
@RestController
@RequestMapping("/religionMessage")
public class ReligionMessageController extends BaseController
{
    @Autowired
    private IReligionMessageService religionMessageService;

    /**
     * 查询预警列表
     */
    @RequiresPermissions("religion:religionMessage:list")
    @GetMapping("/list")
    public TableDataInfo list(ReligionMessage religionMessage)
    {
        startPage();
        List<ReligionMessage> list = religionMessageService.selectReligionMessageList(religionMessage);
        return getDataTable(list);
    }

    /**
     * 导出预警列表
     */
    @RequiresPermissions("religion:religionMessage:export")
    @Log(title = "预警", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ReligionMessage religionMessage)
    {
        List<ReligionMessage> list = religionMessageService.selectReligionMessageList(religionMessage);
        ExcelUtil<ReligionMessage> util = new ExcelUtil<ReligionMessage>(ReligionMessage.class);
        util.exportExcel(response, list, "预警数据");
    }

    /**
     * 获取预警详细信息
     */
    @RequiresPermissions("religion:religionMessage:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(religionMessageService.selectReligionMessageById(id));
    }

    /**
     * 新增预警
     */
    @RequiresPermissions("religion:religionMessage:add")
    @Log(title = "预警", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ReligionMessage religionMessage)
    {
        return toAjax(religionMessageService.insertReligionMessage(religionMessage));
    }

    /**
     * 修改预警
     */
    @RequiresPermissions("religion:religionMessage:edit")
    @Log(title = "预警", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ReligionMessage religionMessage)
    {
        return toAjax(religionMessageService.updateReligionMessage(religionMessage));
    }

    /**
     * 删除预警
     */
    @RequiresPermissions("religion:religionMessage:remove")
    @Log(title = "预警", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(religionMessageService.deleteReligionMessageByIds(ids));
    }
}

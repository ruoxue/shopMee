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
import com.ruoyi.religion.domain.ReligionNotice;
import com.ruoyi.religion.service.IReligionNoticeService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 通知公告Controller
 * 
 * @author xiaoming
 * @date 2022-10-22 23:25:25
 */
@RestController
@RequestMapping("/religionNotice")
public class ReligionNoticeController extends BaseController
{
    @Autowired
    private IReligionNoticeService religionNoticeService;

    /**
     * 查询通知公告列表
     */
    @RequiresPermissions("religion:religionNotice:list")
    @GetMapping("/list")
    public TableDataInfo list(ReligionNotice religionNotice)
    {
        startPage();
        List<ReligionNotice> list = religionNoticeService.selectReligionNoticeList(religionNotice);
        return getDataTable(list);
    }

    /**
     * 导出通知公告列表
     */
    @RequiresPermissions("religion:religionNotice:export")
    @Log(title = "通知公告", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ReligionNotice religionNotice)
    {
        List<ReligionNotice> list = religionNoticeService.selectReligionNoticeList(religionNotice);
        ExcelUtil<ReligionNotice> util = new ExcelUtil<ReligionNotice>(ReligionNotice.class);
        util.exportExcel(response, list, "通知公告数据");
    }

    /**
     * 获取通知公告详细信息
     */
    @RequiresPermissions("religion:religionNotice:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(religionNoticeService.selectReligionNoticeById(id));
    }

    /**
     * 新增通知公告
     */
    @RequiresPermissions("religion:religionNotice:add")
    @Log(title = "通知公告", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ReligionNotice religionNotice)
    {
        return toAjax(religionNoticeService.insertReligionNotice(religionNotice));
    }

    /**
     * 修改通知公告
     */
    @RequiresPermissions("religion:religionNotice:edit")
    @Log(title = "通知公告", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ReligionNotice religionNotice)
    {
        return toAjax(religionNoticeService.updateReligionNotice(religionNotice));
    }

    /**
     * 删除通知公告
     */
    @RequiresPermissions("religion:religionNotice:remove")
    @Log(title = "通知公告", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(religionNoticeService.deleteReligionNoticeByIds(ids));
    }
}

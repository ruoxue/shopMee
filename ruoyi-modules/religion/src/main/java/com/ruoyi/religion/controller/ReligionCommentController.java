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
import com.ruoyi.religion.domain.ReligionComment;
import com.ruoyi.religion.service.IReligionCommentService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 举报投诉Controller
 * 
 * @author xiaoming
 * @date 2022-10-22 09:17:31
 */
@RestController
@RequestMapping("/religionComment")
public class ReligionCommentController extends BaseController
{
    @Autowired
    private IReligionCommentService religionCommentService;

    /**
     * 查询举报投诉列表
     */
    @RequiresPermissions("religion:religionComment:list")
    @GetMapping("/list")
    public TableDataInfo list(ReligionComment religionComment)
    {
        startPage();
        List<ReligionComment> list = religionCommentService.selectReligionCommentList(religionComment);
        return getDataTable(list);
    }

    /**
     * 导出举报投诉列表
     */
    @RequiresPermissions("religion:religionComment:export")
    @Log(title = "举报投诉", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ReligionComment religionComment)
    {
        List<ReligionComment> list = religionCommentService.selectReligionCommentList(religionComment);
        ExcelUtil<ReligionComment> util = new ExcelUtil<ReligionComment>(ReligionComment.class);
        util.exportExcel(response, list, "举报投诉数据");
    }

    /**
     * 获取举报投诉详细信息
     */
    @RequiresPermissions("religion:religionComment:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(religionCommentService.selectReligionCommentById(id));
    }

    /**
     * 新增举报投诉
     */
    @RequiresPermissions("religion:religionComment:add")
    @Log(title = "举报投诉", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ReligionComment religionComment)
    {
        return toAjax(religionCommentService.insertReligionComment(religionComment));
    }

    /**
     * 修改举报投诉
     */
    @RequiresPermissions("religion:religionComment:edit")
    @Log(title = "举报投诉", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ReligionComment religionComment)
    {
        return toAjax(religionCommentService.updateReligionComment(religionComment));
    }

    /**
     * 删除举报投诉
     */
    @RequiresPermissions("religion:religionComment:remove")
    @Log(title = "举报投诉", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(religionCommentService.deleteReligionCommentByIds(ids));
    }
}

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
import com.ruoyi.religion.domain.ReligionTeam;
import com.ruoyi.religion.service.IReligionTeamService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 团体Controller
 * 
 * @author xiaoming
 * @date 2022-10-22 09:17:33
 */
@RestController
@RequestMapping("/religionTeam")
public class ReligionTeamController extends BaseController
{
    @Autowired
    private IReligionTeamService religionTeamService;

    /**
     * 查询团体列表
     */
    @RequiresPermissions("religion:religionTeam:list")
    @GetMapping("/list")
    public TableDataInfo list(ReligionTeam religionTeam)
    {
        startPage();
        List<ReligionTeam> list = religionTeamService.selectReligionTeamList(religionTeam);
        return getDataTable(list);
    }

    /**
     * 导出团体列表
     */
    @RequiresPermissions("religion:religionTeam:export")
    @Log(title = "团体", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ReligionTeam religionTeam)
    {
        List<ReligionTeam> list = religionTeamService.selectReligionTeamList(religionTeam);
        ExcelUtil<ReligionTeam> util = new ExcelUtil<ReligionTeam>(ReligionTeam.class);
        util.exportExcel(response, list, "团体数据");
    }

    /**
     * 获取团体详细信息
     */
    @RequiresPermissions("religion:religionTeam:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(religionTeamService.selectReligionTeamById(id));
    }

    /**
     * 新增团体
     */
    @RequiresPermissions("religion:religionTeam:add")
    @Log(title = "团体", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ReligionTeam religionTeam)
    {
        return toAjax(religionTeamService.insertReligionTeam(religionTeam));
    }

    /**
     * 修改团体
     */
    @RequiresPermissions("religion:religionTeam:edit")
    @Log(title = "团体", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ReligionTeam religionTeam)
    {
        return toAjax(religionTeamService.updateReligionTeam(religionTeam));
    }

    /**
     * 删除团体
     */
    @RequiresPermissions("religion:religionTeam:remove")
    @Log(title = "团体", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(religionTeamService.deleteReligionTeamByIds(ids));
    }
}

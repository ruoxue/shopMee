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
import com.ruoyi.religion.domain.ReligionLearnAssist;
import com.ruoyi.religion.service.IReligionLearnAssistService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 学习辅助Controller
 * 
 * @author xiaoming
 * @date 2022-10-22 23:25:25
 */
@RestController
@RequestMapping("/religionLearnAssist")
public class ReligionLearnAssistController extends BaseController
{
    @Autowired
    private IReligionLearnAssistService religionLearnAssistService;

    /**
     * 查询学习辅助列表
     */
    @RequiresPermissions("religion:religionLearnAssist:list")
    @GetMapping("/list")
    public TableDataInfo list(ReligionLearnAssist religionLearnAssist)
    {
        startPage();
        List<ReligionLearnAssist> list = religionLearnAssistService.selectReligionLearnAssistList(religionLearnAssist);
        return getDataTable(list);
    }

    /**
     * 导出学习辅助列表
     */
    @RequiresPermissions("religion:religionLearnAssist:export")
    @Log(title = "学习辅助", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ReligionLearnAssist religionLearnAssist)
    {
        List<ReligionLearnAssist> list = religionLearnAssistService.selectReligionLearnAssistList(religionLearnAssist);
        ExcelUtil<ReligionLearnAssist> util = new ExcelUtil<ReligionLearnAssist>(ReligionLearnAssist.class);
        util.exportExcel(response, list, "学习辅助数据");
    }

    /**
     * 获取学习辅助详细信息
     */
    @RequiresPermissions("religion:religionLearnAssist:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(religionLearnAssistService.selectReligionLearnAssistById(id));
    }

    /**
     * 新增学习辅助
     */
    @RequiresPermissions("religion:religionLearnAssist:add")
    @Log(title = "学习辅助", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ReligionLearnAssist religionLearnAssist)
    {
        return toAjax(religionLearnAssistService.insertReligionLearnAssist(religionLearnAssist));
    }

    /**
     * 修改学习辅助
     */
    @RequiresPermissions("religion:religionLearnAssist:edit")
    @Log(title = "学习辅助", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ReligionLearnAssist religionLearnAssist)
    {
        return toAjax(religionLearnAssistService.updateReligionLearnAssist(religionLearnAssist));
    }

    /**
     * 删除学习辅助
     */
    @RequiresPermissions("religion:religionLearnAssist:remove")
    @Log(title = "学习辅助", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(religionLearnAssistService.deleteReligionLearnAssistByIds(ids));
    }
}

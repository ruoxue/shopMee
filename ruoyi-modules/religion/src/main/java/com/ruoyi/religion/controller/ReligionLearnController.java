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
import com.ruoyi.religion.domain.ReligionLearn;
import com.ruoyi.religion.service.IReligionLearnService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 文化学习Controller
 * 
 * @author xiaoming
 * @date 2022-10-22 09:17:32
 */
@RestController
@RequestMapping("/religionLearn")
public class ReligionLearnController extends BaseController
{
    @Autowired
    private IReligionLearnService religionLearnService;

    /**
     * 查询文化学习列表
     */
    @RequiresPermissions("religion:religionLearn:list")
    @GetMapping("/list")
    public TableDataInfo list(ReligionLearn religionLearn)
    {
        startPage();
        List<ReligionLearn> list = religionLearnService.selectReligionLearnList(religionLearn);
        return getDataTable(list);
    }

    /**
     * 导出文化学习列表
     */
    @RequiresPermissions("religion:religionLearn:export")
    @Log(title = "文化学习", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ReligionLearn religionLearn)
    {
        List<ReligionLearn> list = religionLearnService.selectReligionLearnList(religionLearn);
        ExcelUtil<ReligionLearn> util = new ExcelUtil<ReligionLearn>(ReligionLearn.class);
        util.exportExcel(response, list, "文化学习数据");
    }

    /**
     * 获取文化学习详细信息
     */
    @RequiresPermissions("religion:religionLearn:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(religionLearnService.selectReligionLearnById(id));
    }

    /**
     * 新增文化学习
     */
    @RequiresPermissions("religion:religionLearn:add")
    @Log(title = "文化学习", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ReligionLearn religionLearn)
    {
        return toAjax(religionLearnService.insertReligionLearn(religionLearn));
    }

    /**
     * 修改文化学习
     */
    @RequiresPermissions("religion:religionLearn:edit")
    @Log(title = "文化学习", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ReligionLearn religionLearn)
    {
        return toAjax(religionLearnService.updateReligionLearn(religionLearn));
    }

    /**
     * 删除文化学习
     */
    @RequiresPermissions("religion:religionLearn:remove")
    @Log(title = "文化学习", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(religionLearnService.deleteReligionLearnByIds(ids));
    }
}

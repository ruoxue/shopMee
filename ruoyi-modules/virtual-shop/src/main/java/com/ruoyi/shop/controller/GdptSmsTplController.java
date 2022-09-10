package com.ruoyi.shop.controller;

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
import com.ruoyi.shop.domain.GdptSmsTpl;
import com.ruoyi.shop.service.IGdptSmsTplService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 短信模板Controller
 * 
 * @author xiaoming
 * @date 2022-08-07
 */
@RestController
@RequestMapping("/gdptSmsTpl")
public class GdptSmsTplController extends BaseController
{
    @Autowired
    private IGdptSmsTplService gdptSmsTplService;

    /**
     * 查询短信模板列表
     */
    @RequiresPermissions("shop:gdptSmsTpl:list")
    @GetMapping("/list")
    public TableDataInfo list(GdptSmsTpl gdptSmsTpl)
    {
        startPage();
        List<GdptSmsTpl> list = gdptSmsTplService.selectGdptSmsTplList(gdptSmsTpl);
        return getDataTable(list);
    }

    /**
     * 导出短信模板列表
     */
    @RequiresPermissions("shop:gdptSmsTpl:export")
    @Log(title = "短信模板", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, GdptSmsTpl gdptSmsTpl)
    {
        List<GdptSmsTpl> list = gdptSmsTplService.selectGdptSmsTplList(gdptSmsTpl);
        ExcelUtil<GdptSmsTpl> util = new ExcelUtil<GdptSmsTpl>(GdptSmsTpl.class);
        util.exportExcel(response, list, "短信模板数据");
    }

    /**
     * 获取短信模板详细信息
     */
    @RequiresPermissions("shop:gdptSmsTpl:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return AjaxResult.success(gdptSmsTplService.selectGdptSmsTplById(id));
    }

    /**
     * 新增短信模板
     */
    @RequiresPermissions("shop:gdptSmsTpl:add")
    @Log(title = "短信模板", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody GdptSmsTpl gdptSmsTpl)
    {
        return toAjax(gdptSmsTplService.insertGdptSmsTpl(gdptSmsTpl));
    }

    /**
     * 修改短信模板
     */
    @RequiresPermissions("shop:gdptSmsTpl:edit")
    @Log(title = "短信模板", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody GdptSmsTpl gdptSmsTpl)
    {
        return toAjax(gdptSmsTplService.updateGdptSmsTpl(gdptSmsTpl));
    }

    /**
     * 删除短信模板
     */
    @RequiresPermissions("shop:gdptSmsTpl:remove")
    @Log(title = "短信模板", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(gdptSmsTplService.deleteGdptSmsTplByIds(ids));
    }
}

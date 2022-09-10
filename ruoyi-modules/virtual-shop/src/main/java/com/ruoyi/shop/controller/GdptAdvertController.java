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
import com.ruoyi.shop.domain.GdptAdvert;
import com.ruoyi.shop.service.IGdptAdvertService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 广告Controller
 * 
 * @author xiaoming
 * @date 2022-08-07
 */
@RestController
@RequestMapping("/gdptAdvert")
public class GdptAdvertController extends BaseController
{
    @Autowired
    private IGdptAdvertService gdptAdvertService;

    /**
     * 查询广告列表
     */
    @RequiresPermissions("shop:gdptAdvert:list")
    @GetMapping("/list")
    public TableDataInfo list(GdptAdvert gdptAdvert)
    {
        startPage();
        List<GdptAdvert> list = gdptAdvertService.selectGdptAdvertList(gdptAdvert);
        return getDataTable(list);
    }

    /**
     * 导出广告列表
     */
    @RequiresPermissions("shop:gdptAdvert:export")
    @Log(title = "广告", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, GdptAdvert gdptAdvert)
    {
        List<GdptAdvert> list = gdptAdvertService.selectGdptAdvertList(gdptAdvert);
        ExcelUtil<GdptAdvert> util = new ExcelUtil<GdptAdvert>(GdptAdvert.class);
        util.exportExcel(response, list, "广告数据");
    }

    /**
     * 获取广告详细信息
     */
    @RequiresPermissions("shop:gdptAdvert:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return AjaxResult.success(gdptAdvertService.selectGdptAdvertById(id));
    }

    /**
     * 新增广告
     */
    @RequiresPermissions("shop:gdptAdvert:add")
    @Log(title = "广告", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody GdptAdvert gdptAdvert)
    {
        return toAjax(gdptAdvertService.insertGdptAdvert(gdptAdvert));
    }

    /**
     * 修改广告
     */
    @RequiresPermissions("shop:gdptAdvert:edit")
    @Log(title = "广告", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody GdptAdvert gdptAdvert)
    {
        return toAjax(gdptAdvertService.updateGdptAdvert(gdptAdvert));
    }

    /**
     * 删除广告
     */
    @RequiresPermissions("shop:gdptAdvert:remove")
    @Log(title = "广告", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(gdptAdvertService.deleteGdptAdvertByIds(ids));
    }
}

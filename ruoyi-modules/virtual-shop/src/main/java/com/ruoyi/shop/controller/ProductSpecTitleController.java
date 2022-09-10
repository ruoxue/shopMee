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
import com.ruoyi.shop.domain.ProductSpecTitle;
import com.ruoyi.shop.service.IProductSpecTitleService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 商品规格项Controller
 * 
 * @author xiaoming
 * @date 2022-08-07
 */
@RestController
@RequestMapping("/productSpecTitle")
public class ProductSpecTitleController extends BaseController
{
    @Autowired
    private IProductSpecTitleService productSpecTitleService;

    /**
     * 查询商品规格项列表
     */
    @RequiresPermissions("shop:productSpecTitle:list")
    @GetMapping("/list")
    public TableDataInfo list(ProductSpecTitle productSpecTitle)
    {
        startPage();
        List<ProductSpecTitle> list = productSpecTitleService.selectProductSpecTitleList(productSpecTitle);
        return getDataTable(list);
    }

    /**
     * 导出商品规格项列表
     */
    @RequiresPermissions("shop:productSpecTitle:export")
    @Log(title = "商品规格项", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ProductSpecTitle productSpecTitle)
    {
        List<ProductSpecTitle> list = productSpecTitleService.selectProductSpecTitleList(productSpecTitle);
        ExcelUtil<ProductSpecTitle> util = new ExcelUtil<ProductSpecTitle>(ProductSpecTitle.class);
        util.exportExcel(response, list, "商品规格项数据");
    }

    /**
     * 获取商品规格项详细信息
     */
    @RequiresPermissions("shop:productSpecTitle:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return AjaxResult.success(productSpecTitleService.selectProductSpecTitleById(id));
    }

    /**
     * 新增商品规格项
     */
    @RequiresPermissions("shop:productSpecTitle:add")
    @Log(title = "商品规格项", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ProductSpecTitle productSpecTitle)
    {
        return toAjax(productSpecTitleService.insertProductSpecTitle(productSpecTitle));
    }

    /**
     * 修改商品规格项
     */
    @RequiresPermissions("shop:productSpecTitle:edit")
    @Log(title = "商品规格项", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ProductSpecTitle productSpecTitle)
    {
        return toAjax(productSpecTitleService.updateProductSpecTitle(productSpecTitle));
    }

    /**
     * 删除商品规格项
     */
    @RequiresPermissions("shop:productSpecTitle:remove")
    @Log(title = "商品规格项", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(productSpecTitleService.deleteProductSpecTitleByIds(ids));
    }
}

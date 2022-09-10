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
import com.ruoyi.shop.domain.ProductLabel;
import com.ruoyi.shop.service.IProductLabelService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 商品标签Controller
 * 
 * @author xiaoming
 * @date 2022-08-07
 */
@RestController
@RequestMapping("/productLabel")
public class ProductLabelController extends BaseController
{
    @Autowired
    private IProductLabelService productLabelService;

    /**
     * 查询商品标签列表
     */
    @RequiresPermissions("shop:productLabel:list")
    @GetMapping("/list")
    public TableDataInfo list(ProductLabel productLabel)
    {
        startPage();
        List<ProductLabel> list = productLabelService.selectProductLabelList(productLabel);
        return getDataTable(list);
    }

    /**
     * 导出商品标签列表
     */
    @RequiresPermissions("shop:productLabel:export")
    @Log(title = "商品标签", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ProductLabel productLabel)
    {
        List<ProductLabel> list = productLabelService.selectProductLabelList(productLabel);
        ExcelUtil<ProductLabel> util = new ExcelUtil<ProductLabel>(ProductLabel.class);
        util.exportExcel(response, list, "商品标签数据");
    }

    /**
     * 获取商品标签详细信息
     */
    @RequiresPermissions("shop:productLabel:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(productLabelService.selectProductLabelById(id));
    }

    /**
     * 新增商品标签
     */
    @RequiresPermissions("shop:productLabel:add")
    @Log(title = "商品标签", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ProductLabel productLabel)
    {
        return toAjax(productLabelService.insertProductLabel(productLabel));
    }

    /**
     * 修改商品标签
     */
    @RequiresPermissions("shop:productLabel:edit")
    @Log(title = "商品标签", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ProductLabel productLabel)
    {
        return toAjax(productLabelService.updateProductLabel(productLabel));
    }

    /**
     * 删除商品标签
     */
    @RequiresPermissions("shop:productLabel:remove")
    @Log(title = "商品标签", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(productLabelService.deleteProductLabelByIds(ids));
    }
}

package com.ruoyi.shop.controller;

import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.security.annotation.InnerAuth;
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
import com.ruoyi.shop.domain.ProductSpecOption;
import com.ruoyi.shop.service.IProductSpecOptionService;
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
@RequestMapping("/productSpecOption")
public class ProductSpecOptionController extends BaseController
{
    @Autowired
    private IProductSpecOptionService productSpecOptionService;





    /**
     * 查询商品规格项列表
     */
    @RequiresPermissions("shop:productSpecOption:list")
    @GetMapping("/list")
    public TableDataInfo list(ProductSpecOption productSpecOption)
    {
        startPage();
        List<ProductSpecOption> list = productSpecOptionService.selectProductSpecOptionList(productSpecOption);
        return getDataTable(list);
    }

    /**
     * 导出商品规格项列表
     */
    @RequiresPermissions("shop:productSpecOption:export")
    @Log(title = "商品规格项", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ProductSpecOption productSpecOption)
    {
        List<ProductSpecOption> list = productSpecOptionService.selectProductSpecOptionList(productSpecOption);
        ExcelUtil<ProductSpecOption> util = new ExcelUtil<ProductSpecOption>(ProductSpecOption.class);
        util.exportExcel(response, list, "商品规格项数据");
    }

    /**
     * 获取商品规格项详细信息
     */
    @RequiresPermissions("shop:productSpecOption:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(productSpecOptionService.selectProductSpecOptionById(id));
    }

    /**
     * 新增商品规格项
     */
    @RequiresPermissions("shop:productSpecOption:add")
    @Log(title = "商品规格项", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ProductSpecOption productSpecOption)
    {
        return toAjax(productSpecOptionService.insertProductSpecOption(productSpecOption));
    }

    /**
     * 修改商品规格项
     */
    @RequiresPermissions("shop:productSpecOption:edit")
    @Log(title = "商品规格项", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ProductSpecOption productSpecOption)
    {
        return toAjax(productSpecOptionService.updateProductSpecOption(productSpecOption));
    }

    /**
     * 删除商品规格项
     */
    @RequiresPermissions("shop:productSpecOption:remove")
    @Log(title = "商品规格项", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(productSpecOptionService.deleteProductSpecOptionByIds(ids));
    }
}

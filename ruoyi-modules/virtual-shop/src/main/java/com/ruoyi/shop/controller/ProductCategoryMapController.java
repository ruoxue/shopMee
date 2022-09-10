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
import com.ruoyi.shop.domain.ProductCategoryMap;
import com.ruoyi.shop.service.IProductCategoryMapService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 商品分类对应关系Controller
 * 
 * @author xiaoming
 * @date 2022-08-07
 */
@RestController
@RequestMapping("/productCategoryMap")
public class ProductCategoryMapController extends BaseController
{
    @Autowired
    private IProductCategoryMapService productCategoryMapService;

    /**
     * 查询商品分类对应关系列表
     */
    @RequiresPermissions("shop:productCategoryMap:list")
    @GetMapping("/list")
    public TableDataInfo list(ProductCategoryMap productCategoryMap)
    {
        startPage();
        List<ProductCategoryMap> list = productCategoryMapService.selectProductCategoryMapList(productCategoryMap);
        return getDataTable(list);
    }

    /**
     * 导出商品分类对应关系列表
     */
    @RequiresPermissions("shop:productCategoryMap:export")
    @Log(title = "商品分类对应关系", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ProductCategoryMap productCategoryMap)
    {
        List<ProductCategoryMap> list = productCategoryMapService.selectProductCategoryMapList(productCategoryMap);
        ExcelUtil<ProductCategoryMap> util = new ExcelUtil<ProductCategoryMap>(ProductCategoryMap.class);
        util.exportExcel(response, list, "商品分类对应关系数据");
    }

    /**
     * 获取商品分类对应关系详细信息
     */
    @RequiresPermissions("shop:productCategoryMap:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return AjaxResult.success(productCategoryMapService.selectProductCategoryMapById(id));
    }

    /**
     * 新增商品分类对应关系
     */
    @RequiresPermissions("shop:productCategoryMap:add")
    @Log(title = "商品分类对应关系", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ProductCategoryMap productCategoryMap)
    {
        return toAjax(productCategoryMapService.insertProductCategoryMap(productCategoryMap));
    }

    /**
     * 修改商品分类对应关系
     */
    @RequiresPermissions("shop:productCategoryMap:edit")
    @Log(title = "商品分类对应关系", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ProductCategoryMap productCategoryMap)
    {
        return toAjax(productCategoryMapService.updateProductCategoryMap(productCategoryMap));
    }

    /**
     * 删除商品分类对应关系
     */
    @RequiresPermissions("shop:productCategoryMap:remove")
    @Log(title = "商品分类对应关系", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(productCategoryMapService.deleteProductCategoryMapByIds(ids));
    }
}

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
import com.ruoyi.shop.domain.ProductGroupMap;
import com.ruoyi.shop.service.IProductGroupMapService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 商品分组对应关系Controller
 * 
 * @author xiaoming
 * @date 2022-08-07
 */
@RestController
@RequestMapping("/productGroupMap")
public class ProductGroupMapController extends BaseController
{
    @Autowired
    private IProductGroupMapService productGroupMapService;

    /**
     * 查询商品分组对应关系列表
     */
    @RequiresPermissions("shop:productGroupMap:list")
    @GetMapping("/list")
    public TableDataInfo list(ProductGroupMap productGroupMap)
    {
        startPage();
        List<ProductGroupMap> list = productGroupMapService.selectProductGroupMapList(productGroupMap);
        return getDataTable(list);
    }

    /**
     * 导出商品分组对应关系列表
     */
    @RequiresPermissions("shop:productGroupMap:export")
    @Log(title = "商品分组对应关系", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ProductGroupMap productGroupMap)
    {
        List<ProductGroupMap> list = productGroupMapService.selectProductGroupMapList(productGroupMap);
        ExcelUtil<ProductGroupMap> util = new ExcelUtil<ProductGroupMap>(ProductGroupMap.class);
        util.exportExcel(response, list, "商品分组对应关系数据");
    }

    /**
     * 获取商品分组对应关系详细信息
     */
    @RequiresPermissions("shop:productGroupMap:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return AjaxResult.success(productGroupMapService.selectProductGroupMapById(id));
    }

    /**
     * 新增商品分组对应关系
     */
    @RequiresPermissions("shop:productGroupMap:add")
    @Log(title = "商品分组对应关系", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ProductGroupMap productGroupMap)
    {
        return toAjax(productGroupMapService.insertProductGroupMap(productGroupMap));
    }

    /**
     * 修改商品分组对应关系
     */
    @RequiresPermissions("shop:productGroupMap:edit")
    @Log(title = "商品分组对应关系", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ProductGroupMap productGroupMap)
    {
        return toAjax(productGroupMapService.updateProductGroupMap(productGroupMap));
    }

    /**
     * 删除商品分组对应关系
     */
    @RequiresPermissions("shop:productGroupMap:remove")
    @Log(title = "商品分组对应关系", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(productGroupMapService.deleteProductGroupMapByIds(ids));
    }
}

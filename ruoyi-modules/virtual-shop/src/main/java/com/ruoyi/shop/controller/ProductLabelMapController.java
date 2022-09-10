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
import com.ruoyi.shop.domain.ProductLabelMap;
import com.ruoyi.shop.service.IProductLabelMapService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 商品标签对应关系Controller
 * 
 * @author xiaoming
 * @date 2022-08-07
 */
@RestController
@RequestMapping("/productLabelMap")
public class ProductLabelMapController extends BaseController
{
    @Autowired
    private IProductLabelMapService productLabelMapService;

    /**
     * 查询商品标签对应关系列表
     */
    @RequiresPermissions("shop:productLabelMap:list")
    @GetMapping("/list")
    public TableDataInfo list(ProductLabelMap productLabelMap)
    {
        startPage();
        List<ProductLabelMap> list = productLabelMapService.selectProductLabelMapList(productLabelMap);
        return getDataTable(list);
    }

    /**
     * 导出商品标签对应关系列表
     */
    @RequiresPermissions("shop:productLabelMap:export")
    @Log(title = "商品标签对应关系", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ProductLabelMap productLabelMap)
    {
        List<ProductLabelMap> list = productLabelMapService.selectProductLabelMapList(productLabelMap);
        ExcelUtil<ProductLabelMap> util = new ExcelUtil<ProductLabelMap>(ProductLabelMap.class);
        util.exportExcel(response, list, "商品标签对应关系数据");
    }

    /**
     * 获取商品标签对应关系详细信息
     */
    @RequiresPermissions("shop:productLabelMap:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return AjaxResult.success(productLabelMapService.selectProductLabelMapById(id));
    }

    /**
     * 新增商品标签对应关系
     */
    @RequiresPermissions("shop:productLabelMap:add")
    @Log(title = "商品标签对应关系", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ProductLabelMap productLabelMap)
    {
        return toAjax(productLabelMapService.insertProductLabelMap(productLabelMap));
    }

    /**
     * 修改商品标签对应关系
     */
    @RequiresPermissions("shop:productLabelMap:edit")
    @Log(title = "商品标签对应关系", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ProductLabelMap productLabelMap)
    {
        return toAjax(productLabelMapService.updateProductLabelMap(productLabelMap));
    }

    /**
     * 删除商品标签对应关系
     */
    @RequiresPermissions("shop:productLabelMap:remove")
    @Log(title = "商品标签对应关系", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(productLabelMapService.deleteProductLabelMapByIds(ids));
    }
}

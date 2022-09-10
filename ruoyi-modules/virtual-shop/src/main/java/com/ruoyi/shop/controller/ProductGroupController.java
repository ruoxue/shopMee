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
import com.ruoyi.shop.domain.ProductGroup;
import com.ruoyi.shop.service.IProductGroupService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 商品分组Controller
 * 
 * @author xiaoming
 * @date 2022-08-07
 */
@RestController
@RequestMapping("/productGroup")
public class ProductGroupController extends BaseController
{
    @Autowired
    private IProductGroupService productGroupService;

    /**
     * 查询商品分组列表
     */
    @RequiresPermissions("shop:productGroup:list")
    @GetMapping("/list")
    public TableDataInfo list(ProductGroup productGroup)
    {
        startPage();
        List<ProductGroup> list = productGroupService.selectProductGroupList(productGroup);
        return getDataTable(list);
    }

    /**
     * 导出商品分组列表
     */
    @RequiresPermissions("shop:productGroup:export")
    @Log(title = "商品分组", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ProductGroup productGroup)
    {
        List<ProductGroup> list = productGroupService.selectProductGroupList(productGroup);
        ExcelUtil<ProductGroup> util = new ExcelUtil<ProductGroup>(ProductGroup.class);
        util.exportExcel(response, list, "商品分组数据");
    }

    /**
     * 获取商品分组详细信息
     */
    @RequiresPermissions("shop:productGroup:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(productGroupService.selectProductGroupById(id));
    }

    /**
     * 新增商品分组
     */
    @RequiresPermissions("shop:productGroup:add")
    @Log(title = "商品分组", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ProductGroup productGroup)
    {
        return toAjax(productGroupService.insertProductGroup(productGroup));
    }

    /**
     * 修改商品分组
     */
    @RequiresPermissions("shop:productGroup:edit")
    @Log(title = "商品分组", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ProductGroup productGroup)
    {
        return toAjax(productGroupService.updateProductGroup(productGroup));
    }

    /**
     * 删除商品分组
     */
    @RequiresPermissions("shop:productGroup:remove")
    @Log(title = "商品分组", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(productGroupService.deleteProductGroupByIds(ids));
    }
}

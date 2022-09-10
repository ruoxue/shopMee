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
import com.ruoyi.shop.domain.ProductCategory;
import com.ruoyi.shop.service.IProductCategoryService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 商品分类Controller
 *
 * @author xiaoming
 * @date 2022-08-07
 */
@RestController
@RequestMapping("/productCategory")
public class ProductCategoryController extends BaseController {
    @Autowired
    private IProductCategoryService productCategoryService;

    @InnerAuth
    @PostMapping("/fegin/list")
    public TableDataInfo listf(@RequestBody ProductCategory productCategory) {
        if (productCategory.getTree() == null || productCategory.getTree() != 1) {
            startPage(productCategory.getPageSize(), productCategory.getPageNum());
        }

        List<ProductCategory> list = productCategoryService.selectProductCategoryList(productCategory);
        return getDataTable(list);
    }

    /**
     * 查询商品分类列表
     */
    @RequiresPermissions("shop:productCategory:list")
    @GetMapping("/list")
    public TableDataInfo list(ProductCategory productCategory) {

        if (productCategory.getTree() == null || productCategory.getTree() != 1) {
            startPage();

        }
        List<ProductCategory> list = productCategoryService.selectProductCategoryList(productCategory);
        return getDataTable(list);
    }

    /**
     * 导出商品分类列表
     */
    @RequiresPermissions("shop:productCategory:export")
    @Log(title = "商品分类", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ProductCategory productCategory) {
        List<ProductCategory> list = productCategoryService.selectProductCategoryList(productCategory);
        ExcelUtil<ProductCategory> util = new ExcelUtil<ProductCategory>(ProductCategory.class);
        util.exportExcel(response, list, "商品分类数据");
    }

    /**
     * 获取商品分类详细信息
     */
    @RequiresPermissions("shop:productCategory:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id) {
        return AjaxResult.success(productCategoryService.selectProductCategoryById(id));
    }

    /**
     * 新增商品分类
     */
    @RequiresPermissions("shop:productCategory:add")
    @Log(title = "商品分类", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ProductCategory productCategory) {
        return toAjax(productCategoryService.insertProductCategory(productCategory));
    }

    /**
     * 修改商品分类
     */
    @RequiresPermissions("shop:productCategory:edit")
    @Log(title = "商品分类", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ProductCategory productCategory) {
        return toAjax(productCategoryService.updateProductCategory(productCategory));
    }

    /**
     * 删除商品分类
     */
    @RequiresPermissions("shop:productCategory:remove")
    @Log(title = "商品分类", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids) {
        return toAjax(productCategoryService.deleteProductCategoryByIds(ids));
    }
}

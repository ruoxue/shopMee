package com.ruoyi.shop.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.security.annotation.InnerAuth;
import com.ruoyi.shop.domain.ProductShop;
import com.ruoyi.shop.domain.ProductVO;
import com.ruoyi.shop.param.ProductPO;
import com.ruoyi.shop.service.IProductShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.log.annotation.Log;
import com.ruoyi.common.log.enums.BusinessType;
import com.ruoyi.common.security.annotation.RequiresPermissions;
import com.ruoyi.shop.domain.Product;
import com.ruoyi.shop.service.IProductService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 商品基础信息Controller
 *
 * @author xiaoming
 * @date 2022-08-07
 */
@RestController
@RequestMapping("/product")
public class ProductController extends BaseController {
    @Autowired
    private IProductShopService productShopService;
    @Autowired
    private IProductService productService;

    @InnerAuth
    @PostMapping("/fegin/list")
    public TableDataInfo listf(@RequestBody ProductPO product) {
        startPage(product.getPageSize(), product.getPageNum());
        List<ProductVO> list = productService.selectProductList(product);
        return getDataTable(list);
    }

    @InnerAuth
    @GetMapping(value = "/fegin/{id}")
    public ProductVO getInfof(@PathVariable("id") Long id) {
        return (productService.selectProductById(id));
    }


    @InnerAuth
    @Log(title = "商品基础信息", businessType = BusinessType.INSERT)
    @PostMapping("/fegin")
    public AjaxResult addf(@RequestBody ProductPO product) {
        return toAjax(productService.insertProduct(product,
                product.getCategoryId()));
    }


    /**
     * 修改商品基础信息
     */
    @InnerAuth
    @Log(title = "商品基础信息", businessType = BusinessType.UPDATE)
    @PutMapping("/fegin")
    public AjaxResult editf(@RequestBody ProductPO product) {
        return toAjax(productService.updateProduct(product));
    }

    /**
     * 删除商品基础信息
     */
    @InnerAuth
    @Log(title = "商品基础信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/fegin/{ids}")
    public AjaxResult removef(@PathVariable Long[] ids) {
        return toAjax(productService.deleteProductByIds(ids));
    }


    /**
     * 查询商品基础信息列表
     */
    @RequiresPermissions("shop:product:list")
    @GetMapping("/list")
    public TableDataInfo list(ProductPO product) {
        startPage();
        List<ProductVO> list = productService.selectProductList(product);
        return getDataTable(list);
    }

    /**
     * 导出商品基础信息列表  pageNum=1&pageSize=10
     * index=1&total=2&pageSize=10&pageNum=2
     */
    @RequiresPermissions("shop:product:export")
    @Log(title = "商品基础信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ProductPO product) {
        List<ProductVO> list = productService.selectProductList(product);
        ExcelUtil<ProductVO> util = new ExcelUtil<ProductVO>(ProductVO.class);
        util.exportExcel(response, list, "商品基础信息数据");
    }

    /**
     * 获取商品基础信息详细信息
     */
    @RequiresPermissions("shop:product:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(productService.selectProductById(id));
    }

    /**
     * 新增商品基础信息
     */
    @RequiresPermissions("shop:product:add")
    @Log(title = "商品基础信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ProductPO product) {
        return toAjax(productService.insertProduct(product,
                product.getCategoryId()));
    }

    /**
     * 修改商品基础信息
     */
    @RequiresPermissions("shop:product:edit")
    @Log(title = "商品基础信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ProductPO product) {
        return toAjax(productService.updateProduct(product));
    }

    /**
     * 删除商品基础信息
     */
    @RequiresPermissions("shop:product:remove")
    @Log(title = "商品基础信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(productService.deleteProductByIds(ids));
    }
}

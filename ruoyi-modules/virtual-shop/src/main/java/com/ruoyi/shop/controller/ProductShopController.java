package com.ruoyi.shop.controller;

import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.core.constant.SecurityConstants;
import com.ruoyi.common.security.annotation.InnerAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.log.annotation.Log;
import com.ruoyi.common.log.enums.BusinessType;
import com.ruoyi.common.security.annotation.RequiresPermissions;
import com.ruoyi.shop.domain.ProductShop;
import com.ruoyi.shop.service.IProductShopService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 商户店铺Controller
 * 
 * @author xiaoming
 * @date 2022-08-10
 */
@RestController
@RequestMapping("/productShop")
public class ProductShopController extends BaseController
{
    @Autowired
    private IProductShopService productShopService;

    @PostMapping("/fegin/shop")
    public TableDataInfo shopF(@RequestBody ProductShop productShop)
    {
       // System.out.println("productShop = " + productShop);
        startPage(productShop.getPageSize(),productShop.getPageNum());
        List<ProductShop> list = productShopService.selectProductShopList(productShop);
        return getDataTable(list);
    }


    @InnerAuth
    @PostMapping("/fegin/addShop")
    AjaxResult addShop(@RequestBody ProductShop productShop, @RequestHeader(SecurityConstants.FROM_SOURCE) String inner){
        System.out.println("productShop = " + productShop);
        return  AjaxResult.success(productShopService.insertProductShop(productShop));
    }
    @InnerAuth
    @PutMapping("/fegin/editShop")
    AjaxResult editShop(@RequestBody ProductShop productShop, @RequestHeader(SecurityConstants.FROM_SOURCE) String inner){
        return  AjaxResult.success(productShopService.updateProductShop(productShop));

    }
    @InnerAuth
    @DeleteMapping("/fegin/delShop/{shopId}")
    AjaxResult delShop(@PathVariable("shopId") Long shopId, @RequestHeader(SecurityConstants.FROM_SOURCE) String inner){
        return  AjaxResult.success(productShopService.deleteProductShopByShopId(shopId));

    }
    /**
     * 查询商户店铺列表
     */
    @RequiresPermissions("shop:productShop:list")
    @GetMapping("/list")
    public TableDataInfo list(ProductShop productShop)
    {
        startPage();
        List<ProductShop> list = productShopService.selectProductShopList(productShop);
        return getDataTable(list);
    }

    /**
     * 导出商户店铺列表
     */
    @RequiresPermissions("shop:productShop:export")
    @Log(title = "商户店铺", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ProductShop productShop)
    {
        List<ProductShop> list = productShopService.selectProductShopList(productShop);
        ExcelUtil<ProductShop> util = new ExcelUtil<ProductShop>(ProductShop.class);
        util.exportExcel(response, list, "商户店铺数据");
    }

    /**
     * 获取商户店铺详细信息
     */
    @RequiresPermissions("shop:productShop:query")
    @GetMapping(value = "/{shopId}")
    public AjaxResult getInfo(@PathVariable("shopId") Long shopId)
    {
        return AjaxResult.success(productShopService.selectProductShopByShopId(shopId));
    }


    /**
     * 新增商户店铺
     */
    @RequiresPermissions("shop:productShop:add")
    @Log(title = "商户店铺", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ProductShop productShop)
    {
        return toAjax(productShopService.insertProductShop(productShop));
    }

    /**
     * 修改商户店铺
     */
    @RequiresPermissions("shop:productShop:edit")
    @Log(title = "商户店铺", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ProductShop productShop)
    {
        return toAjax(productShopService.updateProductShop(productShop));
    }

    /**
     * 删除商户店铺
     */
    @RequiresPermissions("shop:productShop:remove")
    @Log(title = "商户店铺", businessType = BusinessType.DELETE)
	@DeleteMapping("/{shopIds}")
    public AjaxResult remove(@PathVariable Long[] shopIds)
    {
        return toAjax(productShopService.deleteProductShopByShopIds(shopIds));
    }
}

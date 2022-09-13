package com.ruoyi.mobile.controller;

import com.ruoyi.common.core.constant.SecurityConstants;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.web.page.TableDataInfo;
import com.ruoyi.common.log.annotation.Log;
import com.ruoyi.common.log.enums.BusinessType;
import com.ruoyi.common.security.annotation.RequiresLogin;
import com.ruoyi.common.security.annotation.RequiresPermissions;
import com.ruoyi.common.security.utils.SecurityUtils;
import com.ruoyi.mobile.service.IProductService;
import com.ruoyi.shop.domain.Product;
import com.ruoyi.shop.domain.ProductCategory;
import com.ruoyi.shop.domain.ProductShop;
import com.ruoyi.shop.param.ProductPO;
import com.ruoyi.system.api.RemoteProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * 商品基础信息Controller
 *
 * @author xiaoming
 * @date 2022-08-08
 */
@RestController
@RequestMapping("/productShop")
public class ProductShopController extends BaseController {
    @Autowired
    private IProductService productService;

    @Autowired
    private RemoteProductService remoteProductService;


    @RequiresLogin
    @GetMapping("/shop")
    public TableDataInfo getShop(ProductShop productShop) {
      //  System.out.println("productShop = " + productShop);
        productShop.setUserId(SecurityUtils.getLoginUser().getUserid());
        return remoteProductService.getShop(productShop, SecurityConstants.INNER);
    }

    @RequiresLogin
    @PostMapping("/shop")
    public AjaxResult addShop(@RequestBody  ProductShop productShop) {
        productShop.setUserId(  SecurityUtils.getLoginUser().getUserid() );
        productShop.setUpdatedTime(new Date());
        productShop.setCreatedTime(new Date());
        productShop.setShopStatus(null);
        return remoteProductService.addShop(productShop, SecurityConstants.INNER);
    }

    @RequiresLogin
    @PutMapping("/shop")
    public AjaxResult editShop(@RequestBody  ProductShop productShop) {
        productShop.setUserId(SecurityUtils.getLoginUser().getUserid() );
        productShop.setUpdatedTime(new Date());
        productShop.setShopStatus(null);
        return remoteProductService.editShop(productShop, SecurityConstants.INNER);
    }
    @RequiresLogin
    @DeleteMapping("/shop/{id}")
    public AjaxResult delShop(@PathVariable("id") Long id) {

        return remoteProductService.delShop(id, SecurityConstants.INNER);
    }


}

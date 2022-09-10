package com.ruoyi.mobile.controller;

import com.ruoyi.common.core.constant.SecurityConstants;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.page.TableDataInfo;
import com.ruoyi.mobile.service.IProductService;
import com.ruoyi.shop.domain.ProductCategory;
import com.ruoyi.shop.domain.ProductShop;
import com.ruoyi.system.api.RemoteProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 商品基础信息Controller
 *
 * @author xiaoming
 * @date 2022-08-08
 */
@RestController
@RequestMapping("/productCategory")
public class ProductCategoryController extends BaseController {
    @Autowired
    private IProductService productService;

    @Autowired
    private RemoteProductService remoteProductService;


    @GetMapping("/category")
    public TableDataInfo category(ProductCategory product) {
//        System.out.println("product = " + product);
        return remoteProductService.category(product, SecurityConstants.INNER);
    }


}

package com.ruoyi.mobile.controller;

import com.ruoyi.common.core.constant.SecurityConstants;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.web.page.TableDataInfo;
import com.ruoyi.common.security.annotation.RequiresLogin;
import com.ruoyi.common.security.utils.SecurityUtils;
import com.ruoyi.mobile.service.IProductService;
import com.ruoyi.shop.domain.ProductShop;
import com.ruoyi.shop.domain.ProductSku;
import com.ruoyi.system.api.RemoteProductService;
import com.ruoyi.system.api.RemoteProductSkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 商品基础信息Controller
 *
 * @author xiaoming
 * @date 2022-08-08
 */
@RestController
@RequestMapping("/productSku")
public class ProductSkuController extends BaseController {
    @Autowired
    private IProductService productService;

    @Autowired
    private RemoteProductSkuService   remoteProductSkuService;

    @GetMapping("/{goodsId}")
    public TableDataInfo getSKuByGoods(@PathVariable("goodsId") Integer goodsId) {
        return  (remoteProductSkuService.getSKuByGoods(goodsId,SecurityConstants.INNER));
    }


}

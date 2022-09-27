package com.ruoyi.mobile.controller;

import com.ruoyi.common.core.constant.SecurityConstants;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.web.page.TableDataInfo;
import com.ruoyi.common.security.annotation.RequiresLogin;
import com.ruoyi.common.security.utils.SecurityUtils;
import com.ruoyi.mobile.domain.SpecVO;
import com.ruoyi.mobile.service.IProductService;
import com.ruoyi.shop.domain.ProductShop;
import com.ruoyi.shop.domain.ProductSku;
import com.ruoyi.shop.domain.ProductSpecTitle;
import com.ruoyi.system.api.RemoteProductService;
import com.ruoyi.system.api.RemoteProductSkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    @GetMapping("/sku/{goodsId}")
    public TableDataInfo getSKuByGoods(@PathVariable("goodsId") Integer goodsId) {
        return  (remoteProductSkuService.getSKuByGoods(goodsId,SecurityConstants.INNER));
    }

    @GetMapping("/spec/{goodsId}")
    public TableDataInfo getSpec(@PathVariable("goodsId") Long goodsId) {
        ProductSpecTitle productSpecTitle=new ProductSpecTitle();
        productSpecTitle.setGoodsId(goodsId);
        Map<String, List<ProductSpecTitle>> spec = remoteProductSkuService.getSpec(productSpecTitle, SecurityConstants.INNER);

        List<SpecVO> specVOS=new ArrayList<>();
        for (Map.Entry<String, List<ProductSpecTitle>> e: spec.entrySet()){
            SpecVO specVO=new SpecVO();
            specVO.setList(e.getValue());
            specVO.setName(e.getKey());
            specVOS.add(specVO);

        } 

        return  getDataTable(specVOS);
    }
}

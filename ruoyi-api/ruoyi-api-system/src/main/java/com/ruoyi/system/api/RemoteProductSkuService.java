package com.ruoyi.system.api;

import com.ruoyi.common.core.constant.SecurityConstants;
import com.ruoyi.common.core.constant.ServiceNameConstants;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.web.page.TableDataInfo;
import com.ruoyi.shop.domain.ProductCategory;
import com.ruoyi.shop.domain.ProductShop;
import com.ruoyi.shop.domain.ProductSku;
import com.ruoyi.shop.domain.ProductSpecTitle;
import com.ruoyi.shop.param.ProductPO;
import com.ruoyi.system.api.factory.RemoteProductSkuFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@FeignClient(contextId = "remoteProductSkuService", value = ServiceNameConstants.SHOP_SERVICE,fallbackFactory = RemoteProductSkuFallbackFactory.class)
public interface RemoteProductSkuService {


    /**
     * 获取商品基础信息详细信息
     */
    @GetMapping(value = "/productSku/remote/{id}")
    public ProductSku getInfo(@PathVariable("id") Long id, @RequestHeader(SecurityConstants.FROM_SOURCE) String source);

    /**
     * 新增商品基础信息
     */
    @PostMapping(value = "/product/fegin")
    public AjaxResult add(@RequestBody ProductPO product, @RequestHeader(SecurityConstants.FROM_SOURCE) String source);


    /**
     * 修改商品基础信息
     */
    @PutMapping(value = "/product/fegin")
    public AjaxResult edit(@RequestBody ProductPO product, @RequestHeader(SecurityConstants.FROM_SOURCE) String source);

    @DeleteMapping("/product/fegin/{ids}")
    public AjaxResult remove(@PathVariable("ids") Long[] ids, @RequestHeader(SecurityConstants.FROM_SOURCE) String source);

    @PostMapping("/productCategory/fegin/list")
    public TableDataInfo category(@RequestBody ProductCategory product, @RequestHeader(SecurityConstants.FROM_SOURCE) String source);

    @GetMapping(value = "/productSku/fegin/{goodsId}")
    TableDataInfo getSKuByGoods(@PathVariable("goodsId") Integer goodsId, @RequestHeader(SecurityConstants.FROM_SOURCE) String source );
    @GetMapping("/productSpecTitle/list/fegin")
    public Map<String,List<ProductSpecTitle>> getSpec(@RequestBody ProductSpecTitle productSpecTitle, @RequestHeader(SecurityConstants.FROM_SOURCE) String inner);

}

package com.ruoyi.system.api;

import com.ruoyi.common.core.constant.SecurityConstants;
import com.ruoyi.common.core.constant.ServiceNameConstants;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.web.page.TableDataInfo;
import com.ruoyi.shop.domain.ProductCategory;
import com.ruoyi.shop.domain.ProductShop;
import com.ruoyi.shop.param.ProductPO;
import com.ruoyi.system.api.factory.RemoteProductFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(contextId = "remoteProductService", value = ServiceNameConstants.SHOP_SERVICE,fallbackFactory = RemoteProductFallbackFactory.class)
public interface RemoteProductService {
    @PostMapping("/product/fegin/list")
    public TableDataInfo list(@RequestBody ProductPO product, @RequestHeader(SecurityConstants.FROM_SOURCE) String source);
    @PostMapping("/productShop/fegin/shop")
    public TableDataInfo getShop(ProductShop productShop, @RequestHeader(SecurityConstants.FROM_SOURCE) String source) ;

    /**
     * 导出商品基础信息列表
     */

//    @PostMapping("/export")
//    public void export(HttpServletResponse response,@RequestBody Product product);

    /**
     * 获取商品基础信息详细信息
     */
    @GetMapping(value = "/product/fegin/{id}")
    public ProductPO getInfo(@PathVariable("id") Long id, @RequestHeader(SecurityConstants.FROM_SOURCE) String source);

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

    @PostMapping("/productShop/fegin/addShop")
    AjaxResult addShop(@RequestBody ProductShop productShop, @RequestHeader(SecurityConstants.FROM_SOURCE) String inner);

    @PutMapping("/productShop/fegin/editShop")
    AjaxResult editShop(@RequestBody ProductShop productShop, @RequestHeader(SecurityConstants.FROM_SOURCE) String inner);

    @DeleteMapping  ("/productShop/fegin/delShop/{id}")
    AjaxResult delShop(@PathVariable("id") Long id, @RequestHeader(SecurityConstants.FROM_SOURCE) String inner);
}

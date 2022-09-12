package com.ruoyi.system.api;

import com.ruoyi.common.core.constant.SecurityConstants;
import com.ruoyi.common.core.constant.ServiceNameConstants;
import com.ruoyi.shop.domain.BuyerAddress;
import com.ruoyi.shop.domain.BuyerOrder;
import com.ruoyi.shop.domain.OrderBasicVO;
import com.ruoyi.shop.domain.OrderPO;
import com.ruoyi.system.api.factory.RemoteOrderFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 文件服务
 *
 * @author ruoyi
 */
@FeignClient(contextId = "remoteAddressService", value = ServiceNameConstants.SHOP_SERVICE,
        fallbackFactory = RemoteOrderFallbackFactory.class)
public interface RemoteAddressService {


    @PostMapping(value = "/buyerAddress/list/fegin")
    List<BuyerAddress> selectBuyerAddressList(@RequestBody BuyerAddress buyerAddress, @RequestHeader(SecurityConstants.FROM_SOURCE) String inner);

    @GetMapping(value = "/buyerAddress/fegin/{addressId}")
    BuyerAddress selectBuyerAddressByAddressId(@PathVariable("addressId") Long addressId, @RequestHeader(SecurityConstants.FROM_SOURCE) String inner);

    @PostMapping(value = "/buyerAddress/fegin")
    int insertBuyerAddress(@RequestBody BuyerAddress buyerAddress, @RequestHeader(SecurityConstants.FROM_SOURCE) String inner);

    @PutMapping(value = "/buyerAddress/fegin")
    int updateBuyerAddress(@RequestBody BuyerAddress buyerAddress, @RequestHeader(SecurityConstants.FROM_SOURCE) String inner);

    @DeleteMapping("/buyerAddress/fegin/{addressIds}")
    int deleteBuyerAddressByAddressId(@PathVariable("addressId") Long addressId, @RequestHeader(SecurityConstants.FROM_SOURCE) String inner);
}

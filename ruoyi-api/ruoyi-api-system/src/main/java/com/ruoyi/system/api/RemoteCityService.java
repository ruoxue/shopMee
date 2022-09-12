package com.ruoyi.system.api;

import com.ruoyi.common.core.constant.SecurityConstants;
import com.ruoyi.common.core.constant.ServiceNameConstants;
import com.ruoyi.shop.domain.BuyerOrder;
import com.ruoyi.shop.domain.OrderBasicVO;
import com.ruoyi.shop.domain.OrderPO;
import com.ruoyi.system.api.factory.RemoteOrderFallbackFactory;
import feign.Body;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 文件服务
 * 
 * @author ruoyi
 */
@FeignClient(contextId = "remoteCityService", value = ServiceNameConstants.SHOP_SERVICE,
        fallbackFactory = RemoteOrderFallbackFactory.class)
public interface RemoteCityService
{

    @PostMapping("/city/list/fegin")
    List<com.ruoyi.shop.domain.City> selectCityList(@RequestBody com.ruoyi.shop.domain.City city, @RequestHeader(SecurityConstants.FROM_SOURCE) String inner);
}

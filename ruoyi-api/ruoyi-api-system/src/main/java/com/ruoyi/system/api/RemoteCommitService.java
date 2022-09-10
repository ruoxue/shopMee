//package com.ruoyi.system.api;
//
//import com.ruoyi.common.core.constant.SecurityConstants;
//import com.ruoyi.common.core.constant.ServiceNameConstants;
//import com.ruoyi.shop.domain.OrderPO;
//import com.ruoyi.shop.domain.BuyerOrder;
//import com.ruoyi.system.api.factory.RemoteOrderFallbackFactory;
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
///**
// * 文件服务
// *
// * @author ruoyi
// */
//@FeignClient(contextId = "remoteOrderService", value = ServiceNameConstants.ORDER_SERVICE,
//        fallbackFactory = RemoteOrderFallbackFactory.class)
//public interface RemoteCommitService
//{
//    @GetMapping(value = "/buyerOrder/fegin")
//    String commitOrderPay( @RequestHeader(SecurityConstants.FROM_SOURCE) String source);
//
//}

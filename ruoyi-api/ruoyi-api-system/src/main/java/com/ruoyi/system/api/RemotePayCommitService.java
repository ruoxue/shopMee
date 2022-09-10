package com.ruoyi.system.api;

import com.ruoyi.common.core.constant.SecurityConstants;
import com.ruoyi.common.core.constant.ServiceNameConstants;
import com.ruoyi.common.core.web.page.TableDataInfo;
import com.ruoyi.shop.domain.PayCommit;
import com.ruoyi.system.api.factory.RemoteOrderFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(contextId = "remotePayCommitService", value = ServiceNameConstants.SHOP_SERVICE,
        fallbackFactory = RemoteOrderFallbackFactory.class)
public interface RemotePayCommitService {
    @PostMapping(value = "/payCommit/list/fegin")
    TableDataInfo selectPayCommitList(@RequestBody PayCommit buyerOrder, @RequestHeader(SecurityConstants.FROM_SOURCE) String source);

}

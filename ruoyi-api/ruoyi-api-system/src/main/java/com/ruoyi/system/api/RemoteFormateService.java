package com.ruoyi.system.api;

import com.ruoyi.common.core.constant.SecurityConstants;
import com.ruoyi.common.core.constant.ServiceNameConstants;
import com.ruoyi.common.core.web.page.TableDataInfo;
import com.ruoyi.system.api.factory.RemoteOrderFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

/**
 * 文件服务
 *
 * @author ruoyi
 */
@FeignClient(contextId = "remoteFormateService", value = ServiceNameConstants.SHOP_SERVICE,
        fallbackFactory = RemoteOrderFallbackFactory.class)
public interface RemoteFormateService {
    @GetMapping("/payCommitFormate/list/fegin")
    public TableDataInfo listFegin(@RequestHeader(SecurityConstants.FROM_SOURCE) String inner);

}

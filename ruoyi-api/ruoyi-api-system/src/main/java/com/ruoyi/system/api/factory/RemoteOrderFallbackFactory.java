package com.ruoyi.system.api.factory;

import com.ruoyi.system.api.RemoteOrderService;
import com.ruoyi.system.api.RemoteUserService;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class RemoteOrderFallbackFactory implements FallbackFactory<RemoteOrderService> {
    @Override
    public RemoteOrderService create(Throwable cause) {
        return null;
    }
}

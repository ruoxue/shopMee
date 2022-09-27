package com.ruoyi.system.api.factory;

import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.web.page.TableDataInfo;
import com.ruoyi.shop.domain.ProductCategory;
import com.ruoyi.shop.domain.ProductShop;
import com.ruoyi.shop.domain.ProductSku;
import com.ruoyi.shop.domain.ProductSpecTitle;
import com.ruoyi.shop.param.ProductPO;
import com.ruoyi.system.api.RemoteProductService;
import com.ruoyi.system.api.RemoteProductSkuService;
import org.springframework.cloud.openfeign.FallbackFactory;

import java.util.List;
import java.util.Map;

public class RemoteProductSkuFallbackFactory  implements FallbackFactory<RemoteProductSkuService> {

    @Override
    public RemoteProductSkuService create(Throwable cause) {
        return new RemoteProductSkuService() {

            @Override
            public ProductSku getInfo(Long id, String source) {
                return null;
            }

            @Override
            public AjaxResult add(ProductPO product, String source) {
                return null;
            }

            @Override
            public AjaxResult edit(ProductPO product, String source) {
                return null;
            }

            @Override
            public AjaxResult remove(Long[] ids, String source) {
                return null;
            }

            @Override
            public TableDataInfo category(ProductCategory product, String source) {
                return null;
            }

            @Override
            public TableDataInfo getSKuByGoods(Integer goodsId, String source) {
                return null;
            }

            @Override
            public Map<String, List<ProductSpecTitle>> getSpec(ProductSpecTitle productSpecTitle, String inner) {
                return null;
            }
        };
    }
}

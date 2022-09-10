package com.ruoyi.system.api.factory;

import com.ruoyi.common.core.constant.SecurityConstants;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.web.page.TableDataInfo;
import com.ruoyi.shop.domain.Product;
import com.ruoyi.shop.domain.ProductCategory;
import com.ruoyi.shop.domain.ProductShop;
import com.ruoyi.shop.param.ProductPO;
import com.ruoyi.system.api.RemoteProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;


@Component
public class RemoteProductFallbackFactory implements FallbackFactory<RemoteProductService>
{
    private static final Logger log = LoggerFactory.getLogger(RemoteProductFallbackFactory.class);

    @Override
    public RemoteProductService create(Throwable throwable)
    {
        log.error("商品服务调用失败:{}", throwable.getMessage());
        return new RemoteProductService()
        {

            @Override
            public TableDataInfo list(ProductPO product,String   INNER) {
                return null;
            }

            @Override
            public TableDataInfo getShop(ProductShop productShop, String source) {
                return null;
            }

            @Override
            public ProductPO getInfo(Long id, String source) {
                return null;
            }

//            @Override
//            public void export(HttpServletResponse response, Product product) {
//
//            }


            @Override
            public AjaxResult add(ProductPO product,String   INNER) {
                return null;
            }

            @Override
            public AjaxResult edit(ProductPO product, String source) {
                return null;
            }


            @Override
            public AjaxResult remove(Long[] ids,String   INNER) {
                return null;
            }

            @Override
            public TableDataInfo category(ProductCategory product, String source) {
                return null;
            }

            @Override
            public AjaxResult addShop(ProductShop productShop, String inner) {
                return null;
            }

            @Override
            public AjaxResult editShop(ProductShop productShop, String inner) {
                return null;
            }

            @Override
            public AjaxResult delShop(Long id, String inner) {
                return null;
            }


        };

    }
}

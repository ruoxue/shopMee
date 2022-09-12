package com.ruoyi.mobile.controller;

import com.ruoyi.common.core.constant.SecurityConstants;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.web.page.TableDataInfo;
import com.ruoyi.common.log.annotation.Log;
import com.ruoyi.common.log.enums.BusinessType;
import com.ruoyi.common.security.annotation.RequiresLogin;
import com.ruoyi.common.security.utils.SecurityUtils;
import com.ruoyi.shop.domain.OrderBasicVO;
import com.ruoyi.shop.domain.OrderPO;
import com.ruoyi.shop.domain.BuyerOrder;
import com.ruoyi.system.api.RemoteOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 订单Controller
 *
 * @author xiaoming
 * @date 2022-08-08
 */
@RestController
@RequestMapping("/buyerOrder")
public class BuyerOrderController extends BaseController {

    @Autowired
    private RemoteOrderService remoteOrderService;

    /**
     * 购买
     *
     * @param buyerOrder
     * @return
     */
    @RequiresLogin
    @GetMapping("/buyList")
    public TableDataInfo buyList(BuyerOrder buyerOrder) {

        Long userId = SecurityUtils.getLoginUser().getUserid();
        buyerOrder.setUserId(String.valueOf(userId));
        List<OrderPO> list = remoteOrderService.selectOrderList(buyerOrder, SecurityConstants.INNER);
        return getDataTable(list);
    }

    /**
     * 出售
     *
     * @param buyerOrder
     * @return
     */
    @RequiresLogin
    @GetMapping("/saleList")
    public TableDataInfo saleList(BuyerOrder buyerOrder) {

        Long userId = SecurityUtils.getLoginUser().getUserid();
        buyerOrder.setUserId(String.valueOf(userId));
        List<OrderPO> list = remoteOrderService.selectSaleOrderList(buyerOrder, SecurityConstants.INNER);
        return getDataTable(list);
    }
    @RequiresLogin
    @GetMapping("/basicInfo")
    public AjaxResult basicInfo( ) {
        Long userId = SecurityUtils.getLoginUser().getUserid();

        List<OrderBasicVO>  stringStringMap = remoteOrderService.basicInfo(String.valueOf(userId), SecurityConstants.INNER);
        Map<String, Integer> collect = stringStringMap.stream().collect(Collectors.toMap(
                OrderBasicVO::getOrderStatus,
                OrderBasicVO::getOrderCount
        ));


        return AjaxResult.success(collect);
    }


    /**
     *
     */
    @RequiresLogin
    @Log(title = "订单", businessType = BusinessType.UPDATE)
	@PutMapping
    public AjaxResult update(@RequestBody BuyerOrder buyerOrder)
    {
        return toAjax(remoteOrderService.update(buyerOrder, SecurityConstants.INNER));
    }
}

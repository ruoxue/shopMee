package com.ruoyi.order.controller;

import java.util.List;

import com.ruoyi.common.core.constant.SecurityConstants;
import com.ruoyi.common.security.annotation.InnerAuth;
import com.ruoyi.common.security.annotation.RequiresLogin;
import com.ruoyi.common.security.utils.SecurityUtils;
import com.ruoyi.shop.domain.OrderPO;
import com.ruoyi.shop.domain.BuyerOrder;
import com.ruoyi.system.api.RemoteOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.log.annotation.Log;
import com.ruoyi.common.log.enums.BusinessType;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 订单Controller
 *
 * @author xiaoming
 * @date 2022-08-18
 */
@RestController
@RequestMapping("/buyerOrder")
public class BuyerOrderController extends BaseController {

    @Autowired
    private RemoteOrderService remoteOrderService;


    @InnerAuth
    @PostMapping("/fegin")
    public String fegin() {

        return "";
    }


    /**
     * 查询订单列表
     */
    @RequiresLogin
    @PostMapping("/list")
    public TableDataInfo list(@RequestBody BuyerOrder buyerOrder) {
        buyerOrder.setUserId(SecurityUtils.getLoginUser().getUserid() + "");
        List<OrderPO> list = remoteOrderService.selectBuyerOrderList(buyerOrder, SecurityConstants.INNER);
        return getDataTable(list);
    }


    /**
     * 获取订单详细信息
     */
    @RequiresLogin
    @GetMapping(value = "/{orderId}")
    public AjaxResult getInfo(@PathVariable("orderId") String orderId) {
        return AjaxResult.success("", remoteOrderService.getInfo(orderId, SecurityConstants.INNER));
    }

    /**
     * 新增订单
     */
    @RequiresLogin
    @Log(title = "订单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody OrderPO buyerOrder) {
        buyerOrder.setUserId(SecurityUtils.getLoginUser().getUserid() + "");
        String s = remoteOrderService.insertBuyerOrder(buyerOrder, SecurityConstants.INNER);
        if (s != null && s.startsWith("Z"))
            return AjaxResult.success("ok", s);
        else
            return AjaxResult.error(s);
    }

}

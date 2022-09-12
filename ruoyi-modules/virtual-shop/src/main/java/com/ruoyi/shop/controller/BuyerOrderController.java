package com.ruoyi.shop.controller;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.core.constant.SecurityConstants;
import com.ruoyi.common.security.annotation.InnerAuth;
import com.ruoyi.shop.domain.OrderBasicVO;
import com.ruoyi.shop.domain.OrderPO;
import com.ruoyi.shop.domain.BuyerItem;
import com.ruoyi.shop.service.IBuyerItemService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.log.annotation.Log;
import com.ruoyi.common.log.enums.BusinessType;
import com.ruoyi.common.security.annotation.RequiresPermissions;
import com.ruoyi.shop.domain.BuyerOrder;
import com.ruoyi.shop.service.IBuyerOrderService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 订单Controller
 *
 * @author xiaoming
 * @date 2022-08-07
 */
@RestController
@RequestMapping("/buyerOrder")
public class BuyerOrderController extends BaseController {
    @Autowired
    private IBuyerOrderService buyerOrderService;
    @Autowired
    private IBuyerItemService iBuyerItemService;

    @InnerAuth
    @GetMapping(value = "/fegin/{orderId}")
    OrderPO getInfoFegin(@PathVariable("orderId") String orderId, @RequestHeader(SecurityConstants.FROM_SOURCE) String inner) {
        OrderPO orderPO = buyerOrderService.selectBuyerOrderByOrderId(orderId);

        BuyerItem buyerItem = new BuyerItem();
        buyerItem.setOrderId(orderId);
        List<BuyerItem> buyerItems = iBuyerItemService.selectBuyerItemListByOrderId(buyerItem);
        orderPO.setBuyerItems(buyerItems);


        return orderPO;


    }

    @InnerAuth
    @PutMapping(value = "/fegin")
    OrderPO updateBuyerOrder(@RequestBody OrderPO buyerOrder, @RequestHeader(SecurityConstants.FROM_SOURCE) String inner) {
        int i = buyerOrderService.updateBuyerOrder(buyerOrder);
        OrderPO orderPO = new OrderPO();
        if (i > 0) {
            BuyerOrder buyerOrder1 = buyerOrderService.selectBuyerOrderByOrderId(buyerOrder.getOrderId());
            BeanUtils.copyProperties(buyerOrder1, orderPO);
        }
        return orderPO;
    }

    @InnerAuth
    @PostMapping(value = "/fegin")
    String insertBuyerOrder(@RequestBody OrderPO buyerOrder, @RequestHeader(SecurityConstants.FROM_SOURCE) String inner) {
        return buyerOrderService.insertBuyerOrder(buyerOrder);
    }

    @InnerAuth
    @GetMapping(value = "/commit")
    String commit(@RequestHeader(SecurityConstants.FROM_SOURCE) String inner) {
        return buyerOrderService.commit();
    }

    @InnerAuth
    @PutMapping(value ="/order/fegin")
    public int updateFegin(@RequestBody BuyerOrder buyerOrder, @RequestHeader(SecurityConstants.FROM_SOURCE) String inner) {
        return buyerOrderService.updateBuyerOrder(buyerOrder);

    }


    @InnerAuth
    @PutMapping(value ="/order/basic/fegin/{uid}")
    public List<OrderBasicVO>  basicInfo(@PathVariable("uid") String uid, @RequestHeader(SecurityConstants.FROM_SOURCE) String inner) {
        return buyerOrderService.basicInfo(uid);

    }

    @InnerAuth
    @PostMapping("saleList/fegin")
    public List<OrderPO> saleListFegin(@RequestBody BuyerOrder buyerOrder) {

        startPage(buyerOrder.getPageSize(), buyerOrder.getPageNum());
        List<OrderPO> list = buyerOrderService.selectSaleOrderList(buyerOrder);
        return (list);
    }


    @InnerAuth
    @PostMapping("/order/fegin")
    public List<OrderPO> orderFegin(@RequestBody BuyerOrder buyerOrder) {

        startPage(buyerOrder.getPageSize(), buyerOrder.getPageNum());
        List<OrderPO> list = buyerOrderService.selectOrderList(buyerOrder);
        return (list);
    }


    @InnerAuth
    @PostMapping("/list/fegin")
    public List<OrderPO> listFegin(@RequestBody BuyerOrder buyerOrder) {

        startPage(buyerOrder.getPageSize(), buyerOrder.getPageNum());
        List<OrderPO> list = buyerOrderService.selectBuyerOrderList(buyerOrder);
        return (list);
    }

    /**
     * 查询订单列表
     */
    @RequiresPermissions("shop:buyerOrder:list")
    @GetMapping("/list")
    public TableDataInfo list(BuyerOrder buyerOrder) {
        startPage();
        List<OrderPO> list = buyerOrderService.selectBuyerOrderList(buyerOrder);
        return getDataTable(list);
    }

    /**
     * 导出订单列表
     */
    @RequiresPermissions("shop:buyerOrder:export")
    @Log(title = "订单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BuyerOrder buyerOrder) {
        List<OrderPO> list = buyerOrderService.selectBuyerOrderList(buyerOrder);
        ExcelUtil<OrderPO> util = new ExcelUtil<OrderPO>(OrderPO.class);
        util.exportExcel(response, list, "订单数据");
    }

    /**
     * 获取订单详细信息
     */
    @RequiresPermissions("shop:buyerOrder:query")
    @GetMapping(value = "/{orderId}")
    public AjaxResult getInfo(@PathVariable("orderId") String orderId) {
        return AjaxResult.success(buyerOrderService.selectBuyerOrderByOrderId(orderId));
    }

    /**
     * 新增订单
     */
//    @RequiresPermissions("shop:buyerOrder:add")
//    @Log(title = "订单", businessType = BusinessType.INSERT)
//    @PostMapping
//    public AjaxResult add(@RequestBody BuyerOrder buyerOrder)
//    {
//        return toAjax(buyerOrderService.insertBuyerOrder(buyerOrder));
//    }

    /**
     * 修改订单
     */
    @RequiresPermissions("shop:buyerOrder:edit")
    @Log(title = "订单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BuyerOrder buyerOrder) {
        return toAjax(buyerOrderService.updateBuyerOrder(buyerOrder));
    }

    /**
     * 删除订单
     */
    @RequiresPermissions("shop:buyerOrder:remove")
    @Log(title = "订单", businessType = BusinessType.DELETE)
    @DeleteMapping("/{orderIds}")
    public AjaxResult remove(@PathVariable String[] orderIds) {
        return toAjax(buyerOrderService.deleteBuyerOrderByOrderIds(orderIds));
    }
}

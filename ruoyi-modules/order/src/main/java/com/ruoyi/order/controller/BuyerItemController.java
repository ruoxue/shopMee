//package com.ruoyi.order.controller;
//
//import java.util.List;
//import java.io.IOException;
//import javax.servlet.http.HttpServletResponse;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import com.ruoyi.common.log.annotation.Log;
//import com.ruoyi.common.log.enums.BusinessType;
//import com.ruoyi.common.security.annotation.RequiresPermissions;
//import com.ruoyi.order.domain.BuyerItem;
//import com.ruoyi.common.core.web.controller.BaseController;
//import com.ruoyi.common.core.web.domain.AjaxResult;
//import com.ruoyi.common.core.utils.poi.ExcelUtil;
//import com.ruoyi.common.core.web.page.TableDataInfo;
//
///**
// * 购买明细Controller
// *
// * @author xiaoming
// * @date 2022-08-18
// */
//@RestController
//@RequestMapping("/buyerItem")
//public class BuyerItemController extends BaseController
//{
//    @Autowired
//    private IBuyerItemService buyerItemService;
//
//    /**
//     * 查询购买明细列表
//     */
//    @RequiresPermissions("order:buyerItem:list")
//    @GetMapping("/list")
//    public TableDataInfo list(BuyerItem buyerItem)
//    {
//        startPage();
//        List<BuyerItem> list = buyerItemService.selectBuyerItemList(buyerItem);
//        return getDataTable(list);
//    }
//
//    /**
//     * 导出购买明细列表
//     */
//    @RequiresPermissions("order:buyerItem:export")
//    @Log(title = "购买明细", businessType = BusinessType.EXPORT)
//    @PostMapping("/export")
//    public void export(HttpServletResponse response, BuyerItem buyerItem)
//    {
//        List<BuyerItem> list = buyerItemService.selectBuyerItemList(buyerItem);
//        ExcelUtil<BuyerItem> util = new ExcelUtil<BuyerItem>(BuyerItem.class);
//        util.exportExcel(response, list, "购买明细数据");
//    }
//
//    /**
//     * 获取购买明细详细信息
//     */
//    @RequiresPermissions("order:buyerItem:query")
//    @GetMapping(value = "/{orderId}")
//    public AjaxResult getInfo(@PathVariable("orderId") String orderId)
//    {
//        return AjaxResult.success(buyerItemService.selectBuyerItemByOrderId(orderId));
//    }
//
//    /**
//     * 新增购买明细
//     */
//    @RequiresPermissions("order:buyerItem:add")
//    @Log(title = "购买明细", businessType = BusinessType.INSERT)
//    @PostMapping
//    public AjaxResult add(@RequestBody BuyerItem buyerItem)
//    {
//        return toAjax(buyerItemService.insertBuyerItem(buyerItem));
//    }
//
//    /**
//     * 修改购买明细
//     */
//    @RequiresPermissions("order:buyerItem:edit")
//    @Log(title = "购买明细", businessType = BusinessType.UPDATE)
//    @PutMapping
//    public AjaxResult edit(@RequestBody BuyerItem buyerItem)
//    {
//        return toAjax(buyerItemService.updateBuyerItem(buyerItem));
//    }
//
//    /**
//     * 删除购买明细
//     */
//    @RequiresPermissions("order:buyerItem:remove")
//    @Log(title = "购买明细", businessType = BusinessType.DELETE)
//	@DeleteMapping("/{orderIds}")
//    public AjaxResult remove(@PathVariable String[] orderIds)
//    {
//        return toAjax(buyerItemService.deleteBuyerItemByOrderIds(orderIds));
//    }
//}

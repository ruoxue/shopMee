package com.ruoyi.shop.controller;

import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.core.constant.SecurityConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.log.annotation.Log;
import com.ruoyi.common.log.enums.BusinessType;
import com.ruoyi.common.security.annotation.RequiresPermissions;
import com.ruoyi.shop.domain.BuyerAddress;
import com.ruoyi.shop.service.IBuyerAddressService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 地址Controller
 *
 * @author xiaoming
 * @date 2022-09-11
 */
@RestController
@RequestMapping("/buyerAddress")
public class BuyerAddressController extends BaseController {
    @Autowired
    private IBuyerAddressService buyerAddressService;


    @PostMapping(value = "/list/fegin")
    List<BuyerAddress> selectBuyerAddressListFegin(@RequestBody BuyerAddress buyerAddress, @RequestHeader(SecurityConstants.FROM_SOURCE) String inner) {
        startPage(buyerAddress.getPageSize(), buyerAddress.getPageNum());
        return buyerAddressService.selectBuyerAddressList(buyerAddress);
    }

    @GetMapping(value = "/fegin/{addressId}")
    BuyerAddress selectBuyerAddressByAddressId(@PathVariable("addressId") Long addressId, @RequestHeader(SecurityConstants.FROM_SOURCE) String inner) {
        return buyerAddressService.selectBuyerAddressByAddressId(addressId);
    }

    @PostMapping(value = "/fegin")
    int insertBuyerAddress(@RequestBody BuyerAddress buyerAddress, @RequestHeader(SecurityConstants.FROM_SOURCE) String inner) {
        return buyerAddressService.insertBuyerAddress(buyerAddress);
    }

    @PutMapping(value = "/fegin")
    int updateBuyerAddress(@RequestBody BuyerAddress buyerAddress, @RequestHeader(SecurityConstants.FROM_SOURCE) String inner) {
        return buyerAddressService.updateBuyerAddress(buyerAddress);
    }

    @DeleteMapping("/fegin/{addressId}")
    int deleteBuyerAddressByAddressId(@PathVariable("addressId") Long addressId, @RequestHeader(SecurityConstants.FROM_SOURCE) String inner) {
        return buyerAddressService.deleteBuyerAddressByAddressId(addressId);
    }


    /**
     * 查询地址列表
     */
    @RequiresPermissions("shop:buyerAddress:list")
    @GetMapping("/list")
    public TableDataInfo list(BuyerAddress buyerAddress) {
        startPage();
        List<BuyerAddress> list = buyerAddressService.selectBuyerAddressList(buyerAddress);
        return getDataTable(list);
    }

    /**
     * 导出地址列表
     */
    @RequiresPermissions("shop:buyerAddress:export")
    @Log(title = "地址", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BuyerAddress buyerAddress) {
        List<BuyerAddress> list = buyerAddressService.selectBuyerAddressList(buyerAddress);
        ExcelUtil<BuyerAddress> util = new ExcelUtil<BuyerAddress>(BuyerAddress.class);
        util.exportExcel(response, list, "地址数据");
    }

    /**
     * 获取地址详细信息
     */
    @RequiresPermissions("shop:buyerAddress:query")
    @GetMapping(value = "/{addressId}")
    public AjaxResult getInfo(@PathVariable("addressId") Long addressId) {
        return AjaxResult.success(buyerAddressService.selectBuyerAddressByAddressId(addressId));
    }

    /**
     * 新增地址
     */
    @RequiresPermissions("shop:buyerAddress:add")
    @Log(title = "地址", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BuyerAddress buyerAddress) {
        return toAjax(buyerAddressService.insertBuyerAddress(buyerAddress));
    }

    /**
     * 修改地址
     */
    @RequiresPermissions("shop:buyerAddress:edit")
    @Log(title = "地址", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BuyerAddress buyerAddress) {
        return toAjax(buyerAddressService.updateBuyerAddress(buyerAddress));
    }

    /**
     * 删除地址
     */
    @RequiresPermissions("shop:buyerAddress:remove")
    @Log(title = "地址", businessType = BusinessType.DELETE)
    @DeleteMapping("/{addressIds}")
    public AjaxResult remove(@PathVariable Long[] addressIds) {
        return toAjax(buyerAddressService.deleteBuyerAddressByAddressIds(addressIds));
    }
}

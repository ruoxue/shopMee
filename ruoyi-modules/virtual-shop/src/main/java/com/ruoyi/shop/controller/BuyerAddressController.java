package com.ruoyi.shop.controller;

import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
 * @date 2022-08-07
 */
@RestController
@RequestMapping("/buyerAddress")
public class BuyerAddressController extends BaseController
{
    @Autowired
    private IBuyerAddressService buyerAddressService;

    /**
     * 查询地址列表
     */
    @RequiresPermissions("shop:buyerAddress:list")
    @GetMapping("/list")
    public TableDataInfo list(BuyerAddress buyerAddress)
    {
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
    public void export(HttpServletResponse response, BuyerAddress buyerAddress)
    {
        List<BuyerAddress> list = buyerAddressService.selectBuyerAddressList(buyerAddress);
        ExcelUtil<BuyerAddress> util = new ExcelUtil<BuyerAddress>(BuyerAddress.class);
        util.exportExcel(response, list, "地址数据");
    }

    /**
     * 获取地址详细信息
     */
    @RequiresPermissions("shop:buyerAddress:query")
    @GetMapping(value = "/{addressId}")
    public AjaxResult getInfo(@PathVariable("addressId") String addressId)
    {
        return AjaxResult.success(buyerAddressService.selectBuyerAddressByAddressId(addressId));
    }

    /**
     * 新增地址
     */
    @RequiresPermissions("shop:buyerAddress:add")
    @Log(title = "地址", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BuyerAddress buyerAddress)
    {
        return toAjax(buyerAddressService.insertBuyerAddress(buyerAddress));
    }

    /**
     * 修改地址
     */
    @RequiresPermissions("shop:buyerAddress:edit")
    @Log(title = "地址", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BuyerAddress buyerAddress)
    {
        return toAjax(buyerAddressService.updateBuyerAddress(buyerAddress));
    }

    /**
     * 删除地址
     */
    @RequiresPermissions("shop:buyerAddress:remove")
    @Log(title = "地址", businessType = BusinessType.DELETE)
	@DeleteMapping("/{addressIds}")
    public AjaxResult remove(@PathVariable String[] addressIds)
    {
        return toAjax(buyerAddressService.deleteBuyerAddressByAddressIds(addressIds));
    }
}

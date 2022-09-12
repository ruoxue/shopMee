package com.ruoyi.mobile.controller;

import com.ruoyi.common.core.constant.SecurityConstants;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.web.page.TableDataInfo;
import com.ruoyi.common.log.annotation.Log;
import com.ruoyi.common.log.enums.BusinessType;
import com.ruoyi.common.security.annotation.RequiresLogin;
import com.ruoyi.common.security.annotation.RequiresPermissions;
import com.ruoyi.common.security.utils.SecurityUtils;
import com.ruoyi.shop.domain.BuyerAddress;
import com.ruoyi.system.api.RemoteAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 地址Controller
 * 
 * @author xiaoming
 * @date 2022-09-11
 */
@RestController
@RequestMapping("/buyerAddress")
public class BuyerAddressController extends BaseController
{
    @Autowired
    private RemoteAddressService buyerAddressService;

    /**
     * 查询地址列表
     */
    @RequiresLogin
    @GetMapping("/list")
    public TableDataInfo list(BuyerAddress buyerAddress)
    {
        buyerAddress.setUid(SecurityUtils.getLoginUser().getUserid());
        List<BuyerAddress> list = buyerAddressService.selectBuyerAddressList(buyerAddress, SecurityConstants.INNER);
        return getDataTable(list);
    }


    /**
     * 获取地址详细信息
     */
    @RequiresLogin
    @GetMapping(value = "/{addressId}")
    public AjaxResult getInfo(@PathVariable("addressId") Long addressId)
    {
        BuyerAddress buyerAddress = buyerAddressService.selectBuyerAddressByAddressId(addressId, SecurityConstants.INNER);
        if (buyerAddress.getUid().equals(SecurityUtils.getLoginUser().getUserid())){
            return AjaxResult.success();

        }else {
            return AjaxResult.error("地址为空");

        }
    }

    /**
     * 新增地址
     */
    @RequiresLogin
    @Log(title = "地址", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BuyerAddress buyerAddress)
    {
        buyerAddress.setUid(SecurityUtils.getLoginUser().getUserid());

        return toAjax(buyerAddressService.insertBuyerAddress(buyerAddress, SecurityConstants.INNER));
    }

    /**
     * 修改地址
     */
    @RequiresLogin
    @Log(title = "地址", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BuyerAddress buyerAddress)
    {
        buyerAddress.setUid(SecurityUtils.getLoginUser().getUserid());
        return toAjax(buyerAddressService.updateBuyerAddress(buyerAddress, SecurityConstants.INNER));

    }

    /**
     * 删除地址
     */
    @RequiresLogin
    @Log(title = "地址", businessType = BusinessType.DELETE)
	@DeleteMapping("/{addressId}")
    public AjaxResult remove(@PathVariable("addressId") Long addressId)
    {
        return toAjax(buyerAddressService.deleteBuyerAddressByAddressId(addressId, SecurityConstants.INNER));
    }
}

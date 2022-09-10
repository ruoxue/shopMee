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
import com.ruoyi.shop.domain.BuyerCart;
import com.ruoyi.shop.service.IBuyerCartService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 购物车Controller
 * 
 * @author xiaoming
 * @date 2022-08-07
 */
@RestController
@RequestMapping("/buyerCart")
public class BuyerCartController extends BaseController
{
    @Autowired
    private IBuyerCartService buyerCartService;

    /**
     * 查询购物车列表
     */
    @RequiresPermissions("shop:buyerCart:list")
    @GetMapping("/list")
    public TableDataInfo list(BuyerCart buyerCart)
    {
        startPage();
        List<BuyerCart> list = buyerCartService.selectBuyerCartList(buyerCart);
        return getDataTable(list);
    }

    /**
     * 导出购物车列表
     */
    @RequiresPermissions("shop:buyerCart:export")
    @Log(title = "购物车", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BuyerCart buyerCart)
    {
        List<BuyerCart> list = buyerCartService.selectBuyerCartList(buyerCart);
        ExcelUtil<BuyerCart> util = new ExcelUtil<BuyerCart>(BuyerCart.class);
        util.exportExcel(response, list, "购物车数据");
    }

    /**
     * 获取购物车详细信息
     */
    @RequiresPermissions("shop:buyerCart:query")
    @GetMapping(value = "/{cartId}")
    public AjaxResult getInfo(@PathVariable("cartId") String cartId)
    {
        return AjaxResult.success(buyerCartService.selectBuyerCartByCartId(cartId));
    }

    /**
     * 新增购物车
     */
    @RequiresPermissions("shop:buyerCart:add")
    @Log(title = "购物车", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BuyerCart buyerCart)
    {
        return toAjax(buyerCartService.insertBuyerCart(buyerCart));
    }

    /**
     * 修改购物车
     */
    @RequiresPermissions("shop:buyerCart:edit")
    @Log(title = "购物车", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BuyerCart buyerCart)
    {
        return toAjax(buyerCartService.updateBuyerCart(buyerCart));
    }

    /**
     * 删除购物车
     */
    @RequiresPermissions("shop:buyerCart:remove")
    @Log(title = "购物车", businessType = BusinessType.DELETE)
	@DeleteMapping("/{cartIds}")
    public AjaxResult remove(@PathVariable String[] cartIds)
    {
        return toAjax(buyerCartService.deleteBuyerCartByCartIds(cartIds));
    }
}

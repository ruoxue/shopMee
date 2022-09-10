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
import com.ruoyi.shop.domain.BuyerPayment;
import com.ruoyi.shop.service.IBuyerPaymentService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 支付Controller
 * 
 * @author xiaoming
 * @date 2022-08-07
 */
@RestController
@RequestMapping("/buyerPayment")
public class BuyerPaymentController extends BaseController
{
    @Autowired
    private IBuyerPaymentService buyerPaymentService;

    /**
     * 查询支付列表
     */
    @RequiresPermissions("shop:buyerPayment:list")
    @GetMapping("/list")
    public TableDataInfo list(BuyerPayment buyerPayment)
    {
        startPage();
        List<BuyerPayment> list = buyerPaymentService.selectBuyerPaymentList(buyerPayment);
        return getDataTable(list);
    }

    /**
     * 导出支付列表
     */
    @RequiresPermissions("shop:buyerPayment:export")
    @Log(title = "支付", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BuyerPayment buyerPayment)
    {
        List<BuyerPayment> list = buyerPaymentService.selectBuyerPaymentList(buyerPayment);
        ExcelUtil<BuyerPayment> util = new ExcelUtil<BuyerPayment>(BuyerPayment.class);
        util.exportExcel(response, list, "支付数据");
    }

    /**
     * 获取支付详细信息
     */
    @RequiresPermissions("shop:buyerPayment:query")
    @GetMapping(value = "/{revision}")
    public AjaxResult getInfo(@PathVariable("revision") Long revision)
    {
        return AjaxResult.success(buyerPaymentService.selectBuyerPaymentByRevision(revision));
    }

    /**
     * 新增支付
     */
    @RequiresPermissions("shop:buyerPayment:add")
    @Log(title = "支付", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BuyerPayment buyerPayment)
    {
        return toAjax(buyerPaymentService.insertBuyerPayment(buyerPayment));
    }

    /**
     * 修改支付
     */
    @RequiresPermissions("shop:buyerPayment:edit")
    @Log(title = "支付", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BuyerPayment buyerPayment)
    {
        return toAjax(buyerPaymentService.updateBuyerPayment(buyerPayment));
    }

    /**
     * 删除支付
     */
    @RequiresPermissions("shop:buyerPayment:remove")
    @Log(title = "支付", businessType = BusinessType.DELETE)
	@DeleteMapping("/{revisions}")
    public AjaxResult remove(@PathVariable Long[] revisions)
    {
        return toAjax(buyerPaymentService.deleteBuyerPaymentByRevisions(revisions));
    }
}

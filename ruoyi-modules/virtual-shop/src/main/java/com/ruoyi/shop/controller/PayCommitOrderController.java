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
import com.ruoyi.shop.domain.PayCommitOrder;
import com.ruoyi.shop.service.IPayCommitOrderService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 预付卡订单Controller
 * 
 * @author xiaoming
 * @date 2022-09-10
 */
@RestController
@RequestMapping("/payCommitOrder")
public class PayCommitOrderController extends BaseController
{
    @Autowired
    private IPayCommitOrderService payCommitOrderService;

    /**
     * 查询预付卡订单列表
     */
    @RequiresPermissions("shop:payCommitOrder:list")
    @GetMapping("/list")
    public TableDataInfo list(PayCommitOrder payCommitOrder)
    {
        startPage();
        List<PayCommitOrder> list = payCommitOrderService.selectPayCommitOrderList(payCommitOrder);
        return getDataTable(list);
    }

    /**
     * 导出预付卡订单列表
     */
    @RequiresPermissions("shop:payCommitOrder:export")
    @Log(title = "预付卡订单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PayCommitOrder payCommitOrder)
    {
        List<PayCommitOrder> list = payCommitOrderService.selectPayCommitOrderList(payCommitOrder);
        ExcelUtil<PayCommitOrder> util = new ExcelUtil<PayCommitOrder>(PayCommitOrder.class);
        util.exportExcel(response, list, "预付卡订单数据");
    }

    /**
     * 获取预付卡订单详细信息
     */
    @RequiresPermissions("shop:payCommitOrder:query")
    @GetMapping(value = "/{revision}")
    public AjaxResult getInfo(@PathVariable("revision") Long revision)
    {
        return AjaxResult.success(payCommitOrderService.selectPayCommitOrderByRevision(revision));
    }

    /**
     * 新增预付卡订单
     */
    @RequiresPermissions("shop:payCommitOrder:add")
    @Log(title = "预付卡订单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PayCommitOrder payCommitOrder)
    {
        return toAjax(payCommitOrderService.insertPayCommitOrder(payCommitOrder));
    }

    /**
     * 修改预付卡订单
     */
    @RequiresPermissions("shop:payCommitOrder:edit")
    @Log(title = "预付卡订单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PayCommitOrder payCommitOrder)
    {
        return toAjax(payCommitOrderService.updatePayCommitOrder(payCommitOrder));
    }

    /**
     * 删除预付卡订单
     */
    @RequiresPermissions("shop:payCommitOrder:remove")
    @Log(title = "预付卡订单", businessType = BusinessType.DELETE)
	@DeleteMapping("/{revisions}")
    public AjaxResult remove(@PathVariable Long[] revisions)
    {
        return toAjax(payCommitOrderService.deletePayCommitOrderByRevisions(revisions));
    }
}

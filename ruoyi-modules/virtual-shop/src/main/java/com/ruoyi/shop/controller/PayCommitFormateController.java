package com.ruoyi.shop.controller;

import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.core.constant.SecurityConstants;
import com.ruoyi.common.security.annotation.InnerAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.log.annotation.Log;
import com.ruoyi.common.log.enums.BusinessType;
import com.ruoyi.common.security.annotation.RequiresPermissions;
import com.ruoyi.shop.domain.PayCommitFormate;
import com.ruoyi.shop.service.IPayCommitFormateService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 求购商品格式Controller
 * 
 * @author xiaoming
 * @date 2022-09-11
 */
@RestController
@RequestMapping("/payCommitFormate")
public class PayCommitFormateController extends BaseController
{
    @Autowired
    private IPayCommitFormateService payCommitFormateService;


    @InnerAuth
    @GetMapping("/list/fegin")
    public TableDataInfo listFegin(@RequestHeader(SecurityConstants.FROM_SOURCE) String inner)
    {
        PayCommitFormate payCommitFormate = new PayCommitFormate();
        List<PayCommitFormate> list = payCommitFormateService.selectPayCommitFormateList(payCommitFormate);
        return getDataTable(list);
    }

    /**
     * 查询求购商品格式列表
     */
    @RequiresPermissions("shop:payCommitFormate:list")
    @GetMapping("/list")
    public TableDataInfo list(PayCommitFormate payCommitFormate)
    {
        startPage();
        List<PayCommitFormate> list = payCommitFormateService.selectPayCommitFormateList(payCommitFormate);
        return getDataTable(list);
    }

    /**
     * 导出求购商品格式列表
     */
    @RequiresPermissions("shop:payCommitFormate:export")
    @Log(title = "求购商品格式", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PayCommitFormate payCommitFormate)
    {
        List<PayCommitFormate> list = payCommitFormateService.selectPayCommitFormateList(payCommitFormate);
        ExcelUtil<PayCommitFormate> util = new ExcelUtil<PayCommitFormate>(PayCommitFormate.class);
        util.exportExcel(response, list, "求购商品格式数据");
    }

    /**
     * 获取求购商品格式详细信息
     */
    @RequiresPermissions("shop:payCommitFormate:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(payCommitFormateService.selectPayCommitFormateById(id));
    }

    /**
     * 新增求购商品格式
     */
    @RequiresPermissions("shop:payCommitFormate:add")
    @Log(title = "求购商品格式", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PayCommitFormate payCommitFormate)
    {
        return toAjax(payCommitFormateService.insertPayCommitFormate(payCommitFormate));
    }

    /**
     * 修改求购商品格式
     */
    @RequiresPermissions("shop:payCommitFormate:edit")
    @Log(title = "求购商品格式", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PayCommitFormate payCommitFormate)
    {
        return toAjax(payCommitFormateService.updatePayCommitFormate(payCommitFormate));
    }

    /**
     * 删除求购商品格式
     */
    @RequiresPermissions("shop:payCommitFormate:remove")
    @Log(title = "求购商品格式", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(payCommitFormateService.deletePayCommitFormateByIds(ids));
    }
}

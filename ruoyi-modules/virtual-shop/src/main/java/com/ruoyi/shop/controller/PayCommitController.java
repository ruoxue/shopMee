package com.ruoyi.shop.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.log.annotation.Log;
import com.ruoyi.common.log.enums.BusinessType;
import com.ruoyi.common.security.annotation.RequiresPermissions;
import com.ruoyi.shop.domain.PayCommit;
import com.ruoyi.shop.service.IPayCommitService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 求购自动提交信息Controller
 * 
 * @author xiaoming
 * @date 2022-09-10
 */
@RestController
@RequestMapping("/payCommit")
public class PayCommitController extends BaseController
{
    @Autowired
    private IPayCommitService payCommitService;
    @PostMapping(value = "/list/fegin")
   public TableDataInfo selectPayCommitList(@RequestBody PayCommit payCommit){
        startPage();
        List<PayCommit> list = payCommitService.selectPayCommitList(payCommit);
        return getDataTable(list);
    }

    /**
     * 查询求购自动提交信息列表
     */
    @RequiresPermissions("shop:payCommit:list")
    @GetMapping("/list")
    public TableDataInfo list(PayCommit payCommit)
    {
        startPage();
        List<PayCommit> list = payCommitService.selectPayCommitList(payCommit);
        return getDataTable(list);
    }

    /**
     * 导出求购自动提交信息列表
     */
    @RequiresPermissions("shop:payCommit:export")
    @Log(title = "求购自动提交信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PayCommit payCommit)
    {
        List<PayCommit> list = payCommitService.selectPayCommitList(payCommit);
        ExcelUtil<PayCommit> util = new ExcelUtil<PayCommit>(PayCommit.class);
        util.exportExcel(response, list, "求购自动提交信息数据");
    }

    /**
     * 获取求购自动提交信息详细信息
     */
    @RequiresPermissions("shop:payCommit:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(payCommitService.selectPayCommitById(id));
    }

    /**
     * 新增求购自动提交信息
     */
    @RequiresPermissions("shop:payCommit:add")
    @Log(title = "求购自动提交信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PayCommit payCommit)
    {
        return toAjax(payCommitService.insertPayCommit(payCommit));
    }

    /**
     * 修改求购自动提交信息
     */
    @RequiresPermissions("shop:payCommit:edit")
    @Log(title = "求购自动提交信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PayCommit payCommit)
    {
        return toAjax(payCommitService.updatePayCommit(payCommit));
    }

    /**
     * 删除求购自动提交信息
     */
    @RequiresPermissions("shop:payCommit:remove")
    @Log(title = "求购自动提交信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(payCommitService.deletePayCommitByIds(ids));
    }
}

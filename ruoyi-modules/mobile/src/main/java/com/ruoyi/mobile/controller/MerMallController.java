package com.ruoyi.mobile.controller;

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
import com.ruoyi.mobile.domain.MerMall;
import com.ruoyi.mobile.service.IMerMallService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 商户店铺Controller
 * 
 * @author xiaoming
 * @date 2022-08-08
 */
@RestController
@RequestMapping("/merMall")
public class MerMallController extends BaseController
{
    @Autowired
    private IMerMallService merMallService;

    /**
     * 查询商户店铺列表
     */
    @RequiresPermissions("mobile:merMall:list")
    @GetMapping("/list")
    public TableDataInfo list(MerMall merMall)
    {
        startPage();
        List<MerMall> list = merMallService.selectMerMallList(merMall);
        return getDataTable(list);
    }

    /**
     * 导出商户店铺列表
     */
    @RequiresPermissions("mobile:merMall:export")
    @Log(title = "商户店铺", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MerMall merMall)
    {
        List<MerMall> list = merMallService.selectMerMallList(merMall);
        ExcelUtil<MerMall> util = new ExcelUtil<MerMall>(MerMall.class);
        util.exportExcel(response, list, "商户店铺数据");
    }

    /**
     * 获取商户店铺详细信息
     */
    @RequiresPermissions("mobile:merMall:query")
    @GetMapping(value = "/{merMallId}")
    public AjaxResult getInfo(@PathVariable("merMallId") Long merMallId)
    {
        return AjaxResult.success(merMallService.selectMerMallByMerMallId(merMallId));
    }

    /**
     * 新增商户店铺
     */
    @RequiresPermissions("mobile:merMall:add")
    @Log(title = "商户店铺", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MerMall merMall)
    {
        return toAjax(merMallService.insertMerMall(merMall));
    }

    /**
     * 修改商户店铺
     */
    @RequiresPermissions("mobile:merMall:edit")
    @Log(title = "商户店铺", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MerMall merMall)
    {
        return toAjax(merMallService.updateMerMall(merMall));
    }

    /**
     * 删除商户店铺
     */
    @RequiresPermissions("mobile:merMall:remove")
    @Log(title = "商户店铺", businessType = BusinessType.DELETE)
	@DeleteMapping("/{merMallIds}")
    public AjaxResult remove(@PathVariable Long[] merMallIds)
    {
        return toAjax(merMallService.deleteMerMallByMerMallIds(merMallIds));
    }
}

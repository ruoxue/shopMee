package com.ruoyi.order.controller;

import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.security.annotation.RequiresLogin;
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
import com.ruoyi.order.domain.ProductBanner;
import com.ruoyi.order.service.IProductBannerService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 【请填写功能名称】Controller
 * 
 * @author xiaoming
 * @date 2022-08-28
 */
@RestController
@RequestMapping("/productBanner")
public class ProductBannerController extends BaseController
{
    @Autowired
    private IProductBannerService productBannerService;

    /**
     * 查询【请填写功能名称】列表
     */
//    @RequiresLogin
    @GetMapping("/list")
    public TableDataInfo list(ProductBanner productBanner)
    {
        startPage();
        List<ProductBanner> list = productBannerService.selectProductBannerList(productBanner);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @RequiresPermissions("order:productBanner:export")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ProductBanner productBanner)
    {
        List<ProductBanner> list = productBannerService.selectProductBannerList(productBanner);
        ExcelUtil<ProductBanner> util = new ExcelUtil<ProductBanner>(ProductBanner.class);
        util.exportExcel(response, list, "【请填写功能名称】数据");
    }

    /**
     * 获取【请填写功能名称】详细信息
     */
    @RequiresPermissions("order:productBanner:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(productBannerService.selectProductBannerById(id));
    }

    /**
     * 新增【请填写功能名称】
     */
    @RequiresPermissions("order:productBanner:add")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ProductBanner productBanner)
    {
        return toAjax(productBannerService.insertProductBanner(productBanner));
    }

    /**
     * 修改【请填写功能名称】
     */
    @RequiresPermissions("order:productBanner:edit")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ProductBanner productBanner)
    {
        return toAjax(productBannerService.updateProductBanner(productBanner));
    }

    /**
     * 删除【请填写功能名称】
     */
    @RequiresPermissions("order:productBanner:remove")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(productBannerService.deleteProductBannerByIds(ids));
    }
}

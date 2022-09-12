package com.ruoyi.mobile.controller;

import cn.hutool.core.util.URLUtil;
import cn.hutool.http.HtmlUtil;
import com.ruoyi.common.core.constant.SecurityConstants;
import com.ruoyi.common.core.utils.sign.Base64;
import com.ruoyi.common.security.annotation.RequiresLogin;
import com.ruoyi.common.security.utils.SecurityUtils;
import com.ruoyi.shop.domain.Product;
import com.ruoyi.shop.domain.ProductCategory;
import com.ruoyi.shop.domain.ProductShop;
import com.ruoyi.shop.param.ProductPO;
import com.ruoyi.system.api.RemoteProductService;
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
import com.ruoyi.mobile.service.IProductService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

import java.nio.charset.StandardCharsets;

/**
 * 商品基础信息Controller
 *
 * @author xiaoming
 * @date 2022-08-08
 */
@RestController
@RequestMapping("/product")
public class ProductController extends BaseController {
    @Autowired
    private IProductService productService;

    @Autowired
    private RemoteProductService remoteProductService;


    /**
     * 查询商品基础信息列表
     */
//    @RequiresPermissions("mobile:product:list")
    @GetMapping("/list")
    public TableDataInfo list(ProductPO product) {
        return remoteProductService.list(product, SecurityConstants.INNER);
    }

    @RequiresLogin
    @GetMapping("/mineList")
    public TableDataInfo mineList(ProductPO product) {
        product.setUserId( (SecurityUtils.getLoginUser().getUserid() ));

        return remoteProductService.list(product, SecurityConstants.INNER);
    }


    /**
     * 获取商品基础信息详细信息
     */

    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return  AjaxResult.success(remoteProductService.getInfo(id, SecurityConstants.INNER));
    }

    /**
     * 新增商品基础信息
     */
    @RequiresLogin
    @Log(title = "商品基础信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ProductPO product) {
        product.setUserId(SecurityUtils.getLoginUser().getUserid());
        return (remoteProductService.add(product, SecurityConstants.INNER));
    }

    /**
     * 修改商品基础信息
     */
    @RequiresLogin
    @Log(title = "商品基础信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ProductPO product) {
        product.setUserId(SecurityUtils.getLoginUser().getUserid());

        return (remoteProductService.edit(product, SecurityConstants.INNER));
    }

    /**
     * 删除商品基础信息
     */
    @RequiresLogin
    @Log(title = "商品基础信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {

        return (remoteProductService.remove(ids, SecurityConstants.INNER));
    }
}

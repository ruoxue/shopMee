package com.ruoyi.shop.controller;

import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.security.annotation.InnerAuth;
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
import com.ruoyi.shop.domain.ProductSku;
import com.ruoyi.shop.service.IProductSkuService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 商品规格信息Controller
 *
 * @author xiaoming
 * @date 2022-08-07
 */
@RestController
@RequestMapping("/productSku")
public class ProductSkuController extends BaseController {
    @Autowired
    private IProductSkuService productSkuService;


    @InnerAuth
    @GetMapping(value = "/fegin/{goodsId}")
    TableDataInfo getSKuByGoods(@PathVariable("goodsId") Long goodsId) {
        ProductSku sku = new ProductSku();
        sku.setGoodsId(goodsId );
        return getDataTable(productSkuService.selectProductSkuList(sku));
    }


    @GetMapping(value = "/remote/{id}")
    public ProductSku getInfoRemote(@PathVariable("id") Long id) {
        return (productSkuService.selectProductSkuById(id));
    }

    /**
     * 查询商品规格信息列表
     */
    @RequiresPermissions("shop:productSku:list")
    @GetMapping("/list")
    public TableDataInfo list(ProductSku productSku) {
        startPage(productSku.getPageSize(),productSku.getPageNum());
        List<ProductSku> list = productSkuService.selectProductSkuList(productSku);
        return getDataTable(list);
    }

    /**
     * 导出商品规格信息列表
     */
    @RequiresPermissions("shop:productSku:export")
    @Log(title = "商品规格信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ProductSku productSku) {
        List<ProductSku> list = productSkuService.selectProductSkuList(productSku);
        ExcelUtil<ProductSku> util = new ExcelUtil<ProductSku>(ProductSku.class);
        util.exportExcel(response, list, "商品规格信息数据");
    }

    /**
     * 获取商品规格信息详细信息
     */
    @RequiresPermissions("shop:productSku:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(productSkuService.selectProductSkuById(id));
    }

    /**
     * 新增商品规格信息
     */
    @RequiresPermissions("shop:productSku:add")
    @Log(title = "商品规格信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ProductSku productSku) {
        return toAjax(productSkuService.insertProductSku(productSku));
    }

    /**
     * 修改商品规格信息
     */
    @RequiresPermissions("shop:productSku:edit")
    @Log(title = "商品规格信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ProductSku productSku) {
        return toAjax(productSkuService.updateProductSku(productSku));
    }

    /**
     * 删除商品规格信息
     */
    @RequiresPermissions("shop:productSku:remove")
    @Log(title = "商品规格信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids) {
        return toAjax(productSkuService.deleteProductSkuByIds(ids));
    }
}

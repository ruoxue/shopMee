package com.ruoyi.shop.controller;

import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.core.constant.SecurityConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.log.annotation.Log;
import com.ruoyi.common.log.enums.BusinessType;
import com.ruoyi.common.security.annotation.RequiresPermissions;
import com.ruoyi.shop.domain.City;
import com.ruoyi.shop.service.ICityService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 城市Controller
 *
 * @author xiaoming
 * @date 2022-09-11
 */
@RestController
@RequestMapping("/city")
public class CityController extends BaseController {
    @Autowired
    private ICityService cityService;

    @PostMapping("/list/fegin")
    List<com.ruoyi.shop.domain.City> selectCityList(@RequestBody com.ruoyi.shop.domain.City city, @RequestHeader(SecurityConstants.FROM_SOURCE) String inner) {
        return cityService.selectCityList(city);
    }

    /**
     * 查询城市列表
     */
    @RequiresPermissions("shop:city:list")
    @GetMapping("/list")
    public TableDataInfo list(City city) {
        startPage();
        List<City> list = cityService.selectCityList(city);
        return getDataTable(list);
    }

    /**
     * 导出城市列表
     */
    @RequiresPermissions("shop:city:export")
    @Log(title = "城市", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, City city) {
        List<City> list = cityService.selectCityList(city);
        ExcelUtil<City> util = new ExcelUtil<City>(City.class);
        util.exportExcel(response, list, "城市数据");
    }

    /**
     * 获取城市详细信息
     */
    @RequiresPermissions("shop:city:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(cityService.selectCityById(id));
    }

    /**
     * 新增城市
     */
    @RequiresPermissions("shop:city:add")
    @Log(title = "城市", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody City city) {
        return toAjax(cityService.insertCity(city));
    }

    /**
     * 修改城市
     */
    @RequiresPermissions("shop:city:edit")
    @Log(title = "城市", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody City city) {
        return toAjax(cityService.updateCity(city));
    }

    /**
     * 删除城市
     */
    @RequiresPermissions("shop:city:remove")
    @Log(title = "城市", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(cityService.deleteCityByIds(ids));
    }
}

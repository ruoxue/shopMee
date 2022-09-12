package com.ruoyi.mobile.controller;

import com.ruoyi.common.core.constant.SecurityConstants;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.page.TableDataInfo;
import com.ruoyi.common.security.annotation.RequiresLogin;
import com.ruoyi.common.security.annotation.RequiresPermissions;
import com.ruoyi.shop.domain.City;
import com.ruoyi.system.api.RemoteCityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 城市Controller
 * 
 * @author xiaoming
 * @date 2022-09-11
 */
@RestController
@RequestMapping("/city")
public class CityController extends BaseController
{
    @Autowired
    private RemoteCityService cityService;

    /**
     * 查询城市列表
     */
    @RequiresLogin
    @GetMapping("/list")
    public TableDataInfo list(City city)
    {

        List<City> list = cityService.selectCityList(city, SecurityConstants.INNER);
        return getDataTable(list);
    }


}

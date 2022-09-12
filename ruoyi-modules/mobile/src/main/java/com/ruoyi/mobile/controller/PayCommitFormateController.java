package com.ruoyi.mobile.controller;

import com.ruoyi.common.core.constant.SecurityConstants;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.page.TableDataInfo;
import com.ruoyi.common.security.annotation.RequiresLogin;
import com.ruoyi.system.api.RemoteFormateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 求购商品格式Controller
 *
 * @author xiaoming
 * @date 2022-09-11
 */
@RestController
@RequestMapping("/payCommitFormate")
public class PayCommitFormateController extends BaseController {
    @Autowired
    private RemoteFormateService remoteFormateService;


    /**
     * 查询求购商品格式列表
     */
    @RequiresLogin
    @GetMapping("/list")
    public TableDataInfo list() {
        return remoteFormateService.listFegin(SecurityConstants.INNER);
    }

}

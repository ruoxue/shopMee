package com.ruoyi.mobile.controller;

import com.ruoyi.common.core.constant.SecurityConstants;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.page.TableDataInfo;
import com.ruoyi.common.security.annotation.RequiresLogin;
import com.ruoyi.common.security.annotation.RequiresPermissions;
import com.ruoyi.shop.domain.PayCommit;
import com.ruoyi.system.api.RemotePayCommitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    private RemotePayCommitService payCommitService;

    /**
     * 查询求购自动提交信息列表
     */
    @RequiresLogin
    @GetMapping("/list")
    public TableDataInfo list(PayCommit payCommit)
    {
        TableDataInfo  list = payCommitService.selectPayCommitList(payCommit, SecurityConstants.INNER);
        return  (list);
    }




}

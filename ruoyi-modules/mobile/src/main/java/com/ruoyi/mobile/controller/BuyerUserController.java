package com.ruoyi.mobile.controller;

import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.security.annotation.RequiresLogin;
import com.ruoyi.common.security.utils.SecurityUtils;
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
import com.ruoyi.mobile.domain.BuyerUser;
import com.ruoyi.mobile.service.IBuyerUserService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 买家Controller
 *
 * @author xiaoming
 * @date 2022-08-08
 */
@RestController
@RequestMapping("/buyerUser")
public class BuyerUserController extends BaseController {
    @Autowired
    private IBuyerUserService buyerUserService;

    /**
     * 查询买家列表
     */
    @RequiresPermissions("mobile:buyerUser:list")
    @GetMapping("/list")
    public TableDataInfo list(BuyerUser buyerUser) {
        startPage();
        List<BuyerUser> list = buyerUserService.selectBuyerUserList(buyerUser);
        return getDataTable(list);
    }

    /**
     * 导出买家列表
     */
    @RequiresPermissions("mobile:buyerUser:export")
    @Log(title = "买家", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BuyerUser buyerUser) {
        List<BuyerUser> list = buyerUserService.selectBuyerUserList(buyerUser);
        ExcelUtil<BuyerUser> util = new ExcelUtil<BuyerUser>(BuyerUser.class);
        util.exportExcel(response, list, "买家数据");
    }

    /**
     * 获取买家详细信息
     */
    @RequiresLogin
    @GetMapping()
    public AjaxResult getInfo() {
        String userId = String.valueOf(SecurityUtils.getLoginUser().getUserid());
        return AjaxResult.success(buyerUserService.selectBuyerUserByUserId(userId));
    }


    /**
     * 新增买家
     */
    @RequiresPermissions("mobile:buyerUser:add")
    @Log(title = "买家", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BuyerUser buyerUser) {
        return toAjax(buyerUserService.insertBuyerUser(buyerUser));
    }

    /**
     * 修改买家
     */
    @RequiresPermissions("mobile:buyerUser:edit")
    @Log(title = "买家", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BuyerUser buyerUser) {
        return toAjax(buyerUserService.updateBuyerUser(buyerUser));
    }

    /**
     * 删除买家
     */
    @RequiresPermissions("mobile:buyerUser:remove")
    @Log(title = "买家", businessType = BusinessType.DELETE)
    @DeleteMapping("/{userIds}")
    public AjaxResult remove(@PathVariable String[] userIds) {
        return toAjax(buyerUserService.deleteBuyerUserByUserIds(userIds));
    }
}

package com.ruoyi.shop.controller;

import java.util.List;
import java.io.IOException;
import java.util.Set;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.core.constant.SecurityConstants;
import com.ruoyi.common.core.constant.UserConstants;
import com.ruoyi.common.core.domain.R;
import com.ruoyi.common.core.utils.StringUtils;
import com.ruoyi.common.security.annotation.InnerAuth;
import com.ruoyi.system.api.domain.SysUser;
import com.ruoyi.system.api.model.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.log.annotation.Log;
import com.ruoyi.common.log.enums.BusinessType;
import com.ruoyi.common.security.annotation.RequiresPermissions;
import com.ruoyi.shop.domain.BuyerUser;
import com.ruoyi.shop.service.IBuyerUserService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 买家Controller
 * 
 * @author xiaoming
 * @date 2022-08-07
 */
@RestController
@RequestMapping("/buyerUser")
public class BuyerUserController extends BaseController
{



    @Autowired
    private IBuyerUserService buyerUserService;

    /**
     * 查询买家列表
     */
    @RequiresPermissions("shop:buyerUser:list")
    @GetMapping("/list")
    public TableDataInfo list(BuyerUser buyerUser)
    {
        startPage();
        List<BuyerUser> list = buyerUserService.selectBuyerUserList(buyerUser);
        return getDataTable(list);
    }

    /**
     * 导出买家列表
     */
    @RequiresPermissions("shop:buyerUser:export")
    @Log(title = "买家", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BuyerUser buyerUser)
    {
        List<BuyerUser> list = buyerUserService.selectBuyerUserList(buyerUser);
        ExcelUtil<BuyerUser> util = new ExcelUtil<BuyerUser>(BuyerUser.class);
        util.exportExcel(response, list, "买家数据");
    }

    /**
     * 获取买家详细信息
     */
    @RequiresPermissions("shop:buyerUser:query")
    @GetMapping(value = "/{userId}")
    public AjaxResult getInfo(@PathVariable("userId") String userId)
    {
        return AjaxResult.success(buyerUserService.selectBuyerUserByUserId(userId));
    }

    /**
     * 新增买家
     */
    @RequiresPermissions("shop:buyerUser:add")
    @Log(title = "买家", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BuyerUser buyerUser)
    {
        return toAjax(buyerUserService.insertBuyerUser(buyerUser));
    }

    /**
     * 修改买家
     */
    @RequiresPermissions("shop:buyerUser:edit")
    @Log(title = "买家", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BuyerUser buyerUser)
    {
        return toAjax(buyerUserService.updateBuyerUser(buyerUser));
    }

    /**
     * 删除买家
     */
    @RequiresPermissions("shop:buyerUser:remove")
    @Log(title = "买家", businessType = BusinessType.DELETE)
	@DeleteMapping("/{userIds}")
    public AjaxResult remove(@PathVariable String[] userIds)
    {
        return toAjax(buyerUserService.deleteBuyerUserByUserIds(userIds));
    }



    /**
     * 通过用户名查询用户信息
     *
     * @param username 用户名
     * @param source 请求来源
     * @return 结果
     */
    @InnerAuth

    @GetMapping("/user/info/{username}")
    public R<LoginUser> getUserInfo(@PathVariable("username") String username, @RequestHeader(SecurityConstants.FROM_SOURCE) String source){
       BuyerUser buyerUser=new BuyerUser();
       buyerUser.setUserName(username);
        List<BuyerUser> buyerUsers = buyerUserService.selectBuyerUserList(buyerUser);
        if (StringUtils.isNull(buyerUsers)||buyerUsers.size()!=1)
        {
            return R.fail("用户名或密码错误");
        }
        // 角色集合
        BuyerUser buyerUser1 = buyerUsers.get(0);
        LoginUser sysUserVo = new LoginUser();


        sysUserVo.setBuyerUser(buyerUser1);

        return R.ok(sysUserVo);
    }

    /**
     * 注册用户信息
     *
     * @param sysUser 用户信息
     * @param source 请求来源
     * @return 结果
     */
    @InnerAuth
    @PostMapping("/user/register")
    public R<Boolean> registerUserInfo(@RequestBody BuyerUser sysUser, @RequestHeader(SecurityConstants.FROM_SOURCE) String source){
        String username = sysUser.getUserName();

        if (UserConstants.NOT_UNIQUE.equals(buyerUserService.checkUserNameUnique(username)))
        {
            return R.fail("保存用户'" + username + "'失败，注册账号已存在");
        }
        return R.ok(buyerUserService.registerUser(sysUser));
    }





}

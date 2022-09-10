package com.ruoyi.shop.service.impl;

import java.util.List;

import com.ruoyi.system.api.domain.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.shop.mapper.BuyerUserMapper;
import com.ruoyi.shop.domain.BuyerUser;
import com.ruoyi.shop.service.IBuyerUserService;

/**
 * 买家Service业务层处理
 * 
 * @author xiaoming
 * @date 2022-08-07
 */
@Service
public class BuyerUserServiceImpl implements IBuyerUserService 
{
    @Autowired
    private BuyerUserMapper buyerUserMapper;

    /**
     * 查询买家
     * 
     * @param userId 买家主键
     * @return 买家
     */
    @Override
    public BuyerUser selectBuyerUserByUserId(String userId)
    {
        return buyerUserMapper.selectBuyerUserByUserId(userId);
    }

    /**
     * 查询买家列表
     * 
     * @param buyerUser 买家
     * @return 买家
     */
    @Override
    public List<BuyerUser> selectBuyerUserList(BuyerUser buyerUser)
    {
        return buyerUserMapper.selectBuyerUserList(buyerUser);
    }

    /**
     * 新增买家
     * 
     * @param buyerUser 买家
     * @return 结果
     */
    @Override
    public int insertBuyerUser(BuyerUser buyerUser)
    {
        return buyerUserMapper.insertBuyerUser(buyerUser);
    }

    /**
     * 修改买家
     * 
     * @param buyerUser 买家
     * @return 结果
     */
    @Override
    public int updateBuyerUser(BuyerUser buyerUser)
    {
        return buyerUserMapper.updateBuyerUser(buyerUser);
    }

    /**
     * 批量删除买家
     * 
     * @param userIds 需要删除的买家主键
     * @return 结果
     */
    @Override
    public int deleteBuyerUserByUserIds(String[] userIds)
    {
        return buyerUserMapper.deleteBuyerUserByUserIds(userIds);
    }

    /**
     * 删除买家信息
     * 
     * @param userId 买家主键
     * @return 结果
     */
    @Override
    public int deleteBuyerUserByUserId(String userId)
    {
        return buyerUserMapper.deleteBuyerUserByUserId(userId);
    }

    @Override
    public String checkUserNameUnique(String username) {
        return buyerUserMapper.checkUserNameUnique(username);
    }

    @Override
    public Boolean registerUser(BuyerUser sysUser) {
        return buyerUserMapper.insertBuyerUser(sysUser)>0;
    }
}

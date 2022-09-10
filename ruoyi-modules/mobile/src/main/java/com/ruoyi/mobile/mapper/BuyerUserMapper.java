package com.ruoyi.mobile.mapper;

import java.util.List;
import com.ruoyi.mobile.domain.BuyerUser;

/**
 * 买家Mapper接口
 * 
 * @author xiaoming
 * @date 2022-08-08
 */
public interface BuyerUserMapper 
{
    /**
     * 查询买家
     * 
     * @param userId 买家主键
     * @return 买家
     */
    public BuyerUser selectBuyerUserByUserId(String userId);

    /**
     * 查询买家列表
     * 
     * @param buyerUser 买家
     * @return 买家集合
     */
    public List<BuyerUser> selectBuyerUserList(BuyerUser buyerUser);

    /**
     * 新增买家
     * 
     * @param buyerUser 买家
     * @return 结果
     */
    public int insertBuyerUser(BuyerUser buyerUser);

    /**
     * 修改买家
     * 
     * @param buyerUser 买家
     * @return 结果
     */
    public int updateBuyerUser(BuyerUser buyerUser);

    /**
     * 删除买家
     * 
     * @param userId 买家主键
     * @return 结果
     */
    public int deleteBuyerUserByUserId(String userId);

    /**
     * 批量删除买家
     * 
     * @param userIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBuyerUserByUserIds(String[] userIds);
}

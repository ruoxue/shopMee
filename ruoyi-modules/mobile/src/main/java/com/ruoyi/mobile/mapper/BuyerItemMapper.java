package com.ruoyi.mobile.mapper;

import java.util.List;
import com.ruoyi.mobile.domain.BuyerItem;

/**
 * 购买明细Mapper接口
 * 
 * @author xiaoming
 * @date 2022-08-08
 */
public interface BuyerItemMapper 
{
    /**
     * 查询购买明细
     * 
     * @param orderId 购买明细主键
     * @return 购买明细
     */
    public BuyerItem selectBuyerItemByOrderId(String orderId);

    /**
     * 查询购买明细列表
     * 
     * @param buyerItem 购买明细
     * @return 购买明细集合
     */
    public List<BuyerItem> selectBuyerItemList(BuyerItem buyerItem);

    /**
     * 新增购买明细
     * 
     * @param buyerItem 购买明细
     * @return 结果
     */
    public int insertBuyerItem(BuyerItem buyerItem);

    /**
     * 修改购买明细
     * 
     * @param buyerItem 购买明细
     * @return 结果
     */
    public int updateBuyerItem(BuyerItem buyerItem);

    /**
     * 删除购买明细
     * 
     * @param orderId 购买明细主键
     * @return 结果
     */
    public int deleteBuyerItemByOrderId(String orderId);

    /**
     * 批量删除购买明细
     * 
     * @param orderIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBuyerItemByOrderIds(String[] orderIds);
}

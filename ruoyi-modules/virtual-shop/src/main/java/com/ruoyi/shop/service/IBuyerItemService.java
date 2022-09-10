package com.ruoyi.shop.service;

import java.util.List;
import com.ruoyi.shop.domain.BuyerItem;

/**
 * 购买明细Service接口
 * 
 * @author xiaoming
 * @date 2022-08-07
 */
public interface IBuyerItemService 
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
     * 批量删除购买明细
     * 
     * @param orderIds 需要删除的购买明细主键集合
     * @return 结果
     */
    public int deleteBuyerItemByOrderIds(String[] orderIds);

    /**
     * 删除购买明细信息
     * 
     * @param orderId 购买明细主键
     * @return 结果
     */
    public int deleteBuyerItemByOrderId(String orderId);

    List<BuyerItem> selectBuyerItemListByOrderId(BuyerItem buyerItem);
}

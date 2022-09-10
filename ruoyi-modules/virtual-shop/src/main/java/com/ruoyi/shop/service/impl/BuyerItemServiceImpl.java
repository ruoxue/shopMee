package com.ruoyi.shop.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.shop.mapper.BuyerItemMapper;
import com.ruoyi.shop.domain.BuyerItem;
import com.ruoyi.shop.service.IBuyerItemService;

/**
 * 购买明细Service业务层处理
 * 
 * @author xiaoming
 * @date 2022-08-07
 */
@Service
public class BuyerItemServiceImpl implements IBuyerItemService 
{
    @Autowired
    private BuyerItemMapper buyerItemMapper;

    /**
     * 查询购买明细
     * 
     * @param orderId 购买明细主键
     * @return 购买明细
     */
    @Override
    public BuyerItem selectBuyerItemByOrderId(String orderId)
    {
        return buyerItemMapper.selectBuyerItemByOrderId(orderId);
    }

    /**
     * 查询购买明细列表
     * 
     * @param buyerItem 购买明细
     * @return 购买明细
     */
    @Override
    public List<BuyerItem> selectBuyerItemList(BuyerItem buyerItem)
    {
        return buyerItemMapper.selectBuyerItemList(buyerItem);
    }

    /**
     * 新增购买明细
     * 
     * @param buyerItem 购买明细
     * @return 结果
     */
    @Override
    public int insertBuyerItem(BuyerItem buyerItem)
    {
        return buyerItemMapper.insertBuyerItem(buyerItem);
    }

    /**
     * 修改购买明细
     * 
     * @param buyerItem 购买明细
     * @return 结果
     */
    @Override
    public int updateBuyerItem(BuyerItem buyerItem)
    {
        return buyerItemMapper.updateBuyerItem(buyerItem);
    }

    /**
     * 批量删除购买明细
     * 
     * @param orderIds 需要删除的购买明细主键
     * @return 结果
     */
    @Override
    public int deleteBuyerItemByOrderIds(String[] orderIds)
    {
        return buyerItemMapper.deleteBuyerItemByOrderIds(orderIds);
    }

    /**
     * 删除购买明细信息
     * 
     * @param orderId 购买明细主键
     * @return 结果
     */
    @Override
    public int deleteBuyerItemByOrderId(String orderId)
    {
        return buyerItemMapper.deleteBuyerItemByOrderId(orderId);
    }

    @Override
    public List<BuyerItem> selectBuyerItemListByOrderId(BuyerItem buyerItem) {
        return buyerItemMapper.selectBuyerByOrderId(buyerItem);
    }
}

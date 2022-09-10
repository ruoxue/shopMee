//package com.ruoyi.mobile.service.impl;
//
//import java.util.List;
//
//import com.ruoyi.mobile.domain.vo.BuyerOrderVO;
//import com.ruoyi.shop.domain.BuyerOrder;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import com.ruoyi.mobile.mapper.BuyerOrderMapper;
//import com.ruoyi.mobile.service.IBuyerOrderService;
//
///**
// * 订单Service业务层处理
// *
// * @author xiaoming
// * @date 2022-08-08
// */
//@Service
//public class BuyerOrderServiceImpl implements IBuyerOrderService
//{
//    @Autowired
//    private BuyerOrderMapper buyerOrderMapper;
//
//    /**
//     * 查询订单
//     *
//     * @param orderId 订单主键
//     * @return 订单
//     */
//    @Override
//    public BuyerOrder selectBuyerOrderByOrderId(String orderId)
//    {
//        return buyerOrderMapper.selectBuyerOrderByOrderId(orderId);
//    }
//
//    /**
//     * 查询订单列表
//     *
//     * @param buyerOrder 订单
//     * @return 订单
//     */
//    @Override
//    public List<BuyerOrderVO> selectBuyerOrderList(BuyerOrder buyerOrder)
//    {
//        return buyerOrderMapper.selectBuyerOrderList(buyerOrder);
//    }
//    @Override
//    public List<BuyerOrderVO> selectSaleOrderList(BuyerOrder buyerOrder)
//    {
//        return buyerOrderMapper.selectSaleOrderList(buyerOrder);
//    }
//    /**
//     * 新增订单
//     *
//     * @param buyerOrder 订单
//     * @return 结果
//     */
//    @Override
//    public int insertBuyerOrder(BuyerOrder buyerOrder)
//    {
//        return buyerOrderMapper.insertBuyerOrder(buyerOrder);
//    }
//
//    /**
//     * 修改订单
//     *
//     * @param buyerOrder 订单
//     * @return 结果
//     */
//    @Override
//    public int updateBuyerOrder(BuyerOrder buyerOrder)
//    {
//        return buyerOrderMapper.updateBuyerOrder(buyerOrder);
//    }
//
//    /**
//     * 批量删除订单
//     *
//     * @param orderIds 需要删除的订单主键
//     * @return 结果
//     */
//    @Override
//    public int deleteBuyerOrderByOrderIds(String[] orderIds)
//    {
//        return buyerOrderMapper.deleteBuyerOrderByOrderIds(orderIds);
//    }
//
//    /**
//     * 删除订单信息
//     *
//     * @param orderId 订单主键
//     * @return 结果
//     */
//    @Override
//    public int deleteBuyerOrderByOrderId(String orderId)
//    {
//        return buyerOrderMapper.deleteBuyerOrderByOrderId(orderId);
//    }
//}

//package com.ruoyi.mobile.service;
//
//import java.util.List;
//import com.ruoyi.mobile.domain.vo.BuyerOrderVO;
//import com.ruoyi.shop.domain.BuyerOrder;
//
///**
// * 订单Service接口
// *
// * @author xiaoming
// * @date 2022-08-08
// */
//public interface IBuyerOrderService
//{
//    /**
//     * 查询订单
//     *
//     * @param orderId 订单主键
//     * @return 订单
//     */
//    public BuyerOrder selectBuyerOrderByOrderId(String orderId);
//
//    /**
//     * 查询订单列表
//     *
//     * @param buyerOrder 订单
//     * @return 订单集合
//     */
//    public List<BuyerOrderVO> selectBuyerOrderList(BuyerOrder buyerOrder);
//    public List<BuyerOrderVO> selectSaleOrderList(BuyerOrder buyerOrder);
//
//    /**
//     * 新增订单
//     *
//     * @param buyerOrder 订单
//     * @return 结果
//     */
//    public int insertBuyerOrder(BuyerOrder buyerOrder);
//
//    /**
//     * 修改订单
//     *
//     * @param buyerOrder 订单
//     * @return 结果
//     */
//    public int updateBuyerOrder(BuyerOrder buyerOrder);
//
//    /**
//     * 批量删除订单
//     *
//     * @param orderIds 需要删除的订单主键集合
//     * @return 结果
//     */
//    public int deleteBuyerOrderByOrderIds(String[] orderIds);
//
//    /**
//     * 删除订单信息
//     *
//     * @param orderId 订单主键
//     * @return 结果
//     */
//    public int deleteBuyerOrderByOrderId(String orderId);
//}

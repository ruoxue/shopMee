package com.ruoyi.shop.mapper;

import java.util.List;
import java.util.Map;

import com.ruoyi.shop.domain.OrderBasicVO;
import com.ruoyi.shop.domain.OrderPO;
import com.ruoyi.shop.domain.BuyerOrder;

/**
 * 订单Mapper接口
 * 
 * @author xiaoming
 * @date 2022-08-07
 */
public interface BuyerOrderMapper 
{
    /**
     * 查询订单
     * 
     * @param orderId 订单主键
     * @return 订单
     */
    public OrderPO selectBuyerOrderByOrderId(String orderId);

    /**
     * 查询订单列表
     * 
     * @param buyerOrder 订单
     * @return 订单集合
     */
    public List<BuyerOrder> selectBuyerOrderList(BuyerOrder buyerOrder);

    /**
     * 新增订单
     * 
     * @param buyerOrder 订单
     * @return 结果
     */
    public int insertBuyerOrder(BuyerOrder buyerOrder);

    /**
     * 修改订单
     * 
     * @param buyerOrder 订单
     * @return 结果
     */
    public int updateBuyerOrder(BuyerOrder buyerOrder);

    /**
     * 删除订单
     * 
     * @param orderId 订单主键
     * @return 结果
     */
    public int deleteBuyerOrderByOrderId(String orderId);

    /**
     * 批量删除订单
     * 
     * @param orderIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBuyerOrderByOrderIds(String[] orderIds);

    List<OrderPO> selectOrderList(BuyerOrder buyerOrder);

    List<OrderPO> selectSaleOrderList(BuyerOrder buyerOrder);

    List<OrderBasicVO> basicSaleInfo(Long uid);

    List<OrderBasicVO> basicBuyInfo(Long uid);

    List<OrderBasicVO>  basicCurrentInfo(Long uid);
    List<OrderBasicVO>  basicCurrentAmountInfo(Long uid);


}

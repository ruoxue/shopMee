package com.ruoyi.shop.service;

import java.util.List;
import com.ruoyi.shop.domain.PayCommitOrder;

/**
 * 预付卡订单Service接口
 * 
 * @author xiaoming
 * @date 2022-09-10
 */
public interface IPayCommitOrderService 
{
    /**
     * 查询预付卡订单
     * 
     * @param revision 预付卡订单主键
     * @return 预付卡订单
     */
    public PayCommitOrder selectPayCommitOrderByRevision(Long revision);

    /**
     * 查询预付卡订单列表
     * 
     * @param payCommitOrder 预付卡订单
     * @return 预付卡订单集合
     */
    public List<PayCommitOrder> selectPayCommitOrderList(PayCommitOrder payCommitOrder);

    /**
     * 新增预付卡订单
     * 
     * @param payCommitOrder 预付卡订单
     * @return 结果
     */
    public int insertPayCommitOrder(PayCommitOrder payCommitOrder);

    /**
     * 修改预付卡订单
     * 
     * @param payCommitOrder 预付卡订单
     * @return 结果
     */
    public int updatePayCommitOrder(PayCommitOrder payCommitOrder);

    /**
     * 批量删除预付卡订单
     * 
     * @param revisions 需要删除的预付卡订单主键集合
     * @return 结果
     */
    public int deletePayCommitOrderByRevisions(Long[] revisions);

    /**
     * 删除预付卡订单信息
     * 
     * @param revision 预付卡订单主键
     * @return 结果
     */
    public int deletePayCommitOrderByRevision(Long revision);
}

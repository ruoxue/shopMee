package com.ruoyi.shop.mapper;

import java.util.List;
import com.ruoyi.shop.domain.PayCommitOrder;

/**
 * 预付卡订单Mapper接口
 * 
 * @author xiaoming
 * @date 2022-09-10
 */
public interface PayCommitOrderMapper 
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
     * 删除预付卡订单
     * 
     * @param revision 预付卡订单主键
     * @return 结果
     */
    public int deletePayCommitOrderByRevision(Long revision);

    /**
     * 批量删除预付卡订单
     * 
     * @param revisions 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePayCommitOrderByRevisions(Long[] revisions);
}

package com.ruoyi.shop.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.shop.mapper.PayCommitOrderMapper;
import com.ruoyi.shop.domain.PayCommitOrder;
import com.ruoyi.shop.service.IPayCommitOrderService;

/**
 * 预付卡订单Service业务层处理
 * 
 * @author xiaoming
 * @date 2022-09-10
 */
@Service
public class PayCommitOrderServiceImpl implements IPayCommitOrderService 
{
    @Autowired
    private PayCommitOrderMapper payCommitOrderMapper;

    /**
     * 查询预付卡订单
     * 
     * @param revision 预付卡订单主键
     * @return 预付卡订单
     */
    @Override
    public PayCommitOrder selectPayCommitOrderByRevision(Long revision)
    {
        return payCommitOrderMapper.selectPayCommitOrderByRevision(revision);
    }

    /**
     * 查询预付卡订单列表
     * 
     * @param payCommitOrder 预付卡订单
     * @return 预付卡订单
     */
    @Override
    public List<PayCommitOrder> selectPayCommitOrderList(PayCommitOrder payCommitOrder)
    {
        return payCommitOrderMapper.selectPayCommitOrderList(payCommitOrder);
    }

    /**
     * 新增预付卡订单
     * 
     * @param payCommitOrder 预付卡订单
     * @return 结果
     */
    @Override
    public int insertPayCommitOrder(PayCommitOrder payCommitOrder)
    {
        return payCommitOrderMapper.insertPayCommitOrder(payCommitOrder);
    }

    /**
     * 修改预付卡订单
     * 
     * @param payCommitOrder 预付卡订单
     * @return 结果
     */
    @Override
    public int updatePayCommitOrder(PayCommitOrder payCommitOrder)
    {
        return payCommitOrderMapper.updatePayCommitOrder(payCommitOrder);
    }

    /**
     * 批量删除预付卡订单
     * 
     * @param revisions 需要删除的预付卡订单主键
     * @return 结果
     */
    @Override
    public int deletePayCommitOrderByRevisions(Long[] revisions)
    {
        return payCommitOrderMapper.deletePayCommitOrderByRevisions(revisions);
    }

    /**
     * 删除预付卡订单信息
     * 
     * @param revision 预付卡订单主键
     * @return 结果
     */
    @Override
    public int deletePayCommitOrderByRevision(Long revision)
    {
        return payCommitOrderMapper.deletePayCommitOrderByRevision(revision);
    }
}

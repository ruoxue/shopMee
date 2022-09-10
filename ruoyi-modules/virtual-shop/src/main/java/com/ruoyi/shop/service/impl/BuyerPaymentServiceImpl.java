package com.ruoyi.shop.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.shop.mapper.BuyerPaymentMapper;
import com.ruoyi.shop.domain.BuyerPayment;
import com.ruoyi.shop.service.IBuyerPaymentService;

/**
 * 支付Service业务层处理
 * 
 * @author xiaoming
 * @date 2022-08-07
 */
@Service
public class BuyerPaymentServiceImpl implements IBuyerPaymentService 
{
    @Autowired
    private BuyerPaymentMapper buyerPaymentMapper;

    /**
     * 查询支付
     * 
     * @param revision 支付主键
     * @return 支付
     */
    @Override
    public BuyerPayment selectBuyerPaymentByRevision(Long revision)
    {
        return buyerPaymentMapper.selectBuyerPaymentByRevision(revision);
    }

    /**
     * 查询支付列表
     * 
     * @param buyerPayment 支付
     * @return 支付
     */
    @Override
    public List<BuyerPayment> selectBuyerPaymentList(BuyerPayment buyerPayment)
    {
        return buyerPaymentMapper.selectBuyerPaymentList(buyerPayment);
    }

    /**
     * 新增支付
     * 
     * @param buyerPayment 支付
     * @return 结果
     */
    @Override
    public int insertBuyerPayment(BuyerPayment buyerPayment)
    {
        return buyerPaymentMapper.insertBuyerPayment(buyerPayment);
    }

    /**
     * 修改支付
     * 
     * @param buyerPayment 支付
     * @return 结果
     */
    @Override
    public int updateBuyerPayment(BuyerPayment buyerPayment)
    {
        return buyerPaymentMapper.updateBuyerPayment(buyerPayment);
    }

    /**
     * 批量删除支付
     * 
     * @param revisions 需要删除的支付主键
     * @return 结果
     */
    @Override
    public int deleteBuyerPaymentByRevisions(Long[] revisions)
    {
        return buyerPaymentMapper.deleteBuyerPaymentByRevisions(revisions);
    }

    /**
     * 删除支付信息
     * 
     * @param revision 支付主键
     * @return 结果
     */
    @Override
    public int deleteBuyerPaymentByRevision(Long revision)
    {
        return buyerPaymentMapper.deleteBuyerPaymentByRevision(revision);
    }
}

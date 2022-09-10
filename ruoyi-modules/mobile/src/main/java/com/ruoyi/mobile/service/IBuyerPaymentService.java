package com.ruoyi.mobile.service;

import java.util.List;
import com.ruoyi.mobile.domain.BuyerPayment;

/**
 * 支付Service接口
 * 
 * @author xiaoming
 * @date 2022-08-08
 */
public interface IBuyerPaymentService 
{
    /**
     * 查询支付
     * 
     * @param revision 支付主键
     * @return 支付
     */
    public BuyerPayment selectBuyerPaymentByRevision(Long revision);

    /**
     * 查询支付列表
     * 
     * @param buyerPayment 支付
     * @return 支付集合
     */
    public List<BuyerPayment> selectBuyerPaymentList(BuyerPayment buyerPayment);

    /**
     * 新增支付
     * 
     * @param buyerPayment 支付
     * @return 结果
     */
    public int insertBuyerPayment(BuyerPayment buyerPayment);

    /**
     * 修改支付
     * 
     * @param buyerPayment 支付
     * @return 结果
     */
    public int updateBuyerPayment(BuyerPayment buyerPayment);

    /**
     * 批量删除支付
     * 
     * @param revisions 需要删除的支付主键集合
     * @return 结果
     */
    public int deleteBuyerPaymentByRevisions(Long[] revisions);

    /**
     * 删除支付信息
     * 
     * @param revision 支付主键
     * @return 结果
     */
    public int deleteBuyerPaymentByRevision(Long revision);
}

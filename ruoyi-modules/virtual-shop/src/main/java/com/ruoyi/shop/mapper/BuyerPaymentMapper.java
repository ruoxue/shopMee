package com.ruoyi.shop.mapper;

import java.util.List;
import com.ruoyi.shop.domain.BuyerPayment;

/**
 * 支付Mapper接口
 * 
 * @author xiaoming
 * @date 2022-08-07
 */
public interface BuyerPaymentMapper 
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
     * 删除支付
     * 
     * @param revision 支付主键
     * @return 结果
     */
    public int deleteBuyerPaymentByRevision(Long revision);

    /**
     * 批量删除支付
     * 
     * @param revisions 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBuyerPaymentByRevisions(Long[] revisions);
}

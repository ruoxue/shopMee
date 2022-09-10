package com.ruoyi.shop.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.shop.mapper.PayCommitMapper;
import com.ruoyi.shop.domain.PayCommit;
import com.ruoyi.shop.service.IPayCommitService;

/**
 * 求购自动提交信息Service业务层处理
 * 
 * @author xiaoming
 * @date 2022-09-10
 */
@Service
public class PayCommitServiceImpl implements IPayCommitService 
{
    @Autowired
    private PayCommitMapper payCommitMapper;

    /**
     * 查询求购自动提交信息
     * 
     * @param id 求购自动提交信息主键
     * @return 求购自动提交信息
     */
    @Override
    public PayCommit selectPayCommitById(Long id)
    {
        return payCommitMapper.selectPayCommitById(id);
    }

    /**
     * 查询求购自动提交信息列表
     * 
     * @param payCommit 求购自动提交信息
     * @return 求购自动提交信息
     */
    @Override
    public List<PayCommit> selectPayCommitList(PayCommit payCommit)
    {
        return payCommitMapper.selectPayCommitList(payCommit);
    }

    /**
     * 新增求购自动提交信息
     * 
     * @param payCommit 求购自动提交信息
     * @return 结果
     */
    @Override
    public int insertPayCommit(PayCommit payCommit)
    {
        return payCommitMapper.insertPayCommit(payCommit);
    }

    /**
     * 修改求购自动提交信息
     * 
     * @param payCommit 求购自动提交信息
     * @return 结果
     */
    @Override
    public int updatePayCommit(PayCommit payCommit)
    {
        return payCommitMapper.updatePayCommit(payCommit);
    }

    /**
     * 批量删除求购自动提交信息
     * 
     * @param ids 需要删除的求购自动提交信息主键
     * @return 结果
     */
    @Override
    public int deletePayCommitByIds(Long[] ids)
    {
        return payCommitMapper.deletePayCommitByIds(ids);
    }

    /**
     * 删除求购自动提交信息信息
     * 
     * @param id 求购自动提交信息主键
     * @return 结果
     */
    @Override
    public int deletePayCommitById(Long id)
    {
        return payCommitMapper.deletePayCommitById(id);
    }
}

package com.ruoyi.shop.service;

import java.util.List;
import com.ruoyi.shop.domain.PayCommit;

/**
 * 求购自动提交信息Service接口
 * 
 * @author xiaoming
 * @date 2022-09-10
 */
public interface IPayCommitService 
{
    /**
     * 查询求购自动提交信息
     * 
     * @param id 求购自动提交信息主键
     * @return 求购自动提交信息
     */
    public PayCommit selectPayCommitById(Long id);

    /**
     * 查询求购自动提交信息列表
     * 
     * @param payCommit 求购自动提交信息
     * @return 求购自动提交信息集合
     */
    public List<PayCommit> selectPayCommitList(PayCommit payCommit);

    /**
     * 新增求购自动提交信息
     * 
     * @param payCommit 求购自动提交信息
     * @return 结果
     */
    public int insertPayCommit(PayCommit payCommit);

    /**
     * 修改求购自动提交信息
     * 
     * @param payCommit 求购自动提交信息
     * @return 结果
     */
    public int updatePayCommit(PayCommit payCommit);

    /**
     * 批量删除求购自动提交信息
     * 
     * @param ids 需要删除的求购自动提交信息主键集合
     * @return 结果
     */
    public int deletePayCommitByIds(Long[] ids);

    /**
     * 删除求购自动提交信息信息
     * 
     * @param id 求购自动提交信息主键
     * @return 结果
     */
    public int deletePayCommitById(Long id);
}

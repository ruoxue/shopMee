package com.ruoyi.shop.service;

import java.util.List;
import com.ruoyi.shop.domain.PayCommitFormate;

/**
 * 求购商品格式Service接口
 * 
 * @author xiaoming
 * @date 2022-09-11
 */
public interface IPayCommitFormateService 
{
    /**
     * 查询求购商品格式
     * 
     * @param id 求购商品格式主键
     * @return 求购商品格式
     */
    public PayCommitFormate selectPayCommitFormateById(Long id);

    /**
     * 查询求购商品格式列表
     * 
     * @param payCommitFormate 求购商品格式
     * @return 求购商品格式集合
     */
    public List<PayCommitFormate> selectPayCommitFormateList(PayCommitFormate payCommitFormate);

    /**
     * 新增求购商品格式
     * 
     * @param payCommitFormate 求购商品格式
     * @return 结果
     */
    public int insertPayCommitFormate(PayCommitFormate payCommitFormate);

    /**
     * 修改求购商品格式
     * 
     * @param payCommitFormate 求购商品格式
     * @return 结果
     */
    public int updatePayCommitFormate(PayCommitFormate payCommitFormate);

    /**
     * 批量删除求购商品格式
     * 
     * @param ids 需要删除的求购商品格式主键集合
     * @return 结果
     */
    public int deletePayCommitFormateByIds(Long[] ids);

    /**
     * 删除求购商品格式信息
     * 
     * @param id 求购商品格式主键
     * @return 结果
     */
    public int deletePayCommitFormateById(Long id);
}

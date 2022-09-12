package com.ruoyi.shop.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.shop.mapper.PayCommitFormateMapper;
import com.ruoyi.shop.domain.PayCommitFormate;
import com.ruoyi.shop.service.IPayCommitFormateService;

/**
 * 求购商品格式Service业务层处理
 * 
 * @author xiaoming
 * @date 2022-09-11
 */
@Service
public class PayCommitFormateServiceImpl implements IPayCommitFormateService 
{
    @Autowired
    private PayCommitFormateMapper payCommitFormateMapper;

    /**
     * 查询求购商品格式
     * 
     * @param id 求购商品格式主键
     * @return 求购商品格式
     */
    @Override
    public PayCommitFormate selectPayCommitFormateById(Long id)
    {
        return payCommitFormateMapper.selectPayCommitFormateById(id);
    }

    /**
     * 查询求购商品格式列表
     * 
     * @param payCommitFormate 求购商品格式
     * @return 求购商品格式
     */
    @Override
    public List<PayCommitFormate> selectPayCommitFormateList(PayCommitFormate payCommitFormate)
    {
        return payCommitFormateMapper.selectPayCommitFormateList(payCommitFormate);
    }

    /**
     * 新增求购商品格式
     * 
     * @param payCommitFormate 求购商品格式
     * @return 结果
     */
    @Override
    public int insertPayCommitFormate(PayCommitFormate payCommitFormate)
    {
        return payCommitFormateMapper.insertPayCommitFormate(payCommitFormate);
    }

    /**
     * 修改求购商品格式
     * 
     * @param payCommitFormate 求购商品格式
     * @return 结果
     */
    @Override
    public int updatePayCommitFormate(PayCommitFormate payCommitFormate)
    {
        return payCommitFormateMapper.updatePayCommitFormate(payCommitFormate);
    }

    /**
     * 批量删除求购商品格式
     * 
     * @param ids 需要删除的求购商品格式主键
     * @return 结果
     */
    @Override
    public int deletePayCommitFormateByIds(Long[] ids)
    {
        return payCommitFormateMapper.deletePayCommitFormateByIds(ids);
    }

    /**
     * 删除求购商品格式信息
     * 
     * @param id 求购商品格式主键
     * @return 结果
     */
    @Override
    public int deletePayCommitFormateById(Long id)
    {
        return payCommitFormateMapper.deletePayCommitFormateById(id);
    }
}

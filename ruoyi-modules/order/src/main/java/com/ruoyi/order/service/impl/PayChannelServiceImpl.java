package com.ruoyi.order.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.order.mapper.PayChannelMapper;
import com.ruoyi.order.domain.PayChannel;
import com.ruoyi.order.service.IPayChannelService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author xiaoming
 * @date 2022-08-28
 */
@Service
public class PayChannelServiceImpl implements IPayChannelService 
{
    @Autowired
    private PayChannelMapper payChannelMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public PayChannel selectPayChannelById(Long id)
    {
        return payChannelMapper.selectPayChannelById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param payChannel 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<PayChannel> selectPayChannelList(PayChannel payChannel)
    {
        return payChannelMapper.selectPayChannelList(payChannel);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param payChannel 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertPayChannel(PayChannel payChannel)
    {
        return payChannelMapper.insertPayChannel(payChannel);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param payChannel 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updatePayChannel(PayChannel payChannel)
    {
        return payChannelMapper.updatePayChannel(payChannel);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deletePayChannelByIds(Long[] ids)
    {
        return payChannelMapper.deletePayChannelByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deletePayChannelById(Long id)
    {
        return payChannelMapper.deletePayChannelById(id);
    }
}

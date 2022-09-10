package com.ruoyi.order.service;

import java.util.List;
import com.ruoyi.order.domain.PayChannel;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author xiaoming
 * @date 2022-08-28
 */
public interface IPayChannelService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public PayChannel selectPayChannelById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param payChannel 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<PayChannel> selectPayChannelList(PayChannel payChannel);

    /**
     * 新增【请填写功能名称】
     * 
     * @param payChannel 【请填写功能名称】
     * @return 结果
     */
    public int insertPayChannel(PayChannel payChannel);

    /**
     * 修改【请填写功能名称】
     * 
     * @param payChannel 【请填写功能名称】
     * @return 结果
     */
    public int updatePayChannel(PayChannel payChannel);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deletePayChannelByIds(Long[] ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deletePayChannelById(Long id);
}

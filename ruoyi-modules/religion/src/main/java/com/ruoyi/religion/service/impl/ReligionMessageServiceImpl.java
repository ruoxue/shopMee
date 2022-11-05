package com.ruoyi.religion.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.religion.mapper.ReligionMessageMapper;
import com.ruoyi.religion.domain.ReligionMessage;
import com.ruoyi.religion.service.IReligionMessageService;

/**
 * 预警Service业务层处理
 * 
 * @author xiaoming
 * @date 2022-10-22 09:17:32
 */
@Service
public class ReligionMessageServiceImpl implements IReligionMessageService 
{
    @Autowired
    private ReligionMessageMapper religionMessageMapper;

    /**
     * 查询预警
     * 
     * @param id 预警主键
     * @return 预警
     */
    @Override
    public ReligionMessage selectReligionMessageById(Long id)
    {
        return religionMessageMapper.selectReligionMessageById(id);
    }

    /**
     * 查询预警列表
     * 
     * @param religionMessage 预警
     * @return 预警
     */
    @Override
    public List<ReligionMessage> selectReligionMessageList(ReligionMessage religionMessage)
    {
        return religionMessageMapper.selectReligionMessageList(religionMessage);
    }

    /**
     * 新增预警
     * 
     * @param religionMessage 预警
     * @return 结果
     */
    @Override
    public int insertReligionMessage(ReligionMessage religionMessage)
    {
        religionMessage.setCreateTime(DateUtils.getNowDate());
        return religionMessageMapper.insertReligionMessage(religionMessage);
    }

    /**
     * 修改预警
     * 
     * @param religionMessage 预警
     * @return 结果
     */
    @Override
    public int updateReligionMessage(ReligionMessage religionMessage)
    {
        religionMessage.setUpdateTime(DateUtils.getNowDate());
        return religionMessageMapper.updateReligionMessage(religionMessage);
    }

    /**
     * 批量删除预警
     * 
     * @param ids 需要删除的预警主键
     * @return 结果
     */
    @Override
    public int deleteReligionMessageByIds(Long[] ids)
    {
        return religionMessageMapper.deleteReligionMessageByIds(ids);
    }

    /**
     * 删除预警信息
     * 
     * @param id 预警主键
     * @return 结果
     */
    @Override
    public int deleteReligionMessageById(Long id)
    {
        return religionMessageMapper.deleteReligionMessageById(id);
    }
}

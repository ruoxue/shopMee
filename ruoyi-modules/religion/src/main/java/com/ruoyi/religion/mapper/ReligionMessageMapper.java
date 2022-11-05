package com.ruoyi.religion.mapper;

import java.util.List;
import com.ruoyi.religion.domain.ReligionMessage;

/**
 * 预警Mapper接口
 * 
 * @author xiaoming
 * @date 2022-10-22 09:17:32
 */
public interface ReligionMessageMapper 
{
    /**
     * 查询预警
     * 
     * @param id 预警主键
     * @return 预警
     */
    public ReligionMessage selectReligionMessageById(Long id);

    /**
     * 查询预警列表
     * 
     * @param religionMessage 预警
     * @return 预警集合
     */
    public List<ReligionMessage> selectReligionMessageList(ReligionMessage religionMessage);

    /**
     * 新增预警
     * 
     * @param religionMessage 预警
     * @return 结果
     */
    public int insertReligionMessage(ReligionMessage religionMessage);

    /**
     * 修改预警
     * 
     * @param religionMessage 预警
     * @return 结果
     */
    public int updateReligionMessage(ReligionMessage religionMessage);

    /**
     * 删除预警
     * 
     * @param id 预警主键
     * @return 结果
     */
    public int deleteReligionMessageById(Long id);

    /**
     * 批量删除预警
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteReligionMessageByIds(Long[] ids);
}

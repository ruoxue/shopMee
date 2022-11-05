package com.ruoyi.religion.mapper;

import java.util.List;
import com.ruoyi.religion.domain.ReligionFinanceComplain;

/**
 * 财务投诉Mapper接口
 * 
 * @author xiaoming
 * @date 2022-10-22 09:17:32
 */
public interface ReligionFinanceComplainMapper 
{
    /**
     * 查询财务投诉
     * 
     * @param id 财务投诉主键
     * @return 财务投诉
     */
    public ReligionFinanceComplain selectReligionFinanceComplainById(Long id);

    /**
     * 查询财务投诉列表
     * 
     * @param religionFinanceComplain 财务投诉
     * @return 财务投诉集合
     */
    public List<ReligionFinanceComplain> selectReligionFinanceComplainList(ReligionFinanceComplain religionFinanceComplain);

    /**
     * 新增财务投诉
     * 
     * @param religionFinanceComplain 财务投诉
     * @return 结果
     */
    public int insertReligionFinanceComplain(ReligionFinanceComplain religionFinanceComplain);

    /**
     * 修改财务投诉
     * 
     * @param religionFinanceComplain 财务投诉
     * @return 结果
     */
    public int updateReligionFinanceComplain(ReligionFinanceComplain religionFinanceComplain);

    /**
     * 删除财务投诉
     * 
     * @param id 财务投诉主键
     * @return 结果
     */
    public int deleteReligionFinanceComplainById(Long id);

    /**
     * 批量删除财务投诉
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteReligionFinanceComplainByIds(Long[] ids);
}

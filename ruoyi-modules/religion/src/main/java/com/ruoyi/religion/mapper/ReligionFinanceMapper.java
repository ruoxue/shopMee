package com.ruoyi.religion.mapper;

import java.util.List;
import com.ruoyi.religion.domain.ReligionFinance;

/**
 * 财务数据Mapper接口
 * 
 * @author xiaoming
 * @date 2022-10-22 09:17:31
 */
public interface ReligionFinanceMapper 
{
    /**
     * 查询财务数据
     * 
     * @param id 财务数据主键
     * @return 财务数据
     */
    public ReligionFinance selectReligionFinanceById(Long id);

    /**
     * 查询财务数据列表
     * 
     * @param religionFinance 财务数据
     * @return 财务数据集合
     */
    public List<ReligionFinance> selectReligionFinanceList(ReligionFinance religionFinance);

    /**
     * 新增财务数据
     * 
     * @param religionFinance 财务数据
     * @return 结果
     */
    public int insertReligionFinance(ReligionFinance religionFinance);

    /**
     * 修改财务数据
     * 
     * @param religionFinance 财务数据
     * @return 结果
     */
    public int updateReligionFinance(ReligionFinance religionFinance);

    /**
     * 删除财务数据
     * 
     * @param id 财务数据主键
     * @return 结果
     */
    public int deleteReligionFinanceById(Long id);

    /**
     * 批量删除财务数据
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteReligionFinanceByIds(Long[] ids);
}

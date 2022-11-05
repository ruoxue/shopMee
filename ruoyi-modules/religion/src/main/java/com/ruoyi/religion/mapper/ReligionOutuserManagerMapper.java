package com.ruoyi.religion.mapper;

import java.util.List;
import com.ruoyi.religion.domain.ReligionOutuserManager;

/**
 * 临时人员登记Mapper接口
 * 
 * @author xiaoming
 * @date 2022-10-22 09:17:32
 */
public interface ReligionOutuserManagerMapper 
{
    /**
     * 查询临时人员登记
     * 
     * @param id 临时人员登记主键
     * @return 临时人员登记
     */
    public ReligionOutuserManager selectReligionOutuserManagerById(Long id);

    /**
     * 查询临时人员登记列表
     * 
     * @param religionOutuserManager 临时人员登记
     * @return 临时人员登记集合
     */
    public List<ReligionOutuserManager> selectReligionOutuserManagerList(ReligionOutuserManager religionOutuserManager);

    /**
     * 新增临时人员登记
     * 
     * @param religionOutuserManager 临时人员登记
     * @return 结果
     */
    public int insertReligionOutuserManager(ReligionOutuserManager religionOutuserManager);

    /**
     * 修改临时人员登记
     * 
     * @param religionOutuserManager 临时人员登记
     * @return 结果
     */
    public int updateReligionOutuserManager(ReligionOutuserManager religionOutuserManager);

    /**
     * 删除临时人员登记
     * 
     * @param id 临时人员登记主键
     * @return 结果
     */
    public int deleteReligionOutuserManagerById(Long id);

    /**
     * 批量删除临时人员登记
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteReligionOutuserManagerByIds(Long[] ids);
}

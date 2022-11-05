package com.ruoyi.religion.service;

import java.util.List;
import com.ruoyi.religion.domain.ReligionConvenience;

/**
 * 便民服务Service接口
 * 
 * @author xiaoming
 * @date 2022-10-22 09:17:31
 */
public interface IReligionConvenienceService 
{
    /**
     * 查询便民服务
     * 
     * @param id 便民服务主键
     * @return 便民服务
     */
    public ReligionConvenience selectReligionConvenienceById(Long id);

    /**
     * 查询便民服务列表
     * 
     * @param religionConvenience 便民服务
     * @return 便民服务集合
     */
    public List<ReligionConvenience> selectReligionConvenienceList(ReligionConvenience religionConvenience);

    /**
     * 新增便民服务
     * 
     * @param religionConvenience 便民服务
     * @return 结果
     */
    public int insertReligionConvenience(ReligionConvenience religionConvenience);

    /**
     * 修改便民服务
     * 
     * @param religionConvenience 便民服务
     * @return 结果
     */
    public int updateReligionConvenience(ReligionConvenience religionConvenience);

    /**
     * 批量删除便民服务
     * 
     * @param ids 需要删除的便民服务主键集合
     * @return 结果
     */
    public int deleteReligionConvenienceByIds(Long[] ids);

    /**
     * 删除便民服务信息
     * 
     * @param id 便民服务主键
     * @return 结果
     */
    public int deleteReligionConvenienceById(Long id);
}

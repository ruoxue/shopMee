package com.ruoyi.shop.mapper;

import java.util.List;
import com.ruoyi.shop.domain.City;

/**
 * 城市Mapper接口
 * 
 * @author xiaoming
 * @date 2022-09-11
 */
public interface CityMapper 
{
    /**
     * 查询城市
     * 
     * @param id 城市主键
     * @return 城市
     */
    public City selectCityById(Long id);

    /**
     * 查询城市列表
     * 
     * @param city 城市
     * @return 城市集合
     */
    public List<City> selectCityList(City city);

    /**
     * 新增城市
     * 
     * @param city 城市
     * @return 结果
     */
    public int insertCity(City city);

    /**
     * 修改城市
     * 
     * @param city 城市
     * @return 结果
     */
    public int updateCity(City city);

    /**
     * 删除城市
     * 
     * @param id 城市主键
     * @return 结果
     */
    public int deleteCityById(Long id);

    /**
     * 批量删除城市
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCityByIds(Long[] ids);
}

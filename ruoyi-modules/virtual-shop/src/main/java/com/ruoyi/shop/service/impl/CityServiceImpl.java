package com.ruoyi.shop.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.shop.mapper.CityMapper;
import com.ruoyi.shop.domain.City;
import com.ruoyi.shop.service.ICityService;

/**
 * 城市Service业务层处理
 * 
 * @author xiaoming
 * @date 2022-09-11
 */
@Service
public class CityServiceImpl implements ICityService 
{
    @Autowired
    private CityMapper cityMapper;

    /**
     * 查询城市
     * 
     * @param id 城市主键
     * @return 城市
     */
    @Override
    public City selectCityById(Long id)
    {
        return cityMapper.selectCityById(id);
    }

    /**
     * 查询城市列表
     * 
     * @param city 城市
     * @return 城市
     */
    @Override
    public List<City> selectCityList(City city)
    {
        return cityMapper.selectCityList(city);
    }

    /**
     * 新增城市
     * 
     * @param city 城市
     * @return 结果
     */
    @Override
    public int insertCity(City city)
    {
        return cityMapper.insertCity(city);
    }

    /**
     * 修改城市
     * 
     * @param city 城市
     * @return 结果
     */
    @Override
    public int updateCity(City city)
    {
        return cityMapper.updateCity(city);
    }

    /**
     * 批量删除城市
     * 
     * @param ids 需要删除的城市主键
     * @return 结果
     */
    @Override
    public int deleteCityByIds(Long[] ids)
    {
        return cityMapper.deleteCityByIds(ids);
    }

    /**
     * 删除城市信息
     * 
     * @param id 城市主键
     * @return 结果
     */
    @Override
    public int deleteCityById(Long id)
    {
        return cityMapper.deleteCityById(id);
    }
}

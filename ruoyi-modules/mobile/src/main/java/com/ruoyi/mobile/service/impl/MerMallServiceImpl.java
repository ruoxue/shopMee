package com.ruoyi.mobile.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.mobile.mapper.MerMallMapper;
import com.ruoyi.mobile.domain.MerMall;
import com.ruoyi.mobile.service.IMerMallService;

/**
 * 商户店铺Service业务层处理
 * 
 * @author xiaoming
 * @date 2022-08-08
 */
@Service
public class MerMallServiceImpl implements IMerMallService 
{
    @Autowired
    private MerMallMapper merMallMapper;

    /**
     * 查询商户店铺
     * 
     * @param merMallId 商户店铺主键
     * @return 商户店铺
     */
    @Override
    public MerMall selectMerMallByMerMallId(Long merMallId)
    {
        return merMallMapper.selectMerMallByMerMallId(merMallId);
    }

    /**
     * 查询商户店铺列表
     * 
     * @param merMall 商户店铺
     * @return 商户店铺
     */
    @Override
    public List<MerMall> selectMerMallList(MerMall merMall)
    {
        return merMallMapper.selectMerMallList(merMall);
    }

    /**
     * 新增商户店铺
     * 
     * @param merMall 商户店铺
     * @return 结果
     */
    @Override
    public int insertMerMall(MerMall merMall)
    {
        return merMallMapper.insertMerMall(merMall);
    }

    /**
     * 修改商户店铺
     * 
     * @param merMall 商户店铺
     * @return 结果
     */
    @Override
    public int updateMerMall(MerMall merMall)
    {
        return merMallMapper.updateMerMall(merMall);
    }

    /**
     * 批量删除商户店铺
     * 
     * @param merMallIds 需要删除的商户店铺主键
     * @return 结果
     */
    @Override
    public int deleteMerMallByMerMallIds(Long[] merMallIds)
    {
        return merMallMapper.deleteMerMallByMerMallIds(merMallIds);
    }

    /**
     * 删除商户店铺信息
     * 
     * @param merMallId 商户店铺主键
     * @return 结果
     */
    @Override
    public int deleteMerMallByMerMallId(Long merMallId)
    {
        return merMallMapper.deleteMerMallByMerMallId(merMallId);
    }
}

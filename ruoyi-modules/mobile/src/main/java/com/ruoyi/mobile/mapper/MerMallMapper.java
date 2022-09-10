package com.ruoyi.mobile.mapper;

import java.util.List;
import com.ruoyi.mobile.domain.MerMall;

/**
 * 商户店铺Mapper接口
 * 
 * @author xiaoming
 * @date 2022-08-08
 */
public interface MerMallMapper 
{
    /**
     * 查询商户店铺
     * 
     * @param merMallId 商户店铺主键
     * @return 商户店铺
     */
    public MerMall selectMerMallByMerMallId(Long merMallId);

    /**
     * 查询商户店铺列表
     * 
     * @param merMall 商户店铺
     * @return 商户店铺集合
     */
    public List<MerMall> selectMerMallList(MerMall merMall);

    /**
     * 新增商户店铺
     * 
     * @param merMall 商户店铺
     * @return 结果
     */
    public int insertMerMall(MerMall merMall);

    /**
     * 修改商户店铺
     * 
     * @param merMall 商户店铺
     * @return 结果
     */
    public int updateMerMall(MerMall merMall);

    /**
     * 删除商户店铺
     * 
     * @param merMallId 商户店铺主键
     * @return 结果
     */
    public int deleteMerMallByMerMallId(Long merMallId);

    /**
     * 批量删除商户店铺
     * 
     * @param merMallIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteMerMallByMerMallIds(Long[] merMallIds);
}

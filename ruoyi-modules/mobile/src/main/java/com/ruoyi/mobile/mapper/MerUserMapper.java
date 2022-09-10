package com.ruoyi.mobile.mapper;

import java.util.List;
import com.ruoyi.mobile.domain.MerUser;

/**
 * 商户Mapper接口
 * 
 * @author xiaoming
 * @date 2022-08-08
 */
public interface MerUserMapper 
{
    /**
     * 查询商户
     * 
     * @param merId 商户主键
     * @return 商户
     */
    public MerUser selectMerUserByMerId(Long merId);

    /**
     * 查询商户列表
     * 
     * @param merUser 商户
     * @return 商户集合
     */
    public List<MerUser> selectMerUserList(MerUser merUser);

    /**
     * 新增商户
     * 
     * @param merUser 商户
     * @return 结果
     */
    public int insertMerUser(MerUser merUser);

    /**
     * 修改商户
     * 
     * @param merUser 商户
     * @return 结果
     */
    public int updateMerUser(MerUser merUser);

    /**
     * 删除商户
     * 
     * @param merId 商户主键
     * @return 结果
     */
    public int deleteMerUserByMerId(Long merId);

    /**
     * 批量删除商户
     * 
     * @param merIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteMerUserByMerIds(Long[] merIds);
}

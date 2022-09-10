package com.ruoyi.mobile.mapper;

import java.util.List;
import com.ruoyi.mobile.domain.BuyerCart;

/**
 * 购物车Mapper接口
 * 
 * @author xiaoming
 * @date 2022-08-08
 */
public interface BuyerCartMapper 
{
    /**
     * 查询购物车
     * 
     * @param cartId 购物车主键
     * @return 购物车
     */
    public BuyerCart selectBuyerCartByCartId(String cartId);

    /**
     * 查询购物车列表
     * 
     * @param buyerCart 购物车
     * @return 购物车集合
     */
    public List<BuyerCart> selectBuyerCartList(BuyerCart buyerCart);

    /**
     * 新增购物车
     * 
     * @param buyerCart 购物车
     * @return 结果
     */
    public int insertBuyerCart(BuyerCart buyerCart);

    /**
     * 修改购物车
     * 
     * @param buyerCart 购物车
     * @return 结果
     */
    public int updateBuyerCart(BuyerCart buyerCart);

    /**
     * 删除购物车
     * 
     * @param cartId 购物车主键
     * @return 结果
     */
    public int deleteBuyerCartByCartId(String cartId);

    /**
     * 批量删除购物车
     * 
     * @param cartIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBuyerCartByCartIds(String[] cartIds);
}

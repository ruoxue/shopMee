package com.ruoyi.mobile.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.mobile.mapper.BuyerCartMapper;
import com.ruoyi.mobile.domain.BuyerCart;
import com.ruoyi.mobile.service.IBuyerCartService;

/**
 * 购物车Service业务层处理
 * 
 * @author xiaoming
 * @date 2022-08-08
 */
@Service
public class BuyerCartServiceImpl implements IBuyerCartService 
{
    @Autowired
    private BuyerCartMapper buyerCartMapper;

    /**
     * 查询购物车
     * 
     * @param cartId 购物车主键
     * @return 购物车
     */
    @Override
    public BuyerCart selectBuyerCartByCartId(String cartId)
    {
        return buyerCartMapper.selectBuyerCartByCartId(cartId);
    }

    /**
     * 查询购物车列表
     * 
     * @param buyerCart 购物车
     * @return 购物车
     */
    @Override
    public List<BuyerCart> selectBuyerCartList(BuyerCart buyerCart)
    {
        return buyerCartMapper.selectBuyerCartList(buyerCart);
    }

    /**
     * 新增购物车
     * 
     * @param buyerCart 购物车
     * @return 结果
     */
    @Override
    public int insertBuyerCart(BuyerCart buyerCart)
    {
        return buyerCartMapper.insertBuyerCart(buyerCart);
    }

    /**
     * 修改购物车
     * 
     * @param buyerCart 购物车
     * @return 结果
     */
    @Override
    public int updateBuyerCart(BuyerCart buyerCart)
    {
        return buyerCartMapper.updateBuyerCart(buyerCart);
    }

    /**
     * 批量删除购物车
     * 
     * @param cartIds 需要删除的购物车主键
     * @return 结果
     */
    @Override
    public int deleteBuyerCartByCartIds(String[] cartIds)
    {
        return buyerCartMapper.deleteBuyerCartByCartIds(cartIds);
    }

    /**
     * 删除购物车信息
     * 
     * @param cartId 购物车主键
     * @return 结果
     */
    @Override
    public int deleteBuyerCartByCartId(String cartId)
    {
        return buyerCartMapper.deleteBuyerCartByCartId(cartId);
    }
}

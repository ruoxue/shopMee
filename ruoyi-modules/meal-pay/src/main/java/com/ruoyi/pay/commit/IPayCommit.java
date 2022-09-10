package com.ruoyi.pay.commit;

import com.ruoyi.shop.domain.BuyerOrder;

public interface IPayCommit {
    public  void  submit(BuyerOrder buyerOrder, String url,String param);
}

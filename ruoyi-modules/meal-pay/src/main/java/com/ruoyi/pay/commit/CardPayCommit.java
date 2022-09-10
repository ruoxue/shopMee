package com.ruoyi.pay.commit;

import cn.hutool.http.HttpUtil;
import com.ruoyi.shop.domain.BuyerOrder;

public class CardPayCommit implements IPayCommit{
    @Override
    public void submit(BuyerOrder buyerOrder, String url,String param) {


        String post = HttpUtil.post(url, param);
        System.out.println("post = " + post);
    }
}

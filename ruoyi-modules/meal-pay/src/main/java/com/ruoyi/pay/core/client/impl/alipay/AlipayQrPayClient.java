package com.ruoyi.pay.core.client.impl.alipay;

import cn.hutool.json.JSONObject;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.request.AlipayTradeQueryRequest;
import com.alipay.api.response.AlipayTradePagePayResponse;
import com.alipay.api.response.AlipayTradeQueryResponse;
import com.alipay.api.response.AlipayTradeWapPayResponse;
import com.ruoyi.pay.core.client.PayCommonResult;
import com.ruoyi.pay.core.client.dto.PayOrderUnifiedReqDTO;
import com.ruoyi.pay.core.enums.PayChannelEnum;
import com.alipay.api.AlipayApiException;
import com.alipay.api.domain.AlipayTradePrecreateModel;
import com.alipay.api.request.AlipayTradePrecreateRequest;
import com.alipay.api.response.AlipayTradePrecreateResponse;


/**
 * 支付宝【扫码支付】的 PayClient 实现类
 * 文档：https://opendocs.alipay.com/apis/02890k
 *
 * @author 芋道源码
 */

public class AlipayQrPayClient extends AbstractAlipayClient {

    public AlipayQrPayClient(Long channelId, AlipayPayClientConfig config) {
        super(channelId, PayChannelEnum.ALIPAY_QR.getCode(), config, new AlipayPayCodeMapping());
    }

    @Override
    public PayCommonResult<AlipayTradePagePayResponse> doUnifiedOrder(PayOrderUnifiedReqDTO reqDTO) {


        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest(); //创建API对应的request
        alipayRequest.setReturnUrl(reqDTO.getReturnUrl());
        alipayRequest.setNotifyUrl(reqDTO.getNotifyUrl()); //在公共参数中设置回跳和通知地址
        alipayRequest.setBizContent("{" +
                "    \"out_trade_no\":\"" + reqDTO.getMerchantOrderId() + "\"," +
                "    \"product_code\":\"FAST_INSTANT_TRADE_PAY\"," +
                "    \"total_amount\":" + calculateAmount(reqDTO.getAmount()).toString() + "," +
                "    \"subject\":\"" + reqDTO.getSubject() + "\"," +
                "    \"body\":\"" + reqDTO.getBody() + "\"," +
                "    \"passback_params\":\"" + reqDTO.getMerchantOrderId() + "\"," +
                "    \"extend_params\":{" +

                "    }" +
                "  }"); //填充业务参数
        AlipayTradePagePayResponse response=null;
        try {
              response = client.pageExecute(alipayRequest);
        } catch (AlipayApiException e) {
            e.printStackTrace();
            return PayCommonResult.build(e.getErrCode(), e.getErrMsg(), null, codeMapping);

        }

        return PayCommonResult.build("-9999", "ok", response, codeMapping);
    }

    public PayCommonResult<AlipayTradeQueryResponse> doQueryOrder(PayOrderUnifiedReqDTO reqDTO) {
        AlipayTradeQueryRequest request = new AlipayTradeQueryRequest();
        JSONObject bizContent = new JSONObject();
        bizContent.put("out_trade_no", reqDTO.getMerchantOrderId());
        request.setBizContent(bizContent.toString());
        AlipayTradeQueryResponse response = null;
        try {
            response = client.execute(request);
            if (response.isSuccess()) {
                System.out.println("调用成功");
                return PayCommonResult.build("-9999", "Success", response, codeMapping);

            } else {
                System.out.println("调用失败");
            }
        } catch (AlipayApiException e) {
            e.printStackTrace();
            return PayCommonResult.build(e.getErrCode(), e.getErrMsg(), response, codeMapping);

        }

        return PayCommonResult.build(response.getCode(), response.getMsg(), response, codeMapping);

    }
}

package com.ruoyi.pay.core.client.impl.wx;

import com.ruoyi.pay.core.client.AbstractPayCodeMapping;
import com.ruoyi.pay.core.client.ErrorCode;
import com.ruoyi.pay.core.enums.PayFrameworkErrorCodeConstants;
import com.ruoyi.common.core.utils.StringUtils;

import java.util.Objects;

/**
 * 微信支付 PayCodeMapping 实现类
 *
 * @author 芋道源码
 */
public class WXCodeMapping extends AbstractPayCodeMapping {

    /**
     * 错误码 - 成功
     * 由于 weixin-java-pay 封装的 Result 未返回 code，所以自己定义下
     */
    public static final String CODE_SUCCESS = "SUCCESS";
    /**
     * 错误提示 - 成功
     */
    public static final String MESSAGE_SUCCESS = "成功";

    @Override
    protected ErrorCode apply0(String apiCode, String apiMsg) {
        if (Objects.equals(apiCode, CODE_SUCCESS)) {
            return  PayFrameworkErrorCodeConstants.SUCCESS;
        }
        if (Objects.equals(apiCode, "FAIL")) {
            if (Objects.equals(apiMsg, "AppID不存在，请检查后再试")) {
                return PayFrameworkErrorCodeConstants.PAY_CONFIG_APP_ID_ERROR;
            }
            if (Objects.equals(apiMsg, "签名错误，请检查后再试")
                || Objects.equals(apiMsg, "签名错误")) {
                return PayFrameworkErrorCodeConstants.PAY_CONFIG_SIGN_ERROR;
            }
        }
        if (Objects.equals(apiCode, "PARAM_ERROR")) {
            if (Objects.equals(apiMsg, "无效的openid")) {
                return PayFrameworkErrorCodeConstants.PAY_OPENID_ERROR;
            }
        }
        if (Objects.equals(apiCode, "CustomErrorCode")) {
            if (StringUtils.contains(apiMsg, "必填字段")) {
                return PayFrameworkErrorCodeConstants.PAY_PARAM_MISSING;
            }
        }
        return null;
    }

}

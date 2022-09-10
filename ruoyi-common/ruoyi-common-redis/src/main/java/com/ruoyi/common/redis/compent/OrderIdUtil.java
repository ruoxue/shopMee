package com.ruoyi.common.redis.compent;

import com.ruoyi.common.core.utils.StringUtils;
import com.ruoyi.common.redis.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Component
public class OrderIdUtil {
    @Autowired
    private RedisService jedisPool;

    //初始值
    private static final int ORDER_INIT = 0;
    //订单缓存key
    private static final String ORDER_KEY = "ORDER_KEY";
    //订单ID前缀
    private static final String ORDER_ID_PREFIX = "Z";
    //时间格式化
    private static final String DATE_FORMAT = "yyyyMMddHHmmss";
    private static final int MAXLEN = 8;


    /**
     * 通过key获取自增并设定过期时间
     * @param key
     * @param date 过期时间
     * @return
     */
    public String generateId(String key,Date date) {


        try{
            Integer s = jedisPool.getCacheObject(key);

            if(null==s){
                jedisPool.setCacheObject(key,ORDER_INIT);
            }
            long orderId=jedisPool.incr(key);
            jedisPool.expire(key,date.getTime());
            int len = String.valueOf(orderId).length();
            StringBuffer sb = new StringBuffer();
            if(len<MAXLEN){
                for(int i=0;i<(MAXLEN-len);i++){
                    sb.append("0");
                }
                sb.append(orderId);
            }
            return sb.toString();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取唯一订单号
     * @return
     */
    public String genOrderId(){
        String id = this.generateId(ORDER_KEY,getExpireAtData());
        String orderId = format(id, ORDER_ID_PREFIX);
        return orderId;
    }

    /**
     * 过期时间每天凌晨
     * @return
     */
    public Date getExpireAtData(){
        Date date = null;
        Calendar calendar = Calendar.getInstance();
        // 时
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        // 分
        calendar.set(Calendar.MINUTE, 0);
        // 秒
        calendar.set(Calendar.SECOND, 0);
        // 毫秒
        calendar.set(Calendar.MILLISECOND, 0);

        date = calendar.getTime();
        return date;
    }

    /**
     * 格式化时间
     * @param format 时间格式
     * @return
     */
    public  String getDateFormat(String format){
        DateFormat df = new SimpleDateFormat(null == format || "".equals(format) ? DATE_FORMAT : format);
        return df.format(new Date());
    }


    /**
     * 自定义ID格式
     * @param id
     * @param prefix 前缀
     * @return
     */
    private  String format(String id,String prefix){
        StringBuffer sb = new StringBuffer();
        if(null != prefix && !"".equals(prefix)){
            sb.append(prefix);
        }
        sb.append(getDateFormat(null));//当前时间戳

        String strId = sb.toString()+id;
        return strId;
    }
}

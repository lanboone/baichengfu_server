package com.yihukurama.sysbase.common.utils;

public class NumberUtil extends com.yihukurama.sysbase.handle.NumberUtil {


    /**
     * 两个数相加防止NullPoint
     * @param num
     * @param plus
     * @return
     */
    public static int NullPlus(Integer num,Integer plus){
        return (num==null?0:num)+(plus==null?0:plus);
    }

    /**
     * 两数相减防止nullPoint和负数
     * @param num
     * @param plus
     * @return
     */
    public static int NullSub(Integer num,Integer sub){
        int result = (num==null?0:num)-(sub==null?0:sub);
        return result<0?0:result;
    }

}

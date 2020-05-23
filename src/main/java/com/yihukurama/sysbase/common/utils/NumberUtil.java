package com.yihukurama.sysbase.common.utils;

import java.util.Random;
import java.util.UUID;

public class NumberUtil extends com.yihukurama.sysbase.handle.NumberUtil {

    public static String getOrderIdByUUId() {
        int first = new Random(10).nextInt(8) + 1;
        System.out.println(first);
        int hashCodeV = UUID.randomUUID().toString().hashCode();
        if (hashCodeV < 0) {//有可能是负数
            hashCodeV = -hashCodeV;
        }
        // 0 代表前面补充0
        // 4 代表长度为4
        // d 代表参数为正数型
        return first + String.format("%015d", hashCodeV);
    }

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

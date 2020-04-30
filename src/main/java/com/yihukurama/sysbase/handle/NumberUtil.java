package com.yihukurama.sysbase.handle;

import com.yihukurama.tkmybatisplus.app.utils.EmptyUtil;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Random;


/**
 * 功能描述:数字处理工具类;
 *
 * @author liujun
 * Created by Eclipse
 * @date 2016年9月6日
 */
public abstract class NumberUtil {
    /**
     * 功能描述:将数值型数组转换为字符串,例如输入数组为[1,2,3],转换之后的结果为"1,2,3";
     *
     * @param numbers 数值型数组,例如[1,2,3]
     * @return 字符串
     * @Date:2016年9月26日 上午9:36:09
     * @Author liujun
     */
    public static String convertToString(Number[] numbers) {
        if (EmptyUtil.isEmpty(numbers)) {
            return "";
        }
        final StringBuffer buffer = new StringBuffer();
        for (Number number : numbers) {
            buffer.append(number + ",");
        }
        buffer.deleteCharAt(buffer.length() - 1);

        return buffer.toString();
    }

    /**
     * 功能描述:将数字集合转换为字符串;
     *
     * @param numbers 数字对象集合
     * @return 字符串对象, 例如:"1,2,3,4"
     * @Author:liujun
     * @Date:2016年12月20日 下午2:25:41
     */
    public static String convertToString(List<? extends Number> numbers) {
        if (EmptyUtil.isEmpty(numbers)) {
            return "";
        }
        final StringBuffer buffer = new StringBuffer();
        for (Number number : numbers) {
            buffer.append(number + ",");
        }
        buffer.deleteCharAt(buffer.length() - 1);

        return buffer.toString();
    }

    public static String getRandStr(int charCount) {
        String charValue = "";
        for (int i = 0; i < charCount; i++) {
            char c = (char) (randomInt(0, 26) + 'a');
            charValue += String.valueOf(c);
        }
        return charValue;
    }

    public static String getRandNum(int charCount) {
        String charValue = "";
        for (int i = 0; i < charCount; i++) {
            char c = (char) (randomInt(0, 10) + '0');
            charValue += String.valueOf(c);
        }
        return charValue;
    }

    public static int randomInt(int from, int to) {
        Random r = new Random();
        return from + r.nextInt(to - from);
    }

    /**
     * 功能描述：将double型数据转换为百分数
     *
     * @param value
     * @param precision
     * @return
     * @author SongBaoYu
     * @date 2017年2月15日 下午1:36:48
     */
    public static String percentFormat(double value, int precision) {
        NumberFormat numberFormat = NumberFormat.getPercentInstance();
        //设置百分数精确度2即保留两位小数
        numberFormat.setMinimumFractionDigits(precision);
        //格式化数据
        return numberFormat.format(value);
    }

    /**
     * 功能描述：格式化浮点数
     *
     * @param value
     * @param pattern
     * @return
     * @author SongBaoYu
     * @date 2017年2月15日 下午1:37:48
     */
    public static double decimalFormat(double value, String pattern) {
        DecimalFormat df = new DecimalFormat(pattern);
        String result = df.format(value);
        return Double.valueOf(result).doubleValue();
    }

}

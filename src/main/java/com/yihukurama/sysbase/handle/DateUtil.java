package com.yihukurama.sysbase.handle;

import com.yihukurama.tkmybatisplus.app.utils.EmptyUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * 说明： 时间日期处理工具类;
 * @author yihukurama
 * @date Created in 14:29 2020/1/27
 *       Modified by yihukurama in 14:29 2020/1/27
 */
public abstract class DateUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(DateUtil.class);  // 日志工具;
    public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";           // 默认日期格式;
    public static final String DATE_FORMAT_YYYYMMDD = "yyyyMMdd";
    public static final String DATE_FORMAT_YYMMDD = "yyMMdd";
    public static final String DEFAULT_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";  // 默认时间格式;

    /**
     * 不包括秒
     */
    public static final String DATE_FORMAT_YYMMDD_HHMM = "yyyy-MM-dd HH:mm";

    /**
     * 只取时分
     */
    public static final String DATE_FORMAT_HHMM = "HH:mm";


    // G: Era designator;
    // y: Year;
    // M: Month in Year;
    // w: Week in Year;
    // W: Week in month;
    // M: Month in year;
    // D: Day in year;
    // d: Day in month;
    // E: Day name in week;
    // u: Day number of week;
    // a: Am/pm marker;
    // H: Hour in day(0-23);
    // k: Hour in day(1-24);
    // K: Hour in am/pm(0-11);
    // h: Hour in am/pm(1-12);
    // m: Minute in hour;
    // s: Second in minute;
    // S: Millisecond;
    // z: Time zone;
    // Z: Time zone(RFC822);
    // X: Time zone;

    /**
     * 功能描述:将java.util.Date类型的日期对象格式化为字符串;
     *
     * @param date java.util.Date对象
     * @return 转换成功返回'yyyy-MM-dd'格式的字符串;转换失败返回null
     * 创建时间:2016年9月7日
     * @Author liujun
     */
    public static String toString(Date date) {
        try {
            if (date == null) {
                return new SimpleDateFormat(DEFAULT_DATE_FORMAT).format(new Date());
            } else {
                return new SimpleDateFormat(DEFAULT_DATE_FORMAT).format(date);
            }

        } catch (Exception e) {
            // TODO: handle exception
            return new SimpleDateFormat(DEFAULT_DATE_FORMAT).format(new Date());
        }
    }

    /**
     * 功能描述:将java.util.Date对象格式化为给定格式的字符串;
     *
     * @param date   java.util.Date对象
     * @param format 日期格式
     * @return 给定格式的日期字符串
     * 创建时间:2016年9月8日
     * @Author liujun
     */
    public static String toString(Date date, String format) {
        try {

            return new SimpleDateFormat(format).format(date);
        } catch (Exception e) {
            // TODO: handle exception
            return new SimpleDateFormat(format).format(new Date());
        }
    }

    /**
     * 功能描述:将日期字符串格式化为java.util.Date对象;
     *
     * @param dateStr 'yyyy-MM-dd HH:mm:ss'格式的日期字符串
     * @return 转换成功返回java.util.Date对象, 转换失败返回null
     * 创建时间:2016年9月8日
     * @Author liujun
     */
    public static Date toDate(String dateStr) {
        if (EmptyUtil.isEmpty(dateStr)) {
            return null;
        }
        try {
            return new SimpleDateFormat(DEFAULT_TIME_FORMAT).parse(dateStr);
        } catch (ParseException e) {
            LOGGER.warn("日期格式错误");
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 功能描述:将日期字符串转换为java.util.Date对象;
     *
     * @param dateStr 日期字符串
     * @param format  日期格式
     * @return 转换成功返回java.util.Date对象, 转换失败返回null
     * 创建时间:2016年9月8日
     * @Author liujun
     */
    public static Date toDate(String dateStr, String format) {
        try {
            return new SimpleDateFormat(format).parse(dateStr);
        } catch (ParseException e) {
            LOGGER.warn("日期格式错误");
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 功能描述:将日期字符串转换为java.util.Date对象;
     *
     * @param dateStr 日期字符串
     * @param format  日期格式
     * @return 转换成功返回java.util.Date对象, 转换失败返回null
     * 创建时间:2016年9月8日
     * @Author liujun
     */
    public static Date toDate(String dateStr, Locale uk) {
        SimpleDateFormat sdf1 = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK);
        try {
            Date date = sdf1.parse(dateStr);
            return date;
        } catch (ParseException e) {
            LOGGER.warn("日期格式错误");
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 功能描述:
     *
     * @param date
     * @param format
     * @return 创建时间:2016年9月8日
     * @Author liujun
     */
    @Deprecated
    public static String toDateStr(Date date, String format) {
        return new SimpleDateFormat(format).format(date);
    }

    /**
     * 功能描述:将字符串格式的日期转换为java.util.Date对象
     *
     * @param dateStr 日期字符串
     * @param format  日期格式
     * @return 转换成功, 返回java.util.Date对象;转换失败,返回null
     * 创建时间:2016年9月7日
     * @Author liujun
     */
    public static Date parse(String dateStr, String format) {
        DateFormat df = new SimpleDateFormat(format);
        try {
            return df.parse(dateStr);
        } catch (ParseException e) {
            // 记录异常信息;
            LOGGER.error("日期格式错误!!!");
            return null;
        }
    }

    /**
     * 功能描述:获取当前系统 时间;
     *
     * @return java.util.Date对象
     * 创建时间:2016年9月7日
     * @Author liujun
     */
    public static Date now() {
        return new Date(System.currentTimeMillis());
    }

    /**
     * 功能描述：获取指定年份第一天
     *
     * @param year
     * @return
     * @author SongBaoYu
     * @date 2017年2月17日 下午7:13:23
     */
    public static String getYearFirst(Integer year) {

        Calendar calendar = Calendar.getInstance();
        if (null == year) {
            year = calendar.get(Calendar.YEAR);
        }
        calendar.clear();
        calendar.set(Calendar.YEAR, year);
        Date currYearFirst = calendar.getTime();
        return toString(currYearFirst);
    }

    /**
     * 功能描述：获取明天日期
     *
     * @return 字符串类型日期
     * @author SongBaoYu
     * @date 2017年2月17日 下午7:42:28
     */
    public static String getTomorrow() {
        Date today = new Date();
        Calendar cld = Calendar.getInstance();
        cld.setTime(today);
        cld.add(Calendar.DAY_OF_YEAR, 1);
        return toString(cld.getTime());
    }

    /**
     * 功能描述：获取当日以前的指定日期
     *
     * @param millSeconds
     * @return
     * @author SongBaoYu
     * @date 2017年3月6日 下午5:24:25
     */
    public static Date getSpecifiedDate(long millSeconds) {
        long currentTimeMillis = System.currentTimeMillis();
        return new Date(currentTimeMillis - millSeconds);
    }


}

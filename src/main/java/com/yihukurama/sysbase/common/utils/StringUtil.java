package com.yihukurama.sysbase.common.utils;


import java.io.PrintWriter;
import java.io.StringWriter;


/**
 * 说明：
 * @author yihukurama
 * @date Created in 19:56 2020/4/20
 *       Modified by dengs in 19:56 2020/4/20
 */
public class StringUtil {

    public static final String exceptionToString(Throwable e){
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        e.printStackTrace(pw);
        String errorString = sw.toString();
        pw.close();
        return errorString;
    }
}

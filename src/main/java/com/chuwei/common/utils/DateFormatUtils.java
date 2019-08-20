package com.chuwei.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by win on 2019/8/18.
 */
public final class DateFormatUtils {
    static String  datetimeFormat = "yyyy-MM-dd HH:mm:ss";
    static String dateFormatWithHyphen = "yyyy-MM-dd";
    static String dateFormat = "yyyyMMdd";


    public static String getDatetime(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat(datetimeFormat);
        return sdf.format(date);
    }
    public static String getDateWithHyphen(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormatWithHyphen);
        return sdf.format(date);
    }
    public static String getDate(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        return sdf.format(date);
    }
}

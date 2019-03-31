package com.dq.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    //时间格式
    public  static SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /***
     * 时间格式转换
     * @param date
     * @return
     */

    public static String dateToStr(Date date,String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }
}

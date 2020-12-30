package com.gloryh.utils;

import java.util.Calendar;
import java.util.Date;

/**
 * 日期工具类
 *
 * @author 黄光辉
 * @since 2020/11/29
 **/
public class DateUtils {
    public static Date getNextNow(){
        Calendar calendar=Calendar.getInstance();
        int day=calendar.get(Calendar.DATE);
        calendar.set(Calendar.DATE,day+1);
        return calendar.getTime();
    }
    public static boolean isNotExpired(Date date){
        return date.getTime() > (new Date()).getTime();
    }
}

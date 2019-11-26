package net.yhkj.mvvmdemo.utils;

import android.annotation.SuppressLint;



import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import me.goldze.mvvmhabit.utils.StringUtils;

/**
 * 时间工具类
 */
@SuppressLint("SimpleDateFormat")
public class TimeUtil {

    public static String getTime(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return format.format(date);
    }

    public static String getTime1(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(date);
    }

    public static String getSaveTime(Date date) {
        DateFormat formatter;
        formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = formatter.format(date);
        return format;
    }

    public static String getSaveTime(long time) {
        DateFormat formatter;
        formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = formatter.format(new Date(time));
        return format;
    }

    public static String getSaveTime1(long time) {
        DateFormat formatter;
        formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String format = formatter.format(new Date(time));
        return format;
    }


    public static String getTime61(String time) {
        DateFormat formatter1;
        formatter1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        DateFormat formatter2;
        formatter2 = new SimpleDateFormat("yyyy年M月d日");
        Date parse1 = null;
        try {
            parse1 = formatter1.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
//            Logger.e(e.getMessage());
        }
        String format1 = formatter2.format(parse1);
        return format1;
    }

    public static String getTime62(String time) {
        DateFormat formatter1;
        formatter1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        DateFormat formatter2;
        formatter2 = new SimpleDateFormat("yyyy年M月d日 mm:HH");
        Date parse1 = null;
        try {
            parse1 = formatter1.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
//            Logger.e(e.getMessage());
        }
        String format1 = formatter2.format(parse1);
        return format1;
    }

    public static String getTime63(String time) {
        DateFormat formatter1;
        formatter1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        DateFormat formatter2;
        formatter2 = new SimpleDateFormat("yyyy年M月d日 mm:HH");
        Date parse1 = null;
        try {
            parse1 = formatter1.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
//            Logger.e(e.getMessage());
        }
        String format1 = formatter2.format(parse1);
        return format1;
    }

    public static String getTime68(String time) {
        DateFormat formatter1;
        formatter1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        DateFormat formatter2;
        formatter2 = new SimpleDateFormat("yyyy年M月d日");
        Date parse1 = null;
        try {
            parse1 = formatter1.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
//            Logger.e(e.getMessage());
        }
        String format1 = formatter2.format(parse1);
        return format1;
    }

    public static String getTime69(String time) {
        DateFormat formatter2;
        formatter2 = new SimpleDateFormat("HH:mm");
        Date parse1 = getDate(time);

        String format1 = formatter2.format(parse1);
        return format1;
    }

    public static String getTime67(String time) {
        if (StringUtils.isEmpty(time)) {
            return "";
        }
        return getMsgType(getDate(time));
    }

    public static Date getDate(String time) {
        DateFormat formatter1;
        formatter1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date parse1 = null;
        try {
            parse1 = formatter1.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
//            Logger.e(e.getMessage());
        }
        return parse1;
    }


    public static String getTime10(String time) {
        DateFormat formatter1;
        formatter1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        DateFormat formatter2;
        formatter2 = new SimpleDateFormat("M月d日 mm:HH:ss");
        Date parse1 = null;
        try {
            parse1 = formatter1.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
//            Logger.e(e.getMessage());
        }
        String format1 = formatter2.format(parse1);
        return format1;
    }

    public static String getTime64(String time) {
        return getDiffTime(getDate(time));
    }

    public static String getTime65(String time) {
        return getMsgType(getDate(time));
    }


    public static String getTime(long time) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return format.format(new Date(time));
    }

    public static String getTime12(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy年M月d日");
        return format.format(date);
    }

    public static String getTime19(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy年M月");
        return format.format(date);
    }

    public static String getTime15(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(date);
    }

    public static String getTime115(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return format.format(date);
    }

    public static String getTime18(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
        return format.format(date);
    }

    public static String getTime14(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy年M月d日");
        return format.format(date);
    }

    public static String getTime16(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        return format.format(date);
    }

    public static String getTime17(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("MM月dd日 HH:mm");
        return format.format(date);
    }

    public static String getTime13(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy年M月");
        return format.format(date);
    }

    public static String getTime3(long time) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日");
        return format.format(new Date(time));
    }

    public static String getTime31(long time) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
        return format.format(new Date(time));
    }

    public static String getTime2(long time) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(new Date(time));
    }

    public static String getTime21(long time) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return format.format(new Date(time));
    }

    public static String getTime25(long time) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        return format.format(new Date(time));
    }


    public static String getTime23(long time) {
        SimpleDateFormat format = new SimpleDateFormat("MM-dd HH:mm");
        return format.format(new Date(time));
    }

    public static String getTime26(long time) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy年M月d日 HH:mm");
        return format.format(new Date(time));
    }

    public static String getTime22(long time) {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        return format.format(new Date(time));
    }

    public static Date getTime3(String time) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = format.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static String getTime4() {
        SimpleDateFormat format = new SimpleDateFormat("MM月dd日 今天 HH:mm");
        return format.format(new Date());
    }

    public static String getTime41(long time) {
        SimpleDateFormat format = new SimpleDateFormat("MM月dd日");
        return format.format(new Date(time));
    }

    public static String getTime5() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return format.format(new Date());
    }

    public static String getHourAndMin(long time) {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        return format.format(new Date(time));
    }

    public static String getChatTime(long timesamp) {
        String result = "";
        SimpleDateFormat sdf = new SimpleDateFormat("dd");
        Date today = new Date(System.currentTimeMillis());
        Date otherDay = new Date(timesamp);
        int temp = Integer.parseInt(sdf.format(today))
                - Integer.parseInt(sdf.format(otherDay));
        switch (temp) {
            case 0:
                result = "今天 " + getHourAndMin(timesamp);
                break;
            case 1:
                result = "昨天 " + getHourAndMin(timesamp);
                break;
            case 2:
                result = "前天 " + getHourAndMin(timesamp);
                break;

            default:
                // result = temp + "天前 ";
                result = getTime(timesamp);
                break;
        }

        return result;
    }

    //与当前时间的差
    public static long[] getReduceTime(String time) {
        long between = getTime3(time).getTime() - new Date().getTime();
        return formatTime(between);
    }

    /*
     * 毫秒转化时天分秒毫秒
     */

    public static long[] formatTime(Long ms) {
        long[] timelong = new long[4];

        Integer ss = 1000;
        Integer mi = ss * 60;
        Integer HH = mi * 60;
        Integer dd = HH * 24;

        Long day = ms / dd;
        Long hour = (ms - day * dd) / HH;
        Long minute = (ms - day * dd - hour * HH) / mi;
        Long second = (ms - day * dd - hour * HH - minute * mi) / ss;
        timelong[0] = day;
        timelong[1] = hour;
        timelong[2] = minute;
        timelong[3] = second;
        //Long milliSecond = ms - day * dd - hour * HH - minute * mi - second * ss;
        /*StringBuffer sb = new StringBuffer();
        if (day >= 0) {
            sb.append(day + ":");
        }
        if (hour >= 0) {
            sb.append(hour + ":");
        }
        if (minute >= 0) {
            sb.append(minute + ":");
        }
        if (second >= 0) {
            sb.append(second);
        }*/
        /*if (milliSecond > 0) {
            sb.append(milliSecond + "毫秒");
        }*/
        return timelong;
    }

    public static int getTimeDifference(long fromDate, long toDate) {
        int days = 0;
        days = (int) ((toDate - fromDate) / (1000 * 60 * 60 * 24));
        return days;
    }

    public static int getTimeDifference(Date fromDate, Date toDate) {
        int days = 0;
        days = (int) ((toDate.getTime() - fromDate.getTime()) / (1000 * 60 * 60 * 24));
        return days;
    }

    /**
     * 计算时差  返回小时数
     *
     * @param fromDate
     * @param toDate
     * @return
     */
    public static int getHourDifference(long fromDate, long toDate) {
        SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        int hours = 0;
        hours = (int) ((toDate - fromDate) / (1000 * 60 * 60));
        return hours;
    }

    public static int getMiuteDifferece(long fromDate, long toDate) {
        int minutes = 0;
        long result = toDate - fromDate;
        minutes = (int) (result / (1000 * 60));
        return minutes;
    }

    public static String calTimeDifference(long startTime, long endtime) {
        String times = "";
        int days = getTimeDifference(startTime, endtime);
        int hours = getHourDifference(startTime, endtime);
        int minutes = getMiuteDifferece(startTime, endtime);
        hours = hours % 24;
        minutes = minutes % 60;
        if (days == 0 && hours == 0 && minutes != 0) {//36分钟
            times = String.valueOf(minutes) + "分钟";
        } else if (days == 0 && hours != 0 && minutes != 0) {//2小时56分钟
            times = String.valueOf(hours) + "小时" + minutes + "分钟";
        } else if (days == 0 && hours != 0 && minutes == 0) {//3小时
            times = String.valueOf(hours) + "小时";
        } else if (days != 0 && hours == 0 && minutes == 0) {//3天
            times = String.valueOf(days) + "天";
        } else if (days != 0 && hours != 0 && minutes == 0) {//2天2小时
            times = String.valueOf(days) + "天" + String.valueOf(hours) + "小时";
        } else if (days != 0 && hours != 0 && minutes != 0) {//3天2小时36分钟
            times = String.valueOf(days) + "天" + String.valueOf(hours) + "小时" + minutes + "分钟";
        } else if (days != 0 && hours == 0 && minutes != 0) {//6天30分钟
            times = String.valueOf(days) + "天" + String.valueOf(hours) + "小时" + String.valueOf(minutes) + "分钟";
        }
        return times;
    }

    public static String getDatePoor(Date endDate, Date nowDate) {

        long nd = 1000 * 24 * 60 * 60;
        long nh = 1000 * 60 * 60;
        long nm = 1000 * 60;
        // long ns = 1000;
        // 获得两个时间的毫秒时间差异
        long diff = endDate.getTime() - nowDate.getTime();
        // 计算差多少天
        long day = diff / nd;
        // 计算差多少小时
        long hour = diff % nd / nh;
        // 计算差多少分钟
        long min = diff % nd % nh / nm;
        // 计算差多少秒//输出结果
        // long sec = diff % nd % nh % nm / ns;
        String resultStr = "";
        if (day > 0) {
            resultStr += day + "天";
        }
        if (hour > 0) {
            resultStr += hour + "小时";
        }
        if (min > 0) {
            resultStr += min + "分钟";
        }

        return resultStr;
    }

    public static String getCurrentTime() {
        return String.valueOf(System.currentTimeMillis());
    }

    public static String getMsgType(Date date) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat sfd = null;
        String dayDF = "M月d日 HH:mm";
        String monthDF = "M月d日 HH:mm";
        String YearDF = "yyyy年M月d日 HH:mm ";
        Calendar dateCalendar = Calendar.getInstance();
        dateCalendar.setTime(date);
        Date now = new Date();
        Calendar todayCalendar = Calendar.getInstance();
        todayCalendar.setTime(now);
        if (dateCalendar.get(Calendar.YEAR) != todayCalendar.get(Calendar.YEAR)) {
            sfd = new SimpleDateFormat(YearDF);
        } else if (dateCalendar.get(Calendar.MONTH) != todayCalendar.get(Calendar.MONTH)) {
            sfd = new SimpleDateFormat(monthDF);
        } else {
            sfd = new SimpleDateFormat(dayDF);
        }

        return sfd.format(date);
    }

    public static String getDiffTime(Date date) {
        SimpleDateFormat sfd = null;
        String dayDF = "MM月dd日";
        String monthDF = "MM月dd日";
        String YearDF = "yyyy年MM月dd日";
        Calendar dateCalendar = Calendar.getInstance();
        dateCalendar.setTime(date);
        Date now = new Date();
        Calendar todayCalendar = Calendar.getInstance();
        todayCalendar.setTime(now);
        if (dateCalendar.get(Calendar.YEAR) != todayCalendar.get(Calendar.YEAR)) {
            sfd = new SimpleDateFormat(YearDF);
        } else if (dateCalendar.get(Calendar.MONTH) != todayCalendar.get(Calendar.MONTH)) {
            sfd = new SimpleDateFormat(monthDF);
        } else {
            sfd = new SimpleDateFormat(dayDF);
        }

        return sfd.format(date);
    }

    public static final String getTime81(String startTime, String endTime) {
        if (StringUtils.isEmpty(startTime)) {
            return "";
        }
        if (StringUtils.isEmpty(endTime)) {
            return "";
        }
        String resultStr = getDatePoor(getDate(endTime), getDate(startTime));
        return resultStr;
    }

    public static int compareTime(String time) {
        String myString = null;
        if (time == null) {
            myString = "0000-00-00";
        } else {
            myString = time;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar start = Calendar.getInstance();
        Calendar end = Calendar.getInstance();

        Date now1 = new Date();
        String now = sdf.format(now1);
        Date date = null;
        try {
            now1 = sdf.parse(now);
            date = sdf.parse(myString);
            start.setTime(date);
            end.setTime(now1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (end.get(Calendar.YEAR) > start.get(Calendar.YEAR)) {
            int year = end.get(Calendar.YEAR) - start.get(Calendar.YEAR);
            if (end.get(Calendar.MONTH) + 1 >= start.get(Calendar.MONTH) + 1) {
                if (end.get(Calendar.DATE) >= start.get(Calendar.DATE)) {
                    return year;
                } else {
                    return year - 1;
                }
            } else {
                return year - 1;
            }

        } else {
            return 0;
        }

    }


    /**
     * 1 凌晨  2上午 3中午 4 下午 5晚上
     *
     * @return
     */
    public static int getDayStatus() {
        int dayStatus = 0;
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("HH");
        String str = df.format(date);
        int a = Integer.parseInt(str);
        if (a >= 0 && a <= 6) {
            dayStatus = 1;
        }
        if (a > 6 && a <= 12) {
            dayStatus = 2;
        }
        if (a > 12 && a <= 14) {
            dayStatus = 3;
        }
        if (a > 13 && a <= 20) {
            dayStatus = 4;
        }
        if (a > 20 && a <= 24) {
            dayStatus = 5;
        }
        return dayStatus;
    }


    /**
     * 1 凌晨  2上午 3中午 4 下午 5晚上
     *
     * @return
     */
    public static boolean isMoring() {
        boolean isMoring = true;
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("HH");
        String str = df.format(date);
        int a = Integer.parseInt(str);
        if (a > 12) {
            isMoring = false;
        }
        return isMoring;
    }
}

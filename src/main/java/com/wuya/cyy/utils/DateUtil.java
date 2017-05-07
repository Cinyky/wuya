package com.wuya.cyy.utils;  
  
import java.io.UnsupportedEncodingException;  
import java.security.MessageDigest;  
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import java.util.TimeZone;  
/**
 * Date
 * Cinyky 
 *
 * 2017年3月21日上午8:48:11
 */
public class DateUtil {  
      
    public static  Long getStartTime(){  
    	long current=System.currentTimeMillis();//当前时间毫秒数
        long zero=current/(1000*3600*24)*(1000*3600*24)-TimeZone.getDefault().getRawOffset();//今天零点零分零秒的毫秒数
        return zero;
    }  
      
    public static  Long getEndTime(){  
    	long current=System.currentTimeMillis();//当前时间毫秒数
    	long zero=current/(1000*3600*24)*(1000*3600*24)-TimeZone.getDefault().getRawOffset();//今天零点零分零秒的毫秒数
    	long end=zero+24*60*60*1000-1;//今天23点59分59秒的毫秒数  
    	return end;
    }  
      
}
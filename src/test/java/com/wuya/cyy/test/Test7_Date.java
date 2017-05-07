package com.wuya.cyy.test;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.wuya.cyy.utils.DateUtil;
import com.wuya.cyy.utils.MD5Util;

public class Test7_Date {
	public static void main(String[] args) {
		Long startTime = DateUtil.getStartTime();
		Long endTime = DateUtil.getEndTime();
		System.out.println("start:"+startTime+"end:"+endTime);
	}
}

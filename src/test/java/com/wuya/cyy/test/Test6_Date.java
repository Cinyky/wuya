package com.wuya.cyy.test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test6_Date {
	public static void main(String[] args) {
		SimpleDateFormat smf = new SimpleDateFormat("yyyy/MM/dd");
		Date date = new Date(Long.parseLong("0"));
		System.out.println(new Date().getTime());
//		String format = smf.format(date);
//		System.out.println(format);
//		new SimpleDateFormat("yyyy/MM/dd").format(new Date(Long.parseLong("0")));
	}
}

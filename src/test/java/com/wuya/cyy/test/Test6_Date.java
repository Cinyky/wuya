package com.wuya.cyy.test;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.wuya.cyy.utils.MD5Util;

public class Test6_Date {
	public static void main(String[] args) {
		SimpleDateFormat smf = new SimpleDateFormat("yyyy/MM/dd");
		Date date = new Date(Long.parseLong("0"));
		System.out.println(new Date().getTime());
		String encode2hex1 = MD5Util.encode2hex("12345678");
		String encode2hex2 = MD5Util.encode2hex("12341234");
		System.out.println("encode2hex1:"+encode2hex1);
		System.out.println("encode2hex2:"+encode2hex2);
//		String format = smf.format(date);
//		System.out.println(format);
//		new SimpleDateFormat("yyyy/MM/dd").format(new Date(Long.parseLong("0")));
	}
}

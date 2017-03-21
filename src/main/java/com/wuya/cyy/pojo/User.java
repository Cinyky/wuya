package com.wuya.cyy.pojo;

import java.util.Date;

/**
 * 用户实体
 * Cinyky 
 *
 * 2017年3月21日上午8:44:37
 */
public class User {
	private long id;			//用户ID 用户的唯一标识
	//注册登录相关
	private String user_name;	//登录名
	private String password;	//密码  (MD5加密)
	//详细个人资料
	private int sex;		    //0-男  1-女
	//激活相关
	private String email;  		//绑定邮箱账号  目前只支持163邮箱
	private int status=0;		//0未激活  1激活 2封号 
	private Long verifyTime;	//jdbcType bigint
//	private String regCode;		//注册激活码  
//	private Date  regTime; 		//注册时间  
//	//激活结束
//	private String pwdCode;		//找回密码的激活码  
//	private Date  pwdTime; 		//找回密码时间 
	
	public enum Sex{
		MALE,			//男
		FEMALE;			//女
	}
	
	public static void main(String[] args) {
		int res = Sex.MALE.ordinal();
		System.out.println(res);
	}
}

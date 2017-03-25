package com.wuya.cyy.pojo;

import java.util.Date;

/**
 * 用户实体
 * Cinyky 
 *
 * 2017年3月21日上午8:44:37
 */
public class Admin {
	private String  uid;			//用户唯一id
	private String  loginName;		//用户登录名
	private String  pwd;			//用户密码
//	uid = #{uid},
//	loginName = #{loginName},
//	pwd = #{pwd},

	
	public Admin() {
		super();
	}
	public Admin(String uid, String loginName, String pwd) {
		super();
		this.uid = uid;
		this.loginName = loginName;
		this.pwd = pwd;
	}
	@Override
	public String toString() {
		return "Admin [uid=" + uid + ", loginName=" + loginName + ", pwd=" + pwd + "]";
	}
	
	

	


	
	
	

	
	
	
	
}

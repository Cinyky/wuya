package com.wuya.cyy.pojo;

import java.util.Date;
import java.util.UUID;

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
	private int status;
//	uid = #{uid},
//	loginName = #{loginName},
//	pwd = #{pwd},

	
	public Admin() {
		super();
	}
	public Admin(String uid, String loginName, String pwd) {
		super();
		this.uid = UUID.randomUUID()+"";
		this.loginName = loginName;
		this.pwd = pwd;
	}
	
	
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Admin [uid=" + uid + ", loginName=" + loginName + ", pwd=" + pwd + "]";
	}
	
	

	


	
	
	

	
	
	
	
}

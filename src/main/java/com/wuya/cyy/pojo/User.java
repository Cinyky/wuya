package com.wuya.cyy.pojo;

import java.util.Date;
import java.util.UUID;

import com.wuya.cyy.utils.MD5Util;

/**
 * 用户实体
 * Cinyky 
 *
 * 2017年3月21日上午8:44:37
 */
public class User {
	private String  uid;			//用户唯一id
	private String  loginName;		//用户登录名
	private String  pwd;			//用户密码
	private String  bind_email;		//绑定邮箱账号
	private String  email_code;		//邮箱验证码
	private String  nickName;		//用户昵称
	private int 	sex =1;			//性别 默认1->男 0->女'
	private String  signature="这个人很懒";		//个性签名
	private String	profile="个人简介";		//用户个人简介
	private String  location="中国"; 		//居住地
	private String 	headPic="default_headpic.jpg";		//头像
	private long 	birth;		 	//生日
	private long 	regTime;	    //注册时间
	private long 	banTime = 0;		//封号时间点
	private int 	status = -1;			//用户账号状态 -1未激活 0 正常 1封号
	
//	uid = #{uid},
//	loginName = #{loginName},
//	pwd = #{pwd},
//	bind_email = #{bind_email},
//	email_code = #{email_code},
//	nickName = #{nickName},
//	sex = #{sex},
//	signature = #{signature},
//	profile = #{profile},
//	location = #{location},
//	headPic = #{headPic},
//	birth = #{birth},
//	regTime = #{regTime},
//	banTime = #{banTime},
//	status = #{status}

	
	//	public enum Sex{
	//	MALE,			//男
	//	FEMALE;			//女
	//}
	public User() {
		super();
	}




	public User(String uid, String loginName, String pwd, String bind_email, String email_code, String nickName,
			int sex, String signature, String profile, String location, String headPic, long birth,
			long banTime, int status) {
		super();
		this.uid = UUID.randomUUID()+"";
		this.loginName = loginName;
		this.pwd = pwd;
		this.bind_email = bind_email;
		this.email_code = email_code;
		this.nickName = nickName;
		this.sex = sex;
		this.signature = signature;
		this.profile = profile;
		this.location = location;
		this.headPic = headPic;
		this.birth = birth;
		this.regTime = System.currentTimeMillis();
		this.banTime = banTime;
		this.status = status;
	}
	
	public User(String loginName, String pwd, String bind_email, String nickName) {
		super();
		this.uid = UUID.randomUUID()+"";
		this.loginName = loginName;
		this.pwd = MD5Util.encode2hex(pwd);
		this.bind_email = bind_email;
		this.email_code = MD5Util.encode2hex(bind_email);
		this.nickName = nickName;
		this.regTime = System.currentTimeMillis();
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




	public String getBind_email() {
		return bind_email;
	}




	public void setBind_email(String bind_email) {
		this.bind_email = bind_email;
	}




	public String getEmail_code() {
		return email_code;
	}




	public void setEmail_code(String email_code) {
		this.email_code = email_code;
	}




	public String getNickName() {
		return nickName;
	}




	public void setNickName(String nickName) {
		this.nickName = nickName;
	}




	public int getSex() {
		return sex;
	}




	public void setSex(int sex) {
		this.sex = sex;
	}




	public String getSignature() {
		return signature;
	}




	public void setSignature(String signature) {
		this.signature = signature;
	}




	public String getProfile() {
		return profile;
	}




	public void setProfile(String profile) {
		this.profile = profile;
	}




	public String getLocation() {
		return location;
	}




	public void setLocation(String location) {
		this.location = location;
	}




	public String getHeadPic() {
		return headPic;
	}




	public void setHeadPic(String headPic) {
		this.headPic = headPic;
	}




	public long getBirth() {
		return birth;
	}




	public void setBirth(long birth) {
		this.birth = birth;
	}




	public long getRegTime() {
		return regTime;
	}




	public void setRegTime(long regTime) {
		this.regTime = regTime;
	}




	public long getBanTime() {
		return banTime;
	}




	public void setBanTime(long banTime) {
		this.banTime = banTime;
	}




	public int getStatus() {
		return status;
	}




	public void setStatus(int status) {
		this.status = status;
	}




	@Override
	public String toString() {
		return "User [uid=" + uid + ", loginName=" + loginName + ", pwd=" + pwd + ", bind_email=" + bind_email
				+ ", email_code=" + email_code + ", nickName=" + nickName + ", sex=" + sex + ", signature=" + signature
				+ ", profile=" + profile + ", location=" + location + ", headPic=" + headPic + ", birth=" + birth
				+ ", regTime=" + regTime + ", banTime=" + banTime + ", status=" + status + "]";
	}

	
	
	
	

	
	
	
	
}

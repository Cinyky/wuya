package com.wuya.cyy.service;

import java.util.*;

import com.wuya.cyy.pojo.User;



/**
 * 用户service接口
 * Cinyky 
 *
 * 2017年3月21日上午8:46:00
 */
public interface UserService {

	/**
	 * 用户注册
	 * @param user 用户
	 * @return
	 */
	boolean userReg(String loginName,String pwd,String bind_email,String nickName);
	
	/**
	 * 用户激活
	 * @param email , code
	 * @return
	 */
	boolean userActicate(String bind_email,String code);
	

	/**
	 * 用户登录
	 * @param loginCondition(loginName/nickName/email) pwd
	 * @return
	 */
	User userLogin(String loginCondition,String pwd);
	
	
	/**
	 * 根据昵称模糊搜索
	 * @param nickName
	 * @return
	 */
	List<User> userSelect(String nickName);
	
	/**
	 * 根据昵称模糊搜索
	 * @param uid
	 * @return
	 */
	User userSelectByUid(String uid);
	
	

}

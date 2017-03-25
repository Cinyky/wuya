package com.wuya.cyy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wuya.cyy.pojo.User;

/**
 * 用户
 * Cinyky 
 *
 * 2017年3月21日下午10:32:56
 */
public interface UserDao {
	/**
	 * 增加用户
	 * @param user
	 * @return
	 */
	int addUser(User user);
	
	/**
	 * 更新用户
	 * @param user
	 * @return
	 */
	int updateUser(User user);
	
	/**
	 * 根据用户昵称模糊查询用户
	 * @return
	 */
	List<User> selectUserByNickName(String nickName);
	
	/**
	 * 根据用户Id查询用户
	 * @return
	 */
	User selectUserByUid(String uid);
	
	/**
	 * 根据用户Id&pwd查询用户
	 * @return
	 */
	User selectUserByUidAndPwd(@Param("loginName")String loginName,@Param("pwd")String pwd);
	
	/**
	 * 根据email查询email_code
	 * @return
	 */
	User selectUserByEmail(String email);
	
	
	
	
}

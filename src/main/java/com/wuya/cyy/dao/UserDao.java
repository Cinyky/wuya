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
	User selectUserByNickNameAndPwd(@Param("nickName")String nickName,@Param("pwd")String pwd);
	
	/**
	 * 根据用户Id查询用户
	 * @return
	 */
	User selectUserByUid(@Param("uid")String uid);
	
	/**
	 * 根据用户Id&pwd查询用户
	 * @return
	 */
	User selectUserByLoginNameAndPwd(@Param("loginName")String loginName,@Param("pwd")String pwd);
	
	/**
	 * 根据用户Id&pwd查询用户
	 * @return
	 */
	User selectUserByEmailAndPwd(@Param("bindEmail")String bindEmail,@Param("pwd")String pwd);
	
	/**
	 * 根据email查询用户
	 * @return
	 */
	User selectUserByEmail(@Param("bindEmail")String bindEmail);
	
	/**
	 * 根据nickName查询用户
	 * @return
	 */
	List<User> selectUserByNickName(@Param("nickName")String nickName);
	
	/**
	 * count user
	 * @return
	 */
	String selectAllUserCount();
	
	/**
	 * 
	 * @param todayTime
	 * @return
	 */
	String selectTodayUserCount(@Param("startTime")Long startTime,@Param("endTime")Long endTime);
	
	/**
	 * 
	 * @param todayTime
	 * @return
	 */
	List<User> selectUserByPage(@Param("start")int start,@Param("pageSize")int pageSize);
}

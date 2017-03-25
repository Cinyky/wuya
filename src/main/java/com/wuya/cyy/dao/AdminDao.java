package com.wuya.cyy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wuya.cyy.pojo.Admin;

/**
 * 管理员
 * Cinyky 
 *
 * 2017年3月21日下午10:32:56
 */
public interface AdminDao {
	/**
	 * 增加用户
	 * @param user
	 * @return
	 */
	int addAdmin(Admin admin);
	
	/**
	 * 更新用户
	 * @param user
	 * @return
	 */
	int updateAdmin(Admin admin);
	
	/**
	 * 根据用户Id&pwd查询用户
	 * @return
	 */
	Admin selectUserByUidAndPwd(@Param("loginName")String loginName,@Param("pwd")String pwd);
	
	
	
}

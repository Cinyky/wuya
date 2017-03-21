package com.wuya.cyy.service;

import java.util.List;

import com.wuya.cyy.pojo.Book;

/**
 * 用户接口
 * Cinyky 
 *
 * 2017年3月21日上午8:46:00
 */
public interface UserService {

	/**
	 * 查询一本图书
	 * 
	 * @param bookId
	 * @return
	 */
	Book getById(long bookId);

	/**
	 * 查询所有图书
	 * 
	 * @return
	 */
	List<Book> getList();


}

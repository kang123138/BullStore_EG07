package cn.itbull.bullstore.dao;

import java.util.List;

/**
 * 操作数据库表共有的特性
 */
public interface BaseDao<T> {

	/**
	 * 用来增删改的操作
	 */
	int update(String sql, Object...params);
	
	/**
	 * 查询数据库一条记录，返回一个对象
	 */
	T getBean(String sql, Object...params);
	
	/**
	 * 查询数据库多条记录，返回一个对象集合
	 */
	List<T> getBeanList(String sql, Object...params);
}

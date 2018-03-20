package cn.itbull.bullstore.dao;

import java.util.List;

/**
 * 操作数据库表共有的内容
 */
public interface BaseDao<T> {
	
	// 增删改的操作
	int update(String sql,Object...params);
	
	// 查询一条记录，返回一个对象
	T getBean(String sql, Object...params);
	
	// 查询多条记录，返回一个对象集合
	List<T> getListBean(String sql, Object...params);
	
	// 查询单行单列的记录
	Object getSingleValue(String sql, Object...params);
	
	
}

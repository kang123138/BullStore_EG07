package cn.itbull.bullstore.dao;

import java.util.List;

/**
 * 操作数据库表的共性的方法
 * 增删改
 * 查询一条记录封装成一个java对象
 * 查询一组记录封装成一个java对象集合
 */
public interface BaseDao<T> {
	
	// 执行增删改的操作
	int update(String sql,Object... params); 
	
	// 查询一条记录封装成一个java对象
	T getBean(String sql,Object... params);
	
	// 查询一组记录封装成一个java对象集合
	List<T> getBeanList(String sql,Object... params);

}

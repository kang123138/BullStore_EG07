package cn.itbull.bullstore.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itbull.bullstore.dao.BaseDao;
import cn.itbull.bullstore.utils.C3P0Utils;

/**
 * BaseDao的实现类
 */
public class BaseDaoImpl<T> implements BaseDao<T> {
	
	
	// UserDaoImpl extends BaseDaoImpl<User>
	
	private Class type;
	
	public BaseDaoImpl() {
		ParameterizedType pt = (ParameterizedType)this.getClass().getGenericSuperclass();
		Type[] types = pt.getActualTypeArguments();
		type = (Class)types[0];
	}
	

	@Override
	public int update(String sql, Object... params) {
		
		QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
		int count = 0;
		try {
			count =  runner.update(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
		
	}

	@Override
	public T getBean(String sql, Object... params) {
		
		QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
		
		T t = null;
		
		try {
			t = runner.query(sql, new BeanHandler<T>(type), params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return t;
		
	}

	@Override
	public List<T> getBeanList(String sql, Object... params) {
		
		QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
		
		List<T> list = null;
		
		try {
			list = runner.query(sql, new BeanListHandler<T>(type), params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

}

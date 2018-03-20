package cn.itbull.bullstore.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.itbull.bullstore.dao.BaseDao;
import cn.itbull.bullstore.utils.C3P0Utils;

public class BaseDaoImpl<T> implements BaseDao<T> {

	private Class type;
	private QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());

	public BaseDaoImpl() {
		ParameterizedType t = (ParameterizedType) this.getClass().getGenericSuperclass();
		Type[] ts = t.getActualTypeArguments();
		type = (Class) ts[0];
	}

	@Override
	public int update(String sql, Object... params) {
		// 使用DBUtils中的方法
		int count = 0;
		try {
			count = runner.update(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public T getBean(String sql, Object... params) {
		T t = null;
		try {
			t = runner.query(sql, new BeanHandler<T>(type), params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return t;
	}

	@Override
	public List<T> getListBean(String sql, Object... params) {
		List<T> list = null;
		try {
			list = runner.query(sql, new BeanListHandler<T>(type), params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Object getSingleData(String sql, Object... params) {
		Object count = null;
		try {
			count = runner.query(sql, new ScalarHandler(), params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public int[] batch(String sql, Object[][] params) {

		int[] batch = null;
		try {
			batch = runner.batch(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return batch;
	}

}

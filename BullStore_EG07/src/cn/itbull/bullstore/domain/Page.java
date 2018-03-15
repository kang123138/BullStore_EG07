package cn.itbull.bullstore.domain;

import java.util.List;

/**
 * 商品信息类
 * 
 * @param <T>
 */
public class Page<T> {

	// 总记录数
	private int totalRecord;
	// 获取到的商品列表对象
	private List<T> datas;
	// 每页显示的记录
	private int pageSize;
	
	private String path;
	
	public String getPath() {
		return path;
	}


	public void setPath(String path) {
		this.path = path;
	}

	//当前的页码
	private int currentPage;
	// 总页数
	// private int totalPage;
	// 当前页的索引
	// private int index;

	public Page() {
		super();

	}


	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}

	public List<T> getDatas() {
		return datas;
	}

	public void setDatas(List<T> datas) {
		this.datas = datas;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getCurrentPage() {
		if(currentPage <= 0) {
			// 显示第一页
			currentPage = 1;
		} else if(currentPage > getTotalPage()) {
			currentPage = getTotalPage();
		}
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	/**
	 * 总页数通过计算得出
	 * 
	 */
	public int getTotalPage() {
		if(getTotalRecord() % getPageSize() == 0) {
			// 整除
			return getTotalRecord() / getPageSize();
		} else {
			return getTotalRecord() / getPageSize() + 1;
		}
	}

	/**
	 * 当前页码的索引通过计算得出
	 *  每页记录数       当前页数	索引
	 *	4			1		0
	 *	4			2		4
	 *	4			3		8	
	 */
	public int getIndex() {
		return (getCurrentPage()-1) * pageSize;
	}


}

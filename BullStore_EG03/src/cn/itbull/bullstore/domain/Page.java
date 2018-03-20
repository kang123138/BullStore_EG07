package cn.itbull.bullstore.domain;

import java.util.List;

/**
 * 分页的类
 * 
 * @param <T>
 */
public class Page<T> {
	// 当前页码
	private int currentPage;
	// 总记录数
	private int totalRecord;

	// 每页显示几条记录
	private int pageSize;

	// 共多少页
// 	private int totalPage;

	// 每页显示的列表
	private List<T> datas;

	// 当前页的索引
	private int index;

	public Page() {
		super();

	}


	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * 总页数= 总记录数 / 每页显示的记录
	 */
	public int getTotalPage() {
		
		if(getTotalRecord()%getPageSize() == 0) {
			//
			return  getTotalRecord()/getPageSize();
			
		} else {
			return getTotalRecord()/getPageSize() + 1;
		}
	}

	public List<T> getDatas() {
		return datas;
	}

	public void setDatas(List<T> datas) {
		this.datas = datas;
	}

	/**
	 * 当前页的索引
	 * 
	 * 每页记录     第几页    索引
	 *    4      1      0
	 *    4      2      4
	 *    4      3      8
	 */
	public int getIndex() {
		return (getCurrentPage()-1) * getCurrentPage();
	}

	public void setIndex(int index) {
		this.index = index;
	}

}

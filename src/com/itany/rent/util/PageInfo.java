package com.itany.rent.util;

import java.util.List;

/**
 * 分页工具类
 * @author ldl
 * @date 2018年5月9日 下午2:41:18
 * @version 1.0
 * @param <T>
 */
public class PageInfo<T> {

	private int total = 0;//总数据条数
	private int pages = 1;//总页数
	
	private int pageNo = 1;//当前页码
	private int pageSize = 1;//每页最大显示的数据条数
	private List<T> list;//当前页的数据
	/**
	 * <b>请按顺序设置以下属性 :</b><br/>
	 * <b>total</b> 总数据条数<br/>
	 * <b>pageNo</b> 当前页码<br/>
	 * <b>pageSize</b> 每页最大显示的数据条数<br/>
	 * <b>list</b> 当前页的数据<br/>
	 * <b>pages</b> 总页数<br/>
	 */
	public PageInfo() {
	}
	/**
	 * 自动计算总页数pages
	 * @param total 总数据条数
	 * @param pageNo 当前页码
	 * @param pageSize 每页最大显示的数据条数
	 * @param list 当前页的数据
	 */
	public PageInfo(int total, int pageNo, int pageSize, List<T> list) {
		this.total = total > 0 ? total : 0;
		this.pageNo = pageNo > 0 ? pageNo : 1;
		this.pageSize = pageSize > 0 ? pageSize : 1;
		this.list = list;
		
		this.pages = countPages(this.total, this.pageSize);
		if(this.pageNo > this.pages){
			this.pageNo = this.pages;
		}
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total > 0 ? total : 1;
	}
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages > 0 ? pages : 1;
		//验证pageNo与pages的合法性
		if(this.pageNo > this.pages){
			this.pageNo = this.pages;
		}
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo > 0 ? pageNo : 1;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize > 0 ? pageSize : 1;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	/**
	 * 获取首页页码
	 * @return
	 */
	public int getFirstNo(){
		return 1;
	}
	/**
	 * 获取最后一页页码
	 * @return
	 */
	public int getLastNo(){
		return this.pages;
	}
	/**
	 * 获取前一页页码
	 * @return
	 */
	public int getPreNo(){
		int preNo = this.pageNo - 1;
		preNo = preNo > 0 ? preNo : this.getFirstNo();
		return preNo;
	}
	/**
	 * 获取下一页页码
	 * @return
	 */
	public int getNextNo(){
		int nextNo = this.pageNo + 1;
		nextNo = nextNo < this.getLastNo() ? nextNo : this.getLastNo();
		return nextNo;
	}

	/**
	 * 计算总页数
	 * @param total 总数据条数
	 * @param pageSize 每页最大显示的数据条数
	 * @return 最小一页
	 */
	public int countPages(int total, int pageSize){
		int pages = 1;
		if(total > 0 && pageSize > 0){
			int p = total/pageSize;
			pages = total%pageSize == 0 ? p : p + 1;
		}
		return pages;
	}
	
}

package com.zjlp.face.shop.util;

import java.io.Serializable;
import java.util.List;

public class Pagination<E> implements Serializable {
	
	private static final long serialVersionUID = 8556204895500145339L;
	private int curPage = 1; // 当前页
	private int pageSize = 10; // 每页多少行
	private int totalRow = 0; // 共多少行
	private int start = 0;// 当前页起始行
	private int end = 0;// 结束行
	private int totalPage = 0; // 共多少页
	private List<E> datas;//分页查询结果
	
	private int fromPage=0; //展示起始页
	private int toPage=0;   //展示结束页
	private int showPageNum=3; //展示页数
	private Integer page = null;
	private Integer rows = null;
	private String sort;
	private String order;
	
	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public List<E> getDatas() {
		return datas;
	}

	public void setDatas(List<E> datas) {
		this.datas = datas;
	}

	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		if (curPage < 1) {
			curPage = 1;
		} else {
			start = pageSize * (curPage - 1);
		}
		end = start + pageSize > totalRow ? totalRow : start + pageSize;
		this.curPage = curPage;
	}

	public int getStart() {
		return start;
	}

	public int getEnd() {

		return end;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		if (pageSize < 1) {
			pageSize = 10;
		} else {
			start = pageSize * (curPage - 1);
		}
		end = start + pageSize > totalRow ? totalRow : start + pageSize;
		this.pageSize = pageSize;
	}

	public int getTotalRow() {
		return totalRow;
	}

	public void setTotalRow(int totalRow) {
		if(totalRow>0){
			totalPage = (totalRow + pageSize - 1) / pageSize;
			this.totalRow = totalRow;
			if (totalPage < curPage) {
				curPage = totalPage;
				start = pageSize * (curPage - 1);
				end = totalRow;
				
			}
			start = pageSize * (curPage - 1);
			end = start + pageSize > totalRow ? totalRow : start + pageSize;

			fromPage=curPage-(showPageNum%2!=0?showPageNum/2:(showPageNum/2-1));
		}else{
			curPage = 0;
			totalPage = 0;
		}
		if(fromPage<1){
			fromPage=1;
		}
		toPage=fromPage+showPageNum-1;
		
		if(toPage>totalPage){
			toPage=totalPage;
		}
	}

	public int getTotalPage() {

		return this.totalPage;
	}

	public int getFromPage() {
		return fromPage;
	}

	public void setFromPage(int fromPage) {
		this.fromPage = fromPage;
	}

	public int getToPage() {
		return toPage;
	}

	public void setToPage(int toPage) {
		this.toPage = toPage;
	}

	public int getShowPageNum() {
		return showPageNum;
	}

	public void setShowPageNum(int showPageNum) {
		this.showPageNum = showPageNum;
	}
	
}

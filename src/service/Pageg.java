package service;

import entity.Commodity_info;
import entity.Counseling;

import java.util.List;

public class Pageg {
    private int pageindex;
    private int pageSize;
    private int totalCount;
    private int totalpage;
    private List<Counseling> list;
	public int getPageindex() {
		return pageindex;
	}
	public void setPageindex(int pageindex) {
		this.pageindex = pageindex;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		if(totalCount>0){
			this.totalCount = totalCount;
	        this.totalpage =(int)Math.ceil(totalCount/(double)pageSize);
		}
		
	    }
	public int getTotalpage() {
		return totalpage;
	}
	public void setTotalpage(int totalpage) {
		this.totalpage = totalpage;
	}
	public List<Counseling> getList() {
		return list;
	}
	public void setList(List<Counseling> list) {
		this.list = list;
	}
   
}

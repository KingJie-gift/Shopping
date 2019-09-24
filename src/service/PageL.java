package service;

import entity.Commodity_info;

import java.util.List;

public class PageL {
    private int sumCount;
    private int sumPage;
    private int indexPage;
    private int row;
    private List<Commodity_info> list;
    public int getSumCount() {
        return sumCount;
    }

    public void setSumCount(int sumCount) {
        this.sumCount = sumCount;
        this.sumPage = this.sumCount%this.row==0?this.sumCount/this.row:this.sumCount/this.row+1;
    }

    public int getSumPage() {
        return sumPage;
    }

    public void setSumPage(int sumPage) {
        this.sumPage = sumPage;
    }

    public int getIndexPage() {
        return indexPage;
    }

    public void setIndexPage(int indexPage) {
        this.indexPage = indexPage;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public List<Commodity_info> getList() {
        return list;
    }

    public void setList(List<Commodity_info> list) {
        this.list = list;
    }
}

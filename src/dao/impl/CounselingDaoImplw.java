package dao.impl;

import entity.Counseling;

import java.util.List;

public interface CounselingDaoImplw {
//  展示的数据
    public List<Counseling> getAllContent(int indexPage, int row);
//    显示一共多少行
    public int getAllCount();
//    根据id显示数据
    public Counseling getById(int id);
}

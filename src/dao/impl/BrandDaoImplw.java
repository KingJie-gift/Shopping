package dao.impl;

import entity.Brand;

import java.util.List;

public interface BrandDaoImplw {
//    查询使用最多使用的品牌
    public List<Brand> listBrand();
    public Brand brandByid(int id);
}

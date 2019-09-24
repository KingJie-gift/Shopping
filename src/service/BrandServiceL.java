package service;

import dao.BrandDaoL;
import dao.CommodityDaoL;
import dao.Commodity_smallDaoL;
import entity.Brand;
import entity.Commodity;

import java.awt.BorderLayout;
import java.util.List;

public class BrandServiceL {
    public int listBrand() {
//        先删除
        new Commodity_smallDaoL().delSmall();
        List<Brand> brands = new BrandDaoL().listBrand();
        int count = 0 ;
        for(Brand brand: brands){
            count += new Commodity_smallDaoL().addSmall(brand.getBrand_name(),new CommodityDaoL().commId());
        }
        return count;
    }
    
    public List<Brand> getBrandAll() {
    	return new BrandDaoL().getBrandAll();
    }
    public List<Brand> getBrandAll2() {
    	return new BrandDaoL().getBrandAll2();
    }
    public List<Brand> getBrandAll3() {
    	return new BrandDaoL().getBrandAll3();
    }
    public List<Brand> selectAll() {
    	return new BrandDaoL().selectAll();
    }
    public List<Commodity> selectComm() {
    	return new BrandDaoL().selectComm();
    }
    public int getBrandAdd(Brand b) {
    	return new BrandDaoL().getBrandAdd(b);
    }
    public int getdelete(int id) {
    	return new BrandDaoL().getdelete(id);
    }
    public int getdeletesp(int id) {
    	return new BrandDaoL().getdeletesp(id);
    }
}

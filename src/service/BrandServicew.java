package service;

import dao.BrandDaow;
import dao.Commodity_smallDaow;
import entity.Brand;

import java.util.List;

public class BrandServicew {
    public int listBrand() {
//        先删除
//        new Commodity_smallDao().delSmall();

//        查出来的新数据
        List<Brand> brands = new BrandDaow().listBrand();

        int count = 0 ;
        List<Integer> getSmall = new Commodity_smallDaow().commByNum();
        for(int i = 0 ; i < getSmall.size() ; i ++){

            count += new Commodity_smallDaow().addCommBy(brands.get(i).getBrand_name(),getSmall.get(i));
        }
//        查询 为1的商品编号

//
//        for(Brand brand: brands){
//            count += new Commodity_smallDao().addSmall(brand.getBrand_name(),new CommodityDao().commId());
//        }
//        return count;
        return count;
    }
}

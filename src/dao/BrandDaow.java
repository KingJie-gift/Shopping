package dao;

import dao.impl.BrandDaoImplw;
import entity.Brand;
import entity.Commodity;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BrandDaow extends BaseDaow implements BrandDaoImplw {
    @Override
    public List<Brand> listBrand() {
        List<Integer> list = new Commodity_infoDaow().getComm();
        List<Brand> brands = new ArrayList<>();
        Object [] obj = new Object[list.size()];
        String hao = "";
        for(int i = 0 ; i < list.size() ; i ++ ){
            obj[i] = list.get(i);
            if((i+1)==(list.size())){
                hao += "?";
            }else {
                hao += "?,";
            }
        }
        this.executeQuery("SELECT * FROM brand WHERE Brand_id IN ("+hao+")  and  Brand_type = 0",obj);
        try {
            while (rs.next()){
                Brand brand = new Brand();
                brand.setBrand_id(rs.getInt("Brand_id"));
                brand.setBrand_name(rs.getString("Brand_name"));
                brands.add(brand);
            }
        }catch (SQLException sql){
            sql.printStackTrace();
        }finally {
            this.closeAll();
        }
        return brands;
    }
    public Brand brandByid(int id){
        this.executeQuery("SELECT * FROM `brand` WHERE `Brand_id` = ?",new Object[]{id});
        Brand brand = null;
        try {
            while (rs.next()){
                brand = new Brand();
                brand.setBrand_id(rs.getInt("Brand_id"));
                brand.setBrand_name(rs.getString("Brand_name"));
                Commodity commodity = new Commodity();
                brand.setComm(commodity);
            }
        }catch (SQLException sql){
            sql.printStackTrace();
        }finally {
            this.closeAll();
        }
        return brand;
    }
}

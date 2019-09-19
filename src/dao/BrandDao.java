package dao;

import dao.impl.BrandDaoImpl;
import entity.Brand;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BrandDao extends BaseDao implements BrandDaoImpl {
    @Override
    public List<Brand> listBrand() {
        List<Integer> list = new Commodity_infoDao().getComm();
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
        this.executeQuery("SELECT * FROM brand WHERE Brand_id IN ("+hao+")",obj);
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
}

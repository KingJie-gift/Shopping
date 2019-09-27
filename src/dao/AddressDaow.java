package dao;

import dao.impl.AddressDaoImplw;
import entity.Address;
import entity.Enter;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AddressDaow extends BaseDaow implements AddressDaoImplw {
    public int getListAddressCount(int id){
//        显示分页，查看当前用户有多少个地址
        this.executeQuery("SELECT count(*) FROM address WHERE enter_id = ? and address_del = 0 ",new Object[]{id});
        int count = 0 ;
        try{
            while (rs.next()){
                count = rs.getInt(1);
            }
        }catch (SQLException sql){
            sql.printStackTrace();
        }finally {
            this.closeAll();
        }
        return count;
    }

    @Override
    public List<Address> getListAddress(int id) {
        this.executeQuery("SELECT * FROM address WHERE enter_id = ? and address_del = 0 ",new Object[]{id});
        return getAddresses();
    }

    private List<Address> getAddresses() {
        List<Address> list = new ArrayList<>();
        try{
            while (rs.next()){
                Address address = new Address();
                address.setAddress_id(rs.getInt("address_id"));
                Enter e = new Enter();
                e.setEnter_id(rs.getInt("enter_id"));
                address.setEnter(e);
                address.setAddress_detalied(rs.getString("address_detalied"));
                address.setAddress_postal(rs.getString("address_postal"));
                address.setAddress_name(rs.getString("address_name"));
                address.setAddress_telephone(rs.getString("address_telephone"));
                address.setAddress_default(rs.getInt("address_default"));
                list.add(address);
            }
        }catch (SQLException sql){
            sql.printStackTrace();
        }finally {
            this.closeAll();
        }
        return list;
    }

    @Override
    public List<Address> getListAddress(int id,int indexPage, int row ) {
        this.executeQuery("SELECT * FROM address WHERE enter_id = ? and address_del = 0 ORDER BY address_default DESC LIMIT ?,?  ",new Object[]{id,indexPage,row});
        return getAddresses();
    }

    @Override
    public int addAddress(Address address) {
        return this.executeUpdate("INSERT INTO address VALUES(NULL,?,?,?,?,?,?,0)",new Object[]{
                address.getEnter().getEnter_id(),address.getAddress_detalied(),address.getAddress_postal(),address.getAddress_name(),address.getAddress_telephone(),address.getAddress_default()
        });
    }

    @Override
    public int addressUpdate() {
        return this.executeUpdate("UPDATE address SET address_default = 0",null);
    }

    @Override
    public Address getAddressBuyId(int id) {
        this.executeQuery("SELECT * FROM address WHERE address_id = ?",new Object[]{id});
        Address address = null;
        try{
            while (rs.next()){
                address = new Address();
                address.setAddress_id(rs.getInt("address_id"));
                address.setAddress_name(rs.getString("address_name"));
                address.setAddress_telephone(rs.getString("address_telephone"));
                address.setAddress_detalied(rs.getString("address_detalied"));
                address.setAddress_postal(rs.getString("address_postal"));
                address.setAddress_default(rs.getInt("address_default"));
            }
        }catch (SQLException sql){
            sql.printStackTrace();
        }finally {
            this.closeAll();
        }
        return address;
    }

    public int getDelete(int id){
        String sql="UPDATE address SET address_del = 1 WHERE  address_id = ?";
        Object[] para={id};
        return executeUpdate(sql, para);
    }

    @Override
    public int getUpdate(Address a) {
        String sql="UPDATE address SET address_detalied=?,address_postal=?,address_name=?,address_telephone=?,address_default=? WHERE address_id=?";
        Object []para={a.getAddress_detalied(),a.getAddress_postal(),a.getAddress_name(),a.getAddress_telephone(),a.getAddress_default(),a.getAddress_id()};
        return executeUpdate(sql, para);
    }
}

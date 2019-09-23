package dao;

import dao.impl.AddressDaoImpl;
import entity.Address;
import entity.Enter;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AddressDao extends BaseDao implements AddressDaoImpl {
    @Override
    public List<Address> getListAddress(int id) {
        this.executeQuery("SELECT * FROM address WHERE enter_id = ?",new Object[]{id});
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
    public int addAddress(Address address) {
        return this.executeUpdate("INSERT INTO address VALUES(NULL,?,?,?,?,?,?)",new Object[]{
                address.getEnter().getEnter_id(),address.getAddress_detalied(),address.getAddress_postal(),address.getAddress_name(),address.getAddress_postal(),address.getAddress_default()
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
            }
        }catch (SQLException sql){
            sql.printStackTrace();
        }finally {
            this.closeAll();
        }
        return address;
    }

    public int getDelete(int id){
        String sql="DELETE FROM address WHERE address_id=?";
        Object[] para={id};
        return executeUpdate(sql, para);
    }

    @Override
    public int getUpdate(Address a) {
        String sql="UPDATE address SET address_detalied=?,address_postal=?,address_name=?,address_telephone=? WHERE address_id=?";
        Object []para={a.getAddress_detalied(),a.getAddress_postal(),a.getAddress_name(),a.getAddress_telephone(),a.getAddress_id()};
        return executeUpdate(sql, para);
    }
}

package dao.impl;

import entity.Address;

import java.util.List;

public interface AddressDaoImplw {
    public int getListAddressCount(int id);
    public List<Address> getListAddress(int id) ;

//    添加地址
    public int addAddress(Address address);
//    如果是1更新其他地址
    public int addressUpdate();
//    展示这个购买商品的地址
    public Address getAddressBuyId(int id);
//    删除地址
    public int getDelete(int id);
//更新地址
    public int getUpdate(Address a) ;
    //    显示用户的地址
    public List<Address> getListAddress(int indexPage, int row , int id);
}

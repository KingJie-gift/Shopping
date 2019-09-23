package service;

import dao.AddressDao;
import entity.Address;

import java.util.List;

public class AddressService {
    public List<Address> getListAddress(int id) {
        return new AddressDao().getListAddress(id);
    }
    public int addAddress(Address address) {
        return new AddressDao().addAddress(address);
    }
    public int addressUpdate() {
        return new AddressDao().addressUpdate();
    }
    public int getDelete(int id){
        return new AddressDao().getDelete(id);
    }
    public Address getAddressBuyId(int id){
        return new AddressDao().getAddressBuyId(id);
    }
    public int getUpdate(Address a) {
        return new AddressDao().getUpdate(a);
    }
}

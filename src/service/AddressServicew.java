package service;

import dao.AddressDaow;
import entity.Address;

import java.util.List;

public class AddressServicew {
    public List<Address> getListAddress(int id) {
        return new AddressDaow().getListAddress(id);
    }
    public int addAddress(Address address) {
        return new AddressDaow().addAddress(address);
    }
    public int addressUpdate() {
        return new AddressDaow().addressUpdate();
    }
    public int getDelete(int id){
        return new AddressDaow().getDelete(id);
    }
    public Address getAddressBuyId(int id){
        return new AddressDaow().getAddressBuyId(id);
    }
    public int getUpdate(Address a) {
        return new AddressDaow().getUpdate(a);
    }
}

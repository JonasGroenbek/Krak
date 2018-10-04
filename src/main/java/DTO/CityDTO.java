package DTO;

import Entities.Address;
import Entities.Cityinfo;
import java.util.Collection;

public class CityDTO {

    private int zipCode;
    private String city;
    private Collection<AddressDTO> addresses;

    public CityDTO(int zipCode, String city, Collection<AddressDTO> addresses) {
        this.zipCode = zipCode;
        this.city = city;
        this.addresses = addresses;
    }

    public CityDTO(Cityinfo city) {
        this.zipCode = city.getZip();
        this.city = city.getCity();
        convertAddress(city.getAddressCollection());
    }

    private void convertAddress(Collection<Address> address) {
        for (Address addres : address) {
            this.addresses.add(new AddressDTO(addres));
        }
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Collection<AddressDTO> getAddresses() {
        return addresses;
    }

    public void setAddresses(Collection<AddressDTO> addresses) {
        this.addresses = addresses;
    }

}

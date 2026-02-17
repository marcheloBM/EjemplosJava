/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.burgos.sakila.Ent;

import java.util.Date;
import cl.burgos.sakila.Exp.AddressException;

/**
 *
 * @author Marchelo
 */
public class Address {
    private int addressId;
    private String address;
    private String address2;
    private String district;
    //private City cityId;
    private int cityId;
    private String postalCode;
    private String phone;
    private Date lastUpdate;

    public int getAddressId() {
        return addressId;
    }

    private void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getAddress() {
            return address;
    }

    public void setAddress(String address) throws Exception {
    if(address.length()>100)
        {
            throw new AddressException(AddressException.E_ADDRESS);
        }
        else
        {
            this.address = address;
        }
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) throws Exception {
        if(address2.length()>100)
        {
            throw new AddressException(AddressException.E_ADDRESS_2);
        }
        else
        {
            this.address2 = address2;
        }
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) throws Exception {
        if(district.length()>100)
        {
            throw new AddressException(AddressException.E_DISTRICT);
        }
        else
        {
            this.district = district;
        }
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) throws Exception {
        if(postalCode.length()>100)
        {
            throw new AddressException(AddressException.E_POSTAL_CODE);
        }
        else
        {
            this.postalCode = postalCode;
        }
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) throws Exception {
        if(phone.length()>100)
        {
            throw new AddressException(AddressException.E_PHONE);
        }
        else
        {
            this.phone = phone;
        }
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    private void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
    
    //costructor para Guardar
    public Address(String address, String address2, String district, int cityId, String postalCode, String phone) throws Exception {
        setAddress(address);
        setAddress2(address2);
        setDistrict(district);
        setCityId(cityId);
        setPostalCode(postalCode);
        setPhone(phone);
    }
    
    //costructor para Actualizar
    public Address(int addressId, String address, String address2, String district, int cityId, String postalCode, String phone) throws Exception {
        setAddressId(addressId);
        setAddress(address);
        setAddress2(address2);
        setDistrict(district);
        setCityId(cityId);
        setPostalCode(postalCode);
        setPhone(phone);
    }
    
    //constructor para Eliminar
    public Address(int addressId) {
        setAddressId(addressId);
    }

    @Override
    public String toString() {
        return "Address{" + "addressId=" + addressId + ", address=" + address + ", address2=" + address2 + ", district=" + district + ", cityId=" + cityId + ", postalCode=" + postalCode + ", phone=" + phone + ", lastUpdate=" + lastUpdate + '}';
    }
    
    public void imprimir()
    {
        System.out.println(this.toString());
    }

}

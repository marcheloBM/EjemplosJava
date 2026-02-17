/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.burgos.sakila.Ent;

import cl.burgos.sakila.Exp.CustomerException;
import java.util.Date;

/**
 *
 * @author Marchelo
 */
public class Customer {
    private int customerId;
    //private Store storeId;
    private int storeId;
    private String firstName;
    private String lastName;
    private String email;
    //private Address addressId;
    private int addressId;
    private int active;
    private Date createDate;
    private Date lastUpdate;

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) throws  Exception {
        if(firstName==null||firstName.length()<2||firstName.length()>45)
        {
            throw new CustomerException(CustomerException.E_FIRST_NAME);
        }
        else
        {
            this.firstName = firstName;
        }
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) throws Exception {
        if(lastName==null||lastName.length()<2||lastName.length()>45)
        {
            throw new CustomerException(CustomerException.E_LAST_NAME);
        }
        else
        {
            this.lastName = lastName;
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws Exception {
        if(email.length()<5||email.length()>50)
        {
            throw new CustomerException(CustomerException.E_EMAIL);
        }
        else
        {
            this.email = email;
        }
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    private void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
//costructor para Guardar
    public Customer(int storeId, String firstName, String lastName, String email, int addressId, int active) throws Exception {
        setStoreId(storeId);
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
        setAddressId(addressId);
        setActive(active);
    }
    //costructor para Actualizar
    public Customer(int customerId, int storeId, String firstName, String lastName, String email, int addressId, int active) throws Exception {
        setCustomerId(customerId);
        setStoreId(storeId);
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
        setAddressId(addressId);
        setActive(active);
    }
    //costructor para Eliminar
    public Customer(int customerId) throws Exception {
        setCustomerId(customerId);   
    }
    
    @Override
    public String toString() {
        return "Customer{" + "customerId=" + customerId + ", storeId=" + storeId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", addressId=" + addressId + ", active=" + active + ", createDate=" + createDate + ", lastUpdate=" + lastUpdate + '}';
    }
    
    public void imprimir()
    {
        System.out.println(this.toString());
    }
    
}

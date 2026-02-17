/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.burgos.sakila.Ent;

import java.sql.Blob;
import java.util.Date;
import cl.burgos.sakila.Exp.StaffException;

/**
 *
 * @author Marchelo
 */
public class Staff {
    private Staff staffId;
    private String firstName;
    private String lastName;
    private Address addressId;
    //Nose si funciona por que hay que cargar imagenes
    private Blob piscture;
    private String email;
    private Store storeId;
    private int active;
    private String username;
    private String password;
    private Date lastUpdate;

    public Staff getStaffId() {
        return staffId;
    }

    private void setStaffId(Staff staffId) {
        this.staffId = staffId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) throws Exception {
        if(firstName==null||firstName.length()<5||firstName.length()>45)
        {
            throw new StaffException(StaffException.E_FIRST_NAME);
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
        if(lastName==null||lastName.length()<5||lastName.length()>45)
        {
            throw new StaffException(StaffException.E_LAST_NAME);
        }
        else
        {
            this.lastName = lastName;
        }
    }

    public Address getAddressId() {
        return addressId;
    }

    public void setAddressId(Address addressId) {
        this.addressId = addressId;
    }

    public Blob getPiscture() {
        return piscture;
    }

    public void setPiscture(Blob piscture) {
        this.piscture = piscture;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws Exception {
        if(email.length()<5||email.length()>50)
        {
            throw new StaffException(StaffException.E_EMAIL);
        }
        else
        {
            this.email = email;
        }
    }

    public Store getStoreId() {
        return storeId;
    }

    public void setStoreId(Store storeId) {
        this.storeId = storeId;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) throws Exception {
        if(username==null||username.length()<5||username.length()>16)
        {
            throw new StaffException(StaffException.E_USERNAME);
        }
        else
        {
            this.username = username;
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) throws Exception {
        if(password.length()<5||password.length()>40)
        {
            throw new StaffException(StaffException.E_PASSWORD);
        }
        else
        {
            this.password = password;
        }
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
    
//costructor para Guardar
    public Staff( String firstName, String lastName, Address addressId, Blob piscture, String email, Store storeId, int active, String username, String password) throws Exception {
        setFirstName(firstName);
        setLastName(lastName);
        setAddressId(addressId);
        setPiscture(piscture);
        setEmail(email);
        setStoreId(storeId);
        setActive(active);
        setUsername(username);
        setPassword(password);
    }
//costructor para Actualizar
    public Staff(Staff staffId, String firstName, String lastName, Address addressId, Blob piscture, String email, Store storeId, int active, String username, String password) throws Exception {
        setStaffId(staffId);
        setFirstName(firstName);
        setLastName(lastName);
        setAddressId(addressId);
        setPiscture(piscture);
        setEmail(email);
        setStoreId(storeId);
        setActive(active);
        setUsername(username);
        setPassword(password);
    }
    
//constructor para Eliminar
    public Staff(Staff staffId) throws Exception {
        setStaffId(staffId);
    }

    @Override
    public String toString() {
        return "Staff{" + "staffId=" + staffId + ", firstName=" + firstName + ", lastName=" + lastName + ", addressId=" + addressId + ", piscture=" + piscture + ", email=" + email + ", storeId=" + storeId + ", active=" + active + ", username=" + username + ", password=" + password + ", lastUpdate=" + lastUpdate + '}';
    }

    public void imprimir()
    {
        System.out.println(this.toString());
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.burgos.sakila.Ent;

import java.util.Date;

/**
 *
 * @author Marchelo
 */
public class Store {
    private int storeId;
    private int managerStaffID;
    private int addressId;
    //private Address addressId;
    private Date lastUpdate;

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public int getManagerStaffID() {
        return managerStaffID;
    }

    public void setManagerStaffID(int managerStaffID) {
        this.managerStaffID = managerStaffID;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    private void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
    
//costructor para Guardar
    public Store( int managerStaffID, int addressId ) {
        setManagerStaffID(managerStaffID);
        setAddressId(addressId);
    }
//costructor para Actualizar
    public Store(int storeId, int managerStaffID, int addressId) {
        setStoreId(storeId);
        setManagerStaffID(managerStaffID);
        setAddressId(addressId);
    }
//constructor para Eliminar
    public Store(int storeId ) {
        setStoreId(storeId);
    }

    @Override
    public String toString() {
        return "Store{" + "storeId=" + storeId + ", managerStaffID=" + managerStaffID + ", addressId=" + addressId + ", lastUpdate=" + lastUpdate + '}';
    }

    public void imprimir()
    {
        System.out.println(this.toString());
    }
    
}

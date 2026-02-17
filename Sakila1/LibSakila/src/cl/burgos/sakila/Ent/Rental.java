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
public class Rental {
    private int rentalId;
    private Date rentalDate;
    private Inventory inventoryId;
    private Customer customerId;
    private Date returnDate;
    private Staff staffId;
    //private int staffId;
    private Date lastUpdate;

    public int getRentalId() {
        return rentalId;
    }

    private void setRentalId(int rentalId) {
        this.rentalId = rentalId;
    }

    public Date getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(Date rentalDate) {
        this.rentalDate = rentalDate;
    }

    public Inventory getInventoryId() {
        return inventoryId;
    }

    private void setInventoryId(Inventory inventoryId) {
        this.inventoryId = inventoryId;
    }

    public Customer getCustomerId() {
        return customerId;
    }

    private void setCustomerId(Customer customerId) {
        this.customerId = customerId;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public Staff getStaffId() {
        return staffId;
    }

    private void setStaffId(Staff staffId) {
        this.staffId = staffId;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
    
//costructor para Guardar
    public Rental(int rentalId, Date rentalDate, Inventory inventoryId, Customer customerId, Staff staffId, Date lastUpdate) {
        setRentalId(rentalId);
        setRentalDate(rentalDate);
        setInventoryId(inventoryId);
        setCustomerId(customerId);
        setStaffId(staffId);
    }
//costructor para Actualizar
    public Rental(int rentalId, Date rentalDate, Inventory inventoryId, Customer customerId, Date returnDate, Staff staffId, Date lastUpdate) {
        setRentalId(rentalId);
        setRentalDate(rentalDate);
        setInventoryId(inventoryId);
        setCustomerId(customerId);
        setReturnDate(returnDate);
        setStaffId(staffId);
    }
//constructor para Eliminar
    public Rental(int rentalId) {
        setRentalId(rentalId);
    }

    @Override
    public String toString() {
        return "Rental{" + "rentalId=" + rentalId + ", rentalDate=" + rentalDate + ", inventoryId=" + inventoryId + ", customerId=" + customerId + ", returnDate=" + returnDate + ", staffId=" + staffId + ", lastUpdate=" + lastUpdate + '}';
    }

    public void imprimir()
    {
        System.out.println(this.toString());
    }
}

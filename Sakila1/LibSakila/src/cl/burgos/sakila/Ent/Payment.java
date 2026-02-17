/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.burgos.sakila.Ent;

import cl.burgos.sakila.Exp.PaymentException;
import java.util.Date;

/**
 *
 * @author Marchelo
 */
public class Payment {
    private int paymentId;
    private Customer customerId;
    //private int customerId;
    private Staff staffId;
    //private int staffId;
    private Rental rentalId;
    //private int rentalId;
    private double amount;
    private Date paymentDate;
    private Date lastUpdate;

    public int getPaymentId() {
        return paymentId;
    }

    private void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public Customer getCustomerId() {
        return customerId;
    }

    private void setCustomerId(Customer customerId) {
        this.customerId = customerId;
    }

    public Staff getStaffId() {
        return staffId;
    }

    private void setStaffId(Staff staffId) {
        this.staffId = staffId;
    }

    public Rental getRentalId() {
        return rentalId;
    }

    private void setRentalId(Rental rentalId) {
        this.rentalId = rentalId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) throws Exception {
        if(amount>0.00||amount<99999.99)
        {
            throw new PaymentException(PaymentException.E_AMOUNT);
        }
        else
        {
            this.amount = amount;
        }
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    private void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    private void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
//costructor para Guardar
    public Payment(Customer customerId, Staff staffId, Rental rentalId, double amount) throws Exception {
        setCustomerId(customerId);
        setStaffId(staffId);
        setRentalId(rentalId);
        setAmount(amount);
    }
//costructor para Actualizar
    public Payment(int paymentId, Customer customerId, Staff staffId, Rental rentalId, double amount) throws Exception {
        setPaymentId(paymentId);
        setCustomerId(customerId);
        setStaffId(staffId);
        setRentalId(rentalId);
        setAmount(amount);
    }
//constructor para Eliminar
    public Payment(int paymentId) {
        setPaymentId(paymentId);
    }

    @Override
    public String toString() {
        return "Payment{" + "paymentId=" + paymentId + ", customerId=" + customerId + ", staffId=" + staffId + ", rentalId=" + rentalId + ", amount=" + amount + ", paymentDate=" + paymentDate + ", lastUpdate=" + lastUpdate + '}';
    }
    
    public void imprimir()
    {
        System.out.println(this.toString());
    }
}

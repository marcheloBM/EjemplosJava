/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.burgos.sakila.DAO;

import cl.burgos.sakila.BD.BD;
import cl.burgos.sakila.Ent.Customer;
import cl.burgos.sakila.BD.Log;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Marchelo
 */
public class CustomerDAO {
    public static boolean sqlAgregar(Customer customer) {
        String sql = String.format("insert into customer(store_id,first_name,last_name,email,address_id,active,create_date,last_update)"
                + "values('%d','%s','%s','%s','%d','%s',now(),now()) "
                ,customer.getStoreId()
                ,customer.getFirstName()
                ,customer.getLastName()
                ,customer.getEmail()
                ,customer.getAddressId()
                ,customer.getActive()
                ,customer.getCreateDate());
        BD.getInstance().sqlEjecutar(sql);
        return true;
    }
    public static void sqlAgregar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public static boolean sqlBuscar(Customer customer) throws Exception {
        try {
            String sql = String.format("select store_id,first_name,last_name,email,address_id,active,create_date,last_update from customer where customer_id=%d",customer.getCustomerId());
            ResultSet rs=BD.getInstance().sqlBuscar(sql);
            if(rs==null)return false;
            if(!rs.next())return false;
            customer.setStoreId(rs.getInt("store_id"));
            customer.setFirstName(rs.getString("first_name"));
            customer.setLastName(rs.getString("last_name"));
            customer.setEmail(rs.getString("email"));
            customer.setAddressId(rs.getInt("address_id"));
            customer.setActive(rs.getInt("active"));
            return true;
        } catch (SQLException ex) {
            Log.log("Buscar error"+ex.getMessage());
            Logger.getLogger(AddressDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public static boolean sqlModificar(Customer customer) {
        String sql = String.format("update customer set store_id='%d', first_name='%s',last_name='%s',email='%s',address_id='%d',active='%s' where customer_id=%d"
                ,customer.getStoreId()
                ,customer.getFirstName()
                ,customer.getLastName()
                ,customer.getEmail()
                ,customer.getAddressId()
                ,customer.getActive()
                ,customer.getCustomerId());
        return BD.getInstance().sqlEjecutar(sql);
    }
    public static boolean sqlEliminar(Customer customer) {
       String sql = String.format("delete from customer where customer_id=%d"
               ,customer.getCustomerId());
        return BD.getInstance().sqlEjecutar(sql);
    }
    public static ArrayList<Customer> sqlBuscar()
    {
        ArrayList<Customer> lista=new ArrayList<Customer>();
        try {
            String sql = String.format("select customer_id, store_id,first_name,last_name,email,address_id,active,create_date,last_update from customer ");
            ResultSet rs=BD.getInstance().sqlBuscar(sql);
            if(rs==null)return lista;
            while(rs.next()){
                lista.add(new Customer(rs.getInt("customer_id")
                        ,rs.getInt("store_id")
                        ,rs.getString("first_name")
                        ,rs.getString("last_name")
                        ,rs.getString("email")
                        ,rs.getInt("address_id")
                        ,rs.getInt("active")));
            }
            return lista;
        } catch (SQLException ex) {
            Log.log("Listar 1 "+ex.getMessage());
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
            return lista;
        } catch (Exception ex) {
            Log.log("Listar 2 "+ex.getMessage());
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
            return lista;
        }
    }
}

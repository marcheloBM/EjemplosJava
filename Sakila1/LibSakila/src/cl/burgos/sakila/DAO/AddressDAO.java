/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.burgos.sakila.DAO;

import cl.burgos.sakila.BD.BD;
import cl.burgos.sakila.Ent.Address;
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
public class AddressDAO {
    public static boolean sqlAgregar(Address address) {
        String sql = String.format("insert into address(address,address2,district,city_id,postal_code,phone,last_update)"
                + "values('%s','%s','%s','%d','%s','%s',now()) "
                ,address.getAddress()
                ,address.getAddress2()
                ,address.getDistrict()
                ,address.getCityId()
                ,address.getPostalCode()
                ,address.getPhone());
        BD.getInstance().sqlEjecutar(sql);
        return true;
    }
    public static boolean sqlEliminar(Address address) {
       String sql = String.format("delete from address where address_id=%d"
               ,address.getAddressId());
        return BD.getInstance().sqlEjecutar(sql);
    }
    public static boolean sqlModificar(Address address) {
        String sql = String.format("update address set address='%s', address2='%s',district='%s',city_id='%d',postal_code='%s',phone='%s' where address_id=%d"
                ,address.getAddress()
                ,address.getAddress2()
                ,address.getDistrict()
                ,address.getCityId()
                ,address.getPostalCode()
                ,address.getPhone()
                ,address.getAddressId());
        return BD.getInstance().sqlEjecutar(sql);
    }

    public static boolean sqlBuscar(Address address) throws Exception {
        try {
            String sql = String.format("select address,address2,district,city_id,postal_code,phone,last_update from address where address_id=%d",address.getAddressId());
            ResultSet rs=BD.getInstance().sqlBuscar(sql);
            if(rs==null)return false;
            if(!rs.next())return false;
            address.setAddress(rs.getString("address"));
            address.setAddress2(rs.getString("address2"));
            address.setDistrict(rs.getString("district"));
            address.setCityId(rs.getInt("city_id"));
            address.setPostalCode(rs.getString("postal_code"));
            address.setPhone(rs.getString("phone"));
            return true;
        } catch (SQLException ex) {
            Log.log("Buscar error"+ex.getMessage());
            Logger.getLogger(AddressDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static void sqlAgregar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static ArrayList<Address> sqlBuscar()
    {
        ArrayList<Address> lista=new ArrayList<Address>();
        try {
            String sql = String.format("select address_id, address ,address2 ,district, city_id ,postal_code ,phone ,last_update from address ");
            ResultSet rs=BD.getInstance().sqlBuscar(sql);
            if(rs==null)return lista;
            while(rs.next()){
                lista.add(new Address(rs.getInt("address_id")
                        ,rs.getString("address")
                        ,rs.getString("address2")
                        ,rs.getString("district")
                        ,rs.getInt("city_id")
                        ,rs.getString("postal_code")
                        ,rs.getString("phone")));
            }
            
            return lista;
        } catch (SQLException ex) {
            Log.log("Listar 1 "+ex.getMessage());
            Logger.getLogger(AddressDAO.class.getName()).log(Level.SEVERE, null, ex);
            return lista;
        } catch (Exception ex) {
            Log.log("Listar 2 "+ex.getMessage());
            Logger.getLogger(AddressDAO.class.getName()).log(Level.SEVERE, null, ex);
            return lista;
        }
    }
}

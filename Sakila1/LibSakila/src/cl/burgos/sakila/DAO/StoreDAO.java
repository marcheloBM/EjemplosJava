/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.burgos.sakila.DAO;
import cl.burgos.sakila.BD.BD;
import cl.burgos.sakila.Ent.Store;
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
public class StoreDAO {
    public static boolean sqlAgregar(Store store) {
        String sql = String.format("insert into store(manager_staff_id,address_id,last_update)"
                + "values('%d','%d',now()) "
                ,store.getManagerStaffID()
                ,store.getAddressId());
        BD.getInstance().sqlEjecutar(sql);
        return true;
    }
    public static boolean sqlEliminar(Store store) {
       String sql = String.format("delete from store where store_id=%d"
               ,store.getStoreId());
        return BD.getInstance().sqlEjecutar(sql);
    }
    public static boolean sqlModificar(Store store) {
        String sql = String.format("update store set manager_staff_id='%d',address_id='%d' where store_id=%d"
                ,store.getManagerStaffID()
        ,store.getAddressId()
        ,store.getStoreId());
        return BD.getInstance().sqlEjecutar(sql);
    }

    public static boolean sqlBuscar(Store store) throws Exception {
        try {
            String sql = String.format("select manager_staff_id,address_id,last_update from address where store_id=%d",store.getStoreId());
            ResultSet rs=BD.getInstance().sqlBuscar(sql);
            if(rs==null)return false;
            if(!rs.next())return false;
            store.setManagerStaffID(rs.getInt("manager_staff_id"));
            store.setAddressId(rs.getInt("address_id"));
            return true;
        } catch (SQLException ex) {
            Log.log("Buscar error"+ex.getMessage());
            Logger.getLogger(StoreDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static void sqlAgregar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static ArrayList<Store> sqlBuscar()
    {
        ArrayList<Store> lista=new ArrayList<Store>();
        try {
            String sql = String.format("select store_id,manager_staff_id,address_id,last_update from store ");
            ResultSet rs=BD.getInstance().sqlBuscar(sql);
            if(rs==null)return lista;
            while(rs.next()){
                lista.add(new Store(rs.getInt("store_id")
                        ,rs.getInt("manager_staff_id")
                        ,rs.getInt("address_id")));
            }
            return lista;
        } catch (SQLException ex) {
            Log.log("Listar 1 "+ex.getMessage());
            Logger.getLogger(StoreDAO.class.getName()).log(Level.SEVERE, null, ex);
            return lista;
        } catch (Exception ex) {
            Log.log("Listar 2 "+ex.getMessage());
            Logger.getLogger(StoreDAO.class.getName()).log(Level.SEVERE, null, ex);
            return lista;
        }
    }
}

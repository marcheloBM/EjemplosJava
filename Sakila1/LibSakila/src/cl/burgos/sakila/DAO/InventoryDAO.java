/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.burgos.sakila.DAO;
import cl.burgos.sakila.BD.BD;
import cl.burgos.sakila.Ent.Inventory;
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
public class InventoryDAO {
    public static boolean sqlAgregar(Inventory inventory) {
        String sql = String.format("insert into inventory(film_id,store_id,last_update)"
                + "values('%d','%d',now()) "
                ,inventory.getFilmId()
                ,inventory.getStoreId());
        BD.getInstance().sqlEjecutar(sql);
        return true;
    }
    public static boolean sqlEliminar(Inventory inventory) {
       String sql = String.format("delete from inventor where inventor_id=%d"
               ,inventory.getInventoryId());
        return BD.getInstance().sqlEjecutar(sql);
    }
    public static boolean sqlModificar(Inventory inventory) {
        String sql = String.format("update inventory set film_id='%d', store_id='%d' where inventory_id=%d"
                ,inventory.getFilmId()
                ,inventory.getStoreId()
                ,inventory.getInventoryId());
        return BD.getInstance().sqlEjecutar(sql);
    }
    public static boolean sqlBuscar(Inventory inventory) throws Exception {
        try {
            String sql = String.format("select film_id,store_id,last_update from inventory where inventory_id=%d",inventory.getInventoryId());
            ResultSet rs=BD.getInstance().sqlBuscar(sql);
            if(rs==null)return false;
            if(!rs.next())return false;
            inventory.setFilmId(rs.getInt("film_id"));
            inventory.setInventoryId(rs.getInt("store_id"));
            return true;
        } catch (SQLException ex) {
            Log.log("Buscar error"+ex.getMessage());
            Logger.getLogger(InventoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public static void sqlAgregar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public static ArrayList<Inventory> sqlBuscar()
    {
        ArrayList<Inventory> lista=new ArrayList<Inventory>();
        try {
            String sql = String.format("select inventory_id,film_id,store_id ,last_update from inventory ");
            ResultSet rs=BD.getInstance().sqlBuscar(sql);
            if(rs==null)return lista;
            while(rs.next()){
                lista.add(new Inventory(rs.getInt("inventory_id")
                        ,rs.getInt("film_id")
                        ,rs.getInt("store_id")));
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

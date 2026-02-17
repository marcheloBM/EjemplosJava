/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.burgos.sakila.DAO;

import cl.burgos.sakila.BD.BD;
import cl.burgos.sakila.Ent.Category;
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
public class CategoryDAO {
    public static boolean sqlAgregar(Category category) {
        String sql = String.format("insert into category(name,last_update) values('%s',now())"
                ,category.getName());
        BD.getInstance().sqlEjecutar(sql);
        return true;
    }
    public static boolean sqlEliminar(Category category) {
       String sql = String.format("delete from category where category_id=%d",category.getCategoryId());
        return BD.getInstance().sqlEjecutar(sql);
    }
    public static boolean sqlModificar(Category category) {
        String sql = String.format("update category set name='%s' where category_id=%d"
                ,category.getName()
                ,category.getCategoryId());
        return BD.getInstance().sqlEjecutar(sql);
    }
    public static boolean sqlBuscar(Category category) throws Exception {
        try {
            String sql = String.format("select name,last_update from category where category_id=%d"
                    ,category.getCategoryId());
            ResultSet rs=BD.getInstance().sqlBuscar(sql);
            if(rs==null)return false;
            if(!rs.next())return false;
            category.setName(rs.getString("name"));
            
            return true;
        } catch (SQLException ex) {
            Log.log("Buscar error"+ex.getMessage());
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public static void sqlAgregar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public static ArrayList<Category> sqlBuscar()
    {
        ArrayList<Category> lista=new ArrayList<Category>();
        try {
            String sql = String.format("select category_id,name,last_update from category ");
            ResultSet rs=BD.getInstance().sqlBuscar(sql);
            if(rs==null)return lista;
            while(rs.next()){
                lista.add(new Category(rs.getInt("category_id"), rs.getString("name")));
            
            }
            
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
            return lista;
        } catch (Exception ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
            return lista;
        }
    }
}

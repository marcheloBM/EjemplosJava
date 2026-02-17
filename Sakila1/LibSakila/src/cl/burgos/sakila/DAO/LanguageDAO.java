/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.burgos.sakila.DAO;

import cl.burgos.sakila.BD.BD;
import cl.burgos.sakila.Ent.Language;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marchelo
 */
public class LanguageDAO {
    public static boolean sqlAgregar(Language languaje)
    {
        String sql=String.format("insert into language(name,last_update) values('%s',now())",
                languaje.getName(),languaje.getLastUpdate());
        BD.getInstance().sqlEjecutar(sql);
        return true;
    }
    public static void sqlAgregar()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public static boolean sqlEliminar(Language languaje) {
       String sql = String.format("delete from language where language_id=%d",languaje.getLanguageId());
        return BD.getInstance().sqlEjecutar(sql);
    }

    public static boolean sqlModificar(Language languaje) {
        
        String sql = String.format("update language set name='%s' where language_id=%d"
                ,languaje.getName()
                ,languaje.getLanguageId()
              );
        return BD.getInstance().sqlEjecutar(sql);
        
    }

    public static boolean sqlBuscar(Language languaje) throws Exception {
        
        try {
            String sql= String.format("select name,last_update from Language where language_id=%d",languaje.getLanguageId());
            ResultSet rs=BD.getInstance().sqlBuscar(sql);
            if(rs==null)return false;
            if(!rs.next())return false;
            languaje.setName(rs.getString("name"));
            
            return true;
            
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(LanguageDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public static ArrayList<Language> sqlBuscar()
    {
         ArrayList<Language> lista=new ArrayList<Language>();
        try {
            String sql = String.format("select language_id,name,last_update from language ");
            ResultSet rs=BD.getInstance().sqlBuscar(sql);
            if(rs==null)return lista;
            while(rs.next()){
                //esta es la mejor por que no declaro nada
                lista.add(new Language(rs.getInt("language_id"), rs.getString("name")));
            }
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(LanguageDAO.class.getName()).log(Level.SEVERE, null, ex);
            return lista;
        } catch (Exception ex) {
            Logger.getLogger(LanguageDAO.class.getName()).log(Level.SEVERE, null, ex);
            return lista;
        }
    }
}

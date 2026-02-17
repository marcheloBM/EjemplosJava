/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.burgos.sakila.DAO;

import cl.burgos.sakila.BD.BD;
import cl.burgos.sakila.Ent.FilmText;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import cl.burgos.sakila.BD.Log;
/**
 *
 * @author Marchelo
 */
public class FilmTextDAO {
    public static boolean sqlAgregar(FilmText filmText)
    {
        String sql=String.format("insert into film_text(film_id,title,description) values('%d','%s','%s')"
                ,filmText.getFilmId()
                ,filmText.getTitle()
                ,filmText.getDescription());
        BD.getInstance().sqlEjecutar(sql);
        return true;
        
    }
    public static boolean sqlEliminar(FilmText filmText)
    {
        String sql=String.format("delete from film_text where film_id=%d"
                ,filmText.getFilmId());
        return BD.getInstance().sqlEjecutar(sql);
    }
    public static boolean sqlModificar(FilmText filmText)
    {
        String sql=String.format("update film_text set film_id'%d',title='%s',description='%s' where film_id=%d"
                ,filmText.getFilmId()
                ,filmText.getTitle()
                ,filmText.getDescription()
                ,filmText.getFilmId());
        return BD.getInstance().sqlEjecutar(sql);
    }
    public static boolean sqlBuscar(FilmText filmText) throws Exception {
        try {
            String sql = String.format("select title,description from film_text where film_id=%d"
                    ,filmText.getFilmId());
            ResultSet rs=BD.getInstance().sqlBuscar(sql);
            if(rs==null)return false;
            if(!rs.next())return false;
            filmText.setTitle(rs.getString("title"));
            filmText.setDescription(rs.getString("description"));
            
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(FilmTextDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public static void sqlAgregar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public static ArrayList<FilmText> sqlBuscar()
    {
        ArrayList<FilmText> lista=new ArrayList<FilmText>();
        try {
            String sql = String.format("select film_id,title,description from film_text ");
            ResultSet rs=BD.getInstance().sqlBuscar(sql);
            if(rs==null)return lista;
            while(rs.next()){
                lista.add(new FilmText(rs.getInt("film_id"), rs.getString("title"),rs.getString("description")));
            
            }
            
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(FilmTextDAO.class.getName()).log(Level.SEVERE, null, ex);
            return lista;
        } catch (Exception ex) {
            Logger.getLogger(FilmTextDAO.class.getName()).log(Level.SEVERE, null, ex);
            return lista;
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.burgos.sakila.DAO;
import cl.burgos.sakila.BD.BD;
import cl.burgos.sakila.Ent.Film;
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
public class FilmDAO {
    public static boolean sqlAgregar(Film film) {
        String sql = String.format("insert into film(title,description,release_year,language_id ,original_language_id,rental_duration,rental_rate ,length, replacement_cost,rating,special_features,last_update)"
                + "values('%s','%s',now(),'%d','%d','%d','%s','%f','%d','%s','%s',now()) "
                ,film.getTitle()
                ,film.getDescription()
                ,film.getReleaseYear()
                ,film.getLenguageId()
                ,film.getOriginalLenguageID()
                ,film.getRentalDuration()
                ,film.getRentaRate()
                ,film.getLength()
                ,film.getReplacementCost()
                ,film.getRating()
                ,film.getSpecialFeatures());
        BD.getInstance().sqlEjecutar(sql);
        return true;
    }
    public static boolean sqlEliminar(Film film) {
       String sql = String.format("delete from film where film_id=%d"
               ,film.getFilmId());
        return BD.getInstance().sqlEjecutar(sql);
    }
    public static boolean sqlModificar(Film film) {
        String sql = String.format("update film set title='%s',description='%s',release_year=now(),language_id='%d' ,original_language_id='%d',rental_duration='%d',rental_rate='%s' ,length='%f', replacement_cost='%d',rating='%s',special_features='%s' where film_id=%d"
                ,film.getTitle()
                ,film.getDescription()
                ,film.getReleaseYear()
                ,film.getLenguageId()
                ,film.getOriginalLenguageID()
                ,film.getRentalDuration()
                ,film.getRentaRate()
                ,film.getLength()
                ,film.getReplacementCost()
                ,film.getRating()
                ,film.getSpecialFeatures()
                ,film.getFilmId());
        return BD.getInstance().sqlEjecutar(sql);
    }
    public static boolean sqlBuscar(Film film) throws Exception {
        try {
            String sql = String.format("select title,description,release_year,language_id ,original_language_id,rental_duration,rental_rate ,length, replacement_cost,rating,special_features,last_update from film where film_id=%d"
                    ,film.getFilmId());
            ResultSet rs=BD.getInstance().sqlBuscar(sql);
            if(rs==null)return false;
            if(!rs.next())return false;
            film.setTitle(rs.getString("title"));
            film.setDescription(rs.getString("description"));
            
            film.setLenguageId(rs.getInt("language_id"));
            film.setOriginalLenguageID(rs.getInt("original_language_id"));
            film.setRentalDuration(rs.getInt("rental_duration"));
            film.setRentaRate(rs.getDouble("rental_rate"));
            film.setLength(rs.getInt("length"));
            film.setReplacementCost(rs.getDouble("replacement_cost"));
            film.setRating(rs.getString("rating"));
            film.setSpecialFeatures(rs.getString("special_features"));
            return true;
        } catch (SQLException ex) {
            Log.log("Buscar error"+ex.getMessage());
            Logger.getLogger(FilmDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public static void sqlAgregar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public static ArrayList<Film> sqlBuscar()
    {
        ArrayList<Film> lista=new ArrayList<Film>();
        try {
            String sql = String.format("select film_id,title,description,release_year,language_id ,original_language_id,rental_duration,rental_rate ,length, replacement_cost,rating,special_features,last_update from film ");
            ResultSet rs=BD.getInstance().sqlBuscar(sql);
            if(rs==null)return lista;
            while(rs.next()){
                lista.add(new Film(rs.getInt("film_id")
                        ,rs.getString("title")
                        ,rs.getString("description")
                        ,rs.getDate("release_year")
                        ,rs.getInt("language_id")
                        ,rs.getInt("original_language_id")
                        ,rs.getInt("rental_duration")
                        ,rs.getDouble("rental_rate")
                        ,rs.getInt("length")
                        ,rs.getDouble("replacement_cost")
                        ,rs.getString("rating")
                        ,rs.getString("special_features")));
            }
            Log.log("Listar "+rs);
            return lista;
        } catch (SQLException ex) {
            Log.log("Listar 1 "+ex.getMessage());
            Logger.getLogger(FilmDAO.class.getName()).log(Level.SEVERE, null, ex);
            return lista;
        } catch (Exception ex) {
            Log.log("Listar 2 "+ex.getMessage());
            Logger.getLogger(FilmDAO.class.getName()).log(Level.SEVERE, null, ex);
            return lista;
        }
    }
}

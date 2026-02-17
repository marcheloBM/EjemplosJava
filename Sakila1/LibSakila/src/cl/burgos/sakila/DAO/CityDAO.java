/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.burgos.sakila.DAO;

import cl.burgos.sakila.BD.BD;
import cl.burgos.sakila.Ent.City;
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
public class CityDAO {
    public static boolean sqlAgregar(City city) {
        String sql = String.format("insert into city(city,country_id,last_update) values('%s','%d',now()) ",
                city.getCity(),city.getCountryId());
        BD.getInstance().sqlEjecutar(sql);
        return true;
    }
    public static boolean sqlEliminar(City city) {
       String sql = String.format("delete from city where city_id=%d",city.getCityId());
        return BD.getInstance().sqlEjecutar(sql);
    }
    public static boolean sqlModificar(City city) {
        String sql = String.format("update city set city='%s', country_id='%d' where city_id=%d"
                ,city.getCity()
                ,city.getCountryId()
                ,city.getCityId()
              );
        return BD.getInstance().sqlEjecutar(sql);
    }
    //buscar
    public static boolean sqlBuscar(City city) throws Exception {
        try {
            String sql = String.format("select city,country_id,last_update from city where city_id=%d",city.getCityId());
            ResultSet rs=BD.getInstance().sqlBuscar(sql);
            Log.log("Buscar "+sql);
            if(rs==null)return false;
            if(!rs.next())return false;
            city.setCity(rs.getString("city"));
            city.setCountryId(rs.getInt("country_id"));
            
            return true;
        } catch (SQLException ex) {
            Log.log("Buscar error"+ex.getMessage());
            Logger.getLogger(CityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
        
    public static void sqlAgregar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    //listar
    public static ArrayList<City> sqlBuscar()
    {
        ArrayList<City> lista=new ArrayList<City>();
        try {
            String sql = String.format("select city_id, city, country_id, last_update from city");
            ResultSet rs=BD.getInstance().sqlBuscar(sql);
            if(rs==null)return lista;
            while(rs.next()){
                lista.add(new City(rs.getInt("city_id"), rs.getString("city"),rs.getInt("country_id")));
            }
            return lista;
        } catch (SQLException ex) {
            Log.log("Buscar error"+ex.getMessage());
            Logger.getLogger(CityDAO.class.getName()).log(Level.SEVERE, null, ex);
            return lista;
        } catch (Exception ex) {
            Log.log("Buscar error"+ex.getMessage());
            Logger.getLogger(CityDAO.class.getName()).log(Level.SEVERE, null, ex);
            return lista;
        }
    }
}

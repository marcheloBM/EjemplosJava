/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.burgos.sakila.DAO;

import cl.burgos.sakila.BD.BD;
import cl.burgos.sakila.Ent.Country;
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
public class CountryDAO {
    public static boolean sqlAgregar(Country country)
    {
        String sql=String.format("insert into country(country,last_update) values('%s',now())"
                ,country.getCountry());
        BD.getInstance().sqlEjecutar(sql);
        return true;
    }
    public static boolean sqlEliminar(Country country)
    {
        String sql=String.format("delete from country where country_id=%d",country.getCountryId());
        return BD.getInstance().sqlEjecutar(sql);
    }
    public static boolean sqlModificar(Country country)
    {
        String sql=String.format("update country set country='%s' where country_id=%d",country.getCountry(),country.getCountryId());
        return BD.getInstance().sqlEjecutar(sql);
    }
    public static boolean sqlBuscar(Country country) throws Exception {
        try {
            String sql = String.format("select country,last_update from country where country_id=%d",country.getCountryId());
            ResultSet rs=BD.getInstance().sqlBuscar(sql);
            if(rs==null)return false;
            if(!rs.next())return false;
            country.setCountry(rs.getString("country"));
            
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CountryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public static void sqlAgregar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public static ArrayList<Country> sqlBuscar()
    {
        ArrayList<Country> lista=new ArrayList<Country>();
        try {
            String sql = String.format("select country_id,country,last_update from country ");
            ResultSet rs=BD.getInstance().sqlBuscar(sql);
            if(rs==null)return lista;
            while(rs.next()){
                lista.add(new Country(rs.getInt("country_id"), rs.getString("country")));
            }
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(CountryDAO.class.getName()).log(Level.SEVERE, null, ex);
            return lista;
        } catch (Exception ex) {
            Logger.getLogger(Country.class.getName()).log(Level.SEVERE, null, ex);
            return lista;
        }
    }
}

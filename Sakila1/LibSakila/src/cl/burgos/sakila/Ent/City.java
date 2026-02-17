/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.burgos.sakila.Ent;

import cl.burgos.sakila.Exp.CityException;
import java.util.Date;

/**
 *
 * @author Duoc
 */
public class City {
    
    private int cityId;
    private String city;
    //private Country countryId;
    private int countryId;
    private Date lastUpdate;

    public int getCityId() {
        return cityId;
    }

    public String getCity() {
        return city;
    }

    public int getCountryId() {
        return countryId;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    private void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public void setCity(String city) throws CityException, Exception {
        if(city==null||city.trim().length()<0||city.trim().length()>100)
        {
            throw new CityException(CityException.ERR_NOMBRE);
        }
        this.city = city;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    private void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    //costructor para Guardar
    public City(String city,int countryId) throws Exception {
        setCity(city);
        setCountryId(countryId);
    }

    //costructor para Actualizar
    public City(int cityId, String city, int countryId) throws Exception {    
        setCityId(cityId);
        setCity(city);
        setCountryId(countryId);
    }
    //constructor para Eliminar

    public City(int cityId) {
        this.cityId = cityId;
    }
    
    @Override
    public String toString() {
        return "City{" + "cityId=" + cityId + ", city=" + city + ", countryId=" + countryId + ", lastUpdate=" + lastUpdate + '}';
    }
    
    public void imprimir()
    {
        System.out.println(this.toString());
    }
}

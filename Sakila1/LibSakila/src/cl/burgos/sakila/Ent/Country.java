/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.burgos.sakila.Ent;

import java.util.Date;

/**
 *
 * @author Duoc
 */
public class Country {
    private int countryId;
    private String country;
    private Date lastUpdate;

    public int getCountryId() {
        return countryId;
    }

    private void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) throws Exception
    {if (country==null||country.length()<1||country.length()>45)
    {
        throw new Exception("Error,country 1..45"); 
    }

        this.country = country;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    private void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
    

    //costructor para Guardar
    public Country(String country) {
        this.country = country;
    }

    //costructor para Actualizar
    public Country(int countryId, String country) {
        this.countryId = countryId;
        this.country = country;
    }

    //constructor para Eliminar
    public Country(int countryId) {
        this.countryId = countryId;
    }

    @Override
    public String toString() {
        return "Country{" + "countryId=" + getCountryId() + ", country=" + getCountry() + ", lastUpdate=" + getLastUpdate() + '}';
    }
   public void imprimir()
   {
       System.out.println(this.toString());
   }
}

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
public class Language {
    private int languageId;
    private String name;
    private Date LastUpdate;

    public int getLanguageId() {
        return languageId;
    }

    private void setLanguageId(int languageId) {
        this.languageId = languageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws Exception 
    {if (name==null||name.length()<1||name.length()>20)
    {
        throw new Exception("Error,name 1..20"); 
    }
        this.name = name;
    }

    public Date getLastUpdate() {
        return LastUpdate;
    }

    private void setLastUpdate(Date LastUpdate) {
        this.LastUpdate = LastUpdate;
    }

    //costructor para Guardar
    public Language(String name) throws Exception {
        setName(name);
    }

    //costructor para Actualizar
    public Language(int languageId, String name) throws Exception {
        setLanguageId(languageId);
        setName(name);
    }

    //constructor para Eliminar
    public Language(int languageId) {
        setLanguageId(languageId);
    }

    @Override
    public String toString() {
        return "language{" + "languageId=" + getLanguageId() + ", name=" + getName() + ", LastUpdate=" + getLastUpdate() + '}';
    }
    public void imprimir()
    {
        System.out.println(this.toString());
    }
}

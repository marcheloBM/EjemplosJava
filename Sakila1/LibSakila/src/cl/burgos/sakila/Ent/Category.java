/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.burgos.sakila.Ent;

import cl.burgos.sakila.Exp.CategoryException;
import java.util.Date;

/**
 *
 * @author Duoc
 */
public class Category {
    private int categoryId;
    private String name;
    private Date lastUpdate;

    public int getCategoryId() {
        return categoryId;
    }

    private void setCategoryId(int categoryId)
    {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws Exception 
    {if (name==null||name.length()<1||name.length()>25)
    {
        //throw new Exception("Error,name 1..25");
        throw new CategoryException(CategoryException.ERR_NOMBRE);
    }
        this.name = name;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    private void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
    
    //costructor para Guardar
    public Category(String name) throws Exception {
        setName(name);
    }
    
    //costructor para Actualizar
    public Category(int categoryId, String name) throws Exception {
        setCategoryId(categoryId);
        setName(name);
    }

    //constructor para Eliminar
    public Category(int categoryId) {
        setCategoryId(categoryId);
    }

    @Override
    public String toString() {
        return "Category{" + "categoryId=" + getCategoryId() + ", name=" + getName() + ", lastUpdate=" + getLastUpdate() + '}';
    }
    public void imprimir()
    {
        System.out.println(this.toString());
    }
}

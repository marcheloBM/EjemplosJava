/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.burgos.sakila.Ent;

import java.util.Date;

/**
 *
 * @author Marchelo
 */
public class FilmCategory {
    private Film filmId;
    //private int filmId;
    private Category categoryId;
    //private int categoryId;
    private Date lastUpdate;

    public Film getFilmId() {
        return filmId;
    }

    private void setFilmId(Film filmId) {
        this.filmId = filmId;
    }

    public Category getCategoryId() {
        return categoryId;
    }

    private void setCategoryId(Category categoryId) {
        this.categoryId = categoryId;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    private void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
    
//costructor para Guardar
    public FilmCategory(Category categoryId, Date lastUpdate) {
        setCategoryId(categoryId);
        setLastUpdate(lastUpdate);
    }
    
//costructor para Actualizar
    public FilmCategory(Film filmId, Category categoryId) {
        setFilmId(filmId);
        setCategoryId(categoryId);
    }
    
//constructor para Eliminar
    public FilmCategory(Film filmId) {
        setFilmId(filmId);
    }

    @Override
    public String toString() {
        return "FilmCategory{" + "filmId=" + filmId + ", categoryId=" + categoryId + ", lastUpdate=" + lastUpdate + '}';
    }

    public void imprimir()
    {
        System.out.println(this.toString());
    }
    
}

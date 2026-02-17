/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.burgos.sakila.Ent;

import cl.burgos.sakila.Exp.FilmTextException;

/**
 *
 * @author Duoc
 */
public class FilmText {
    private int filmId;
    private String title;
    private String description;

    public int getFilmId() {
        return filmId;
    }

    private void setFilmId(int filmId) throws Exception {
        if(filmId<1||filmId>99999)
        {
            throw new FilmTextException(FilmTextException.E_FILMID);
        } 
        this.filmId = filmId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) throws Exception {
    if (title==null||title.length()<1||title.length()>255)
    {
        //throw new Exception("Error,title 1..255");
        throw new FilmTextException(FilmTextException.E_TITLE);
    }
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) throws Exception {
        if(description==null||title.length()<1||title.length()>255)
        {
            //throw new Exception("country 1..255");
            throw new FilmTextException(FilmTextException.E_DESCRIPTION);
        }
        this.description = description;
    }

    //costructor para Guardar
    public FilmText( String title,String description) throws Exception {
        setTitle(title);
        setDescription(description);
    }

    //costructor para Actualizar
    public FilmText(int filmId, String title, String description) throws Exception {
        setFilmId(filmId);
        setTitle(title);
        setDescription(description);
    }

    
    //constructor para Eliminar
    public FilmText(int filmId) throws Exception {
        setFilmId(filmId);
    }

    @Override
    public String toString() {
        return "filmText{" + "filmId=" + getFilmId() + ", title=" + getTitle() + ", description=" + getDescription() + '}';
    }

  
    public void imprimir()
    {
        System.out.println(this.toString());
    }
}

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
public class FilmActor {
    //private Actor actorId;
    private int actorId;
    //private Film filmId;
    private int filmId;
    private Date lastUpdate;

    public int getActorId() {
        return actorId;
    }

    private void setActorId(int actorId) {
        this.actorId = actorId;
    }

    public int getFilmId() {
        return filmId;
    }

    private void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    private void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
    
//costructor para Guardar
    public FilmActor( int filmId, Date lastUpdate) {
        setFilmId(filmId);
        setLastUpdate(lastUpdate);
    }
    
//costructor para Actualizar
    public FilmActor(int actorId, int filmId) {
        setActorId(actorId);
        setFilmId(filmId);
    }
    
//constructor para Eliminar
    public FilmActor(int actorId) {
        setActorId(actorId);
        
    }

    @Override
    public String toString() {
        return "FilmActor{" + "actorId=" + actorId + ", filmId=" + filmId + ", lastUpdate=" + lastUpdate + '}';
    }
    
    public void imprimir()
    {
        System.out.println(this.toString());
    }
    
}

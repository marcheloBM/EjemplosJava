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
public class Inventory {
    private int inventoryId;
    //private Film filmId;
    private int filmId;
    //private Store storeId;
    private int storeId;
    private Date lastUpdate;

    public int getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(int inventoryId) {
        this.inventoryId = inventoryId;
    }

    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    private void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
//costructor para Guardar
    public Inventory(int filmId, int storeId) {
        setFilmId(filmId);
        setStoreId(storeId);
    }
//costructor para Actualizar
    public Inventory(int inventoryId, int filmId, int storeId) {
        setInventoryId(inventoryId);
        setFilmId(filmId);
        setStoreId(storeId);
    }
//constructor para Eliminar
    public Inventory(int inventoryId) {
        setInventoryId(inventoryId);
        
    }

    @Override
    public String toString() {
        return "Inventory{" + "inventoryId=" + inventoryId + ", filmId=" + filmId + ", storeId=" + storeId + ", lastUpdate=" + lastUpdate + '}';
    }
    
    public void imprimir()
    {
        System.out.println(this.toString());
    }
}

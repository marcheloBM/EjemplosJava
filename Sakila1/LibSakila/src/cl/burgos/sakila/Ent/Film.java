/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.burgos.sakila.Ent;

import cl.burgos.sakila.Exp.FilmException;
import java.util.Date;

/**
 *
 * @author Marchelo
 */
public class Film {
    private int filmId;
    private String title;
    private String description;
    private Date releaseYear;
    //private Language lenguageId;
    private int lenguageId;
    //private Language originalLenguageID;
    private int originalLenguageID;
    private int rentalDuration;
    private double rentaRate;
    private int length;
    private double replacementCost;
    //private Enum rating;
    private String rating;
    //private Enum specialFeatures;
    private String specialFeatures;
    private Date lastUpdate;

    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) throws Exception {
        if(title==null||title.length()<5||title.length()>50)
        {
            throw new FilmException(FilmException.E_TITLE);
        }
        else
        {
            this.title = title;
        }
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Date releaseYear) {
        this.releaseYear = releaseYear;
    }

    public int getLenguageId() {
        return lenguageId;
    }

    public void setLenguageId(int lenguageId) {
        this.lenguageId = lenguageId;
    }

    public int getOriginalLenguageID() {
        return originalLenguageID;
    }

    public void setOriginalLenguageID(int originalLenguageID) {
        this.originalLenguageID = originalLenguageID;
    }

    public int getRentalDuration() {
        return rentalDuration;
    }

    public void setRentalDuration(int rentalDuration) throws Exception {
        if(rentalDuration>1||rentalDuration<30)
        {
            throw new FilmException(FilmException.E_RENTAL_DURATION);
        }
        else
        {
            this.rentalDuration = rentalDuration;
        }
    }

    public double getRentaRate() {
        return rentaRate;
    }

    public void setRentaRate(double rentaRate) throws Exception {
        if(rentaRate>0||rentaRate<100)
        {
            throw new FilmException(FilmException.E_RENTAL_RATE);
        }
        else
        {
            this.rentaRate = rentaRate;
        }
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public double getReplacementCost() {
        return replacementCost;
    }

    public void setReplacementCost(double replacementCost) {
        this.replacementCost = replacementCost;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getRating() {
        return rating;
    }
//hay q ver si se puede colocar enum('G','PG','PG-13','R','NC-17')
    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getSpecialFeatures() {
        return specialFeatures;
    }
//hay q ver si se puede colocar set('Trailers','Commentaries','Deleted Scenes','Behind the Scenes')
    public void setSpecialFeatures(String specialFeatures) {
        this.specialFeatures = specialFeatures;
    }
    
    //costructor para Guardar
    public Film(String title, String description, Date releaseYear, int lenguageId, int originalLenguageID, int rentalDuration, double rentaRate, int length, double replacementCost,String rating, String specialFeatures) throws Exception {
        setTitle(title);
        setDescription(description);
        setReleaseYear(releaseYear);
        setLenguageId(lenguageId);
        setOriginalLenguageID(originalLenguageID);
        setRentalDuration(rentalDuration);
        setRentaRate(rentaRate);
        setLength(length);
        setReplacementCost(replacementCost);
        setRating(rating);
        setSpecialFeatures(specialFeatures);
    }
    //costructor para Actualizar
    public Film(int filmId, String title, String description, Date releaseYear, int lenguageId, int originalLenguageID, int rentalDuration, double rentaRate, int length, double replacementCost,String rating, String specialFeatures) throws Exception {
        setFilmId(filmId);
        setTitle(title);
        setDescription(description);
        setReleaseYear(releaseYear);
        setLenguageId(lenguageId);
        setOriginalLenguageID(originalLenguageID);
        setRentalDuration(rentalDuration);
        setRentaRate(rentaRate);
        setLength(length);
        setReplacementCost(replacementCost);
        setRating(rating);
        setSpecialFeatures(specialFeatures);
    }
    //constructor para Eliminar

    public Film(int filmId) {
        setFilmId(filmId);
    }

    @Override
    public String toString() {
        return "Film{" + "filmId=" + filmId + ", title=" + title + ", description=" + description + ", releaseYear=" + releaseYear + ", lenguageId=" + lenguageId + ", originalLenguageID=" + originalLenguageID + ", rentalDuration=" + rentalDuration + ", rentaRate=" + rentaRate + ", length=" + length + ", replacementCost=" + replacementCost + ", rating=" + rating + ", specialFeatures=" + specialFeatures + ", lastUpdate=" + lastUpdate + '}';
    }
    
    public void imprimir()
    {
        System.out.println(this.toString());
    }

    

    
}

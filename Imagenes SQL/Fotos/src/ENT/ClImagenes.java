/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ENT;

import java.awt.Image;

/**
 *
 * @author Marchelo
 */
public class ClImagenes {
    private int id;
    private String nombre;
    private Image imagen;
    
    private byte[] imagen2;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Image getImagen() {
        return imagen;
    }

    public void setImagen(Image imagen) {
        this.imagen = imagen;
    }

    public byte[] getImagen2() {
        return imagen2;
    }

    public void setImagen2(byte[] imagen2) {
        this.imagen2 = imagen2;
    }

    public ClImagenes() {
    }

    
    
    public ClImagenes(String nombre, byte[] imagen2) {
        this.nombre = nombre;
        this.imagen2 = imagen2;
    }

    
    
}

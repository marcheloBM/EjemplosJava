package VO;

public class ProductoVO {

/*Todo los atributos*/
    int idproducto;
    String nombre;
    double precio;
    String marca;
    private byte[] foto;

public ProductoVO(){}

/*Todo los codigos get*/
    public int getIdproducto(){
        return idproducto;
    }
    public String getNombre(){
        return nombre;
    }
    public double getPrecio(){
        return precio;
    }
    public String getMarca(){
        return marca;
    }


/*Todo los codigos set*/
    public void setIdproducto(int idproducto){
        this.idproducto = idproducto;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setPrecio(double precio){
        this.precio = precio;
    }
    public void setMarca(String marca){
        this.marca = marca;
    }

    /**
     * @return the foto
     */
    public byte[] getFoto() {
        return foto;
    }

    /**
     * @param foto the foto to set
     */
    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

}

package model;

import java.io.FileInputStream;

/**
 *
 * @author El APRENDIZ www.elaprendiz.net63.net
 */
public class Cliente {
    
    /**
     * Consutla sql que seleccionado todos los campos de la tabla
     */
    public static String SELECT_ALL = "SELECT * FROM tbl_cliente";
    
    /**
     *  Consutla sql que seleccionado todos los campos de la tabla excepto el campo foto
     */
    public static String SELECT_ALL_NO_FOTO = "SELECT idCliente, nombre, apellidos, email, estadoCuenta FROM tbl_cliente";
    
    public static String UPDATE_CON_FOTO = "UPDATE tbl_cliente SET "+
	"nombre = ? ,"+
	"apellidos = ?, "+
	"email = ?, "+
	"estadoCuenta = ?, "+
	"foto = ? WHERE idCliente = ?";
    
     public static String UPDATE_SIN_FOTO = "UPDATE  tbl_cliente SET "+
	"nombre = ? , "+
	"apellidos = ? , "+
	"email = ? , "+
	"estadoCuenta = ?  WHERE idCliente = ?";
     
     public static String INSERT_CON_FOTO = "INSERT INTO tbl_cliente"
             + "(nombre, apellidos, email, estadoCuenta, foto) VALUES(?, ?, ?, ?, ?)";
    
     public static String INSERT_SIN_FOTO = "INSERT INTO tbl_cliente"
             + "(nombre, apellidos, email, estadoCuenta) VALUES(?, ?, ?, ?)";
     
     public static String DELETE = "DELETE FROM tbl_cliente where idCliente = ?";
     
    private Integer primaryKey;
    private String nombre;
    private String apelldos;
    private String email;
    private String estadoCuenta;
    private FileInputStream foto;

    public Cliente(Integer primaryKey, String nombre, String apelldos, String email, String estadoCuenta, FileInputStream foto) {
        this.primaryKey = primaryKey;
        this.nombre = nombre;
        this.apelldos = apelldos;
        this.email = email;
        this.estadoCuenta = estadoCuenta;
        this.foto = foto;
    }
    
      public Cliente(String nombre, String apelldos, String email, String estadoCuenta, FileInputStream foto) {
        this.nombre = nombre;
        this.apelldos = apelldos;
        this.email = email;
        this.estadoCuenta = estadoCuenta;
        this.foto = foto;
    }

    public Cliente() {
    }
    
      

    public Integer getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(Integer primaryKey) {
        this.primaryKey = primaryKey;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApelldos() {
        return apelldos;
    }

    public void setApelldos(String apelldos) {
        this.apelldos = apelldos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEstadoCuenta() {
        return estadoCuenta;
    }

    public void setEstadoCuenta(String estadoCuenta) {
        this.estadoCuenta = estadoCuenta;
    }

    public FileInputStream getFoto() {
        return foto;
    }

    public void setFoto(FileInputStream foto) {
        this.foto = foto;
    }

    @Override
    public String toString() {
        return nombre + apelldos;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + (this.primaryKey != null ? this.primaryKey.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        if (this.primaryKey != other.primaryKey && (this.primaryKey == null || !this.primaryKey.equals(other.primaryKey))) {
            return false;
        }
        return true;
    }
    
}

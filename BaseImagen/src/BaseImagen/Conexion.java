
package BaseImagen;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.h2.tools.RunScript;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;


public class Conexion {
    
    public Connection conectar(){
        Connection con = null;
        String url = "jdbc:h2:./BaseDatos/imagenes";
        try{
            Class.forName("org.h2.Driver");
            con = DriverManager.getConnection(url, "SA","");
            System.out.println("En linea");
        }catch(Exception ex){
            System.out.println("Error: "+ex.getMessage());
        }
        return con;
    }
    
    public ResultSet visualizar(){
        Connection con = conectar();
        ResultSet rs = null;
        try{
            PreparedStatement ps = con.prepareStatement("select * from usuario");
            rs = ps.executeQuery();
        }catch(Exception ex){
            System.out.println("Error de consulta");
        }
        return rs;
    }
    
    public void guardar(String ruta, String nombre){
        Connection con = conectar();
        String insert = "insert into usuario(nombre,foto) values(?,?)";
        FileInputStream fi = null;
        PreparedStatement ps = null;
        try{
            File file = new File(ruta);
            fi = new FileInputStream(file);
            
            ps = con.prepareStatement(insert);
            ps.setString(1, nombre);
            ps.setBinaryStream(2, fi);
            
            ps.executeUpdate();
        }catch(Exception ex){
            System.out.println("Error al agregar usuario "+ex.getMessage());
        }
    }
    
    

public void inicializarBase() {
    try (Connection con = conectar()) {
        RunScript.execute(con, new FileReader("src/BaseImagen/newSQLTemplate.sql", StandardCharsets.UTF_8));
        System.out.println("Script SQL ejecutado correctamente.");
    } catch (Exception e) {
        System.out.println("Error al ejecutar el script SQL: " + e.getMessage());
    }
}
}

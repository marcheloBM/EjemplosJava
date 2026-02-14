/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;
import ENT.ClImagenes;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;


/**
 *
 * @author jonathan
 */
public class BaseDatos {
    Connection conexion;
    Statement st;
    
    public BaseDatos(String host,String user, String pass){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://"+host+"/fotos", user, pass); 
            st = conexion.createStatement();
        } catch (Exception ex) {
            Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    
    public boolean guardarImagen(String ruta,String nombre){
        String insert = "insert into imagenes(nombre,imagen) values(?,?)";
        FileInputStream fis = null;
        PreparedStatement ps = null;
        try {
            conexion.setAutoCommit(false);
            File file = new File(ruta);
            fis = new FileInputStream(file);
            ps = conexion.prepareStatement(insert);
            ps.setString(1, nombre);
            ps.setBinaryStream(2,fis,(int)file.length());
            ps.executeUpdate();
            conexion.commit();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                ps.close();
                fis.close();
            } catch (Exception ex) {
                Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }        
        return false;
    }
    
    ArrayList<ClImagenes> getImagenes() {
        ArrayList<ClImagenes> lista = new ArrayList();
        try {
            ResultSet rs = st.executeQuery("SELECT imagen,nombre FROM Imagenes"); 
            while (rs.next())
            {
                ClImagenes imagen=new ClImagenes();
                Blob blob = rs.getBlob("imagen");
//                String nombre = rs.getObject("nombre").toString();
                byte[] data = blob.getBytes(1, (int)blob.length());
                BufferedImage img = null;
                try {
                    img = ImageIO.read(new ByteArrayInputStream(data));
                } catch (IOException ex) {
                    Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                imagen.setImagen(img);
//                imagen.setNombre(nombre);
                lista.add(imagen);
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }    
}

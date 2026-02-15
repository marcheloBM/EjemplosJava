package coneccion;
import clases.CustomImageIcon;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import model.Cliente;

/**
 *
 * @author El APRENDIZ www.elaprendiz.net63.net
 */
public class ConexionBase {
    
    private static Connection cn = null;
    private static Statement st = null;
    private static PreparedStatement ps = null;    
    private static ResultSet rs = null;
    
    private static String servidor = "localhost";
    private static String nombreBD = "tuto";
    private static String usuario = "root";
    private static String clave = "";

    public static String getNombreBD() {
        return nombreBD;
    }

    public static void setNombreBD(String nombreBD) {
        ConexionBase.nombreBD = nombreBD;
    }

    public static String getUsuario() {
        return usuario;
    }

    public static void setUsuario(String usuario) {
        ConexionBase.usuario = usuario;
    }

    public static String getClave() {
        return clave;
    }

    public static void setClave(String clave) {
        ConexionBase.clave = clave;
    }
    
    
    
    public static boolean conectar()
    {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            //String url = "jdbc:mysql://localhost:3306/tuto";
            String url = "jdbc:mysql://"+servidor+":3306/"+nombreBD;
            cn = DriverManager.getConnection(url, usuario, clave);
            
        }catch(ClassNotFoundException ex){ex.printStackTrace();}        
        catch(SQLException ex){
            String msg = "";
            if(ex.getErrorCode() == 1049)
            {
                msg = "La base de datos: "+nombreBD+" no existe.";
            }else if(ex.getErrorCode() == 1044)
            {
                msg = "El usuario: "+usuario+" no existe.";
            }else if(ex.getErrorCode() == 1045)
            {
                msg = "Contraseña incorrecta.";
            }else if(ex.getErrorCode() == 0)
            {
                msg = "La coneccion con la base de datos no se puede realizar.\nParece que el servidor de base de datos no esta activo.";
            }
            JOptionPane.showMessageDialog(null, msg, ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        
        if(cn != null)
        {
             System.out.println("Coneccion Exitosa.... XD");
             return true;
        }
        return false;
           
    }
    
   public static ArrayList<Cliente> getClientes(String consulta)
    {
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        Cliente cl = null;
        if(cn == null)
            conectar();
        try{
            st = cn.createStatement();
            rs = st.executeQuery(consulta);            
            while(rs.next())
            {
                cl = new Cliente();
                cl.setPrimaryKey(rs.getInt(1));
                cl.setNombre(rs.getString(2));
                cl.setApelldos(rs.getString(3));
                cl.setEmail(rs.getString(4));
                cl.setEstadoCuenta(rs.getString(5));
                clientes.add(cl);
            }
            st.close();
            rs.close();
        }catch(SQLException ex){}
        
        return clientes;
    }
   
   public static int grabarCliente(Cliente cl)
    {
        int rsu = 0;
        String sql = Cliente.INSERT_CON_FOTO;
        if(cl.getFoto() == null)
        {
            sql = Cliente.INSERT_SIN_FOTO;
        }
        if(cn == null)
            conectar();
        try{
            ps = cn.prepareStatement(sql);
            ps.setString(1, cl.getNombre());
            ps.setString(2, cl.getApelldos());
            ps.setString(3, cl.getEmail());
            ps.setString(4, cl.getEstadoCuenta());
            if(cl.getFoto() != null)
            {
                ps.setBinaryStream(5, cl.getFoto());
            }
            rsu=ps.executeUpdate();
        }catch(SQLException ex){ex.printStackTrace();} 
        System.out.println(sql);
        return rsu;
        
    }
   
   public static int actualizarCliente(Cliente cl)
    {
        int rsu = 0;
        String sql = Cliente.UPDATE_CON_FOTO;
        if(cl.getFoto() == null)
        {            
            sql = Cliente.UPDATE_SIN_FOTO;
        }
        if(cn == null)
            conectar();
        try{
            ps = cn.prepareStatement(sql);
            ps.setString(1, cl.getNombre());
            ps.setString(2, cl.getApelldos());
            ps.setString(3, cl.getEmail());
            ps.setString(4, cl.getEstadoCuenta());
            if(cl.getFoto() != null)
            {
                ps.setBinaryStream(5, cl.getFoto());
                ps.setInt(6, cl.getPrimaryKey());
            }else{
                ps.setInt(5, cl.getPrimaryKey());
            }
            rsu=ps.executeUpdate();
        }catch(SQLException ex){ex.printStackTrace();} 
        System.out.println(sql);
        return rsu;
        
    }
   
   public static int eliminarCliente(Integer pk)
    {
        int rsu = 0;
        String sql = Cliente.DELETE;
      
        if(cn == null)
            conectar();
        try{
            ps = cn.prepareStatement(sql);
            ps.setInt(1, pk);  
            rsu=ps.executeUpdate();
        }catch(SQLException ex){ex.printStackTrace();} 
        System.out.println(sql);
        return rsu;
        
    }
   
     public static CustomImageIcon getFoto(int id)
    {
        String sql = "select foto from tbl_cliente where idCliente = "+id;
        CustomImageIcon ii = null;
        InputStream is = null;
         if(cn == null)
            conectar();
       try{
           
           st = cn.createStatement();
           rs = st.executeQuery(sql); 
           if(rs.next()){
               is = rs.getBinaryStream(1);
               if(is != null)
               {
                   
                   BufferedImage bi = ImageIO.read(is);
                   ii = new CustomImageIcon(bi);
               }
               
           }
           
           
       }catch(SQLException ex){ex.printStackTrace();}
       catch(IOException ex){ex.printStackTrace();}
        
        return ii;
    }

     public static boolean existeEmail(String email)
    {        
        String sql = "select email from tbl_cliente where email like ? ";  
        boolean emailEncontrado = false;
        if(cn == null)
            conectar();
        try{
            ps = cn.prepareStatement(sql);
            ps.setString(1, email);            
            rs = ps.executeQuery();
            if(rs.next())
            {
               emailEncontrado = true; 
            }
        }catch(SQLException ex){ex.printStackTrace();} 
        System.out.println(sql);
        return emailEncontrado;
        
    }
     
     
}

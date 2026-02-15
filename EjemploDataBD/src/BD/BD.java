/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

//import static Inter.Confi.*;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
//import org.apache.log4j.Logger;
//import org.apache.log4j.PropertyConfigurator;

/**
 *
 * @author Marchelo
 */
public class BD {
    public static  enum typeData {swBd,swArreglo,swLista,swHashTable};
    public static typeData swData = typeData.swBd;
    public static BD bd;
    private Statement stmt;
    private static Connection cnn;
    
    private static String myDriver = "com.mysql.jdbc.Driver";
//    private static String myDriver = "oracle.jdbc.OracleDriver";
//    private static String myDriver = "net.ucanaccess.jdbc.UcanaccessDriver";
//    private static String myDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    
    private static String ip="localhost";
    private static String puerto="3306";
    private static String BaseDatos="fotos";
    private static String userBD="root";
    private static String passBD="";
    
    //En el mismo Sistema
    private static String myUrl = "jdbc:mysql://"+ip+":"+puerto+"/"+BaseDatos;String user=userBD;String clave=passBD;
    //En access
//    private static String myUrl = "jdbc:ucanaccess://./Juegos.accdb;jackcessOpener=Cl.Burgos.Juegos.BD.CryptCodecOpener";String user="sa";String clave="HP2117la";
    //Para SqlServer
//    private static String myUrl = "jdbc:sqlserver://localhost:1433;databaseName=contactos";String user="marchelo";String clave="hp2117la";
    //Para Oracle
//    private static String myUrl = "jdbc:oracle:thin:@localhost:1521:XE";String user="HALCONE";String clave="123";
    
    //Variables del Log4j
//    static  Logger log =Logger.getLogger(BD.class);
    
    public static String getMyDriver() {
        return myDriver;
    }

    public static void setMyDriver(String myDriver) {
        BD.myDriver = myDriver;
    }
  
    public static String getIp() {
        return ip;
    }

    public static void setIp(String ip) {
        BD.ip = ip;
    }

    public static String getPuerto() {
        return puerto;
    }

    public static void setPuerto(String puerto) {
        BD.puerto = puerto;
    }
    
    public static String getBaseDatos() {
        return BaseDatos;
    }

    public static void setBaseDatos(String BaseDatos) {
        BD.BaseDatos = BaseDatos;
    }

    public static String getUserBD() {
        return userBD;
    }

    public static void setUserBD(String userBD) {
        BD.userBD = userBD;
    }

    public static String getPassBD() {
        return passBD;
    }

    public static void setPassBD(String passBD) {
        BD.passBD = passBD;
    }
    
        
    private BD(){
        try {
            Class.forName(myDriver);
            cnn = DriverManager.getConnection(myUrl, user, clave);
            stmt=cnn.createStatement();
        } catch (ClassNotFoundException ex) {
//            Log.log("Class Not Found " + ex.getMessage());
//            log.info("Clase no Encontrada "+ex.getMessage());
            new Exception("Class Not Found" + ex.getMessage());
            JOptionPane.showMessageDialog(null, "ERROR DE CONEXIÓN"+ex);
        } catch (SQLException ex) {
            String msg = "";
            if(ex.getErrorCode() == 1049){
                msg = "La base de datos: "+BaseDatos+" no existe.";
            }else if(ex.getErrorCode() == 1044){
                msg = "El usuario: "+userBD+" no existe.";
            }else if(ex.getErrorCode() == 1045){
                msg = "Contraseña incorrecta.";
            }else if(ex.getErrorCode() == 0){
                msg = "La coneccion con la base de datos no se puede realizar.\nParece que el servidor de base de datos no esta activo.";
            }
            JOptionPane.showMessageDialog(null, msg, ex.getMessage(), JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static BD getInstance(){ 
        if (bd==null) bd=new BD();return bd;
    }
    
    public boolean sqlEjecutar(String sql) throws SQLException{
        int rs=0;
        try {
            rs = stmt.executeUpdate(sql);
            boolean resp=(rs>0)?true:false;
            return resp;
        } catch (SQLException ex) {
//            Log.log("Sql Ejecutar " + ex.getMessage());
//            log.info("Sql Ejecutar "+ex.getMessage());
            new Exception("Sql Ejecutar " + ex.getMessage());
            return false;
        }
    }  
    
    public ResultSet sqlSelect(String sql){
        try {
            ResultSet rs= stmt.executeQuery(sql);
            return rs;
        } catch (SQLException ex) {
//            Log.log("Sql Select " + ex.getMessage());
//            log.info("Sql Select "+ex.getMessage());
            new Exception("Sql Select " + ex.getMessage());
        }
        return null;
    }
    
    public Connection conectar(){
        Connection con = null;
        try{
            Class.forName(myDriver);
            con = DriverManager.getConnection(myUrl, user, clave);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "ERROR DE CONEXIÓN"+ex);
        }
        return con;
    }
    
    public static boolean conectarBD(){
        try{
            Class.forName(myDriver);
            cnn = DriverManager.getConnection(myUrl, userBD, passBD);
        }catch(ClassNotFoundException ex){ex.printStackTrace();}
        catch(SQLException ex){
            String msg = "";
            if(ex.getErrorCode() == 1049){
                msg = "La base de datos: "+BaseDatos+" no existe.";
            }else if(ex.getErrorCode() == 1044){
                msg = "El usuario: "+userBD+" no existe.";
            }else if(ex.getErrorCode() == 1045){
                msg = "Contraseña incorrecta.";
            }else if(ex.getErrorCode() == 0){
                msg = "La coneccion con la base de datos no se puede realizar.\nParece que el servidor de base de datos no esta activo.";
            }
            JOptionPane.showMessageDialog(null, msg, ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if(cnn != null){
             System.out.println("Coneccion Exitosa.... XD");
             return true;
        }
        return false;  
    }
}

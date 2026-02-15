package Conectar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class conexion {
    
    
    
   static Connection con = null;
   static Statement sta = null;
   static ResultSet rst = null;
   
   static  String user = "root";
   static  String pass = "";
   static  String url = "jdbc:mysql://localhost/codigo_auto";
   
   public static Connection conexion()
   {
       
       try {
           Class.forName("com.mysql.jdbc.Driver");
           
           try {
               con = DriverManager.getConnection(url,user,pass);
               System.err.println("");
               
           } catch (SQLException ex) {
               JOptionPane.showMessageDialog(null, "No se pudo conectar a sql, se usara datepro en su lugar!!");
              // JOptionPane.showMessageDialog(null, "Error!! "+ex.getMessage());
               Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
           }
       } catch (ClassNotFoundException ex) {
           
           JOptionPane.showMessageDialog(null, "Error De Driver"+ex);
           Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
       }
    
       
       return con;
   }
   

}
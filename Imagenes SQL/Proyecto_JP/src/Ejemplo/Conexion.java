
package Ejemplo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {
    
   Connection Mi_Mundo = null;  
   
   public Connection Mundo_Programación(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
             String Url = "jdbc:sqlserver://localhost\\SQLEXPRESS:1433;DatabaseName=PERSONAS;user = sa;password=123";
             Mi_Mundo = DriverManager.getConnection(Url);
            JOptionPane.showMessageDialog(null, "Conexion");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error En : " + e);
        }
        return Mi_Mundo;
    }
    
}

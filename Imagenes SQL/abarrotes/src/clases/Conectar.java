
package Clases;

import java.sql.*;
import javax.swing.JOptionPane;


public class Conectar {
    Connection conectar=null;
    public Connection conexion()
    {
        try {
           Class.forName("com.mysql.jdbc.Driver");
           conectar=DriverManager.getConnection("jdbc:mysql://localhost/abarrotes","root","");
           
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return conectar;
    }
    
    
    
}



import java.sql.*;
import javax.swing.*;

/**
 *
 * @author Sony
 */

public class ConexionBD {

    Connection conect = null;

    public Connection conexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conect = DriverManager.getConnection("jdbc:mysql://localhost/biblioteca1", "root", ""); 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en la conexión" + e);
        }
        return conect;
    }   
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqlconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author marcelo
 */
public class SQLConnection {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // TODO code application logic here
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String connectionURL = "jdbc:sqlserver://localhost:1433;databaseName=contactos;user=marchelo;password=hp21";
        Connection con = DriverManager.getConnection(connectionURL);
        
        System.out.println("Coneccion a SQL server 2012");
        
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from contacto");
        while (rs.next()) {
            int ID = rs.getInt(1);
            String Name = rs.getString(2);
            System.out.println(ID + " "+Name);
            
        }
        
    }
    
}

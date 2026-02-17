/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.burgos.sakila.BD;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Duoc
 */
public class BD {

    private Connection cnn;
    private static BD bd;
    private Statement stmt;
//    String myDriver = "com.mysql.cj.jdbc.Driver";
    String myDriver = "org.gjt.mm.mysql.Driver";
    //En mi CASA
//    String myUrl="jdc:mysql://localhost/:3306/sakila";
    
    private BD()  {

        try {
            Class.forName(myDriver);
            // En el Duoc
            //cnn = DriverManager.getConnection(myUrl, "harrys", "macarena");
            // En mi Casa
            cnn= DriverManager.getConnection("jdbc:mysql://localhost/sakila", "root", "");
            stmt = cnn.createStatement();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static BD getInstance()  {
        if (bd == null) {
            bd = new BD();
        }
        return bd;
    }
    
    public boolean sqlEjecutar(String sql) {
        try {
            int rest =stmt.executeUpdate(sql);
            if (rest==0) return false ;
            return true;
        } catch (Exception ex) {
            Log.log("Error BD Ejecuta "+ex.getMessage());
            Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    //esta es una forma no es muy buena 
    public ResultSet sqlBuscar(String sql)
    {
        try {
            ResultSet rs=stmt.executeQuery(sql);
            return rs;
        } catch (SQLException ex) {
            Log.log("error en bd select "+ex.getMessage());
            Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}

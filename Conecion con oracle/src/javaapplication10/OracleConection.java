package javaapplication10;


import java.sql.Connection;
import java.sql.DriverManager;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author marcelo
 */
public class OracleConection {
    Connection conexion;
    public Connection getConexion() {
        return conexion;
    }

    
    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }
    public OracleConection Conectar()
    {
        try{
        Class.forName("oracle.jdbc.OracleDriver");
        String BaseDeDatos = "jdbc:oracle:thin:@localhost:1521:XE";
        conexion= DriverManager.getConnection(BaseDeDatos,"HR","hr");
        if(conexion!=null)
        {
        System.out.println("Conexion exitosa a esquema HR");
        }
        else{System.out.println("Conexion fallida");}
        }
        catch(Exception e)
        {e.printStackTrace();}
      
    return this;
    }

}

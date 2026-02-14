/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inter;

/**
 *
 * @author march
 */
public interface Confi {
    //Configuracion de BD localhot
    //Para mySQL
    String DriverBD="com.mysql.cj.jdbc.Driver";
    //Para Oracle
//    String DriverBD="oracle.jdbc.OracleDriver";
    // BD Local
    String ip="localhost";
    String puerto="3306";
    String BaseDatos="fotos";
    String userBD="root";
    String passBD="";
}
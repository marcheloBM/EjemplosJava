/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.burgos.sakila.Exp;

/**
 *
 * @author palto
 */
public class CityException extends Exception {
     public static final int ERR_NOMBRE=1;
    public static final int ERR_ID=2;
    
    public CityException(int error) throws Exception
           {
               switch(error)
               {
                   case ERR_NOMBRE:
                       throw  new Exception("Error nombre entre 0..50");
                   case ERR_ID:
                       throw  new Exception("Error id mayor que 0");
                   default:
                       throw new Exception("Error desconocido "+ error);
               }
            }
}

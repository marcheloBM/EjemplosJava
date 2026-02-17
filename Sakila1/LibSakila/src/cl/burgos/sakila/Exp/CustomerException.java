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
public class CustomerException extends Exception {
    public static final int E_FIRST_NAME=1;
    public static final int E_LAST_NAME=2;
    public static final int E_EMAIL=3;
    
    public CustomerException(int error) throws Exception
           {
               switch(error)
               {
                   case E_FIRST_NAME:
                       throw  new Exception("Error nombre entre 2..45");
                   case E_LAST_NAME:
                       throw  new Exception("Error apellido entre 2..45");
                   case E_EMAIL:
                       throw new Exception("Error email entre 5..50");
                   default:
                       throw new Exception("Error desconocido "+ error);
               }
            }
}

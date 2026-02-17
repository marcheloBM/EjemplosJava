/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.burgos.sakila.Exp;

/**
 *
 * @author Marchelo
 */
public class StaffException extends Exception{
    public static final int E_FIRST_NAME=1;
    public static final int E_LAST_NAME=2;
    public static final int E_EMAIL=3;
    public static final int E_USERNAME=4;
    public static final int E_PASSWORD=5;
    
    public StaffException(int error) throws Exception
    {
        switch(error)
        {
            case E_FIRST_NAME:
                throw new Exception("Error,first name entre 5..45");
            case E_LAST_NAME:
                throw new Exception("Error last name entre 5..45");
            case E_EMAIL:
                throw new Exception("Error email entre 5..50");
            case E_USERNAME:
                throw new Exception("Error username entre 5..16");
            case E_PASSWORD:
                throw new Exception("Error password entre 5..40");
            default:
                throw new Exception("Error Desconocido: "+ error);
            
        
        }
    }
}

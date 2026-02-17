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
public class FilmException extends Exception{
    public static final int E_TITLE=1;
    public static final int E_RENTAL_DURATION=2;
    public static final int E_RENTAL_RATE=3;
    
    public FilmException(int error) throws Exception
    {
        switch(error)
        {
            case E_TITLE:
                throw new Exception("Error el titilo entre 5..50");
            case E_RENTAL_DURATION:
                throw new Exception("Error duraccion entre 1..30");
            case E_RENTAL_RATE:
                throw new Exception("Error rental rate entre 0..100");
            default:
                throw new Exception("Error Desconocido: "+ error);
            
        
        }
    }
}

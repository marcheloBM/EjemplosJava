package cl.burgos.sakila.Exp;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Duoc
 */
public class ActorException extends Exception{
    
    public static final int E_FIRST_NAME=1;
    public static final int E_LAST_NAME=2;
    
    public ActorException(int error) throws Exception
    {
        switch(error)
        {
            case E_FIRST_NAME:
                throw new Exception("Error,first name 1..45");
                
            case E_LAST_NAME:
                throw new Exception("Error,last name 1..45");
                
            default:
                throw new Exception("Error Desconocido: "+ error);
            
        
        }
    }
    
    }
    


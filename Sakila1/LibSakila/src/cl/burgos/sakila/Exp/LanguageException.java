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
public class LanguageException {
    public static final int E_NAME=1;
    
    public LanguageException(int error) throws Exception
    {
        switch(error)
        {
            case E_NAME:
                throw new Exception("Error,first name 1..45");
                
            default:
                throw new Exception("Error Desconocido: "+ error);
            
        
        }
    }
}

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
public class AddressException extends Exception{
    public static final int E_ADDRESS=1;
    public static final int E_ADDRESS_2=2;
    public static final int E_DISTRICT=4;
    public static final int E_POSTAL_CODE=5;
    public static final int E_PHONE=6;
    
    public AddressException(int error) throws Exception
    {
        switch(error)
        {
            case E_ADDRESS:
                throw new Exception("dirección demasiado corta 1...45");
                
            case E_ADDRESS_2:
                throw new Exception("Dirección 2 demasiado corta 1...45");
                
            case E_DISTRICT:
                throw new Exception("Distrito demasiado corta 1...100");
                
            case E_POSTAL_CODE:
                throw new Exception("Codigo postal fuera de rango 5...7");
                
            case E_PHONE:
                throw new Exception("Telefono fuera de rango 1...12");
                    
            default:
                throw new Exception("Error Desconocido: "+ error);
            
        
        }
    }
}

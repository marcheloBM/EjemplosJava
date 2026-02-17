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
public class PaymentException extends Exception{
    
    public static final int E_AMOUNT=1;
    
    public PaymentException(int error) throws Exception
    {
        switch(error)
        {
            case E_AMOUNT:
                throw new Exception("Error,first name 00.00..99999.99");
            default:
                throw new Exception("Error Desconocido: "+ error);
            
        
        }
    }
}

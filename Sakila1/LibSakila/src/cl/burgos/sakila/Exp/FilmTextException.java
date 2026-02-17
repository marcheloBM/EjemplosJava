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
public class FilmTextException extends Exception{
    
    public static final int E_FILMID=1;
    public static final int E_TITLE=2;
    public static final int E_DESCRIPTION=3;
    
    public FilmTextException(int error) throws Exception
    {
        switch(error)
        {
            case E_FILMID:
                throw new Exception("Error,film Id 1..99999");
            case E_TITLE:
                throw new Exception("Error,title 1..255");
            case E_DESCRIPTION:
                throw new Exception("country 1..255");
            default:
                throw new Exception("Error Desconocido: "+ error);
        }
    }
}

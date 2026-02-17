/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.burgos.sakila.BD;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Duoc
 */
public class Log {
    
    public static void log(String msg){
    
        try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("..//myfile.log", true)))) 
        {
            out.println(msg+"\r\n");
//more code
            out.close();
        }
        catch (IOException e)
        {
//exception handling left as an exercise for the reader
        }
    }
    
}

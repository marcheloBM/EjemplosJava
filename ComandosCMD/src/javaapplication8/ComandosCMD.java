/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author marcelo
 */
public class ComandosCMD {
    
    public String cmd(String comando){
        String salida = null;
        String salida2 = null;
        try{
            // Ejecucion Basica del Comando
            Process proceso = Runtime.getRuntime().exec(comando);
 
            InputStreamReader entrada = new InputStreamReader(proceso.getInputStream());
            BufferedReader stdInput = new BufferedReader(entrada);
            //Si el comando tiene una salida la mostramos
            if((salida=stdInput.readLine()) != null){
                System.out.println("Comando ejecutado Correctamente");
                while ((salida=stdInput.readLine()) != null){
//                    System.out.println(salida.length());
                    if(salida.length()>1){
                        System.out.println(salida);
                        salida2=salida;
                    }
                }
                stdInput.close();
            }else{
                System.out.println("No se a producido ninguna salida");
            }
        }catch (IOException e) {
                System.out.println("Excepción: ");
                e.printStackTrace();
        }
        return salida2;
    }
}

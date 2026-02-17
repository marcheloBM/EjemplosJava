/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodofor;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author march
 */
public class MetodoFor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //declaramos nuestra lista utilizando la interfaz List e indicamos que contendra objetos del tipo String
        List<String> lista = new ArrayList<>();
        
        lista.add("rojo");
        lista.add("verde");
        lista.add("negro");
        lista.add("azul");
        
        System.out.print("------for each------\n");
        //for each : debemos indicar el dato que almacena la lista , en este caso String , luego debemos declarar una variable pivote (str) finalmente dos puntos (:) y la lista que vamos a recorrer
        for(String str : lista)
        {
            //imprimimos el objeto pivote
            System.out.println(str);
        }
        System.out.print("------for------\n");
        //for indicamos la variable indice en 0 para recorrer toda la lista, de inicio a fin al final de cada iteracion el indice se incrementa en uno
        for(int indice = 0;indice<lista.size();indice++)
        {
            System.out.println(lista.get(indice));
        }
        System.out.print("------foreach------\n");
        //utilizar el metodo foreach() de las colecciones de java , debemos llamar al metodo foreach de la instancia de coleccion y enviar un parametro del tipo Consumer
        lista.forEach(System.out::println);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package creararchivos;

import Cl.Burgos.ENT.Cuenta;
import Cl.Burgos.ENT.Persona;
import Cl.Burgos.FUN.CrearExcel;
import Cl.Burgos.FUN.CrearPDF;
import Cl.Burgos.FUN.CrearWorld;

/**
 *
 * @author march
 */
public class CrearArchivos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Persona p = new Persona("marchelo", "burgos", "90715586");
        Cuenta c = new Cuenta("2345678976543", "corriente", "123456");
        CrearWorld cw= new CrearWorld();
        cw.crear();
        CrearExcel ce=new CrearExcel();
        ce.Crear();
        CrearPDF cpdf = new CrearPDF();
        cpdf.Crear();
    }
}

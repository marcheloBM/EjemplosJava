package controller;

import coneccion.ConexionBase;
import java.util.ArrayList;
import model.Cliente;

/**
 *
 * @author El APRENDIZ www.elaprendiz.net63.net
 */
public class ControllerCliente {
    
     public ArrayList<Cliente> getClientes()
     {
         return ConexionBase.getClientes(Cliente.SELECT_ALL_NO_FOTO);
     }
     
     public int insertCliente(Cliente cl)
     {
        return ConexionBase.grabarCliente(cl);
     }
     
     public int actualzartCliente(Cliente cl)
     {
        return ConexionBase.actualizarCliente(cl);
     }
     
     public int eliminarCliente(Integer pk)
     {
        return ConexionBase.eliminarCliente(pk) ;
     }
     
}

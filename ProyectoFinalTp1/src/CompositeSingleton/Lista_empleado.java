package CompositeSingleton;

import Entidades.Empleado;
import java.util.ArrayList;

public class Lista_empleado extends Composite {
    
    private final String nombre_hospital = "Hospital Acatecuro";
    
    private static Lista_empleado unicaInstancia;
    
    private Lista_empleado()
    {
        empleados = new ArrayList();
    }
    
    public static Lista_empleado getUniqueInstance()
    {
        if(unicaInstancia == null)
            unicaInstancia = new Lista_empleado();
        return unicaInstancia;
    }
    
    public int cantidadEmpleados()
    {
        return empleados.size();
    }
    
        public int buscar_dni(String dni)
        {
        String cod;
        for(int i=0; i<empleados.size(); i++){
            cod = ((Empleado)empleados.get(i)).getDni();
            if(cod.compareToIgnoreCase(dni)==0){
                return i;
            }
        }
        return -1;
    }
    
    public int buscar_codigo(String codigo)
    {
        String cod;
        for(int i=0; i<empleados.size(); i++){
            cod = ((Empleado)empleados.get(i)).getCodigo();
            if(cod.compareToIgnoreCase(codigo)==0){
                return i;
            }
        }
        return -1;
    }
    
    @Override
    public String toString()
    {
        return nombre_hospital;
    }
}

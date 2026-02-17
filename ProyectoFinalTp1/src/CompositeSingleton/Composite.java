package CompositeSingleton;

import java.util.ArrayList;

public class Composite implements Salario {

    protected ArrayList<Salario> empleados;
//    Almacena objetos de clases que implementan dicha interfaz.
    
    @Override
    public double getSalarioNeto() {
        int SalarioGlobal = 0;
        for(int i=0; i<empleados.size(); ++i)
            SalarioGlobal += empleados.get(i).getSalarioNeto();
        return SalarioGlobal;
    }
    
    public void agregar(Salario empleado)
    {
        empleados.add(empleado);
    }
    
    public void remover(int pos)
    {
        empleados.remove(pos);
    }
    
}

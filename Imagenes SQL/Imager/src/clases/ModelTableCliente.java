package clases;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import model.Cliente;

/**
 *
 * @author El APRENDIZ www.elaprendiz.net63.net
 */
public class ModelTableCliente extends AbstractTableModel{
    
    private String[] nombreColumnas = {"Codigo","Nombre","Apellido","Email","Estado de Cuenta"};
    private ArrayList<Cliente> cls;

    public ModelTableCliente(ArrayList<Cliente> cls) {
        this.cls = cls;
    }

    public ModelTableCliente() {
    }

    public void setClientes(ArrayList<Cliente> cls) {
        this.cls = cls;
    }
    
    @Override
    public int getRowCount() {
        return cls.size();
    }

    @Override
    public int getColumnCount() {
        return nombreColumnas.length;
    }

    @Override
    public String getColumnName(int column) {
        return nombreColumnas[column];
    }

    public Cliente getFila(int index)
    {
        return cls.get(index);
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex)
        {
            case 0: return cls.get(rowIndex).getPrimaryKey();
            case 1: return cls.get(rowIndex).getNombre();    
            case 2: return cls.get(rowIndex).getApelldos();    
            case 3: return cls.get(rowIndex).getEmail();
            case 4: return cls.get(rowIndex).getEstadoCuenta();
            default: return null;    
                
        }
    }
    
}

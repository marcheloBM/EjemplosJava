
package negocio;

import dto.Cliente;
import java.util.List;
import model.dao.ClienteDao;
import model.dao.impl.ClienteDaoImpl;


public class ClienteNE {
    ClienteDao clienteDao;

    public ClienteNE() {
    clienteDao = new ClienteDaoImpl();
    }
    public List<Cliente> list(){
        return clienteDao.list();
    }
    public String insertarCliente(Cliente cliente){
        return clienteDao.insert(cliente);
    }
    public Integer idCliente(){
        return clienteDao.idCliente();
    }
    public Cliente get(Integer id){
        return clienteDao.get(id);
    }
    public String detele(Integer id){
        return clienteDao.delete(id);
    }
    public String update(Cliente cliente){
     return clienteDao.update(cliente);
    }
    
}

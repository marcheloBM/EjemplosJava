/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import dto.Cliente;
import java.util.List;


public interface ClienteDao {
    
    public List<Cliente> list();
    
    public String insert(Cliente cliente);
    
    public Integer idCliente();
    
    public Cliente get(Integer id);
    
    public String delete(Integer id);
    
    public String update(Cliente cliente);
}

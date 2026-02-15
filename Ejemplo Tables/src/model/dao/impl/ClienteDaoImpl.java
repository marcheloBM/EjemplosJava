/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao.impl;

import cone.sql.ConectaBD;
import dto.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.dao.ClienteDao;

/**
 *
 * @author sistemas
 */
public class ClienteDaoImpl implements ClienteDao{
public ConectaBD db;
    public ClienteDaoImpl() {
        db= new ConectaBD();
    }

    @Override
    public List<Cliente> list() {
    List<Cliente>     list = null;
    String sql = "select * from cliente";
        try {
            Connection cn = db.getConnection();
            PreparedStatement st = cn.prepareStatement(sql);
            
            ResultSet rs = st.executeQuery();
            list = new ArrayList<Cliente>();
            while (rs.next()) {                
                Cliente c = new Cliente();
                c.setIdcliente(rs.getInt(1));
                c.setNombre(rs.getString(2));
                c.setApellidos(rs.getString(3));
                c.setDni(rs.getString(4));
                c.setDireccion(rs.getString(5));
                list.add(c);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return  list;
    }

    @Override
    public String insert(Cliente cliente) {
       String result= null;
       String sql="Insert into cliente (idcliente, nombre, apellidos, dni, direccion)"
               + " values (?,?,?,?,?)";
        try {
            Connection cn= db.getConnection();
            PreparedStatement ps= cn.prepareStatement(sql);
            ps.setInt(1, cliente.getIdcliente());
            ps.setString(2, cliente.getNombre());
            ps.setString(3, cliente.getApellidos());
            ps.setString(4, cliente.getDni());
            ps.setString(5, cliente.getDireccion());
            ps.executeUpdate();            
            ps.close();cn.close();
            
        } catch (Exception e) {
            System.out.println("Error:  " + e.getMessage());
            result = e.getMessage();
        }
        return  result;
    }

    @Override
    public Integer idCliente() {
        Integer id = 0;
        String sql = "select max(idcliente) + 1 as codigo from cliente;";
        try {
            Connection cn= db.getConnection();
            PreparedStatement ps=cn.prepareStatement(sql);
            ResultSet rs= ps.executeQuery();
            if(rs.next()){
                id= rs.getInt(1);
            }
            ps.close();
            cn.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return  id;
    }

    @Override
    public Cliente get(Integer id) {
        Cliente cliente = null;
        String sql="select * from cliente where idcliente=?";
        try {
            Connection cn= db.getConnection();
            PreparedStatement ps= cn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs= ps.executeQuery();
            cliente= new Cliente();
            if(rs.next()){
                cliente.setIdcliente(rs.getInt(1));
                cliente.setNombre(rs.getString(2));
                cliente.setApellidos(rs.getString(3));
                cliente.setDni(rs.getString(4));
                cliente.setDireccion(rs.getString(5));
            }
            cn.close();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return  cliente;
    }

    @Override
    public String delete(Integer id) {
        String result= null;
        String sql= "delete from cliente where idcliente=?";
        try {
            Connection cn= db.getConnection();
            PreparedStatement ps= cn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            cn.close();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            result = e.getMessage();
        }
        return  result;
    }

    @Override
    public String update(Cliente cliente) {
        String result= null;
        String sql ="update cliente set nombre=?, apellidos =?,"
                + " dni=?, direccion=? "
                + " where idcliente =?";
        try {
            Connection cn = db.getConnection();
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getApellidos());
            ps.setString(3, cliente.getDni());
            ps.setString(4, cliente.getDireccion());
            ps.setInt(5, cliente.getIdcliente());
            ps.executeUpdate();
            cn.close();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return  result;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import BD.BD;
import BD.Conectar;
import ENT.ClImagenes;
import java.io.File;
import java.io.FileInputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marchelo
 */
public class DAOImagenes {
/*Metodo agregar*/
//    public void Agregar_ProductoVO(ClImagenes vo){
//        Conectar conec = new Conectar();
//        String sql = "insert into imagenes(nombre,imagen) values(?,?)";
//        PreparedStatement ps = null;
//        try{
//            ps = conec.getConnection().prepareStatement(sql);
//            ps.setString(1, vo.getNombre());
//            ps.setBytes(2, vo.getImagen2());
//            ps.executeUpdate();
//        }catch(SQLException ex){
//            System.out.println("A "+ex.getMessage());
//        }catch(Exception ex){
//            System.out.println("B "+ex.getMessage());
//        }finally{
//            try{
//                ps.close();
//                conec.desconectar();
//            }catch(Exception ex){}
//        }
//    }
      
    
    public boolean sqlInsert(ClImagenes clImagenes) {
        try {
            String stSql  = "insert into imagenes(nombre,imagen) values('"+clImagenes.getNombre()+"','"+clImagenes.getImagen()+"')";
            return BD.getInstance().sqlEjecutar(stSql);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
//            Logger.getLogger(DAOLogin.class.getName()).log(Level.SEVERE, null, ex);
//            Log.log(ex.getMessage());
            return false;
        }
    }
    
    public List<ClImagenes> leerClientes() {
        List<ClImagenes> lista=new ArrayList<>();
        String strConsulta;
        
        strConsulta="select nombre,imagen from imagenes;";
        
        try{
         ResultSet rs=BD.getInstance().sqlSelect(strConsulta);
         if(rs==null)return null;
         while(rs.next()){
             ClImagenes c = new ClImagenes(rs.getString("nombre"), 
                     rs.getBytes("imagen"));
              lista.add(c);
         }
         
        } catch (SQLException ex) {
//            Logger.getLogger(DAOLogin.class.getName()).log(Level.SEVERE, null, ex);
//            Log.log(ex.getMessage());
        } catch (Exception ex) {
//            Logger.getLogger(DAOLogin.class.getName()).log(Level.SEVERE, null, ex);
//            Log.log(ex.getMessage());
        }
        return lista;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.burgos.sakila.DAO;

import cl.burgos.sakila.BD.BD;
import cl.burgos.sakila.Ent.Actor;
import cl.burgos.sakila.BD.Log;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Duoc
 */
public class ActorDAO {

    public static boolean sqlAgregar(Actor actor) {
        //String sql = "insert into actor(first_name,last_name,last_update) values('"++actor.getFirstName()"','"++actor.getLastName()"','"++actor.getLastUpdate()"'")";
        String sql = String.format("insert into actor(first_name,last_name,last_update) values('%s','%s',now())",
                actor.getFirstName()
        ,actor.getLastName());
        BD.getInstance().sqlEjecutar(sql);
        return true;
    }

    public static boolean sqlEliminar(Actor actor) {
       String sql = String.format("delete from Actor where actor_id=%d",actor.getActorId());
        return BD.getInstance().sqlEjecutar(sql);
    }

    public static boolean sqlModificar(Actor actor) {
        String sql = String.format("update Actor set first_name='%s', last_name='%s' where actor_id=%d"
                ,actor.getFirstName()
                ,actor.getLastName()
                ,actor.getActorId()
              );
        return BD.getInstance().sqlEjecutar(sql);
    }

    public static boolean sqlBuscar(Actor actor) throws Exception {
        try {
            String sql = String.format("select first_name,last_name,last_update from Actor where actor_id=%d",actor.getActorId());
            ResultSet rs=BD.getInstance().sqlBuscar(sql);
            if(rs==null)return false;
            if(!rs.next())return false;
            actor.setFirstName(rs.getString("first_name"));
            actor.setLastName(rs.getString("last_name"));
            
            return true;
        } catch (SQLException ex) {
            Log.log("Buscar error"+ex.getMessage());
            Logger.getLogger(ActorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static void sqlAgregar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static ArrayList<Actor> sqlBuscar()
    {
        ArrayList<Actor> lista=new ArrayList<Actor>();
        try {
            String sql = String.format("select actor_id,first_name,last_name,last_update from Actor ");
            ResultSet rs=BD.getInstance().sqlBuscar(sql);
            if(rs==null)return lista;
            while(rs.next()){
                //esta forma no es la mejor
                //Actor a1=new Actor(rs.getInt("actor_id"), rs.getString("first_name"),rs.getString("last_name"));
                //esta es la mejor por que no declaro nada
                lista.add(new Actor(rs.getInt("actor_id"), rs.getString("first_name"),rs.getString("last_name")));
            
            }
            
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(ActorDAO.class.getName()).log(Level.SEVERE, null, ex);
            return lista;
        } catch (Exception ex) {
            Logger.getLogger(ActorDAO.class.getName()).log(Level.SEVERE, null, ex);
            return lista;
        }
    }
}

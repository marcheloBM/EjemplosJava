/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.burgos.sakila.Ent;


import cl.burgos.sakila.Exp.ActorException;
import java.util.Date;

/**
 *
 * @author Duoc
 */
public class Actor {
    private int actorId;
    private String firstName;
    private String lastName;
    private Date lastUpdate;

    public int getActorId() {
        return actorId;
    }

    private void setActorId(int actorId) {
        this.actorId = actorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) throws Exception
    {if (firstName==null||firstName.trim().length()<1||firstName.trim().length()>45)
    {
        //throw new Exception("Error,first name 1..45"); 
        throw new ActorException(ActorException.E_FIRST_NAME);
    }
        this.firstName = firstName.trim();
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) throws Exception 
    {if (lastName==null||lastName.length()<1||lastName.length()>45)
    {
        //throw new Exception("Error,last name 1..45");
        throw new ActorException(ActorException.E_LAST_NAME);
    }
        this.lastName = lastName;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    private void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
//costructor para Guardar
    public Actor(String firstName, String lastName) throws Exception {
        //this.firstName = firstName;
        //this.lastName = lastName;
        //ESTE ES EL MEJOR YA QUE NO HAY Q VALIDAR DE NUEVO
        setFirstName(firstName);
        setLastName(lastName);  
    }
    
//costructor para Actualizar
    public Actor(int actorId, String firstName, String lastName) throws Exception 
    {
        setActorId(actorId);
        setFirstName(firstName);
        setLastName(lastName);
    }    
    
//constructor para Eliminar
    public Actor(int actorId) {
        //this.actorId = actorId;
        setActorId(actorId);
    }

    @Override
    public String toString() {
        return "Actor{" + "actorId=" + getActorId() + ", firstName=" + getFirstName() + ", lastName=" + getLastName() + ", lastUpdate=" + getLastUpdate() + '}';
    }
    public void imprimir()
    {
        System.out.println(this.toString());
    }
    
    
}

<%-- 
    Document   : ActorMvc
    Created on : 24-08-2015, 12:35:16 PM
    Author     : Duoc
--%>

<%@page import="java.util.Date"%>
<%@page import="java.util.ArrayList"%>
<%@page import="cl.burgos.sakila.DAO.ActorDAO"%>
<%@page import="cl.burgos.sakila.Ent.Actor"%>
<%@page import="cl.burgos.sakila.BD.Log"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    Actor a1=null;
    if (request.getParameter("btn_ingresar") !=null)
    {
            a1= new Actor(request.getParameter("txt_firstName"),request.getParameter("txt_lastName"));
             if(ActorDAO.sqlAgregar(a1))
            out.println("Actor Guardado");
           else
              out.println("Error al Agregar"); 
        }
        
    if (request.getParameter("btn_buscar") !=null)
    {        a1 = new Actor(Integer.parseInt(request.getParameter("txt_actorId")));
             if(ActorDAO.sqlBuscar(a1))
             {
                 out.println("Actor Encontrado "+a1.getFirstName());
             }
           else
              out.println("Actor no se encuentra"); 
        }
    if (request.getParameter("btn_modificar") !=null)
    {
          a1 = new Actor(Integer.parseInt(request.getParameter("txt_actorId")),request.getParameter("txt_firstName"),request.getParameter("txt_lastName"));
         if(ActorDAO.sqlModificar(a1)) 
            out.println("Actor Modificado");
           else
              out.println("Actor no se modificó"); 
            
        }
    if (request.getParameter("btn_eliminar") !=null)
    {
             a1 = new Actor(Integer.parseInt(request.getParameter("txt_actorId")));
           if(ActorDAO.sqlEliminar(a1)) 
            out.println("Actor Eliminado");
           else
              out.println("Actor no fue eliminado"); 
        }
    if (request.getParameter("btn_listar") !=null)
    {
        String miTabla = "";
        ArrayList<Actor> ar=ActorDAO.sqlBuscar();
        miTabla += "<table border='1'>";
        for(Actor a2 :ar)
        {
            //fila
            miTabla += "<tr>";
            //columas
            miTabla += String.format("<td>%d</td>",a2.getActorId());
            miTabla += String.format("<td>%s</td>",a2.getFirstName());
            miTabla += String.format("<td>%s</td>",a2.getLastName());
            miTabla += "</tr>";
        }
        miTabla += "</table>";
        out.println(miTabla);
        Log.log("Listado");
            out.println("Listado exitosamente");
        }
    %>
    <html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Actor</title>
    </head>
    <body>
        <h1>Formulario de Registro</h1>
        <form method="POST" action="ActorMvc.jsp"> 
        <table border="1" background="red" > 
            <tr>  <td> ActorId </td>
                <td> <input value="<%if(a1 !=null) out.println(a1.getActorId());%>" name="txt_actorId" id="txt_actorId" size="50"
                            maxlength="45" type="number" min="0" max="7000">  </td>
            </tr> 
            <tr>  <td>First Name </td>
                <td> <input value="<%if(a1 !=null) out.println(a1.getFirstName());%>" name="txt_firstName" id="txt_firstName" size="20" maxlength="45">  </td> 
            </tr> 
            <tr>  <td>Last Name </td>
                <td> <input value="<%if(a1 !=null) out.println(a1.getLastName());%>" name="txt_lastName" id="txt_lastName" size="25" maxlength="45">  </td> 
            </tr> 
            <tr>  <td>Last Update </td>
                <td> <input name="txt_lastUpdate" id="txt_lastUpdate" size="20" type="date" >  </td> 
            </tr> 
            <tr> <td colspan="2"> 
                    <button name="btn_ingresar" id="btn_ingresar" type="submit"> Ingresar </button> 
                    <button name="btn_listar" id="btn_listar" type="submit"> Listar </button>
                    <button name="btn_buscar" id="btn_buscar" type="submit"> Buscar </button>
                    <button name="btn_eliminar" id="btn_eliminar" type="submit"> Eliminar </button>
                    <button name="btn_modificar" id="btn_modificar" type="submit"> Modificar </button>
                </td> </tr>
        </table>
        </form>
    </body>
</html>

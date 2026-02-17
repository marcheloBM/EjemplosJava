<%-- 
    Document   : InventoryMvc
    Created on : 14-09-2015, 0:10:21
    Author     : Marchelo
--%>
<%@page import="cl.burgos.sakila.Ent.Film"%>
<%@page import="cl.burgos.sakila.DAO.FilmDAO"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.ArrayList"%>
<%@page import="cl.burgos.sakila.DAO.InventoryDAO"%>
<%@page import="cl.burgos.sakila.Ent.Inventory"%>
<%@page import="cl.burgos.sakila.BD.Log"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
  Inventory i1=null;
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inventory</title>
    </head>
    <body>
        <h1>Formulario de Registro</h1>
        <form method="POST" action="InventoryMvc.jsp">
            <table border="1" background="red" >
                <tr>  <td>InventoryId</td>
                <td> <input value="<%if(i1 !=null) out.println(i1.getInventoryId());%>" name="txt_inventoryId" id="txt_inventoryId" size="50" maxlength="45" type="number" min="0" max="7000">  </td>
                </tr>
                <tr>  <td>FilmId</td>
                <td> <select name="txt_filmId" id="txt_filmId">
                        <%
                            ArrayList <Film> lista = FilmDAO.sqlBuscar();
                            String miOption ="";
                            for(Film milista : lista)
                            {
                                   miOption+= String.format("<option value = '%d'>", milista.getFilmId());
                                   miOption+= String.format("%s </option>", milista.getFilmId());
                            }
                            out.print(miOption);
                            
                        %>  </select> 
            </tr>
            <tr> <td colspan="2"> 
                    <button name="btn_ingresar" id="btn_ingresar" type="submit"> Ingresar </button> 
                    <button name="btn_listar" id="btn_listar" type="submit"> Listar </button>
                    <button name="btn_buscar" id="btn_buscar" type="submit"> Buscar </button>
                    <button name="btn_eliminar" id="btn_eliminar" type="submit"> Eliminar </button>
                    <button name="btn_modificar" id="btn_modificar" type="submit"> Modificar </button>
                </td> </tr>
        </table>
    </body>
</html>

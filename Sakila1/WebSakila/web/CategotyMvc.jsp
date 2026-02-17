<%-- 
    Document   : CategotyMvc
    Created on : 08-09-2015, 06:30:02 PM
    Author     : Duoc
--%>

<%@page import="java.util.Date"%>
<%@page import="java.util.ArrayList"%>
<%@page import="cl.burgos.sakila.DAO.CategoryDAO"%>
<%@page import="cl.burgos.sakila.Ent.Category"%>
<%@page import="cl.burgos.sakila.BD.Log"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    Category c1=null;
    if (request.getParameter("btn_ingresar") !=null)
    {
        c1= new Category(request.getParameter("txt_name"));
        if(CategoryDAO.sqlAgregar(c1))
            out.println("Category Guardado");
        else
            out.println("Error al Agregar"); 
    }
    if (request.getParameter("btn_buscar") !=null)
    {
        c1 = new Category(Integer.parseInt(request.getParameter("txt_categoryId")));
             if(CategoryDAO.sqlBuscar(c1))
             {
                 out.println("Category Encontrado "+c1.getName());
             }
           else
              out.println("Category no se encuentra"); 
        }
    if (request.getParameter("btn_modificar") !=null)
    {
          c1 = new Category(Integer.parseInt(request.getParameter("txt_categoryId")),request.getParameter("txt_name"));
         if(CategoryDAO.sqlModificar(c1)) 
            out.println("Category Modificado");
           else
              out.println("Category no se modificó"); 
            
        }
    if (request.getParameter("btn_eliminar") !=null)
    {
             c1 = new Category(Integer.parseInt(request.getParameter("txt_categoryId")));
           if(CategoryDAO.sqlEliminar(c1)) 
            out.println("Category Eliminado");
           else
              out.println("Category no fue eliminado"); 
        }
    if (request.getParameter("btn_listar") !=null)
    {
        String miTabla = "";
        ArrayList<Category> ar=CategoryDAO.sqlBuscar();
        miTabla += "<table border='1'>";
        for(Category c2 :ar)
        {
            //fila
            miTabla += "<tr>";
            //columas
            miTabla += String.format("<td>%d</td>",c2.getCategoryId());
            miTabla += String.format("<td>%s</td>",c2.getName());
            miTabla += "</tr>";
        }
        miTabla += "</table>";
        out.println(miTabla);
            out.println("Listado exitosamente");
        }
%>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Category</title>
    </head>
    <body>
        <h1>Formulario de Registro</h1>
        <form method="POST" action="CategotyMvc.jsp"> 
        <table border="1" background="red" > 
            <tr>  <td> CategoryId </td>
                <td> <input value="<%if(c1 !=null) out.println(c1.getCategoryId());%>" name="txt_categoryId" id="txt_categoryId" size="50"
                            maxlength="45" type="number" min="0" max="7000">  </td>
            </tr> 
            <tr>  <td>Name </td>
                <td> <input value="<%if(c1 !=null) out.println(c1.getName());%>" name="txt_name" id="txt_name" size="20" maxlength="45">  </td> 
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

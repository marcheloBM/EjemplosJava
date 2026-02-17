<%-- 
    Document   : FilmTextMvc
    Created on : 08-09-2015, 2:18:28
    Author     : Marchelo
--%>
<%@page import="java.util.Date"%>
<%@page import="java.util.ArrayList"%>
<%@page import="cl.burgos.sakila.DAO.FilmTextDAO"%>
<%@page import="cl.burgos.sakila.Ent.FilmText"%>
<%@page import="cl.burgos.sakila.BD.Log"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    FilmText ft=null;
    if (request.getParameter("btn_ingresar") !=null)
    {
        ft= new FilmText(Integer.parseInt(request.getParameter("txt_filmId")), request.getParameter("txt_title"),request.getParameter("txt_description"));
        if(FilmTextDAO.sqlAgregar(ft))
            out.println("Film Text Guardado");
        else
            out.println("Error al Agregar");
    }
    if (request.getParameter("btn_listar") !=null)
    {
        String miTabla = "";
        ArrayList<FilmText> lr=FilmTextDAO.sqlBuscar();
        miTabla += "<table border='1'>";
        for(FilmText ft1 :lr)
        {
            //fila
            miTabla += "<tr>";
            //columas
            miTabla += String.format("<td>%d</td>",ft1.getFilmId());
            miTabla += String.format("<td>%s</td>",ft1.getTitle());
            miTabla += String.format("<td>%s</td>",ft1.getDescription());
            miTabla += "</tr>";
        }
        miTabla += "</table>";
        out.println(miTabla);
            out.println("Listado exitosamente");
        }
    if (request.getParameter("btn_buscar") !=null)
    {        ft = new FilmText(Integer.parseInt(request.getParameter("txt_filmId")));
             if(FilmTextDAO.sqlBuscar(ft))
             {
                 out.println("Film Text Encontrado "+ft.getTitle());
             }
           else
              out.println("Film Text no se encuentra"); 
        }
    if (request.getParameter("btn_eliminar") !=null)
    {
             ft = new FilmText(Integer.parseInt(request.getParameter("txt_filmId")));
           if(FilmTextDAO.sqlEliminar(ft)) 
            out.println("Film Text Eliminado");
           else
              out.println("Film Text no fue eliminado"); 
        }
    if (request.getParameter("btn_modificar") !=null)
    {
          ft = new FilmText(Integer.parseInt(request.getParameter("txt_filmId")),request.getParameter("txt_title"),request.getParameter("txt_description"));
         if(FilmTextDAO.sqlModificar(ft)) 
            out.println("Film Text Modificado");
           else
              out.println("Film Text no se modificó"); 
            
        }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Film Text</title>
    </head>
    <body>
        <h1>Formulario de Registro</h1>
        <form method="POST" action="FilmTextMvc.jsp"> 
        <table border="1" background="red" > 
            <tr>  <td> FilmId </td>
                <td> <input value="<%if(ft !=null) out.println(ft.getFilmId());%>" name="txt_filmId" id="txt_filmId" size="50"
                            maxlength="45" type="number" min="0" max="7000">  </td>
            </tr> 
            <tr>  <td>Title </td>
                <td> <input value="<%if(ft !=null) out.println(ft.getTitle());%>" name="txt_title" id="txt_title" size="20" maxlength="45">  </td> 
            </tr> 
            <tr>  <td>Description </td>
                <td> <input value="<%if(ft !=null) out.println(ft.getDescription());%>" name="txt_description" id="txt_description" size="25" maxlength="45">  </td> 
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


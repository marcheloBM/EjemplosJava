<%-- 
    Document   : LanguageMvc
    Created on : 07-09-2015, 1:47:10
    Author     : Marchelo
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="cl.burgos.sakila.DAO.LanguageDAO"%>
<%@page import="cl.burgos.sakila.Ent.Language"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    Language l1=null;
    if (request.getParameter("btn_ingresar") !=null)
    {
            l1= new Language(request.getParameter("txt_name"));
             if(LanguageDAO.sqlAgregar(l1))
            out.println("Lenguaje Guardado");
           else
              out.println("Error al Agregar"); 
        }
        
    if (request.getParameter("btn_buscar") !=null)
    {        l1 = new Language(Integer.parseInt(request.getParameter("txt_language_id")));
             if(LanguageDAO.sqlBuscar(l1))
             {
                 out.println("Lenguaje Encontrado "+l1.getName());
             }
           else
              out.println("Lenguaje no se encuentra"); 
        }
    if (request.getParameter("btn_modificar") !=null)
    {
          l1 = new Language(Integer.parseInt(request.getParameter("txt_language_id")),request.getParameter("txt_name"));
         if(LanguageDAO.sqlModificar(l1)) 
            out.println("Lenguaje Modificado");
           else
              out.println("Lenguaje no se modificó"); 
            
        }
    if (request.getParameter("btn_eliminar") !=null)
    {
             l1 = new Language(Integer.parseInt(request.getParameter("txt_language_id")));
           if(LanguageDAO.sqlEliminar(l1)) 
            out.println("Lenguaje Eliminado");
           else
              out.println("Lenguaje no fue eliminado"); 
        }
    if (request.getParameter("btn_listar") !=null)
    {
        String miTabla = "";
        ArrayList<Language> lr=LanguageDAO.sqlBuscar();
        miTabla += "<table border='1'>";
        for(Language l2 :lr)
        {
            //fila
            miTabla += "<tr>";
            //columas
            miTabla += String.format("<td>%d</td>",l2.getLanguageId());
            miTabla += String.format("<td>%s</td>",l2.getName());
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
        <title>Lenguaje</title>
    </head>
    <body>
        <h1>Formulario de Registro</h1>
        <form method="POST" action="LanguageMvc.jsp"> 
        <table border="1" background="red" > 
            <tr>  <td> LanguageId </td>
                <td> <input value="<%if(l1 !=null) out.println(l1.getLanguageId());%>" name="txt_language_id" id="txt_language_id" size="50"
                            maxlength="45" type="number" min="0" max="7000">  </td>
            </tr> 
            <tr>  <td>Name </td>
                <td> <input value="<%if(l1 !=null) out.println(l1.getName());%>" name="txt_name" id="txt_name" size="20" maxlength="45">  </td> 
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

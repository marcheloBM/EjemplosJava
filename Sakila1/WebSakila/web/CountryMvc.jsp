<%-- 
    Document   : CountryMvc
    Created on : 08-09-2015, 0:44:25
    Author     : Marchelo
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="cl.burgos.sakila.DAO.CountryDAO"%>
<%@page import="cl.burgos.sakila.Ent.Country"%>
<%@page import="cl.burgos.sakila.BD.Log"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    Country c1=null;
    if(request.getParameter("btn_ingresar")!=null)
    {
        c1=new Country(request.getParameter("txt_country"));
        if(CountryDAO.sqlAgregar(c1))
            out.println("Country guardado");
        else
            out.println("Error al Agregar");
    }
    if(request.getParameter("btn_buscar")!=null)
    {
        c1=new Country(Integer.parseInt(request.getParameter("txt_countryId")));
        if(CountryDAO.sqlBuscar(c1))
        {
            out.println("Country Encontrado"+c1.getCountry());
        }
        else
            out.println("Country no se Encuentra");
    }
    if(request.getParameter("btn_modificar")!=null)
    {
        c1 =new Country(Integer.parseInt(request.getParameter("txt_countryId")),request.getParameter("txt_country"));
        if(CountryDAO.sqlModificar(c1))
            out.println("Country Modificado");
        else
            out.println("country no se Modifico");
    }
    if(request.getParameter("btn_eliminar")!=null)
    {
        c1 =new Country(Integer.parseInt(request.getParameter("txt_countryId")));
        if(CountryDAO.sqlEliminar(c1))
            out.println("Country Eliminado");
        else
            out.println("Country no fue Modificado");
    }
    if(request.getParameter("btn_listar")!=null)
    {
        String miTabla="";
        ArrayList<Country> lr=CountryDAO.sqlBuscar();
        miTabla += "<table border='1'>";
        for(Country c2 :lr)
        {
            miTabla += "<tr>";
            miTabla += String.format("<td>%d</td>",c2.getCountryId());
            miTabla += String.format("<td>%s</td>",c2.getCountry());
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
        <title>Country</title>
    </head>
    <body>
        <h1>Formulario de Registro</h1>
        <form method="POST" action="CountryMvc.jsp"> 
        <table border="1" background="red" > 
            <tr>  <td> LanguageId </td>
                <td> <input value="<%if(c1 !=null) out.println(c1.getCountryId());%>" name="txt_countryId" id="txt_countryId" size="50"
                            maxlength="45" type="number" min="0" max="7000">  </td>
            </tr> 
            <tr>  <td>Name </td>
                <td> <input value="<%if(c1 !=null) out.println(c1.getCountry());%>" name="txt_country" id="txt_country" size="20" maxlength="45">  </td> 
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

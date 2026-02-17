<%-- 
    Document   : CityMvc
    Created on : 09-09-2015, 2:07:32
    Author     : Marchelo
--%>
<%@page import="java.util.Date"%>
<%@page import="java.util.ArrayList"%>
<%@page import="cl.burgos.sakila.DAO.CityDAO"%>
<%@page import="cl.burgos.sakila.Ent.City"%>
<%@page import="cl.burgos.sakila.DAO.CountryDAO"%>
<%@page import="cl.burgos.sakila.Ent.Country"%>
<%@page import="cl.burgos.sakila.BD.Log"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    City c1=null;
    if (request.getParameter("btn_ingresar") !=null)
    {
            c1= new City(request.getParameter("txt_city"),Integer.parseInt(request.getParameter("txt_countryId")));
             if(CityDAO.sqlAgregar(c1))
            out.println("City Guardado");
           else
              out.println("Error al Agregar"); 
        }
    if (request.getParameter("btn_buscar") !=null)
    {        c1 = new City(Integer.parseInt(request.getParameter("txt_cityId")));
             if(CityDAO.sqlBuscar(c1))
             {
                 out.println("City Encontrado "+c1.getCity());
             }
           else
              out.println("City no se encuentra"); 
        }
    if (request.getParameter("btn_modificar") !=null)
    {
          c1 = new City(Integer.parseInt(request.getParameter("txt_cityId")),request.getParameter("txt_city"),Integer.parseInt(request.getParameter("txt_countryId")));
         if(CityDAO.sqlModificar(c1)) 
            out.println("City Modificado");
           else
              out.println("City no se modificó"); 
            
        }
    if (request.getParameter("btn_eliminar") !=null)
    {
             c1 = new City(Integer.parseInt(request.getParameter("txt_cityId")));
           if(CityDAO.sqlEliminar(c1)) 
            out.println("City Eliminado");
           else
              out.println("City no fue eliminado"); 
        }
    if (request.getParameter("btn_listar") !=null)
    {
        String miTabla = "";
        ArrayList<City> ar=CityDAO.sqlBuscar();
        miTabla += "<table border='1'>";
        for(City c2 :ar)
        {
            //fila
            miTabla += "<tr>";
            //columas
            miTabla += String.format("<td>%d</td>",c2.getCityId());
            miTabla += String.format("<td>%s</td>",c2.getCity());
            miTabla += String.format("<td>%d</td>",c2.getCountryId());
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
        <title>City</title>
    </head>
    <body>
        <h1>Formulario de Registro</h1>
        <form method="POST" action="CityMvc.jsp"> 
        <table border="1" background="red" > 
            <tr>  <td>CityId</td>
                <td> <input value="<%if(c1 !=null) out.println(c1.getCityId());%>" name="txt_cityId" id="txt_cityId" size="50"
                            maxlength="45" type="number" min="0" max="7000">  </td>
            </tr> 
            <tr>  <td>City </td>
                <td> <input value="<%if(c1 !=null) out.println(c1.getCity());%>" name="txt_city" id="txt_city" size="20" maxlength="45">  </td> 
            </tr>
            <tr><td>CountryId </td>
                <td> <select name="txt_countryId" id="txt_countryId">
                        <%
                            ArrayList <Country> lista = CountryDAO.sqlBuscar();
                            String miOption ="";
                            for(Country milista : lista)
                            {
                                   miOption+= String.format("<option value = '%d'>", milista.getCountryId());
                                   miOption+= String.format("%s </option>", milista.getCountry());
                            }
                            out.print(miOption);
                            
                        %>  </select>
            </tr>
            <tr>  <td>Last Update</td>
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

<%-- 
    Document   : AddressMvc
    Created on : 13-09-2015, 1:46:11
    Author     : Marchelo
--%>
<%@page import="java.util.Date"%>
<%@page import="java.util.ArrayList"%>
<%@page import="cl.burgos.sakila.DAO.AddressDAO"%>
<%@page import="cl.burgos.sakila.DAO.CountryDAO"%>
<%@page import="cl.burgos.sakila.Ent.Address"%>
<%@page import="cl.burgos.sakila.Ent.Country"%>
<%@page import="cl.burgos.sakila.BD.Log"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    Address ad=null;
    if (request.getParameter("btn_ingresar") !=null)
    {
            ad= new Address(request.getParameter("txt_address")
                    ,request.getParameter("txt_address2")
                    ,request.getParameter("txt_district")
                    ,Integer.parseInt(request.getParameter("txt_countryId"))
                    ,request.getParameter("txt_postalCode")
                    ,request.getParameter("txt_phone"));
             if(AddressDAO.sqlAgregar(ad))
            out.println("Address Guardado");
           else
              out.println("Error al Agregar"); 
        }
    if (request.getParameter("btn_buscar") !=null)
    {        ad = new Address(Integer.parseInt(request.getParameter("txt_addressId")));
             if(AddressDAO.sqlBuscar(ad))
             {
                 out.println("Address Encontrado "+ad.getAddress());
             }
           else
              out.println("Address no se encuentra"); 
        }
    if (request.getParameter("btn_modificar") !=null)
    {
          ad = new Address(Integer.parseInt(request.getParameter("txt_addressId"))
                  ,request.getParameter("txt_address")
                  ,request.getParameter("txt_address2")
                  ,request.getParameter("txt_district")
                  ,Integer.parseInt(request.getParameter("txt_countryId"))
                  ,request.getParameter("txt_postalCode")
                  ,request.getParameter("txt_phone"));
         if(AddressDAO.sqlModificar(ad)) 
            out.println("Address Modificado");
           else
              out.println("Address no se modificó"); 
            
        }
    if (request.getParameter("btn_eliminar") !=null)
    {
             ad = new Address(Integer.parseInt(request.getParameter("txt_addressId")));
           if(AddressDAO.sqlEliminar(ad)) 
            out.println("Address Eliminado");
           else
              out.println("Address no fue eliminado"); 
        }
    if (request.getParameter("btn_listar") !=null)
    {
        String miTabla = "";
        ArrayList<Address> ar=AddressDAO.sqlBuscar();
        miTabla += "<table border='1'>";
        for(Address a2 :ar)
        {
            miTabla += "<tr>";
            miTabla += String.format("<td>%d</td>",a2.getAddressId());
            miTabla += String.format("<td>%s</td>",a2.getAddress());
            miTabla += String.format("<td>%s</td>",a2.getAddress2());
            miTabla += String.format("<td>%s</td>",a2.getDistrict());
            miTabla += String.format("<td>%d</td>",a2.getCityId());
            miTabla += String.format("<td>%s</td>",a2.getPostalCode());
            miTabla += String.format("<td>%s</td>",a2.getPhone());
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
        <title>Address</title>
    </head>
    <body>
        <h1>Formulario de Registro</h1>
        <form method="POST" action="AddressMvc.jsp">
            <table border="1" background="red" >
                <tr>  <td>AddressId</td>
                <td> <input value="<%if(ad !=null) out.println(ad.getAddressId());%>" name="txt_addressId" id="txt_addressId" size="50" maxlength="45" type="number" min="0" max="7000">  </td>
            </tr>
            <tr>  <td>Address</td>
                <td> <input value="<%if(ad !=null) out.println(ad.getAddress());%>" name="txt_address" id="txt_address" size="20" maxlength="45">  </td> 
            </tr>
            <tr>  <td>Address2</td>
                <td> <input value="<%if(ad !=null) out.println(ad.getAddress2());%>" name="txt_address2" id="txt_address2" size="25" maxlength="45">  </td> 
            </tr>
            <tr>  <td>District</td>
                <td> <input value="<%if(ad !=null)out.println(ad.getDistrict());%>" name="txt_district" id="txt_district" size="25" maxlength="45">  </td> 
            </tr>
            <tr>  <td>CityId</td>
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
            <tr>  <td>PostalCode</td>
                <td> <input value="<%if(ad !=null)out.println(ad.getPostalCode());%>" name="txt_postalCode" id="txt_postalCode" size="25" maxlength="45">  </td> 
            </tr>
            <tr>  <td>Phone</td>
                <td> <input value="<%if(ad !=null)out.println(ad.getPhone());%>" name="txt_phone" id="txt_phone" size="25" maxlength="45">  </td> 
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
    </body>
</html>

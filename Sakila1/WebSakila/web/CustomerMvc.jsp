<%-- 
    Document   : CustomerMvc
    Created on : 13-09-2015, 18:05:37
    Author     : Marchelo
--%>
<%@page import="cl.burgos.sakila.DAO.AddressDAO"%>
<%@page import="cl.burgos.sakila.Ent.Address"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.ArrayList"%>
<%@page import="cl.burgos.sakila.DAO.CustomerDAO"%>
<%@page import="cl.burgos.sakila.DAO.StoreDAO"%>
<%@page import="cl.burgos.sakila.Ent.Customer"%>
<%@page import="cl.burgos.sakila.Ent.Store"%>
<%@page import="cl.burgos.sakila.BD.Log"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    Customer cu=null;
    if (request.getParameter("btn_ingresar") !=null)
    {
            cu= new Customer(Integer.parseInt(request.getParameter("txt_storeId"))
                    ,request.getParameter("txt_firstName")
                    ,request.getParameter("txt_lastName")
                    ,request.getParameter("txt_email")
                    ,Integer.parseInt(request.getParameter("txt_addressId"))
                    ,Integer.parseInt(request.getParameter("txt_active")));
             if(CustomerDAO.sqlAgregar(cu))
            out.println("Customer Guardado");
           else
              out.println("Error al Agregar"); 
        }
    if (request.getParameter("btn_buscar") !=null)
    {        cu = new Customer(Integer.parseInt(request.getParameter("txt_customerId")));
             if(CustomerDAO.sqlBuscar(cu))
             {
                 out.println("Customer Encontrado "+cu.getFirstName());
             }
           else
              out.println("Customer no se encuentra"); 
        }
    if (request.getParameter("btn_modificar") !=null)
    {
          cu = new Customer(Integer.parseInt(request.getParameter("txt_customerId"))
                  ,Integer.parseInt(request.getParameter("txt_storeId"))
                  ,request.getParameter("txt_firstName")
                  ,request.getParameter("txt_lastName")
                  ,request.getParameter("txt_email")
                  ,Integer.parseInt(request.getParameter("txt_addressId"))
                  ,Integer.parseInt(request.getParameter("txt_active")));
         if(CustomerDAO.sqlModificar(cu)) 
            out.println("Customer Modificado");
           else
              out.println("Customer no se modificó"); 
        }
    if (request.getParameter("btn_eliminar") !=null)
    {
             cu = new Customer(Integer.parseInt(request.getParameter("txt_customerId")));
           if(CustomerDAO.sqlEliminar(cu)) 
            out.println("Customer Eliminado");
           else
              out.println("Customer no fue eliminado"); 
        }
    if (request.getParameter("btn_listar") !=null)
    {
        String miTabla = "";
        ArrayList<Customer> ar=CustomerDAO.sqlBuscar();
        miTabla += "<table border='1'>";
        for(Customer a2 :ar)
        {
            miTabla += "<tr>";
            miTabla += String.format("<td>%d</td>",a2.getCustomerId());
            miTabla += String.format("<td>%s</td>",a2.getStoreId());
            miTabla += String.format("<td>%s</td>",a2.getFirstName());
            miTabla += String.format("<td>%s</td>",a2.getLastName());
            miTabla += String.format("<td>%s</td>",a2.getEmail());
            miTabla += String.format("<td>%d</td>",a2.getAddressId());
            miTabla += String.format("<td>%s</td>",a2.getActive());
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
        <title>Customer</title>
    </head>
    <body>
        <h1>Formulario de Registro</h1>
        <form method="POST" action="CustomerMvc.jsp">
            <table border="1" background="red" >
                <tr>  <td>CustomerId</td>
                <td> <input value="<%if(cu !=null) out.println(cu.getCustomerId());%>" name="txt_customerId" id="txt_customerId" size="50" maxlength="45" type="number" min="0" max="7000">  </td>
            </tr>
            <tr><td>StoreId</td>
                <td> <select name="txt_storeId" id="txt_storeId">
                        <%
                            ArrayList <Store> lista = StoreDAO.sqlBuscar();
                            String miOption ="";
                            for(Store milista : lista)
                            {
                                   miOption+= String.format("<option value = '%d'>", milista.getStoreId());
                                   miOption+= String.format("%s </option>", milista.getStoreId());
                            }
                            out.print(miOption);
                            
                        %></select>
            <tr>  <td>FirstName</td>
                <td> <input value="<%if(cu !=null) out.println(cu.getFirstName());%>" name="txt_firstName" id="txt_firstName" size="20" maxlength="45">  </td>
            </tr>
            <tr>  <td>LastName</td>
                <td> <input value="<%if(cu !=null) out.println(cu.getLastName());%>" name="txt_lastName" id="txt_lastName" size="20" maxlength="45">  </td>
            </tr>
            <tr>  <td>Email</td>
                <td> <input value="<%if(cu !=null) out.println(cu.getEmail());%>" name="txt_email" id="txt_email" size="20" maxlength="45">  </td>
            </tr>
            <tr><td>StoreId</td>
                <td> <select name="txt_addressId" id="txt_addressId">
                        <%
                            ArrayList <Address> lista1 = AddressDAO.sqlBuscar();
                            String miOption1 ="";
                            for(Address milista1 : lista1)
                            {
                                   miOption1+= String.format("<option value = '%d'>", milista1.getAddressId());
                                   miOption1+= String.format("%s </option>", milista1.getAddressId());
                            }
                            out.print(miOption1);
                            
                        %></select>
            </tr>
            <tr>  <td>Active</td>
                <td> <input value="<%if(cu !=null) out.println(cu.getActive());%>" name="txt_active" id="txt_active" size="20" maxlength="45">  </td>
            </tr>
            <tr>  <td>CreateDate</td>
                <td> <input name="txt_createDate" id="txt_createDate" size="20" type="date" >  </td> 
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

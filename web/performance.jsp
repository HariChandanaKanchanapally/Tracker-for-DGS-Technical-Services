<%-- 
    Document   : perfoemnace
    Created on : Mar 19, 2013, 1:37:16 PM
    Author     : Acer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 3.2 Final//EN">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Performance</title>
        <style type="text/css">
table.imagetable {
	font-family: verdana,arial,sans-serif;
	font-size:11px;
	color:#333333;
	border-width: 1px;
	border-color: #999999;
	border-collapse: collapse;
        
      table-layout: fixed;
    width: 200px;
       
      
         
        
}
table.imagetable th {
	background:#b5cfd2 url('cell-blue.jpg');
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #999999;
                align: center;
                overflow: hidden;
    width: 100px;
}
table.imagetable td {
	background:#dcddc0 url('cell-grey.jpg');
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #999999;
                align: center;
                overflow: hidden;
    width: 100px;

}
</style>
    </head>
    <body>
    
         <%@ page import="java.sql.*" %>
<% Class.forName("oracle.jdbc.OracleDriver"); %>
 
     <%  HttpSession session1=request.getSession(true);
             out.println("The email"+session1.getAttribute("email"));
           String  sess_email=session.getAttribute("email").toString();%>
    
     
       <% 
           Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM", "chandana");
           Statement statement = connection.createStatement() ;
           
          PreparedStatement ps = connection.prepareStatement("select empid, name from employer where designation!='Manager' ");
            ResultSet rs = ps.executeQuery();
            %>
      
      
      <% while(rs.next()){ %>
       <form action="cperformance">     
      <TABLE BORDER="1" class="imagetable">
      <TR>
      <TH>EMP ID</TH>
      <TH>EMP NAME</TH>
      <TH>RATING(Please Enter 1-10)</TH>
    
      </TR>
      <TR>
       <TD><%= rs.getString(1) %></td>
       <TD><%= rs.getString(2) %></TD>
       
       <td>
           <input type="text" name="rating" style="background-color:transparent;border:0px solid white">
           <input type="hidden" name="empid" value="<%= rs.getString(1)%>">
           <input type="submit" value="OK" name="OK" >
       <br>
               
       </td>
      </tr> 
      </table>

          
             </form>  

     
            <% } %>

    </body>
</html>

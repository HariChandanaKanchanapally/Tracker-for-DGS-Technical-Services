

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manager</title> 
  <style type="text/css">
table.imagetable {
	font-family: verdana,arial,sans-serif;
	font-size:11px;
	color:#333333;
	border-width: 1px;
	border-color: #999999;
	border-collapse: collapse;
        align: center;
      
         
        
}
table.imagetable th {
	background:#b5cfd2 url('cell-blue.jpg');
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #999999;
                align: center;
                width: 12%;

}
table.imagetable td {
	background:#dcddc0 url('cell-grey.jpg');
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #999999;
                align: center;
                width: 12%;

}
</style>
  </head>
    <body>
        <h1>Hello Manager!</h1>
        <table border="0">
            
          <tr>
                <td align="center">
                  &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;   &nbsp; &nbsp; <form action="cviewprofile" method="post">
                    <input type="image" name="View Profile" value="submit" src="view-profile-button-th.png" height="100" width="100">
                               <%-- <b class="cs1"> PLEASE ENTER THE PROFILE ID OF THE EMPLOYER : </b> <input type="text" name="empid">
                                    <input type="submit" value="View Profile"><br><br>--%>
                    </form>
                </td>
       
               <td align="center">
                    &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp;  &nbsp; &nbsp; <form action='ceditform' method='post'>
                        <input type="image" name="Edit Profile" value="Edit Profile" src="edit-profile-button-over.png" height="70" width="150">
                </form>
               </td>
            <td align="center">  
        
                  &nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; <a href="createjob.jsp"><img src="createjob.jpg" height="100" width="150"></a>
            </td>
            <td>
            
                 &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;  &nbsp;<a href="dynamic.jsp"><img src="Jobs.jpg" height="100" width="150"></a>
            </td>
            <td>
            &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp;<a href="color.jsp"><img src="Progress.jpeg" height="100" width="150"></a>
            </td>
            <td>
           &nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;  &nbsp; &nbsp; <a href="performance.jsp"><img src="Performance.jpg" height="100" width="100"></a>
            </td>
            <td>
          &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  &nbsp; &nbsp;<a href="logout.jsp">Logout</a>
            </td>
          </tr>
        </table> 
        <%@ page import="java.sql.*" %>
<% Class.forName("oracle.jdbc.OracleDriver"); %>
 
     <%  HttpSession session1=request.getSession(true);
             out.println("The email"+session1.getAttribute("email"));
           String  sess_email=session.getAttribute("email").toString();%>
    
       <H1>List of those applying for leave </H1>
       <% 
           Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM", "chandana");
           Statement statement = connection.createStatement() ;
           
          PreparedStatement ps = connection.prepareStatement("select empid,fromdate,reason,todate from datepicker where mgrid in(select empid from employer where email='"+sess_email+"' )");
            ResultSet rs = ps.executeQuery();%>

<table class="imagetable" border="1">                  
    <TR>
        <TH width="12%">EMPID</TH>
      <TH width="12%">FROM DATE</TH>
      
     <TH width="12%">REASON</TH>
      <TH  width="12%">TO DATE</TH>
      <TH width="12%">DECISION</TH>
      
      </TR>
     </table> 
      <% while(rs.next()){ %>
       <form action="cleavenotification">  
          <table border="1"  class="imagetable">
      <TR>
       <TD><%= rs.getString(1) %></td>
       <TD><%= rs.getString(2) %></TD>
       <TD><%= rs.getString(3) %></TD>
       <TD><%= rs.getString(4) %></td>
       <td><input type="text" name="decision" style="background-color:transparent;border:0px solid white">
           <input type="hidden" name="empid" value="<%= rs.getString(1)%>">
           <input type="hidden" name="fromdate" value="<%= rs.getString(2)%>">
           <input type="hidden" name="todate" value="<%= rs.getString(4)%>">
           <input type="submit" value="OK" name="OK" >
           <br>
               
       </td>
      </tr> 
      </table>

          
             </form>  

     
            <% } %>

      
      
     
         
          
        
    </body>
</html>

        

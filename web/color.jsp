<%-- 
    Document   : color
    Created on : Feb 27, 2013, 6:25:26 PM
    Author     : Acer
--%>

<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 3.2 Final//EN">
<!DOCTYPE html>
<html>
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
                width: 20%;

}
table.imagetable td {
	background:#dcddc0 url('cell-grey.jpg');
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #999999;
                align: center;
                width: 20%;

}
</style>
    <body>



<%@ page contentType="text/html"
import="java.awt.*,java.awt.image.*,
com.sun.image.codec.jpeg.*,java.util.*"
%>

 <%@ page import="java.sql.*" %>
<% Class.forName("oracle.jdbc.OracleDriver"); %>
 
     <%  HttpSession session1=request.getSession(true);
             
    // out.println("The email"+session1.getAttribute("email"));
           String  sess_email=session.getAttribute("email").toString();%>
    
             <font size="5" color="darkblue" face="verdana"> List of Jobs assigned </font><br><br>
       <% 
              try{
           
       
           Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM", "chandana");
           Statement statement = connection.createStatement() ;
          
            
         //  out.println("Connection\n");    
          PreparedStatement ps = connection.prepareStatement("select jobid,jobname,est_time,deadline,teamname,startdate,status,progress from jobs ");
            ResultSet rs = ps.executeQuery();
            //out.println("execute query");
            %>
            <table border="1" class="imagetable">    
      <TR>
      <TH>JOBID</TH>
      <TH>JOB NAME</TH>
      <TH>ESTIMATED TIME</TH>
      <TH>DEADLINE</TH>
      <TH>TEAM NAME</TH>
      <TH>START DATE</TH>
      <TH>STATUS</TH>
      <TH>COMPLETION PHASE</TH>
     
      </TR>
    </table>
      <% while(rs.next()){ %>
  
           <TABLE BORDER="1" class="imagetable" width="100%">
               
            
      <TR>
         
       <TD> <%= rs.getString(1) %></td>
       <TD> <%= rs.getString(2) %></TD>
       <TD> <%= rs.getString(3) %></TD>
       <TD> <%= rs.getString(4) %></TD>
       <TD> <%= rs.getString(5) %></TD>
       <TD> <%= rs.getString(6) %></TD>
       
       <TD>
           
           <%= rs.getString(7) %>
       </TD>
       <TD>   
          
        
        <%
if(rs.getString(8).equalsIgnoreCase("checking")){
       
        %> 
        <p>Checking phase with 33% work completed</p>
        <img src="checking.jsp">
        
       <%}
         
else  if(rs.getString(8).equalsIgnoreCase("detailing")){%>
<p>Detailing phase with 66% work completed</p>
<img src="detailing.jsp">
          <%}
            
else if((rs.getString(8)).equalsIgnoreCase("modeling")){%>
<p>Modeling phase with 99% work completed</p>
<img src="modeling.jsp">
         <% }
        
else if((rs.getString(8)).equalsIgnoreCase("finished")){%>
<p>Finished Job.Not currently in progress</p>
<img src="finished.jsp">
         <% } %> 
          
       </TD> 
       
     
            
      </TR>
           </table>
       
      <% } }
        catch(Exception e){}            
       %>
     
</body>
</html>
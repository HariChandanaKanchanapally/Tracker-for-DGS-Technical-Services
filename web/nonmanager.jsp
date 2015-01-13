<%-- 
    Document   : nonmanager
    Created on : Jan 25, 2013, 12:58:26 PM
    Author     : shruthibalki
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Non-Manager</title>
    </head>
    <body>
        <h1>Hello Nonmanager!</h1>
        
       
        
        <a href="CAL.jsp" >Select Leaves</a>
              
        <%@ page import="java.sql.*" %>
<% Class.forName("oracle.jdbc.OracleDriver"); %>
 
     <%  HttpSession session1=request.getSession(true);
             out.println("The email"+session1.getAttribute("email"));
           String  sess_email=session.getAttribute("email").toString();%>
    
       <H1>List of Jobs assigned </H1>
       <% 
           Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM", "chandana");
           Statement statement = connection.createStatement() ;
           
          PreparedStatement ps = connection.prepareStatement("select jobid,jobname,est_time,deadline,teamname,startdate from jobs where projmgr in(select empid from employer where email='"+sess_email+"') ");
            ResultSet rs = ps.executeQuery();
            %>
          
      
      <% while(rs.next()){ %>
      
       <form method="post" action="cjoblist">
           <TABLE BORDER="1">
      <TR>
      <TH>JOBID</TH>
      <TH>JOB NAME</TH>
      <TH>ESTIMATED TIME</TH>
      <TH>DEADLINE</TH>
      <TH>TEAM NAME</TH>
      <TH>START DATE</TH>
      <TH>STATUS</TH>
      <TH>COMPLETION PHASE</TH>
      <TH> Rewrite</TH>
        
      </TR>
     
      <TR>
         
       <TD> <%= rs.getString(1) %></td>
       <TD> <%= rs.getString(2) %></TD>
       <TD> <%= rs.getString(3) %></TD>
       <TD> <%= rs.getString(4) %></TD>
       <TD> <%= rs.getString(5) %></TD>
       <TD> <%= rs.getString(6) %></TD>
       
       <TD>
           
           <input type="text" name="status" style="background-color:transparent;border:0px solid white">
       </TD>
       <TD>
           <input type="text" name="phase" style="background-color:transparent;border:0px solid white">
           <input type="hidden" name="job" value="<%= rs.getString(1)%>">       
       </TD> 
       
       <TD> <input type="submit" value="Notify the progress to manager">
       </TD>
            
      </TR>
           </table>
       </form>
      <% } %>
     
     
        
          
        

        <br>  <br>     <a href="logout.jsp">Logout</a>
     
    </body>
</html>
<%-- 
    Document   : editnote
    Created on : Feb 25, 2013, 4:02:02 PM
    Author     : shruthibalki
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.io.IOException;" %>
<%@page import="java.io.PrintWriter;" %>
<%@page import="java.sql.Connection;" %>
<%@page import="java.sql.DriverManager;" %>
<%@page import="java.sql.PreparedStatement;" %>
<%@page import="java.sql.ResultSet;" %>
<%@page import="javax.servlet.RequestDispatcher;" %>
<%@page import="javax.servlet.ServletException;" %>
<%@page import="javax.servlet.http.HttpServlet;" %>
<%@page import="javax.servlet.http.HttpServletRequest;" %>
<%@page import="javax.servlet.http.HttpServletResponse;" %>
<%@page import="javax.servlet.http.HttpSession;" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>errorlog</title>
    </head>
    <body>
        <h1>List of Notes</h1>
        <%
        try{
            
            Class.forName("oracle.jdbc.OracleDriver");
                           
            Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","chandana");
                        
             PreparedStatement ps = con.prepareStatement("select * from errorlog");
             ResultSet rs = ps.executeQuery();
            
             %> 
             
             <a href="createerrorlog.jsp">Create</a>
             
             <TABLE cellpadding="15" border="1" style="background-color: #ffffcc;"> 
                
            <% 
                  
            while ( rs.next()) {
                                                        
                           
                 %> 
                        <form action="updateerrorlog" method="get">
                        <TR> 
                        
                            <TD><%=rs.getString(1)%></TD>
                            <TD><%=rs.getString(2)%></TD>
                            <TD><%=rs.getString(3)%></TD>
                            <TD><%=rs.getString(4)%></TD>
                            <TD>
                                <input type="hidden" name="jobid" value="<%=rs.getString(1)%>">
                                <input type="submit" value="Edit"></TD>
                        </TR> 
                        </form>
                <%        
                                  
            }

            con.close();
        }
        catch(Exception ex) {

        }
        finally { 
            out.close();
        }
        %>
    </body>
</html>


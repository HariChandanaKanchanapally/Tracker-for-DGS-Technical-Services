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
        <title>Editnote</title>
    </head>
    <body>
        <h1>List of Notes</h1>
        <%
        try{
            
            Class.forName("oracle.jdbc.OracleDriver");
                           
            Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","shruthi");
                        
             PreparedStatement ps = con.prepareStatement("select * from todonotes");
             ResultSet rs = ps.executeQuery();
            
             String sess_email;
             HttpSession session1=request.getSession(true);
            
             sess_email=session1.getAttribute("email").toString();
             %> 
             
             <TABLE cellpadding="15" border="1" style="background-color: #ffffcc;"> 
                
            <% 
        
            while ( rs.next()) {
                                                        
                             if(sess_email == null ? rs.getString(1) == null : sess_email.equals(rs.getString(1)))
              {
                 %> 
                 <form action="editnote" method="get" >
                        <TR> 
                        
                            <TD><%=rs.getString(2)%></TD>
                            <TD>
                                <input type="hidden" name="note" value="<%=rs.getString(2)%>">
                                <input type="submit" value="Edit"></TD>
                        </TR> 
                 </form>  <%        
             }
            
             
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


<%-- 
    Document   : leavesm
    Created on : Apr 7, 2013, 3:00:43 PM
    Author     : Acer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 3.2 Final//EN">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
<script>
            function vali(){
                    
                       
                                        
                                       if((leavem.decision.value==""))
                                                            {

                                                                alert ('Please enter the decision');
                                                                leavem.decision.focus();
                                                               return false;
                                                            }
                                   
                                      
                        document.forms[0].action();
                        return true;
                    }
 </script>
        <style>
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

     .tryitbtn
        
           {
            background: black;
            color: white;
            height:40px;
            border-radius:40px;
        
            }
</style>



<%@ page contentType="text/html"
import="java.awt.*,java.awt.image.*,
com.sun.image.codec.jpeg.*,java.util.*"
%>

 <%@ page import="java.sql.*" %>
<% Class.forName("oracle.jdbc.OracleDriver"); %>
 
     <%  HttpSession session1=request.getSession(true);
             
    // out.println("The email"+session1.getAttribute("email"));
           String  sess_email=session.getAttribute("email").toString();%>
    
             <font size="5" color="darkblue" face="verdana"> List of those who applied for leaves </font><br><br>
       <% 
              try{
           
       
           Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM", "chandana");
           Statement statement = connection.createStatement() ;
          
            
          
          PreparedStatement ps = connection.prepareStatement("select empid, fromdate, reason, todate from datepicker where mgrid in (select empid from employer where email='"+sess_email+"') ");
            ResultSet rs = ps.executeQuery();
         
            %>
            <table border="1" class="imagetable">    
      <TR>
      <TH width="10%">EMPID</TH>
      <TH width="10%">FROM DATE</TH>
      <TH width="10%">REASON</TH>
      <TH width="10%">TO DATE</TH>

      <TH width="10%"> DECISION</TH>
      <TH width="10%">SUBMIT</TH>
      </TR>
    </table>
      <% while(rs.next()){ %>
      <form action="cleavesm" method="post" onsubmit="vali()" name="leavem">
           <TABLE BORDER="1" class="imagetable">
               
            
      <TR>
         
       <TD width="10%"> <%= rs.getString(1) %></td>
       <TD width="10%"> <%= rs.getString(2) %></TD>
       <TD width="10%"> <%= rs.getString(3) %></TD>
       <TD width="10%"> <%= rs.getString(4) %></TD>
       <TD width="10%"> 
          
           <input type="text" name="decision" style="background-color:transparent;border:0px solid white">
           <input type="hidden" name="empid" value="<%= rs.getString(1)%>">   
       </TD>
       <TD width="10%"><input type="submit" class="tryitbtn" name="submit"  align="center" value="Click for notifying decision to employee"><br><br>  
    </TD>
        </TR>
                   </table>

           </form>     
  
       
      <% } }
        catch(Exception e){}            
       %>
     

        

    </body>
</html>

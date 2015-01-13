<%-- 
    Document   : editnote
    Created on : Feb 25, 2013, 4:02:02 PM
    Author     : shruthibalki
--%>

<%@page import="java.util.Date"%>
<%@page import="java.text.DateFormat"%>
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




    <%--
        <%
        try{
            
            Class.forName("oracle.jdbc.OracleDriver");
                           
            Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","chandana");
                        
             PreparedStatement ps = con.prepareStatement("select * from egs");
             ResultSet rs = ps.executeQuery();
            
             Date date2=new Date();
             %> 
             
            <% 
            out.println("" );  
            while ( rs.next()) {
                                                        
                           
                    Date date = rs.getDate(5); 
                    String dateStr = DateFormat.getDateInstance(DateFormat.MEDIUM).format(date); 
                    
                    int d1=date.getMonth();
                    int d2=date2.getMonth();
                    if(d1==d2)
                                               {
                        %>
                        The deadline for JOB ID <%
                        out.println(rs.getString(1));
                        %>is on <%
                        out.println(dateStr);
                        %>.The manager handling the project is <%
                        out.println(rs.getString(7));
                        %><hr width="60%" align ="left"><%
                    }
            }
        }
        finally { 
            out.close();
        }
        %>
        <script language="JavaScript">
            // ==============================================
            // Copyright 2004 by CodeLifter.com
            // Free for all; but please leave in this header.
            // ==============================================

            var Quotation=new Array() // do not change this!

            // Set up the quotations to be shown, below.
            // To add more quotations, continue with the
            // pattern, adding to the array.  Remember
            // to increment the Quotation[x] index!

            Quotation[0] = "Time is of the essence! Comb your hair.";
            Quotation[1] = "Sanity is a golden apple with no shoelaces.";
            Quotation[2] = "Repent! The end is coming, $9.95 at Amazon.";
            Quotation[3] = "Honesty blurts where deception sneezes.";
            Quotation[4] = "Pastry satisfies where art is unavailable.";
            Quotation[5] = "Delete not, lest you, too, be deleted.";
            Quotation[6] = "O! Youth! What a pain in the backside.";
            Quotation[7] = "Wishes are like goldfish with propellors.";
            Quotation[8] = "Love the river's \"beauty\", but live on a hill.";
            Quotation[9] = "Invention is the mother of too many useless toys.";

            // ======================================
            // Do not change anything below this line
            // ======================================
            var Q = Quotation.length;
            var whichQuotation=Math.round(Math.random()*(Q-1));
            function showQuotation(){document.write(Quotation[whichQuotation]);}
            showQuotation();
            </script>
    --%>
    <!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>notifications</title>
        
  
    
<style type="text/css">
table.imagetable {
	font-family: verdana,arial,sans-serif;
	font-size:11px;
	color:#333333;
	border-width: 1px;
	border-color: #999999;
	border-collapse: collapse;
        overflow: hidden;
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
</style></head>
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
      <TH width="10%">JOBID</TH>
      <TH width="10%">JOB NAME</TH>
      <TH width="10%">ESTIMATED TIME</TH>
      <TH width="10%">DEADLINE</TH>
      <TH width="10%">TEAM NAME</TH>
      <TH width="10%">START DATE</TH>
      <TH width="10%">STATUS</TH>
      <TH width="20%">COMPLETION PHASE</TH>
     
      </TR>
    </table>
      <% while(rs.next()){ %>
  
           <TABLE BORDER="1" class="imagetable">
               
            
      <TR>
         
       <TD width="10%"> <%= rs.getString(1) %></td>
       <TD width="10%"> <%= rs.getString(2) %></TD>
       <TD width="10%"> <%= rs.getString(3) %></TD>
       <TD width="10%"> <%= rs.getString(4) %></TD>
       <TD width="10%"> <%= rs.getString(5) %></TD>
       <TD width="10%"> <%= rs.getString(6) %></TD>
       
       <TD width="10%">
           
           <%= rs.getString(7) %>
       </TD>
       <TD width="20%">   
          
        
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
        

<%-- 
    Document   : wel_todo
    Created on : Feb 6, 2013, 11:07:02 AM
    Author     : shruthibalki
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*;" %>
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

<!--  http://www.java-samples.com/jsp  -->  
<html>
    <head> 
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8"> 
        <title>Triqui Clock</title> 
    <p align="right"><a href="logout.jsp" target="B"><img src="logout.png" width="50" height="50"></a></p>
        <SCRIPT LANGUAGE="JavaScript">
            var clocksize=200;
            if(!clocksize||clocksize=='SIZE')clocksize='100';

            document.write('<OBJECT CLASSID="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" CODEBASE="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,0,0" WIDTH="'+clocksize+'" HEIGHT="'+clocksize+'">');

            document.write('<PARAM NAME="movie" VALUE="http://www.gheos.net/js/clock/clock.swf">');
            document.write('<PARAM NAME="quality" VALUE="high">');
            //document.write('<PARAM NAME="bgcolor" VALUE="#FFFFFF">');
            document.write('<PARAM NAME="wmode" VALUE="transparent">');
            document.write('<PARAM NAME="menu" VALUE="false">');

            document.write('<EMBED SRC="http://www.gheos.net/js/clock/clock.swf" WIDTH="'+clocksize+'" HEIGHT="'+clocksize+'" QUALITY="high" WMODE="transparent" MENU="false"></EMBED>');

            document.write('</OBJECT>');
        </script>
    </head>
    <body>
        <p> </p>
     
 <div id="clock_id"></div>
 <br><br>
        <script>draw_clock()</script>
        
        
                        <%

                        Calendar cal = Calendar.getInstance();
                        int hour = cal.get(Calendar.HOUR);
                        int meridiem = cal.get(Calendar.AM_PM);

                        if(meridiem == Calendar.AM) {

                        if(hour >= 5 && hour < 12) {
                        out.println("Good Morning");
                        }

                        }else {

                        if(hour >= 12 && hour <= 5) {
                        out.println("Good Afternoon");
                        }else {
                        out.println("Good Evening");
                        }
                        }
                        try{

                                    Class.forName("oracle.jdbc.OracleDriver");

                                    Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","shruthi");

                                     PreparedStatement ps = con.prepareStatement("select * from employer");
                                     ResultSet rs = ps.executeQuery();
                                     
                                     PreparedStatement ps1 = con.prepareStatement("select * from todonotes");
                                     ResultSet rs1 = ps1.executeQuery();

                                     String sess_email;
                                     HttpSession session1=request.getSession(true);

                                     sess_email=session1.getAttribute("email").toString();


                                    while ( rs.next()) {

                                                     if(sess_email == null ? rs.getString(8) == null : sess_email.equals(rs.getString(8)))
                                                                {
                                                                       out.println(rs.getString(2));
                                                                }

                                                       }
                                     
                                     %>
                                    <p><marquee direction="up" scrollamount ="4"><%
                                    while(rs1.next()){
                                                       if(sess_email == null ? rs1.getString(1) == null : sess_email.equals(rs1.getString(1)))
                                                                {
                                                                  %><br><br><br>
                                                                  <%=rs1.getString(2)%>
                                                                   <% 
                                                                 }
                                                      }  %>
                                   </marquee></p><%
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

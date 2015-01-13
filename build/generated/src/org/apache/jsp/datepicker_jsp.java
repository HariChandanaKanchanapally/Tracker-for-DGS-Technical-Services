package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import java.io.*;

public final class datepicker_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<!doctype html>\n");
      out.write(" \n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("  <meta charset=\"utf-8\" />\n");
      out.write("  <title>jQuery UI Datepicker - Default functionality</title>\n");
      out.write("  <link rel=\"stylesheet\" href=\"http://code.jquery.com/ui/1.10.0/themes/base/jquery-ui.css\" />\n");
      out.write("  <script src=\"http://code.jquery.com/jquery-1.8.3.js\"></script>\n");
      out.write("  <script src=\"http://code.jquery.com/ui/1.10.0/jquery-ui.js\"></script>\n");
      out.write("  <link rel=\"stylesheet\" href=\"/resources/demos/style.css\" />\n");
      out.write("  <script>\n");
      out.write("  $(function() {\n");
      out.write("    $( \"#datepicker\" ).datepicker();\n");
      out.write("  });\n");
      out.write(" $(function() {\n");
      out.write("    $( \"#datepicker2\" ).datepicker();\n");
      out.write("  });\n");
      out.write("  </script>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<form method=\"put\" action=\"#\"> \n");
      out.write("<p>From Date: <input type=\"text\" id=\"datepicker\" name=\"fromdate\"/></p>\n");
      out.write("<p>Reason/Purpose<input type=\"text\" size=\"30\" name=\"reason\">\n");
      out.write("<p>To Date: <input type=\"text\" id=\"datepicker2\" /></p>\n");
      out.write("<p>Send Notification to(type the EMPID of your manager):<input type=\"text\" name=\"empidm\"\n");
      out.write("\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"\"http://www.w3.org/TR/html4/loose.dtd\"> \n");
      out.write(" \n");
      out.write(" \n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<html> \n");
      out.write("<head> \n");
      out.write("<title>insert into table using jsp</title> \n");
      out.write("</head> \n");
      out.write("<body> \n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
 
try{


/* Create string of connection url within specified format with machinename, port number and database name. Here machine name id localhost and database name is mydb. */ 

String connectionURL = "jdbc:oracle:thin:@localhost:1521:XE"; 

// declare a connection by using Connection interface 

Connection connection = null; 

/* declare object of Statement interface that is used for executing sql statements. */ 

Statement statement = null; 

// declare a resultset that uses as a table for output data from tha table. 

ResultSet rs = null; 

// Load JDBC driver "com.mysql.jdbc.Driver" 

Class.forName("oracle.jdbc.OracleDriver").newInstance(); 

/* Create a connection by using getConnection() method that takes parameters of string type connection url, user name and password to connect to database.*/ 

connection = DriverManager.getConnection(connectionURL, "chandana", "SYSTEM"); 

/* createStatement() is used for create statement object that is used for sending sql statements to the specified database. */ 

statement = connection.createStatement(); 

// sql query to retrieve values from the specified table. 

     

 String ffromdate = request.getParameter("fromdate");
 String freason = request.getParameter("reason");
 String ftodate = request.getParameter("todate");
 String fmgrid = request.getParameter("mgrid");
 String sess_email;
 HttpSession session1=request.getSession(true);
             out.println("The email"+session1.getAttribute("email"));
             sess_email=session.getAttribute("email").toString();  
  PreparedStatement ps =connection.prepareStatement( "insert into datepicker(empid,fromdate,reason,todate,mgrid) values(?,?,?,?,?)");                  

      out.write(" \n");
      out.write("<TABLE cellpadding=\"15\" border=\"1\" style=\"background-color: #ffffcc;\"> \n");
 
while (rs.next()) 
{ 

ps.setString(1,sess_email);
ps.setString(2,ffromdate); 
ps.setString(3,freason);
ps.setString(4,ftodate);
ps.setString(5,fmgrid);

} 


      out.write(" \n");
      out.write("\n");
 

// close all the connections.

rs.close(); 
statement.close(); 
connection.close(); 
} 
catch (Exception ex) 
{ 

      out.write(" \n");
      out.write("<font size=\"+3\" color=\"red\"></b> \n");
 
out.println("Unable to connect to database."); 
} 

      out.write(" \n");
      out.write("<p >Successfully notified</p>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}

package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class CAL_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<html>\r\n");
      out.write("<head> \r\n");
      out.write("    <style> \r\n");
      out.write(".monthPre{\r\n");
      out.write(" color: gray;\r\n");
      out.write(" text-align: center;\r\n");
      out.write("}\r\n");
      out.write(".monthNow{\r\n");
      out.write(" color: blue;\r\n");
      out.write(" text-align: center;\r\n");
      out.write("}\r\n");
      out.write(".dayNow{\r\n");
      out.write(" border: 2px solid black;\r\n");
      out.write(" color: #FF0000;\r\n");
      out.write(" text-align: center;\r\n");
      out.write("}\r\n");
      out.write(".calendar td{\r\n");
      out.write(" htmlContent: 2px;\r\n");
      out.write(" width: 40px;\r\n");
      out.write("}\r\n");
      out.write(".monthNow th{\r\n");
      out.write(" background-color: #000000;\r\n");
      out.write(" color: #FFFFFF;\r\n");
      out.write(" text-align: center;\r\n");
      out.write("}\r\n");
      out.write(".dayNames{\r\n");
      out.write(" background: #0FF000;\r\n");
      out.write(" color: #FFFFFF;\r\n");
      out.write(" text-align: center;\r\n");
      out.write("}\r\n");
      out.write(" \r\n");
      out.write("</style> \r\n");
      out.write("<title>JavaScript calendar</title>\r\n");
      out.write("<script> \r\n");
      out.write("  var action=1000;  \r\n");
      out.write(" function fdate(bv)\r\n");
      out.write("        {\r\n");
      out.write("            if(action==1000)\r\n");
      out.write("            {\r\n");
      out.write("            alert(bv);\r\n");
      out.write("            \r\n");
      out.write("            document.entry.fromdate.value=bv;\r\n");
      out.write("            document.entry.fromdate.value+=\"/\"+ new Date().getMonth();\r\n");
      out.write("            document.entry.fromdate.value+= \"/\"+new Date().getFullYear();\r\n");
      out.write("        \r\n");
      out.write("           alert(document.getElementById(\"button1\").value) ;\r\n");
      out.write("           action=2000;\r\n");
      out.write("            }\r\n");
      out.write("            if(action==2000)\r\n");
      out.write("                {\r\n");
      out.write("                    alert(bv);\r\n");
      out.write("            \r\n");
      out.write("            document.entry.todate.value=bv;\r\n");
      out.write("            document.entry.todate.value+=\"/\"+ new Date().getMonth();\r\n");
      out.write("            document.entry.todate.value+= \"/\"+new Date().getFullYear();\r\n");
      out.write("                }\r\n");
      out.write("        }\r\n");
      out.write("         \r\n");
      out.write("    \r\n");
      out.write("function displayCalendar(){\r\n");
      out.write(" \r\n");
      out.write(" \r\n");
      out.write(" var htmlContent =\"\";\r\n");
      out.write(" var FebNumberOfDays =\"\";\r\n");
      out.write(" var counter = 1;\r\n");
      out.write(" \r\n");
      out.write(" \r\n");
      out.write(" var dateNow = new Date();\r\n");
      out.write(" var month = dateNow.getMonth();\r\n");
      out.write("\r\n");
      out.write(" var nextMonth = month+1; //+1; //Used to match up the current month with the correct start date.\r\n");
      out.write(" var prevMonth = month -1;\r\n");
      out.write(" var day = dateNow.getDate();\r\n");
      out.write(" var year = dateNow.getFullYear();\r\n");
      out.write(" \r\n");
      out.write(" \r\n");
      out.write(" //Determing if February (28,or 29)  \r\n");
      out.write(" if (month == 1){\r\n");
      out.write("    if ( (year%100!=0) && (year%4==0) || (year%400==0)){\r\n");
      out.write("      FebNumberOfDays = 29;\r\n");
      out.write("    }else{\r\n");
      out.write("      FebNumberOfDays = 28;\r\n");
      out.write("    }\r\n");
      out.write(" }\r\n");
      out.write(" \r\n");
      out.write(" \r\n");
      out.write(" // names of months and week days.\r\n");
      out.write(" var monthNames = [\"January\",\"February\",\"March\",\"April\",\"May\",\"June\",\"July\",\"August\",\"September\",\"October\",\"November\", \"December\"];\r\n");
      out.write(" var dayNames = [\"Sunday\",\"Monday\",\"Tuesday\",\"Wednesday\",\"Thrusday\",\"Friday\", \"Saturday\"];\r\n");
      out.write(" var dayPerMonth = [\"31\", \"\"+FebNumberOfDays+\"\",\"31\",\"30\",\"31\",\"30\",\"31\",\"31\",\"30\",\"31\",\"30\",\"31\"]\r\n");
      out.write(" \r\n");
      out.write(" \r\n");
      out.write(" // days in previous month and next one , and day of week.\r\n");
      out.write(" var nextDate = new Date(nextMonth +' 1 ,'+year);\r\n");
      out.write(" var weekdays= nextDate.getDay();\r\n");
      out.write(" var weekdays2 = weekdays\r\n");
      out.write(" var numOfDays = dayPerMonth[month];\r\n");
      out.write(" \r\n");
      out.write(" \r\n");
      out.write(" \r\n");
      out.write(" \r\n");
      out.write(" \r\n");
      out.write(" \r\n");
      out.write(" // this leave a white space for days of pervious month.\r\n");
      out.write(" while (weekdays>0){\r\n");
      out.write("    htmlContent += \"<td class='monthPre'></td>\";\r\n");
      out.write(" \r\n");
      out.write(" // used in next loop.\r\n");
      out.write("     weekdays--;\r\n");
      out.write(" }\r\n");
      out.write(" \r\n");
      out.write(" // loop to build the calander body.\r\n");
      out.write(" while (counter <= numOfDays){\r\n");
      out.write(" \r\n");
      out.write("     // When to start new line.\r\n");
      out.write("    if (weekdays2 > 6){\r\n");
      out.write("        weekdays2 = 0;\r\n");
      out.write("        htmlContent += \"</tr><tr>\";\r\n");
      out.write("    }\r\n");
      out.write(" \r\n");
      out.write(" \r\n");
      out.write("    // if counter is current day.\r\n");
      out.write("    // highlight current day using the CSS defined in header.\r\n");
      out.write("    if (counter == day){\r\n");
      out.write("               \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("htmlContent +=\r\n");
      out.write("    \"<td class='dayNow'  onMouseOver='this.style.background=\\\"#FF0000\\\" ;this.style.color=\\\"#FFFFFF\\\"' onMouseOut='this.style.background=\\\"#FFFFFF\\\"; this.style.color=\\\"#00FF00\\\"'> <input type='button' name='date' value='\"+counter+\"' onclick='fdate( \" +counter+ \" )' id='button1'></input></td>\"; \r\n");
      out.write("}\r\n");
      out.write("else{\r\n");
      out.write("         \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("htmlContent +=\"<td class='monthNow' onMouseOver='this.style.background=\\\"#FF0000\\\"'\"+\r\n");
      out.write("        \" onMouseOut='this.style.background=\\\"#FFFFFF\\\"'><input type='button' name='date' value='\"+counter+\"' onclick='fdate( \"+counter+\" )' id='button1' ></input></td>\"   \r\n");
      out.write(" \r\n");
      out.write("    }\r\n");
      out.write("    \r\n");
      out.write("    weekdays2++;\r\n");
      out.write("    counter++;\r\n");
      out.write(" }\r\n");
      out.write(" \r\n");
      out.write(" \r\n");
      out.write(" \r\n");
      out.write(" // building the calendar html body.\r\n");
      out.write(" var calendarBody = \"<table class='calendar'> <tr class='monthNow'><th colspan='7'>\"\r\n");
      out.write(" +monthNames[month]+\" \"+ year +\"</th></tr>\";\r\n");
      out.write(" calendarBody +=\"<tr class='dayNames'>  <td>Sun</td>  <td>Mon</td> <td>Tues</td>\"+\r\n");
      out.write(" \"<td>Wed</td> <td>Thurs</td> <td>Fri</td> <td>Sat</td> </tr>\";\r\n");
      out.write(" calendarBody += \"<tr>\";\r\n");
      out.write(" calendarBody += htmlContent;\r\n");
      out.write(" calendarBody += \"</tr></table>\";\r\n");
      out.write(" // set the content of div .\r\n");
      out.write(" document.getElementById(\"calendar\").innerHTML=calendarBody;\r\n");
      out.write(" \r\n");
      out.write("}\r\n");
      out.write("</script> \r\n");
      out.write("</head> \r\n");
      out.write(" \r\n");
      out.write("<body onload=\"displayCalendar()\"> \r\n");
      out.write(" \r\n");
      out.write("<div id=\"calendar\"></div> \r\n");
      out.write(" <form name=\"entry\" action=\"cdatepicker\">\r\n");
      out.write("      From date<input  type=\"text\" name=\"fromdate\"><br><br>\r\n");
      out.write("    \r\n");
      out.write("      To date<input  type=\"text\" name=\"todate\"><br><br>\r\n");
      out.write("    \r\n");
      out.write("      Reason<input type=\"text\" name=\"reason\"><br><br>\r\n");
      out.write("      \r\n");
      out.write("      Manager ID<input type=\"text\" name=\"mgrid\"><br><br>\r\n");
      out.write("      \r\n");
      out.write("      <input type=\"submit\" name=\"submit\" value=\"Notify my absence to the manager\"><br><br>\r\n");
      out.write(" </form>\r\n");
      out.write("</BODY>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</html>");
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

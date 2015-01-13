package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class dynamic_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"utf-8\" />\n");
      out.write("        <title>Example</title>\n");
      out.write("        <script type=\"text/javascript\" src=\"https://www.google.com/jsapi\"></script>\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("                var numberschart = 10; //<- Initial value\n");
      out.write("                google.load('visualization', '1', {packages: ['corechart']});\n");
      out.write("\n");
      out.write("                function numbers(){\n");
      out.write("                        var work_field = document.forms['work_form']['work_n_field'].value;\n");
      out.write("                        var work_div = document.getElementById('number-work');\n");
      out.write("                        numberschart = work_div.innerHTML = work_field;\n");
      out.write("                        drawVisualization();\n");
      out.write("                        return false;\n");
      out.write("                };\n");
      out.write("\n");
      out.write("                function drawVisualization() {\n");
      out.write("                    // Create and populate the data table.\n");
      out.write("                    var data = new google.visualization.DataTable();\n");
      out.write("                    data.addColumn('string', 'Task');\n");
      out.write("                    data.addColumn('number', 'Hours per Day');\n");
      out.write("                    data.addRows(5);\n");
      out.write("                    data.setValue(0, 0, 'Work');\n");
      out.write("                    //data.setValue(0, 1, 11);\n");
      out.write("                    data.setValue(0, 1, parseInt(numberschart));//<- The value you get from input field is a string, Google API will throw an error\n");
      out.write("                    data.setValue(1, 0, 'Eat');\n");
      out.write("                    data.setValue(1, 1, 2);\n");
      out.write("                    data.setValue(2, 0, 'Commute');\n");
      out.write("                    data.setValue(2, 1, 2);\n");
      out.write("\n");
      out.write("                    // Create and draw the visualization.\n");
      out.write("                    new google.visualization.PieChart(document.getElementById('visualization')).\n");
      out.write("                        draw(data, {\n");
      out.write("                            title:\"Mortgage Rates\",\n");
      out.write("                            colors: ['#a4b12d', '#818e0a', '#5c6601', '#f0fd79', '#dbe864'],\n");
      out.write("                            animation:{\n");
      out.write("                                duration:1000,\n");
      out.write("                                easing: 'out',\n");
      out.write("                            },\n");
      out.write("                            vAxis: {\n");
      out.write("                                minValue:0, \n");
      out.write("                                maxValue:1000\n");
      out.write("                            },\n");
      out.write("                        });\n");
      out.write("                  }    \n");
      out.write("                google.setOnLoadCallback(drawVisualization);\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div id=\"visualization\" style=\"width: 400px; height: 300px;\"></div>\n");
      out.write("        <form name=\"work_form\" onsubmit=\"return false\">\n");
      out.write("            <label id=\"n-work-label\">Work</label><input name=\"work_n_field\"/>\n");
      out.write("            <button name=\"submit\" id=\"submit\" value=\"submit\" onclick=\"numbers();return false;\">Submit</button>\n");
      out.write("        </form>\n");
      out.write("        <div id=\"number-work\"></div>\n");
      out.write("    </body>\n");
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

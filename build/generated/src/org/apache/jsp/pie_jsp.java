package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class pie_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 3.2 Final//EN\">\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("<script language=\"javascript\" src=\"/js/bluff/js-class.js\" type=\"text/javascript\"></script>\n");
      out.write("<script language=\"javascript\" src=\"/js/bluff/bluff-min.js\" type=\"text/javascript\"></script>\n");
      out.write("<!--[if IE]><script language=\"javascript\" src=\"/js/bluff/excanvas.js\" type=\"text/javascript\"></script><![endif]-->\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("   \n");
      out.write("   \n");
      out.write("   window.onload = function () {\n");
      out.write("        i=0;\n");
      out.write("        for (i in data.items) {\n");
      out.write("        data.items[i] = prompt(\"Enter the  variants\");\n");
      out.write("        data.items[i]= parseString(data.items[i]);\n");
      out.write("     }\n");
      out.write("    \n");
      out.write("  //Create pie chart\n");
      out.write("  var bluffGraph = new Bluff.Pie('bluffExample', 400);\n");
      out.write("  //Use keynote theme. Several other themes can be used\n");
      out.write("  bluffGraph.theme_keynote();\n");
      out.write("  bluffGraph.title = 'Status of Jobs';\n");
      out.write(" \n");
      out.write(" for (i in data.items) {\n");
      out.write("    var item = data.items[i];\n");
      out.write("    //Add each data item to pie\n");
      out.write("    bluffGraph.data(item.label, item.data);\n");
      out.write("  }\n");
      out.write("  //Finally draw the chart\n");
      out.write("  bluffGraph.draw();\n");
      out.write("   }\n");
      out.write("</script>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        \n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <canvas id=\"bluffExample\"></canvas>\n");
      out.write("        <h1>Hello World!</h1>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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

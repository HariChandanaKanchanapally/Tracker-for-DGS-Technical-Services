package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class heading_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title></title>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("    <style type=\"text/css\">\n");
      out.write("    .heading {\n");
      out.write("\tfont-family: Verdana, Geneva, sans-serif;\n");
      out.write("\tfont-size: 1.225cm;\n");
      out.write("\tfont-weight: bold;\n");
      out.write("\tcolor: #006;        \n");
      out.write("            }\n");
      out.write("    html\n");
      out.write("            {\n");
      out.write("                overflow:hidden;\n");
      out.write("\n");
      out.write("            }\n");
      out.write("   body\n");
      out.write("            {\n");
      out.write("            background-image:url('gradient.jpg');\n");
      out.write("            background-repeat:repeat-y;\n");
      out.write("            background-size: 100%;\n");
      out.write("            }     \n");
      out.write("    </style>\n");
      out.write("    </head>\n");
      out.write("    <body >\n");
      out.write("    <img src=\"logo.jpg\" width=\"75\" height=\"75\"> \n");
      out.write("    <span class=\"heading\">&nbsp;DGS Technical Services</span>\n");
      out.write("   \n");
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

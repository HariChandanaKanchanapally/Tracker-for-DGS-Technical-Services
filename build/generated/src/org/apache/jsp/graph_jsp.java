package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class graph_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<title>Bar Chart</title>\n");
      out.write("</head>\n");
      out.write("<body bgcolor=white text=black>\n");
      out.write("<table id=graph align=center width=600 cellpadding=0 cellspacing=1 border=0>\n");
      out.write("\n");
      out.write("<tr bgcolor=#C0C0C0>\n");
      out.write("<td align=center valign=bottom width=29>90<br>\n");
      out.write("<div style=' background-color:cyan; width:24; height:100;' />\n");
      out.write("</td>\n");
      out.write("<td align=center valign=bottom width=29>90<br>\n");
      out.write("<div style=' background-color:cyan; width:24; height:90;' />\n");
      out.write("</td>\n");
      out.write("<td align=center valign=bottom width=29>95<br>\n");
      out.write("<div style=' background-color:cyan; width:24; height:95;' />\n");
      out.write("</td>\n");
      out.write("<td align=center valign=bottom width=29>60<br>\n");
      out.write("<div style=' background-color:cyan; width:24; height:60;' />\n");
      out.write("</td>\n");
      out.write("<td align=center valign=bottom width=29>85<br>\n");
      out.write("<div style=' background-color:cyan; width:24; height:85;' />\n");
      out.write("</td>\n");
      out.write("<td align=center valign=bottom width=29>100<br>\n");
      out.write("<div style=' background-color:cyan; width:24; height:100;' />\n");
      out.write("</td>\n");
      out.write("<td align=center valign=bottom width=29>70<br>\n");
      out.write("<div style=' background-color:cyan; width:24; height:70;' />\n");
      out.write("</td>\n");
      out.write("<td align=center valign=bottom width=29>100<br>\n");
      out.write("<div style=' background-color:cyan; width:24; height:100;' />\n");
      out.write("</td>\n");
      out.write("<td align=center valign=bottom width=29>75<br>\n");
      out.write("<div style=' background-color:cyan; width:24; height:75;' />\n");
      out.write("</td>\n");
      out.write("<td align=center valign=bottom width=29>85<br>\n");
      out.write("<div style=' background-color:cyan; width:24; height:85;' />\n");
      out.write("</td>\n");
      out.write("\n");
      out.write("</tr>\n");
      out.write("<tr bgcolor=#C0C0C0>\n");

int id=0;
while(id<10)
{
id=id+1;

      out.write("\n");
      out.write("\n");
      out.write("<td align=center>");
out.println(id);
      out.write("</td>\n");

}

      out.write("\n");
      out.write("</tr>\n");
      out.write("</table>\n");
      out.write("</body>\n");
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

package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class register_005f1_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Register</title>\n");
      out.write("    </head>\n");
      out.write("     <script>\n");
      out.write("            function vali(){\n");
      out.write("                    var pattern=/^([a-zA-Z0-9_.-])+@([a-zA-Z0-9_.-])+\\.([a-zA-Z])+([a-zA-Z])+/;\n");
      out.write("\n");
      out.write("                    if(pattern.test(document.login.email.value)){\n");
      out.write("\n");
      out.write("                       \n");
      out.write("                                         if((login.name.value.length==0))\n");
      out.write("                                                            {\n");
      out.write("                                                                \n");
      out.write("                                                                alert ('Please enter your NAME');\n");
      out.write("                                                                login.name.focus();\n");
      out.write("                                                               return false;\n");
      out.write("                                                            }\n");
      out.write("                                       if((login.doj.value==\"\"))\n");
      out.write("                                                            {\n");
      out.write("\n");
      out.write("                                                                alert ('Please enter your Date of joining');\n");
      out.write("                                                                login.doj.focus();\n");
      out.write("                                                               return false;\n");
      out.write("                                                            }\n");
      out.write("                                       if((login.dob.value==\"\"))\n");
      out.write("                                                            {\n");
      out.write("\n");
      out.write("                                                                alert ('Please enter your Date Of Birth');\n");
      out.write("                                                                login.dob.focus();\n");
      out.write("                                                               return false;\n");
      out.write("                                                            }\n");
      out.write("                                       if((login.gender[0].checked==false)&&(login.gender[1].checked==false))\n");
      out.write("                                        {\n");
      out.write("\n");
      out.write("                                            alert ('Select the Gender');\n");
      out.write("                                            login.gender[0].focus();\n");
      out.write("                                            login.gender[1].focus();\n");
      out.write("                                           return false;\n");
      out.write("                                        }\n");
      out.write("                                       if((login.password.value==\"\"))\n");
      out.write("                                                            {\n");
      out.write("\n");
      out.write("                                                                alert ('Please enter your password');\n");
      out.write("                                                                login.password.focus();\n");
      out.write("                                                               return false;\n");
      out.write("                                                            }\n");
      out.write("                                       if((login.designation.value==\"\"))\n");
      out.write("                                                            {\n");
      out.write("\n");
      out.write("                                                                alert ('Please enter your PHONE');\n");
      out.write("                                                                login.designation.focus();\n");
      out.write("                                                               return false;\n");
      out.write("                                                            }\n");
      out.write("                                       if((login.emptype[0].checked==false)&&(login.emptype[1].checked==false))\n");
      out.write("                                        {\n");
      out.write("\n");
      out.write("                                            alert ('Select Employee Type');\n");
      out.write("                                            login.emptype[0].focus();\n");
      out.write("                                            login.emptype[1].focus();\n");
      out.write("                                           return false;\n");
      out.write("                                        }\n");
      out.write("                                      \n");
      out.write("                        document.forms[0].action();\n");
      out.write("                        return true;\n");
      out.write("                    }\n");
      out.write("\n");
      out.write("                  else{\n");
      out.write("                        alert(\"Enter valid Email ID. Example:xyz123@abc.com\");\n");
      out.write("                       login.email.focus();\n");
      out.write("                        return false;\n");
      out.write("                     }\n");
      out.write("            }\n");
      out.write("                    \n");
      out.write("\n");
      out.write("         \n");
      out.write("              \n");
      out.write("    </script>\n");
      out.write("    </head>\n");
      out.write("    <body Bgcolor =\"#0099cc\">\n");
      out.write("       \n");
      out.write("        <form name=\"login\" action=\"cregister\" method=\"post\" enctype=\"multipart/form-data\" onsubmit=\"return vali()\">\n");
      out.write("                EmpId : <input type=\"text\" size=\"20\" name=\"empid\"><br><br>\n");
      out.write("                \n");
      out.write("                Name : <input type=\"text\" size=\"maxlength\" name=\"name\"><br><br>\n");
      out.write("\n");
      out.write("                            \n");
      out.write("                Gender : \n");
      out.write("                    <input type=\"radio\" name=\"gender\" value=\"male\"><b > Male</b><br>\n");
      out.write("                    <input type=\"radio\" name=\"gender\" value=\"female\"><b>Female</b><br><br>\n");
      out.write("\n");
      out.write("                Date Of Birth :<input type=\"text\" size=\"10\" name=\"dob\"><br><br>\n");
      out.write("                \n");
      out.write("                Date Of Joining :<input type=\"text\" size=\"10\" name=\"doj\"><br><br>\n");
      out.write("                \n");
      out.write("                Designation :<input type=\"text\" name=\"designation\"><br><br>\n");
      out.write("  \n");
      out.write("                Employee Type : \n");
      out.write("                    <input type=\"radio\" name=\"emptype\" value=\"permanent\"><b>Permanent</b><br>\n");
      out.write("                    <input type=\"radio\" name=\"emptype\" value=\"training\"><b>Training</b><br><br>\n");
      out.write("\n");
      out.write("                Email : <input type=\"text\" size=\"maxlength\" name=\"email\"><br><br>\n");
      out.write("\n");
      out.write("               Password :<input type=\"password\" size=\"maxlength\" name=\"password\"><br><br>\n");
      out.write("              \n");
      out.write("               \n");
      out.write("               ");
      out.write("\n");
      out.write("                <input type=\"submit\" value=\"submit\">\n");
      out.write("\n");
      out.write("\n");
      out.write("            </form>      \n");
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

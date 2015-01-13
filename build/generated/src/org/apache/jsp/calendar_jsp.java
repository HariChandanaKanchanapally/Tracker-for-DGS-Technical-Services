package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.*;
import java.text.*;

public final class calendar_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


public int nullIntconv(String inv)
{   
    int conv=0;
        
    try{
        conv=Integer.parseInt(inv);
    }
    catch(Exception e)
    {}
    return conv;
}

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
      out.write("\n");
      out.write("\n");
      out.write('\n');

 int iYear=nullIntconv(request.getParameter("iYear"));
 int iMonth=nullIntconv(request.getParameter("iMonth"));

 Calendar ca = new GregorianCalendar();
 int iTDay=ca.get(Calendar.DATE);
 int iTYear=ca.get(Calendar.YEAR);
 int iTMonth=ca.get(Calendar.MONTH);

 if(iYear==0)
 {
      iYear=iTYear;
      iMonth=iTMonth;
 }

 GregorianCalendar cal = new GregorianCalendar (iYear, iMonth, 1); 

 int days=cal.getActualMaximum(Calendar.DAY_OF_MONTH);
 int weekStartDay=cal.get(Calendar.DAY_OF_WEEK);
 
 cal = new GregorianCalendar (iYear, iMonth, days); 
 int iTotalweeks=cal.get(Calendar.WEEK_OF_MONTH);
  

      out.write("\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<title>How to create Calendar in JSP</title>\n");
      out.write("<script>\n");
      out.write("    s=\"\";\n");
      out.write("        function fdate(bv)\n");
      out.write("        {\n");
      out.write("             if(s.length<10)\n");
      out.write("                 {\n");
      out.write("            document.frm.fromdate.value =s+\"/\"+bv;\n");
      out.write("            s=document.frm.fromdate.value;\n");
      out.write("                 }\n");
      out.write("            \n");
      out.write("            \n");
      out.write("        } \n");
      out.write("          s=\"\"\n");
      out.write("          function tdate(bv)\n");
      out.write("        {\n");
      out.write("               \n");
      out.write("            document.frm.todate.value =s+\"/\"+bv;\n");
      out.write("            s=document.frm.todate.value;\n");
      out.write("            \n");
      out.write("            \n");
      out.write("            \n");
      out.write("        } \n");
      out.write("          \n");
      out.write("function goTo()\n");
      out.write("{\n");
      out.write("  document.frm.submit()\n");
      out.write("}\n");
      out.write("</script>\n");
      out.write("<style>\n");
      out.write("body\n");
      out.write("{\n");
      out.write(" font-family:Verdana, Arial, Helvetica, sans-serif\n");
      out.write("}\n");
      out.write(".dsb\n");
      out.write("{\n");
      out.write(" background-color:#EEEEEE\n");
      out.write("}\n");
      out.write("</style>\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("<form name=\"frm\" method=\"post\">\n");
      out.write("<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n");
      out.write("  <tr>\n");
      out.write("    <td width=\"25%\">&nbsp;</td>\n");
      out.write("    <td width=\"45%\">&nbsp;</td>\n");
      out.write("    <td width=\"30%\">&nbsp;</td>\n");
      out.write("  </tr>\n");
      out.write("  <tr>\n");
      out.write("    <td>&nbsp;</td>\n");
      out.write("    <td><table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n");
      out.write("  <tr>\n");
      out.write("    <td><table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n");
      out.write("      <tr>\n");
      out.write("        <td width=\"6%\">Year</td>\n");
      out.write("        <td width=\"7%\">\n");
      out.write("        <select name=\"iYear\" id=\"selectBox\" onChange=\"fdate(selectBox.options[selectBox.selectedIndex].value); goTo()\">\n");
      out.write("           \n");
      out.write("        \n");
      out.write("        <option value=\" \" selected=\"selected\">Select</option>\n");
      out.write("        ");

            // start year and end year in combo box to change year in calendar
        for(int iy=iTYear-70;iy<=iTYear+70;iy++)
        {
          if(iy==iYear)
          {
            
      out.write("\n");
      out.write("          <option value=\"");
      out.print(iy);
      out.write("\" onclick=\"fdate(");
      out.print( iy);
      out.write(")\" >");
      out.print(iy);
      out.write("</option>\n");
      out.write("          ");

          }
          else
          {
            
      out.write("\n");
      out.write("          <option value=\"");
      out.print(iy);
      out.write("\" onclick=\"fdate(");
      out.print( iy);
      out.write(")\">");
      out.print(iy);
      out.write("</option>\n");
      out.write("          ");

          }
        }
       
      out.write("\n");
      out.write("        </select></td>\n");
      out.write("        <td width=\"73%\" align=\"center\" style=\"color:#4E96DE\"><h3>");
      out.print(new SimpleDateFormat("MMMM").format(new Date(2008,iMonth,01)));
      out.write(' ');
      out.print(iYear);
      out.write("</h3></td>\n");
      out.write("        <td width=\"6%\">Month</td>\n");
      out.write("        <td width=\"8%\">\n");
      out.write("           \n");
      out.write("        <select name=\"iMonth\" id=\"selectMonth\" onChange=\"fdate(selectMonth.options[selectMonth.selectedIndex].value); goTo();\">\n");
      out.write("         <option value=\" \" selected=\"selected\">Select</option>\n");
      out.write("            ");

        // print month in combo box to change month in calendar
        for(int im=0;im<=11;im++)
        {
  
          if(im==iMonth)
          {
         
      out.write("\n");
      out.write("         <option value=\"");
      out.print(im);
      out.write("\" onclick=\"fdate(");
      out.print( im);
      out.write(")\">");
      out.print(new SimpleDateFormat("MMMM").format(new Date(2008,im,01)));
      out.write("</option>\n");
      out.write("          ");

          }
          else
          {
            
      out.write("\n");
      out.write("          <option value=\"");
      out.print(im);
      out.write("\" onclick=\"fdate(");
      out.print( im);
      out.write(")\">");
      out.print(new SimpleDateFormat("MMMM").format(new Date(2008,im,01)));
      out.write("</option>\n");
      out.write("          ");

          }
        }
       
      out.write("\n");
      out.write("        </select></td>\n");
      out.write("      </tr>\n");
      out.write("    </table></td>\n");
      out.write("  </tr>\n");
      out.write("  <tr>\n");
      out.write("    <td><table align=\"center\" border=\"1\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\">\n");
      out.write("      <tbody>\n");
      out.write("        <tr>\n");
      out.write("          <th>Sun</th>\n");
      out.write("          <th>Mon</th>\n");
      out.write("          <th>Tue</th>\n");
      out.write("          <th>Wed</th>\n");
      out.write("          <th>Thu</th>\n");
      out.write("          <th>Fri</th>\n");
      out.write("          <th>Sat</th>\n");
      out.write("        </tr>\n");
      out.write("        ");

        int cnt =1;
        for(int i=1;i<=iTotalweeks;i++)
        {
        
      out.write("\n");
      out.write("        <tr>\n");
      out.write("          ");
 
            for(int j=1;j<=7;j++)
            {
                if(cnt<weekStartDay || (cnt-weekStartDay+1)>days)
                {
                 
      out.write("\n");
      out.write("                <td align=\"center\" height=\"35\" class=\"dsb\">&nbsp;</td>\n");
      out.write("               ");
 
                }
                else
                {
                 
      out.write("\n");
      out.write("                 \n");
      out.write("                 <td align=\"center\" height=\"35\" id=\"");
      out.print( (cnt-weekStartDay+1));
      out.write("\">\n");
      out.write("                 <span> \n");
      out.write("                     <input type=\"button\" name=\"date\" value=\"");
      out.print( (cnt-weekStartDay+1));
      out.write("\" onclick=\"fdate(");
      out.print( (cnt-weekStartDay+1));
      out.write(")\" id=\"button1\">\n");
      out.write("                 </span>\n");
      out.write("                </td>\n");
      out.write("                 \n");
      out.write("                 \n");
      out.write("                 \n");
      out.write("                 ");
 
                }
                cnt++;
              }
            
      out.write("\n");
      out.write("                 \n");
      out.write("        </tr>\n");
      out.write("        ");
 
        }
        
      out.write("\n");
      out.write("      </tbody>\n");
      out.write("    </table></td>\n");
      out.write("        \n");
      out.write("  </tr>\n");
      out.write("</table></td>\n");
      out.write("    <td>&nbsp;</td>\n");
      out.write("  </tr>\n");
      out.write("  <tr>\n");
      out.write("    <td>&nbsp;</td>\n");
      out.write("    <td>&nbsp;</td>\n");
      out.write("    <td>&nbsp;</td>\n");
      out.write("  </tr>\n");
      out.write("</table>\n");
      out.write("\n");
      out.write("      From date<input type=\"text\" name=\"fromdate\">\n");
      out.write("      \n");
      out.write("</form>\n");
      out.write("</body>\n");
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

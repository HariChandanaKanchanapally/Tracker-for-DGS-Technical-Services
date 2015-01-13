/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Acer
 */
@WebServlet(name = "ceditform", urlPatterns = {"/ceditform"})
public class ceditform extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
   protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
           Class.forName("oracle.jdbc.OracleDriver");
                           out.println("hi1");

            Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","chandana");
                        out.println("hi2");
             PreparedStatement ps = con.prepareStatement("select * from employer");
            ResultSet rs = ps.executeQuery();
            String sess_email;
             HttpSession session=request.getSession(true);
             out.println("The email"+session.getAttribute("email"));
             sess_email=session.getAttribute("email").toString();
             out.println("<head>");
             
             out.println("<script>");
             out.println("function vali(){");
             
            //out.println("var x=document.getElementById(\"submitd\").value");
            //out.println("printf(\"%s\",x)");
                   out.println("if((edit.editp.name=='true')){");
                   out.println("dispedit.password.focus();}");
                   out.println("if(()){");
                   out.println("dispedit.designation.focus();}");                                       
                   out.println("if((edit.editemp.name))");
                   out.println("{");
                   out.println("dispedit.emptype[0].focus();");
                   out.println("dispedit.emptype[1].focus();");
                   out.println("   return false;");
                   out.println("}");
              out.println("}");
              out.println(" </script>");
            while ( rs.next()) {
              if(sess_email == null ? rs.getString(8) == null : sess_email.equals(rs.getString(8)))
              {
                  out.println("<body>");
                  out.println("<form name='dispedit' action='ceditregister' method='post'>");
              
                   out.println("<h4><br>EMPID: <input type='text' value='"+rs.getString(1)+"' name='empid' ");
                   out.println("<br><h4>NAME: <input type='text' value='"+rs.getString(2)+"' name='name'");
                   out.println("<h4><br>GENDER:<input type='text' value='"+rs.getString(3)+"' name='gender'");
                   out.println("<h4><br>DOB:<input type='text' value='"+rs.getString(4)+"' name='dob'");
                   out.println("<h4><br>DOJ:<input type='text' value='"+rs.getString(5)+"' name='doj'");
                   out.println("<h4><br>DESIGNATION:<input type='text' value='"+rs.getString(6)+"' name='designation'");
                   out.println("<h4><br>EMPTYPE: <input type='text' value='"+rs.getString(7)+"' name='emptype'");
                   out.println("<h4><br>EMAIL:<input type='text' value='"+rs.getString(8)+"' name='email'");
                   out.println("<h4><br>PASSWORD: <input type='text' value='"+rs.getString(9)+"' name='password'");
                   out.println("<br><input type='submit' value='Edit' name='Edit'>");
                   out.println("</form>");
                   out.println("</body>");
                    
                    
                    }
            
                  /*out.println("<h4>" + rs.getString("name") + "</h4>");
                  out.println("<img width='600' height='600' src='displayphoto'></img> <p/>");
                  out.println("<h4>" + rs.getString("empid") + "</h4>");
                  */
            }

            con.close();
        }
        catch(Exception ex) {

        }
        finally { 
            out.close();
        }
    } 

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }
}
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
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Acer
 */
@WebServlet(name = "cjoblist", urlPatterns = {"/cjoblist"})
public class cjoblist extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
             Class.forName("oracle.jdbc.OracleDriver");
                            

            Connection connection= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","chandana");
                          
                          
            String fstatus=request.getParameter("status");      
            String fphase=request.getParameter("phase");
            String fjob=request.getParameter("job");
           
            
            PreparedStatement ps =connection.prepareStatement
                    ("update jobs set status=?,progress=? where jobid=? ");
            ResultSet rs=null;
          
            
            ps.setString(1,fstatus);
            ps.setString(2,fphase);
            ps.setString(3,fjob);
            
             // size must be converted to int otherwise it results in error
 //           ps.setBinaryStream(10, file.getInputStream(), (int)file.getSize());
     
      

            int n=ps.executeUpdate();

            
         

            out.println("<html>");
            out.println("<head>");
            out.println("<title>Joblist</title>");
            out.println("<style>");
            out.println(".profiledec{color:black;font-style:normal;font-family:verdana;font-size:15pt;}");
            out.println(".profiledec1{color:lightgreen;font-style:normal;font-family:Arial;font-size:15pt;}");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<br><br><br>");
            out.println("<p class='profiledec'>Status of the job has been updated. This will be notified to the manager.</p>");
            out.println( "<p class='profiledec'>Status message is:The job "+fjob+" has a "+fstatus+" status and is in "+fphase+" phase</p>");
            out.println("<br><br><a href='notificationse.jsp'><img src='back.jpg' height='75' width='75'></a>");
            out.println("</body>");
            out.println("</html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet cjoblist</title>");            
            out.println("</head>");
 
            
            out.println("</html>");
        } catch (SQLException ex) {
            Logger.getLogger(cjoblist.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(cjoblist.class.getName()).log(Level.SEVERE, null, ex);
        } finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}

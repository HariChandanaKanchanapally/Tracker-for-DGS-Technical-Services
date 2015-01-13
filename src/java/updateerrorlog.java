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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author shruthibalki
 */
public class updateerrorlog extends HttpServlet {

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
            
            
             
        try {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            Class.forName("oracle.jdbc.OracleDriver");

            Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","chandana");
                   
            String fjobid = request.getParameter("jobid");     
            out.println(fjobid);
            
            PreparedStatement ps = con.prepareStatement("select * from errorlog where jobid = '"+fjobid+"'");
            ResultSet rs = ps.executeQuery();
            
               while ( rs.next()) {
                   
                   out.println("<body>");
                   out.println("<form action='cediterrorlog' method='post'>");
                   out.println("<h4>Job ID : <input type='text' value='"+rs.getString(1)+"' name='jobid' ");
                   out.println("<br><h4>Job Specification : <textarea name='jobspecification' rows='5' cols='50' placeholder='"+rs.getString(2) +"'></textarea>");
                   out.println("<h4>Error Occured : <textarea name='erroroccured' rows='5' cols='50' placeholder='"+rs.getString(3) +"'></textarea>");
                   out.println("<h4>Solution : <textarea name='solution' rows='5' cols='50' placeholder='"+rs.getString(4) +"'></textarea>");
                   
                   out.println("<input type='submit' value='Done' name = 'Edit'>"); 
                   out.println("</form>");
                  /*out.println("<h4>" + rs.getString("name") + "</h4>");
                  out.println("<img width='600' height='600' src='displayphoto'></img> <p/>");
                  out.println("<h4>" + rs.getString("empid") + "</h4>");
                  */
            }

            

          
        
         
    try {
        /* TODO output your page here. You may use following sample code. */
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet updateerrorlog</title>");            
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Servlet updateerrorlog at " + request.getContextPath() + "</h1>");
        out.println("</body>");
        out.println("</html>");
    } finally {            
        out.close();
    }
}       catch (SQLException ex) {
            Logger.getLogger(updateerrorlog.class.getName()).log(Level.SEVERE, null, ex);
        }       catch (ClassNotFoundException ex) {
            Logger.getLogger(updateerrorlog.class.getName()).log(Level.SEVERE, null, ex);
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

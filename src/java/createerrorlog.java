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
public class createerrorlog extends HttpServlet {

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
    response.setContentType("text/html;charset=UTF-8");

Class.forName("oracle.jdbc.OracleDriver");
                     out.println("hi1");

    Connection connection= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","chandana");
                  out.println("hi2");
    
    String fjobid = request.getParameter("jobid");
    String fjobspecification = request.getParameter("jobspecification");
    String ferroroccured = request.getParameter("erroroccured");
    String fsolution = request.getParameter("solution");
      
    PreparedStatement ps =connection.prepareStatement
                ("insert into errorlog (JOBID , JOBSPECIFICATION , ERROROCCURED , SOLUTION) values(?,?,?,?)");
        ResultSet rs=null;
        out.println("114");
        
        
        ps.setString(1,fjobid);
        ps.setString(2,fjobspecification);
        ps.setString(3,ferroroccured);
        ps.setString(4,fsolution);
        
        int n=ps.executeUpdate();
    try {
        /* TODO output your page here. You may use following sample code. */
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet createerrorlog</title>");            
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Servlet createerrorlog at " + request.getContextPath() + "</h1>");
        out.println("</body>");
        out.println("</html>");
    } finally {            
        out.close();
    }
}       catch (SQLException ex) {
            Logger.getLogger(createerrorlog.class.getName()).log(Level.SEVERE, null, ex);
        }       catch (ClassNotFoundException ex) {
            Logger.getLogger(createerrorlog.class.getName()).log(Level.SEVERE, null, ex);
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

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
import javax.servlet.http.HttpSession;

/**
 *
 * @author Acer
 */
public class cjobprogress extends HttpServlet {

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
        
            /* TODO output your page here. You may use following sample code. */
            
            
            String sess_email;
             HttpSession session=request.getSession(true);
             
            // out.println("The email"+session.getAttribute("email"));
             sess_email=session.getAttribute("email").toString();
        
             
            try
            {
             
                Class.forName("oracle.jdbc.OracleDriver");
                           //out.println("hi1");

                Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","chandana");
                       // out.println("hi2");
                
              PreparedStatement ps0 = con.prepareStatement("select email from employer where designation='manager' ");
            ResultSet rs0 = ps0.executeQuery(); 
                        while ( rs0.next()) {
              
                   out.println("<h4>ALL EMAIL ID"+rs0.getString(1));
                 
                  
                  if(rs0.getString(1).equalsIgnoreCase(sess_email))  
                  {
                 
            
               
                PreparedStatement ps = con.prepareStatement("select jobid,jobname,est_time,act_time,deadline,status,teamname,startdate from jobs ");
            ResultSet rs = ps.executeQuery(); 
            
             while ( rs.next()) {
              
                   out.println("<h4>JOBID"+rs.getString(1));
                   out.println("<br><h4>JOBNAME"+rs.getString(2));
                   out.println("<h4>EST_TIME"+rs.getString(3));
                   out.println("<h4>ACT_TIME"+rs.getString(4));
                   out.println("<h4>DEADLINE"+rs.getString(5));
                   out.println("<h4>DESIGNATION"+rs.getString(6));
                   out.println("<h4>STATUS"+rs.getString(7));
                   out.println("<h4>PROJECT MANAGER"+rs.getString(8));
                   out.println("<h4>TEAMNAME"+rs.getString(9));
                   out.println("<h4>STARTDATE"+rs.getString(10));
                   out.println("<h4>PROGRESS:" );
                  
                    
                    }
                 
            
            }      }
            }
            catch (SQLException ex) {
                        Logger.getLogger(cnotifications.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    catch (ClassNotFoundException ex) {
                        Logger.getLogger(cnotifications.class.getName()).log(Level.SEVERE, null, ex);
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
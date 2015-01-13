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
 * @author shruthibalki
 */
public class cleavesm extends HttpServlet {

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
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
         
             Class.forName("oracle.jdbc.OracleDriver");
            
            Connection connection = null;
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","chandana");
                       
           
HttpSession session=request.getSession(true);
           //  out.println("The email"+session.getAttribute("email"));
           String  sess_email=session.getAttribute("email").toString();
            String fdecision = request.getParameter("decision");
            
            String fempid = request.getParameter("empid");
           
             
          PreparedStatement ps;
             ps =connection.prepareStatement
                    ("update datepicker set decision=? where empid=?");
              
             ResultSet rs=null;   
                      
            ps.setString(1,fdecision);
            ps.setString(2,fempid);
            
            
                     
                   
                      
                      int n = ps.executeUpdate();
                      


            out.println("<html>");
            out.println("<head>");
            out.println("<title>Leaves</title>");
            out.println("<style>");
            out.println(".profiledec{color:yellow;font-style:normal;font-family:Arial;font-size:15pt;}");
            out.println(".profiledec1{color:lightgreen;font-style:normal;font-family:Arial;font-size:15pt;}");
            out.println("</style>");
            out.println("</head>");
            out.println("<body bgcolor='black'>");
            out.println("<h1 class='profiledec'>Your decision has been notified to your employer</h1>");

           
           
          
        } catch (SQLException ex) {
            Logger.getLogger(cdatepicker.class.getName()).log(Level.SEVERE, null, ex);
            out.println("error in conn");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(cdatepicker.class.getName()).log(Level.SEVERE, null, ex);
            out.println("err in other");
        } finally {
            out.close();
        }
    } 

}
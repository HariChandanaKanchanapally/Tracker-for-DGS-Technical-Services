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
 * @author Acer
 */
public class cperformance extends HttpServlet {

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
                            

            Connection connection= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","chandana");
                      
                          
                          
            String frating=request.getParameter("rating");
            String fempid=request.getParameter("empid");
 
            PreparedStatement ps =connection.prepareStatement
                    ("MERGE INTO chart c USING (SELECT 1 empid, 'x' rating from dual) s ON (c.empid = s.empid) WHEN MATCHED THEN UPDATE SET c.rating = s.rating WHEN NOT MATCHED THEN INSERT (empid, rating) VALUES (?,?); ");
            ResultSet rs=null;

            
            ps.setString(1,fempid);
            ps.setString(2,frating);
           
           out.println("After setstring");             
   

            int n=ps.executeUpdate();
            

            

            out.println("<html>");
            out.println("<head>");
            out.println("<title>Registeration</title>");
            out.println("<style>");
            out.println(".profiledec{color:yellow;font-style:normal;font-family:Arial;font-size:15pt;}");
            out.println(".profiledec1{color:lightgreen;font-style:normal;font-family:Arial;font-size:15pt;}");
            out.println("</style>");
            out.println("</head>");
            out.println("<body bgcolor='blue'>");
            out.println("<h1 class='profiledec'>Rating Updated!!!!!!</h1>");
          // out.println("  <a href='chart.jsp' >Create a performance chart </a>");
           
            out.println("<h1>Servlet register at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        
            
        } catch (SQLException ex) {
            Logger.getLogger(cregister.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(cregister.class.getName()).log(Level.SEVERE, null, ex);
        } finally {            
            out.close();
        }
    }
}

    
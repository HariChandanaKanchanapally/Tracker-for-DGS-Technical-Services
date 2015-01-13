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
public class editnote extends HttpServlet {

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
                      
            Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","chandana");
                       
             String fnote = request.getParameter("note");           
             PreparedStatement ps = con.prepareStatement("select * from todonotes where note = '"+fnote+"'");
             ResultSet rs = ps.executeQuery();
            
            /* if(n!=0){
                    int rs1=0;
                    
                     }*/
             while(rs.next()){
                       
                        
                        out.println("<form  action='editnotes' method='post'>");
                        out.println("<textarea name='notes' rows='5' cols='50' placeholder='"+rs.getString(2) +"'></textarea>");
                        out.println("<input type='hidden' name ='note' value='"+rs.getString(2) +"'> ");
                        out.println("<input type='submit' value='Edit Note'>"); 
                        out.println("</form>");
                 
                             }
            
            
             
            
                    }
            
                  /*out.println("<h4>" + rs.getString("name") + "</h4>");
                  out.println("<img width='600' height='600' src='displayphoto'></img> <p/>");
                  out.println("<h4>" + rs.getString("empid") + "</h4>");
                  */
            

         catch (SQLException ex) {
            Logger.getLogger(editnote.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(editnote.class.getName()).log(Level.SEVERE, null, ex);
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

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author shruthibalki
 */
public class cregister extends HttpServlet {

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
            
             // Apache Commons-Fileupload library classes
            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload sfu  = new ServletFileUpload(factory);

            if (! ServletFileUpload.isMultipartContent(request)) {
                System.out.println("sorry. No file uploaded");
                return;
            }

           
            
           //connections 
            Class.forName("oracle.jdbc.OracleDriver");
                             out.println("hi1");

            Connection connection= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","chandana");
                          out.println("hi2");
                          
             // parse request
           List items = sfu.parseRequest(request);
            
            
            FileItem empid = (FileItem) items.get(0);
            String   fempid =  empid.getString();
            
            FileItem name = (FileItem) items.get(1);
            String   fname =  name.getString();
           
                      
             FileItem gender = (FileItem) items.get(2);
            String   fgender =  gender.getString();
            
             FileItem dob = (FileItem) items.get(3);
            String   fdob =  dob.getString();
            
            FileItem doj = (FileItem) items.get(4);
            String  fdoj  =  doj.getString();
           
                  
             FileItem designation = (FileItem) items.get(5);
            String   fdesignation =  designation.getString();
            
            FileItem emptype = (FileItem) items.get(6);
            String   femptype =  emptype.getString();
            
           
            FileItem email = (FileItem) items.get(7);
            String   femail =  email.getString();

            FileItem password = (FileItem) items.get(8);
            String   fpassword =  password.getString();
       
              
          out.println("13");
          
          

            PreparedStatement ps =connection.prepareStatement
                    ("insert into EMPLOYER (EMPID ,NAME ,GENDER ,DOB ,DOJ ,DESIGNATION ,EMPTYPE ,EMAIL,PASSWORD) values(?,?,?,?,?,?,?,?,?)");
            ResultSet rs=null;
            out.println("114");
            
            ps.setString(1,fempid);
            ps.setString(2,fname);
            ps.setString(3,fgender);
            ps.setString(4,fdob);
            ps.setString(5,fdoj);
            ps.setString(6,fdesignation);
            ps.setString(7,femptype);
            ps.setString(8,femail);
            ps.setString(9,fpassword);
             
            out.println("115");

            int n=ps.executeUpdate();
            
            out.println(n);
            out.println("16");

            out.println("<html>");
            out.println("<head>");
            out.println("<title>Registeration</title>");
            out.println("<style>");
            out.println(".profiledec{color:yellow;font-style:normal;font-family:Arial;font-size:15pt;}");
            out.println(".profiledec1{color:lightgreen;font-style:normal;font-family:Arial;font-size:15pt;}");
            out.println("</style>");
            out.println("</head>");
            out.println("<body bgcolor='blue'>");
            out.println("<h1 class='profiledec'>REGISTERATION COMPLETE!!!!!!</h1>");
            out.println("<h1>Servlet register at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } catch (FileUploadException ex) {
            Logger.getLogger(cregister.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(cregister.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(cregister.class.getName()).log(Level.SEVERE, null, ex);
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

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author shruthibalki
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.*;
import javax.servlet.http.*;


/**
 *
 * @author Muser01
 */
public class sessionAction extends HttpServlet {
   
    
    
   
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        RequestDispatcher dispatcher;
        try {
                
            
                Class.forName("oracle.jdbc.OracleDriver");
                      

                Connection connection= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","chandana");
                          

                
                String uemail=request.getParameter("email");
                String pass=request.getParameter("Password");
                Boolean srows=false;
                                   

                PreparedStatement ps=connection.prepareStatement("select EMAIL,PASSWORD,DESIGNATION from EMPLOYER");
                ResultSet rs=ps.executeQuery();
                                  

                int flag=0;
                int n=1;
                while(rs.next())
                {

                    String userName=rs.getString("EMAIL");
                   String passwrd=rs.getString("PASSWORD");
                   String design=rs.getString("DESIGNATION");
                  
                   if((userName.equals(uemail))&&(passwrd.equals(pass))){
                       HttpSession session=request.getSession(true);
                      session.setAttribute("email", uemail);
                      session.getAttribute( "email" );  
                      if(design.equalsIgnoreCase("manager")){
                          
                          dispatcher=request.getRequestDispatcher("manager_main.html");
                                        dispatcher.forward(request, response);
                      }
                      else{
                          dispatcher=request.getRequestDispatcher("employer_main.html");
                                        dispatcher.forward(request, response);
                      }
                     
                   }
                }
                 
                       
                       
dispatcher =request.getRequestDispatcher("/logined1.html");
dispatcher.include(request, response);
 out.println("<p align='center'><font face='verdana' size='5' color='red'> Wrong Email or Password</font></p>");
               
                out.close();
        
             } catch (ClassNotFoundException ex) {
            Logger.getLogger(sessionAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (SQLException ex) {
            Logger.getLogger(sessionAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class cviewprofile extends HttpServlet {
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
         RequestDispatcher dispatcher;
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
        
            while ( rs.next()) {
              if(sess_email == null ? rs.getString(8) == null : sess_email.equals(rs.getString(8)))
              {
                  out.println("<p align='center'><font face='verdana' size='5' color='red'>");
                   out.println("EMPID"+rs.getString(1));
                   out.println("<br>NAME"+rs.getString(2));
                   out.println("<br>GENDER"+rs.getString(3));
                   out.println("<br>DOB"+rs.getString(4));
                   out.println("<br>DOJ"+rs.getString(5));
                   out.println("<br>DESIGNATION"+rs.getString(6));
                  /* out.println("<form  action='ceditform' method='post' name='edit'>");
                   out.println("<input type='submit' id='submitd' value='edit designation' name='editd'>"); 
                  */ out.println("<br>EMPTYPE"+rs.getString(7));
                  // out.println("<input type='button' id='submitemp' value='edit' name='editemp' onclick='openPage(\"editregister.jsp\")'>"); 
                   out.println("<br>EMAIL"+rs.getString(8));
                   //out.println("<input type='button' id='submite' value='edit' name='edite' onclick='openPage(\"editregister.jsp\")'>");  
                   out.println("<br>PASSWORD"+rs.getString(9));
                  // out.println("<input type='button' id='submitp' value='edit' name='editp' onclick='openPage(\"editregister.jsp\")'>"); 
                    //out.println("</form>");
                    //out.println("<script type='text/javascript'>");
                    //out.println("function openPage(pageURL){");
                    
                    //out.println("window.location.href = pageURL}");
                    
                   //]+\ out.println("</script>");
                   out.println("</font></p>");
                    
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
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author shruthibalki
 */
public class ccreatejob extends HttpServlet {

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
                            

            Connection connection= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","chandana");
                         
             // parse request
           List items = sfu.parseRequest(request);
            
            
            FileItem id = (FileItem) items.get(0);
            String   fjobid =  id.getString();
            
            FileItem name = (FileItem) items.get(1);
            String   fname =  name.getString();
           
                      
             FileItem est_time = (FileItem) items.get(2);
            String   fest_time =  est_time.getString();
            
             FileItem act_time = (FileItem) items.get(3);
            String   fact_time =  act_time.getString();
            
            FileItem deadline = (FileItem) items.get(4);
            String  fdeadline  =  deadline.getString();
           
            FileItem projmgr = (FileItem) items.get(5);
            String   fprojmgr =  projmgr.getString();
            
             FileItem teamname = (FileItem) items.get(6);
            String   fteamname =  teamname.getString();
            
            FileItem startdate = (FileItem) items.get(7);
            String  fstartdate  =  startdate.getString();
           
                  
             
            PreparedStatement ps =connection.prepareStatement
                    ("insert into JOBS (JOBID ,JOBNAME ,EST_TIME,ACT_TIME,DEADLINE,PROJMGR,TEAMNAME,STARTDATE) values(?,?,?,?,?,?,?,?)");
            ResultSet rs=null;
     
            
            ps.setString(1,fjobid);
            ps.setString(2,fname);
            ps.setString(3,fest_time);
            ps.setString(4,fact_time);
            ps.setString(5,fdeadline);
            ps.setString(6,fprojmgr);
            ps.setString(7,fteamname);
            ps.setString(8,fstartdate);
            
             // size must be converted to int otherwise it results in error
 //           ps.setBinaryStream(10, file.getInputStream(), (int)file.getSize());
     
      

            int n=ps.executeUpdate();

           
           

            out.println("<html>");
            out.println("<head>");
            out.println("<title>Job Creation</title>");
            out.println("<style>");
            out.println(".profiledec{color:black;font-style:normal;font-family:verdana;font-size:15pt;}");
            out.println(".profiledec1{color:lightgreen;font-style:normal;font-family:Arial;font-size:15pt;}");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1 class='profiledec'><br><br>Requested Job has been added to the database. Respective Project manager will be notified.</h1>");
          //  out.println("<h1>Servlet register at " + request.getContextPath() + "</h1>");
            
            //Object value = request.getSession().getAttribute("email");
            //Sending notification to employer
            //out.println(value.toString());
          
            connection.close();
        }
        catch(Exception ex) {

        }
        finally { 
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

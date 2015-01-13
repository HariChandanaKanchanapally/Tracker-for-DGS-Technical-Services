/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author shruthibalki
 */
public class displayphoto extends HttpServlet {

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
                        
             String fid = request.getParameter("empid");
            
             PreparedStatement ps = con.prepareStatement("select photo from employer where empid = '"+fid+"'");
                                   

            ResultSet rs = ps.executeQuery();
            out.println("hi4");
            
            String contentType = request.getContentType();
	//here we are checking the content type is not equal to Null and as well as the passed data from mulitpart/form-data is greater than or equal to 0
	if ((contentType != null) && (contentType.indexOf("multipart/form-data") >= 0)) 
	{
 		DataInputStream in = new DataInputStream(request.getInputStream());
		//we are taking the length of Content type data
		int formDataLength = request.getContentLength();
		byte dataBytes[] = new byte[formDataLength];
		int byteRead;
                byteRead = 0;
		int totalBytesRead = 0;
		//this loop converting the uploaded file into byte code
		while (totalBytesRead < formDataLength) {
			byteRead = in.read(dataBytes, totalBytesRead, formDataLength);
			totalBytesRead += byteRead;
			}

		String file = new String(dataBytes);
		//for saving the file name
		String saveFile = file.substring(file.indexOf("filename=\"") + 10);
		saveFile = saveFile.substring(0, saveFile.indexOf("\n"));
		saveFile = saveFile.substring(saveFile.lastIndexOf("\\") + 1,saveFile.indexOf("\""));
		int lastIndex = contentType.lastIndexOf("=");
		String boundary = contentType.substring(lastIndex + 1,contentType.length());
		int pos;
		//extracting the index of file 
		pos = file.indexOf("filename=\"");
		pos = file.indexOf("\n", pos) + 1;
		pos = file.indexOf("\n", pos) + 1;
		pos = file.indexOf("\n", pos) + 1;
		int boundaryLocation = file.indexOf(boundary, pos) - 4;
		int startPos = ((file.substring(0, pos)).getBytes()).length;
		int endPos = ((file.substring(0, boundaryLocation)).getBytes()).length;
        saveFile="d:/" + saveFile;
		// creating a new file with the same name and writing the content in new file
		FileOutputStream fileOut = new FileOutputStream(saveFile);
		fileOut.write(dataBytes, startPos, (endPos - startPos));
		fileOut.flush();
		fileOut.close();

            /*
            response.setContentType("image/jpeg");
            response.setContentLength( (int) b.length());
            InputStream is = b.getBinaryStream();
            OutputStream os = response.getOutputStream();
            byte buf[] = new byte[(int) b.length()];
            is.read(buf);
            os.write(buf);
            out.println("after os");
           out.println("<img border='1' src='<%response.getOutputStream().write(buf);%>' width='10' height='10'>");  
            
             /*Blob blob = rs.getBlob("photo");
              
           out.println(blob.getBytes(1, (int) blob.length);
           */
           /*
            
            Blob photo = rs.getBlob("photo");
            out.println("After blob declaration");
            InputStream in=photo.getBinaryStream();             
            int len;              
                    len = (int) photo.length();
            int bufferSize = 1024;             
            byte[] buffer = new byte[bufferSize];   
    
            while ((in.read(buffer)) != -1) {                
            System.out.println("writing " + len+ " bytes");                 
            response.setContentType("image/jpg");
            
                    response.getOutputStream().write(buffer,0,len);
                    
                    out.println("<img border='1' src='<%response.getOutputStream().write(buf);%>' width='10' height='10'>");  
                    } 
               */   
           //rs.next();
          /*  ServletOutputStream sos=response.getOutputStream();

while(rs.next()) {
    byte[] buffer=new byte[1];

    InputStream is=rs.getBinaryStream(1);
    while(is.read(buffer)>0){
      sos.write(buffer);
}
sos.println();
sos.flush();*/
            
             out.println("<input name='saveFile' type'text' id='saveFile' value='saveFile'>");
             
                     
}
/*            
            out.println("hi5");
            
            Blob  b = rs.getBlob("photo");
            out.println("hi5.5");            
            response.setContentType("image/jpeg");
           // response.setContentLength( (int) b.length());
            byte[] bytearray = new byte[(int)b.length()];
            out.println("hi6");
            int size;
            InputStream image;
            image = rs.getBinaryStream(1);
             
            out.println("hi7");
            //response.reset();
            response.setContentType("image/jpg");
            while((size=image.read(bytearray,0,(int)b.length()))!= -1 ){
                    response.getOutputStream().write(bytearray,0,size);
                    out.println("<img border='1' src='<%response.getOutputStream().write(bytearray,0,size);%>' width='100' height='100'>");  
                    } 
            
            response.flushBuffer();
            */
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(displayphoto.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(displayphoto.class.getName()).log(Level.SEVERE, null, ex);
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

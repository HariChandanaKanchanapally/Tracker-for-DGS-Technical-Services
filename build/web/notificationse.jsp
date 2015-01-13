<%-- 
    Document   : notificationse
    Created on : Apr 7, 2013, 10:49:47 AM
    Author     : Acer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 3.2 Final//EN">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <script>
            function vali(){
                    
                       
                                         
                                       if((document.forms["jobe"]["status"].value==""))
                                                            {

                                                                alert ('Please enter job status and then enter submit');
                                                                jobe.status.focus();
                                                               return false;
                                                            }
                                       if((document.forms["jobe"]["phase"].value==""))
                                                            {

                                                                alert ("Please enter job completion phase");
                                                                jobe.phase.focus();
                                                               return false;
                                                            }
                                     
                                      
                                     
                        document.forms[0].action();
                        return true;
                    }
 </script>
    
        <style type="text/css"> 
            .fontname
        {
             font-style:verdana;
             font-size: 20;
             color: black;
            
             
             
        }
        .tryitbtn
        {
            background: black;
            color: white;
            height:40px;
            border-radius:40px;
        }
        
table.imagetable {
	font-family: verdana,arial,sans-serif;
	font-size:11px;
	color:#333333;
	border-width: 1px;
	border-color: #999999;
	border-collapse: collapse;
        
      table-layout: fixed;
    width: 200px;
      
         
        
}
table.imagetable th {
	background:#b5cfd2 url('cell-blue.jpg');
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #999999;
                align: center;
                overflow: hidden;
    width: 100px;
             

}
table.imagetable td {
	background:#dcddc0 url('cell-grey.jpg');
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #999999;
                align: center;
                overflow: hidden;
    width: 100px;
            

}

</style>
    </head>
       
    <body>
         <%@ page import="java.sql.*" %>
<% Class.forName("oracle.jdbc.OracleDriver"); %>
 
     <%  HttpSession session1=request.getSession(true);
            // out.println("The email"+session1.getAttribute("email"));
           String  sess_email=session.getAttribute("email").toString();%>
    
          
       <% 
           Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM", "chandana");
           Statement statement = connection.createStatement() ;
           
          PreparedStatement ps = connection.prepareStatement("select jobid,jobname,est_time,deadline,teamname,startdate from jobs where projmgr in(select empid from employer where email='"+sess_email+"') ");
            ResultSet rs = ps.executeQuery();
            %>
            <p class="fontname">Please enter status and completion phase values in the table below:<br></p>
            <p class="fontname">Possible values for status are:<font color="blue"> Running, Closed, Held or Canceled</font><br></p>
            <p  class="fontname">Possible values for completion are: <font color="blue">Checking, Detailing, Modeling, Finished</font><br></p>
             <p class="fontname">List of Jobs assigned </p>
            <table border="1" class="imagetable">
           <TR>
      <TH width="10%">JOBID</TH>
      <TH  width="10%">JOB NAME</TH>
      <TH  width="10%">ESTIMATED TIME</TH>
      <TH  width="10%">DEADLINE</TH>
      <TH  width="10%">TEAM NAME</TH>
      <TH  width="10%">START DATE</TH>
      <TH  width="10%">STATUS</TH>
      <TH  width="10%">COMPLETION PHASE</TH>
      <TH width="10%"> Notify</TH>
      
        
      </TR>
    </table>
      
      <% while(rs.next()){ %>
      
       <form method="post" action="cjoblist" name="stat" onsubmit="vali()" name="jobe">
           <TABLE BORDER="1" class="imagetable">
     
     
      <TR>
         
       <TD  width="10%"> <%= rs.getString(1) %></td>
       <TD  width="10%"> <%= rs.getString(2) %></TD>
       <TD  width="10%"> <%= rs.getString(3) %></TD>
       <TD  width="10%"> <%= rs.getString(4) %></TD>
       <TD  width="10%"> <%= rs.getString(5) %></TD>
       <TD  width="10%"> <%= rs.getString(6) %></TD>
       
       <TD  width="10%">
           
           <input type="text" name="status" style="background-color:transparent;border:0px solid white">
       </TD>
       <TD  width="10%">
           <input type="text" name="phase" style="background-color:transparent;border:0px solid white">
           <input type="hidden" name="job" value="<%= rs.getString(1)%>">       
       </TD> 
       
       <TD  width="10%">  <font face="Georgia,Arial" color="maroon" >
               <input type="submit" class="tryitbtn" name="submit"  align="center" value="Notify my progress to the manager" ><br><br>
       </TD>
            
      </TR>
           </table>
       </form>
      <% } %>
     
     
    </body>
</html>
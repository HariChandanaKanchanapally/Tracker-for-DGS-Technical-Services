

<%@ page contentType="text/html"
import="java.awt.*,java.awt.image.*,
com.sun.image.codec.jpeg.*,java.util.*"
%>

 <%@ page import="java.sql.*" %>
 <!DOCTYPE html>
<html lang="en">
    <head>
        <style>
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

                .tryitbtn
        
           {
            background: black;
            color: white;
            height:40px;
            border-radius:40px;
        
            }
        </style>
        <meta charset="utf-8" />
        <title>Pie Chart</title>
        <script type="text/javascript" src="https://www.google.com/jsapi"></script>
        <script type="text/javascript">
                var numberschart1 = 10;//<- Initial value
                var numberschart2 = 10;//<- Initial value
                var numberschart3 = 10;//<- Initial value
                var numberschart4 = 10;//<- Initial value
                
                google.load('visualization', '1', {packages: ['corechart']});

                function numbers(){
                        var work_field = document.forms['work_form']['running_n_field'].value;
                        var work_div = document.getElementById('number-running');
                        numberschart1= work_field;
                        
                        var work_field = document.forms['work_form']['closed_n_field'].value;
                        var work_div = document.getElementById('number-closed');
                        // numberschart2 = work_div.innerHTML = work_field;
                        numberschart2= work_field;
                        
                        var work_field = document.forms['work_form']['held_n_field'].value;
                        var work_div = document.getElementById('number-held');
                        numberschart3= work_field;
                       //   numberschart3 = work_div.innerHTML = work_field;
                        
                        var work_field = document.forms['work_form']['canceled_n_field'].value;
                        var work_div = document.getElementById('number-canceled');
                        // numberschart4 = work_div.innerHTML = work_field;
                        numberschart4= work_field;
                        
                        drawVisualization();
                        return false;
                };

                function drawVisualization() {
                    // Create and populate the data table.
                    var data = new google.visualization.DataTable();
                    data.addColumn('string', 'Task');
                    data.addColumn('number', 'Number of jobs');
                    data.addRows(5);
                    data.setValue(0, 0, 'Running');
                    //data.setValue(0, 1, 11);
                    data.setValue(0, 1, parseInt(numberschart1));//<- The value you get from input field is a string, Google API will throw an error
                    data.setValue(1, 0, 'Closed');
                    data.setValue(1, 1, parseInt(numberschart2));
                    data.setValue(2, 0, 'Held');
                    data.setValue(2, 1, parseInt(numberschart3));
                    data.setValue(3, 0, 'Canceled');
                    data.setValue(3, 1, parseInt(numberschart4));
                    

                    // Create and draw the visualization.
                    new google.visualization.PieChart(document.getElementById('visualization')).
                        draw(data, {
                            title:"Status of Jobs",
                            colors: ['#a4b12d', '#818e0a', '#5c6601', '#f0fd79', '#dbe864'],
                            animation:{
                                duration:1000,
                                easing: 'out',
                            },
                            vAxis: {
                                minValue:0, 
                                maxValue:1000
                            },
                        });
                  }    
               // google.setOnLoadCallback(drawVisualization);
        </script>
    </head>
    <body>
        
         <%@ page import="java.sql.*" %>
        <% Class.forName("oracle.jdbc.OracleDriver"); %>
 
        <%  HttpSession session1=request.getSession(true);
           //  out.println("The email"+session1.getAttribute("email"));
           String  sess_email=session.getAttribute("email").toString();%>
    
    
       <% 
           Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM", "chandana");
           Statement statement = connection.createStatement() ;
           
          PreparedStatement ps = connection.prepareStatement("select count(status) from jobs where status='running' ");
          ResultSet rs = ps.executeQuery();
          
           PreparedStatement ps2 = connection.prepareStatement("select count(status) from jobs where status='Closed' ");
          ResultSet rs2 = ps2.executeQuery();
          
           PreparedStatement ps3 = connection.prepareStatement("select count(status) from jobs where status='held' ");
          ResultSet rs3 = ps3.executeQuery();
          
           PreparedStatement ps4 = connection.prepareStatement("select count(status) from jobs where status='canceled' ");
          ResultSet rs4 = ps4.executeQuery();
            %>
        
        
        
        <form name="work_form">
            <label id="n-running-label"></label>
            <% while(rs.next()){ %>
             
            <input type="hidden" value="<%= rs.getString(1) %>"  name="running_n_field" />
            <% } %>
            <label id="n-closed-label"></label>
            <% while(rs2.next()){ %>
            <input type="hidden" name="closed_n_field" value="<%= rs2.getString(1) %>"/>
            <% } %>
            <label id="n-held-label"></label>
            <% while(rs3.next()){ %>
            <input type="hidden" name="held_n_field" value="<%= rs3.getString(1) %>"/>
            <% }%>
            <label id="n-canceled-label"></label>
            <% while(rs4.next()){ %>
            <input type="hidden" name="canceled_n_field" value="<%= rs4.getString(1) %>"/>
            <%}%>
            <button name="submit" id="submit" value="submit" class="tryitbtn" onclick="numbers();return false;">Click here to view the pie graph</button>
        </form>
            <div id="visualization" style="width: 400px; height: 300px;"></div>
        <div id="number-running"></div>
        <div id="number-closed"></div>
        <div id="number-held"></div>
        <div id="number-canceled"></div>
    
      
           <form action="#">

        <div data-role="fieldcontain">
    <fieldset data-role="controlgroup">
    	<legend><font size="3" color="black" face="verdana">Choose one of the following jobs for display</font></legend>
         	<input type="radio" name="r1" id="radio-choice-1" value="running" checked="checked" />
         	<label for="radio-choice-1"><font size="2" color="darkblue" face="verdana"> Running</font></label>

         	<input type="radio" name="r1" id="radio-choice-2" value="closed"  />
         	<label for="radio-choice-2"><font size="2" color="darkblue" face="verdana">Closed</font></label>

         	<input type="radio" name="r1" id="radio-choice-3" value="held"  />
         	<label for="radio-choice-3"><font size="2" color="darkblue" face="verdana">Held</font></label>

         	<input type="radio" name="r1" id="radio-choice-4" value="canceled"  />
                <label for="radio-choice-4"><font size="2" color="darkblue" face="verdana">Canceled</font></label>
    </fieldset>
</div>
       <input type="submit" class="tryitbtn" name="submit"  align="center" value="Click to view the respecctive job information"><br><br>  

        <% 
        String fradio=request.getParameter("r1");
       // out.println("The radio value"+fradio);
        
        %>
        




<% Class.forName("oracle.jdbc.OracleDriver"); %>
 <%
    
             
    // out.println("The email"+session1.getAttribute("email"));
          // String  sess_email=session.getAttribute("email").toString();%>
    
             
       <% 
              try{
           
       
         //  Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM", "chandana");
           //Statement statement = connection.createStatement() ;
          
            
         //  out.println("Connection\n");    
          PreparedStatement ps1 = connection.prepareStatement("select jobid,jobname,est_time,deadline,teamname,startdate,status from jobs where status='"+fradio+"' ");
            ResultSet rs1 = ps1.executeQuery();
           // out.println("execute query");
            %>
            <table border="1" class="imagetable">    
      <TR>
      <TH width="10%">JOBID</TH>
      <TH width="10%">JOB NAME</TH>
      <TH width="10%">ESTIMATED TIME</TH>
      <TH width="10%">DEADLINE</TH>
      <TH width="10%">TEAM NAME</TH>
      <TH width="10%">START DATE</TH>
      <TH width="10%">STATUS</TH>
     
     
      </TR>
    </table>
      <% while(rs1.next()){ %>
  
           <TABLE BORDER="1" class="imagetable">
               
            
      <TR>
         
       <TD width="10%"> <%= rs1.getString(1) %></td>
       <TD width="10%"> <%= rs1.getString(2) %></TD>
       <TD width="10%"> <%= rs1.getString(3) %></TD>
       <TD width="10%"> <%= rs1.getString(4) %></TD>
       <TD width="10%"> <%= rs1.getString(5) %></TD>
       <TD width="10%"> <%= rs1.getString(6) %></TD>
       
       <TD width="10%">
           
           <%= rs1.getString(7) %>
       </TD>
      
            
      </TR>
           </table>
       
      <% } }
        catch(Exception e){}            
       %>
        </form>

        </body>  

</html>
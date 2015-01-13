<%-- 
    Document   : createerrorlog
    Created on : Mar 3, 2013, 4:18:02 PM
    Author     : shruthibalki
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <form action="createerrorlog" method="get">
                 JOB ID : <input type="text" name="jobid" > </input>
                 <br>                           
           JOB SPECIFICATION : <textarea name="jobspecification" rows="5" cols="50"></textarea><br> 
           
           ERROR OCCURED : <textarea name="erroroccured" rows="5" cols="50"></textarea><br> 
           
           SOLUTION PROPOSED : <textarea name="solution" rows="5" cols="50"></textarea><br> 
                                    <input type ="submit" value="Done">
             </form>
    </body>
</html>

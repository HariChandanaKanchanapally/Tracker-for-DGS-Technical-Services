<%-- 
    Document   : viewprofile
    Created on : Jan 26, 2013, 4:07:21 PM
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
        <h1>Hello World!</h1>
        <form action="cviewprofile" method="post">
            <input type='submit' value='View Profile'>
          <%-- <b class="cs1"> PLEASE ENTER THE PROFILE ID OF THE EMPLOYER : </b> <input type="text" name="empid">
            <input type="submit" value="View Profile"><br><br>--%>
          
             <a href="logout.jsp"><img src="logout.png"></a>
        </form>
    </body>
</html>

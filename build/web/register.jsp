<%-- 
    Document   : register
    Created on : Jan 25, 2013, 11:32:37 AM
    Author     : shruthibalki
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
    
     <script>
            function vali(){
                    var pattern=/^([a-zA-Z0-9_.-])+@([a-zA-Z0-9_.-])+\.([a-zA-Z])+([a-zA-Z])+/;

                    if(pattern.test(document.login.email.value)){

                       
                                         if((login.name.value.length==0))
                                                            {
                                                                
                                                                alert ('Please enter your NAME');
                                                                login.name.focus();
                                                               return false;
                                                            }
                                       if((login.doj.value==""))
                                                            {

                                                                alert ('Please enter your Date of joining');
                                                                login.doj.focus();
                                                               return false;
                                                            }
                                       if((login.dob.value==""))
                                                            {

                                                                alert ('Please enter your Date Of Birth');
                                                                login.dob.focus();
                                                               return false;
                                                            }
                                       if((login.gender[0].checked==false)&&(login.gender[1].checked==false))
                                        {

                                            alert ('Select the Gender');
                                            login.gender[0].focus();
                                            login.gender[1].focus();
                                           return false;
                                        }
                                       if((login.password.value==""))
                                                            {

                                                                alert ('Please enter your password');
                                                                login.password.focus();
                                                               return false;
                                                            }
                                       if((login.designation.value==""))
                                                            {

                                                                alert ('Please enter your PHONE');
                                                                login.designation.focus();
                                                               return false;
                                                            }
                                       if((login.emptype[0].checked==false)&&(login.emptype[1].checked==false))
                                        {

                                            alert ('Select Employee Type');
                                            login.emptype[0].focus();
                                            login.emptype[1].focus();
                                           return false;
                                        }
                                      
                        document.forms[0].action();
                        return true;
                    }

                  else{
                        alert("Enter valid Email ID. Example:xyz123@abc.com");
                       login.email.focus();
                        return false;
                     }
            }
                    

         
              
    </script>
    </head>
    <body Bgcolor ="#0099cc">
       
        <form name="login" action="cregister" method="post" enctype="multipart/form-data" onsubmit="return vali()">
                EmpId : <input type="text" size="20" name="empid"><br><br>
                
                Name : <input type="text" size="maxlength" name="name"><br><br>

                            
                Gender : 
                    <input type="radio" name="gender" value="male"><b > Male</b><br>
                    <input type="radio" name="gender" value="female"><b>Female</b><br><br>

                Date Of Birth :<input type="text" size="10" name="dob"><br><br>
                
                Date Of Joining :<input type="text" size="10" name="doj"><br><br>
                
                Designation :<input type="text" name="designation"><br><br>
  
                Employee Type : 
                    <input type="radio" name="emptype" value="permanent"><b>Permanent</b><br>
                    <input type="radio" name="emptype" value="training"><b>Training</b><br><br>

                Email : <input type="text" size="maxlength" name="email"><br><br>

               Password :<input type="password" size="maxlength" name="password"><br><br>
              
               
                 Select a file to upload: <br />
                 <input type="file" name="photo" size="50" />
                <br />
                <input type="submit" value="submit">


            </form>      
    </body>
</html>

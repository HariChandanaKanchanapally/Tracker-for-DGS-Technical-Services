<%-- 
    Document   : createjob
    Created on : Feb 5, 2013, 10:54:03 PM
    Author     : Acer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
    
     <script>
            function vali(){
                    
                       
                                         if((job.id.value.length==""))
                                                            {
                                                                
                                                                alert ('Please enter JobID');
                                                                job.id.focus();
                                                               return false;
                                                            }
                                       if((job.name.value==""))
                                                            {

                                                                alert ('Please enter Job Name');
                                                                job.name.focus();
                                                               return false;
                                                            }
                                       if((job.est_time.value==""))
                                                            {

                                                                alert ('Please enter Job\'s Estimated Time');
                                                                job.est_time.focus();
                                                               return false;
                                                            }
                                     
                                      
                                       if((job.deadline.value==""))
                                                            {

                                                                alert ('Please enter Jobs Deadline');
                                                                job.deadline.focus();
                                                               return false;
                                                            }
                                     
                                      
                        document.forms[0].action();
                        return true;
                    }
 </script>
    <style>
               .textbox
        {
            border:2px solid #0FF000;
            vertical-align: middle;
           
            padding-top: 4px;
            
        }
        .tryitbtn
        {
            background: black;
            color: white;
            height:40px;
            border-radius:40px;
        }    
        .fontname
        {
             font-style:verdana;
             font-size: 2;
            
             
             
        }
 </style>                   

         
              
   
    </head>
    <body>
        <p> 
        <form name="job" action="ccreatejob" method="post" enctype="multipart/form-data" onsubmit="return vali()">
               
            <p class="fontname">    JOB ID :</p><input class="textbox" type="text" size="20" name="id"><br><br>
                
                <p class="fontname">      Name :</p><input type="text" class="textbox" size="20" name="name"><br><br>
                
               <p class="fontname">   Estimated Time:</p><input type="text"  class="textbox"  size="10" name="est_time"><br><br>
                
                <p class="fontname">  Actual Time : </p><input type="text"  class="textbox" size="10" name="act_time"><br><br>
                
               <p class="fontname"> Deadline :  </p><input type="text"  class="textbox"  name="deadline"><br><br>
  
                <p class="fontname">Project Manager :</p>  <input type="text"  class="textbox"  size="20" name="projmgr"><br><br>
                
               <p class="fontname"> Team Name : </p> <input type="text"  class="textbox"  size="20" name="teamname"><br><br>
                
               <p class="fontname"> Start Date : </p> <input type="text"  class="textbox"  size="20" name="startdate"><br><br>
                
                
                <input type="submit"  class="tryitbtn" value="submit">
               

            </form>  
         
    
    </body>
</html>

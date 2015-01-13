<html>
<head> 
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
.monthPre{
 color: gray;
 text-align: center;
}
.monthNow{
 color: blue;
 text-align: center;
}
.dayNow{
 border: 2px solid black;
 color: #FF0000;
 text-align: center;
}
.calendar td{
 htmlContent: 2px;
 width: 40px;
}
.monthNow th{
 background-color: #000000;
 color: #FFFFFF;
 text-align: center;
}
.dayNames{
 background: #0FF000;
 color: #FFFFFF;
 text-align: center;
}
 
</style> 
   
<title>JavaScript calendar</title>
<script> 
  var action=1000;  
 function fdate(bv)
        {
            if(action==1000)
            {
         
            
            document.entry.fromdate.value=bv;
            document.entry.fromdate.value+="/"+ new Date().getMonth();
            document.entry.fromdate.value+= "/"+new Date().getFullYear();
        
           
           action=2000;
            }
            if(action==2000)
                {
                   
            
            document.entry.todate.value=bv;
            document.entry.todate.value+="/"+ new Date().getMonth();
            document.entry.todate.value+= "/"+new Date().getFullYear();
                }
        }
         
    
function displayCalendar(){
 
 
 var htmlContent ="";
 var FebNumberOfDays ="";
 var counter = 1;
 
 
 var dateNow = new Date();
 var month = dateNow.getMonth();

 var nextMonth = month+1; //+1; //Used to match up the current month with the correct start date.
 var prevMonth = month -1;
 var day = dateNow.getDate();
 var year = dateNow.getFullYear();
 
 
 //Determing if February (28,or 29)  
 if (month == 1){
    if ( (year%100!=0) && (year%4==0) || (year%400==0)){
      FebNumberOfDays = 29;
    }else{
      FebNumberOfDays = 28;
    }
 }
 
 
 // names of months and week days.
 var monthNames = ["January","February","March","April","May","June","July","August","September","October","November", "December"];
 var dayNames = ["Sunday","Monday","Tuesday","Wednesday","Thrusday","Friday", "Saturday"];
 var dayPerMonth = ["31", ""+FebNumberOfDays+"","31","30","31","30","31","31","30","31","30","31"]
 
 
 // days in previous month and next one , and day of week.
 var nextDate = new Date(nextMonth +' 1 ,'+year);
 var weekdays= nextDate.getDay();
 var weekdays2 = weekdays
 var numOfDays = dayPerMonth[month];
 
 
 
 
 
 
 // this leave a white space for days of pervious month.
 while (weekdays>0){
    htmlContent += "<td class='monthPre'></td>";
 
 // used in next loop.
     weekdays--;
 }
 
 // loop to build the calander body.
 while (counter <= numOfDays){
 
     // When to start new line.
    if (weekdays2 > 6){
        weekdays2 = 0;
        htmlContent += "</tr><tr>";
    }
 
 
    // if counter is current day.
    // highlight current day using the CSS defined in header.
    if (counter == day){
               


htmlContent +=
    "<td class='dayNow'  onMouseOver='this.style.background=\"#FF0000\" ;this.style.color=\"#FFFFFF\"' onMouseOut='this.style.background=\"#FFFFFF\"; this.style.color=\"#00FF00\"'> <input type='button' name='date' value='"+counter+"' onclick='fdate( " +counter+ " )' id='button1'></input></td>"; 
}
else{
         


htmlContent +="<td class='monthNow' onMouseOver='this.style.background=\"#FF0000\"'"+
        " onMouseOut='this.style.background=\"#FFFFFF\"'><input type='button' name='date' value='"+counter+"' onclick='fdate( "+counter+" )' id='button1' ></input></td>"   
 
    }
    
    weekdays2++;
    counter++;
 }
 
 
 
 // building the calendar html body.
 var calendarBody = "<table class='calendar'> <tr class='monthNow'><th colspan='7'>"
 +monthNames[month]+" "+ year +"</th></tr>";
 calendarBody +="<tr class='dayNames'>  <td>Sun</td>  <td>Mon</td> <td>Tues</td>"+
 "<td>Wed</td> <td>Thurs</td> <td>Fri</td> <td>Sat</td> </tr>";
 calendarBody += "<tr>";
 calendarBody += htmlContent;
 calendarBody += "</tr></table>";
 // set the content of div .
 document.getElementById("calendar").innerHTML=calendarBody;
 
}
</script> 
</head> 
 
<body onload="displayCalendar()"> 
<div id="calendar"></div> 
 <form name="entry" action="cdatepicker"><br><br>
     <font face="Georgia,Arial" color="maroon"  > <input size="10" value="FROM DATE:" style="background-color:transparent;border:0px solid white; font-style:Georgia,Arial; color:maroon; size:10px"></font><input align="center" type="text" name="fromdate" class="textbox"><br><br>
    
     <font face="Georgia,Arial" color="maroon"><input size="10" value="TO DATE:" style="background-color:transparent;border:0px solid white;font-style:Georgia,Arial; color:maroon; size:10px"></font><input align="center" type="text" name="todate" class="textbox"><br><br>
    
       <font face="Georgia,Arial" color="maroon" ><input size="10" value="REASON:" style="background-color:transparent;border:0px solid white; font-style:Georgia,Arial; color:maroon; size:10px"></font><input type="text" align="center" name="reason" class="textbox"><br><br>
      
     <font face="Georgia,Arial" color="maroon" ><input size="10" value="MANAGER:" style="background-color:transparent;border:0px solid white; font-style:Georgia,Arial; color:maroon; size:10px"></font><input type="text" align="center" name="mgrid" class="textbox"><br><br>
      
       <font face="Georgia,Arial" color="maroon" ><input type="submit" class="tryitbtn" name="submit"  align="center" value="Notify my absence to the manager"><br><br>
 </form>
</BODY>


</html>
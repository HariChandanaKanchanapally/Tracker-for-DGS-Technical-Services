<%@page import="java.io.PrintWriter"%>
<%@page import="java.io.IOException"%>
<%@ page  language="java" import="java.util.*,java.text.*"%>
<%!
public int nullIntconv(String inv)
{   
    int conv=0;
        
    try{
        conv=Integer.parseInt(inv);
    }
    catch(Exception e)
    {}
    return conv;
}
%>
<%
 int iYear=nullIntconv(request.getParameter("iYear"));
 int iMonth=nullIntconv(request.getParameter("iMonth"));

 Calendar ca = new GregorianCalendar();
 int iTDay=ca.get(Calendar.DATE);
 int iTYear=ca.get(Calendar.YEAR);
 int iTMonth=ca.get(Calendar.MONTH);

 if(iYear==0)
 {
      iYear=iTYear;
      iMonth=iTMonth;
 }

 GregorianCalendar cal = new GregorianCalendar (iYear, iMonth, 1); 

 int days=cal.getActualMaximum(Calendar.DAY_OF_MONTH);
 int weekStartDay=cal.get(Calendar.DAY_OF_WEEK);
 
 cal = new GregorianCalendar (iYear, iMonth, days); 
 int iTotalweeks=cal.get(Calendar.WEEK_OF_MONTH);
  
%>
<html>
<head>
<title>How to create Calendar in JSP</title>
<script>
    s="";
        function fdate(bv)
        {
             if(s.length<10)
                 {
            document.entry.fromdate.value =s+"/"+bv;
            s=document.entry.fromdate.value;
       goTo();
                 }
            
            
        } 
          s=""
          function tdate(bv)
        {
               
            document.entry.todate.value =s+"/"+bv;
            s=document.entry.todate.value;
            
            goTo();
            
        } 
          
function goTo()
{
  document.frm.submit()
}
</script>
<style>
body
{
 font-family:Verdana, Arial, Helvetica, sans-serif
}
.dsb
{
 background-color:#EEEEEE
}
</style>
</head>

<body>
<form name="frm" method="post" action="#">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="25%">&nbsp;</td>
    <td width="45%">&nbsp;</td>
    <td width="30%">&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="6%">Year</td>
        <td width="7%">
        <select name="iYear" id="selectBox" onChange="fdate(selectBox.options[selectBox.selectedIndex].value);">
           
        
        <option value=" " selected="selected">Select</option>
        <%
            // start year and end year in combo box to change year in calendar
        for(int iy=iTYear-70;iy<=iTYear+70;iy++)
        {
          if(iy==iYear)
          {
            %>
          <option value="<%=iy%>" onclick="fdate(<%= iy%>)" ><%=iy%></option>
          <%
          }
          else
          {
            %>
          <option value="<%=iy%>" onclick="fdate(<%= iy%>)"><%=iy%></option>
          <%
          }
        }
       %>
        </select></td>
        <td width="73%" align="center" style="color:#4E96DE"><h3><%=new SimpleDateFormat("MMMM").format(new Date(2008,iMonth,01))%> <%=iYear%></h3></td>
        <td width="6%">Month</td>
        <td width="8%">
           
        <select name="iMonth" id="selectMonth" onChange="fdate(selectMonth.options[selectMonth.selectedIndex].value); ">
         <option value=" " selected="selected">Select</option>
            <%
        // print month in combo box to change month in calendar
        for(int im=0;im<=11;im++)
        {
  
          if(im==iMonth)
          {
         %>
         <option value="<%=im%>" onclick="fdate(<%= im%>)"><%= im %></option>
          <%
          }
          else
          {
            %>
          <option value="<%=im%>" onclick="fdate(<%= im%>)"><%=im%></option>
          <%
          }
        }
       %>
        </select></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td><table align="center" border="1" cellpadding="3" cellspacing="0" width="100%">
      <tbody>
        <tr>
          <th>Sun</th>
          <th>Mon</th>
          <th>Tue</th>
          <th>Wed</th>
          <th>Thu</th>
          <th>Fri</th>
          <th>Sat</th>
        </tr>
        <%
        int cnt =1;
        for(int i=1;i<=iTotalweeks;i++)
        {
        %>
        <tr>
          <% 
            for(int j=1;j<=7;j++)
            {
                if(cnt<weekStartDay || (cnt-weekStartDay+1)>days)
                {
                 %>
                <td align="center" height="35" class="dsb">&nbsp;</td>
               <% 
                }
                else
                {
                 %>
                 
                 <td align="center" height="35" id="<%= (cnt-weekStartDay+1)%>">
                 <span> 
                     <input type="button" name="date" value="<%= (cnt-weekStartDay+1)%>" onclick="fdate(<%= (cnt-weekStartDay+1)%>)" id="button1">
                 </span>
                </td>
                 
                 
                 
                 <% 
                }
                cnt++;
              }
            %>
                 
        </tr>
        <% 
        }
        %>
      </tbody>
    </table></td>
        
  </tr>
</table></td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
</table>
</form>
      <form name="entry">
      From date<input  type="text" name="fromdate">
      </form>

</body>
</html>

<%@ page language="java" %>
<html>
<head>
<title>Bar Chart</title>
</head>
<body bgcolor=white text=black>
<table id=graph align=center width=600 cellpadding=0 cellspacing=1 border=0>

<tr bgcolor=#C0C0C0>
<td align=center valign=bottom width=29>90<br>
<div style=' background-color:cyan; width:24; height:100;' />
</td>
<td align=center valign=bottom width=29>90<br>
<div style=' background-color:cyan; width:24; height:90;' />
</td>
<td align=center valign=bottom width=29>95<br>
<div style=' background-color:cyan; width:24; height:95;' />
</td>
<td align=center valign=bottom width=29>60<br>
<div style=' background-color:cyan; width:24; height:60;' />
</td>
<td align=center valign=bottom width=29>85<br>
<div style=' background-color:cyan; width:24; height:85;' />
</td>
<td align=center valign=bottom width=29>100<br>
<div style=' background-color:cyan; width:24; height:100;' />
</td>
<td align=center valign=bottom width=29>70<br>
<div style=' background-color:cyan; width:24; height:70;' />
</td>
<td align=center valign=bottom width=29>100<br>
<div style=' background-color:cyan; width:24; height:100;' />
</td>
<td align=center valign=bottom width=29>75<br>
<div style=' background-color:cyan; width:24; height:75;' />
</td>
<td align=center valign=bottom width=29>85<br>
<div style=' background-color:cyan; width:24; height:85;' />
</td>

</tr>
<tr bgcolor=#C0C0C0>
<%
int id=0;
while(id<10)
{
id=id+1;
%>

<td align=center><%out.println(id);%></td>
<%
}
%>
</tr>
</table>
</body>
</html>
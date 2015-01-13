<%-- 
    Document   : chart
    Created on : Mar 19, 2013, 3:44:39 PM
    Author     : Acer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 3.2 Final//EN">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       
        <%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %>
<%@ page import="org.jfree.chart.ChartFactory" %>
<%@ page import="org.jfree.chart.ChartUtilities" %>
<%@ page import="org.jfree.chart.JFreeChart" %>
<%@ page import="org.jfree.chart.plot.PlotOrientation"%>
<%@ page import="org.jfree.data.*" %>
<%@ page import="org.jfree.data.jdbc.JDBCCategoryDataset"%>

<%
String query="SELECT * from chart";

JDBCCategoryDataset dataset=new JDBCCategoryDataset("jdbc:oracle:thin:@localhost:1521:XE",
"oracle.jdbc.OracleDriver","SYSTEM","chandana");

dataset.executeQuery( query);

JFreeChart chart = ChartFactory .createBarChart3D(
"Performance", 
"EMPID", 
"Rating", 
dataset, 
PlotOrientation.VERTICAL,true, true, false);

try
{
ChartUtilities.saveChartAsJPEG(new File("D:/project/WebApplication1/web/chart.jpg"), chart, 400, 300);

}
catch (IOException e)
{
out.println("Problem in creating chart.");
}
%><br><br>
<img src="chart.jpg" width="500" height="500"> 

    </body>
</html>

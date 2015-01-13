<%-- 
    Document   : circle
    Created on : Feb 25, 2013, 2:35:30 PM
    Author     : Acer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 3.2 Final//EN">
<html>
  <head>
    <script type="text/javascript" src="https://www.google.com/jsapi"></script>
    <script type="text/javascript">
      google.load("visualization", "1", {packages:["corechart"]});
      google.setOnLoadCallback(drawChart);
      function drawChart() {
        var data = google.visualization.arrayToDataTable([
          ['Task', 'Hours per Day'],
          ['Checking',  1  ],
          ['Detailing',  1    ],
          ['Modeling', 1 ],
          
        ]);

        var options = {
          title: 'Job Status'
        };

        var chart = new google.visualization.PieChart(document.getElementById('chart_div'));
        chart.draw(data, options);
        
      }
    </script>
  </head>
  <body>
    <div id="chart_div" style="width: 900px; height: 500px;"> </div>
    
  
  </body>
</html>


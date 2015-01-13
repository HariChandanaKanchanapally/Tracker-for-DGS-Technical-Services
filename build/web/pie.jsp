<%-- 
    Document   : pie
    Created on : Feb 25, 2013, 4:17:46 PM
    Author     : Acer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 3.2 Final//EN">

    <canvas id="bluffExample" width="200" height="200"></canvas>
   
<script language="javascript" src="/js/bluff/js-class.js" type="text/javascript"></script>
<script language="javascript" src="/js/bluff/bluff-min.js" type="text/javascript"></script>
<!--[if IE]><script language="javascript" src="/js/bluff/excanvas.js" type="text/javascript"></script><![endif]-->
<script type="text/javascript">
   
   
   window.onload = function () {
        i=0;
        for (i in data.items) {
        data.items[i] = prompt("Enter the  variants");
        data.items[i]= parseString(data.items[i]);
     }
    
  //Create pie chart
  var bluffGraph = new Bluff.Pie('bluffExample', 400);
  //Use keynote theme. Several other themes can be used
  bluffGraph.theme_keynote();
  bluffGraph.title = 'Status of Jobs';
 
 for (i in data.items) {
    var item = data.items[i];
    //Add each data item to pie
    bluffGraph.data(item.label, item.data);
  }
  //Finally draw the chart
  bluffGraph.draw();
   }
</script>
      

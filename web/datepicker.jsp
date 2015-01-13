<!doctype html>
 
<html lang="en">
<head>
  <meta charset="utf-8" />
  <title>jQuery UI Datepicker - Default functionality</title>
  <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.0/themes/base/jquery-ui.css" />
  <script src="http://code.jquery.com/jquery-1.8.3.js"></script>
  <script src="http://code.jquery.com/ui/1.10.0/jquery-ui.js"></script>
  <link rel="stylesheet" href="/resources/demos/style.css" />
  <script>
  $(function() {
    $( "#datepicker" ).datepicker();
  });
 $(function() {
    $( "#datepicker2" ).datepicker();
  });
  </script>
</head>
<body>
<form  action="cdatepicker"> 
<p>From Date: <input type="text" id="datepicker" name="fromdate"/></p>
<p>Reason/Purpose<input type="text" size="30" name="reason">
<p>To Date: <input type="text" id="datepicker2" name="todate" /></p>
<p>Send Notification to(type the EMPID of your manager):<input type="text" name="mgrid"
<p><input type="submit" name="submit" value="Send Notification"></p> 

</form>
</body>
</html>
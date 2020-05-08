<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Tracker App</title>
<link type="text/css" rel="stylesheet" href="css/style.css">
</head>

<!-- //EMPLOYEES_LIST -->
<body>

	<div id="wrapper">
		<div id="header">
			<h2>Employee(s) View/Update WebApp</h2>
		</div>
	</div>

	
		<div id="container">
	
		<div id="content">
		
		
			<table id="listEmployee">
			</table>
			</br>
			<a href="EmployeeHome.jsp">Go Back</a>
			</div>
		</div>
</body>
</html>

<script src="./plugins/jquery/jquery.min.js"></script>
<script>
    var timer, delay = 3000;
     timer = setInterval(function(){
        fetch('ListEmployeeAjax', {
          method: 'POST'
        })
        .then(response => response.text())
        .then((response) => {
            $('#listEmployee').empty();
            $('#listEmployee').append(response);
        })
        .catch((error) => {
          alert("Error Plaese Load Page");
        });
    }
   , delay);    
</script>
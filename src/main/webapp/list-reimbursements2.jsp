<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reimbursement Tracker App</title>
<link type="text/css" rel="stylesheet" href="css/style.css">

</head>

<!--  -->
<body>
	<div id="wrapper">
		<div id="header">
			<h2>Reimbursement(s) View/Update WebApp</h2>		
		</div>
	</div>
	
	<div id="container">
		<div id="content">
		
		<!--  add remibursement button-->
		
		<input type="button" value="+Reimbursement"
			onclick="window.location.href='add-reimbursement-form2.jsp'; return false;"
				class="add-student-button"
				/>
		
		<!--  add remibursement button-->
		
			<table id="listReimbursement">
			</table>
			</br>
			<a href="ManagmentHome.jsp">Go Back</a>
		</div>
	
	</div>

</body>
</html>

<script src="./plugins/jquery/jquery.min.js"></script>
<script>
    var timer, delay = 3000;

    timer = setInterval(function(){
        $.ajax({
            type: 'POST',
            url: "ListReimbursements2Ajax",
            success: function(html){
                $('#listReimbursement').empty();
                $('#listReimbursement').append(html);
            }
        });
    }, delay);
</script>
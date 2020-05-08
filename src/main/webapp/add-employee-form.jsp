
<!DOCTYPE html>
<html>
<head>
<title>Add Employee</title>

<link type="text/css" rel="stylesheet" href="css/style.css">
<link type="text/css" rel="stylesheet" href="css/add-student-style.css">

<meta charset="ISO-8859-1">
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>Tuition Reimbursement Program</h2>
		</div>
	</div>
	
	
	<div id="container">
		<h3>Add Employee</h3>
		
		<form action="EmployeeControllerServlet" method="GET">
			<input type="hidden" name="command" value="ADD"/>
			
			<table>
				<tbody>
					<tr>
						<td><label>Email</label></td>
						<td><input type="text" name="userName"/></td>
					</tr>
					<tr>
						<td><label>Password</label></td>
						<td><input type="text" name="passWord"/></td>
					</tr>
					<tr>
						<td><label>Access Level</label></td>
						<td><input type="text" name="accessLevel"/></td>
					</tr>
					<tr>
						<td><label>DOB MM/DD/YY</label></td>
						<td><input type="text" name="dob"/></td>
					</tr>
					<tr>
						<td><label>First Name</label></td>
						<td><input type="text" name="firstName"/></td>
					</tr>
					<tr>
						<td><label>Last Name</label></td>
						<td><input type="text" name="lastName"/></td>
					</tr>
					<tr>
						<td><label>Manager Email</label></td>
						<td><input type="text" name="managerEmail"/></td>
					</tr>
					
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save"/></td>
					</tr>
				
				</tbody>
			
			</table>
			
		</form>
		
		<div style="clear: both;"></div>
		<p>
			<a href="EmployeeControllerServlet">Go Back</a>
		</p>
	</div>
</body>
</html>
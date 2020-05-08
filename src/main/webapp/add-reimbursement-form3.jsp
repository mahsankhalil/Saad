
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Reimbursement Request</title>

<link type="text/css" rel="stylesheet" href="css/style.css">
<link type="text/css" rel="stylesheet" href="css/add-student-style.css">
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>Tuition Reimbursement Program</h2>
		</div>
	</div>
	
	
	<div id="container">
		<h3>Add Reimbursement Requests</h3>
		
		<form action="ReimbursementControllerServlet3" method="GET">
			<input type="hidden" name="command" value="ADD"/>
			
			<table>
				<tbody>
					<tr>
						<td><label>First Name</label></td>
						<td><input type="text" name="firstName"/></td>
					</tr>
					<tr>
						<td><label>Last Name</label></td>
						<td><input type="text" name="lastName"/></td>
					</tr>
					<tr>
						<td><label>Email</label></td>
						<td><input type="text" name="userName"/></td>
					</tr>
					<tr>
						<td><label>Learning Institution Name</label></td>
						<td><input type="text" name="schoolName"/></td>
					</tr>
					<tr>
						<td><label>Receipt Link</label></td>
						<td><input type="text" name="receiptLink"/></td>
					</tr>
					<tr>
						<td><label>Proof Of Completion</label></td>
						<td><input type="text" name="proofOfCompletionLink"/></td>
					</tr>
					<tr>
						<td><label>Manager Email</label></td>
						<td><input type="text" name="managerEmail"/></td>
					</tr>
					<tr>
						<td><label>Submit Date</label></td>
						<td><input type="text" name="submitDate"/></td>
					</tr>
					<tr>
						<td><label>Start Date</label></td>
						<td><input type="text" name="courseStartDate"/></td>
					</tr>
					<tr>
						<td><label>Completion Date</label></td>
						<td><input type="text" name="courseEndDate;"/></td>
					</tr>
					<tr>
						<td><label>Approving Manager's Email</label></td>
						<td><input type="text" name="approvedByUsername"/></td>
					</tr>
					<tr>
						<td><label>Approval Date</label></td>
						<td><input type="text" name="approvalDate"/></td>
					</tr>
<!-- 					<tr>
						<td><label>Reimbursement ID#</label></td>
						<td><input type="text" name="ReimbursementId"/></td>
					</tr> -->
					
					<tr> 
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save"/></td>
					</tr>
				</tbody>
			
			</table>
			
		</form>
		
		<div style="clear: both;"></div>
		<p>
			<a href="ReimbursementControllerServlet3">Go Back</a>
		</p>
		
	</div>
</body>
</html>

<!DOCTYPE html>
<html>
<head>
<title>Update Reimbursement Request</title>

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
		<h3>Update Reimbursement Request(s)</h3>
		
		<form action="ReimbursementControllerServlet2" method="GET">
			<input type="hidden" name="command" value="UPDATE" />
			<input type="hidden" name="reimbursementId" value="${THE_REIMBURSEMENT.reimbursementId}"/>
			<table>
				<tbody>
					<tr>
						<td><label>First Name</label></td>
						<td><input type="text" name="firstName" value="${THE_REIMBURSEMENT.firstName}"/></td>
					</tr>
					<tr>
						<td><label>Last Name</label></td>
						<td><input type="text" name="lastName" value="${THE_REIMBURSEMENT.lastName}"/></td>
					</tr>
					<tr>
						<td><label>Email</label></td>
						<td><input type="text" name="userName" value="${THE_REIMBURSEMENT.userName}"/></td>
					</tr>
					<tr>
						<td><label>Learning Institution Name</label></td>
						<td><input type="text" name="schoolName" value="${THE_REIMBURSEMENT.schoolName}"/></td>
					</tr>
					<tr>
						<td><label>Receipt Link</label></td>
						<td><input type="text" name="receiptLink" value="${THE_REIMBURSEMENT.receiptLink}"/></td>
					</tr>
					<tr>
						<td><label>Proof Of Completion</label></td>
						<td><input type="text" name="proofOfCompletionLink" value="${THE_REIMBURSEMENT.proofOfCompletionLink}"/></td>
					</tr>
					<tr>
						<td><label>Manager Email</label></td>
						<td><input type="text" name="managerEmail" value="${THE_REIMBURSEMENT.managerEmail}"/></td>
					</tr>
					<tr>
						<td><label>Submit Date</label></td>
						<td><input type="text" name="submitDate" value="${THE_REIMBURSEMENT.submitDate}"/></td>
					</tr>
					<tr>
						<td><label>Start Date</label></td>
						<td><input type="text" name="courseStartDate" value="${THE_REIMBURSEMENT.courseStartDate}"/></td>
					</tr>
					<tr>
						<td><label>Completion Date</label></td>
						<td><input type="text" name="courseEndDate" value="${THE_REIMBURSEMENT.courseEndDate}"/></td>
					</tr>
					<tr>
						<td><label>Approving Manager's Email</label></td>
						<td><input type="text" name="approvedByUsername" value="${THE_REIMBURSEMENT.approvedByUsername}"/></td>
					</tr>
					<tr>
						<td><label>Approval Date</label></td>
						<td><input type="text" name="approvalDate" value="${THE_REIMBURSEMENT.approvalDate}"/></td>
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
			<a href="ReimbursementControllerServlet2">Go Back</a>
		</p>
		
	</div>
</body>
</html>
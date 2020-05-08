package com.mycompany.meven;

public class Reimbursement {

		private String firstName;
		private String lastName;
		private String userName;
		private String schoolName;
		private String receiptLink;
		private String managerEmail;
		private String submitDate;
		private String courseStartDate;
		private String courseEndDate;
		private String approvedByUsername;
		private String approvalDate;
		private String proofOfCompletionLink;
		private int ReimbursementId;
		
		public Reimbursement(String firstName, String lastName, String userName, String schoolName, String receiptLink,
				String managerEmail, String submitDate, String courseStartDate, String courseEndDate,
				String approvedByUsername, String approvalDate, String proofOfCompletionLink, int reimbursementId) {
			
			this.firstName = firstName;
			this.lastName = lastName;
			this.userName = userName;
			this.schoolName = schoolName;
			this.receiptLink = receiptLink;
			this.managerEmail = managerEmail;
			this.submitDate = submitDate;
			this.courseStartDate = courseStartDate;
			this.courseEndDate = courseEndDate;
			this.approvedByUsername = approvedByUsername;
			this.approvalDate = approvalDate;
			this.proofOfCompletionLink = proofOfCompletionLink;
			this.ReimbursementId = reimbursementId;
		}

		@Override
		public String toString() {
			return "Reimbursement [firstName=" + firstName + ", lastName=" + lastName + ", userName=" + userName
					+ ", schoolName=" + schoolName + ", receiptLink=" + receiptLink + ", managerEmail=" + managerEmail
					+ ", submitDate=" + submitDate + ", courseStartDate=" + courseStartDate + ", courseEndDate="
					+ courseEndDate + ", approvedByUsername=" + approvedByUsername + ", approvalDate=" + approvalDate
					+ ", proofOfCompletionLink=" + proofOfCompletionLink + ", ReimbursementId=" + ReimbursementId + "]";
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public String getSchoolName() {
			return schoolName;
		}

		public void setSchoolName(String schoolName) {
			this.schoolName = schoolName;
		}

		public String getReceiptLink() {
			return receiptLink;
		}

		public void setReceiptLink(String receiptLink) {
			this.receiptLink = receiptLink;
		}

		public String getManagerEmail() {
			return managerEmail;
		}

		public void setManagerEmail(String managerEmail) {
			this.managerEmail = managerEmail;
		}

		public String getSubmitDate() {
			return submitDate;
		}

		public void setSubmitDate(String submitDate) {
			this.submitDate = submitDate;
		}

		public String getCourseStartDate() {
			return courseStartDate;
		}

		public void setCourseStartDate(String courseStartDate) {
			this.courseStartDate = courseStartDate;
		}

		public String getCourseEndDate() {
			return courseEndDate;
		}

		public void setCourseEndDate(String courseEndDate) {
			this.courseEndDate = courseEndDate;
		}

		public String getApprovedByUsername() {
			return approvedByUsername;
		}

		public void setApprovedByUsername(String approvedByUsername) {
			this.approvedByUsername = approvedByUsername;
		}

		public String getApprovalDate() {
			return approvalDate;
		}

		public void setApprovalDate(String approvalDate) {
			this.approvalDate = approvalDate;
		}

		public String getProofOfCompletionLink() {
			return proofOfCompletionLink;
		}

		public void setProofOfCompletionLink(String proofOfCompletionLink) {
			this.proofOfCompletionLink = proofOfCompletionLink;
		}

		public int getReimbursementId() {
			return ReimbursementId;
		}

		public void setReimbursementId(int reimbursementId) {
			ReimbursementId = reimbursementId;
		}

		public Reimbursement(String firstName, String lastName, String userName, String schoolName, String receiptLink,
				String managerEmail, String submitDate, String courseStartDate, String courseEndDate,
				String approvedByUsername, String approvalDate, String proofOfCompletionLink) {
			super();
			this.firstName = firstName;
			this.lastName = lastName;
			this.userName = userName;
			this.schoolName = schoolName;
			this.receiptLink = receiptLink;
			this.managerEmail = managerEmail;
			this.submitDate = submitDate;
			this.courseStartDate = courseStartDate;
			this.courseEndDate = courseEndDate;
			this.approvedByUsername = approvedByUsername;
			this.approvalDate = approvalDate;
			this.proofOfCompletionLink = proofOfCompletionLink;
		}
		
		
}

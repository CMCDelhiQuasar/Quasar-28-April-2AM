<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<sj:head jqueryui="true" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Insert title here</title>
<script type="text/javascript">
	function validatecheque() {
		alert("come to validate method");
		var strchequeNumber = document.forms["chequedetails"]["chequeNumber"].value;
		var chequeNumber = parseInt(strchequeNumber, 10);

		var bankName = document.forms["chequedetails"]["bankName"].value;
		var issueDate = document.forms["chequedetails"]["issueDate"].value;

		if (chequeNumber <= 0 || strchequeNumber == "") {
			alert("Please check Cheque Number !!");
			return false;
		}
		if (bankName.length < 3) {
			alert("Please enter at least 3 character in bank name");
			return false;
		}
		if (issueDate == "") {
			alert("Please select date!!");
			return false;
		}

		return true;
	}
</script>
</head>

<body>

	<s:if test="#session.REGISTERING_STUDENT_EMAIL==null">
		You are not within the session .Please Login
		<jsp:forward page="registration.jsp" />
	</s:if>
	<s:else>
		<s:div id="studentdetail">
			<h2>Welcome</h2>
			Name:- <s:property value="#session.shagird.name" />
			<br />
			Email:- <s:property value="#session.shagird.emailId" />
			<br />
			Contact:- <s:property value="#session.shagird.contactNumber" />
			<br />
			Payment Objects:- <s:property
				value="#session.shagird.paymentsList.size" />
			<br />
			<s:iterator var="p" value="#session.shagird.paymentsList">
				<s:property value="#p.paymentDetails.proposedAmount" />  :  <s:property
					value="#p.paymentDetails.proposedDate" />   :  <s:property
					value="#p.paymentComment" />
				<br>
			</s:iterator>
		</s:div>
		<h3>
			<a href="cancelregistration">Cancel Registration</a>
		</h3>

		<hr>
			<h1>Registration Object Details</h1>
			Registration Proposed Amount:- <s:property
				value="#session.shagird.paymentsList.get(0).paymentDetails.proposedAmount" />
			<br />Registration Deposited Amount:- <s:property
				value="#session.shagird.paymentsList.get(0).paymentDetails.depositedAmount" />
			<br /> Registration Proposed Date : <s:property
				value="#session.shagird.paymentsList.get(0).paymentDetails.proposedDate" />
			<br />Registration Payment Date:- <s:property
				value="#session.shagird.paymentsList.get(0).paymentDetails.paymentDate" />
			<br />Registration Payment Comment:- <s:property
				value="#session.shagird.paymentsList.get(0).paymentComment" />
			<br />
			<hr>

				<h1>Cheque Details</h1>
				<s:form name="chequedetails" action="cheque" method="post"
					onsubmit="return validatecheque()">
					<s:textfield label="Cheque Number" labelSeparator=""
						labelposition="left" name="chequeNumber" />
					<s:textfield label="Drawn on/Bank Name" labelSeparator=""
						labelposition="left" name="bankName" />
					<sj:datepicker changeMonth="true" changeYear="true"
						name="issueDate" label="Issue Date" labelSeparator=""
						labelposition="left" />
					<s:submit type="image" value="Proceed" src="images/forward.png"
						align="right" />
				</s:form>
	</s:else>

</body>
</html>
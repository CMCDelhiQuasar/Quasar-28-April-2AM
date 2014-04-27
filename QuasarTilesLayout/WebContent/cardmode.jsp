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
	function validatecard() {
		alert("come to validate method");
		var cardtype = document.getElementsByName("cardType");

		var strcardNumber = document.forms["regmode"]["cardNumber"].value;
		var cardNumber = parseInt(strcardNumber, 10);

		var strtransactionId = document.forms["regmode"]["transactionId"].value;
		var transactionId = parseInt(strtransactionId, 10);

		var cardExpiryDate = document.forms["regmode"]["cardExpiryDate"].value;

		if (cardNumber < 0 || strcardNumber == "") {
			alert("Please enter valid card number!!");
			return false;
		}

		if (transactionId < 0 || strtransactionId == "") {
			alert("Please enter valid transaction id!!");
			return false;
		}

		if (cardExpiryDate == "") {
			alert("Please select Card Expiry Date");
			return false;
		}

		var check = -1;
		for (var i = 0; i < cardtype.length; i++) {
			// 	 alert("Come for radio list");
			if (cardtype[i].checked) {
				// alert("Value is incremented!!");
				check += 1;
			}
		}
		if (check == -1) {
			alert("Please select at least one radio button");
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
				<br/>
			</s:iterator>
		</s:div>
		<h3>
			<a href="cancelregistration">Cancel Registration</a>
		</h3>

		<hr/>
			<h1>Registration Object Details</h1>
			Registration Proposed Amount:- <s:property
				value="#session.shagird.paymentsList.get(0).paymentDetails.proposedAmount" />
			<br/>Registration Deposited Amount:- <s:property
				value="#session.shagird.paymentsList.get(0).paymentDetails.depositedAmount" />
			<br/> Registration Proposed Date : <s:property
				value="#session.shagird.paymentsList.get(0).paymentDetails.proposedDate" />
			<br/>Registration Payment Date:- <s:property
				value="#session.shagird.paymentsList.get(0).paymentDetails.paymentDate" />
			<br/>Registration Payment Comment:- <s:property
				value="#session.shagird.paymentsList.get(0).paymentComment" />
			<br/>
			<hr/>
				<s:form name="regmode" action="cardmode" method="post"
					onsubmit="return validatecard()">
					<s:radio label="Card Type" labelSeparator="" labelposition="left"
						name="cardType" list="{'Debit Card','Credit Card'}" />
					<s:textfield label="Card Number" labelSeparator=""
						labelposition="left" name="cardNumber" />
					<s:textfield label="Transaction ID" labelSeparator=""
						labelposition="left" name="transactionId" />
					<sj:datepicker label="Expiry Date" changeMonth="true"
						changeYear="true" labelSeparator="" labelposition="left"
						name="cardExpiryDate" displayFormat="dd/mm/yy" />
					<s:submit type="image" value="Proceed" src="images/forward.png"
						align="right" />
				</s:form>
	</s:else>

</body>
</html>
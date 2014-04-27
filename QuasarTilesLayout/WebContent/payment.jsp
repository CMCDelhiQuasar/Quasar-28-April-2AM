<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="sj" uri="/struts-jquery-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<style type="text/css">
#studentdetail {
	background-color: white;
	font-family: sans-serif;
	padding: 10px;
	-webkit-border-radius: 4px;
	-moz-border-radius: 4px;
	border-radius: 4px;
	box-shadow: 0 4px 4px -4px rgba(0, 0, 0, 0.7);
	-moz-box-shadow: 0 4px 4px -4px rgba(0, 0, 0, 0.7);
	-webkit-box-shadow: 0 4px 6px -5px rgba(0, 0, 0, 0.8);
	padding: 10px;
}
</style>
<sj:head jqueryui="true" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<script type="text/javascript">
	function paymentvalidate() {

		//alert("come to validate method");
		var strproposedAmount = document.forms["regpayment"]["proposedAmount"].value;
		var proposedAmount = parseInt(strproposedAmount, 10);

		var strdepositedAmount = document.forms["regpayment"]["depositedAmount"].value;
		var depositedAmount = parseInt(strdepositedAmount, 10);

		var proposedDate = document.forms["regpayment"]["proposedDate"].value;
		var paymentDate = document.forms["regpayment"]["paymentDate"].value;

		var comments = document.forms["regpayment"]["comments"].value;
		var paymentMode = document.getElementsByName("paymentMode");

		if (proposedAmount < 0 || strproposedAmount == "") {
			alert("Proposed Amount can not be less then 0 !!!");
			return false;
		}

		if (depositedAmount<0  ||strdepositedAmount=="" || depositedAmount>proposedAmount) {
			alert("Please check deposited amount");
			return false;
		}

		if (proposedDate == "") {
			alert("Please select Proposed Date!!");
			return false;
		}

		if (paymentDate == "") {
			alert("Please select Payment Date!!");
			return false;
		}

		if (comments.length < 1) {
			alert("Please enter atleast 5 charcter in Comment Section!!");
			return false;
		}

		//	window.confirm(paymentMode1[2].checked);

		var check = -1;
		for (var i = 0; i < paymentMode.length; i++) {
			// 	 alert("Come for radio list");
			if (paymentMode[i].checked) {
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
<title>Insert title here</title>
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
				Proposed Amount : <s:property
					value="#p.paymentDetails.proposedAmount" />
				<br /> Proposed Date 
				<s:property value="#p.paymentDetails.proposedDate" />
				<br /> Payment Comment : 
				<s:property value="#p.paymentComment" />
				<br />
			</s:iterator>
		</s:div>
		<h3>
			<a href="cancelregistration">Cancel Registration</a>
		</h3>
	</s:else>

	<h1>Payment Page</h1>
	<s:form name="regpayment" method="post" action="payment"
		onsubmit="return paymentvalidate()">
		<s:set var="pa"
			value="#session.shagird.paymentsList.get(0).paymentDetails.proposedAmount" />
		<br />

		<s:textfield label="Proposed Amount" labelSeparator=""
			labelposition="left" name="proposedAmount" value="%{#pa}"
			disabled="true" />

		<s:textfield label="Deposited Amount" labelSeparator=""
			labelposition="left" name="depositedAmount" />
		<sj:datepicker name="proposedDate" displayFormat="dd/mm/yy"
			changeMonth="true" changeYear="true" label="Proposed Date"
			labelposition="left" />
		<sj:datepicker name="paymentDate" changeMonth="true" changeYear="true"
			label="Payment Date" labelposition="left" displayFormat="dd/mm/yy" />
		<s:textarea name="comments" label="Comments" labelSeparator=""
			labelposition="left" />
		<s:radio
			list="#{'cash':'Cash','online':'Online','cheque':'Cheque','dd':'DD','card':'Card'}"
			name="paymentMode" label="Mode of Payment" labelSeparator=""
			labelposition="left" />

		<s:submit type="image" value="Proceed" src="images/forward.png"
			align="right" />
		<s:submit type="image" value="Back" src="images/back.png" align="left" />
	</s:form>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style type="text/css">
td {
	height: 10px;
	font-family: sans-serif;
	font-style: oblique;
	line-height: 20px;
}

table {
	border-collapse: collapse;
}
#name
{
font-size: large;
font-style: oblique;
}
</style>

</head>
<body>
	This is Registration Confirmation Page

	<table>
		<tr id="name" >
		<td width="40px" ></td>
			<td><h2>
					<s:property value="#session.shagird.name" />
				</h2></td>
			<td width="30px"></td>
			<td><h4><s:property value="#session.shagird.contactNumber" /></h4></td>

		</tr>
		<tr>
		<td width="40px" ></td>
		<td>
		<h2><s:property value="#session.shagird.emailId" /></h2>
		</td>
		</tr>
	</table>
	<table border="1" width="">
		<tr>
			<td colspan="2">
				<h2>Basic Details Of Student</h2>
			</td>
		</tr>
		<tr>
			<td><h4>Name:-</h4></td>
			<td><s:property value="#session.shagird.name" /></td>
		</tr>

		<tr>
			<td><h4>Email:-</h4></td>
			<td><s:property value="#session.shagird.emailId" /></td>
		</tr>

		<tr>
			<td><h4>Contact:-</h4></td>
			<td><s:property value="#session.shagird.contactNumber" /></td>
		</tr>
	</table>
	<table>
		<tr>
			<td colspan="2">
				<h2>Fee Details Of Student</h2>
			</td>
		</tr>
		<tr>
			<td><h4>Course Fee:-</h4></td>
			<td><s:property value="#session.shagird.feeDetails.courseFees" /></td>
		</tr>

		<tr>
			<td><h4>Service Tax:-</h4></td>
			<td><s:property value="#session.shagird.feeDetails.serviceTax" /></td>
		</tr>

		<tr>
			<td><h4>Total Fee:-</h4></td>
			<td><s:property value="#session.shagird.feeDetails.totalFee" /></td>
		</tr>

		<s:iterator var="p" value="#session.shagird.paymentsList">

			<tr>
				<td><h4>Proposed Amount :-</h4></td>
				<td><s:property value="#p.paymentDetails.proposedAmount" /></td>
			</tr>

			<tr>
				<td><h4>Proposed Date :-</h4></td>
				<td><s:property value="#p.paymentDetails.proposedDate" /></td>
			</tr>

			<tr>
				<td><h4>Payment Comment :-</h4></td>
				<td><s:property value="#p.paymentComment" /></td>
			</tr>
		</s:iterator>
	</table>
	<table>
		<tr>
			<td colspan="2">
				<h2>Registration Details Of Student</h2>
			</td>
		</tr>
		<tr>
			<td><h4>Registration Proposed Amount:-</h4></td>
			<td><s:property
					value="#session.shagird.paymentsList.get(0).paymentDetails.proposedAmount" /></td>
		</tr>

		<tr>
			<td><h4>Registration Deposited Amount:-</h4></td>
			<td><s:property
					value="#session.shagird.paymentsList.get(0).paymentDetails.depositedAmount" /></td>
		</tr>

		<tr>
			<td><h4>Registration Proposed Date :</h4></td>
			<td><s:property
					value="#session.shagird.paymentsList.get(0).paymentDetails.proposedDate" /></td>
		</tr>

		<tr>
			<td><h4>Registration Payment Date :</h4></td>
			<td><s:property
					value="#session.shagird.paymentsList.get(0).paymentDetails.paymentDate" /></td>
		</tr>
		<tr>
			<td><h4>Registration Payment Comment :</h4></td>
			<td><s:property
					value="#session.shagird.paymentsList.get(0).paymentComment" /></td>
		</tr>

	</table>

	<s:form action="confirmregistration" method="post">
		<s:label label="Press Submit to Confirm" />
		<s:submit />
	</s:form>

</body>
</html>
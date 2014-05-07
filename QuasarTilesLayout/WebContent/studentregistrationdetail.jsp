<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<style>
</style>
<script type="text/javascript">
	function display() {

		var ch = document.getElementsByName("paymenttype");
		var check = -1;

		if (ch[0].checked == true) {
			//	alert("come to fullfee");
			document.getElementsByName("totalinstallments").style.display = 'none';

		}

		if (ch[1].checked == true) {
			//	alert("come to installment");
			document.getElementsByName("totalinstallments").style.display = 'none';
		}

	}
</script>



<sj:head jqueryui="true" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Student Registration Page...</title>



</head>
<body>



	<div>
		<h3 align="center">
			<img src="images/student.png" alt="Student" /> Student Registration
			Details
		</h3>
	</div>
	<h2>Basic Details</h2>
	<s:form name="regform" theme="simple" action="registration"
		method="post">
		<table border="0">
			<s:div id="basicDetails">
				<tr>
					<td><s:label value="Name of the Student" labelSeparator=""
							labelposition="left" /></td>
					<td><s:textfield label="Name of the Student"
							labelSeparator="" labelposition="left" name="studentname" /></td>
					<td><s:fielderror fieldName="studentname" /></td>
				</tr>
				<tr>
					<td><s:label value="Email Id" labelSeparator=""
							labelposition="left" /></td>
					<td><s:textfield label="Email Id" labelSeparator=""
							labelposition="left" name="studentemail" /></td>
					<td><s:fielderror fieldName="studentemail" /></td>
				</tr>
				<tr>
					<td><s:label value="Course" labelSeparator=""
							labelposition="left" /></td>
					<td><s:select name="coursename" list="%{#{'Other':'Other'}}"
							label="Course" labelSeparator="">
							<s:optgroup label="6 Weeks"
								list="#{'Java SE':'Java SE','Java EE':'Java EE','Android':'Android','.Net':'.Net','Php':'Php','C/C++':'C/C++','Cloud Computing':'Cloud Computing','Java EE':'Java EE','Java SE':'Java SE','Java EE':'Java EE'}" />
							<s:optgroup label="6 Months"
								list="#{'Java SE':'Java SE','Java EE':'Java EE','Android':'Android','.Net':'.Net','Php':'Php','C/C++':'C/C++','Cloud Computing':'Cloud Computing','Java EE':'Java EE','Java SE':'Java SE','Java EE':'Java EE'}" />
							<s:optgroup label="6 Months Weekend"
								list="#{'Java SE':'Java SE','Java EE':'Java EE','Android':'Android','.Net':'.Net','Php':'Php','C/C++':'C/C++','Cloud Computing':'Cloud Computing','Java EE':'Java EE','Java SE':'Java SE','Java EE':'Java EE'}" />
							<s:optgroup label="6 Weeks Weekend"
								list="#{'Java SE':'Java SE','Java EE':'Java EE','Android':'Android','.Net':'.Net','Php':'Php','C/C++':'C/C++','Cloud Computing':'Cloud Computing','Java EE':'Java EE','Java SE':'Java SE','Java EE':'Java EE'}" />
							<s:optgroup label="Edge"
								list="#{'.Net':'.Net','Core Java':'Core Java'}" />
						</s:select></td>
					<td><s:fielderror fieldName="coursename" /></td>
				</tr>
				<tr>
					<td><s:label value="Contact Number" labelSeparator=""
							labelposition="left" /></td>
					<td><s:textfield label="Contact Number" labelSeparator=""
							labelposition="left" name="contact" /></td>
					<td><s:fielderror fieldName="contact" /></td>
				</tr>
			</s:div>
		</table>
		<hr />
		<hr />

		<h2>Fee Details</h2>
		<table border="0">
			<s:div id="paymentDetails">
				<tr>
					<td><s:label value="Course Fees" labelSeparator=""
							labelposition="left" /></td>
					<td><sj:autocompleter label="Course Fees" labelSeparator=""
							labelposition="left" name="coursefee" value="10000"
							list="{'10000','12000','15000','150000'}" /></td>
				</tr>

				<tr>
					<td><s:label value="Service Tax(%)" labelSeparator=""
							labelposition="left" /></td>
					<td><sj:autocompleter label="Service Tax(%)" labelSeparator=""
							value="10.45" labelposition="left" name="servicetax"
							list="{'10.45','20','30','40'}" /></td>
				</tr>

				<tr>
					<td><s:label value="Discount(%)" labelSeparator=""
							labelposition="left" /></td>
					<td><sj:autocompleter label="Discount(%)" labelSeparator=""
							value="10" labelposition="left" name="discount"
							list="{'10','20','30','40'}" /></td>
				</tr>

				<tr>
					<td><s:label value="Fine(if any)" labelSeparator=""
							labelposition="left" /></td>
					<td><sj:autocompleter label="Fine(if any)" labelSeparator=""
							value="10" labelposition="left" name="fine"
							list="{'10','20','30','40'}" /></td>
				</tr>

				<tr>
					<td><s:label value="Total" labelSeparator=""
							labelposition="left" /></td>
					<td><s:textfield label="Total" labelSeparator=""
							labelposition="left" name="total" disabled="true" value="0.0" /></td>
				</tr>
			</s:div>
		</table>
		<hr />
		<hr />
		<h2>Payment Details</h2>
		<table>
			<s:div id="radio">
				<tr>
					<td><s:label value="Payment Type" labelSeparator=""
							labelposition="left" /></td>
					<td><s:radio list="{'Full Fees','Installment'}"
							onclick="display()" name="paymenttype" label="Payment Type"
							labelSeparator="" labelposition="left" /></td>
					<td><s:fielderror fieldName="paymenttype" /></td>
				</tr>
			</s:div>
			<s:div>
				<tr>
					<td><s:label value="Number of Installments" labelSeparator=""
							labelposition="left" /></td>
					<td><s:select name="totalinstallments" cssStyle=""
							list="%{#{'Select':'Select'}}" label="Number of Installments"
							labelSeparator="">
							<s:optgroup
								list="#{'2':'2','3':'3','4':'4','5':'5','6':'6','7':'7','8':'8','9':'9','10':'10'}" />
						</s:select></td>
					<td><s:fielderror fieldName="totalinstallments" /></td>
				</tr>

				<tr>
					<td><s:label value="Registration Amount" labelSeparator=""
							labelposition="left" /></td>
					<td><s:textfield name="registrationamount"
							label="Registration Amount" labelSeparator=""
							labelposition="left" /></td>
					<td><s:fielderror fieldName="registrationamount" /></td>
				</tr>
			</s:div>
		</table>
		<hr />
		<hr />
		<table border="0">
			<tr>
				<s:div>
					<td width="250"></td>
					<td><s:reset value="Reset" src="images/back.png" align="left" /></td>
					<td width="30"></td>

					<td><s:submit type="image" value="Proceed"
							src="images/forward.png" /></td>

				</s:div>
			</tr>
		</table>
	</s:form>
</body>
</html>
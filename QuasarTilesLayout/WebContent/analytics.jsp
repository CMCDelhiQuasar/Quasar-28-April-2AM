<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="sjg" uri="/struts-jquery-grid-tags"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="sj" uri="/struts-jquery-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<sj:head jqueryui="true" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	Hello
	<sjg:grid id="gridtable" caption="Customer Examples" dataType="json"
		href="grid-data-provider" pager="true" gridModel="gridModel"
		rowList="2,5,10" rowNum="5" rownumbers="true" navigator="true"
		navigatorEdit="false" navigatorView="true" navigatorDelete="false"
		navigatorViewOptions="{'width':'700'}" navigatorAdd="false"
		navigatorSearch="false" altRows="true">
		<sjg:gridColumn name="studentId" index="id" title="St.ID"
			formatter="integer" sortable="false" width="20" />
		<sjg:gridColumn name="name" index="name" title="Name" sortable="true"
			width="80" align="center" />
		<sjg:gridColumn name="contactNumber" title="Contact Number"
			sortable="false" width="80" />
		<sjg:gridColumn name="courseName" title="Course Name" sortable="false"
			width="80" />

		<sjg:gridColumn name="feeDetails.totalFee" title="Total Fee"
			formatter="currency" sortable="false" width="100" />
		<sjg:gridColumn name="emailId" title="Email ID" sortable="false" />

		<sjg:gridColumn name="feeDetails.courseFees" title="Course Fee"
			formatter="currency" sortable="false" />
		<sjg:gridColumn name="feeDetails.discountAvailable"
			title="Discount Available" formatter="currency" sortable="false" />
		<sjg:gridColumn name="feeDetails.serviceTax" title="Service Tax"
			sortable="false" />
		<sjg:gridColumn name="feeDetails.fine" title="Fine"
			formatter="currency" sortable="false" />


	</sjg:grid>

</body>
</html>
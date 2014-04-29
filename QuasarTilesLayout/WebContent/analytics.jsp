<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="sjg" uri="/struts-jquery-grid-tags"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@taglib prefix="sjc" uri="/struts-jquery-chart-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<sj:head jqueryui="true" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>Number of Registration vs Date</h3>
	<table border="0">
		<s:form action="analytics" theme="simple">
			<tr>
				<td><s:label value="Start Date" /></td>
				<td><sj:datepicker name="startdate" displayFormat="dd/mm/yy" /></td>
				<td><s:label value="End Date" /></td>
				<td><sj:datepicker name="enddate" displayFormat="dd/mm/yy" /></td>
			</tr>
			<tr>
				<td><s:checkbox name="checkall" /></td>
				<td>All</td>
				<td><s:select name="allcourse" list="{'6 months','6 weeks'}" /></td>
			</tr>
			<tr>
				<td><s:checkbox name="checkj2se" /></td>
				<td><s:label value="J2SE" /></td>
				<td><s:select name="j2seduration" list="{'6 months','6 weeks'}" /></td>
			</tr>

			<tr>
				<td><s:checkbox name="checkj2ee" /></td>
				<td><s:label value="J2EE" /></td>
				<td><s:select name="j2eeduration" list="{'6 months','6 weeks'}" /></td>
			</tr>
			<tr>
				<td><s:checkbox name="checkandriod" /></td>
				<td><s:label value="Anriod" /></td>
				<td><s:select name="andriodduration"
						list="{'6 months','6 weeks'}" /></td>
			</tr>
			<tr>
				<td><s:checkbox name="checkdotnet" /></td>
				<td><s:label value=">Net" /></td>
				<td><s:select name="dotnetduration"
						list="{'6 months','6 weeks'}" /></td>
			</tr>
			<tr>
				<td><s:checkbox name="checkphp" /></td>
				<td><s:label value="PHP" /></td>
				<td><s:select name="phpduration" list="{'6 months','6 weeks'}" /></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td><s:submit value="Analyse" /></td>
			</tr>

		</s:form>
	</table>
	<h3>Chart with values from a List or a Map</h3>
	<sjc:chart id="chartPoints" cssStyle="width: 600px; height: 400px;"
		xaxisLabel="Label-X" yaxisLabel="Label-Y" 
		xaxisPosition="top" xaxisColor="#666" xaxisTickColor="#aaa"  
		
		xaxisMode="time"
    	xaxisTimeformat="%d.%m"
    xaxisTickSize="[2, 'month']"
    	
		
		  >
		<sjc:chartData label="List -Points-" list="%{allCourseList}"
			color="#ff0000" points="{ show: false }" lines="{ show: true }"
			curvedLines="true" curvedLinesFit="true" clickable="true"
			hoverable="true" />
	</sjc:chart>

	<!--  <sjg:grid id="gridtable" caption="Customer Examples" dataType="json"
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
-->
</body>
</html>
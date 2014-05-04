<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<sj:head jqueryui="true" />
</head>
<body>

	<sj:accordion id="student" collapsible="false" openOnMouseover="false"
		heightStyle="content" animate="true">
		<sj:accordionItem title="Student Details">
			<ul type="none">
				<li><div>
						<a href="registration.jsp"> <img src="images/addstudent.png" /></a>
					</div></li>
				<li><img src="images/deletestudent.png"></li>
				<li><img src="images/starred.png"></li>
			</ul>
		</sj:accordionItem>

		<sj:accordionItem title="Pending Payment">
			<ol>
				<li><a href="registration.jsp"><img src="images/002.png"></img></a></li>
				<li>student two</li>
				<li>student three</li>
				<li><a href="pendingpayment"><img src="images/calendar.png"/></a></li>
			</ol>
		</sj:accordionItem>

		<sj:accordionItem title="Add History">
			<ol>
				<li>abc gf</li>
				<li>def</li>
			</ol>


			<sj:accordionItem title="Print">
				<ol>
					<li>Reciept</li>
					<li>Report</li>
				</ol>
			</sj:accordionItem>
		</sj:accordionItem>

	</sj:accordion>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
html {
	font-size: 15px;
}
body {
	color: #333;
	font-family: arial, helvetica, sans-serif;
	color: #333;
	font-size: 13px;
}
body {
	font-family: Arial, sans-serif;
	font-size: 13px;
}
html {
	color: #333;
}
html {
	font-size: 13px;
}
body {
	background-color: #1568b4;
}
hr {
	background-color: #EEE;
	border: 0;
	height: 1px;
}
#container {
	background-image: url("images/dots.png");
	border: 1px solid #DDD;
	padding: 20px;
	margin-top: 20px;
	-webkit-border-radius: 4px;
	-moz-border-radius: 4px;
	border-radius: 4px;
	border: 1px solid #E9E9E9;
	-webkit-border-radius: 4px;
	box-shadow: 0 4px 4px -4px rgba(0, 0, 0, 0.7);
	-moz-box-shadow: 0 4px 4px -4px rgba(0, 0, 0, 0.7);
	-webkit-box-shadow: 0 4px 6px -5px rgba(0, 0, 0, 0.8);
	border: 1px solid #DDD;
	box-shadow: 0 1px 4px rgba(0, 0, 0, 0.5);
}

#content {
	background-color: white;
	border: 1px solid #DDD;
	margin: 20px 0;
	padding: 20px;
	-webkit-border-radius: 4px;
	-moz-border-radius: 4px;
	border-radius: 4px;
	box-shadow: 0 4px 4px -4px rgba(0, 0, 0, 0.7);
	-moz-box-shadow: 0 4px 4px -4px rgba(0, 0, 0, 0.7);
	-webkit-box-shadow: 0 4px 6px -5px rgba(0, 0, 0, 0.8);
}

#sidemenu {
	/* -webkit-box-shadow: 0 1px 4px rgba(0, 0, 0, 0.2); */
	/*box-shadow: 0 1px 4px rgba(0, 0, 0, 0.2);*/
	
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body topmargin="0">

	<table id="container" width="1000" cellspacing="0" align="center"
		bgcolor="white">
		<tr>
			<td colspan="2" height="70"><tiles:insertAttribute name="header" /></td>
		</tr>

		<tr>
			<td width="250" id="sidemenu" valign="top"><tiles:insertAttribute
					name="sideMenu" /></td>
			<td width="600" id="content"><tiles:insertAttribute name="body" /></td>
		</tr>
		<tr>
			<td colspan="2" height="70"><tiles:insertAttribute name="footer" />
			</td>
		</tr>
	</table>

</body>
</html>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@taglib prefix="sjg" uri="/struts-jquery-grid-tags"%>
<%@taglib prefix="sjc" uri="/struts-jquery-chart-tags"%>

<table width="400" align="center" cellpadding="10" bgcolor="#a362b3">
	<tr>
		<td>
			<p>Quasar is you for creating this tutorial. It's very clearly
				written. I'm having a problem adding a page to "Part 4: Struts 2
				Tiles Plugin Tutorial with Example". I added the necessary code to
				struts.xml, tiles.xml, menu.jsp and linkAction.java but it's not
				working, the feedback in the Console section of Eclipse rolls on and
				on and the page does not render. Could you tell me what I missed or
				what files have to be changed to add a page. Thank you</p>
		</td>

		<td>

			<h3>Chart with values from a List or a Map</h3> <sjc:chart
				id="chartPoints" cssStyle="width: 600px; height: 400px;"
				xaxisLabel="Label-X" yaxisLabel="Label-Y" xaxisColor="#ff0000"
				xaxisMax="10" xaxisMin="-5" xaxisPosition="top"
				xaxisTickColor="#00ff00">
				<sjc:chartData label="List -Points-" list="{330,934,278}"
					color="#ff0000" points="{ show: true }" lines="{ show: true }"
					curvedLines="true" curvedLinesFit="true" clickable="true"
					hoverable="true" />
			</sjc:chart>
		</td>
</table>
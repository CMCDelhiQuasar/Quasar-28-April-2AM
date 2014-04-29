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
	<tr>

		<sjg:grid id="gridtable" caption="Customer Examples" dataType="json"
			href="grid-data-provider" pager="true" gridModel="gridModel"
			rowList="5,10,20" rowNum="15" rownumbers="true" navigator="true"
			navigatorEdit="false" navigatorView="true" navigatorDelete="false"
			navigatorAdd="false" navigatorSearch="false" altRows="true">
			<sjg:gridColumn name="studentId" index="id" title="St.ID"
				formatter="integer" sortable="false" width="20" />
			<sjg:gridColumn name="name" index="name" title="Name" sortable="true"
				width="80" align="center" />
			<sjg:gridColumn name="contactNumber" title="Contact Number"
				sortable="false" width="80" />
			<sjg:gridColumn name="courseName" title="Course Name"
				sortable="false" width="80" />

			<sjg:gridColumn name="feeDetails.totalFee" title="Total Fee"
				formatter="currency" sortable="false" width="100" />
			<sjg:gridColumn name="emailId" title="Email ID" sortable="false"
				width="80" />

			<sjg:gridColumn name="feeDetails.courseFees" title="Course Fee"
				formatter="currency" sortable="false" width="50" />
			<sjg:gridColumn name="feeDetails.discountAvailable"
				title="Discount Available" formatter="currency" width="20"
				sortable="false" />
			<sjg:gridColumn name="feeDetails.serviceTax" title="Service Tax"
				sortable="false" width="20" />
			<sjg:gridColumn name="feeDetails.fine" title="Fine"
				formatter="currency" sortable="false" width="20" />

		</sjg:grid>

	</tr>
</table>
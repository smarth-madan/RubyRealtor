<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ page session="true"%>

<h3>Contact us/ Appointment Page</h3>
<hr />
<div>

	<br />


<form action="registerFromFB" method="post"> 
		<table>
			<tr>
				<td><b>*First Name: </b></td>
				<td><input type="text" name="fName" /></td>
			</tr>
			<tr>
				<td><b>*Last Name: </b></td>
				<td><input type="text" name="lName" /></td>
			</tr>
			<tr>
				<td><b>*Email-Id: </b></td>
				<td><input type="text" name="fName" /></td>
			</tr>
			<tr>
				<td><b>*Phone Number: </b></td>
				<td><input type="text" name="phoneNumber" /></td>
			</tr>
			<tr>
				<td><b>Street: </b></td>
				<td><input type="text" name="street" /></td>
			</tr>
			<tr>
				<td><b>City: </b></td>
				<td><input type="text" name="city" /></td>
			</tr>
			<tr>
				<td><b>State: </b></td>
				<td><input type="text" name="state" /></td>
			</tr>
			<tr>
				<td><b>Zipcode: </b></td>
				<td><input type="text" name="zipcode" /></td>
			</tr>
			<tr>
				<td><b>Marital Status: </b></td>
				<td><select id="maritalStatus" name="martial_status"
					data-inline="true">
						<option value="SINGLE">Single</option>
						<option value="ANNULLED">Annulled</option>
						<option value="DIVORCED">Divorced</option>
						<option value="MARRIED">Married</option>
						<option value="SEPARATED">Separated</option>
						<option value="WIDOWED">Widowed</option>
						<option value="UNKNOWN"{selected} >Unknown</option>
				</select></td>
			</tr>
			<tr>
				<td><b>Salary Range:: </b></td>
				<td>Min: <input type="text" name="salary_min_val"/> Max: <input type="text"  name="salary_max_val"/></td>
			</tr>
			<tr>
				<td><b>Appointment </b></td>
				<td><select id="appointment" name="appointment"
					data-inline="true">
						<option value="yes">Yes</option>
						<option value="no">No</option>
						
				</select></td>
			</tr>
			<tr>
				<td><b>Tentative Date/Time: </b></td>
				<td>
	  				<input type="Text" name="time" id="demo1" maxlength="25" size="25"><a href="javascript:NewCal('demo1','ddmmmyyyy',true,24)"><img src="resources/images/cal.gif" width="16" height="16" border="0" alt="Pick a date"></a>
	  				<span class="descriptions">pick a date..</span>
	  			</td>
			</tr>
			<tr>
				<td>

					<td><input type="Submit" value="Register" /></td>
			</tr>
		</table>
	</form> 
<hr /></div>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ page session="true" %>

<h3>Edit My Profile</h3>
<hr />
<form method="post" action="update">
<table style="width:50%;align:left"  class="formatHTML5">
	<tr align="left" style="background-color:grey;">
		<td ><h3>Edit Personal Info </h3></td><td></td>
	</tr>
	<tr>
		<td><b>Realtor ID:</b></td>
		<td><input name="realtorId" type="text" size="30" disabled value="<c:out value="${myProfile.realtorId}"/>" /></td>
	</tr>
	<tr>
		<td><b>First Name:</b></td>
		<td><input name="fname" type="text" size="30" value="<c:out value="${myProfile.fname}"/>" /></td>
	</tr>
	<tr>
		<td><b>Last Name:</b></td>
		<td><input name="lname" type="text" size="30" value="<c:out value="${myProfile.lname}"/>" /></td>
	</tr>
	<tr>
		<td><b>Street:</b></td>
		<td><input name="street" type="text"  size="30" value="<c:out value="${myProfile.street}"/>" /></td>
	</tr>
	<tr>
		<td><b>City:</b></td>
		<td><input name="city" type="text" size="30" value="<c:out value="${myProfile.city}"/>" /></td>
	</tr>
	<tr>
		<td><b>State:</b></td>
		<td><input name="state" type="text" size="30" value="<c:out value="${myProfile.state}"/>" /></td>
	</tr>
	<tr>
		<td><b>Zipcode:</b></td>
		<td><input name="zipcode" type="text" size="30" value="<c:out value="${myProfile.zipcode}"/>" /></td>
	</tr>
	<tr>
		<td><b>Phone Number:</b></td>
		<td><input name="phoneNumber" type="text" size="30" value="<c:out value="${myProfile.phoneNumber}"/>" /></td>
	</tr>
	<tr>
		<td><b>Email ID:</b></td>
		<td><input name="emailId" type="text" size="30" value="<c:out value="${myProfile.emailId}"/>" /></td>
	</tr>
	<tr>
		<td></td>
		<td><input type="submit"  value="Update" /></td>
	</tr>
	<!-- <td>
		<table border="0">
			<tr><td>
				<form action="/registerFaceBook"> 
					<table >
					<tr><td><b>Facebook Id:</b></td><td><input type="text" name="facebookId" /></td></tr>
					<tr><td><b>Facebook Password:</b></td><td><input type="text" name="facebookPwd" /></td></tr>
					<tr><td><td><input type="Submit" value="Register" /></td></tr>
					</table>
				</form>
			</td></tr>
			</table>
			<hr />
			<table>
			<tr><td>
			<form action="/registerTwitter"> 
					<table>
					<tr><td><b>Twitter Id:</b></td><td><input type="text" name="twitterId" /></td></tr>
					<tr><td><b>Twitter Password:</b></td><td><input type="text" name="twitterPwd" /></td></tr>
					<tr><td><td><input type="Submit" value="Register" /></td></tr>
					</table>
			</form>
			</td></tr>
		</table>
	</td> -->


</table>
</form>


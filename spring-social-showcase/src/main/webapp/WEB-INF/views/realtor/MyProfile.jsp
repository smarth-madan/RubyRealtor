<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ page session="true" %>

<h3>My Profile</h3>
	
<table border="1" width="100%">
<tr border="1" >
	<td><h3> Personal Info </h3></td><td><h3>Facebook/Twitter Registeration</h3></td>
</tr>
<tr border="1">
	<td border="1">
		<table border="0">
			<tr>
				<td><b>First Name:</b></td>
				<td><c:out value="${myProfile.fname}"/></td>
			</tr>
			<tr>
				<td><b>Last Name:</b></td>
				<td><c:out value="${myProfile.lname}"/></td>
			</tr>
			<tr>
				<td><b>Address:</b></td>
				<td><c:out value="${myProfile.address}"/></td>
			</tr>
			<tr>
				<td><b>Realtor ID:</b></td>
				<td><c:out value="${myProfile.realtorId}"/></td>
			</tr>
			<tr>
				<td><b>Email ID:</b></td>
				<td><c:out value="${myProfile.emailId}"/></td>
			</tr>
		</table>
	</td>
	<td>
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
	</td>
</tr>

</table>


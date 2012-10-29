<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ page session="true" %>

<h3>My Profile</h3>
<hr />
<form method="post" action="/myProfile/update">
<table  style="width:50%;" align="left" class="formatHTML5" >
	<tr style="background-color:grey;">
		<th align="left"><h3> Personal Info </h3></th><td align="right" ><h4><a href="<c:url value="/myprofile/edit"/>" style="">Edit</a></h4></td>
	</tr></td>
	</tr>
	<tr>
		<td><b>First Name:</b></td>
		<td><c:out value="${myProfile.fname}"/></td>
	</tr>
	<tr>
		<td><b>Last Name:</b></td>
		<td><c:out value="${myProfile.lname}"/></td>
	</tr>
	<tr>
		<td><b>Street:</b></td>
		<td><c:out value="${myProfile.street}"/></td>
	</tr>
	<tr>
		<td><b>City:</b></td>
		<td><c:out value="${myProfile.city}"/></td>
	</tr>
	<tr>
		<td><b>State:</b></td>
		<td><c:out value="${myProfile.state}"/></td>
	</tr>
	<tr>
		<td><b>Zipcode:</b></td>
		<td><c:out value="${myProfile.zipcode}"/></td>
	</tr>
	<tr>
		<td><b>Realtor ID:</b></td>
		<td><c:out value="${myProfile.realtorId}"/></td>
	</tr>
	<tr>
		<td><b>Email ID:</b></td>
		<td><c:out value="${myProfile.emailId}"/></td>
	</tr>
	<tr>
		<td><b>Phone Number:</b></td>
		<td><c:out value="${myProfile.phoneNumber}"/></td>
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


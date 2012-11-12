<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ page session="true"%>

<h3>My Profile</h3>
<hr />
<table style="width: 70%;" class="formatHTML5" align="center">
	<tr>
		<td style="width: 50%;">
			<form method="post" action="/myProfile/update">
				<table style="width: 100%;"  align="left" class="formatHTML5">
					<tr style="background-color: grey;">
						<th align="left"><h4>Personal Info</h4></th>
						<td align="right"><h4>
								<a href="<c:url value="/myprofile/edit"/>" style="">Edit</a>
							</h4></td>
					</tr>
					<tr>
						<td><b>First Name:</b></td>
						<td><c:out value="${myProfile.fname}" /></td>
					</tr>
					<tr>
						<td><b>Last Name:</b></td>
						<td><c:out value="${myProfile.lname}" /></td>
					</tr>
					<tr>
						<td><b>Street:</b></td>
						<td><c:out value="${myProfile.street}" /></td>
					</tr>
					<tr>
						<td><b>City:</b></td>
						<td><c:out value="${myProfile.city}" /></td>
					</tr>
					<tr>
						<td><b>State:</b></td>
						<td><c:out value="${myProfile.state}" /></td>
					</tr>
					<tr>
						<td><b>Zipcode:</b></td>
						<td><c:out value="${myProfile.zipcode}" /></td>
					</tr>
					<tr>
						<td><b>Realtor ID:</b></td>
						<td><c:out value="${myProfile.realtorId}" /></td>
					</tr>
					<tr>
						<td><b>Email ID:</b></td>
						<td><c:out value="${myProfile.emailId}" /></td>
					</tr>
					<tr>
						<td><b>Phone Number:</b></td>
						<td><c:out value="${myProfile.phoneNumber}" /></td>
					</tr>
				</table>
				</form>
		</td>
		</tr>
		</table>
		<br />
		<br />
		<table style="width: 70%;" class="formatHTML5" align="center">
		<tr>
		<td style="width: 50%; valign:top" >
		<form method="get" action="myprofile/setUpGmailAccount">
			<table  class="formatHTML5" style="width:100%;align:center;valign:top">
				<tr style="background-color: grey;">
					<td align="left"><h4>
						Gmail Account Settings
						</h4>						
					</td>
					<td align="right" valign="middle">
					<input type="submit" value="Set/Update">
					</td>
				</tr>
				<tr>
					<td>
						User name:
					</td>
					<td>
						<input type="hidden" name="gmailId" value="${myProfile.gmailId}">
						<c:out value="${myProfile.gmailId}" />
					</td>
				</tr>
				<tr>
					<td>
						Password:
					</td>
					<td>
						<input type="hidden" name="password" value="${myProfile.password}">
						<c:out value="${myProfile.password}" />
					</td>
				</tr>
				
			</table>
			</form>
		</td>
	</tr>
</table>




<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ page session="true" %>

<h3>Gmail Settings</h3>
<hr />
<h4>Why Gmail Account? </h4>
<br/>
<p>
	Setup Gmail account to email customers.
<br /> You can Select properties that match customer requirements and <i><b> email them from the tool.</b></i>
<br /> PLease note your data will not be shared. We respect Customer privacy.
</p>
<i>No Gmail account? <a href="https://accounts.google.com/SignUp?service=mail&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ltmpl=default&hl=en" target="_blank">Create an account here!</a></i>
<br />
<br />
<form method="post" action="updateGmailAccount">
<table style="width:50%;align:left"  class="formatHTML5">
	<tr align="left" style="background-color:grey;">
		<td ><h4>Account Details</h4></td><td></td>
	</tr>
	<tr>
		<td><b>Email Id:</b></td>
		<td><input name="gmailId" type="text" size="30"  value="<c:out value="${gmailAccount.emailId}"/>" /></td>
	</tr>
	<tr>
		<td><b>Password:</b></td>
		<td><input name="gmailPassword" type="text" size="30" value="<c:out value="${gmailAccount.password}"/>" /></td>
	</tr>
	<tr>
		<td></td>
		<td><input  type="submit" size="30" value="Set / Update" /></td>
	</tr>
	
</table>
</form>


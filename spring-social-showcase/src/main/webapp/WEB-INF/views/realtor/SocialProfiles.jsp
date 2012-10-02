<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ page session="true" %>

<h3>Social Profiles</h3>
<hr />
<div>


	
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
	




</div>

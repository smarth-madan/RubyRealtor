<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ page session="true" %>

<h3>Facebook Page Registration</h3>
<hr />
<div>


	
		<table border="0">
			<tr><td>
				<form action="/registerFaceBook"> 
					<table >
					<tr><td><b>Facebook Page Id:</b></td><td><input type="text" name="facebookId" /></td></tr>
					<tr><td><td><input type="Submit" value="Register your FB Page" /></td></tr>
					</table>
				</form>
			</td></tr>
			</table>
			<hr />
</div>

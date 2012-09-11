<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ page session="true" %>

<h3>Your MLS Feeds</h3>
	
<table border="1">
	<tr>
		<td><b>Name</b></td>
		<td><b>Address</b></td>
		<td><b>Rating</b></td>
		<td><b>Image</b></td>
	</tr>
<c:forEach items="${propertyList}" var="property">
	<tr>
		<td><c:out value="${property.name}"/></td>
		<td><c:out value="${property.address}"/></td>
		<td><c:out value="${property.rating}"/></td>
		<td><img src = "${property.image}" ></td>
	</tr>
</c:forEach>
</table>


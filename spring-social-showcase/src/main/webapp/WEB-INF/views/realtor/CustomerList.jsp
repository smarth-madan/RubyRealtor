<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ page session="true" %>

<h3>Your MLS Feeds</h3>
	
<table border="1">
	<tr>
		<td><b>Customer ID</b></td>
		<td><b>Name</b></td>
		<td><b>Email-Id</b></td>
		<td><b>Address</b></td>
	</tr>
<c:forEach items="${customerList}" var="customer">
	<tr>
		<td><c:out value="${customer.customerId}"/></td>
		<td><c:out value="${customer.name}"/></td>
		<td><c:out value="${customer.emailId}"/></td>
		<td><c:out value="${customer.address}"/></td>
	</tr>
</c:forEach>
</table>


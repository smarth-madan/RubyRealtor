<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ page session="true" %>

<h3>Your MLS Feeds</h3>
	
<table  class ="formatHTML5">
<c:forEach items="${propertyList}" var="property">
	<tr border="1">
	<td scope="col">
		<table border="0">
		<tr><td scope="col"><b>MLS_ID</b></td><td><c:out value="${property.MLS_ID}"/></td></tr>
		<tr><td scope="col"><b>Street</b></td><td><c:out value="${property.street}"/></td></tr>
		<tr><td scope="col"><b>City</b></td><td><c:out value="${property.city}"/></td></tr>
		<tr><td scope="col"><b>State</b></td><td><c:out value="${property.state}"/></td></tr>
		<tr><td scope="col"><b>Zipcode</b></td><td><c:out value="${property.zipcode}"/></td></tr>
		<tr><td scope="col"><b>Bed/Bath</b></td><td><c:out value="${property.bed_bath}"/></td></tr>
		</table>
	</td>
	<td valign="top" scope="col">
		<img src = "${property.image}" >
	</td>
	<td>
		<table border="0">
		<tr><td scope="col"><b>Size</b></td><td><c:out value="${property.size}"/></td></tr>
		<tr><td scope="col"><b>price</b></td><td><c:out value="${property.price}"/></td></tr>
		<tr><td scope="col"><b>type</b></td><td><c:out value="${property.type}"/></td></tr>
		<tr><td scope="col"><b>parking</b></td><td><c:out value="${property.parking}"/></td></tr>
		<tr><td scope="col"><b>garage</b></td><td><c:out value="${property.garage}"/></td></tr>
		</table>
	</td>
	</tr>
	
</c:forEach>
</table>


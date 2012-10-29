<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ page session="true"%>

<h3>Your MLS Feeds</h3>

<table class="formatHTML5">

	<c:forEach items="${propertyList}" var="property">
	<form method="post" action="postProperty">
		<tr>		
			<td width="30%">
				<table>
					<tr>
						<td style="font-size: 11"><b>MLS_ID</b></td>
						<td style="font-size: 11"><c:out value="${property.MLS_ID}" /></td>
					</tr>
					<tr>
						<td style="font-size: 11"><b>Size</b></td>
						<td style="font-size: 11"><c:out value="${property.size}" /></td>
					</tr>
					<tr>
						<td style="font-size: 11"><b>Address</b></td>
						<td style="font-size: 11">
							<c:out value="${property.street}" />, <c:out value="${property.city}" />, <c:out value="${property.state}" />
						</td>
					</tr>
					<tr>
						<td style="font-size: 11"><b>Price</b></td>
						<td style="font-size: 11"><c:out value="${property.price}" /></td>
					</tr>
					<tr>
						<td style="font-size: 11"><b>Type</b></td>
						<td style="font-size: 11"><c:out value="${property.type}" /></td>
					</tr>
					<tr>
						<td style="font-size: 11"><b>Parking</b></td>
						<td style="font-size: 11"><c:out value="${property.parking}" /></td>
					</tr>
					<tr>
						<td style="font-size: 11"><b>Bed/Bath</b></td>
						<td style="font-size: 11"><c:out value="${property.bed_bath}" /></td>
					</tr>
					<tr>
						<td style="font-size: 11"><b>Garage</b></td>
						<td style="font-size: 11"><c:out value="${property.garage}" /></td>
					</tr>
				</table>
			</td>

			<td valign="top" scope="col" style="float: left"><img height="125" width="150" src="${property.image}"></td>
			<td valign="top" scope="col" style="float: left"><input type="hidden" name="mls_id" value="${property.MLS_ID}">
			<input type="hidden" name="imageName" value="${property.imageName}"><input type="submit" value="Post MLS listing to FB">
			
			</td>
		</tr>
		</form>
	</c:forEach>
	
</table>


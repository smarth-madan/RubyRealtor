<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ page session="true"%>

<h3>Your MLS Feeds</h3>

<table>

	<c:forEach items="${propertyList}" var="property">
	<form method="post" action="postPropertyToFaceBook">
		<tr>		
			<td width="50%">
				<table>
					<tr>
						<td><b>MLS_ID</b></td>
						<td><input type="text" name="MLS_ID" disabled value="${property.MLS_ID}"></td>
					</tr>
					<tr>
						<td><b>Size</b></td>
						<td><input type="text" NAME="size" value="${property.size}"></td>
					</tr>
					<tr>
						<td><b>Address</b></td>
						<td>
							<TEXTAREA NAME="address" COLS=30 ROWS=2><c:out value="${property.street}, ${property.city}, ${property.state}- ${property.zipcode} }" /></TEXTAREA>
							<input type="hidden" name="street" value="${property.street}">
							<input type="hidden" name="city" value="${property.city}">
							<input type="hidden" name="state" value="${property.state}">
							<input type="hidden" name="image" value="${property.image}">
						</td>
					</tr>
					<tr>
						<td><b>Price</b></td>
						<td><input type="text" name="price" value="${property.price}"></td>
					</tr>
					<tr>
						<td><b>Type</b></td>
						<td><input type="text" name="type" value="${property.type}"></td>
					</tr>
					<tr>
						<td><b>Parking</b></td>
						<td><input type="text" name="parking" value="${property.parking}"></td>
					</tr>
					<tr>
						<td><b>Bed/Bath</b></td>
						<td><input type="text" name="bed_bath" value="${property.bed_bath}"></td>
					</tr>
					<tr>
						<td><b>Garage</b></td>
						<td><input type="text" name="garage" value="${property.garage}"></td>
					</tr>
					<tr>
						<td><b>Description</b></td>
						<td><TEXTAREA NAME="description" COLS=40 ROWS=6></TEXTAREA></td>
					</tr>
					<tr>
						<td></td>
						<td><INPUT TYPE="submit" value="Post to Facebook"></td>
					</tr>
				</table>
			</td>

			<td valign="top" scope="col" style="float:right"><img height="125" width="150" src="${property.image}"><br><br> <font size="2"><b>Image src</b> = "<c:out value="${property.image}" />"</font></td>
			
			
			</td>
		</tr>
		</form>
	</c:forEach>
	
</table>


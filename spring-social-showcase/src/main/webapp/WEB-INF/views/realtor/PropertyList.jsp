<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ page session="true"%>

<h3><i>Your MLS Feeds</i></h3>

<table class="formatHTML5" border="0">

	<c:forEach items="${propertyList}" var="property">
		<tr>
			<form method="post" action="postProperty">
				<td width="35%">
					<table width="95%">
						<tr style="background-color:grey">
							<td style="font-size: 13"><b>MLS_ID</b></td>
							<td style="font-size: 13"><c:out value="${property.MLS_ID}" /></td>
						</tr>
						<tr>
							<td style="font-size: 13"><b>Size</b></td>
							<td style="font-size: 13"><c:out value="${property.size}" /></td>
						</tr>
						<tr>
							<td style="font-size: 13"><b>Address</b></td>
							<td style="font-size: 13"><c:out value="${property.street}" />,
								<c:out value="${property.city}" />, <c:out
									value="${property.state}" /></td>
						</tr>
						<tr>
							<td style="font-size: 13"><b>Price</b></td>
							<td style="font-size: 13"><c:out value="${property.price}" /></td>
						</tr>
						<tr>
							<td style="font-size: 13"><b>Type</b></td>
							<td style="font-size: 13"><c:out value="${property.type}" /></td>
						</tr>
						<tr>
							<td style="font-size: 13"><b>Parking</b></td>
							<td style="font-size: 13"><c:out value="${property.parking}" /></td>
						</tr>
						<tr>
							<td style="font-size: 13"><b>Bed/Bath</b></td>
							<td style="font-size: 13"><c:out
									value="${property.bed_bath}" /></td>
						</tr>
						<tr>
							<td style="font-size: 13"><b>Garage</b></td>
							<td style="font-size: 13"><c:out value="${property.garage}" /></td>
						</tr>
					</table>
				</td>
				<td scope="col" width="18%">
					<table width="100%">
						<tr>
							<td><img height="125" width="180" src="${property.image}" alt="No Image Available"></td>
						</tr>
						<tr>
							<td valign="top"> <input type="hidden" name="mls_id" value="${property.MLS_ID}">
							<img height="20" width="20" src="resources/social/facebook/f_logo.jpg"><font size="3"> <i>Post to facebook</i></font></td>
						</tr>
						<tr>
							<td align="center">	 
								<input type="submit" value="Click to Post"></input>
							</td>
						</tr>
					</table>
				</td>
				<td style="valign: top;"><b><i>Existing tags:</i></b> <c:out
								value="${property.tags}" />
					</td>
			</form>
			<form action="addTagsToProperty">
				<td valign="top" scope="col" style="float: left">
				<input type="hidden" name="mls_id" value="${property.MLS_ID}"> 
				<input type="submit" value="Tag this property"></td>
			</form>
		</tr>

	</c:forEach>

</table>


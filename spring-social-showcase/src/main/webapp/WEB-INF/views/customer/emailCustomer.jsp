<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ page session="true"%>

<h3>Send an email</h3>
<hr />

<font size="3" color=""><i>** For multiple Recipients add
		them as CC as comma separated addresses</i></font>
<br />
<br />
<form method="post" action="/sendEmail">
	<table style="width: 100%;" align="center" class="formatHTML5" border="0">
		<tr style="background-color: grey">
			<th align="left">Email details:</th>
			<th></th>
		</tr>
		<tr>
			<td style="width: 20%;"><b>To:</b></td>
			<td style="width: 80%;"><input type="text" style="width:95%" name="to"
				value="<c:out value="${customerEmailId}" />"></td>
		</tr>
		<tr>
			<td><b>CC:</b></td>
			<td><input type="text" style="width:95%" name="cc"></td>
		</tr>
		<tr>
			<td><b>Subject:</b></td>
			<td><input type="text" style="width:95%" name="subject" value="<c:out value="${subject}" />"></td>
		</tr>
		<tr>
			<td><b>Add a Message:</b></td>
			<td><textarea name="message" style="width:95%" cols="100" rows="3"></textarea></td>
		</tr>
		<tr>
			<td><b>Contents:</b></td>
			<td>
				
						<table class="" border="0">	
								<c:forEach items="${propertyList}" var="property">
								<tr>
									<table>
										<tr style='background-color: #0099CC;'>
											<td style="font-size: 11"><b>MLS_ID</b></td>
											<td style="font-size: 11"><c:out value="${property.MLS_ID}" /></td>
										</tr>
										<tr style='background-color: #D0D0D0 ;'>
											<td style="font-size: 11"><b>Size</b></td>
											<td style="font-size: 11"><c:out value="${property.size}" /></td>
										</tr>
										<tr style='background-color:#E0E0E0;'>
											<td style="font-size: 11"><b>Address</b></td>
											<td style="font-size: 11">
												<c:out value="${property.street}" />, <c:out
																		value="${property.city}" />, <c:out
																		value="${property.state}" />
											</td>
										</tr>
										<tr style='background-color: #D0D0D0 ;'>
											<td style="font-size: 11"><b>Price</b></td>
											<td style="font-size: 11"><c:out value="${property.price}" /></td>
										</tr>
										<tr style='background-color:#E0E0E0;'>
											<td style="font-size: 11"><b>Type</b></td>
											<td style="font-size: 11"><c:out value="${property.type}" /></td>
										</tr>
										<tr style='background-color: #D0D0D0 ;'>
											<td style="font-size: 11"><b>Parking</b></td>
											<td style="font-size: 11"><c:out value="${property.parking}" /></td>
										</tr>
										<tr style='background-color:#E0E0E0;'>
											<td style="font-size: 11"><b>Bed/Bath</b></td>
											<td style="font-size: 11"><c:out value="${property.bed_bath}" /></td>
										</tr>
										<tr style='background-color: #D0D0D0 ;'>
											<td style="font-size: 11"><b>Garage</b></td>
											<td style="font-size: 11"><c:out value="${property.garage}" /></td>
										</tr>
									</table>	
								</tr>
								</c:forEach>
					</table>
		</td>
		</tr>
		<tr>
			<td></td>
			<td align="left"><input type="submit" value="Send Email"></td>
		</tr>
	</table>
</form>


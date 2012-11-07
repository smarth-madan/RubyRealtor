<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ page session="true"%>

<h3>Add Tags to this Property</h3>

<font size="2" color="red"><b><i><c:out value="${result}" /></i></b></font>

<table class="formatHTML5" border="0">

	<c:forEach items="${propertyList}" var="property">
		<tr>
			<td width="40%">
				<table width="100%">
					<tr style="background-color: grey">
						<td><b>MLS_ID</b></td>
						<td><c:out value="${property.MLS_ID}" /></td>
					</tr>
					<tr>
						<td><b>Size</b></td>
						<td><c:out value="${property.size}" /></td>
					</tr>

					<tr>
						<td><b>Address</b></td>
						<td><c:out
								value="${property.street}, ${property.city}, ${property.state}- ${property.zipcode}" />

						</td>
					</tr>
					<tr>
						<td><b>Price</b></td>
						<td><c:out value="${property.price}" /></td>
					</tr>
					<tr>
						<td><b>Type</b></td>
						<td><c:out value="${property.type}" /></td>
					</tr>
					<tr>
						<td><b>Parking</b></td>
						<td><c:out value="${property.parking}" /></td>
					</tr>
					<tr>
						<td><b>Bed/Bath</b></td>
						<td><c:out value="${property.bed_bath}" /></td>
					</tr>
					<tr>
						<td><b>Garage</b></td>
						<td><c:out value="${property.garage}" /></td>
					</tr>
					<tr>
						<td><b>Pic</b></td>
						<td scope="col"><img align="left" height="125" width="160"
							src="${property.image}"></td>
					</tr>
				</table>
			</td>
			<td width="30%">
				<table>
					<form method="post" action="editTags">
					<tr style="background-color: grey">
						<td><b><i>Existing Tags:</i></b></td>
					</tr>
					<tr>
						<td><c:out value="${property.tags}" /></td>
					</tr>
					<tr style="background-color: grey">
						<td><b><i>Edit Existing Tags:</i></b></td>
					</tr>
					<tr>
						<td><textarea cols="40" rows="12" name="editTags">
								<c:out value="${property.tags}" />
							</textarea>
					</tr>
					<tr>
						<td><input type="hidden" name="mls_id" value="${property.MLS_ID}"><input type="submit" value="Edit Tags"></td>
					</tr>
					</form>
				</table>
			</td>

			<td>
				<form method="post" action="addTag">
					<table width="100%">

						<tr style="background-color: grey">
							<td><b><i>Add More Tags:</i></b></td>
							<td style="font-size: 11; font-color: white; vailgn: bottom"><i>**
									select one or more options</i></td>
						</tr>
						<tr>
							<td>Tag 1:</td>
							<td><select id="tag1" name="tag1" data-inline="true">
									<option value="">-Select-</option>
									<option value="Basement">Basement</option>
									<option value="Safe">Safe</option>
									<option value="Downtown">Downtown</option>
									<option value="Beach">Beach</option>
									<option value="Skyline">Skyline</option>
									<option value="Mountains">Mountains</option>
									<option value="Spacious">Spacious</option>
									<option value="Beautiful">Beautiful</option>
									<option value="Backyard">Backyard</option>
									<option value="Garage">Garage</option>
									<option value="River"{selected} >River</option>
							</select></td>
						</tr>
						<tr>
							<td>Tag 2:</td>
							<td><select id="tag2" name="tag2" data-inline="true">
									<option value="">-Select-</option>
									<option value="Urban">Urban</option>
									<option value="Cottage">Cottage</option>
									<option value="Upscale">Upscale</option>
									<option value="Handicap">Handicap</option>
									<option value="Kids">Kids</option>
									<option value="Student">Student</option>
									<option value="University">University</option>
									<option value="Freeway">Freeway</option>
									<option value="Bus">Bus</option>
									<option value="Train">Train</option>
									<option value="Lightrail"{selected} >Lightrail</option>
							</select></td>
						</tr>
						<tr>
							<td>Tag 3:</td>
							<td><select id="tag3" name="tag3" data-inline="true">
									<option value="">-Select-</option>
									<option value="breathtaking">breathtaking</option>
									<option value="Brick">Brick</option>
									<option value="Average">Average</option>
									<option value="Colossal">Colossal</option>
									<option value="Huge">Huge</option>
									<option value="Haunted">Haunted</option>
									<option value="Cute">Cute</option>
									<option value="OLd">OLd</option>
									<option value="Colorful">Furnished</option>
									<option value="Furnished">Widowed</option>
									<option value="Semi-Furnished"{selected} >Semi-Furnished</option>
							</select></td>
						</tr>
						<tr>
							<td>Tag 4:</td>
							<td><select id="tag4" name="tag4" data-inline="true">
									<option value="">-Select-</option>
									<option value="Quiet">Quiet</option>
									<option value="Cozy">Cozy</option>
									<option value="Luxury">Luxury</option>
									<option value="BrownStone">BrownStone</option>
									<option value="Carpeted">Carpeted</option>
									<option value="Darkened">Darkened</option>
									<option value="High-Rise">High-Rise</option>
									<option value="low-rise">low-rise</option>
									<option value="redbrick">redbrick</option>
									<option value="Secure">Secure</option>
									<option value="Split-level"{selected} >Split-level</option>
							</select></td>
						</tr>
						<tr>
							<td>Tag 5:</td>
							<td><select id="tag5" name="tag5" data-inline="true">
									<option value="">-Select-</option>
									<option value="Sprawl">Sprawl</option>
									<option value="Unoccupied">Unoccupied</option>
									<option value="warm">warm</option>
									<option value="Sunlight">Sunlight</option>
									<option value="air">air</option>
									<option value="Classy">Classy</option>
									<option value="Vintage">Vintage</option>
									<option value="Special">Special</option>
							</select></td>
						</tr>
						<tr>
							<td>Your own Tag:</td>
							<td><input type="text" name="ownTag"></td>
						</tr>

					</table>

					<br />
					<center>
						<input type="hidden" name="mls_id" value="${property.MLS_ID}"><input
							type="submit" value="Add Tags">
					</center>
				</form>
			</td>

		</tr>

	</c:forEach>

</table>


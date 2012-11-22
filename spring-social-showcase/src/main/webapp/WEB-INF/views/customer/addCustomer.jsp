<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<h1  style="text-align:center;">Add New Customer</h1>



<form action="registerFromFB" method="post"> 
	<div class="row">
		<div class="row">
			<div class="span5">
				<div class="row">
					<div class="span2"><b><font size="2">*Name: </font></b></div>
					<div class="span3"><input type="text" name="name" /></div>
				</div>
				<div class="row">
					<div class="span2"><b><font size="2">*Email-Id: </font></b></div>
					<div class="span3"><input type="text" name="email_ID" /></div>
				</div>
				<div class="row">
					<div class="span2"><b><font size="2">*Phone Number: </font></b></div>
					<div class="span3"><input type="text" name="phone_number" /></div>
				</div>
				<div class="row">
					<div class="span2"><b><font size="2">Street: </font></b></div>
					<div class="span3"><input type="text" name="street" /></div>
				</div>
				<div class="row">
					<div class="span2"><b><font size="2">City: </font></b></div>
					<div class="span3"><input type="text" name="city" /></div>
				</div>
				<div class="row">
					<div class="span2"><b><font size="2">State: </font></b></div>
					<div class="span3"><input type="text" name="state" /></div>
				</div>
				<div class="row">
					<div class="span2"><b><font size="2">Zipcode: </font></b></div>
					<div class="span3"><input type="text" name="zipcode" /></div>
				</div>
				<div class="row">
					<div class="span2"><b><font size="2">Marital Status: </font></b></div>
					<div class="span3"><select id="maritalStatus" name="martial_status"
						data-inline="true">
							<option value="SINGLE">Single</option>
							<option value="ANNULLED">Annulled</option>
							<option value="DIVORCED">Divorced</option>
							<option value="MARRIED">Married</option>
							<option value="SEPARATED">Separated</option>
							<option value="WIDOWED">Widowed</option>
							<option value="UNKNOWN"{selected} >Unknown</option>
					</select></div>
				</div>
				<div class="row">
					<div class="span2"><b><font size="2">Salary Range:</font></b></div>
					<div class="span3">
						<p><input type="radio" name=salary_range value="1"> below $50,000</p> 
						<p><input type="radio" name=salary_range value="2"> $50,000 - $100,000</p> 
						<p><input type="radio" name=salary_range value="3"> $100,000 - $200,000</p>
						<p><input type="radio" name=salary_range value="4"> $200,000 - $500,000</p>
						<p><input type="radio" name=salary_range value="5"> above $500,000</p> 
					</div>
				</div>
				<div class="row">
					<div class="span2"><b><font size="2">Appointment </font></b></div>
					<div class="span3"><select id="appointment" name="appointment"
						data-inline="true">
							<option value="yes">Yes</option>
							<option value="no" selected>No</option>
							
					</select></div>
				</div>
				<div class="row">
					<div class="span2"><b><font size="2">Tentative Date/Time: </font></b></div>
					<div class="span3">
		  				<input type="Text" name="time" id="demo1" maxlength="25" size="25"><a href="javascript:NewCal('demo1','ddmmmyyyy',true,24)"><img src="<c:url value="/resources/images/cal.gif"/>" width="16" height="16" border="0" alt="Pick a date"></a>
		  				<span class="descriptions">pick a date..</span>
		  			</div>
				</div>
			</div>
			<div class="span2"></div>
			<div class="span5">

					<div class="row"><b><font size="2">Help us know you more</font></b></div>
					<div class="row"><b><i><font size="2">Type of House:</font></b></i></div>

					<div class="row"><font size="2"> <input type="checkbox" name="type_house" value="yes"  /> House </font></div>
					<div class="row"><font size="2"> <input type="checkbox" name="type_apartment" value="yes"  />  Apartment </font></div>
					<div class="row"><font size="2"> <input type="checkbox" name="type_studio" value="yes"  />  Studio </font></div>
					<div class="row"><b><font size="2"><i>No of Persons:</i></font></b> 
					
					<select id="numberOfPersons" name="numberOfPersons" class="help-inline"
						data-inline="true">
							<option value="-1" {selected} >any</option>
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
							<option value="6">6</option>
							<option value="7">7</option>
							<option value="8">8</option>
							<option value="9">9</option>
							<option value="9">10</option>
					</select></br>
					</div>
					
					
						<div class="row"><b><font size="2"><i>No of Bedrooms:</i></font></b></div>
						<div class="row"><font size="2"><input type="checkbox" name="bedRoomNumber1" value="yes"  />  1  <input type="checkbox" name="bedRoomNumber2" value="yes"  />  2 <input type="checkbox" name="bedRoomNumber3" value="yes"  />  3 </font></div>
						<div class="row"><b><font size="2"><i>No of Baths:</i></font></b></div>
						<div class="row"><font size="2"><input type="checkbox" name="bathNumber1" value="yes"  />  1  <input type="checkbox" name="bathNumber2" value="yes"  />  2 <input type="checkbox" name="bathNumber3" value="yes"  />  3 </font></div>
						<div class="row"><font size="2"><b><i>In/Around City </i></b><input type="text" name="house_city"  /></font></div>
						<div class="row"><font size="2"><b><i>State </i></b><input type="text" name="house_state"  /></font></div>
						<div class="row"><font size="2"><b><i>Location </i></b></font></div>
						<div class="row"><font size="2"><input type="checkbox" name="location_downtown" value="yes"  /> Downtown </font></div>
						<div class="row"><font size="2"> <input type="checkbox" name="location_suburb" value="yes"  /> suburbs </font></div>
						<div class="row"><font size="2"><b><i>Range :</i></b></font></div>
						<div class="row"><input type="radio" name=range value="1"  /> <font size="2"> Under $100,000 </font></div>
						<div class="row"><font size="2"> <input type="radio" name=range value="2"  /> $100,000 - $400,000 </font></div>
						<div class="row"><font size="2"> <input type="radio" name=range value="3" />  $400,000 and above</font></div>
						<div class="row"><font size="2"> <input type="radio" name=range value="4"   />  Any </font></div>
	
			</div>
		</div>
			<div class="row">
					<div class="span3"><b><font size="2">Home Description: </font></b></div>
					<div class="span5">
		  				<textarea  name="homeDescription" cols="60" rows="4"></textarea>
		  			</div>
		</div>
		<div class="row">
			<div class="span4"></div>
			<div class="span5 offset5">
				<button class = "btn" type="submit">Register</button>
			</div>
		</div>
	</div>

</form> 

<div class="modal hide fade" id="result-modal" style="display: block;">
 <div class="modal-header">
<a class="close" data-dismiss="modal">&times;</a>
<h3>Result</h3>
</div>
<div class="modal-body">
	<p><c:out value="${result}" /></p>
</div>

<div class="modal-footer">
    <a href="<c:url value="/customer/add"/>" class="btn">Add another customer</a>
    <a href="<c:url value="/customer"/>" class="btn">View all Customer</a>
</div>
</div>

<script language="Javascript">
var result= "<c:out value="${result}" />";
if(result.length>0){
	$('#result-modal').modal('show');
}

</script>

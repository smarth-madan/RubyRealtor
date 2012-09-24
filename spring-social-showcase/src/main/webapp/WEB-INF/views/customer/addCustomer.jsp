<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Customer</title>
</head>

<body>

<h1>Add Customer</h1>
<form method="POST" action = "<c:url value="/customer/add" />" >
First Name*<input type="text" name ="fName"/>
Last Name*<input type="text" name ="lName"/>
Email ID<input type="text" name ="email_ID"/>
Phone Number<input type="text" name ="phone_number"/>
Street<input type="text" name ="street"/>
City<input type="text" name ="city"/>
State<input type="text" name ="state"/>
Zipcode<input type="text" name ="zipcode"/>
Marital Status
<select id="maritalStatus" name="martial_status" data-inline="true">
	<option value="SINGLE" >Single</option>
	<option value="ANNULLED" >Annulled</option>
	<option value="DIVORCED" >Divorced</option>
	<option value="MARRIED" >Married</option>
	<option value="SEPARATED" >Separated</option>
	<option value="WIDOWED" >Widowed</option>
	<option value="UNKNOWN"{selected} >Unknown</option>
</select>	
Salary Range <input type="text" name="salary_min_val"/>-<input type="text"  name="salary_max_val"/>

<input type="submit" value="Submit"/>
</form>

</body>
</html>

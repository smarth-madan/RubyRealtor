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
<form method="POST" action = "<c:url value="/customer/editSubmit" />" >
<input type="hidden" name ="c_id" value=<c:out value="${customer.c_id}"/> />
<input type="hidden" name ="CR_ID" value=<c:out value="${customer.CR_ID}"/> />
<%-- <input type="hidden" name ="R_ID" value=<c:out value="${customer.R_ID}"/> /> --%>
First Name*<input type="text" name ="fName" value=<c:out value="${customer.fName}"/> />
Last Name*<input type="text" name ="lName" value=<c:out value="${customer.lName}"/> />
Email ID<input type="text" name ="email_ID" value=<c:out value="${customer.email_ID}"/>/>
Phone Number<input type="text" name ="phone_number" value=<c:out value="${customer.phone_number}"/> />
Street<input type="text" name ="street" value=<c:out value="${customer.street}"/> />
City<input type="text" name ="city" value=<c:out value="${customer.city}"/> />
State<input type="text" name ="state" value=<c:out value="${customer.city}"/> />
Zipcode<input type="text" name ="zipcode" value=<c:out value="${customer.zipcode}"/> />
Marital Status
<select id="maritalStatus" name="martial_status" data-inline="true">
	<option value="SINGLE" >Single</option>
	<option value="ANNULLED" >Annulled</option>
	<option value="DIVORCED" >Divorced</option>
	<option value="MARRIED" >Married</option>
	<option value="SEPARATED" >Separated</option>
	<option value="WIDOWED" >Widowed</option>
	<option value="UNKNOWN" selected ="SELECTED" >Unknown</option>
</select>	
Salary Range <input type="text" name="salary_min_val" value=<c:out value="${customer.salary_min_val}"/> />-<input type="text"  name="salary_max_val" value=<c:out value="${customer.salary_max_val}"/> />

<input type="submit" value="Submit"/>
</form>

</body>
</html>

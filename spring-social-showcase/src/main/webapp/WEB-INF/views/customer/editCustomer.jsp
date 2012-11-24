<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Customer</title>
</head>

<body>

<h1>Edit Customer</h1>
<div class="container">
<form method="POST" action = "<c:url value="/customer/editSubmit" />" >
<input type="hidden" name ="c_id" value=<c:out value="${customer.c_id}"/> /></div>
<div><input type="hidden" name ="CR_ID" value=<c:out value="${customer.CR_ID}"/> /></div>
<%-- <input type="hidden" name ="R_ID" value=<c:out value="${customer.R_ID}"/> /> --%>

<div class="row">
	<div class="span2">Name</div><div class="span3"><input type="text" name ="name" value="<c:out value="${customer.name}"/>" /></div>
</div>
<div class="row">
	<div class="span2">Email ID</div><div class="span3"><input type="text" name ="email_ID" value=<c:out value="${customer.email_ID}"/>></div>
</div>
<div class="row">
	<div class="span2">Phone Number</div><div class="span3"><input type="text" name ="phone_number" value=<c:out value="${customer.phone_number}"/> /></div>
</div>
<div class="row">
	<div class="span2">Street</div><div class="span3"><input type="text" name ="street" value="<c:out value="${customer.street}"/>" /></div>
</div>
<div class="row">
	<div class="span2">City</div><div class="span3"><input type="text" name ="city" value="<c:out value="${customer.city}"/>" /></div>
</div>
<div class="row">
	<div class="span2">State</div><div class="span3"><input type="text" name ="state" value="<c:out value="${customer.state}"/>" /></div>
</div>
<div class="row">
	<div class="span2">Zipcode</div><div class="span3"><input type="text" name ="zipcode" value=<c:out value="${customer.zipcode}"/> /></div>
</div>
<div class="row">
	<div class="span2">Marital Status</div>
	<div class="span3">
		<select id="maritalStatus" name="martial_status" data-inline="true">
		<option value="SINGLE" >Single</option>
		<option value="ANNULLED" >Annulled</option>
		<option value="DIVORCED" >Divorced</option>
		<option value="MARRIED" >Married</option>
		<option value="SEPARATED" >Separated</option>
		<option value="WIDOWED" >Widowed</option>
		<option value="UNKNOWN" selected ="SELECTED" >Unknown</option>
	</select></div>
</div>	
<div class="row">
<div class="span5 offset2">
	<input type="submit" class="btn" value="Submit"/>
</div>
</div>
</form>
</div>

<div class="modal hide fade" id="result-modal" style="display: block;">
 <div class="modal-header">
<a class="close" data-dismiss="modal">&times;</a>
<h3>Result</h3>
</div>
<div class="modal-body">
	<p><c:out value="${result}" /></p>
</div>

<div class="modal-footer">
    <a href="<c:url value="/customer"/>" class="btn">Ok</a>
</div>
</div>

<script language="Javascript">
var result= "<c:out value="${result}" />";
if(result.length>0){
	$('#result-modal').modal('show');
}
</script>
</body>
</html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Customer Requirements</title>
</head>

<body>

<h1>Add Customer Requirements</h1>
<form method="POST" action = "<c:url value="/customer/addReq" />" >
No. of Persons<input type="text" name ="noOfPersons"/>
noOfBedrooms<input type="text" name ="noOfBedrooms"/>
city<input type="text" name ="city"/>
state<input type="text" name ="state"/>
zipcode<input type="text" name ="zipcode"/>
rangeAmount<input type="text" name ="rangeAmount"/>
type<input type="text" name ="type"/>

<input type="submit" value="Submit"/>
</form>

</body>
</html>

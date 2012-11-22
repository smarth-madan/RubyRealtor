<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Customer</title>
</head>
<body>
<h1 style="text-align:center;">List of all Customers</h1>

<!-- <table class ="formatHTML5">  -->
<table class="table table-striped table-hover table-condensed">
<caption>  </caption>
	<colgroup />
	<colgroup span="2" title="title" />
	<thead>
		<tr>
			<th scope="col">Name</th>
			<th scope="col">Street</th>
			<th scope="col">City</th>
			<th scope="col">State</th>
			<th scope="col">Zipcode</th>
			<th scope="col">Marital Status</th>
			<th scope="col">Salary Range</th>
			<th scope="col">Email Id</th>
			<th scope="col">Phone Number</th>
			<th></th>
			<th></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${customers}" var="customer">
		<tr>
			<td style="font-size:small"><c:out value="${customer.name}"/></td>
			<td style="font-size:small" ><c:out value="${customer.street}"/></td>
			<td style="font-size:small"><c:out value="${customer.city}"/></td>
			<td style="font-size:small"><c:out value="${customer.state}"/></td>	
			<td style="font-size:small"><c:out value="${customer.zipcode}"/></td>
			<td style="font-size:small"><c:out value="${customer.martial_status}"/></td>
			<td style="font-size:small"><c:out value="$ ${customer.salary_min_val} - ${customer.salary_max_val}"/></td>
			<td style="font-size:small"><c:out value="${customer.email_ID}"/></td>
			<td style="font-size:small"><c:out value="${customer.phone_number}"/></td>
			<td>
				<form method="POST" action="<c:url value="/customer/edit" />" >
				<input type="hidden" name="c_id" value="${customer.c_id}" />
				<button class = "btn" type="submit">Edit</button>	
				</form>
			</td>
			<td>
				<form method="POST" action="<c:url value="/customer/match" />" >
				<input type="hidden" name="c_id" value="${customer.c_id}" />
				<button class = "btn btn-primary" type="submit">Match</button>
				</form>
			</td>
		</tr>
		</c:forEach>
	</tbody>
</table>
<a href="http://localhost:8080/spring-social-showcase/customer/add">Add new Customer</a>
</body>
</html>
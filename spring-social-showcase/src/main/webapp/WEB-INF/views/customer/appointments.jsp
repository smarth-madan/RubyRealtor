<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>

<h1 style="text-align:center;">List of all Appointments</h1>

 <table class="table table-striped table-hover table-condensed">
<caption>  </caption>
	<colgroup />
	<colgroup span="2" title="title" />
	<thead>
		<tr>
			<th scope="col">Name</th>
			<th scope="col">Email Id</th>
			<th scope="col">Phone Number</th>
			<th></th>
			<th></th>
			<th scope="col"> Date-time </th>
			<th></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${customers}" var="customer">
		<tr>
			<td><c:out value="${customer.name}"/></td>
			<td><c:out value="${customer.email_ID}"/></td>
			<td><c:out value="${customer.phone_number}"/></td>
			<td></td>
			<td></td>
			<td><c:out value="${customer.time}"/></td>
			<td>
				<form method="POST" action="<c:url value="/customer/emailCustomer" />" >
				<input type="hidden" name="c_id" value="${customer.c_id}" />
				<button class = "btn btn-primary" type="submit">Email</button>
				</form>
			</td>
		</tr>
		</c:forEach>
	</tbody>
</table>
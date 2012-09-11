<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ page session="false" %>

<p>Welcome, <c:out value="${account.firstName}"/>! <a href="<c:url value="/signout" />">Sign Out</a></p>

<table width="70%" border ="0"><tr><td>
<table border ="0" width="100%">
	<tr><td>
		<table style="float:left">
			<tr ><td><b> News: </b></td></tr>
			<tr ><td><hr /></td></tr>
			<tr><td> Breaking news: Latest news on Real estate, Market going Down!!!</td></tr>
		</table>
	 </td>
	 <td>
	 	<table style="float:right">
			<tr><td><b> Analysis: <hr /> </b></td></tr>
			<tr><td> Graphs coming up ... !!</td></tr>
		</table>
	 </td>
	 </tr>
</table>
<br />
<table border ="0"width="100%">	 
	 <tr><td>
		<table style="float:left">
			<tr ><td><b> Customers: <hr /></b></td></tr>
			<tr><td> <a href="<c:url value="/customers" />">List Customers</a></td></tr>
		</table>
	 </td>
	 <td>
	 	<table style="float:right">
			<tr><td><b> Property Listings (MLS Data) <hr /></b></td></tr>
			<tr><td> <a href="<c:url value="/properties" />">List Properties</a></td></tr>
		</table>
	 </td>
	 </tr>
</table>

</td></tr></table>
<br />




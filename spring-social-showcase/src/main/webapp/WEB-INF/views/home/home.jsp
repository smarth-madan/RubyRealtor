<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ page session="false" %>

<p><h1>Welcome, <c:out value="${account.firstName}"/>!</h1></p>


<table width="100%">
	<tr ><td>
		<b> Your top 5 Customers : </b><hr />
		<table style="float:left" class="formatHTML5" >
			<tr style="background-color:grey"><td><b>C ID</b></td><td><b>Name</b></td><td><b>Email ID</b></td></tr>
			<c:forEach items="${top5CustomersList}" var="customer">
			<tr >
				<td ><c:out value="${customer.c_id}" /></td>
				<td ><c:out value="${customer.name}" /></td>
				<td ><c:out value="${customer.email_ID}" /></td>
			</tr>
			</c:forEach>
		</table>
		<br />
		<br />
		<b>Latest 5 MLS Listings: </b><hr />
		<table style="float:left" class="formatHTML5" >
			<tr style="background-color:grey"><td>MLS ID</td><td>Address</td><td>Price</td></tr>
			<c:forEach items="${top5MlsListingsList}" var="property">
			<tr >
				<td><c:out value="${property.MLS_ID}" /></td>
				<td><c:out value="${property.street}" /> <c:out value="${property.city}" /> <c:out value="${property.state}" /> <c:out value="${property.zipcode}" /></td>
				<td><c:out value="${property.price}" /></td>
			</tr>
			</c:forEach>
		</table>
	 </td>
	 <td align="center">
	 	<table >
			<tr><td><b> Analysis: <hr /> </b></td></tr>
			<tr><td> <div id="chartContainer">FusionCharts XT will load here!</div><center><a href="<c:url value="/analytics"/>" > Click here for More Analytics..</a></center></td></tr>
		</table>
	 </td>
	 </tr>
	 <tr><td >	 
	     <table style="float:left">
			<tr ><td><b> Customers: <hr /></b></td></tr>
			<tr><td> <a href="<c:url value="/customer" />">View Customers</a></td></tr>
			<tr><td> <a href="<c:url value="/customer/add" />">Add Customers</a></td></tr>
			<tr><td> <a href="<c:url value="/customer/edit" />">Edit Customers</a></td></tr>
			<tr><td> <a href="<c:url value="/contactUs" />">Contact Us</a></td></tr>
		</table> 
	 </td>
	 <td>
	 	<table>
			<tr><td><b> Property Listings (MLS Data) <hr /></b></td></tr>
			<tr><td> <a href="<c:url value="/properties" />">List Properties</a></td></tr>
		</table>
	 </td>
	 </tr>
</table>

 <script type="text/javascript"><!--         
      var myChart = new FusionCharts( "<c:url value="/resources/js/Column3D.swf" />", 
      "myChartId", "400", "300", "0", "1" );
      myChart.setXMLUrl("<c:url value="/resources/js/Data.xml" />");
      myChart.render("chartContainer");
 </script>



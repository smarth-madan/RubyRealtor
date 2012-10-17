<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ page session="false" %>

<h3>Your Facebook Page</h3>
	
<form method="POST" action="<c:url value="/facebook/pageEvent" />">
	<p>Post event on Facebook page<p>
	<label for="name">Name*:</label>
	<input type="text" id="name" name="name" /><br/>
	<label for="start_time">Start Time*:</label>
	<input type="text" id="start_time" name="startTime" /><br/>
	<label for="end_time">End Time:</label>
	<input type="text" id="end_time" name="endTime" /><br/>
	<label for="description">Description:</label>
	<input type="text" id="description" name="description" /><br/>
	<label for="location">Location:</label>
	<input type="text" id="location" name="location" /><br/>
	<input type="submit" value="Post" />
</form>
<p>* Required fields</p>

<div class="feed">
<ul class="feedList">
</ul>
</div>
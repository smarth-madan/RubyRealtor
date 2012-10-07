<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ page session="false" %>

<h3>Your Facebook Page</h3>
	
<form method="POST" action="<c:url value="/facebook/pageEvent" />">
	<p>Post to your Facebook wall:<p>
	<input type="text" id="name" name="name" /><br/>
	<input type="text" id="start_time" name="startTime" /><br/>
	<input type="submit" value="Post" />
</form>

<div class="feed">
<ul class="feedList">
</ul>
</div>
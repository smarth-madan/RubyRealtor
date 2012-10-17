<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ page session="false" %>

<h3>Your Facebook Page</h3>
	
<h3>Post Status on Page</h3>
<form method="POST" action="<c:url value="/facebook/page/post" />">
	<p>Post to your Facebook page wall:<p>
	<textarea id="message" name="message" rows="2" cols="60"></textarea><br/>
	<input type="submit" value="Post" />
</form>

<h3> Post Link on Page</h3>
<form method="POST" action="<c:url value="/facebook/page/postLink" />">
	<p>Link:</p>
	<input type="text" name="link" id="link"/><br/>
	<p>Message:<p>
	<textarea id="message" name="message" rows="2" cols="60"></textarea><br/>
	<input type="submit" value="Post" />
</form>


<div class="feed">
<ul class="feedList">
<c:forEach items="${feed}" var="post">
	<li class="post">
		<p><c:if test="${not empty post.picture}"><img src="<c:out value="${post.picture}"/>" align="top"/></c:if>
		<c:out value="${post.message}" /> - <c:out value="${post.name}" /></p>
	</li>
</c:forEach>
</ul>
</div>

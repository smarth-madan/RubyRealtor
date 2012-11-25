<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ page session="false" %>

<div class="row">
  <div class="span6"><h1>Your facebook page</h1></div>
  <div class="span6"><c:if test="${not empty page.picture}"> <img src="${page.picture}" height="150" width="150" style="float:right"> </c:if> </div>
</div>
	
<h3>Post Status on Page</h3>

<form method="POST" action="<c:url value="/facebook/page/postLink" />">
	<p>Link:</p>
	<input type="text" name="link" id="link"/><br/>
	<p>Message:<p>
	<textarea id="message" name="message" rows="2" cols="60" width=200px></textarea><br/>
	<input type="submit" class="btn" value="Post" />
</form>


<div class="feed">
<ul>
<c:forEach items="${feed}" var="post">
	<div class="row">
		<div class="span1"><c:if test="${not empty post.picture}"><img src="<c:out value="${post.picture}"/>" align="top"/></c:if></div>
		<div class="span5">
			<div class="row"><c:out value="${post.message}" /> <c:if test="${not empty post.name}"> - <c:out value="${post.name}" /> </c:if></div>			
				<div class="row">
					<c:if test="${not empty post.likeCount}">
		 				<c:out value="${post.likeCount}" default="0"/><img src="<c:url value="/resources/social/facebook/facebook-like-logo.jpg" />" height=10 width=20/>
					</c:if>
					<c:if test="${not empty post.commentCount}">
		 				<c:out value="${post.commentCount}" default="0"/> comments
					</c:if>
				</div>
		</div>
		</div>
		<hr>
</c:forEach>
</ul>
</div>

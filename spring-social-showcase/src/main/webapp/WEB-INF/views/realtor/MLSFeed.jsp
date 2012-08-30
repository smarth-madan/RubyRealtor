<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ page session="true" %>

<h3>Your MLS Feeds</h3>
	
<table border="0">
<c:forEach items="${MLSFeeds}" var="mlsFeed">
	<tr id="p"><td style="border-bottom-style:solid"><c:out value="${mlsFeed.id}"/></td><td style="border-bottom-style:dotted"><c:out value="${mlsFeed.url}"/></td></tr>
</c:forEach>
</table>


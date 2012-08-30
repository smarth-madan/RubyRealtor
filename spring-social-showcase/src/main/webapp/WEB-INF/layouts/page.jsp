<?xml version="1.0" encoding="UTF-8" ?>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page session="false" %>
<html>
	<head>
		<title>Social Realtor</title>
		<link rel="stylesheet" href="<c:url value="/resources/page.css" />" type="text/css" media="screen" />
		<link rel="stylesheet" href="<c:url value="/resources/form.css" />" type="text/css" media="screen" />
		<link rel="stylesheet" href="<c:url value="/resources/messages/messages.css" />" type="text/css" media="screen" />
		<style type="text/css">
			#p
			{			
			border-bottom-style:dotted;
			}
		</style>
	</head>
	<body>
		<div id="header">
			<h1><a href="<c:url value="/"/>">Social Realtor</a></h1>
		</div>
		
		<div id="leftNav">
			<tiles:insertTemplate template="menu.jsp" />
		</div>
		
		<div id="content">
			<tiles:insertAttribute name="content" />
		</div>		
	</body>
</html>

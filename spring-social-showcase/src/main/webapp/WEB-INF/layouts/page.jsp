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
	<body >
		<div id="header">
			<table width="100%">
			<tr>
			<td width="86%" ><h1><a href="<c:url value="/"/>">Social Realtor</a></h1></td>
			<td width="7%" align="right"><a href="<c:url value="/"/>"><img height="42" width="42" src="resources/images/home.jpg" /></a></td>
			<td width="7%" align="right"><a href="<c:url value="/signout" />">Sign Out</a></td>
			</tr>
			</table>
		</div>
		<hr />
		
		<div id="leftNav">
			<tiles:insertTemplate template="menu.jsp" />
		</div>
		
		<div id="content" style="background-color:#E8E8E8" >
			<tiles:insertAttribute name="content" />
		</div>	
		<div id="footer">
			
		</div>	
	</body>
</html>

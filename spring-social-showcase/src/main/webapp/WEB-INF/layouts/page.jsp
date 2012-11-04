<?xml version="1.0" encoding="UTF-8" ?>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page session="false" %>
<html>
	<head>
		<title>Social Realtor</title>
		<script type="text/javascript" src="<c:url value="/resources/dropdowntabs.js" />"></script>
		<script type="text/javascript" src="<c:url value="/resources/datetimepicker.js" />"></script>
		<script type="text/javascript" src="<c:url value="/resources/js/FusionCharts.js" />"></script>
			

		<!-- CSS for Drop Down Tabs Menu #3 -->
		<link rel="stylesheet" type="text/css" href="<c:url value="/resources/ddcolortabs.css" />"  />
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
			<table width="100%">
			<tr>
			<td width="86%" ><h1><a href="<c:url value="/"/>">Social Realtor</a></h1></td>
			<td width="7%" align="right"><a href="<c:url value="/"/>"><img height="42" width="42" src="resources/images/home.jpg" /></a></td>
			<td width="7%" align="right"><a href="<c:url value="/signout" />">Sign Out</a></td>
			</tr>
			</table>
		</div>
		<hr />
		<div style="background-color:#D0D0D0;width: 100%;height: 100%;">
		<div  id="leftnav">
			<tiles:insertTemplate template="menu.jsp" />
		</div>
		
		<div id="content">
			<tiles:insertAttribute name="content" />
		</div>	
		</div>
		<!-- <div id="footer">
			
		</div> -->
	</body>
</html>

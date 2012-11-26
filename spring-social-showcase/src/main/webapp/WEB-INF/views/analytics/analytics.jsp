<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ page session="false"%>

<p>
<h3>Analytics page:</h3>
</p>

<table border="1" width="100%">
	<tr>
		<td><div id="chartContainer1"
				style="width: 400px; float: left"></div></td>
		<td><div id="pieChartContainer"
				style="width: 400px; float: left"></div></td>
	</tr>
	<tr>
		<td><div id="chartContainer3"
				style="width: 400px; float: left"></div></td>
		<td><div id="chartContainer4"
				style="width: 400px;  float: left"></div></td>
	</tr>
</table>
<br /><br />
<table border="1" width="100%" height="400px">
	<tr>
		<td><div id="largeDataChartContainer" style="height:100%;"></div></td>		
	</tr>
</table>
 <br /><br />     
<script type="text/javascript" src="<c:url value="/resources/js/LargeData.xml.js" />"></script>           
<script type="text/javascript"><!--                   
                    
      var myChart = new FusionCharts("<c:url value="/resources/js/Area2D.swf" />", 
          "myChartId", "100%", "100%", "0", "0");       
      myChart.setXMLData( largeData );         
      myChart.render("largeDataChartContainer");                   
      // -->     
    </script>

<script type="text/javascript"><!--
      var myChart = new FusionCharts("<c:url value="/resources/js/Pie3D.swf" />", "myChartId", "400", "300", "0", "1");  								
      myChart.setXMLData("<chart caption='Weekly Sales Summary' xAxisName='Week' yAxisName='Sales' numberPrefix='$'><set label='Week 1' value='14400' /><set label='Week 2' value='19600' /><set label='Week 3' value='24000' /><set label='Week 4' value='15700' /></chart>");                               
	  myChart.render("pieChartContainer");
       // -->
      </script>

<script type="text/javascript"><!--         
      var myChart = new FusionCharts( "<c:url value="/resources/js/Column3D.swf" />", 
      "myChartId", "400", "300", "0", "1" );
	  var jsonString = "<c:out value="${graphJsonData}" />";
	  var jsonStringModified = jsonString.replace(/&#039;/g,'"');
	  myChart.setJSONData (jsonStringModified);
     /*  myChart.setXMLUrl("<c:url value="/resources/js/Data.xml" />"); */
      myChart.render("chartContainer1");
    // -->     
    </script>
<script type="text/javascript"><!--         
      var myChart = new FusionCharts( "<c:url value="/resources/js/Column3D.swf" />", 
      "myChartId", "400", "300", "0", "1" );
	  var jsonString = "<c:out value="${graphJsonData}" />";
	  var jsonStringModified = jsonString.replace(/&#039;/g,'"');
	  myChart.setJSONData (jsonStringModified);
/*  myChart.setXMLUrl("<c:url value="/resources/js/Data.xml" />"); */
      myChart.render("chartContainer2");
    // -->     
    </script>
<script type="text/javascript"><!--         
      var myChart = new FusionCharts( "<c:url value="/resources/js/Column3D.swf" />", 
      "myChartId", "400", "300", "0", "1" );
	  var jsonString = "<c:out value="${graphJsonData}" />";
	  var jsonStringModified = jsonString.replace(/&#039;/g,'"');
	  myChart.setJSONData (jsonStringModified);
/*  myChart.setXMLUrl("<c:url value="/resources/js/Data.xml" />"); */
      myChart.render("chartContainer3");
    // -->     
    </script>
<script type="text/javascript"><!--         
      var myChart = new FusionCharts( "<c:url value="/resources/js/Column3D.swf" />", 
      "myChartId", "400", "300", "0", "1" );
      var jsonString = "<c:out value="${graphJsonData}" />";
	  var jsonStringModified = jsonString.replace(/&#039;/g,'"');
	  myChart.setJSONData (jsonStringModified);
/*  myChart.setXMLUrl("<c:url value="/resources/js/Data.xml" />"); */
      myChart.render("chartContainer4");
    // -->     
    </script>


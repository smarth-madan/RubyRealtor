<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ page session="false" %>

<p>Welcome, <c:out value="${account.firstName}"/>!</p>

 <div id="chartContainer">FusionCharts XT will load here!</div>          
    <script type="text/javascript"><!--         
      var myChart = new FusionCharts( "<c:url value="/resources/js/Column3D.swf" />", 
      "myChartId", "400", "300", "0", "1" );
      myChart.setXMLUrl("<c:url value="/resources/js/Data.xml" />");
      myChart.render("chartContainer");
    
    // -->     
    </script>




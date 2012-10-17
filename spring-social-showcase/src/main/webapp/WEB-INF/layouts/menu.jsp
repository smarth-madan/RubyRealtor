<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/spring-social/social/tags" prefix="social" %>


<div id="colortab" class="ddcolortabs">
<ul>

<li><a href="<c:url value="/"/>"><span style="width:50;text-align:center"> Home </span></a></li>
<li><a href="<c:url value="/myprofile"/>"  title="My Profile" rel="dropmenu3_c"><span>My Profile</span></a></li>
<li><a href="<c:url value="/customer"/>" title="Customers" rel="dropmenu4_c"><span>Customers</span></a></li>
<li><a href="<c:url value="/properties"/>"><span>Property Listings</span></a></li>
<li><a href="<c:url value="/connect"/>"><span>Manage FB/Twitter Connections</span></a></li>
<li><a href="#"  title="Dropdown options available only when connected" rel="dropmenu1_c"><span>Facebook</span></a></li>
<li><a href="#"  title="Dropdown options available only when connected" rel="dropmenu2_c"><span>Twitter</span></a></li>
<li><a href="http://tools.dynamicdrive.com" title="Analytics"><span>Analytics</span></a></li>
<li><a href="http://tools.dynamicdrive.com" title="Matching"><span>Matching</span></a></li>
<li><a href="http://tools.dynamicdrive.com" title="News"><span>News</span></a></li>
	
<li><a style="float:right" href="<c:url value="/signout"/>" title="Matching"><span>Signout</span></a></li>	
</ul>
</div>

<div class="ddcolortabsline">&nbsp;</div>



<!--1st drop down menu -->                                                   
<div id="dropmenu1_c" class="dropmenudiv_a">
<social:connected provider="facebook">
	<a href="<c:url value="/facebook"/>">User Profile</a>
	<a href="<c:url value="/facebook/feed"/>">Feed</a></li>
	<a href="<c:url value="/facebook/friends"/>">Friends</a>
	<a href="<c:url value="/facebook/albums"/>">Albums</a>
	<a href="<c:url value="/facebook/page"/>">Page</a>
	<a href="<c:url value="/facebook/pageEvent"/>">PageEvent</a>
</social:connected>
</div>



<!--2nd drop down menu -->                                                
<div id="dropmenu2_c" class="dropmenudiv_a" style="width: 150px;">
<social:connected provider="twitter">
	<a href="<c:url value="/twitter"/>">User Profile</a>
	<a href="<c:url value="/twitter/timeline"/>">Timeline</a>
	<a href="<c:url value="/twitter/friends"/>">Friends</a>
	<a href="<c:url value="/twitter/followers"/>">Followers</a>
	<a href="<c:url value="/twitter/messages"/>">Messages</a>
	<a href="<c:url value="/twitter/trends/daily"/>">Daily Trends</a>
</social:connected>
</div>

<!--  drop down menu for Profile -->                                                   
<div id="dropmenu3_c" class="dropmenudiv_a">
	<a href="<c:url value="/myprofile"/>">Personal Info</a>
	<a href="<c:url value="/myprofile/socialProfiles"/>">Social Profiles</a></li>
	<a href="<c:url value="/myprofile/settings"/>">Settings</a>
</div>

<!--  drop down menu for Profile -->                                                   
<div id="dropmenu4_c" class="dropmenudiv_a">
	<a href="<c:url value="/customer"/>">View Customers</a>
	<a href="<c:url value="/customer/add"/>">Add Customer</a></li>
</div>

<script type="text/javascript">
//SYNTAX: tabdropdown.init("menu_id", [integer OR "auto"])
tabdropdown.init("colortab", 3)
</script>

<%-- 
<h4><a href="<c:url value="/connect"/>">Connections</a></h4>

<h4><a href="<c:url value="/twitter"/>">Twitter</a></h4>
<social:connected provider="twitter">
<ul class="menu">
	<li><a href="<c:url value="/twitter"/>">User Profile</a></li>
	<li><a href="<c:url value="/twitter/timeline"/>">Timeline</a></li>
	<li><a href="<c:url value="/twitter/friends"/>">Friends</a></li>
	<li><a href="<c:url value="/twitter/followers"/>">Followers</a></li>
	<li><a href="<c:url value="/twitter/messages"/>">Messages</a></li>
	<li><a href="<c:url value="/twitter/trends/daily"/>">Daily Trends</a></li>
</ul>
</social:connected>

<h4><a href="<c:url value="/facebook"/>">Facebook</a></h4>
<social:connected provider="facebook">
<ul class="menu">
	<li><a href="<c:url value="/facebook"/>">User Profile</a></li>
	<li><a href="<c:url value="/facebook/feed"/>">Feed</a></li>
	<li><a href="<c:url value="/facebook/friends"/>">Friends</a></li>
	<li><a href="<c:url value="/facebook/albums"/>">Albums</a></li>
</ul>
</social:connected>

<h4><a href="<c:url value="/myprofile"/>">My Profile</a></h4>

<h4><a href="<c:url value="/linkedin"/>">LinkedIn</a></h4>
<social:connected provider="linkedin">
<ul class="menu">
	<li><a href="<c:url value="/linkedin"/>">User Profile</a></li>
</ul>
</social:connected>
 --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/spring-social/social/tags" prefix="social" %>


<!-- <div id="colortab" class="ddcolortabs">-->
<!-- NAVBAR
    ================================================== -->
    <!-- Wrap the .navbar in .container to center it on the page and provide easy way to target it with .navbar-wrapper. -->
    <div class="container navbar-wrapper">
      <div class="navbar navbar-inverse">
        <div class="navbar-inner">
         <!-- Responsive Navbar Part 1: Button for triggering responsive navbar (not covered in tutorial). Include responsive CSS to utilize. -->
          <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </a>
            <a class="brand" href="#">Social Realtor</a>
          <!-- Responsive Navbar Part 2: Place all navbar contents you want collapsed withing .navbar-collapse.collapse. -->
          <div class="nav-collapse collapse">
			<ul class="nav " >

				<li><a href="<c:url value="/"/>"><span style="width:50;text-align:center"> Home </span></a></li>
				<li class="dropdown">
				<a href="<c:url value="/myprofile"/>"  title="My Profile" class="dropdown-toggle" data-toggle="dropdown"><span>My Profile</span><b class="caret"></b></a>
					<ul class="dropdown-menu">
						<li><a href="<c:url value="/myprofile"/>">Personal Info</a></li>
						<li><a href="<c:url value="/myprofile/socialProfiles"/>">Social Profiles</a></li>
						<li><a href="<c:url value="/myprofile/settings"/>">Settings</a></li>
					</ul>
				</li>
				<li class="dropdown">
				<a href="<c:url value="/customer"/>" title="Customers" class="dropdown-toggle" data-toggle="dropdown"><span>Customers</span><b class="caret"></b></a>
					<ul class="dropdown-menu">
						<li><a href="<c:url value="/customer"/>">View Customers</a></li>
						<li><a href="<c:url value="/customer/add"/>">Add Customer</a></li>
					</ul>
				</li>
				<li><a href="<c:url value="/properties"/>"><span>Property Listings</span></a></li>
				<li>
				<a href="<c:url value="/connect"/>" ><span>Manage Social Connections</span></a></li>
				<li><a href="#"  title="Dropdown options available only when connected" class="dropdown-toggle" data-toggle="dropdown"><span>Facebook</span><b class="caret"></b></a>
					<ul class="dropdown-menu">
						<social:connected provider="facebook">
						<li><a href="<c:url value="/facebook/page"/>">Page</a></li>
						<li><a href="<c:url value="/facebook/pageEvent"/>">PageEvent</a></li>
						</social:connected>
					</ul>
				</li>
				<li><a href="#"  title="Dropdown options available only when connected" class="dropdown-toggle"><span>Twitter</span><b class="caret"></b></a>
					<ul class="dropdown-menu">
						<social:connected provider="twitter">
						<li><a href="<c:url value="/twitter"/>">User Profile</a></li>
						<li><a href="<c:url value="/twitter/timeline"/>">Timeline</a></li>
						<li><a href="<c:url value="/twitter/friends"/>">Friends</a></li>
						<li><a href="<c:url value="/twitter/followers"/>">Followers</a></li>
						<li><a href="<c:url value="/twitter/messages"/>">Messages</a></li>
						<li><a href="<c:url value="/twitter/trends"/>"> Trends</a></li>
						</social:connected>
					</ul>
				</li>
				<li><a href="<c:url value="/analytics"/>" title="Analytics"><span>Analytics</span></a></li>
				<li><a href="http://tools.dynamicdrive.com" title="Matching"><span>Matching</span></a></li>
				<li><a href="http://tools.dynamicdrive.com" title="News"><span>News</span></a></li>
	
				<li><a style="float:right" href="<c:url value="/signout"/>" title="Matching"><span>Signout</span></a></li>	
			</ul>
          </div><!--/.nav-collapse -->
        </div><!-- /.navbar-inner -->
      </div><!-- /.navbar -->

    </div><!-- /.container -->

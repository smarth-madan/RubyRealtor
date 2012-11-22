<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/spring-social/social/tags" prefix="social" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ taglib uri="http://www.springframework.org/spring-social/facebook/tags" prefix="facebook" %>
<%@ page session="false" %>

<style>
  #signup-modal h1, #login-modal h3 {
    margin: 0 -40px;
    background: #eee;
    border-bottom: 1px solid #ccc;
    border-top: 1px solid #ccc;
    font-size: 16px;
    padding: 5px 40px;
    border-top-left-radius: 6px;
    border-top-right-radius: 6px;
    text-align: center;
    margin-bottom: 30px; }
    
    #signup-modal, #login-modal {
  width: 300px;
  padding: 0 40px;
  background: #fff;
  border: 5px solid rgba(0, 0, 0, 0.2);
  margin-left: -190px;
  border-radius: 10px;
  overflow: hidden;
  margin-bottom: 40px;
  box-shadow: 0 1px 0 #fff inset;
  margin-top: -306px; }
  #signup-modal h1, #login-modal h1 {
    margin: 0 -40px;
    background: #eee;
    border-bottom: 1px solid #ccc;
    border-top: 1px solid #ccc;
    font-size: 16px;
    padding: 5px 40px;
    border-top-left-radius: 6px;
    border-top-right-radius: 6px;
    text-align: center;
    margin-bottom: 30px; }
  #signup-modal h5, #login-modal h5 {
    margin-top: 5px; }
  #signup-modal form, #login-modal form {
    text-align: center; }
  #signup-modal .close, #login-modal .close {
    position: absolute;
    top: 0;
    right: 0;
    padding: 12px 18px 16px 18px;
    opacity: 0.8;
    border-left: 1px solid #bbb; }
  #signup-modal .signup-btn, #login-modal .signup-btn {
    display: block;
    border: 1px solid #136ac1;
    color: #fff;
    font-weight: bold;
    font-size: 18px;
    padding: 12px 30px 12px 0;
    border-radius: 3px;
    margin: 10px 0 25px;
    box-shadow: 0 1px 0 rgba(255, 255, 255, 0.25) inset;
    text-shadow: 0 1px 0 #1a64bf;
    cursor: pointer;
    text-align: left; }
    #signup-modal .signup-btn i, #login-modal .signup-btn i {
      height: 24px;
      width: 20px;
      background-size: 24px;
      display: inline-block;
      vertical-align: text-top;
      margin-right: 15px;
      border-right: 1px solid rgba(0, 0, 0, 0.1);
      padding-right: 30px;
      box-shadow: 1px 0 0px rgba(255, 255, 255, 0.2); }
    #signup-modal .signup-btn:hover, #login-modal .signup-btn:hover {
      box-shadow: 0 0 2px #ccc;
      text-decoration: none; }
  #signup-modal .signup-twitter, #login-modal .signup-twitter {
    background-color: #0ba8d6;
    background-image: -moz-linear-gradient(#35bfe7, #0ba8d6);
    background-image: -o-linear-gradient(#35bfe7, #0ba8d6);
    background-image: -ms-linear-gradient(#35bfe7, #0ba8d6);
    background-image: -webkit-gradient(linear, left top, left bottom, color-stop(0, #35bfe7), color-stop(1, #0ba8d6));
    background-image: -webkit-linear-gradient(#35bfe7, #0ba8d6); }
    #signup-modal .signup-twitter i, #login-modal .signup-twitter i {
      background: url('/static/img/icon-twitter.png?141b58b60994') center center no-repeat;
      background-size: 32px auto; }
  #signup-modal .signup-facebook, #login-modal .signup-facebook {
    background-color: #4264b3;
    background-image: -moz-linear-gradient(#679ace, #4264b3);
    background-image: -o-linear-gradient(#679ace, #4264b3);
    background-image: -ms-linear-gradient(#679ace, #4264b3);
    background-image: -webkit-gradient(linear, left top, left bottom, color-stop(0, #679ace), color-stop(1, #4264b3));
    background-image: -webkit-linear-gradient(#679ace, #4264b3);
    border-color: #1b345a;
    text-shadow: 0 1px 0 #2d449e; }
    #signup-modal .signup-facebook i, #login-modal .signup-facebook i {
      background: url('/static/img/icon-facebook.png?141b58b60994') center center no-repeat;
      background-size: 14px auto; }
  #signup-modal a, #login-modal a {
    font-weight: normal; }
    #signup-modal a span, #login-modal a span {
      color: #777; }
  #signup-modal fieldset, #login-modal fieldset {
    border-top: 1px solid #ddd;
    border-bottom: 1px solid #ddd;
    padding: 20px 40px 30px;
    margin: 30px -40px 20px; }
    #signup-modal fieldset input[type=submit], #login-modal fieldset input[type=submit] {
      padding: 12px 0;
      width: 300px;
      margin-top: 15px;
      font-size: 14px; }
    #signup-modal fieldset input[type=text], #signup-modal fieldset input[type=password], #signup-modal fieldset input[type=email], #login-modal fieldset input[type=text], #login-modal fieldset input[type=password], #login-modal fieldset input[type=email] {
      font-size: 14px;
      color: #000;
      padding: 10px 10px;
      width: 280px;
      box-shadow: inset 0 1px 1px #ddd;
      margin-top: 10px; }
    #signup-modal fieldset .email_suggestion, #login-modal fieldset .email_suggestion {
      text-align: left;
      margin: 2px 0 0 0;
      color: #666; }
</style>
<sec:authorize var="loggedIn" access="isAuthenticated()" />
<c:choose>
 <c:when test="${loggedIn}">
    <!-- Wrap the .navbar in .container to center it on the page and provide easy way to target it with .navbar-wrapper. -->
    
    <div class="container navbar-wrapper">
      <div class="navbar navbar-inverse">
        <div class="navbar-inner">
         <!-- Responsive Navbar Part 1: Button for triggering responsive navbar (not covered in tutorial). Include responsive CSS to utilize. -->
          <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </a>
            <a class="brand" href="#">Social Realtor</a>
          <!-- Responsive Navbar Part 2: Place all navbar contents you want collapsed withing .navbar-collapse.collapse. -->
          <div class="nav-collapse collapse">
			<ul class="nav " >
				<li><a href="<c:url value="/home"/>"><i class="icon-home icon-white"></i> Home </a></li>
				<li class="dropdown">
				<a href="<c:url value="/myprofile"/>"  title="My Profile" class="dropdown-toggle" data-toggle="dropdown"> <i class="icon-user icon-white"></i><span>My Profile</span><b class="caret"></b></a>
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
				<li><a href="<c:url value="/properties"/>"><i class="icon-book icon-white"></i><span>Property Listings</span></a></li>
				<li>
				<a href="<c:url value="/connect"/>" ><i class="icon-wrench icon-white"></i><span>Manage Social Connections</span></a></li>
				<social:connected provider="facebook">
				<li><a href="#"  title="Dropdown options available only when connected" class="dropdown-toggle" data-toggle="dropdown"><img src="<c:url value="/resources/social/facebook/f_logo.jpg" />" style="width:15px;height:15px"/><span>Facebook</span><b class="caret"></b></a>
					<ul class="dropdown-menu">
						<li><a href="<c:url value="/facebook/page"/>">Page</a></li>
						<li><a href="<c:url value="/facebook/pageEvent"/>">PageEvent</a></li>
					</ul>
				</li>
				</social:connected>
				<social:connected provider="twitter">
				<li><a href="#"  title="Dropdown options available only when connected" class="dropdown-toggle" data-toggle="dropdown"><span>Twitter</span><b class="caret"></b></a>
					<ul class="dropdown-menu">
						<%-- <li><a href="<c:url value="/twitter"/>">User Profile</a></li> --%>
						<li><a href="<c:url value="/twitter/timeline"/>">Timeline</a></li>
						<%-- <li><a href="<c:url value="/twitter/friends"/>">Friends</a></li>
						<li><a href="<c:url value="/twitter/followers"/>">Followers</a></li>
						<li><a href="<c:url value="/twitter/messages"/>">Messages</a></li>
						<li><a href="<c:url value="/twitter/trends"/>"> Trends</a></li> --%>
					</ul>
				</li>
				</social:connected>
				<li><a href="<c:url value="/analytics"/>" title="Analytics"><span>Analytics</span></a></li>
				<li><a href="<c:url value="/customer/getAppt"/>" title="Appointments"><span>Appointments</span></a></li>
				<li><a href="http://www.realtor.org/news-releases" title="News"><span>News</span></a></li>
	
				<li><a style="float:right" href="<c:url value="/signout"/>" title="Matching"><span>Signout</span></a></li>	
			</ul>
          </div><!--/.nav-collapse -->
        </div><!-- /.navbar-inner -->
      </div><!-- /.navbar -->

    </div><!-- /.container -->
</c:when>
<c:otherwise>
      <div class="container navbar-wrapper">
      <div class="navbar navbar-inverse">
      <div class="navbar-inner">
        <div class="container">
          <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </a>
          <a class="brand" href="#">Social Realtor</a>
          <div class="nav-collapse">
              
              
              <ul class="nav actions">
                  <li><a href="#login-modal" data-toggle="modal" data-target="#login-modal">Log In</a></li>
                  <li><a href="<c:url value="/signup"/>">Sign Up</a></li>
              </ul>
              
              
            <ul class="nav">
                <li><a href="/discover/">Discover</a></li>
                <li><a href="/about/">About us</a></li>
                <li><a href="http://blog.kippt.com">Blog</a></li>
            </ul>
          </div><!--/.nav-collapse -->
        </div>
      </div>
    </div>
    </div>
</c:otherwise>
</c:choose>

<div class="modal hide fade" id="login-modal" style="display: block;">
<h3>Log in to Social Realtor</h3>
<a class="close" data-dismiss="modal">&times;</a>
<form id="signin" action="<c:url value="/signin/authenticate" />" method="post">
	<div class="formInfo">
  		<c:if test="${param.error eq 'bad_credentials'}">
  		<div class="error">
  			Your sign in information was incorrect.
  			Please try again or <a href="<c:url value="/signup" />">sign up</a>.
  		</div>
 	 	</c:if>
  		<c:if test="${param.error eq 'multiple_users'}">
  		<div class="error">
  			Multiple local accounts are connected to the provider account.
  			Try again with a different provider or with your username and password.
  		</div>
 	 	</c:if>
	</div>
	<fieldset>
		<label for="login">Email ID</label>
		<input id="login" name="j_username" type="text" size="25" <c:if test="${not empty signinErrorMessage}">value="${SPRING_SECURITY_LAST_USERNAME}"</c:if> />
		<label for="password">Password</label>
		<input id="password" name="j_password" type="password" size="25" />	
	</fieldset>
	<button type="submit">Sign In</button>
	
	<!--<p>Some test user/password pairs you may use are:</p>
	<ul>
		<li>habuma/freebirds</li>
		<li>kdonald/melbourne</li>
		<li>rclarkson/atlanta</li>
	</ul>
	-->
	<p>Or you can <a href="<c:url value="/signup"/>">signup</a> with a new account.</p>
</form>

	<!-- TWITTER SIGNIN 
	<form id="tw_signin" action="<c:url value="/signin/twitter"/>" method="POST">
		<button type="submit"><img src="<c:url value="/resources/social/twitter/sign-in-with-twitter-d.png"/>" /></button>
	</form>
	-->
	<!-- FACEBOOK SIGNIN -->
	<form name="fb_signin" id="fb_signin" action="<c:url value="/signin/facebook"/>" method="POST">
        <input type="hidden" name="scope" value="publish_stream,user_photos,offline_access,manage_pages,create_event" />
		<button type="submit"><img src="<c:url value="/resources/social/facebook/sign-in-with-facebook.png"/>" /></button>
	</form>
</div>
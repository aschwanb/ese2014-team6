<%@tag description="Page structure with top (and bottom)" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> --%>
<%-- <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> --%>
<%@taglib prefix="base" tagdir="/WEB-INF/tags" %>

<%@attribute name="header" fragment="true" required="true" %>

<base:page_bottom>
	<jsp:attribute name="header">
		<jsp:invoke fragment="header"/>
	</jsp:attribute>
	
	<jsp:body>
	
		<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#navbar" aria-expanded="false"
						aria-controls="navbar">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="index">Studi Home</a>
				</div>
				<div id="navbar" class="navbar-collapse collapse">
					<c:choose>
						<c:when test="${pageContext.request.userPrincipal.name != null}">
							<ul class="nav navbar-nav navbar-left">
								<li><a href="calendar">Calendar</a></li>
								<li><a href="bookmarks">Bookmarks</a></li>
								<li><a href="alerts">Alerts</a></li>
								<li><a href="messages">Messages</a></li>
								<li><a href="myAdverts">My Adverts</a></li>
								<li><a href="advert">Create Advert</a></li>
							</ul>
							<ul class="nav navbar-nav">
								<li class="divider"></li>
							</ul>
							<ul class="nav navbar-nav navbar-right">
								<li><a href="profile">${pageContext.request.userPrincipal.name} <span class="glyphicon glyphicon-user"></span></a></li>
								<li><a id="logoutbtn" href="<c:url value="j_spring_security_logout" />" data-toggle="popover" data-placement="bottom" data-trigger="hover focus" data-content="Sign Out"><span class="glyphicon glyphicon-log-out"></span></a></li>
							</ul>
						</c:when>
						<c:otherwise>
							<ul class="nav navbar-nav navbar-right">
								<li><a href="register">Register</a></li>
								<li><a href="login">Login <span class="glyphicon glyphicon-log-in"></span></a></li>
							</ul>
						</c:otherwise>
					</c:choose>
				</div>
				<!--/.nav-collapse -->
			</div>
		</nav>
		
		<jsp:doBody/>
	</jsp:body>
</base:page_bottom>


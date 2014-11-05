<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="base" tagdir="/WEB-INF/tags" %>

<nav class="navbar navbar-default navbar-static-top" role="navigation">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="index">Studi Home</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
          	<c:choose>
				<c:when test="${pageContext.request.userPrincipal.name != null}">
            		<li class="dropdown">
              			<a href="#" class="dropdown-toggle" data-toggle="dropdown">My Account <span class="caret"></span></a>
              			<ul class="dropdown-menu" role="menu">
                			<li><a href="#">Calendar</a></li>
                			<li><a href="#">Messages</a></li>
                			<li><a href="#">Bookmarks</a></li>
                			<li><a href="#">My Adverts</a></li>
                			<li class="divider"></li>
               <!--  <li class="dropdown-header">Nav header</li>-->
               				<li><a href="profilepage">My Profile</a></li>
               				<li><a href="<c:url value="j_spring_security_logout" />">Sign Out</a></li>
              			</ul>
            		</li>			
            </c:when>
            <c:otherwise>
            	<li><a href="login">Login</a></li>
                <li><a href="register">Sign Up</a></li>
            </c:otherwise>
            </c:choose>            
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>
</body>
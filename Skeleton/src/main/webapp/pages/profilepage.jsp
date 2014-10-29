<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="base" tagdir="/WEB-INF/tags" %>


<base:page title="Profile">

	<div class="page-header">
		<h1>Temporary Profile Page</h1>
	</div>
		<c:if test="${pageContext.request.userPrincipal.name != null}">
		   <h2>Welcome : ${pageContext.request.userPrincipal.name}</h2>
			<a class="btn btn-default" href="<c:url value="j_spring_security_logout" />">Logout</a>           
		</c:if>
	<a class="btn btn-default" href=adpage>Create new Ad</a>
	<a class="btn btn-default" href=fileupload>Upload Images</a>
	
	<!-- Quick Search -->
	<div>
		<form>
			<div class="row">
			  <div class="col-lg-6">
			    <div class="input-group">
			      <input type="text" class="form-control">
			      <span class="input-group-btn">
			        <button class="btn btn-default" type="button">Go!</button>
			      </span>
			    </div><!-- /input-group -->
			  </div><!-- /.col-lg-6 -->
			</div><!-- /.row -->
		</form>
		
		<!-- Nav tabs -->
		<ul class="nav nav-tabs" role="tablist">
		  <li class="active"><a href="#profile-cal" role="tab" data-toggle="tab">Calendar</a></li>
		  <li><a href="#profile-msg" role="tab" data-toggle="tab">Messages</a></li>
		  <li><a href="#profile-bm" role="tab" data-toggle="tab">Bookmarks</a></li>
		  <li><a href="#profile-adv" role="tab" data-toggle="tab">My Adverts</a></li>
		</ul>
		
		<!-- Tab panes -->
		<div class="tab-content">
		  <div class="tab-pane fade in active" id="profile-cal">A...</div>
		  <div class="tab-pane fade" id="profile-msg">B...</div>
		  <div class="tab-pane fade" id="profile-bm">C...</div>
		  <div class="tab-pane fade" id="profile-adv"><a class="btn btn-default" href=adpage?id=1>Open Ad 1</a> </div>
		</div>
	</div>

</base:page>

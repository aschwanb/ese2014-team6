<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="base" tagdir="/WEB-INF/tags" %>


<base:page title="Profile">
	<jsp:attribute name="page_header">
		<h1>Username: ${user.userName}</h1>
		<h1>ID: ${user.usr_id}</h1>
		
	</jsp:attribute>

	<jsp:body>
		<a class="btn btn-default" href=advert>Create new Ad</a>
		
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
						</div>
						<!-- /input-group -->
					</div>
					<!-- /.col-lg-6 -->
				</div>
				<!-- /.row -->
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
				<div class="tab-pane fade in active" id="profile-cal">
					A...
				</div>
				<div class="tab-pane fade" id="profile-msg">
					B...
				</div>
				<div class="tab-pane fade" id="profile-bm">
					<c:if test="${not empty bookmarks}">
						<table class="table table-striped table-hover">
							<tr><th>Title</th><th>Price</th></tr>
							<c:forEach var="ad" items="${bookmarks}">
								<tr onclick="document.location='advert?id=${ad.adv_id}';">
									<td><a href="advert?id=${ad.adv_id}"><c:out value="${ad.title}"/></a></td>
									<td><a href="advert?id=${ad.adv_id}"><c:out value="${ad.price}"/></a></td>
								</tr>
							</c:forEach>
						</table>
					</c:if>
					<c:if test="${empty bookmarks}">
						No Ads bookmarked.
					</c:if>
				</div>
				<div class="tab-pane fade" id="profile-adv">
					<c:if test="${not empty ads}">
						<table class="table table-striped table-hover">
							<tr><th>Title</th><th>Price</th></tr>
							<c:forEach var="ad" items="${ads}">
								<tr onclick="document.location='advert?id=${ad.adv_id}';">
									<td><a href="advert?id=${ad.adv_id}"><c:out value="${ad.title}"/></a></td>
									<td><a href="advert?id=${ad.adv_id}"><c:out value="${ad.price}"/></a></td>
								</tr>
							</c:forEach>
						</table>
					</c:if>
					<c:if test="${empty ads}">
						No Ads available.
					</c:if>
				</div>
			</div>
		</div>
	</jsp:body>
</base:page>

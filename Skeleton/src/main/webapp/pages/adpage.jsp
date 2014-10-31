<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="base" tagdir="/WEB-INF/tags" %>


<base:page title="Advert">
	<jsp:attribute name="customHead">
		<script type="text/javascript"  src="js/adp_carousel.js"></script>
		<script type="text/javascript"  src="js/adp_tabs.js"></script>
	</jsp:attribute>

	<jsp:body>
		<div class="page-header">
			<h1>Advert<c:if test="${editable}"> <small>edit mode</small></c:if></h1>
		</div>
		
		<div class="stepwizard">
			<div class="stepwizard-row setup-panel">
				<div class="stepwizard-step">
					<a href="#main" type="button" class="btn btn-primary btn-circle"> </a>
					<p>Main Info</p>
				</div>
				<div class="stepwizard-step">
					<a href="#add" type="button" class="btn btn-default btn-circle" ${adForm.id == 0 ? 'disabled="disabled"':''}> </a>
					<p>Additional Info</p>
				</div>
				<div class="stepwizard-step">
					<a href="#map" type="button" class="btn btn-default btn-circle" ${adForm.id == 0 ? 'disabled="disabled"':''}> </a>
					<p>Map</p>
				</div>
				<div class="stepwizard-step">
					<a href="#pics" type="button" class="btn btn-default btn-circle" ${adForm.id == 0 ? 'disabled="disabled"':''}> </a>
					<p>Pictures</p>
				</div>
			</div>
		</div>
		
		<form:form method="post" modelAttribute="adForm" action="saveAdvert" id="adForm" cssClass="form-horizontal"  enctype="multipart/form-data" autocomplete="off" role="form">
			
			<div class="row setup-content" id="main">
				<div class="col-xs-12">
					<div class="col-md-12">
						<%@include file="adpage_parts/adp_mainInfo.jsp"%>
						<button class="btn btn-primary nextBtn btn-lg pull-right"  type="button" >Next</button>
					</div>
				</div>
			</div>
			<div class="row setup-content" id="add">
				<div class="col-xs-12">
					<div class="col-md-12">
						<%@include file="adpage_parts/adp_additionalInfo.jsp"%>
						<button class="btn btn-primary prevBtn btn-lg"  type="button" >Previous</button>
						<button class="btn btn-primary nextBtn btn-lg pull-right"  type="button" >Next</button>
					</div>
				</div>
			</div>
			<div class="row setup-content" id="map">
				<div class="col-xs-12">
					<div class="col-md-12">
						<%@include file="adpage_parts/adp_map.jsp"%>
						<button class="btn btn-primary prevBtn btn-lg" type="button" >Previous</button>
						<button class="btn btn-primary nextBtn btn-lg pull-right" type="button" >Next</button>
					</div>
				</div>
			</div>
			<div class="row setup-content" id="pics">
				<div class="col-xs-12">
					<div class="col-md-12">
						<%@include file="adpage_parts/adp_pictures.jsp"%>
						<button class="btn btn-primary prevBtn btn-lg" type="button" >Previous</button>
					</div>
				</div>
			</div>
			
			<%-- username unnötig? --%>
			<form:input type="hidden"  path="ownerEmail" id="field-ownerEmail" value="${pageContext.request.userPrincipal.name}" />
			
			<div class="form-group">
				<div class="col-xs-12 adpage-buttongroup">
					<div class="col-md-12 pull-right">
						<c:if test="${editable == false}">
							<a class="btn btn-primary btn-lg adpage-buttongroupbutton" href="bookmark">Bookmark</a>
						</c:if>
						<c:if test="${editable == true}">
							<button type="submit" class="btn btn-primary btn-lg adpage-buttongroupbutton" ${adForm.id == 0 ? 'disabled="disabled"':''}>Save</button>
						</c:if>
						<a class="btn btn-default btn-lg adpage-buttongroupbutton" href="${editable ? 'discard' : 'contact'}" ${adForm.id == 0 ? 'disabled="disabled"':''}>${editable ? 'Discard' : 'Contact'}</a>
					</div>
				</div>
			</div>
		</form:form>
	</jsp:body>
</base:page>

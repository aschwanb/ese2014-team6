<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="base" tagdir="/WEB-INF/tags" %>


<base:page title="Advert">
	<jsp:attribute name="customHead">
		<script type="text/javascript"  src="js/adp_tabs.js"></script>
		<script type="text/javascript" src="http://maps.googleapis.com/maps/api/js?sensor=false"></script>
		<script type="text/javascript" src="js/map.js"></script>
		<script type="text/javascript"  src="js/adp_carousel.js"></script>
	</jsp:attribute>

	<jsp:body>
		<div class="page-header">
			<h1>Advert<c:if test="${editable}"> <small>edit mode</small></c:if></h1>
		</div>
		
		<c:if test="${not empty alertGood}">
			<div class="alert alert-success alert-dismissible" role="alert">
				<button type="button" class="close" data-dismiss="alert"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
				<strong>Success!</strong> ${alertGood}
			</div>
		</c:if>
		
		<c:if test="${not empty alertError}">
			<div class="alert alert-danger alert-dismissible" role="alert">
				<button type="button" class="close" data-dismiss="alert"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
				<strong>Failed!</strong> ${alertError}
			</div>
		</c:if>
		
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
						<%@include file="/WEB-INF/jspf/adpage_parts/adp_mainInfo.jspf"%>
						<button class="btn btn-primary nextBtn btn-lg pull-right"  type="button" >Next</button>
					</div>
				</div>
			</div>
			<div class="row setup-content" id="add">
				<div class="col-xs-12">
					<div class="col-md-12">
						<%@include file="/WEB-INF/jspf/adpage_parts/adp_additionalInfo.jspf"%>
						<button class="btn btn-primary prevBtn btn-lg"  type="button" >Previous</button>
						<button class="btn btn-primary nextBtn btn-lg pull-right"  type="button" >Next</button>
					</div>
				</div>
			</div>
			<div class="row setup-content" id="map">
				<div class="col-xs-12">
					<div class="col-md-12">
						<%@include file="/WEB-INF/jspf/adpage_parts/adp_map.jspf"%>
						<button class="btn btn-primary prevBtn btn-lg" type="button" >Previous</button>
						<button class="btn btn-primary nextBtn btn-lg pull-right" type="button" >Next</button>
					</div>
				</div>
			</div>
			<div class="row setup-content" id="pics">
				<div class="col-xs-12">
					<div class="col-md-12">
						<%@include file="/WEB-INF/jspf/adpage_parts/adp_pictures.jspf"%>
						<button class="btn btn-primary prevBtn btn-lg" type="button" >Previous</button>
					</div>
				</div>
			</div>
			
			<div class="form-group hidden">
				<form:input type="hidden" path="id" id="field-id"/>
				<form:input type="hidden" path="ownerId" id="field-ownerId"/>
			</div>
			
			<div class="col-xs-12 adpage-buttongroup">
				<div class="col-md-12 pull-right">
					<div class="form-group">
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

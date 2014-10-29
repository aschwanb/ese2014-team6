<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<c:import url="template/header.jsp" />

<div class="page-header">
	<h1>Advert Page <c:if test="${editable}"><small>edit mode</small></c:if></h1>
</div>

<div>
	[Pictures]
	<button id="upldBtn">Show upload</button>
</div>

<form:form method="post" modelAttribute="adForm" action="saveAdvert" id="adForm" cssClass="form-horizontal"  autocomplete="off">
	<c:set var="titleErrors"><form:errors path="title"/></c:set>
	<div class="form-group<c:if test="${not empty titleErrors}"> has-error</c:if>">
		<c:if test="${editable == true}">
			<form:input path="title" id="field-title" tabindex="1" type="text" class="form-control" placeholder="Title" />
			<form:errors path="title" cssClass="help-inline" element="span"/>
		</c:if>
		<c:if test="${editable == false}">
			<form:input path="title" id="field-title" tabindex="1" type="text" class="form-control" style="cursor: text;" readonly="true" placeholder="Title" />
		</c:if>
	</div>
	<c:set var="streetErrors"><form:errors path="street"/></c:set>
	<div class="form-group<c:if test="${not empty streetErrors}"> has-error</c:if>">
		<c:if test="${editable == true}">
			<form:input path="street" id="field-street" tabindex="2" type="text" class="form-control" placeholder="Street" />
			<form:errors path="street" cssClass="help-inline" element="span"/>
		</c:if>
		<c:if test="${editable == false}">
			<form:input path="street" id="field-street" tabindex="2" type="text" class="form-control" style="cursor: text;" readonly="true" placeholder="Street" />
		</c:if>
	</div>
	<c:set var="plzErrors"><form:errors path="plz"/></c:set>
	<c:set var="cityErrors"><form:errors path="city"/></c:set>
	<div class="form-group<c:if test="${not empty plzErrors or not empty cityErrors}"> has-error</c:if>">
		<c:if test="${editable == true}">
			<form:input path="plz" id="field-plz" tabindex="3" type="text" class="form-control" placeholder="Plz." />
			<form:errors path="plz" cssClass="help-inline" element="span"/>
			<form:input path="city" id="field-city" tabindex="4" type="text" class="form-control" placeholder="City" />
			<form:errors path="city" cssClass="help-inline" element="span"/>
		</c:if>
		<c:if test="${editable == false}">
			<form:input path="plz" id="field-plz" tabindex="3" type="text" class="form-control" style="cursor: text;" readonly="true" placeholder="Plz." />
			<form:input path="city" id="field-city" tabindex="4" type="text" class="form-control" style="cursor: text;" readonly="true" placeholder="City" />
		</c:if>
	</div>
	<c:set var="priceErrors"><form:errors path="price"/></c:set>
	<div class="form-group<c:if test="${not empty priceErrors}"> has-error</c:if>">
		<c:if test="${editable == true}">
			<form:input path="price" id="field-price" tabindex="5" type="text" class="form-control" placeholder="Price" />
			<form:errors path="price" cssClass="help-inline" element="span"/>
		</c:if>
		<c:if test="${editable == false}">
			<form:input path="price" id="field-price" tabindex="5" type="text" class="form-control" style="cursor: text;" readonly="true"  placeholder="Price" />
		</c:if>
	</div>
	<c:set var="descriptionErrors"><form:errors path="description"/></c:set>
	<div class="form-group<c:if test="${not empty descriptionErrors}"> has-error</c:if>">
		<c:if test="${editable == true}">
			<form:textarea path="description" id="field-description" tabindex="6" class="form-control" rows="5" placeholder="Description"></form:textarea>
			<form:errors path="description" cssClass="help-inline" element="span"/>
		</c:if>
		<c:if test="${editable == false}">
			<form:textarea path="description" id="field-description" tabindex="6" class="form-control" rows="5" style="cursor: text;" readonly="true" placeholder="Description"></form:textarea>
		</c:if>
	</div>
	
	<form:input type="hidden"  path="ownerEmail" id="field-ownerEmail" value="${pageContext.request.userPrincipal.name}" />
	
	<div class="form-group">
		<c:if test="${editable == false}">
			<a class="btn btn-primary" href="bookmark">Bookmark</a>
		</c:if>
		<c:if test="${editable == true}">
			<button type="submit" class="btn btn-primary" >Save</button>
		</c:if>
		<a class="btn btn-default" href="${editable ? 'discard' : 'contact'}">${editable ? 'Discard' : 'Contact'}</a>
	</div>
</form:form>

<div id="pictureUploadFormular" style="display: none;">
	<!-- Hier das upload Formular einfügen -->
	blabla
</div>

<script type="text/javascript">
<!--
document.getElementById('upldBtn').onclick = function() {
	document.getElementById('pictureUploadFormular').style = "";
};
//-->
</script>

<c:import url="template/footer.jsp" />

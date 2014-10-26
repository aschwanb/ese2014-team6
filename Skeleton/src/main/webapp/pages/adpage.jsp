<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<c:import url="template/header.jsp" />

<div class="page-header">
	<h1>Advert Page <c:if test="${editable}"><small>edit mode</small></c:if></h1>
</div>

<a href="${editable ? 'adpage' : 'adpage_edit'}" class="btn btn-default">switch</a>

<div>
	[Pictures]
</div>

<form:form method="post" modelAttribute="adForm" action="saveAdvert" id="adForm" cssClass="form-horizontal"  autocomplete="off">
	<div class="form-group">
		<c:if test="${editable == false}">
			<form:input path="title" id="field-title" tabindex="1" type="text" class="form-control" style="cursor: text;" readonly="true" value="Title" placeholder="Title" />
		</c:if>
		<c:if test="${editable == true}">
			<form:input path="title" id="field-title" tabindex="1" type="text" class="form-control" placeholder="Title" />
		</c:if>
	</div>
	<div class="form-group">
		<c:if test="${editable == false}">
			<form:input path="street" id="field-street" tabindex="2" type="text" class="form-control" style="cursor: text;" readonly="true" value="Street" placeholder="Street" />
		</c:if>
		<c:if test="${editable == true}">
			<form:input path="street" id="field-street" tabindex="2" type="text" class="form-control" placeholder="Street" />
		</c:if>
	</div>
	<div class="form-group">
		<c:if test="${editable == false}">
			<form:input path="plz" id="field-plz" tabindex="3" type="text" class="form-control" style="cursor: text;" readonly="true" value="Plz." placeholder="Plz." />
			<form:input path="city" id="field-city" tabindex="4" type="text" class="form-control" style="cursor: text;" readonly="true" value="City" placeholder="City" />
		</c:if>
		<c:if test="${editable == true}">
			<form:input path="plz" id="field-plz" tabindex="3" type="text" class="form-control" placeholder="Plz." />
			<form:input path="city" id="field-city" tabindex="4" type="text" class="form-control" placeholder="City" />
		</c:if>
	</div>
	<div class="form-group">
		<c:if test="${editable == false}">
			<form:input path="price" id="field-price" tabindex="5" type="text" class="form-control" style="cursor: text;" readonly="true" value="Price" placeholder="Price" />
		</c:if>
		<c:if test="${editable == true}">
			<form:input path="price" id="field-price" tabindex="5" type="text" class="form-control" placeholder="Price" />
		</c:if>
	</div>
	<div class="form-group">
		<c:if test="${editable == false}">
			<form:textarea path="description" id="field-description" tabindex="6" class="form-control" rows="5" style="cursor: text;" readonly="true" placeholder="Description" value="Description"></form:textarea>
		</c:if>
		<c:if test="${editable == true}">
			<form:textarea path="description" id="field-description" tabindex="6" class="form-control" rows="5" placeholder="Description"></form:textarea>
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

<div id="pictureUploadFormular">
	<!-- Hier das upload Formular einfügen -->
</div>

<c:import url="template/footer.jsp" />

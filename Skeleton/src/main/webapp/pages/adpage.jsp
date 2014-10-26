<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<c:import url="template/header.jsp" />

<!-- no edit -->
<div class="page-header">
	<h1>Advert Page <c:if test="${editable}"><small>edit mode</small></c:if></h1>
</div>

<a href="${editable ? 'adpage' : 'adpage_edit'}" class="btn btn-default">switch</a>

<div>
	[Pictures]
</div>

<form:form method="post" modelAttribute="adForm" action="create" id="adForm" cssClass="form-horizontal"  autocomplete="off">
	<div class="form-group">
		<form:input path="title" id="field-title" tabindex="1" type="text" class="form-control" <c:if test="${editable == false}">style="cursor: text;" readonly value="Title"</c:if> placeholder="Title" />
	</div>
	<div class="form-group">
		<form:input path="street" id="field-street" tabindex="2" type="text" class="form-control" <c:if test="${editable == false}">style="cursor: text;" readonly value="Street"</c:if> placeholder="Street" />
	</div>
	<div class="form-group">
		<form:input path="plz" id="field-plz" tabindex="3" type="text" class="form-control" <c:if test="${editable == false}">style="cursor: text;" readonly value="Plz."</c:if> placeholder="Plz." />
		<form:input path="city" id="field-city" tabindex="4" type="text" class="form-control" <c:if test="${editable == false}">style="cursor: text;" readonly value="City"</c:if> placeholder="City" />
	</div>
	<div class="form-group">
		<form:input path="price" id="field-price" tabindex="5" type="text" class="form-control" <c:if test="${editable == false}">style="cursor: text;" readonly value="Price"</c:if> placeholder="Price" />
	</div>
	<div class="form-group">
		<form:textarea path="description" id="field-description" tabindex="6" class="form-control" rows="5" <c:if test="${editable == false}">style="cursor: text;" readonly</c:if> placeholder="Description"><c:if test="${editable == false}">Description</c:if></form:textarea>
	</div>
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

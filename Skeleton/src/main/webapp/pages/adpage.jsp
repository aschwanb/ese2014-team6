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

<div>
	<div class="form-group">
		<input type="text" class="form-control" <c:if test="${editable == false}">style="cursor: text;" readonly value="Title"</c:if> placeholder="Title" />
	</div>
	<div class="form-group">
		<input type="text" class="form-control" <c:if test="${editable == false}">style="cursor: text;" readonly value="Address"</c:if> placeholder="Address" />
	</div>
	<div class="form-group">
		<input type="text" class="form-control" <c:if test="${editable == false}">style="cursor: text;" readonly value="Price"</c:if> placeholder="Price" />
	</div>
	<div class="form-group">
		<textarea class="form-control" rows="5" <c:if test="${editable == false}">style="cursor: text;" readonly</c:if> placeholder="Description"><c:if test="${editable == false}">Description</c:if></textarea>
	</div>
	<div class="form-group">
		<a class="btn btn-primary" href="${editable ? 'save' : 'bookmark'}">${editable ? 'Save' : 'Bookmark'}</a>
		<a class="btn btn-default" href="${editable ? 'discard' : 'contact'}">${editable ? 'Discard' : 'Contact'}</a>
	</div>
</div>

<c:import url="template/footer.jsp" />

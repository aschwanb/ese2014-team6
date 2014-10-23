<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<c:import url="template/header.jsp" />

<!-- no edit -->
<div class="page-header">
	<h1>Advert Page</h1>
</div>

<a href="adpageEdit" class="btn btn-default">switch</a>

<div>
	[Pictures]
</div>

<div>
	<div class="form-group">
		<input type="text" class="form-control" style="cursor: text;" readonly value="Title" />
	</div>
	<div class="form-group">
		<input type="text" class="form-control" style="cursor: text;" readonly value="Address" />
	</div>
	<div class="form-group">
		<input type="text" class="form-control" style="cursor: text;" readonly value="Price" />
	</div>
	<div class="form-group">
		<textarea class="form-control" style="cursor: text;" rows="5" readonly>Description</textarea>
	</div>
	<div class="form-group">
		<a class="btn btn-primary" href="bookmark">Bookmark</a>
		<a class="btn btn-default" href="contact">Contact</a>
	</div>
</div>

<c:import url="template/footer.jsp" />

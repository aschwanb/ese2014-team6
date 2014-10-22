<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<c:import url="template/header.jsp" />

<!-- Edit Page -->
<div class="page-header">
	<h1>Advert Page <small>edit mode</small></h1>
</div>

<a href="adpage" class="btn btn-default">switch</a>

<div>
	[Pictures]
</div>

<div>
<form role="form">
	<div class="form-group">
		<input type="text" class="form-control" placeholder="Title" />
	</div>
	<div class="form-group">
		<input type="text" class="form-control" placeholder="Address" />
	</div>
	<div class="form-group">
		<input type="text" class="form-control" placeholder="Price" />
	</div>
	<div class="form-group">
		<textarea class="form-control" rows="5" placeholder="Description"></textarea>
	</div>
	<div class="form-group">
		<a class="btn btn-primary" href="bookmark">Save</a>
		<a class="btn btn-default" href="contact">Discard</a>
	</div>
</form>
</div>

<c:import url="template/footer.jsp" />

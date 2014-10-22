<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<c:import url="template/header.jsp" />

<h1>Advert Page</h1>

[Pictures]

<form role="form-horizontal">

<input type="text" placeholder="Title" />
<input type="text" placeholder="Address" />
<input type="text" placeholder="Price" />
<input type="text" placeholder="Description" />
<a class="btn btn-primary" href=>Create Ad</a>
<a class="btn" href=adpage>Cancel</a>
</form>

<c:import url="template/footer.jsp" />

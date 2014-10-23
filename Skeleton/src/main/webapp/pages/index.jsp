<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<c:import url="template/header.jsp" />

<div class="page-header">
	<h1>Welcome to StudiHome</h1>
</div>

<h2>Start looking for your home today</h2>

        <div class="form-actions">
            <a class="btn btn-warning" href="register">Sign Up Here!</a>     
            <a class="btn btn-primary" href="login">Login</a>
            <a class="btn btn-default" href="profilepage">My Profile</a>
        </div>

<c:import url="template/footer.jsp" />

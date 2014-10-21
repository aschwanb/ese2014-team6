<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<c:import url="template/header.jsp" />

<h1>Welcome to StudiHome</h1>
<h2>Start looking for your home today</h2>

        <div class="form-actions">
            <a class="btn btn-default" href="register">Sign Up Here!</a>            
            <a class="btn btn-default" href="login">Login</a>            
        </div>

<!--         <div class="form-actions"> -->
<!--             <button type="submit" class="btn" value="register">Sign Up Here!</button>             -->
<!--             <button type="submit" class="btn" value="login">Login</button> -->
<!--         </div> -->

<a href='register'>No account? Sign Up Here!</a>
<a href='login'>Log in with your account</a>

<c:import url="template/footer.jsp" />

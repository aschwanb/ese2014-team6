<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<form:form method="post" modelAttribute="adForm" action="advert" id="adForm" cssClass="form-horizontal" accept-charset="UTF-8" enctype="multipart/form-data" autocomplete="off" role="form">
	<div id="infodiv">
		<%@include file="/WEB-INF/jspf/adpage_parts/adp_info.jspf"%>
	</div>
</form:form>
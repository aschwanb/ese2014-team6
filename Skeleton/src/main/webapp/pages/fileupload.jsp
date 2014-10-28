<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<c:import url="template/header.jsp" />

<h1>${msg}</h1>

<c:if test="${not empty error}">
	<div class="error">${error}</div>
</c:if>

<form:form method="post" modelAttribute="fileUploadForm" action="savefile" id="fileUploadForm" enctype="multipart/form-data" cssClass="form-horizontal" autocomplete="off">
	<fieldset>
		<legend>Select a file to upload</legend>
		
		
        <c:set var="fileErrors"><form:errors path="file"/></c:set>
        <div class="control-group<c:if test="${not empty fileErrors}">error</c:if>">
            <label class="control-label" for="field-file">File</label>
            <div class="controls">
                <form:input type = "file" path="file" id="field-file" tabindex="1" maxlength="45" placeholder="Email"/>
                <form:errors path="file" cssClass="help-inline" element="span"/>
            </div>
        </div>
        
        <c:set var="nameErrors"><form:errors path="name"/></c:set>
        <div class="control-group<c:if test="${not empty nameErrors}">error</c:if>">
            <label class="control-label" for="field-name">Name</label>
            <div class="controls">
                <form:input path="name" id="field-name" tabindex="1" maxlength="45" placeholder="Name"/>
                <form:errors path="name" cssClass="help-inline" element="span"/>
            </div>
        </div>        <div class="form-actions">
            <button type="submit" class="btn btn-primary">Upload</button>
            <a class="btn btn-default" href="index">Cancel</a>            
        </div>		
	</fieldset>
</form:form>


<c:import url="template/footer.jsp" />

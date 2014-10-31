<c:if test="${editable == true}">
	<c:set var="imageErrors"><form:errors path="image"/></c:set>
	<div class="form-group<c:if test="${not empty imageErrors}">error</c:if>">
		<label class="control-label" for="field-image">Upload image</label>
		<div class="controls">
			<form:input type = "file" path="image" id="field-image" maxlength="45" placeholder="Picture"/>
			<form:errors path="image" cssClass="help-inline" element="span"/>
		</div>
	</div>	
	<c:if test="${editable == false}"> <%-- TODO --%>
		<img src="/Skeleton/user/ad/img/square.jpg" alt="..." class="img-thumbnail">
	</c:if>
</c:if>
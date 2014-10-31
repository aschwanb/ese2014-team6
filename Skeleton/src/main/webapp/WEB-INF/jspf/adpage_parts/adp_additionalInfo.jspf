<c:set var="descriptionErrors"><form:errors path="description"/></c:set>
<div class="form-group<c:if test="${not empty descriptionErrors}"> has-error</c:if>">
	<c:if test="${editable == true}">
		<form:textarea path="description" id="field-description" class="form-control" rows="5" placeholder="Description"></form:textarea>
		<form:errors path="description" cssClass="help-inline" element="span"/>
	</c:if>
	<c:if test="${editable == false}">
		<form:textarea path="description" id="field-description" rows="5" class="form-control adform-output" readonly="true" placeholder="Description"></form:textarea>
	</c:if>
</div>
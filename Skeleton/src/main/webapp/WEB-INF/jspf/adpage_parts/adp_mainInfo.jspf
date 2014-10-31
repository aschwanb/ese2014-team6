<c:set var="titleErrors"><form:errors path="title"/></c:set>
<div class="form-group<c:if test="${not empty titleErrors}"> has-error</c:if>">
	<c:if test="${editable == true}">
		<form:input path="title" id="field-title" type="text" class="form-control" placeholder="Title" />
		<form:errors path="title" cssClass="help-inline" element="span"/>
	</c:if>
	<c:if test="${editable == false}">
		<form:input path="title" id="field-title" type="text" class="form-control adform-output" readonly="true" placeholder="Title" />
	</c:if>
</div>
<c:set var="streetErrors"><form:errors path="street"/></c:set>
<div class="form-group<c:if test="${not empty streetErrors}"> has-error</c:if>">
	<c:if test="${editable == true}">
		<form:input path="street" id="field-street" type="text" class="form-control" placeholder="Street" />
		<form:errors path="street" cssClass="help-inline" element="span"/>
	</c:if>
	<c:if test="${editable == false}">
		<form:input path="street" id="field-street" type="text" class="form-control adform-output" readonly="true" placeholder="Street" />
	</c:if>
</div>
<c:set var="plzErrors"><form:errors path="plz"/></c:set>
<c:set var="cityErrors"><form:errors path="city"/></c:set>
<div class="form-group<c:if test="${not empty plzErrors or not empty cityErrors}"> has-error</c:if>">
	<c:if test="${editable == true}">
		<form:input path="plz" id="field-plz" type="text" class="form-control" placeholder="Plz." />
		<form:errors path="plz" cssClass="help-inline" element="span"/>
		<form:input path="city" id="field-city" type="text" class="form-control" placeholder="City" />
		<form:errors path="city" cssClass="help-inline" element="span"/>
	</c:if>
	<c:if test="${editable == false}">
		<form:input path="plz" id="field-plz" type="text" class="form-control adform-output" readonly="true" placeholder="Plz." />
		<form:input path="city" id="field-city" type="text" class="form-control adform-output" readonly="true" placeholder="City" />
	</c:if>
</div>
<c:set var="priceErrors"><form:errors path="price"/></c:set>
<div class="form-group<c:if test="${not empty priceErrors}"> has-error</c:if>">
	<c:if test="${editable == true}">
		<form:input path="price" id="field-price" type="text" class="form-control" placeholder="Price" />
		<form:errors path="price" cssClass="help-inline" element="span"/>
	</c:if>
	<c:if test="${editable == false}">
		<form:input path="price" id="field-price" type="text" class="form-control adform-output" readonly="true"  placeholder="Price" />
	</c:if>
</div>
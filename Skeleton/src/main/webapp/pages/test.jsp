<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="base" tagdir="/WEB-INF/tags"%>


<base:page title="Test">
	<jsp:attribute name="customHead">
	
	<!-- For DateTimePicker -->
	    <link rel="stylesheet" type="text/css" href="css/bootstrap-datetimepicker.min.css">
		<script type="text/javascript" src="js/moment-2.8.4.js"></script>
		<script type="text/javascript" src="js/bootstrap-datetimepicker.min.js"></script>
		
	<!-- For Calendar -->
		<link rel="stylesheet" type="text/css" href="css/bic_calendar.css">
		<script type="text/javascript" src="js/bic_calendar.min.js"></script>
	</jsp:attribute>

	<jsp:body>
	
		<form:form method="post" modelAttribute="invitationForm" action="test" id="invitationForm" class="form-horizontal" role="form">
			<div class="form-group">
				<c:set var="toUserEmailErrors">
					<form:errors path="toUserEmail" />
				</c:set>
				<div class="control-group<c:if test="${not empty toUserEmailErrors}"> has-error</c:if>">
					<label for="field-toUserEmail" class="col-sm-2 control-label">To User Email</label>
					<div class="col-sm-10 form-inline">
						<form:input type="text" class="form-control" path="toUserEmail" id="field-toUserEmail" placeholder="Their Email" />
						<form:errors class="alert alert-danger" role="alert" path="toUserEmail" />
					</div>
				</div>
			</div>
			
			<div class="form-group">
				<c:set var="fromUserEmailErrors">
					<form:errors path="fromUserEmail" />
				</c:set>
				<div class="control-group<c:if test="${not empty fromUserEmailErrors}"> has-error</c:if>">
					<label for="field-fromUserEmail" class="col-sm-2 control-label">Your Email</label>
					<div class="col-sm-10 form-inline">
						<form:input type="text" class="form-control" path="fromUserEmail" id="field-fromUserEmail" placeholder="Your Email" />
						<form:errors class="alert alert-danger" role="alert" path="fromUserEmail" />
					</div>
				</div>
			</div>

			<div class="form-group">
				<c:set var="titleErrors">
					<form:errors path="title" />
				</c:set>
				<div class="control-group<c:if test="${not empty titleErrors}"> has-error</c:if>">
					<label for="field-title" class="col-sm-2 control-label">Title</label>
					<div class="col-sm-10 form-inline">
						<form:input type="text" class="form-control" path="title" id="field-title" placeholder="Title" />
						<form:errors class="alert alert-danger" role="alert" path="title" />
					</div>
				</div>
			</div>
			
			<div class="form-group">
				<label for="field-message" class="col-sm-2 control-label">Message</label>
				<div class="col-sm-6">
					<form:textarea type="text" class="form-control" path="message" id="field-message" placeholder="Message" />
				</div>
			</div>

		<!-- Pick Date test -->
	       	<div class="form-group">
	       	    <c:set var="invDateErrors">
					<form:errors path="" />
				</c:set>
	       	   	<div class="control-group<c:if test="${not empty invDateErrors}"> has-error</c:if>">
	   	        	<label for="field-invDate" class="col-sm-2 control-label">Choose a date</label>
	    			<div class="col-sm-10 form-inline date" id='datepicker'>
	               		<form:input type='text' class="form-control" path="invDate" id="field-invDate" data-date-format="DD/MM/YYYY" />
	            		<span class="form-inline-addon">
	          				<span class="glyphicon glyphicon-calendar"></span>
	           			</span>
	               		<form:errors class="alert alert-danger" role="alert" path="invDate" />
	        		</div>
	        		<script type="text/javascript">
	        	    	$(function () {
	        	    	    $('#datepicker').datetimepicker({
	        	    	    	pickTime: false
	        	    	    });
	        	   		});
	        		</script>
	    		</div>
			</div>

		<!-- Pick Date test -->
	       	<div class="form-group">
	       	    <c:set var="invFindErrors">
					<form:errors path="" />
				</c:set>
	       	   	<div class="control-group<c:if test="${not empty invTimeErrors}"> has-error</c:if>">
	   	        	<label for="field-invTime" class="col-sm-2 control-label">Choose a time</label>
	    			<div class="col-sm-10 form-inline date" id='timepicker'>
	               		<form:input type='text' class="form-control" path="invTime" id="field-invTime" data-date-format="HH:mm" />
	            		<span class="form-inline-addon">
	          				<span class="glyphicon glyphicon-time"></span>
	           			</span>
	               		<form:errors class="alert alert-danger" role="alert" path="invDate" />
	        		</div>
	        		<script type="text/javascript">
	        	    	$(function () {
	        	    	    $('#timepicker').datetimepicker({
	        	    	    	pickDate: false
	        	    	    });
	        	   		});
	        		</script>
	    		</div>
			</div>

			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-primary">Send message</button>
					<a class="btn btn-default" href="index">Cancel</a>
				</div>
			</div>
</form:form>

		<!-- Calendar test -->
		<div>
			<c:out value="${calendar.string}" escapeXml="false" />	
		</div>

	</jsp:body>
</base:page>




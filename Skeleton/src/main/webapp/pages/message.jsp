<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="base" tagdir="/WEB-INF/tags" %>


<base:page title="Message">
	<jsp:attribute name="page_header">
		<h1>Message Detail view</h1>
	</jsp:attribute>
		<jsp:body>
			<c:if test="${not empty msg}">
				<div><h4><c:out value="${msg.title}"/></h4></div>
				<div><p><c:out value="${msg.message}"/></p></div>
				<c:choose>
					<c:when test="${msg.invite}">
						<div>
							Add invitation for the <c:out value="${msg.invDate}"/> at
							<c:out value="${msg.invTime}"/> to your calendar?
						</div>
						<div class="form-group">
							<c:if test="${!msg.reacted}">
								<a class="btn btn-primary" href="invite?msgId=${msg.id}&confirm=true">Confirm</a>
			        			<a class="btn btn-warning" href="invite?msgId=${msg.id}&confirm=false">Reject</a>
			        		</c:if>
			        		<a class="btn btn-default" href="messages">Cancel</a>                        
						</div>
					</c:when>
					<c:otherwise>
						<div class="form-group">
		    				<div>
		    		    		<a class="btn btn-primary" href="contact?msgId=${msg.id}">Respond</a>
				        		<a class="btn btn-default" href="messages">Cancel</a>            
				     		</div>
				    	</div>				
					</c:otherwise>
				</c:choose>
			</c:if>
		</jsp:body>
</base:page>

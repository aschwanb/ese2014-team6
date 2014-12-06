<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="base" tagdir="/WEB-INF/tags" %>


<base:page title="Profile">
	<jsp:attribute name="page_header">
		<h1>${user.userName}'s messages</h1>
	</jsp:attribute>

	<jsp:body>
		<c:if test="${not empty msgs}">
			<table class="table table-striped table-hover">
				<tr><th>From</th><th>Title</th><th>Message</th><th>Status</th></tr>
				<c:forEach var="msg" items="${msgs}">
					<tr onclick="document.location='message?id=${msg.id}';">
						<td><a href="message?id=${msg.id}"><c:out value="${msg.fromUser.userName}"/></a></td>
						<td><a href="message?id=${msg.id}"><c:out value="${msg.title}"/></a></td>
						<td><a href="message?id=${msg.id}"><c:out value="${msg.message}"/></a></td>
						<td><a href="message?id=${msg.id}"><c:if test="${msg.hasResponded == true}"><span class="label label-default">Responded</span></c:if><c:if test="${msg.hasRead == false}"><span class="label label-info">NEW</span></c:if></a></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
		<c:if test="${empty msgs}">
			You have no messages
		</c:if>
	</jsp:body>
</base:page>

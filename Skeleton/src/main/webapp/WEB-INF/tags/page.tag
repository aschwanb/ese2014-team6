<%@tag description="Basic Page template" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> --%>
<%-- <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> --%>
<%@taglib prefix="base" tagdir="/WEB-INF/tags" %>

<%@attribute name="title" required="true"%>
<%@attribute name="customHead" fragment="true" %>
<%@attribute name="page_header" fragment="true" %>

<base:page_head title="${title}">
	<jsp:attribute name="customHead">
		<jsp:invoke fragment="customHead"/>
	</jsp:attribute>
	
	<jsp:body>
		<div class="container theme-showcase" role="main">
			<div class="page-header">
				<jsp:invoke fragment="page_header"/>
			</div>
			
			<div class="alert-group" id="alertGroupPageTop">
				<c:if test="${not empty alerts}">
					<c:forEach var="alert" items="${alerts}">
						<div class="alert alert-${alert.type} alert-dismissable">
							<button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
							${alert.message}
						</div>
					</c:forEach>
				</c:if>
			</div>
			
			<jsp:doBody/>
    	</div>
	</jsp:body>
</base:page_head>
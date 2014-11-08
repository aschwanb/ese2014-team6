<%@tag description="Basic Page template" pageEncoding="UTF-8"%>

<%@taglib prefix="base" tagdir="/WEB-INF/tags" %>

<%@attribute name="title" required="true"%>
<%@attribute name="customHead" fragment="true" %>

<base:page_head title="${title}">
	<jsp:attribute name="customHead">
		<jsp:invoke fragment="customHead"/>
	</jsp:attribute>
	
	<jsp:body>
		<div class="container theme-showcase" role="main">
			<jsp:doBody/>
    	</div>
	</jsp:body>
</base:page_head>
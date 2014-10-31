<%@tag description="Basic Page template" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@attribute name="title" required="true"%>
<%@attribute name="customHead" fragment="true" %>

<!DOCTYPE html>
<html lang="en">
	<head>
	    <title>${title}</title>
	    
	    <c:import url="template/head.jsp"/>
	    
	    <jsp:invoke fragment="customHead"/>
	</head>
    <body>
    	<c:import url="template/top.jsp"/>
    	
    	<div class="container theme-showcase" role="main">
			<jsp:doBody/>
    	</div>
    	
		<c:import url="template/bottom.jsp"/>
    </body>
</html>
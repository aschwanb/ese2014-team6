<%@tag description="Basic Page template" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@attribute name="title" required="true"%>

<!DOCTYPE html>
<html lang="en">
	<head>
	    <title>${title}</title>
	    
	    <c:import url="template/htmlHead.jsp"/>
	</head>
    <body>
    	<c:import url="template/header.jsp"/>
    	
    	<div class="container theme-showcase" role="main">
			<jsp:body>
				<jsp:doBody/>
			</jsp:body>
    	</div>
    	
		<c:import url="template/footer.jsp"/>
    </body>
</html>
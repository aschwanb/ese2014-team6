<%@tag description="Page structure" pageEncoding="UTF-8"%>

<%@attribute name="header" fragment="true" required="true" %>

<!DOCTYPE html>
<html lang="en">
	<head>
	    <jsp:invoke fragment="header"/>
	</head>
    <body>
		<jsp:doBody/>
    </body>
</html>
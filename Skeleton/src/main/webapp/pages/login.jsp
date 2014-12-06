<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="base" tagdir="/WEB-INF/tags" %>


<base:page title="Login">
	<jsp:attribute name="page_header">
		<h1>Login</h1>
	</jsp:attribute>
	
	<jsp:body>
		<div id="login-box">
	 		<form class="form-horizontal" name='loginForm' action="<c:url value='/dologin' />" method='POST'>
				<fieldset>
					<div class="row">
						<div class="col-xs-12">
							<div class="col-md-12">
								<div class="form-group">
									<label class="control-label" for="field-userName">User Name</label>
									<div class="form-group">
										<div class="col-md-4">
											<input type="text" class="form-control" name="userName" id="userName" tabindex="1" placeholder="Your User Name">
										</div>
									</div>
								</div>
								
								<div class="form-group">
									<label class="control-label" for="field-password">Password</label>
									<div class="form-group">
										<div class="col-md-4">
											<input type="password" class="form-control" name="password" id="password" tabindex="2" placeholder="Your Password">
										</div>
									</div>
								</div>		
								
								<div class="form-group">
							    	<div class="form-actions">
							      		<button name="submit" type="submit" value="submit" class="btn btn-primary">login</button>
							           	<a class="btn btn-default" href="index">Cancel</a>
							        </div>
							    </div>
						        
							</div>
						</div>
					</div>
		        </fieldset>
			</form>
		</div>
	</jsp:body>
</base:page>

<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="base" tagdir="/WEB-INF/tags"%>


<base:page title="Test">
	<jsp:attribute name="customHead">
	    <link rel="stylesheet" type="text/css" href="css/bootstrap-datetimepicker.min.css">
		<script type="text/javascript" src="js/moment-2.8.4.js"></script>
		<script type="text/javascript" src="js/bootstrap-datetimepicker.min.js"></script>
	</jsp:attribute>

	<jsp:body>
	
	
<div class="container">
    <div class="row">
        <div class='col-sm-5'>
            <div class="form-group">
                <div class='input-group date' id='datetimepicker1'>
                    <input type='text' class="form-control" data-date-format="DD/MM/YYYY HH:mm" />
                    <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span>
                    </span>
                </div>
            </div>
        </div>
        <script type="text/javascript">
            $(function () {
                $('#datetimepicker1').datetimepicker();
            });
        </script>
    </div>
</div>

	</jsp:body>
</base:page>




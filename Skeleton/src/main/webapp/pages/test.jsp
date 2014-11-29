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
	
	<!-- DateTimePicker test -->
		<div class="container">
		    <div class="row">
       			<div class='col-sm-5'>
       			    <div class="form-group">
              			<div class='input-group date' id='datetimepicker1'>
                    		<input type='text' class="form-control" data-date-format="DD/MM/YYYY HH:mm" />
                    		<span class="input-group-addon">
                    			<span class="glyphicon glyphicon-calendar"></span>
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

<div class="container">
	<div class="row">
		<div class="col-sm-4">
			<script>
				$(document)
					.ready(
						function() {
							var monthNames = [ "January", "February", "March", "April", "May",
							                   "June", "July", "August", "September", "October", 
							                   "November", "December"
							                 ];
							var dayNames = [ "M", "T", "W", "T", "F", "S", "S"];
							var events = [
								{
								date : "28/12/2014",
								title : 'SPORT & WELLNESS',
								link : 'http://bic.cat',
								linkTarget : '_blank',
								color : '',
								content : '<img src="http://gettingcontacts.com/upload/jornadas/sport-wellness_portada.png" ><br>06-11-2013 - 09:00 <br> Tecnocampus Mataró Auditori',
								class : '',
								displayMonthController : true,
								displayYearController : true,
								nMonths : 6
							} ];
							$('#calendari_lateral1').bic_calendar({
								//list of events in array
								events : events,
								//enable select
								enableSelect : true,
								//enable multi-select
								multiSelect : false,
								//set day names
								dayNames : dayNames,
								//set month names
								monthNames : monthNames,
								//show dayNames
								showDays : true,
								//show month controller
								displayMonthController : true,
								//show year controller
								displayYearController : true,
								//set ajax call
								reqAjax : {
									type : 'get',
									url : 'http://bic.cat/bic_calendar/index.php'
								}
							});
						});
			</script>
			<div id="calendari_lateral1"></div>
		</div>

	</jsp:body>
</base:page>




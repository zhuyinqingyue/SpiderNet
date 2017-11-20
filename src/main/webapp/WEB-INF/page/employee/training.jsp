<%@ page language="java" import="java.util.*" pageEncoding="utf-8"
	contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
    String path = request.getContextPath();
%>
<!DOCTYPE html>
<html lang="en">
<head>

<meta charset="utf-8">
<title>SpideNet</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description"
	content="Charisma, a fully featured, responsive, HTML5, Bootstrap admin template.">
<meta name="author" content="Muhammad Usman">

<!-- The styles -->
<link href="<%=path%>/css/bootstrap-cerulean.min.css" rel="stylesheet">

<link href="<%=path%>/css/charisma-app.css" rel="stylesheet">
<link
	href='<%=path%>/bower_components/fullcalendar/dist/fullcalendar.css'
	rel='stylesheet'>
<link
	href='<%=path%>/bower_components/fullcalendar/dist/fullcalendar.print.css'
	rel='stylesheet' media='print'>
<link href='<%=path%>/bower_components/chosen/chosen.min.css'
	rel='stylesheet'>
<link href='<%=path%>/bower_components/colorbox/example3/colorbox.css'
	rel='stylesheet'>
<link
	href='<%=path%>/bower_components/responsive-tables/responsive-tables.css'
	rel='stylesheet'>
<link
	href='<%=path%>/bower_components/bootstrap-tour/build/css/bootstrap-tour.min.css'
	rel='stylesheet'>

<link href='<%=path%>/css/jquery.noty.css' rel='stylesheet'>
<link href='<%=path%>/css/noty_theme_default.css' rel='stylesheet'>
<link href='<%=path%>/css/elfinder.min.css' rel='stylesheet'>
<link href='<%=path%>/css/elfinder.theme.css' rel='stylesheet'>
<link href='<%=path%>/css/jquery.iphone.toggle.css' rel='stylesheet'>
<link href='<%=path%>/css/uploadify.css' rel='stylesheet'>
<link href='<%=path%>/css/animate.min.css' rel='stylesheet'>
<link href='<%=path%>/css/bootstrap-datetimepicker.css' rel='stylesheet'>
<link href='<%=path%>/css/bootstrap-datetimepicker.min.css' rel='stylesheet'>
<link
	href='<%=path%>/bower_components/bootstrap-val/bootstrapValidator.css'
	rel='stylesheet'>

<script type="text/javascript">
		var path = "<%=path%>";
</script>
<!-- jQuery -->
<script src="<%=path%>/bower_components/jquery/jquery.min.js"></script>

<!-- The HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

<!-- The fav icon -->
<link rel="shortcut icon" href="<%=path%>/img/favicon.ico">

</head>

<body>
	<!-- topbar starts -->
	<c:import url="/service/manage/top" />
	<!-- topbar ends -->
	<div class="ch-container">
		<div class="row">
			<!-- left menu starts -->
			<c:import url="/service/manage/left" />
			<!-- left menu ends -->
			<div id="content" class="col-lg-10 col-sm-10">
				<!-- content starts -->

				<div class="row">
					<div class="box col-md-12">
						<div class="box-inner">
							<div class="box-header well" data-original-title="">
								<h2>
									<i class="glyphicon glyphicon-book"></i> Trainning
								</h2>
							</div>
							<div class="box-content">

								<form id="trainingForm" method="post" class="form-horizontal"
									style="width: 100%" action="target.php">
									
									<div class="form-group">
									<div class="group">
										<label class="col-sm-4 control-label">Name</label>
										<div class="col-sm-4">
											<input type="text" class="form-control" name="trainningName" id="trainningName" />
										</div>
									</div>
								    </div>
								    
								    <div class="form-group">
									    <div style="text-align:center;width:50%;float:left">
									    <input type="button" value="&nbsp;Search&nbsp;"
										name="subscribe" id="sub_search" href="#"
										class="button btn btn-primary" data-dismiss="modal"
										onclick="loadTrainningList()"
										style="background-color: #D5D5D5; border: 0 none; border-radius: 4px; color: #FFFFFF; cursor: pointer; display: inline-block; font-size: 15px; font-weight: bold; height: 32px; line-height: 32px; margin: 0 5px 10px 0; padding: 0; text-align: center; text-decoration: none; vertical-align: top; white-space: nowrap; width: 100px; margin:auto ;">
									    </div>
									    
									    <div style="text-align:center;width:50%;float:right">
									    <input type="button" value="&nbsp;Add&nbsp;"
										name="subscribe" id="sub_add" href="#"
										class="button btn btn-primary" data-dismiss="modal"
										onclick="addTrainning()"
										style="background-color: #D5D5D5; border: 0 none; border-radius: 4px; color: #FFFFFF; cursor: pointer; display: inline-block; font-size: 15px; font-weight: bold; height: 32px; line-height: 32px; margin: 0 5px 10px 0; padding: 0; text-align: center; text-decoration: none; vertical-align: top; white-space: nowrap; width: 100px; margin:auto ;">
									    </div>
									</div>

									<div>
										<table id="trainningList"
											class="table table-striped table-bordered">
											<thead>
												<tr>
													<!-- <th>编号</th> -->
													<th>Name</th>
													<th>DateTime</th>
													<th>Address</th>
													<th>Trainer</th>
													<!-- <th>操作</th> -->
												</tr>
											</thead>
										</table>
									</div>
									<div>
										<ul class="pagination pagination-centered">
											<li><a href="#" id="fristPage"
												onclick="loadTrainningList('frist')">Home Page</a></li>
											<li><a href="#" id="previousPage"
												onclick="loadTrainningList('previous')">Previous Page</a></li>
											<li><a href="#" id="nextPage"
												onclick="loadTrainningList('next')">Next Page</a></li>
											<li><a href="#" id="lastPage"
												onclick="loadTrainningList('last')">Last Page</a></li>
										</ul>
										<br> Total<span id="pageCount"></span>Pages at<span
											id="currentPage"></span>Page
									</div>
								</form>
								
								
							</div>
						</div>
					</div>
				</div>
				<!--/row-->
			</div>
			<!--/#content.col-md-0-->
		</div>
		<!--/fluid-row-->
		<hr>
		
		
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">


			<div class="modal-dialog">
				<div class="modal-content">
					<div class="box-header well" data-original-title="">
						<h2>
							<i class="glyphicon glyphicon-user"></i> Examination Information
						</h2>

						<div class="box-icon">
							<a href="#" class="btn btn-round btn-default  btn-minimize "><i
								class="glyphicon glyphicon-chevron-up"></i></a> <a
								class="btn btn-round btn-default" href="#" data-dismiss="modal">
								<i class="glyphicon glyphicon-remove"></i>
							</a>
						</div>
					</div>
					
					
					<div id="trainningBox" class="box-content">

						</br>
						
						<div id="successAlert" class="alert alert-success" style="display: none;"></div>
						<div id="failureAlert" class="alert alert-warning" style="display: none;"></div>
						
						<div class="form-group">
							<div class="group">
								<label class="col-sm-2 control-label">Trainning Name</label>
								<div class="col-sm-4">
									<input type="text" class="form-control" name="trainningName2" id="trainningName2"/>
								</div>
							</div>
							<div class="group">
								<label class="col-sm-2 control-label">Tranning Time</label>
								<div class="col-md-4">
									<div class="input-group date form_datetime col-sm-12"
										data-link-field="dt_set_order_time_input">
										<input class="form-control" id="trainningTime" name="trainningTime" type="text" disabled="disabled" 
											> <span class="input-group-addon"><span
											class="glyphicon glyphicon-th"></span></span> <input type="hidden"
											id="trainningTime1" name="trainningTime1" />
									</div>
								</div>
							</div>
						</div>
						
						</br></br>
						<div class="form-group">
							<div class="group">
								<label class="col-sm-2 control-label">Address</label>
								<div class="col-sm-4">
									<input type="text" class="form-control" name="location" id="location"/>
								</div>
							</div>
							<div class="group">
								<label class="col-sm-2 control-label">Trainer</label>
								<div class="col-sm-4">
									<input type="text" class="form-control" name="teacher" id="teacher"/>
								</div>
							</div>
						</div>
						</br></br>
						
						
						<div class="form-group">
							<div class="group">
								<label class="col-sm-2 control-label">URL</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" name="trainningURL" id="trainningURL"/>
								</div>
							</div>
						</div>
						</br></br>
						
						
						<div class="center">
						<label class="radio-inline"> <input type="radio"
							name="skillRadio" id="commonCapability" value="option1"
							 checked="checked">
							Public Skill
						</label> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<label class="radio-inline"> <input type="radio"
							name="skillRadio" id="proCapability" value="option2">
							Private Skill
						</label>
						</div>
						</br>
						
							<div >
								<label class="col-lg-2 control-label">Skills</label>
								<div class="col-lg-4">
									<select href="#" class="form-control " name="skillPoints"
										data-bv-notempty data-bv-notempty-message="Please select skill." id="skillPoints"
										data-bv-group=".group">
										<option value="">-- Please Select --</option></select>
								</div>
							</div>

						</br></br></br>
						<div class="center">
							<a class="btn btn-success" href="#" onClick="saveTrainning()"> 
							<i class="glyphicon glyphicon-ok icon-white" ></i> Confirm</a> 
							<a class="btn btn-info" href="#" data-dismiss="modal"> 
							<i class="glyphicon glyphicon-remove icon-white"></i> Cancel</a>
						</div>
					</div>
				</div>
			</div>
			<!--/span-->
		</div>
		

		<c:import url="/service/manage/footer" />

	</div>
	<!--/.fluid-container-->

	<!-- external javascript -->

	<script
		src="<%=path%>/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
	<script
		src="<%=path%>/bower_components/bootstrap-val/bootstrapValidator.js"></script>
	<!-- library for cookie management -->
	<script src="<%=path%>/js/jquery.cookie.js"></script>
	<!-- calender plugin -->
	<script src='<%=path%>/bower_components/moment/min/moment.min.js'></script>
	<script
		src='<%=path%>/bower_components/fullcalendar/dist/fullcalendar.min.js'></script>
	<!-- data table plugin -->
	<script src='<%=path%>/js/jquery.dataTables.min.js'></script>

	<!-- select or dropdown enhancer -->
	<script src="<%=path%>/bower_components/chosen/chosen.jquery.min.js"></script>
	<!-- plugin for gallery image view -->
	<script
		src="<%=path%>/bower_components/colorbox/jquery.colorbox-min.js"></script>
	<!-- notification plugin -->
	<script src="<%=path%>/js/jquery.noty.js"></script>
	<!-- library for making tables responsive -->
	<script
		src="<%=path%>/bower_components/responsive-tables/responsive-tables.js"></script>
	<!-- tour plugin -->
	<script
		src="<%=path%>/bower_components/bootstrap-tour/build/js/bootstrap-tour.min.js"></script>
	<!-- star rating plugin -->
	<script src="<%=path%>/js/jquery.raty.min.js"></script>
	<!-- for iOS style toggle switch -->
	<script src="<%=path%>/js/jquery.iphone.toggle.js"></script>
	<!-- autogrowing textarea plugin -->
	<script src="<%=path%>/js/jquery.autogrow-textarea.js"></script>
	<!-- multiple file upload plugin -->
	<script src="<%=path%>/js/jquery.uploadify-3.1.min.js"></script>
	<!-- history.js for cross-browser state change on ajax -->
	<script src="<%=path%>/js/jquery.history.js"></script>
	<!-- application script for Charisma demo -->
	<script src="<%=path%>/js/charisma.js"></script>

	<!-- default loading -->
	<script type="text/javascript"
		src="<%=path %>/js/spidernet/queryTrainningList.js"></script>
	<script type="text/javascript" src="<%=path %>/js/bootstrap-datetimepicker.js"></script>
	<script type="text/javascript" src="<%=path %>/js/bootstrap-datetimepicker.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/bootstrap-datetimepicker.zh-CN.js"></script>

</body>
</html>
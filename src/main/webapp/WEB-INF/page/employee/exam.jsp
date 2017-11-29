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
	rel='stylesheet'>

<script type="text/javascript">
		var path = "<%=path%>";
</script>
<!-- jQuery -->
<script src="<%=path%>/bower_components/jquery/jquery.min.js"></script>

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
									<i class="glyphicon glyphicon-pencil"></i> Examination
								</h2>
							</div>
							<div class="box-content">
							
								<form id="examForm" method="post" class="form-horizontal"
									style="width: 100%" action="target.php">
									
									<!-- <div class="form-group">
										<div class="group">
											<label class="col-lg-2 control-label">交付部</label>
											<div class="col-lg-3">
												<select href="#" class="form-control " name="bu"
													data-bv-notempty data-bv-notempty-message="请选择交付部"
													id="bu" data-bv-group=".group"
													onchange="loadProject(this.options[this.options.selectedIndex].value);"
													<option value="">-- 请选择交付部 --</option>
												</select>
											</div>
										</div>
										
										<div class="group">
											<label class="col-lg-3 control-label">项目</label>
											<div class="col-lg-3">
												<select href="#" class="form-control " name="project"
													data-bv-notempty data-bv-notempty-message="请选择项目"
													id="project" data-bv-group=".group"
													<option value="">-- 请选择项目 --</option>
												</select>
											</div>
										</div>
									</div> -->
									
									<div class="form-group">
										<div class="group">
											<label class="col-sm-5 control-label">Examination Name</label>
											<div class="col-sm-3">
												<input type="text" class="form-control" name="examName" id="examName" />
											</div>
										</div>
									</div>
									
									
									<div class="form-group">
									    <div style="text-align:center;width:50%;float:left">
									    <input type="button" value="&nbsp;Search&nbsp;"
										name="subscribe" id="sub_search" href="#"
										class="button btn btn-primary" data-dismiss="modal"
										onclick="loadExamList()"
										style="background-color: #D5D5D5; border: 0 none; border-radius: 4px; color: #FFFFFF; cursor: pointer; display: inline-block; font-size: 15px; font-weight: bold; height: 32px; line-height: 32px; margin: 0 5px 10px 0; padding: 0; text-align: center; text-decoration: none; vertical-align: top; white-space: nowrap; width: 100px; margin:auto ;">
									    </div>
									    
									    <div style="text-align:center;width:50%;float:right">
									    <input type="button" value="&nbsp;Add&nbsp;"
										name="subscribe" id="sub_add" href="#"
										class="button btn btn-primary" data-dismiss="modal"
										onclick="addExam()"
										style="background-color: #D5D5D5; border: 0 none; border-radius: 4px; color: #FFFFFF; cursor: pointer; display: inline-block; font-size: 15px; font-weight: bold; height: 32px; line-height: 32px; margin: 0 5px 10px 0; padding: 0; text-align: center; text-decoration: none; vertical-align: top; white-space: nowrap; width: 100px; margin:auto ;">
									    </div>
									</div>
									
									<div>
									<table id="examList"
										class="table table-striped table-bordered">
										<thead>
											<tr>
												<!-- <th>编号</th> -->
												<th>Name</th>
												<th>Delivery Department</th>
												<th>Project</th>
												<th>Start Time</th>
												<!-- <th>操作</th> -->
											</tr>
										</thead>
									</table>
									</div>
									<div>
										<ul class="pagination pagination-centered">
											<li><a href="#" id="fristPage" onclick="loadExamList('frist')">Home Page</a></li>
											<li><a href="#" id="previousPage" onclick="loadExamList('previous')">Previous Page</a></li>
											<li><a href="#" id="nextPage" onclick="loadExamList('next')">Next Page</a></li>
											<li><a href="#" id="lastPage" onclick="loadExamList('last')">Last Page</a></li>
										</ul>
										<br>
										Total<span id="pageCount"></span>Pages at<span id="currentPage"></span>Page
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
					
					
					<div id="examBox" class="box-content">

						<div id="successAlert" class="alert alert-success" style="display: none;"></div>
						<div id="failureAlert" class="alert alert-warning" style="display: none;"></div>
						
						<form id="examBoxForm" method="post" class="form-horizontal">
						
						
						<!-- <div class="form-group">
							<div class="group">
								<label class="col-lg-2 control-label">交付部</label>
								<div class="col-lg-4">
									<select href="#" class="form-control " name="bu2"
										data-bv-notempty data-bv-notempty-message="请选择交付部" id="bu2"
										data-bv-group=".group"
										onchange="loadProject2(this.options[this.options.selectedIndex].value);">
										<option value="">-- 请选择交付部 --</option></select>
								</div>
							</div>
							<div class="group">
								<label class="col-lg-2 control-label">项目</label>
								<div class="col-lg-4">
									<select href="#" class="form-control " name="project2"
										data-bv-notempty data-bv-notempty-message="请选择项目" id="project2"
										data-bv-group=".group" >
										<option value="">-- 请选择项目 --</option></select>
								</div>
							</div>
						</div>
 -->
						</br></br>
						<div class="form-group">
							<div class="group">
								<label class="col-sm-2 control-label">Name</label>
								<div class="col-sm-4">
									<input type="text" class="form-control" name="examName2" id="examName2"/>
								</div>
							</div>
							<div class="group">
								<label class="col-sm-2 control-label">Description</label>
								<div class="col-sm-4">
									<input type="text" class="form-control" name="description" id="description"/>
								</div>
							</div>
						</div>
						
						</br></br>
						<div class="form-group">
							<div class="group">
								<label class="col-sm-2 control-label">Start Time</label>
								<div class="col-md-4">
									<div class="input-group date form_datetime col-sm-12"
										data-link-field="dt_set_order_time_input">
										<input class="form-control" type="text" disabled="disabled" 
											id="startTime1" name="startTime1"> <span class="input-group-addon"><span
											class="glyphicon glyphicon-th"></span></span> <input type="hidden"
											id="startTime2" name="startTime2" />
									</div>
								</div>
							</div>
							<div class="group">
								<label class="col-sm-2 control-label">End Time</label>
								<div class="col-md-4">
									<div class="input-group date form_datetime col-sm-12"
										data-link-field="dt_set_order_time_input">
										<input class="form-control" type="text" disabled="disabled"
											id="endTime1" name="endTime1"> <span class="input-group-addon"><span
											class="glyphicon glyphicon-th"></span></span> <input type="hidden"
											id="endTime2" name="endTime2" />
									</div>
								</div>
							</div>

						</div>
						</br>
						
						
						<div class="form-group">
							<div class="group">
								<label class="col-sm-2 control-label">Exam Duration</label>
								<div class="col-sm-4">
									<input type="text" class="form-control" name="examTime" id="examTime"/>
								</div>
							</div>
							<!-- <div class="group">
								<label class="col-sm-2 control-label">有效期</label>
								<div class="col-sm-4">
									<input type="text" class="form-control" name="validPeriod" id="validPeriod"/>
								</div>
							</div> -->
						</div>
						</br></br> 
						
						
						
						<div class="center">
						<label class="radio-inline"> <input type="radio"
							name="skillRadio" id="commonCapability" value="option1"
							 checked="checked">
							Public Skills
						</label> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<label class="radio-inline"> <input type="radio"
							name="skillRadio" id="proCapability" value="option2">
							Private Skills
						</label>
						</div>
						</br>
						
							<div >
								<label class="col-lg-2 control-label">Skills</label>
								<div class="col-lg-4">
									<select href="#" class="form-control " name="skillPoints"
										data-bv-notempty data-bv-notempty-message="Please select skills." id="skillPoints"
										data-bv-group=".group">
										<option value="">-- Please Select --</option></select>
								</div>
							</div>
						

						</br></br></br>
						<div class="center">
							<a class="btn btn-success" href="#" onClick="saveExam()"> 
							<i class="glyphicon glyphicon-ok icon-white" ></i> Confirm</a>
							<!-- <input type="submit" value="确&nbsp;&nbsp;定" name="subscribe" id="sub_bt" 
							href="#" class="button btn btn-primary" data-dismiss="modal">  -->
							<a class="btn btn-info" href="#" data-dismiss="modal"> 
							<i class="glyphicon glyphicon-remove icon-white"></i> &nbsp;Cancel&nbsp;</a>
						</div>
						
						</form>
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
		src="<%=path %>/js/spidernet/scoreImport.js"></script>
		
	<!-- default loading -->
	<script type="text/javascript" src="<%=path %>/js/spidernet/queryExamList.js"></script>
	<script type="text/javascript" src="<%=path %>/js/bootstrap-datetimepicker.js"></script>
	<script type="text/javascript" src="<%=path %>/js/bootstrap-datetimepicker.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/bootstrap-datetimepicker.zh-CN.js"></script>
	
		

</body>
</html>
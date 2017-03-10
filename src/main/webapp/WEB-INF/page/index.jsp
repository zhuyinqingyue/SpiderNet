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
<link href="<%=path %>/css/bootstrap-cerulean.min.css" rel="stylesheet">

<link href="<%=path %>/css/charisma-app.css" rel="stylesheet">
<link
	href='<%=path %>/bower_components/fullcalendar/dist/fullcalendar.css'
	rel='stylesheet'>
<link
	href='<%=path %>/bower_components/fullcalendar/dist/fullcalendar.print.css'
	rel='stylesheet' media='print'>
<link href='<%=path %>/bower_components/chosen/chosen.min.css'
	rel='stylesheet'>
<link href='<%=path %>/bower_components/colorbox/example3/colorbox.css'
	rel='stylesheet'>
<link
	href='<%=path %>/bower_components/responsive-tables/responsive-tables.css'
	rel='stylesheet'>
<link
	href='<%=path %>/bower_components/bootstrap-tour/build/css/bootstrap-tour.min.css'
	rel='stylesheet'>
<link
	href='<%=path %>/bower_components/bootstrap-val/bootstrapValidator.css'
	rel='stylesheet'>
<link href='<%=path %>/css/jquery.noty.css' rel='stylesheet'>
<link href='<%=path %>/css/noty_theme_default.css' rel='stylesheet'>
<link href='<%=path %>/css/elfinder.min.css' rel='stylesheet'>
<link href='<%=path %>/css/elfinder.theme.css' rel='stylesheet'>
<link href='<%=path %>/css/jquery.iphone.toggle.css' rel='stylesheet'>
<link href='<%=path %>/css/uploadify.css' rel='stylesheet'>
<link href='<%=path %>/css/animate.min.css' rel='stylesheet'>

<!-- jQuery -->
<script src="<%=path %>/bower_components/jquery/jquery.min.js"></script>

<!-- The HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

<!-- The fav icon -->
<link rel="shortcut icon" href="img/favicon.ico">

</head>
<script>
var path='<%=path%>';
</script>
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
									<i class="glyphicon glyphicon-user"></i> 个人能力地图
								</h2>
							</div>
							<div id="showEmp" class="box-content">
							<input type="hidden" id="empId"  value="${sessionScope.employee.getEmployeeId()}"/>
								<div class="alert alert-info">用户名：${sessionScope.employee.getName()}   职别：${sessionScope.employee.getEmpLevelId()} 种类：${sessionScope.employee.getEmpTypeId()}
									项目名称：${sessionScope.employee.getProjectId()} </div>
								<table id="personalMap"
									class="table table-striped table-bordered bootstrap-datatable datatable responsive">
									<thead>
										<tr>
											<th></th>
											<th>知识库</th>
											<th>培训</th>
											<th>技能鉴定</th>
											<th>状态</th>
										</tr>
									</thead>
									<tbody>


									</tbody>
								</table>
							</div>
						</div>
					</div>
					<!--/span-->

				</div>
				<!--/row-->
				<!-- content ends -->
			</div>
			<!--/#content.col-md-0-->
		</div>

		<hr>

		<!--my cource by ken 2017.2.27-->
		<div class="modal fade" id="myModalClass" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel">
			<div class="modal-dialog modal-lg" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">培训课程</h4>
					</div>
					<div class="modal-body">
						<div class="box">
							<div class="box-inner">

								<div class="box-content">
									<div class="alert alert-success" style="display: none;"></div>
									<table class="table" id="trainningListTable">
										<thead>
											<tr>
												<th></th>
												<th>课程名称</th>
												<th>课程日期</th>
												<th>地点</th>
												<th>培训讲师</th>
												<th>课程资料</th>
												<th>状态</th>
											</tr>
										</thead>
									</table>
									</view>

									</view>
								</div>
							</div>
						</div>
						<!--/span-->
						<div class="row">

							<div style="text-align: right;"
								class="col-md-4 col-md-offset-4 pull-right">
								<button type="button" class="btn btn-primary" id="trainningSubmitBtn">提交</button>
							</div>
						</div>
					</div>
					<!--/row-->
				</div>

			</div>
		</div>

		<!--my exam by ken 2017.2.27-->
		<div class="modal fade" id="myModalExam" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel">
			<div class="modal-dialog modal-lg" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="myModalLabelExam">我的考试</h4>
					</div>
					<div class="modal-body">
						<div class="box">
							<div class="box-inner">

								<div class="box-content">
								<div class="alert alert-success" style="display: none;"></div>
									<table class="table" id="examListTable">
										<thead>
											<tr>
												<th></th>

												<th>交付部门</th>
												<th>项目名称</th>
												<th>考试名称</th>
												<th>开始时间</th>
												<th>结束时间</th>
												<th>考试时间</th>
												<th>有效期限</th>
												<th>状态</th>
											</tr>
										</thead>
									</table>
									</view>

									</view>
								</div>
							</div>
						</div>
						<!--/span-->
						<div class="row">

							<div style="text-align: right;"
								class="col-md-4 col-md-offset-4 pull-right">
								<button type="button" class="btn btn-primary" id="examSubmitBtn">提交</button>
							</div>
						</div>
					</div>
					<!--/row-->
				</div>
				<div class="modal-footer"></div>
			</div>
		</div>

		<c:import url="/service/manage/footer" />

	</div>
	<!--/.fluid-container-->

	<!-- external javascript -->

	<script
		src="<%=path %>/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
	<script
		src="<%=path %>/bower_components/bootstrap-val/bootstrapValidator.min.js"></script>

	<!-- library for cookie management -->
	<script src="<%=path %>/js/jquery.cookie.js"></script>
	<!-- calender plugin -->
	<script src='<%=path %>/bower_components/moment/min/moment.min.js'></script>
	<script
		src='<%=path %>/bower_components/fullcalendar/dist/fullcalendar.min.js'></script>
	<!-- data table plugin -->
	<script src='<%=path %>/js/jquery.dataTables.min.js'></script>

	<!-- select or dropdown enhancer -->
	<script src="<%=path %>/bower_components/chosen/chosen.jquery.min.js"></script>
	<!-- plugin for gallery image view -->
	<script
		src="<%=path %>/bower_components/colorbox/jquery.colorbox-min.js"></script>
	<!-- notification plugin -->
	<script src="<%=path %>/js/jquery.noty.js"></script>
	<!-- library for making tables responsive -->
	<script
		src="<%=path %>/bower_components/responsive-tables/responsive-tables.js"></script>
	<!-- tour plugin -->
	<script
		src="<%=path %>/bower_components/bootstrap-tour/build/js/bootstrap-tour.min.js"></script>
	<!-- star rating plugin -->
	<script src="<%=path %>/js/jquery.raty.min.js"></script>
	<!-- for iOS style toggle switch -->
	<script src="<%=path %>/js/jquery.iphone.toggle.js"></script>
	<!-- autogrowing textarea plugin -->
	<script src="<%=path %>/js/jquery.autogrow-textarea.js"></script>
	<!-- multiple file upload plugin -->
	<script src="<%=path %>/js/jquery.uploadify-3.1.min.js"></script>
	<!-- history.js for cross-browser state change on ajax -->
	<script src="<%=path %>/js/jquery.history.js"></script>
	<!-- application script for Charisma demo -->
	<script src="<%=path %>/js/charisma.js"></script>

	<script type="text/javascript" src="<%=path %>/js/spidernet/personalMap.js"></script>
	<script type="text/javascript" src="<%=path %>/js/load-trainning.js"></script>
	<script type="text/javascript" src="<%=path %>/js/load-exam.js"></script>
</body>
</html>



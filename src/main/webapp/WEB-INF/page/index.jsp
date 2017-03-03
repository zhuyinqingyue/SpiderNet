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
	href='<%=path %>/bower_components/bootstrap-tour/build/<%=path %>/css/bootstrap-tour.min.css'
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

<body>
	<!-- topbar starts -->
	<c:import url="/service/top" />
	<!-- topbar ends -->
	<div class="ch-container">
		<div class="row">
			<!-- left menu starts -->
			<c:import url="/service/left" />
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
							<div class="box-content">
								<div class="alert alert-info">用户名：毛贵锋 职别：高级 种类：开发
									项目名称：Etax Payment</div>
								<table
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
										<tr>
											<td rowspan="3">行业知识</td>
											<td>java</td>
											<td class="center"><a href="#" id="myCourse">我的课程</a></td>
											<td class="center"><a href="#" data-toggle="modal"
												data-target="#myModalExam">我的考试</a></td>
											<td class="center"><span
												class="label-success label label-default">Pass</span></td>


										</tr>
										<tr>
											<td>dojo</td>
											<td class="center">2017/03/21 dojo技能培训</td>
											<td class="center">2017/04/21 dojo考试</td>
											<td class="center"><span
												class="label-success label label-default">Pass</span></td>

										</tr>
										<tr>
											<td>html5</td>
											<td class="center">2017/03/21 dojo技能培训</td>
											<td class="center">2017/04/21 dojo考试</td>
											<td class="center"></td>

										</tr>
										<tr>
											<td rowspan="3">英语国际化</td>
											<td>write email</td>
											<td class="center">2017/03/21 dojo技能培训</td>
											<td class="center">2017/04/21 dojo考试</td>
											<td class="center"><span
												class="label-success label label-default">Pass</span></td>

										</tr>
										<tr>
											<td>chat with english</td>
											<td class="center">2017/03/21 dojo技能培训</td>
											<td class="center">2017/04/21 dojo考试</td>
											<td class="center"><span
												class="label-default label label-danger">Fail</span></td>

										</tr>
										<tr>
											<td>write english document</td>
											<td class="center">2017/03/21 dojo技能培训技能培</td>
											<td class="center">2017/04/21 dojo考试</td>
											<td class="center"><span
												class="label-default label label-danger">Fail</span></td>

										</tr>

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
						<h4 class="modal-title" id="myModalLabel">我的课程</h4>
					</div>
					<div class="modal-body">
						<div class="box">
							<div class="box-inner">

								<div class="box-content">
									<table class="table" id="trainningListTable">
										<thead>
											<tr>
												<th><input type="checkbox" id="selectAll">全选</th>

												<th>课程名称</th>
												<th>课程日期</th>
												<th>地点</th>
												<th>培训讲师</th>
												<th>课程资料</th>
												<th>状态</th>
											</tr>
										</thead>
										<!--                                     <tbody>
                                    <tr>
                                        <td><input type="checkbox"></td>

                                        <td class="center">Java基础</td>
                                        <td class="center">语法;关键字.</td>
                                        <td class="center">2012/02/01</td>
                                        <td class="center">巨安大厦7楼会议室</td>
                                        <td class="center">隔壁老王</td>
                                        <td class="center">www.baidu.com</td>
                                        <td class="center">
                                            <span class="label-success label label-default">Active</span>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td><input type="checkbox"></td>

                                        <td class="center">HTML5</td>
                                        <td class="center">语法;关键字.</td>
                                        <td class="center">2017/02/18</td>
                                        <td class="center">巨安大厦16.2</td>
                                        <td class="center">王尼玛</td>
                                        <td class="center">www.baidu.com</td>
                                        <td class="center">
                                            <span class="label-default label label-danger">Banned</span>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td><input type="checkbox"></td>

                                        <td class="center">JS</td>
                                        <td class="center">语法;关键字..</td>
                                        <td class="center">2017/03/01</td>
                                        <td class="center">巨安大厦12.2</td>
                                        <td class="center">李春梅</td>
                                        <td class="center">www.sohu.com</td>
                                        <td class="center">
                                            <span class="label-default label">Inactive</span>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td><input type="checkbox"></td>

                                    <td class="center">CSS</td>
                                        <td class="center">语法;关键字.</td>
                                    <td class="center">2017/02/28</td>
                                    <td class="center">巨安大厦7层大会议室</td>
                                    <td class="center">贾君鹏</td>
                                    <td class="center">www.sohu.com</td>
                                    <td class="center">
                                        <span class="label-default label">Inactive</span>
                                    </td>
                                    </tr>
                                    </tbody>
 -->
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
								<button type="button" class="btn btn-primary">提交</button>
								<button type="button" class="btn btn-warning" id="resetButton">重置</button>
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
									<table class="table">
										<thead>
											<tr>
												<th><input type="checkbox">全选</th>

												<th>交付部门</th>
												<th>项目名称</th>
												<th>考试名称</th>
												<th>开始时间</th>
												<th>结束时间</th>
												<th>考试时间</th>
												<th>有效期限</th>
												<th>知识列表</th>
												<th>状态</th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td><input type="checkbox"></td>

												<td class="center">部门一</td>
												<td class="center">项目A.</td>
												<td class="center">Agil</td>
												<td class="center">20170203</td>
												<td class="center">20170303</td>
												<td class="center">90</td>
												<td class="center">20170303</td>
												<td class="center">1,2,3</td>
												<td class="center"><span
													class="label-success label label-default">Active</span></td>
											</tr>
											<tr>
												<td><input type="checkbox"></td>

												<td class="center">部门一</td>
												<td class="center">项目A.</td>
												<td class="center">Agil</td>
												<td class="center">20170203</td>
												<td class="center">20170303</td>
												<td class="center">90</td>
												<td class="center">20170303</td>
												<td class="center">1,2,3</td>
												<td class="center"><span
													class="label-success label label-default">Active</span></td>
											</tr>
											<tr>
												<td><input type="checkbox"></td>

												<td class="center">部门一</td>
												<td class="center">项目A.</td>
												<td class="center">Agil</td>
												<td class="center">20170203</td>
												<td class="center">20170303</td>
												<td class="center">90</td>
												<td class="center">20170303</td>
												<td class="center">1,2,3</td>
												<td class="center"><span
													class="label-success label label-default">Active</span></td>
											</tr>
											<tr>
												<td><input type="checkbox"></td>

												<td class="center">部门一</td>
												<td class="center">项目A.</td>
												<td class="center">Agil</td>
												<td class="center">20170203</td>
												<td class="center">20170303</td>
												<td class="center">90</td>
												<td class="center">20170303</td>
												<td class="center">1,2,3</td>
												<td class="center"><span
													class="label-success label label-default">Active</span></td>
											</tr>
										</tbody>
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
								<button type="button" class="btn btn-primary">提交</button>
								<button type="button" class="btn btn-warning">重置</button>
							</div>
						</div>
					</div>
					<!--/row-->
				</div>
				<div class="modal-footer"></div>
			</div>
		</div>

		<c:import url="/service/footer" />

	</div>
	<!--/.fluid-container-->

	<!-- external javascript -->

	<script
		src="<%=path %>/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

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

	<script type="text/javascript" src="<%=path %>/js/load-trainning.js"></script>
</body>
</html>



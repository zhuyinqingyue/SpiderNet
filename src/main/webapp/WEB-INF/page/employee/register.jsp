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


<script type="text/javascript">
		var path = "<%=path%>";
	</script>
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
									<i class="glyphicon glyphicon-edit"></i> 新员工注册
								</h2>


							</div>
							<div class="box-content">


								<form id="paymentForm" method="post" class="form-horizontal"
									style="width: 100%" action="target.php">

									<input type="hidden" name="BU_id" id="BU_id" value="" /> <input
										type="hidden" name="project_id" id="project_id" value="" />

									<div class="alert alert-success" style="display: none;"></div>
									<br />
									<div class="form-group">
										<div class="group">
											<label class="col-sm-2 control-label">ER</label>
											<div class="col-sm-4">
												<input type="text" class="form-control" name="er" id="er" />
											</div>
										</div>
										<div class="group">
											<label class="col-sm-2 control-label">HR</label>
											<div class="col-sm-4">
												<input type="text" class="form-control" name="hr" id="hr" />
											</div>
										</div>
									</div>
									<br />


									<div class="form-group">
										<div class="group">
											<label class="col-sm-2 control-label">中文名</label>
											<div class="col-sm-4">
												<input type="text" class="form-control" name="name"
													id="name" />
											</div>
										</div>
										<div class="group">
											<label class="col-sm-2 control-label">英文名</label>
											<div class="col-sm-4">
												<input type="text" class="form-control" name="eName"
													id="ename" />
											</div>
										</div>
									</div>
									<br />

									<div class="form-group">
										<label class="col-lg-2 control-label">角色</label>
										<div class="col-lg-3">
											<select class="form-control" name="emp_type" data-bv-notempty
												data-bv-notempty-message="请选择角色" id="emp_type">
												<option value="">-- 请选择角色 --</option>
											</select>
										</div>

										<label class="col-lg-3 control-label">级别</label>
										<div class="col-lg-3">
											<select class="form-control" name="emp_level"
												data-bv-notempty data-bv-notempty-message="请选择级别"
												id="emp_level">
												<option value="">-- 请选择级别 --</option>
											</select>
										</div>
									</div>
									<br />

									<div class="form-group">
										

										<label class="col-lg-2 control-label">项目</label>
										<div class="col-lg-3">
											<select href="#" class="form-control " name="projectName"
												data-bv-notempty data-bv-notempty-message="请选择项目"
												id="projectName"
												onchange="ViewCapability(this.options[this.options.selectedIndex].value);">
												<option value="">-- 请选择项目 --</option>
											</select>
										</div>
										
										<div class="group">
											<label class="col-sm-3 control-label">交付部</label>
											<div class="col-sm-4">
												<input type="text" class="form-control" name="firstName"
													id="deliverDepartment" disabled="disabled"/>
											</div>
										</div>
									</div>
									<br /> <input type="submit" value="注&nbsp;&nbsp;册" name="subscribe"
										id="sub_bt" href="#" class="button btn btn-primary" data-dismiss="modal"
										style="background-color: #aaa; border: 0 none; border-radius: 4px; color: #FFFFFF; cursor: pointer; display: inline-block; font-size: 15px; font-weight: bold; height: 32px; line-height: 32px; margin: 0 5px 10px 0; padding: 0; text-align: center; text-decoration: none; vertical-align: top; white-space: nowrap; width: 100px; margin-left: 80%;"
										>
										<br>
										

								</form>


								<script type="text/javascript">
$(document).ready(function() {
    $('#paymentForm').bootstrapValidator({
		message: 'This value is not valid',
        
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
			er: {
				validators: {
                    notEmpty: {
                        message: '请输入ER号'
                    }
                }
            },
            
            hr: {
                validators: {
                    notEmpty: {
                        message: '请输入HR号'
                    }
                }
            },
            
            name: {
                group: '.group',
				validators: {
                    notEmpty: {
                        message: '请输入中文名'
                    }
                }
            },
            eName: {
                group: '.group',
				validators: {
                    notEmpty: {
                        message: '请输入英文名'
                    }
                }
            }
            
        }
    }).on('success.form.bv', function(e) {
            // Prevent submit form
            e.preventDefault();

            var $form     = $(e.target);
                validator = $form.data('bootstrapValidator');
            if(validator){
            	RegCapabilityMap(e.target);
            }
            
        });
});
</script>

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
							<i class="glyphicon glyphicon-user"></i> 能力地图
						</h2>

						<div class="box-icon">
							<a href="#" class="btn btn-minimize btn-round btn-default"><i
								class="glyphicon glyphicon-chevron-up"></i></a> <a href="#"
								class="btn btn-close btn-round btn-default" data-dismiss="modal"><i
								class="glyphicon glyphicon-remove"></i></a>
						</div>
					</div>
					<div id="capabilityMapAll" class="box-content">
						<table id="capabilityMap"
							class="table table-striped table-bordered responsive">
							<thead>
								<tr>
									<th style="width: 20%;">领域</th>
									<th>区块</th>
								</tr>
							</thead>
							<tbody>
							</tbody>
						</table>
						<div class="center">
							<a class="btn btn-success" href="#" data-dismiss="modal"> <i
								class="glyphicon glyphicon-ok icon-white"></i> 确定
							</a> <a class="btn btn-info" href="#" data-dismiss="modal"> <i
								class="glyphicon glyphicon-remove icon-white"></i> 取消
							</a>
						</div>
					</div>
				</div>
			</div>
			<!--/span-->
		</div>
	<!--/#content.col-md-0-->

	



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

	<!-- default loading -->
	<script type="text/javascript" src="<%=path %>/js/register.js"></script>
	<script src="<%=path %>/js/spidernet/capabilityMap.js"></script>

</body>
</html>
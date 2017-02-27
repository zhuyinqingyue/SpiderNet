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
    <meta name="description" content="Charisma, a fully featured, responsive, HTML5, Bootstrap admin template.">
    <meta name="author" content="Muhammad Usman">

    <!-- The styles -->
    <link  href="<%=path %>/css/bootstrap-cerulean.min.css" rel="stylesheet">

    <link href="<%=path %>/css/charisma-app.css" rel="stylesheet">
    <link href='<%=path %>/bower_components/fullcalendar/dist/fullcalendar.css' rel='stylesheet'>
    <link href='<%=path %>/bower_components/fullcalendar/dist/fullcalendar.print.css' rel='stylesheet' media='print'>
    <link href='<%=path %>/bower_components/chosen/chosen.min.css' rel='stylesheet'>
    <link href='<%=path %>/bower_components/colorbox/example3/colorbox.css' rel='stylesheet'>
    <link href='<%=path %>/bower_components/responsive-tables/responsive-tables.css' rel='stylesheet'>
    <link href='<%=path %>/bower_components/bootstrap-tour/build/<%=path %>/css/bootstrap-tour.min.css' rel='stylesheet'>
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
   <c:import url="/service/top"/>
    <!-- topbar ends -->
<div class="ch-container">
    <div class="row">
        
        <!-- left menu starts -->
       <c:import url="/service/left"/>
        <!-- left menu ends -->


        <div id="content" class="col-lg-10 col-sm-10">
           <div class="ch-container">
    <div class="row">
        

        <noscript>
            <div class="alert alert-block col-md-12">
                <h4 class="alert-heading">Warning!</h4>

                <p>You need to have <a href="http://en.wikipedia.org/wiki/JavaScript" target="_blank">JavaScript</a>
                    enabled to use this site.</p>
            </div>
        </noscript>

        <div id="content" class="col-lg-10 col-sm-10">
            <!-- content starts -->
   

<div class="row">
    <div class="box col-md-12">
        <div class="box-inner">
            <div class="box-header well" data-original-title="">
                <h2><i class="glyphicon glyphicon-edit"></i> 新员工注册</h2>

                <div class="box-icon">
                    <a href="#" class="btn btn-setting btn-round btn-default"><i
                            class="glyphicon glyphicon-cog"></i></a>
                    <a href="#" class="btn btn-minimize btn-round btn-default"><i
                            class="glyphicon glyphicon-chevron-up"></i></a>
                    <a href="#" class="btn btn-close btn-round btn-default"><i
                            class="glyphicon glyphicon-remove"></i></a>
                </div>
            </div>
			
			

            <div class="box-content">
			<form action="" method="post">
			
			    <input type="hidden" name="BU_id" id="BU_id" value="" /> 
			    
			    <input type="hidden" name="project_id" id="project_id" value="" />
			    
			    
			    <div class="form-group has-success col-md-4">
                    <label class="control-label" for="inputSuccess1">ER</label>
                    <input type="text" class="form-control" id="er">
                </div>
				&nbsp&nbsp&nbsp&nbsp
				
				<div class="form-group has-success col-md-4">
                    <label class="control-label" for="inputSuccess1">HR</label>
                    <input type="text" class="form-control" id="hr">
                </div>
				<br><br><br><br>
				
				<div class="form-group has-success col-md-4">
                    <label class="control-label" for="inputSuccess1">中文名</label>
                    <input type="text" class="form-control" id="name">
                </div>
				&nbsp&nbsp&nbsp&nbsp
				
				<div class="form-group has-success col-md-4">
                    <label class="control-label" for="inputSuccess1">英文名</label>
                    <input type="text" class="form-control" id="ename">
                </div>
				<br><br><br><br>
				
				 <div class="form-group has-success col-md-4">
                    <label class="control-label" for="inputSuccess1">交付部</label>
                    <input type="text" class="form-control" id="deliverdepartment">
                </div>
				<br><br><br><br>
                <div class="control-group" style="float:left">
                    <label class="control-label" for="selectError">类型</label>

                    <div class="controls">
                        <select id="type" data-rel="chosen">
                            <option>Option 1</option>
                            <option>Option 2</option>
                            <option>Option 3</option>
                            <option>Option 4</option>
                            <option>Option 5</option>
                        </select>
                    </div>
                </div>
				
				
				<div class="control-group">
                    <label class="control-label" for="selectError">级别</label>

                    <div class="controls">
                        <select id="level" data-rel="chosen">
                            <option>Option 1</option>
                            <option>Option 2</option>
                            <option>Option 3</option>
                            <option>Option 4</option>
                            <option>Option 5</option>
                        </select>
                    </div>
                </div>
               

               <br><br>
          
               
				
				 <div class="form-group has-success col-md-4">
                    <label class="control-label" for="inputSuccess1">项目</label>
                    <a href="#" class="btn btn-setting btn-default">展示</a>
                </div>
				
				<br><br><br><br>
				
				<button type="submit" class="btn btn-default">提交</button>
            
             </form>  
            </div>
        </div>
    </div>
    <!--/span-->

</div><!--/row-->


    </div><!--/#content.col-md-0-->
</div><!--/fluid-row-->





</div><!--/.fluid-container-->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
         aria-hidden="true">


        <div class="modal-dialog">
            <div class="modal-content">
                <div class="box-header well" data-original-title="">
                    <h2><i class="glyphicon glyphicon-user"></i> 能力地图</h2>

                    <div class="box-icon">
                        <a href="#" class="btn btn-minimize btn-round btn-default" ><i
                                class="glyphicon glyphicon-chevron-up" ></i></a>
                        <a href="#" class="btn btn-close btn-round btn-default" data-dismiss="modal"><i
                                class="glyphicon glyphicon-remove"></i></a>
                    </div>
                </div>
                <div class="box-content">
                    <table class="table table-striped table-bordered responsive">
                        <thead>
                        <tr>
                            <th>领域</th>
                            <th>区块</th>
                        </tr>
                        </thead>
                        <tbody>


                        <tr>
                            <td>Muhammad Usman</td>

                            <td class="center">
								<label>
									<input type="checkbox" value="">
									Option one is this and that
								</label>
													<label>
									<input type="checkbox" value="">
									Option one is this and that&mdash;be sure to include why it's great
								</label>
													<label>
									<input type="checkbox" value="">
									be sure to include why it's great
								</label>
													<label>
									<input type="checkbox" value="">
									Option&mdash;be sure to include why it's great
								</label>
                            </td>
                        </tr>
                        <tr>
                            <td>Abraham</td>

                            <td class="center">
                                													<label>
									<input type="checkbox" value="">
									Option one is this and that&mdash;be sure to include why it's great
								</label>
													<label>
									<input type="checkbox" value="">
									Option one is this and that&mdash;be sure to include why it's great
								</label>
                            </td>
                        </tr>
                        <tr>
                            <td>Brown Blue</td>

                            <td class="center">
                                													<label>
									<input type="checkbox" value="">
									Option one is this and that&mdash;be sure to include why it's great
								</label>
													<label>
									<input type="checkbox" value="">
									Option one is this and that&mdash;be sure to include why it's great
								</label>
                            </td>
                        </tr>
                        <tr>
                            <td>Worth Name</td>

                            <td class="center">
                                													<label>
									<input type="checkbox" value="">
									Option one is this and that&mdash;be sure to include why it's great
								</label>
													<label>
									<input type="checkbox" value="">
									Option one is this and that&mdash;be sure to include why it's great
								</label>
                            </td>
                        </tr>
                        </tbody>
                    </table>
					<div class="center">
						<a class="btn btn-success" href="#">
							<i class="glyphicon glyphicon-ok icon-white"></i>
							保存
						</a>
						<a class="btn btn-info" href="#" data-dismiss="modal">
							<i class="glyphicon glyphicon-remove icon-white"></i>
							取消
						</a>
						<a class="btn btn-danger" href="#">
							<i class="glyphicon glyphicon-repeat icon-white"></i>
							重置
						</a>
					</div>
                </div>
			</div>
        </div>
        <!--/span-->
    </div>  
		</div><!--/#content.col-md-0-->
	</div>

    <hr>

    

   <c:import url="/service/footer"/>

</div><!--/.fluid-container-->

<!-- external javascript -->

<script src="<%=path %>/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

<!-- library for cookie management -->
<script src="<%=path %>/js/jquery.cookie.js"></script>
<!-- calender plugin -->
<script src='<%=path %>/bower_components/moment/min/moment.min.js'></script>
<script src='<%=path %>/bower_components/fullcalendar/dist/fullcalendar.min.js'></script>
<!-- data table plugin -->
<script src='<%=path %>/js/jquery.dataTables.min.js'></script>

<!-- select or dropdown enhancer -->
<script src="<%=path %>/bower_components/chosen/chosen.jquery.min.js"></script>
<!-- plugin for gallery image view -->
<script src="<%=path %>/bower_components/colorbox/jquery.colorbox-min.js"></script>
<!-- notification plugin -->
<script src="<%=path %>/js/jquery.noty.js"></script>
<!-- library for making tables responsive -->
<script src="<%=path %>/bower_components/responsive-tables/responsive-tables.js"></script>
<!-- tour plugin -->
<script src="<%=path %>/bower_components/bootstrap-tour/build/js/bootstrap-tour.min.js"></script>
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


</body>
</html>



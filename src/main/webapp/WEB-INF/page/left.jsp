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
</head>

<body>
        <!-- left menu starts -->
        <div class="col-sm-2 col-lg-2">
            <div class="sidebar-nav">
                <div class="nav-canvas">
                    <div class="nav-sm nav nav-stacked">
                    </div>
                    <ul class="nav nav-pills nav-stacked main-menu">
                        <li class="nav-header">功能模块</li>
                        <li><a class="ajax-link" href="<%=path %>/service/employee/index.html"><i class="glyphicon glyphicon-home"></i><span>&nbsp;&nbsp;&nbsp;&nbsp;个人主页</span></a>
                        </li>
                        <c:if test="${sessionScope.employee.empTypeId eq 'a6b8fd9eb5e547da907c7a004810d022'}">
                        <li><a class="ajax-link" href="<%=path %>/service/employee/register.html"><i class="glyphicon glyphicon-user"></i><span>&nbsp;&nbsp;&nbsp;&nbsp;新员工注册</span></a>
                        </li>
                        </c:if>
                        
                    </ul>
                </div>
            </div>
        </div>
</body>
</html>





$(function(){

	loadEmpList();
	
	loadBu();
	
	loadProject();
	
	
});



function loadEmpList(pageState){
	
	var buId = $("#bu").val();

	var projectId = $("#project").val();

	var er = $("#er").val();

	var pageState = pageState;
	
	$.ajax({
		url:path+"/service/employeeInfo/employeeInfoList",
		dataType:"json",
		async:true,
		data:{"buId":buId,"projectId":projectId,"er":er,"pageState":pageState},
		cache:false,
		type:"post",
		success:function(result){
			$("#EmployeeList tbody").remove();
			
			var tbody = $("<tbody>");
			tbody.appendTo($("#EmployeeList"));
			
			for (var i = 0; i < result.data.length; i++) {
				var tr = $("<tr></tr>");
				tr.appendTo(tbody);

				var td1 = $("<td id='tx1'>"
						+ result.data[i].er
						+ "</td>");

				var td2 = $("<td>"
						+ result.data[i].hr
						+ "</td>");
				var td3 = $("<td>"
						+ result.data[i].name
						+ "</td>");
				var td4 = $("<td>"
						+ result.data[i].eName
						+ "</td>");
				var td5 = $("<td>"
						+ result.data[i].buName
						+ "</td>");
				var td6 = $("<td>"
						+ result.data[i].projectName
						+ "</td>");
				var td7 = $("<td><a class='btn btn-info' href='javascript:void(0);'  onclick=getEr('"+result.data[i].er+"')> <i class='glyphicon glyphicon-edit icon-white'></i> Edit</a></td>");
				//var td7 = $("<td><a href='javascript:void(0);'  onclick=getEr('"+result.data[i].er+"')>Edit</a></td>");
				td1.appendTo(tr);
				td2.appendTo(tr);
				td3.appendTo(tr);
				td4.appendTo(tr);
				td5.appendTo(tr);
				td6.appendTo(tr);
				td7.appendTo(tr);
			}
			$("#EmployeeList").append("</tbdoy>");
			//alert(window.location.href);
			var pageNum = parseInt(result.pageInfo.currentPage);
			pageNum = pageNum / 10 + 1;
			var totalPage = parseInt(result.pageInfo.pageCount);
			$("#pageCount").html(totalPage);
			$("#currentPage").html(pageNum);
			$("#nextPage").attr("onclick","loadEmpList('next')");
			$("#previousPage").attr("onclick","loadEmpList('previous')");
			if(pageNum == totalPage){
				$("#nextPage").removeAttr("onclick");
			}
			if(pageNum == 1){
				$("#previousPage").removeAttr("onclick");
			}
		}
	})
}

function getEr(er){
	$("#editForm").attr("action",path+"/service/employee/update.html");
	$("#erNum").val(er);
	$("#editForm").submit();
}

function loadProject(buId,projectId){
	var buId = buId;
	$.ajax({
		url:path+'/service/project/queryAll',
		dataType:"json",
		async:true,
		data:{"buId":buId},
		cache:false,
		type:"post",
		success:function(listP){
			
			$("#project").find("option").remove(); 
			$("#project").append("<option value=''>-- 请选择项目 --</option>");
			for(var i = 0;i<listP.length;i++){
				$("#project").append("<option value='"+listP[i].projectId+"'>"+listP[i].projectName+"</option>");
			}
			if(projectId!=null){
				$("#project").val(projectId);
			}
		}
	})
}

 
function loadBu(){
	
	$.ajax({
		url:path+'/service/bu/queryBu',
		dataType:"json",
		async:true,
		cache:false,
		type:"post",
		success:function(listB){
			$("#bu").append("<option value=''>-- 请选择交付部 --</option>");
			for(var i = 0;i<listB.length;i++){
				$("#bu").append("<option value='"+listB[i].buId+"'>"+listB[i].buName+"</option>");
			}
		}
	})
}
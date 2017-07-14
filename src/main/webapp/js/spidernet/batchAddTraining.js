var empArray = new Array();

$(function(){
	loadEmpList();
	
	loadBu();
	
	loadProject();
	
	loadTrainingName();
	
});

function checkPrivilege(){
	
	var privilegeState = $("#privilegeState").val();
	
	var buId = $("#buId").val();
	
	if(privilegeState=='false'){
		//$("#bu option[value='']").removeAttr("selected");
		//$("#bu option[value='"+buId+"']").attr("select","selected");
		$("#bu").val(buId);
		$("#bu").attr("disabled","disabled");
	}
	
}


function loadTrainingName(){
	$.ajax({
		url:path+'/service/trainning/queryTrainingName',
		dataType:"json",
		async:true,
		cache:false,
		type:"post",
		success:function(trainingList){
			$("#TrainingName").append("<option>--请选择培训名称--</option>");
			for(var i = 0;i<trainingList.length;i++){
				$("#TrainingName").append("<option>"+trainingList[i].courseName+"</option>");
			}
			$('#TrainingName').selectpicker({
		        'selectedText': 'cat'
		    });
		}
	})
}
$("#TrainingName").change(function(){
	var trainingName = $('#TrainingName').val();
	$.ajax({
		url:path+'/service/trainning/queryTrainingByName',
		dataType:"json",
		async:true,
		data:{"trainingName":trainingName},
		cache:false,
		type:"post",
		success:function(trainingList){
			$("#TrainingDate").find("option").remove(); 
			$("#TrainingDate").append("<option value=''>-- 请选择培训时间 --</option>");
			for(var i = 0;i<trainingList.length;i++){
				$("#TrainingDate").append("<option value='"+trainingList[i].trainningId+"'>"+trainingList[i].time+"</option>");
			}
		}
	})
})

function addEmployee(){
	var er = "";
	for(var i=0; i<10; i++){
		er = $("#td"+i+"").text();
		
		if($("#checkbox"+i+"").is(':checked') && $.inArray(er, empArray) == -1){
			empArray.push(er);
		}
		
		if(!$("#checkbox"+i+"").is(':checked') && $.inArray(er, empArray) != -1){
			empArray.splice(jQuery.inArray(er,empArray),1); 
		}
	}
}


function showSelected(){
	var er = "";
	for(var i=0; i<10; i++){
		er = $("#td"+i+"").text();
		
		if($.inArray(er, empArray) != -1){
			
			$("#checkbox"+i+"").attr("checked",'true');
		}
	}
}


function batchAddTraining(){
	addEmployee();
	
	var trainingId = $('#TrainingDate').val();
	
	$.ajax({
		url:path+'/service/trainning/batchAddTraining',
		data: {'trainingId':trainingId,'empArray':empArray},
		async:true,
		cache:false,
		traditional: true,
		type:"post",
		success:function(){
			 location.reload(); 
		}
	})
}


function loadEmpList(pageState){
	
	addEmployee();
	
	var buId = $("#bu").val();

	var projectId = $("#project").val();

	var pageState = pageState;
	
	$.ajax({
		url:path+"/service/employeeInfo/employeeInfoList",
		dataType:"json",
		async:true,
		data:{"buId":buId,"projectId":projectId,"pageState":pageState},
		cache:false,
		type:"post",
		success:function(result){
			$("#EmployeeList tbody").remove();
			
			var tbody = $("<tbody>");
			tbody.appendTo($("#EmployeeList"));
			
			for (var i = 0; i < result.data.length; i++) {
				var tr = $("<tr></tr>");
				tr.appendTo(tbody);

				var td1 = $("<td><input type='checkbox' id='checkbox"+i+"'></td>");
				
				var td2 = $("<td id='td"+i+"'>"
						+ result.data[i].er
						+ "</td>");

				var td3 = $("<td>"
						+ result.data[i].hr
						+ "</td>");
				var td4 = $("<td>"
						+ result.data[i].name
						+ "</td>");
				var td5 = $("<td>"
						+ result.data[i].eName
						+ "</td>");
				var td6 = $("<td>"
						+ result.data[i].buName
						+ "</td>");
				var td7 = $("<td>"
						+ result.data[i].projectName
						+ "</td>");
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
			
			showSelected();
		}
	})
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
			checkPrivilege();
			
			loadEmpList();
		}
	})
}
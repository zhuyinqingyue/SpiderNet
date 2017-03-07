$(function(){
	
	loadlevel();
	
	loadtype();
	
	loadempinfo();
	
	//loadProject();
	
	loadDepartmentName();
	
});



function loadlevel(){
	$.ajax({
		url:path+"/service/level/queryAll",
		dataType:"json",
		async:true,
		//data:"",
		cache:false,
		type:"post",
		success:function(listL){
			for(var i = 0;i<listL.length;i++){
				$("#emp_level").append("<option value='"+listL[i].empLevelId+"'>"+listL[i].levelName+"</option>");
			}
		}
	})
}

function loadtype(){
	$.ajax({
		url:path+'/service/type/queryAll',
		dataType:"json",
		async:true,
		//data:"",
		cache:false,
		type:"post",
		success:function(listT){
			for(var i = 0;i<listT.length;i++){
				$("#emp_type").append("<option value='"+listT[i].empTypeId+"'>"+listT[i].typeName+"</option>");
			}
		}
	})
}


function loadempinfo(){
	$.ajax({
		url:path+'/service/employee/queryEmpInfo',
		dataType:"json",
		async:true,
		//data:"",
		cache:false,
		type:"post",
		success:function(employee){
			$("#BU_id").val(employee.buId);
			//$("#project_id").val(employee.projectId);
			loadProject();
		}
	})
}

function loadProject(){
	var buId = $("#BU_id").val();
	$.ajax({
		url:path+'/service/project/queryAll',
		dataType:"json",
		async:true,
		data:{buId},
		cache:false,
		type:"post",
		success:function(listP){
			for(var i = 0;i<listP.length;i++){
				$("#projectName").append("<option value='"+listP[i].projectId+"'>"+listP[i].projectName+"</option>");
			}
		}
	})
}

function loadDepartmentName(){
	$.ajax({
		url:path+'/service/bu/queryBuName',
		dataType:"json",
		async:true,
		cache:false,
		type:"post",
		success:function(bu){
			$("#deliverDepartment").val(bu.buName);
		}
	})
}


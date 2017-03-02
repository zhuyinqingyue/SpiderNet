$(function(){
	
	loadlevel();
	
	loadtype();
	
	loadempinfo();
	
});


function loadlevel(){
		
	$.ajax({
		url:'http://localhost:8085/SpiderNet/service/level/queryAll',
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
	alert("111");
	$.ajax({
		url:'http://localhost:8085/SpiderNet/service/type/queryAll',
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
	
	alert("222");
	
	$.ajax({
		url:'http://localhost:8085/SpiderNet/service/employee/queryEmpInfo',
		dataType:"json",
		async:true,
		//data:"",
		cache:false,
		type:"post",
		success:function(employee){
			$("#BU_id").val(employee.buId);
			$("#project_id").val(employee.projectId);
		}
		
	})
	
}
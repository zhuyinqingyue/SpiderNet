
var buMultiselect;

$('#commonCapability').click(function(){
	$("#proCapabilityDiv").hide();
	$("#commonCapabilityDiv").show();
})

$('#proCapability').click(function(){
	$("#commonCapabilityDiv").hide();
	$("#proCapabilityDiv").show();
})

$(function(){
	loadCommonCapabilityList();
	
	loadProCapabilityList();
	
	loadBlock();
	
	loadBu();
	
	loadLevel();
	
	loadType();
	
	loadProject();
	
	loadProProject2();
	
	multipleSelect();
});


function multipleSelect(){
	$.ajax({
		url:path+'/service/bu/queryBu',
		dataType:"json",
		async:true,
		cache:false,
		type:"post",
		success:function(listB){
			buMultiselect = listB;
			for(var i = 0;i<listB.length;i++){
				$("#buList").append("<option value='"+listB[i].buId+"'>"+listB[i].buName+"</option>");
			}
			$('.selectpicker').selectpicker({
		        'selectedText': 'cat'
		    });
		}
	})
}


function mosaicBuId(){
	var buNameList = $("span.filter-option").text();
	var buNameArray = new Array();  
	var buIdList = "";
	buNameArray = buNameList.split(',');
	for (var i = 0; i < buNameArray.length; i++) {
		for (var j = 0; j < buMultiselect.length; j++) {
			if($.trim(buNameArray[i]) == buMultiselect[j].buName){
				buIdList += buMultiselect[j].buId;
				break;
			}
		}
		if(i < buNameArray.length - 1){
			buIdList += ",";
		}
	}
	
	
	return buIdList;
}


function loadCommonCapabilityList(pageState){
	var cBlock = $("#cBlock").val();
	
	var cCapabilityName = $("#cCapabilityName").val();
	$.ajax({
		url:path+"/service/cCapabilityInfo/cCapabilityInfoList",
		dataType:"json",
		async:true,
		data:{"cBlock":cBlock,"cCapabilityName":cCapabilityName,"pageState":pageState},
		cache:false,
		type:"post",
		success:function(result){
			$("#commonCapabilityList tbody").remove();
			
			var tbody = $("<tbody>");
			tbody.appendTo($("#commonCapabilityList"));
			
			for (var i = 0; i < result.data.length; i++) {
				var tr = $("<tr></tr>");
				tr.appendTo(tbody);

				/*var td1 = $("<td>"
						+ result.data[i].commonCapabilityId
						+ "</td>");*/
				var td2 = $("<td>"
						+ result.data[i].blockName
						+ "</td>");
				var td3 = $("<td>"
						+ result.data[i].commonCapabilityName
						+ "</td>");
				//var td4 = $("<td><a class='btn btn-info' href='javascript:void(0);'> <i class='glyphicon glyphicon-edit icon-white'></i> Edit</a></td>");
				/*td1.appendTo(tr);*/
				td2.appendTo(tr);
				td3.appendTo(tr);
				//td4.appendTo(tr);
				
			}
			$("#commonCapabilityList").append("</tbdoy>");
			//alert(window.location.href);
			var pageNum = parseInt(result.pageInfo.currentPage);
			pageNum = pageNum / 10 + 1;
			var totalPage = parseInt(result.pageInfo.pageCount);
			$("#cPageCount").html(totalPage);
			$("#cCurrentPage").html(pageNum);
			$("#cNextPage").attr("onclick","loadCommonCapabilityList('next')");
			$("#cPreviousPage").attr("onclick","loadCommonCapabilityList('previous')");
			if(pageNum == totalPage){
				$("#cNextPage").removeAttr("onclick");
			}
			if(pageNum == 1){
				$("#cPreviousPage").removeAttr("onclick");
			}
		}
	})
}

function addCommonCapability(){
	$('#myModalC').modal('show');
}

function loadProCapabilityList(pageState){
	var buId = $("#pBu").val();
	var projectId = $("#pProject").val();
	var typeId = $("#pType").val();
	var levelId = $("#pLevel").val();
	var blockId = $("#pBlock").val();
	var proCapabilityName = $("#pCapabilityName").val();
	$.ajax({
		url:path+"/service/proCapabilityInfo/proCapabilityInfoList",
		dataType:"json",
		async:true,
		data:{"buId":buId,"projectId":projectId,"typeId":typeId,"levelId":levelId,"blockId":blockId,"proCapabilityName":proCapabilityName,"pageState":pageState},
		cache:false,
		type:"post",
		success:function(result){
			$("#proCapabilityList tbody").remove();
			
			var tbody = $("<tbody>");
			tbody.appendTo($("#proCapabilityList"));
			
			for (var i = 0; i < result.data.length; i++) {
				var tr = $("<tr></tr>");
				tr.appendTo(tbody);

				/*var td1 = $("<td>"
						+ result.data[i].proCapabilityId
						+ "</td>");*/
				var td2 = $("<td>"
						+ result.data[i].proCapabilityName
						+ "</td>");
				var td3 = $("<td>"
						+ result.data[i].blockName
						+ "</td>");
				var td4 = $("<td>"
						+ result.data[i].buName
						+ "</td>");
				var td5 = $("<td>"
						+ result.data[i].projectName
						+ "</td>");
				var td6 = $("<td>"
						+ result.data[i].typeName
						+ "</td>");
				var td7 = $("<td>"
						+ result.data[i].levelName
						+ "</td>");
				//var td8 = $("<td><a class='btn btn-info' href='javascript:void(0);'> <i class='glyphicon glyphicon-edit icon-white'></i> Edit</a></td>");
				/*td1.appendTo(tr);*/
				td2.appendTo(tr);
				td3.appendTo(tr);
				td4.appendTo(tr);
				td5.appendTo(tr);
				td6.appendTo(tr);
				td7.appendTo(tr);
				//td8.appendTo(tr);
			}
			$("#proCapabilityList").append("</tbdoy>");
			//alert(window.location.href);
			var pageNum = parseInt(result.pageInfo.currentPage);
			pageNum = pageNum / 10 + 1;
			var totalPage = parseInt(result.pageInfo.pageCount);
			$("#pPageCount").html(totalPage);
			$("#pCurrentPage").html(pageNum);
			$("#pNextPage").attr("onclick","loadProCapabilityList('next')");
			$("#pPreviousPage").attr("onclick","loadProCapabilityList('previous')");
			if(pageNum == totalPage){
				$("#pNextPage").removeAttr("onclick");
			}
			if(pageNum == 1){
				$("#pPreviousPage").removeAttr("onclick");
			}
		}
	})
}


function loadParentCapability(blockId){
	var blockId = blockId;
	$.ajax({
		url:path+"/service/commonCapability/queryParentCapability",
		dataType:"json",
		async:true,
		data:{"blockId":blockId},
		cache:false,
		type:"post",
		success:function(cCapabilityListB){
			$("#parentCapability").find("option").remove();
			$("#parentCapability").append("<option value=''>-- 请选择前置技能 --</option>");
			for(var i = 0;i<cCapabilityListB.length;i++){
				$("#parentCapability").append("<option value='"+cCapabilityListB[i].commCapabilityId+"'>"+cCapabilityListB[i].name+"</option>");
			}
		}
	})
}


function addProCapability(){
	$('#myModalP').modal('show');
}


function savePCapability(){
	var pCapabilityName2 = $("#pCapabilityName2").val();
	var pDescribe = $("#pDescribe").val();
	var pBu2 = $("#pBu2").val();
	var pProject2 = $("#pProject2").val();
	var pType2 = $("#pType2").val();
	var pLevel2 = $("#pLevel2").val();
	var pBlock2 = $("#pBlock2").val();
	var pCapabilityURL = $("#pCapabilityURL").val();
	$.ajax({
		url:path+'/service/proCapability/addProCapability',
		dataType:"json",
		async:true,
		data:{"pCapabilityName2":pCapabilityName2,"pDescribe":pDescribe,"pBu2":pBu2,"pProject2":pProject2,"pType2":pType2,"pLevel2":pLevel2,"pBlock2":pBlock2,"pCapabilityURL":pCapabilityURL},
		cache:false,
		type:"post",
		success:function(resultFlag){
			if(resultFlag){
				$("#successAlert1").html('添加成功').show();
				setTimeout(function () {
					$("#successAlert1").hide();
					$('#myModalP').modal('hide');
					$("#pCapabilityName2").val("");
					$("#pDescribe").val("");
					$("#pBu2").val("");
					$("#pProject2").val("");
					$("#pType2").val("");
					$("#pLevel2").val("");
					$("#pBlock2").val("");
					$("#pCapabilityURL").val("");
			    }, 2000);
			}else{
				$("#failureAlert1").html('添加失败').show();
			}
		}
	})
}


function saveCCapability(){
	var cCapabilityName2 = $("#cCapabilityName2").val();
	var cDescribe = $("#cDescribe").val();
	var cBlock2 = $("#cBlock2").val();
	var parentCapability = $("#parentCapability").val();
	var buList = mosaicBuId();
	var cCapabilityURL = $("#cCapabilityURL").val();
	$.ajax({
		url:path+'/service/commonCapability/addCCapability',
		dataType:"json",
		async:true,
		data:{"cCapabilityName2":cCapabilityName2,"cDescribe":cDescribe,"cBlock2":cBlock2,"parentCapability":parentCapability,"buList":buList,"cCapabilityURL":cCapabilityURL},
		cache:false,
		type:"post",
		success:function(resultFlag){
			if(resultFlag){
				$("#successAlert2").html('添加成功').show();
				setTimeout(function () {
					$("#successAlert2").hide();
					$('#myModalC').modal('hide');
					$("#cCapabilityName2").val("");
					$("#cDescribe").val("");
					$("#cBlock2").val("");
					$("#parentCapability").val("");
					$("span.filter-option").text("");
					$("#cCapabilityURL").val("");
			    }, 2000);
			}else{
				$("#failureAlert2").html('添加失败').show();
			}
		}
	})
}


function loadBlock(){
	$.ajax({
		url:path+'/service/block/queryBlockList',
		dataType:"json",
		async:true,
		//data:"",
		cache:false,
		type:"post",
		success:function(blockList){
			$(".capabilityBlock").find("option").remove();
			$(".capabilityBlock").append("<option value=''>-- 请选择模块 --</option>");
			for(var i = 0;i<blockList.length;i++){
				if(blockList[i].blockType == '1'){
					//私有技能
					$("#pBlock").append("<option value='"+blockList[i].blockId+"'>"+blockList[i].blockName+"</option>");
					$("#pBlock2").append("<option value='"+blockList[i].blockId+"'>"+blockList[i].blockName+"</option>");
				}else if(blockList[i].blockType == '2'){
					//公共技能
					$("#cBlock").append("<option value='"+blockList[i].blockId+"'>"+blockList[i].blockName+"</option>");
					$("#cBlock2").append("<option value='"+blockList[i].blockId+"'>"+blockList[i].blockName+"</option>");
				}
			}
		}
})}




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
			
			$("#pProject").find("option").remove(); 
			$("#pProject").append("<option value=''>-- 请选择项目 --</option>");
			for(var i = 0;i<listP.length;i++){
				$("#pProject").append("<option value='"+listP[i].projectId+"'>"+listP[i].projectName+"</option>");
			}
			if(projectId!=null){
				$("#pProject").val(projectId);
			}
		}
	})
}

function loadProProject2(buId,projectId){
	var buId = buId;
	$.ajax({
		url:path+'/service/project/queryAll',
		dataType:"json",
		async:true,
		data:{"buId":buId},
		cache:false,
		type:"post",
		success:function(listP){
			
			$("#pProject2").find("option").remove(); 
			$("#pProject2").append("<option value=''>-- 请选择项目 --</option>");
			for(var i = 0;i<listP.length;i++){
				$("#pProject2").append("<option value='"+listP[i].projectId+"'>"+listP[i].projectName+"</option>");
			}
			if(projectId!=null){
				$("#pProject2").val(projectId);
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
			$("#pBu").find("option").remove();
			$("#pBu").append("<option value=''>-- 请选择交付部 --</option>");
			for(var i = 0;i<listB.length;i++){
				$(".proCapabilityBu").append("<option value='"+listB[i].buId+"'>"+listB[i].buName+"</option>");
			}
		}
	})
}


function loadLevel(){
	$.ajax({
		url:path+"/service/level/queryAll",
		dataType:"json",
		async:true,
		//data:"",
		cache:false,
		type:"post",
		success:function(listL){
			$(".proCapabilityLevel").find("option").remove();
			$(".proCapabilityLevel").append("<option value=''>-- 请选择级别 --</option>");
			for(var i = 0;i<listL.length;i++){
				$(".proCapabilityLevel").append("<option value='"+listL[i].empLevelId+"'>"+listL[i].levelName+"</option>");
			}
		}
	})
}

function loadType(){
	$.ajax({
		url:path+'/service/type/queryAll',
		dataType:"json",
		async:true,
		//data:"",
		cache:false,
		type:"post",
		success:function(listT){
			$(".proCapabilityType").find("option").remove();
			$(".proCapabilityType").append("<option value=''>-- 请选择角色 --</option>");
			for(var i = 0;i<listT.length;i++){
				$(".proCapabilityType").append("<option value='"+listT[i].empTypeId+"'>"+listT[i].typeName+"</option>");
			}
		}
	})
}
$(function(){
	
	loadTrainningList();
	
	dateType();
	
});


function loadTrainningList(pageState){

	var trainningName = $("#trainningName").val();

	var pageState = pageState;
	
	$.ajax({
		url:path+"/service/trainning/trainningInfoList",
		dataType:"json",
		async:true,
		data:{"trainningName":trainningName,"pageState":pageState},
		cache:false,
		type:"post",
		success:function(result){
			$("#trainningList tbody").remove();
			
			var tbody = $("<tbody>");
			tbody.appendTo($("#trainningList"));
			
			for (var i = 0; i < result.data.length; i++) {
				var tr = $("<tr></tr>");
				tr.appendTo(tbody);

				/*var td1 = $("<td>"
						+ result.data[i].trainningId
						+ "</td>");*/
				var td2 = $("<td>"
						+ result.data[i].courseName
						+ "</td>");
				var td3 = $("<td>"
						+ result.data[i].time
						+ "</td>");
				var td4 = $("<td>"
						+ result.data[i].location
						+ "</td>");
				var td5 = $("<td>"
						+ result.data[i].teacher
						+ "</td>");
				//var td6 = $("<td><a class='btn btn-info' href='javascript:void(0);'> <i class='glyphicon glyphicon-edit icon-white'></i> Edit</a></td>");
				//var td7 = $("<td><a href='javascript:void(0);'  onclick=getEr('"+result.data[i].er+"')>Edit</a></td>");
				/*td1.appendTo(tr);*/
				td2.appendTo(tr);
				td3.appendTo(tr);
				td4.appendTo(tr);
				td5.appendTo(tr);
				//td6.appendTo(tr);
				
			}
			$("#trainningList").append("</tbdoy>");
			//alert(window.location.href);
			var pageNum = parseInt(result.pageInfo.currentPage);
			pageNum = pageNum / 10 + 1;
			var totalPage = parseInt(result.pageInfo.pageCount);
			$("#pageCount").html(totalPage);
			$("#currentPage").html(pageNum);
			$("#nextPage").attr("onclick","loadTrainningList('next')");
			$("#previousPage").attr("onclick","loadTrainningList('previous')");
			if(pageNum == totalPage){
				$("#nextPage").removeAttr("onclick");
			}
			if(pageNum == 1){
				$("#previousPage").removeAttr("onclick");
			}
		}
	})
}


function dateType(){
	$('.form_datetime').datetimepicker({
		weekStart: 1,
		todayBtn:  1,
		autoclose: 1,
		todayHighlight: 1,
		startView: 2,
		forceParse: 0,
		language:'zh-CN',
		format: 'yyyy-mm-dd hh:ii:ss',
		pickerPosition: 'bottom-left',
		showMeridian: 1
	});
}


function loadCCapability(){
	$.ajax({
		url:path+'/service/commonCapability/queryCCapability',
		dataType:"json",
		async:true,
		cache:false,
		type:"post",
		success:function(cCapabilityList){
			$("#skillPoints").find("option").remove(); 
			$("#skillPoints").append("<option value=''>-- 请选择技能点 --</option>");
			for(var i = 0;i<cCapabilityList.length;i++){
				$("#skillPoints").append("<option value='"+cCapabilityList[i].commCapabilityId+"'>"+cCapabilityList[i].name+"</option>");
			}
		}
	})
}


function loadProCapability(){
	$.ajax({
		url:path+'/service/proCapability/queryProCapability',
		dataType:"json",
		async:true,
		cache:false,
		type:"post",
		success:function(proCapabilityList){
			$("#skillPoints").find("option").remove(); 
			$("#skillPoints").append("<option value=''>-- 请选择技能点 --</option>");
			for(var i = 0;i<proCapabilityList.length;i++){
				$("#skillPoints").append("<option value='"+proCapabilityList[i].proCapabilityId+"'>"+proCapabilityList[i].name+"</option>");
			}
		}
	})
}

function addTrainning(){
	var item = $('input[name="skillRadio"]:checked').val();
	
	if(item == 'option1'){
		loadCCapability();
	}
	
	if(item == 'option2'){
		loadProCapability();
	}
	
	$('#myModal').modal('show');
}

function saveTrainning(){
	var trainningName = $("#trainningName2").val();
	var trainningTime = $("#trainningTime").val();
	var location = $("#location").val();
	var teacher = $("#teacher").val();
	var trainningURL = $("#trainningURL").val();
	var skillPoints = $("#skillPoints").val();
	$.ajax({
		url:path+'/service/trainning/addTrainning',
		dataType:"json",
		async:true,
		data:{"trainningName":trainningName,"trainningTime":trainningTime,"location":location,"teacher":teacher,"trainningURL":trainningURL,"skillPoints":skillPoints},
		cache:false,
		type:"post",
		success:function(resultFlag){
			if(resultFlag){
				$("#successAlert").html('添加成功').show();
				setTimeout(function () {
				    $("#successAlert").hide();
				    $("#trainningName2").val("");
					$("#trainningTime").val("");
					$("#location").val("");
					$("#teacher").val("");
					$("#trainningURL").val("");
					$('#myModal').modal('hide');
			    }, 2000);
			}else{
				$("#failureAlert").html('添加失败').show();
			}
		}
	})
}

$('#commonCapability').click(function(){
	loadCCapability();
})

$('#proCapability').click(function(){
	loadProCapability();
})

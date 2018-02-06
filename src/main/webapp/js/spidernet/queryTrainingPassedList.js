var empArray = new Array();
$(function(){
	
	loadTrainningPassedList();
	
	loadTrainingName();
	
});


function loadTrainingName(){
	$.ajax({
		url:path+'/service/trainning/queryTrainingName',
		dataType:"json",
		async:true,
		cache:false,
		type:"post",
		success:function(trainingList){
			$("#TrainingName").append("<option>-- Please select training name --</option>");
			for(var i = 0;i<trainingList.length;i++){
				$("#TrainingName").append("<option>"+trainingList[i].courseName+"</option>");
			}
			$('#TrainingName').selectpicker({
		        'selectedText': 'cat'
		    });
		}
	})
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


function loadTrainningPassedList(pageState){
	
	var trainingName = $("#TrainingName").val();

	var pageState = pageState;
	
	$.ajax({
		url:path+"/service/employeeInfo/trainingPassedList",
		dataType:"json",
		async:true,
		data:{"pageState":pageState,"trainingName":trainingName},
		cache:false,
		type:"post",
		success:function(result){
			$("#trainningPassedList tbody").remove();
			
			var tbody = $("<tbody>");
			tbody.appendTo($("#trainningPassedList"));
			
			for (var i = 0; i < result.data.length; i++) {
				var tr = $("<tr></tr>");
				tr.appendTo(tbody);

				
				var td1 = $("<td id='td"+i+"'>"
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
				var td7 = $("<td>"
						+ result.data[i].trainingName
						+ "</td>");
				td1.appendTo(tr);
				td2.appendTo(tr);
				td3.appendTo(tr);
				td4.appendTo(tr);
				td5.appendTo(tr);
				td6.appendTo(tr);
				td7.appendTo(tr);
				
			}
			$("#trainningPassedList").append("</tbdoy>");
			//alert(window.location.href);
			var pageNum = parseInt(result.pageInfo.currentPage);
			pageNum = pageNum / 10 + 1;
			var totalPage = parseInt(result.pageInfo.pageCount);
			$("#pageCount").html(totalPage);
			$("#currentPage").html(pageNum);
			$("#nextPage").attr("onclick","loadTrainningPassedList('next')");
			$("#previousPage").attr("onclick","loadTrainningPassedList('previous')");
			if(pageNum == totalPage){
				$("#nextPage").removeAttr("onclick");
			}
			if(pageNum == 1){
				$("#previousPage").removeAttr("onclick");
			}
			
//			showSelected();
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






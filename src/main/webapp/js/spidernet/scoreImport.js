$(document).ready(function() {
	$("#scoreForm").attr("action",path+"/service/exam/importScore");

    $('#scoreForm').bootstrapValidator({
		message: 'This value is not valid',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
        	inputFile: {
                group: '.group',
				validators: {
                    notEmpty: {
                        message: '请选择所需导入的表格'
                    }
                }
            }
        }
    }).on('success.form.bv', function(e) {
        });
});


$(function(){
	
	loadExamName();
	
	showResultState();
	
	
});

function updateResultState(){
	$.ajax({
		url:path+"/service/exam/updResultState",
		dataType:"json",
		async:true,
		cache:false,
		type:"post",
	})
}

function showResultState(){
	var resultState = $("#resultState").val();
	
	if(resultState == "1"){
		$("#alertBox").html('录入成功').show();
		updateResultState();
	}
	
	if(resultState == "2"){
		$("#alertBox").html('录入失败').show();
		updateResultState();
	}
}


function loadExamName(){
	$.ajax({
		url:path+"/service/exam/examNameList",
		dataType:"json",
		async:true,
		//data:"",
		cache:false,
		type:"post",
		success:function(examNameList){
			for(var i = 0;i<examNameList.length;i++){
				$("#examName").append("<option value='"+examNameList[i].examId+"'>"+examNameList[i].name+"</option>");
			}
		}
	})
}


function loadExamDate(examId){
	$.ajax({
		url:path+"/service/exam/examDateList",
		dataType:"json",
		async:true,
		data:{'examId':examId},
		cache:false,
		type:"post",
		success:function(examNameList){
			$("#examDate").find("option").remove();
			$("#examDate").append("<option>-- 请选择考试时间 --</option>");
			for(var i = 0;i<examNameList.length;i++){
				$("#examDate").append("<option value='"+examNameList[i].examId+"'>"+examNameList[i].startTime+"</option>");
			}
		}
	})
}



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
		url:path+'/service/exam/queryExamName',
		dataType:"json",
		async:true,
		cache:false,
		type:"post",
		success:function(examList){
			$("#examName").append("<option>--请选择考试名称--</option>");
			for(var i = 0;i<examList.length;i++){
				$("#examName").append("<option>"+examList[i].name+"</option>");
			}
			$('#examName').selectpicker({
		        'selectedText': 'cat'
		    });
		}
	})
}
$("#examName").change(function(){
	var examName = $('#examName').val();
	$.ajax({
		url:path+'/service/exam/queryExamByName',
		dataType:"json",
		async:true,
		data:{"examName":examName},
		cache:false,
		type:"post",
		success:function(examList){
			$("#examDate").find("option").remove(); 
			$("#examDate").append("<option value=''>-- 请选择考试时间 --</option>");
			for(var i = 0;i<examList.length;i++){
				$("#examDate").append("<option value='"+examList[i].examId+"'>"+examList[i].startTime+"</option>");
			}
		}
	})
})


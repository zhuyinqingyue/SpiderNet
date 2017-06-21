/*$(document).ready(function() {
    $('#examBoxForm').bootstrapValidator({
		message: 'This value is not valid',

        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
        	examName2: {
        		group: '.group',
        		validators: {
                    notEmpty: {
                        message: '请输入考试名称'
                    },
                     stringLength: {
                        min: 1,
                        max: 50,
                        message: '请输入长度在50个字符内的考试名称'
                    }
                }
            },
            description: {
            	group: '.group',
            	validators: {
                    notEmpty: {
                        message: '请输入考试描述'
                    }
                },
                stringLength: {
                    min: 1,
                    max: 50,
                    message: '请输入长度在500个字符内的考试描述'
                }
            },
            startTime1: {
                group: '.group',
				validators: {
                    notEmpty: {
                        message: '请输入考试开始时间'
                    }
                }
            },
            endTime1: {
                group: '.group',
				validators: {
                    notEmpty: {
                        message: '请输入考试结束时间'
                    }
                }
            },
            examTime: {
                group: '.group',
				validators: {
                    notEmpty: {
                        message: '请输入考试时间'
                    },
                    regexp: {
                        regexp: /^[1-9]\d*$/,
                        message: '请输入数字'
                    }
                }
            },
            validPeriod: {
                group: '.group',
				validators: {
                    notEmpty: {
                        message: '请输入考试有效期'
                    },
                    regexp: {
                        regexp: /^[1-9]\d*$/,
                        message: '请输入数字'
                    }
                }
            }
        }
    }).on('success.form.bv', function(e) {
            // Prevent submit form
            e.preventDefault();
            var $form     = $(e.target);
                validator = $form.data('bootstrapValidator');
            if(validator){
            		saveExam();
            }
        });
});*/


$(function(){
	loadExamList();
	
    loadBu();
	
	loadProject();

	dateType();
});


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


function loadExamList(pageState){
	var buId = $("#bu").val();

	var projectId = $("#project").val();

	var examName = $("#examName").val();

	var pageState = pageState;
	
	$.ajax({
		url:path+"/service/examInfo/examInfoList",
		dataType:"json",
		async:true,
		data:{"buId":buId,"projectId":projectId,"examName":examName,"pageState":pageState},
		cache:false,
		type:"post",
		success:function(result){
			$("#examList tbody").remove();
			
			var tbody = $("<tbody>");
			tbody.appendTo($("#examList"));
			
			for (var i = 0; i < result.data.length; i++) {
				var tr = $("<tr></tr>");
				tr.appendTo(tbody);

				/*var td1 = $("<td id='tx1'>"
						+ result.data[i].examId
						+ "</td>");*/
				var td2 = $("<td>"
						+ result.data[i].examName
						+ "</td>");
				var td3 = $("<td>"
						+ result.data[i].buName
						+ "</td>");
				var td4 = $("<td>"
						+ result.data[i].projectName
						+ "</td>");
				var td5 = $("<td>"
						+ result.data[i].startTime
						+ "</td>");
				var td6 = $("<td><a class='btn btn-info' href='javascript:void(0);'> <i class='glyphicon glyphicon-edit icon-white'></i> Edit</a></td>");
				//var td7 = $("<td><a href='javascript:void(0);'  onclick=getEr('"+result.data[i].er+"')>Edit</a></td>");
				/*td1.appendTo(tr);*/
				td2.appendTo(tr);
				td3.appendTo(tr);
				td4.appendTo(tr);
				td5.appendTo(tr);
				td6.appendTo(tr);
				
			}
			$("#examList").append("</tbdoy>");
			//alert(window.location.href);
			var pageNum = parseInt(result.pageInfo.currentPage);
			pageNum = pageNum / 10 + 1;
			var totalPage = parseInt(result.pageInfo.pageCount);
			$("#pageCount").html(totalPage);
			$("#currentPage").html(pageNum);
			$("#nextPage").attr("onclick","loadExamList('next')");
			$("#previousPage").attr("onclick","loadExamList('previous')");
			if(pageNum == totalPage){
				$("#nextPage").removeAttr("onclick");
			}
			if(pageNum == 1){
				$("#previousPage").removeAttr("onclick");
			}
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
		}
	})
}

function loadProject2(buId,projectId){
	var buId = buId;
	$.ajax({
		url:path+'/service/project/queryAll',
		dataType:"json",
		async:true,
		data:{"buId":buId},
		cache:false,
		type:"post",
		success:function(listP){
			$("#project2").find("option").remove(); 
			$("#project2").append("<option value=''>-- 请选择项目 --</option>");
			for(var i = 0;i<listP.length;i++){
				$("#project2").append("<option value='"+listP[i].projectId+"'>"+listP[i].projectName+"</option>");
			}
			if(projectId!=null){
				$("#project2").val(projectId);
			}
		}
	})
}

 
function loadBu2(){
	$.ajax({
		url:path+'/service/bu/queryBu',
		dataType:"json",
		async:true,
		cache:false,
		type:"post",
		success:function(listB){
			$("#bu2").find("option").remove(); 
			$("#bu2").append("<option value=''>-- 请选择交付部 --</option>");
			for(var i = 0;i<listB.length;i++){
				$("#bu2").append("<option value='"+listB[i].buId+"'>"+listB[i].buName+"</option>");
			}
		}
	})
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


function addExam(){
	var item = $('input[name="skillRadio"]:checked').val(); 
	
    loadBu2();
	
	loadProject2();
	
	if(item == 'option1'){
		loadCCapability();
	}
	
	if(item == 'option2'){
		loadProCapability();
	}
	
	$('#myModal').modal('show');
}


$('#commonCapability').click(function(){
	loadCCapability();
})

$('#proCapability').click(function(){
	loadProCapability();
})

function saveExam(){
	var buId = $('#bu2').val();
	var projectId = $('#project2').val();
	var examName = $('#examName2').val();
	var description = $('#description').val();
	var startTime = $('#startTime1').val();
	var endTime = $('#endTime1').val();
	var examTime = $('#examTime').val();
	var validPeriod = $('#validPeriod').val();
	var skillPoints = $('#skillPoints').val();
	$.ajax({
		url:path+'/service/exam/addExam',
		dataType:"json",
		async:true,
		data:{"buId":buId,"projectId":projectId,"examName":examName,"description":description,"startTime":startTime,"endTime":endTime,"examTime":examTime,"validPeriod":validPeriod,"skillPoints":skillPoints},
		cache:false,
		type:"post",
		success:function(resultFlag){
			if(resultFlag){
				$("#successAlert").html('添加成功').show();
				setTimeout(function () {
					$("#successAlert").hide();
					$("#examName2").val("");
					$('#description').val("");
					$('#startTime1').val("");
					$('#endTime1').val("");
					$('#examTime').val("");
					$('#validPeriod').val("");
					$('#myModal').modal('hide');
			    }, 2000);
			}else{
				$("#failureAlert").html('添加失败').show();
			}
		}
	})
}





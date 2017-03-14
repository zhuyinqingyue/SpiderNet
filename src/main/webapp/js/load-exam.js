var personalExamList = null;
var status;

$("a[id='myExam']").click(
	function(e) {
		e.preventDefault();
		var capabilityId = e.currentTarget.attributes.capabilityId.value;
		$.ajax({
				url : path + "/service/exam/personalExamList",
				type : "post",
				async : true,
				cache : false,
				dataType : "json",
				data : "capabilityId="
						+ capabilityId,
				timeout : 20000,
				success : function(examList) {
					personalExamList = examList;

					$("#examListTable tbody").remove();
					$("#myModalExam").find('.alert-success').hide();
					$("#myModalExam").find('.alert-warning').hide();

					if (examList.length == 0) {
						$("#examSubmitBtn").prop('disabled',true);
					} else {
						$("#examSubmitBtn").prop('disabled',false);
					}

					var tbody = $("<tbody>");
					tbody.appendTo($("#examListTable"));

					for (var i = 0; i < examList.length; i++) {
						var tr = $("<tr></tr>");
						tr.appendTo(tbody);

						var td1 = $("<td> <input type='checkbox' id='subCheck'> </td>");
						var td2 = $("<td>"
								+ examList[i].buName
								+ "</td>");
						var td3 = $("<td>"
								+ examList[i].projectName
								+ "</td>");
						var td4 = $("<td>"
								+ examList[i].examName
								+ "</td>");
						var td5 = $("<td>"
								+ examList[i].startTime
								+ "</td>");
						var td6 = $("<td>"
								+ examList[i].endTime
								+ "</td>");
						var td7 = $("<td>"
								+ examList[i].examTime + "Min"
								+ "</td>");
						var td8 = $("<td>"
								+ examList[i].validPeriod + "Day"
								+ "</td>");

						if (examList[i].status == 0) {
							status = "报名中";
						}
						var td9 = $("<td>" + "<span class='label-success label label-default'>"
								+ status + "</span>"
								+ "</td>");

						td1.appendTo(tr);
						td2.appendTo(tr);
						td3.appendTo(tr);
						td4.appendTo(tr);
						td5.appendTo(tr);
						td6.appendTo(tr);
						td7.appendTo(tr);
						td8.appendTo(tr);
						td9.appendTo(tr);
					}
					$("#examListTable").append("</tbdoy>");
					$('#myModalExam').modal('show');
				}
			});
})


$("#examSubmitBtn").click(function(e){
	var selectedHtmlArray = [];
	var cMtr = $("#examListTable tbody tr");
	var selectedHtml = "";

	for (var i = 0; i < cMtr.length; i++) {
		var tempNode = cMtr.eq(i).find("td").find("input");

		if (tempNode.is(':checked')) {
			selectedHtml = "{'examId':'"+personalExamList[i].examId+"','examName':'"+personalExamList[i].examName+"','startTime':'"+personalExamList[i].startTime+"','endTime':'"+personalExamList[i].endTime+"','status':'"+personalExamList[i].status+"'}";
			selectedHtmlArray.push(selectedHtml);
		}
	}

	if(selectedHtmlArray.length==0){
		$("#myModalExam").find('.alert').hide();
		$("#myModalExam").find('.alert-warning').html('请选择您要参加的考试').show();

	}else{

	$.ajax({
		url : path + "/service/exam/addPersonalExamDetl",
		type : "post",
		async : true,
		cache : false,
		dataType : "json",
		data : {'selectedExamArray' : JSON.stringify(selectedHtmlArray)},
		timeout : 20000,
		success : function(data) {
			if (data) {
				$("#myModalExam").find('.alert').hide();
				$("#myModalExam").find('.alert-success').html('恭喜您注册考试成功').show();
			} else {
				$("#myModalExam").find('.alert').hide();
				$("#myModalExam").find('.alert-warning').html('您已经注册过该课程考试').show();
			}
		}
	});

	}
})
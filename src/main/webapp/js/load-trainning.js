var personalTrainningList = null;
var status;
var capabilityId;

$("a[id='myCourse']").click(
	function(e) {
		e.preventDefault();
		capabilityId = e.currentTarget.attributes.capabilityId.value;
		$.ajax({
				url : path + "/service/trainning/personalTrainningList",
				type : "post",
				async : true,
				cache : false,
				dataType : "json",
				data : "capabilityId="
						+ capabilityId,
				timeout : 20000,
				success : function(trainningList) {
					personalTrainningList = trainningList;

					$("#trainningListTable tbody").remove();
					$("#myModalClass").find('.alert-success').hide();
					$("#myModalClass").find('.alert-warning').hide();

					var tbody = $("<tbody>");
					tbody.appendTo($("#trainningListTable"));

					if (trainningList.length == 0) {
						$("#trainningSubmitBtn").prop('disabled',true);
					} else {
						$("#trainningSubmitBtn").prop('disabled',false);
					}

					for (var i = 0; i < trainningList.length; i++) {
						var tr = $("<tr></tr>");
						tr.appendTo(tbody);

						var td1;
						var td7;

						if (trainningList[i].status==0) {
							status = '报名中';
							td1 = $("<td> <input type='checkbox' id='subCheck'> </td>");
							td7 = $("<td>" + "<span class='label-success label label-default'>"
									+ status + "</span>"
									+ "</td>");
						} else if (trainningList[i].status==1){
							status = '满员';
							td1 = $("<td> <input type='checkbox' id='subCheck' disabled> </td>");
							td7 = $("<td>" + "<span class='label-warning label label-default'>"
									+ status + "</span>"
									+ "</td>");
						}

						var td2 = $("<td>"
								+ trainningList[i].courseName
								+ "</td>");
						var td3 = $("<td>"
								+ trainningList[i].time
								+ "</td>");
						var td4 = $("<td>"
								+ trainningList[i].location
								+ "</td>");
						var td5 = $("<td>"
								+ trainningList[i].teacher
								+ "</td>");
						var td6 =$("<td></td>");
						if( null!= trainningList[i].url && trainningList[i].url !=''){
							td6 = $("<td><a href='"+trainningList[i].url+"'>查看"
									+ "</a></td>");
						}
						td1.appendTo(tr);
						td2.appendTo(tr);
						td3.appendTo(tr);
						td4.appendTo(tr);
						td5.appendTo(tr);
						td6.appendTo(tr);
						td7.appendTo(tr);
					}
					$("#trainningListTable").append("</tbdoy>");
					$('#myModalClass').modal('show');
				}
			});
})

$("#trainningSubmitBtn").click(function(e){
	var selectedHtmlArray = [];
	var cMtr = $("#trainningListTable tbody tr");
	var selectedHtml = "";

	for (var i = 0; i < cMtr.length; i++) {
		var tempNode = cMtr.eq(i).find("td").find("input");

		if (tempNode.is(':checked')) {
			selectedHtml = "{'trainningId':'"+personalTrainningList[i].trainningId+"','status':'"+personalTrainningList[i].status+"'}";
			selectedHtmlArray.push(selectedHtml);
		}
	}

    if(selectedHtmlArray.length==0){
    	$("#myModalClass").find('.alert').hide();
		$("#myModalClass").find('.alert-warning').html('请选择您要参加的培训').show();
		//$("#myModalClass").find('.alert').css({color:"red"});

	}else{

	$.ajax({
		url : path + "/service/trainning/addPersonalTrainningDetl",
		type : "post",
		async : true,
		cache : false,
		dataType : "json",
		data : {'selectedTrainningArray' : JSON.stringify(selectedHtmlArray)},
		timeout : 20000,
		success : function(data) {
			if (data) {
				$('#myModalClass').modal('hide');
				$('#traning_' + capabilityId).html("<span class='label-success label label-default'>已注册</span>");
				window.location.reload();
			} else {
				$("#myModalClass").find('.alert').hide();
				$("#myModalClass").find('.alert-warning').html('注册失败，请联系管理员').show();
			}
		}
	});
	}
})
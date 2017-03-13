var personalTrainningList = null;

$("a[id='myCourse']").click(
	function(e) {
		e.preventDefault();
		var capabilityId = e.currentTarget.attributes.capabilityId.value;
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
					$("#myModalClass").find('.alert').html('Your trainning have submitted successfully').hide();

					var tbody = $("<tbody>");
					tbody.appendTo($("#trainningListTable"));

					for (var i = 0; i < trainningList.length; i++) {
						var tr = $("<tr></tr>");
						tr.appendTo(tbody);

						var td1 = $("<td> <input type='checkbox' id='subCheck' > </td>");
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
						var td6 = $("<td><a href='#'>"
								+ trainningList[i].url
								+ "</a></td>");
						var td7 = $("<td>"
								+ trainningList[i].status
								+ "</td>");

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

		$("#myModalClass").find('.alert').html('Please select your exam').show();

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
				$("#myModalClass").find('.alert').html('Your trainning have submitted successfully').show();
				//alert("Success");
			} else {
				$("#myModalClass").find('.alert').html('Your trainning is exist').show();
			}
		}
	});
	}
})
/*$("#selectAll").click(function() {
	if ($("#selectAll").prop("checked")) {
		$(":checkbox").prop("checked", true);
	} else {
		$(":checkbox").prop("checked", false);
	}
})

function setSelectAll() {
	if (!$("#subCheck").checked) {
		$("#selectAll").prop("checked", false);
	}

	var chsub = $("input[type='checkbox'][id='subCheck']").length;
	var checkedsub = $("input[type='checkbox'][id='subCheck']:checked").length;

	if (checkedsub == chsub) {
		$("#selectAll").prop("checked", true);
	}
}

$("#resetButton").click(function(){
	$(":checkbox").prop("checked", false);
})*/
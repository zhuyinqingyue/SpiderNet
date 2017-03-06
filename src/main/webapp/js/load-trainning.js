$("#myCourse").click(
	function(e) {
		e.preventDefault();

		$.ajax({
				url : path + "/service/trainning/personalTrainningList",
				type : "post",
				async : true,
				cache : false,
				dataType : "json",
				data : "capabilityId="
						+ "5721b3b036f74b6c9441724e9f2bc063",
				timeout : 20000,
				success : function(trainningList) {
					$("#trainningListTable tbody").remove();
					var tbody = $("<tbody>");
					tbody.appendTo($("#trainningListTable"));

					for (var i = 0; i < trainningList.length; i++) {
						var tr = $("<tr></tr>");
						tr.appendTo(tbody);

						var td1 = $("<td> <input type='checkbox' id='subCheck' onclick='setSelectAll()'> </td>");
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
						var td6 = $("<td>"
								+ trainningList[i].url
								+ "</td>");
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
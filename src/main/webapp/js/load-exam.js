$("#myExam").click(
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
					$("#examListTable tbody").remove();
					var tbody = $("<tbody>");
					tbody.appendTo($("#examListTable"));

					for (var i = 0; i < examList.length; i++) {
						var tr = $("<tr></tr>");
						tr.appendTo(tbody);

						var td1 = $("<td> <input type='checkbox' id='subCheck' onclick='setSelectAll()'> </td>");
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
						var td9 = $("<td>"
								+ examList[i].status
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
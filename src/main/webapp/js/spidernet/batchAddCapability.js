var empArray = new Array();
var capabilityArray = new Array();

$(function(){
	loadEmpList();
	
	loadBu();
	
	loadProject();
});


function checkPrivilege(){
	
	var privilegeState = $("#privilegeState").val();
	
	var buId = $("#buId").val();
	
	if(privilegeState=='false'){
		//$("#bu option[value='']").removeAttr("selected");
		//$("#bu option[value='"+buId+"']").attr("select","selected");
		$("#bu").val(buId);
		$("#bu").attr("disabled","disabled");
	}
	
}


function addEmployee(){
	var er = "";
	for(var i=0; i<10; i++){
		er = $("#td"+i+"").text();
		
		if($("#checkbox"+i+"").is(':checked') && $.inArray(er, empArray) == -1){
			empArray.push(er);
		}
		
		if(!$("#checkbox"+i+"").is(':checked') && $.inArray(er, empArray) != -1){
			empArray.splice(jQuery.inArray(er,empArray),1); 
		}
	}
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


function ViewCapability()
{
	
var url = path+"/service/capability/viewComCapability";

var buId = $('#bu').val();

    $.ajax({
        type: "post",
        url: url,
        data: {'buId':buId},
        cache: false,
        async : false,
        dataType: "json",
        success: function (data)
        {
        	var capabilityMapList = data.capabilityMap;
        	var htmlInner="";
        	for(var i=0;i<capabilityMapList.length;i++){
        		var data_info = capabilityMapList[i];
        		htmlInner+="<tr>";
        		if (data_info.blockType == 1)
    			{
        				htmlInner+= '<td blockId="'+data_info.blockId+'" blockType="'+data_info.blockType+'" name="'+data_info.name+'">'+data_info.name+'</td><td>';
        				if (data_info.proCapabilityL.length > 0)
    					{
        					for (var j=0;j<data_info.proCapabilityL.length;j++)
        					{
        						htmlInner+='  <input type="checkbox" proCapabilityId="'
        							+data_info.proCapabilityL[j].proCapabilityId+
        							'" url="'+data_info.proCapabilityL[j].url+'" name="'+data_info.proCapabilityL[j].name+'"/>'+data_info.proCapabilityL[j].name;
        					}
    					}
        				htmlInner+= '</td>';
    			}
        		if (data_info.blockType == 2)
    			{
        				htmlInner+= '<td blockId="'+data_info.blockId+'" blockType="'+data_info.blockType+'" name="'+data_info.name+'">'+data_info.name+'</td><td>'
        				if (data_info.cCapabilityL.length > 0)
    					{
        					for (var j=0;j<data_info.cCapabilityL.length;j++)
        					{
        						htmlInner+='  <input type="checkbox" commCapabilityId="'
        							+data_info.cCapabilityL[j].commCapabilityId+
        							'" url="'+data_info.cCapabilityL[j].url+'" name="'+data_info.cCapabilityL[j].name+'"/>'+data_info.cCapabilityL[j].name;
        					}
    					}
        				htmlInner+= '</td>';
    			}
        		htmlInner+="</tr>";
        		$("#capabilityMap tbody").html(htmlInner);
            }
        	
        	$('#myModal').modal('show');
        }
     });
}

function batchAddCapability(){
	SaveCapabilityMap();
	addEmployee();
	
	var buId = $('#bu').val(); 
	
	$.ajax({
		url:path+'/service/capability/updPersonalMapList',
		data: {'buId':buId,'empArray':empArray,'capabilityArray':capabilityArray},
		async:true,
		cache:false,
		traditional: true,
		type:"post",
		success:function(){
			 location.reload(); 
		}
	})
}


function SaveCapabilityMap(){
	var cMtr = $("#capabilityMap tbody tr");
	for (var j=0;j<cMtr.length;j++)
	{
		var cL = cMtr.eq(j).find("td").find("input");

		if (cMtr.eq(j).find("td").eq(0).attr("blockType") == 2)
		{
			for (var k=0;k<cL.length;k++)
			{
				if (cL.eq(k).is(':checked'))
				{
					capabilityArray.push(cL.eq(k).attr("commCapabilityId"));
				}
			}
		}
	}
}


function loadEmpList(pageState){
	
	addEmployee();
	
	var buId = $("#bu").val();

	var projectId = $("#project").val();

	var pageState = pageState;
	
	$.ajax({
		url:path+"/service/employeeInfo/employeeInfoList",
		dataType:"json",
		async:true,
		data:{"buId":buId,"projectId":projectId,"pageState":pageState},
		cache:false,
		type:"post",
		success:function(result){
			$("#EmployeeList tbody").remove();
			
			var tbody = $("<tbody>");
			tbody.appendTo($("#EmployeeList"));
			
			for (var i = 0; i < result.data.length; i++) {
				var tr = $("<tr></tr>");
				tr.appendTo(tbody);

				var td1 = $("<td><input type='checkbox' id='checkbox"+i+"'></td>");
				
				var td2 = $("<td id='td"+i+"'>"
						+ result.data[i].er
						+ "</td>");

				var td3 = $("<td>"
						+ result.data[i].hr
						+ "</td>");
				var td4 = $("<td>"
						+ result.data[i].name
						+ "</td>");
				var td5 = $("<td>"
						+ result.data[i].eName
						+ "</td>");
				var td6 = $("<td>"
						+ result.data[i].buName
						+ "</td>");
				var td7 = $("<td>"
						+ result.data[i].projectName
						+ "</td>");
				td1.appendTo(tr);
				td2.appendTo(tr);
				td3.appendTo(tr);
				td4.appendTo(tr);
				td5.appendTo(tr);
				td6.appendTo(tr);
				td7.appendTo(tr);
			}
			$("#EmployeeList").append("</tbdoy>");
			//alert(window.location.href);
			var pageNum = parseInt(result.pageInfo.currentPage);
			pageNum = pageNum / 10 + 1;
			var totalPage = parseInt(result.pageInfo.pageCount);
			$("#pageCount").html(totalPage);
			$("#currentPage").html(pageNum);
			$("#nextPage").attr("onclick","loadEmpList('next')");
			$("#previousPage").attr("onclick","loadEmpList('previous')");
			if(pageNum == totalPage){
				$("#nextPage").removeAttr("onclick");
			}
			if(pageNum == 1){
				$("#previousPage").removeAttr("onclick");
			}
			
			showSelected();
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
			checkPrivilege();
			loadEmpList();
		}
	})
}
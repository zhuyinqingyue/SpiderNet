function ViewCapability()
{
var url = "http://localhost:8080/SpiderNet/service/viewCCapability";
var buId = $("#BU_id").val();
var projectId = $("#project_id").val();
var empLevelId = $("#emp_level").val();
var empTypeId = $("#emp_type").val();;
var area_text = $("#capabilityMap tr:first th:eq(0)").text();
//var data = JSON.stringify(obj);

    $.ajax({
        type: "post",
        url: url,
        data: {buId,projectId,empLevelId,empTypeId},
        cache: false,
        async : false,
        dataType: "json",
        success: function (data)
        {
        	var capabilityMapList = data.capabilityMap;
        	var htmlInner;
        	for(var i=0;i<capabilityMapList.length;i++){
        		var data_info = capabilityMapList[i];
        		if (data_info.blockType == 1)
    			{
        			if (null != data_info.proCapabilityL[i])
    				{
        				htmlInner= '<td>'+data_info.name+'</td><td>';
        				for (var j=0;j<data_info.proCapabilityL.length;j++)
        				{
        					htmlInner+='  <input type="checkbox" value="">'+data_info.proCapabilityL[j].name;
        				}
        				htmlInner+= '</td>';
    				}
        			else
        			{
        				htmlInner= '<td>'+data_info.name+'</td><td>'+''+'</td>';
        			}
    			}
        		if (data_info.blockType == 2)
    			{
        			if (null != data_info.cCapabilityL[i])
    				{
        				htmlInner= '<td>'+data_info.name+'</td><td>'
        				for (var j=0;j<data_info.proCapabilityL.length;j++)
        				{
        					htmlInner+='  <input type="checkbox" value="">'+data_info.cCapabilityL[j].name;
        				}
        				htmlInner+= '</td>';
    				}
        			else
    				{
    					htmlInner= '<td>'+data_info.name+'</td><td>'+''+'</td>';
    				}
    			}
        		$("#capabilityMap tbody tr").eq(i).html(htmlInner);
            }
        	
        }
//        if("true"==data.flag){
//            alert("OK！");
//             return true;
//         }else{
//             alert("No OK!");
//             return false;
//         }
////            ,
//        error:function (XMLHttpRequest, textStatus, errorThrown) {      
//            alert("请求失败！");
//        }
     });
}


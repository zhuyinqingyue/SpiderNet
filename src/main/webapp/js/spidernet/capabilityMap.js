function ViewCapability()
{
var url = path+"/service/viewCCapability";
var buId = $("#BU_id").val();
var projectId = $("#project_id").val();
var empLevelId = $("#emp_level").val();
var empTypeId = $("#emp_type").val();;
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
        				htmlInner= '<td proBlockId="'+data_info.blockId+'">'+data_info.name+'</td><td>';
        				for (var j=0;j<data_info.proCapabilityL.length;j++)
        				{
        					htmlInner+='  <input type="checkbox" proCapabilityId="'
        						+data_info.proCapabilityL[j].proCapabilityId+
        						'" proUrl="'+data_info.proCapabilityL[j].url+'">'+data_info.proCapabilityL[j].name;
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
        				htmlInner= '<td commBlockId="'+data_info.blockId+'">'+data_info.name+'</td><td>'
        				for (var j=0;j<data_info.proCapabilityL.length;j++)
        				{
        					htmlInner+='  <input type="checkbox" commCapabilityId="'
        						+data_info.cCapabilityL[j].commCapabilityId+
        						'" commUrl="'+data_info.cCapabilityL[j].url+'">'+data_info.cCapabilityL[j].name;
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
     });
}

function CanelCheckBox()
{
	$("[type='checkbox']").removeAttr("checked");
}

function SaveCapabilityMap()
{

//	var chooseCMap='';
//    var objCheck=$("[type=checkbox]");    
//    var pCapability='';
//    var cCapability='';
//    for(var i=0; i<objCheck.length; i++){    
//      if(objCheck[i].checked)
//	  {
//    	  pCapability+=objCheck[i].value+',';
//    	  cCapability+=objCheck[i].text+',';
//	  }
//    }    
//    //那么现在来检测s的值就知道选中的复选框的值了    
//    alert(pCapability==''?'你还没有选择任何内容！':pCapability);
//    $.ajax({
//        type: "post",
//        url: path+"/service/saveCapability",
//        data: {buId,projectId,empLevelId,empTypeId},
//        cache: false,
//        async : false,
//        dataType: "json",
//        success: function (data)
//        {
//        }
//     });
}

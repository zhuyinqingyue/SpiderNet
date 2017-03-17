var saveCapability;

function ViewCapability(projectId)
{
	$('#myModal').modal('show');
var url = path+"/service/capability/viewCCapability";
var buId = $("#BU_id").val();
var projectId = projectId;
var empLevelId = $("#emp_level").val();
var empTypeId = $("#emp_type").val();
// var data = JSON.stringify(obj);

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
        	$("[type='checkbox']").attr("checked",'true');
        }
     });
}

function CanelCheckBox()
{
	$("[type='checkbox']").removeAttr("checked");
}

function SaveCapabilityMap()
{
	var cMtr = $("#capabilityMap tbody tr");
	var saveHtml="";
	saveHtml+="[";
	for (var j=0;j<cMtr.length;j++)
	{
		var cL = cMtr.eq(j).find("td").find("input");
		if (cMtr.eq(j).find("td").eq(0).attr("blockType") == 1)
		{
			saveHtml+="{'blockId':'"+cMtr.eq(j).find("td").eq(0).attr("blockId")+"','name':'"+cMtr.eq(j).find("td").eq(0).attr("name")+"','blockType':"+cMtr.eq(j).find("td").eq(0).attr("blockType")+",'proCapabilityL':[";
			for (var k=0;k<cL.length;k++)
			{
				if (cL.eq(k).is(':checked'))
				{
					saveHtml+="{'proCapabilityId':'"+cL.eq(k).attr("proCapabilityId")+"', 'blockId':'"+cMtr.eq(j).find("td").eq(0).attr("blockId")+"', 'name':'"+cL.eq(k).attr("name")+"','url':'"+cL.eq(k).attr("url")+"','status':'','trainingStatus':''},";
				}
			}
			saveHtml+="]},";
		}

		if (cMtr.eq(j).find("td").eq(0).attr("blockType") == 2)
		{
			saveHtml+="{'blockId':'"+cMtr.eq(j).find("td").eq(0).attr("blockId")+"','name':'"+cMtr.eq(j).find("td").eq(0).attr("name")+"','blockType':"+cMtr.eq(j).find("td").eq(0).attr("blockType")+",'cCapabilityL':[";
			for (var k=0;k<cL.length;k++)
			{
				if (cL.eq(k).is(':checked'))
				{
				saveHtml+="{'commCapabilityId':'"+cL.eq(k).attr("commCapabilityId")+"', 'blockId':'"+cMtr.eq(j).find("td").eq(0).attr("blockId")+"', 'name':'"+cL.eq(k).attr("name")+"','url':'"+cL.eq(k).attr("url")+"','status':'','trainingStatus':''},";
				}
			}
			saveHtml+="]},";
		}
	}
	saveHtml+="]";
	saveCapability = saveHtml;
	$('#myModal').modal('hide');
}

function RegCapabilityMap(obj)
{
//	var saveC = SaveCapabilityMap();
	var buId = $("#BU_id").val();
	var projectId = $("#projectName").val();
	var empLevelId = $("#emp_level").val();
	var empTypeId = $("#emp_type").val();
	var erId = $("#er").val();
	var hrId = $("#hr").val();
	var name = $("#name").val();
	var ename = $("#ename").val();
	var cMtr = $("#capabilityMap tbody tr");
    $.ajax({
        type: "post",
        url: path+"/service/capability/regCapability",
        data: {'CapabilityMap': saveCapability,buId,projectId,empLevelId,empTypeId,erId,hrId,name,ename},
        cache: false,
        async : true,
        dataType: "json",
        success: function (data)
        {
        	if (data)
    		{
        		var $form     = $(obj);
        		$form.find('.alert').html('注册成功，用户 ' +name+'可登录').show();
        		$("#sub_bt").prop("disabled", true);
        		//alert("注册成功!");
    		}
        	else
    		{
        		alert("注册失败!");
    		}
        }
     });
}


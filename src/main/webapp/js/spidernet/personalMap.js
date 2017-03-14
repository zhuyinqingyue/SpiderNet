$("#showEmp").show(function(){
    
    var url = path+"/service/capability/viewPersonalMap";
    var empId = $("#empId").val();

        $.ajax({
            type: "post",
            url: url,
            data: {empId},
            cache: false,
            async : false,
            dataType: "json",
            success: function (data)
            {
            	var capabilityMapList = data.capabilityMap;
            	var htmlInner="";
            	for(var i=0;i<capabilityMapList.length;i++){
            		var data_info = capabilityMapList[i];
            		
            		if (data_info.blockType == 1)
        			{
            			if (null != data_info.proCapabilityL[i])
        				{
            				for (var j=0;j<data_info.proCapabilityL.length;j++)
            				{
            					htmlInner+="<tr>";
            					
            					if (j==0)
        						{
            						htmlInner+= '<td rowspan="'+data_info.proCapabilityL.length+'">'+data_info.name+'</td>';
        						}
            					htmlInner+= '<td><a href='+data_info.proCapabilityL[j].url+' target="_blank">'+data_info.proCapabilityL[j].name+'</a></td>';
            					if (data_info.proCapabilityL[j].isTraining == true)
        						{
            						htmlInner+= '<td class="center"><a href="#" id="myCourse" capabilityId="'+data_info.proCapabilityL[j].proCapabilityId+'">参加培训</a></td>';
        						}
            					else
        						{
            						htmlInner+= '<td class="center"></td>';
        						}
            					
            					if (data_info.proCapabilityL[j].isExam == true)
        						{
            						htmlInner+= '<td class="center"><a href="#" id="myExam" capabilityId="'+data_info.proCapabilityL[j].proCapabilityId+'">参加考试</a></td>';
        						}
            					else
        						{
            						htmlInner+= '<td class="center"></td>';
        						}
            					
            					if (data_info.proCapabilityL[j].status != "" && null != data_info.proCapabilityL[j].status)
        						{
            						if (data_info.proCapabilityL[j].status == "0")
        							{
            							htmlInner+= '<td class="center"><span class="label-success label label-default">Sucess</span></td>';
        							}
            						if (data_info.proCapabilityL[j].status == "1")
        							{
            							htmlInner+= '<td class="center"><span class="label-default label label-danger">Fail</span></td>';
        							}
        						}
            					else
        						{
            						htmlInner+= '<td class="center"></td>';
        						}
            					htmlInner+="</tr>";
            				}
        				}
            			else
            			{
            				htmlInner+="<tr>";
            				htmlInner+= '<td>'+data_info.name+'</td>';
        					htmlInner+= '<td class="center"></td>';
        					htmlInner+= '<td class="center"></td>';
        					htmlInner+= '<td class="center"></td>';
            				htmlInner+="</tr>";
            			}
        			}
            		if (data_info.blockType == 2)
        			{
            			if (null != data_info.cCapabilityL[i])
        				{
            				for (var j=0;j<data_info.cCapabilityL.length;j++)
            				{
            					htmlInner+="<tr>";
            					
            					if (j==0)
        						{
            						htmlInner+= '<td rowspan="'+data_info.cCapabilityL.length+'">'+data_info.name+'</td>';
        						}
            					htmlInner+= '<td><a href='+data_info.cCapabilityL[j].url+' target="_blank">'+data_info.cCapabilityL[j].name+'</a></td>';
            					if (data_info.cCapabilityL[j].isTraining == true)
        						{
            						htmlInner+= '<td class="center"><a href="#" id="myCourse" capabilityId="'+data_info.cCapabilityL[j].commCapabilityId+'">参加培训</a></td>';
        						}
            					else
        						{
            						htmlInner+= '<td class="center"></td>';
        						}
            					
            					if (data_info.cCapabilityL[j].isExam == true)
        						{
            						htmlInner+= '<td class="center"><a href="#" id="myExam" capabilityId="'+data_info.cCapabilityL[j].commCapabilityId+'">参加考试</a></td>';
        						}
            					else
        						{
            						htmlInner+= '<td class="center"></td>';
        						}
            					
            					
            					if (data_info.cCapabilityL[j].status != "" && null != data_info.cCapabilityL[j].status)
        						{
            						if (data_info.cCapabilityL[j].status == "0")
        							{
            							htmlInner+= '<td class="center"><span class="label-success label label-default">Sucess</span></td>';
        							}
            						if (data_info.cCapabilityL[j].status == "1")
        							{
            							htmlInner+= '<td class="center"><span class="label-default label label-danger">Fail</span></td>';
        							}
        						}
            					else
        						{
            						htmlInner+= '<td class="center"></td>';
        						}
            					htmlInner+="</tr>";
            				}
        				}
            			else
        				{
            				htmlInner+="<tr>";
        					htmlInner+= '<td>'+data_info.name+'</td><td>'+''+'</td>';
        					htmlInner+= '<td class="center"></td>';
        					htmlInner+= '<td class="center"></td>';
        					htmlInner+= '<td class="center"></td>';
        					htmlInner+="</tr>";
        				}
            		
        			}
            		$("#personalMap tbody").html(htmlInner);
                }
            }
         });
});

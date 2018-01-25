var setting = {
    view: {
        /*addHoverDom: addHoverDom,
        removeHoverDom: removeHoverDom,
        selectedMulti: false*/
    },
    /*check: {
        enable: true
    },*/
    data: {
        simpleData: {
            enable: true
        }
    },
   /*edit: {
        enable: true
    },*/
    /*callback:{  
        onCheck:onCheck  
    } */
    callback: {
		onClick: zTreeOnClick
	}
};

$(document).ready(function(){
	$.ajax({
		url : path+"/service/menuInfo/showMenu",
		type : "post",
		async : true,
		cache : false,
		dataType : "json",
//		data : {'userName' : userName, 'password' : password},
		timeout : 20000,
		success : function(jsonData) {
//			var zNodes = JSON.stringify(jsonData);
			$.fn.zTree.init($("#treeDemo"), setting, jsonData);
//			$.fn.zTree.init($("#treeDemo"), setting, zNodes);
		}
	});
	
	function cleanScreen(){
		$("#pName").val($("#name").val());
		$("#name").val("");
		$("#menuUrl").val("");
		$("#remark").val("");
		$("#picUrl").val("");
		$("#pId").val($("#id").val());
		$('#pName').attr("disabled","disabled");
		
	};
	function addMenuInfo(){
		var id = $("#id").val();
		var name = $("#name").val();
		var url = $("#menuUrl").val();
//		var sort = $("#sort").val();
//		alert($("#id").val());
//		var parentId = $("#parentId").val();
		var remark = $("#remark").val();
		var picUrl = $("#picUrl").val();
		var valid = 'Y';
		$.ajax({
			url:path+"/service/menuInfo/addMenu",
			dataType:"json",
			async:true,
			data: {'id':id,'name':name,'url':url,'remark':remark,'picUrl':picUrl},
			cache:false,
			type:"post",
			success:function(resultFlag){
				if (resultFlag)
	    		{
	        		alert("成功!");
	        		window.location.href = path+"/service/menuInfo/menuManagement.html";
	    		}
	        	else
	    		{
	        		alert("失败!");
	    		}
			}
		})
	};
	
	var num = 0;
	$("#add").click(function(){
		if(num==0){
			cleanScreen();
			num++;
		}else{
			addMenuInfo();
			num--;
		}
		
		
	});

	$("#update").click(function(){
		var id = $("#id").val();
		var name = $("#name").val();
		var url = $("#menuUrl").val();
		var sort = $("#sort").val();
		var parentId = $("#parentId").val();
		var remark = $("#remark").val();
		var picUrl = $("#picUrl").val();
		var valid = 'Y';

		$.ajax({
			url:path+"/service/menuInfo/updateMenu.shtml",
			dataType:"json",
			async:true,
			data: {'id':id,'name':name,'url':url,'sort':sort,'parentId':parentId,'remark':remark,'picUrl':picUrl},
			cache:false,
			type:"post",
			success:function(resultFlag){
				if (resultFlag)
	    		{
	        		alert("成功!");
	        		window.location.href = path+"/service/menuInfo/menuManagement.html";
	    		}
	        	else
	    		{
	        		alert("失败!");
	    		}
			}
		});
	});
	
	$("#delete").click(function(){
		var id = $("#id").val();
		$.ajax({
			url:path+"/service/menuInfo/deleteMenu",
			dataType:"json",
			async:true,
			data:{"id":id},
			cache:false,
			type:"post",
			success:function(resultFlag){
				if (resultFlag)
	    		{
	        		alert("成功!");
	        		window.location.href = path+"/service/menuInfo/menuManagement.html";
	    		}
	        	else
	    		{
	        		alert("失败!");
	    		}
			}
		});
	});
	
	
	
});

var newCount = 1;
function addHoverDom(treeId, treeNode) {
    var sObj = $("#" + treeNode.tId + "_span");
    if (treeNode.editNameFlag || $("#addBtn_"+treeNode.tId).length>0) return;
    var addStr = "<span class='button add' id='addBtn_" + treeNode.tId
        + "' title='add node' onfocus='this.blur();'></span>";
    sObj.after(addStr);
    var btn = $("#addBtn_"+treeNode.tId);
    if (btn) btn.bind("click", function(){
        var zTree = $.fn.zTree.getZTreeObj("treeDemo");
        zTree.addNodes(treeNode, {id:(100 + newCount), pId:treeNode.id, name:"new node" + (newCount++)});
        return false;
    });
};

function removeHoverDom(treeId, treeNode) {
    $("#addBtn_"+treeNode.tId).unbind().remove();
};

//获取所有的选中的NODE Id
/*function onCheck(e,treeId,treeNode){
    var treeObj=$.fn.zTree.getZTreeObj("treeDemo"),
    nodes=treeObj.getCheckedNodes(true),
    v="";
    for(var i=0;i<nodes.length;i++){
    v+=nodes[i].name + ",";
    alert(nodes[i].id); //获取选中节点的值
    }
    
    
 };*/
//$("#form-control").onKeyUp

function zTreeOnClick(event, treeId, treeNode) {
//    alert(treeNode.tId + ", " + treeNode.name  +"," +treeNode.id);
    $.ajax({
		url:path+"/service/menuInfo/getMenuById",
		dataType:"json",
		async:true,
		data:{"id":treeNode.id},
		cache:false,
		type:"post",
		success:function(menu){
			$("#id").val(menu.id);
			$("#name").val(menu.name);
			$("#menuUrl").val(menu.url);
			$("#sort").val(menu.sort);
			$("#parentId").val(menu.parentId);
			$("#remark").val(menu.remark);
			$("#picUrl").val(menu.picUrl);
			$("#pName").val(menu.parentName);
		}
	});
};








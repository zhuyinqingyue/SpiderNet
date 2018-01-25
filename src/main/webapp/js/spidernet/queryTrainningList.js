$(function () {

    loadTrainningList();

    dateType();

});


function loadTrainningList(pageState) {

    var trainningName = $("#trainningName").val();

    var pageState = pageState;

    $.ajax({
        url: path + "/service/trainning/trainningInfoList",
        dataType: "json",
        async: true,
        data: {"trainningName": trainningName, "pageState": pageState},
        cache: false,
        type: "post",
        success: function (result) {
            $("#trainningList tbody").remove();

            var tbody = $("<tbody>");
            tbody.appendTo($("#trainningList"));

            for (var i = 0; i < result.data.length; i++) {
                var tr = $("<tr></tr>");
                tr.appendTo(tbody);

                /*var td1 = $("<td>"
                 + result.data[i].trainningId
                 + "</td>");*/
                var td2 = $("<td>"
                    + result.data[i].courseName
                    + "</td>");
                var td3 = $("<td>"
                    + result.data[i].time
                    + "</td>");
                var td4 = $("<td>"
                    + result.data[i].location
                    + "</td>");
                var td5 = $("<td>"
                    + result.data[i].teacher
                    + "</td>");
                var td6 = $("<td><a class='btn btn-primary btn-sm' href='javascript:void(0);' onclick=detailTrainningplan('" + result.data[i].trainningId + "')>Edit</a></td>");
                //var td6 = $("<td><a class='btn btn-info' href='javascript:void(0);'> <i class='glyphicon glyphicon-edit icon-white'></i> Edit</a></td>");
                //var td7 = $("<td><a href='javascript:void(0);'  onclick=getEr('"+result.data[i].er+"')>Edit</a></td>");
                /*td1.appendTo(tr);*/
                td2.appendTo(tr);
                td3.appendTo(tr);
                td4.appendTo(tr);
                td5.appendTo(tr);
                td6.appendTo(tr);

            }
            $("#trainningList").append("</tbdoy>");
            //alert(window.location.href);
            var pageNum = parseInt(result.pageInfo.currentPage);
            pageNum = pageNum / 10 + 1;
            var totalPage = parseInt(result.pageInfo.pageCount);
            $("#pageCount").html(totalPage);
            $("#currentPage").html(pageNum);
            $("#nextPage").attr("onclick", "loadTrainningList('next')");
            $("#previousPage").attr("onclick", "loadTrainningList('previous')");
            if (pageNum == totalPage) {
                $("#nextPage").removeAttr("onclick");
            }
            if (pageNum == 1) {
                $("#previousPage").removeAttr("onclick");
            }
        }
    })
}


function dateType() {
    $('.form_datetime').datetimepicker({
        weekStart: 1,
        todayBtn: 1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
        forceParse: 0,
        language: 'zh-CN',
        format: 'yyyy-mm-dd hh:ii:ss',
        pickerPosition: 'bottom-left',
        showMeridian: 1
    });
}


function loadCCapability() {
    $.ajax({
        url: path + '/service/commonCapability/queryCCapability',
        dataType: "json",
        async: true,
        cache: false,
        type: "post",
        success: function (cCapabilityList) {
            $("#skillPoints").find("option").remove();
            $("#skillPoints").append("<option value=''>-- 请选择技能点 --</option>");
            for (var i = 0; i < cCapabilityList.length; i++) {
                $("#skillPoints").append("<option value='" + cCapabilityList[i].commCapabilityId + "'>" + cCapabilityList[i].name + "</option>");
            }
        }
    })
}


function loadProCapability() {
    $.ajax({
        url: path + '/service/proCapability/queryProCapability',
        dataType: "json",
        async: true,
        cache: false,
        type: "post",
        success: function (proCapabilityList) {
            $("#skillPoints").find("option").remove();
            $("#skillPoints").append("<option value=''>-- 请选择技能点 --</option>");
            for (var i = 0; i < proCapabilityList.length; i++) {
                $("#skillPoints").append("<option value='" + proCapabilityList[i].proCapabilityId + "'>" + proCapabilityList[i].name + "</option>");
            }
        }
    })
}

function addTrainning() {
    var item = $('input[name="skillRadio"]:checked').val();

    if (item == 'option1') {
        loadCCapability();
    }

    if (item == 'option2') {
        loadProCapability();
    }

    $('#myModal').modal('show');
}

function saveTrainning() {
    var trainningName = $("#trainningName2").val();
    var trainningTime = $("#trainningTime").val();
    var location = $("#location").val();
    var teacher = $("#teacher").val();
    var trainningURL = $("#trainningURL").val();
    var skillPoints = $("#skillPoints").val();
    $.ajax({
        url: path + '/service/trainning/addTrainning',
        dataType: "json",
        async: true,
        data: {
            "trainningName": trainningName,
            "trainningTime": trainningTime,
            "location": location,
            "teacher": teacher,
            "trainningURL": trainningURL,
            "skillPoints": skillPoints
        },
        cache: false,
        type: "post",
        success: function (resultFlag) {
            if (resultFlag) {
                $("#successAlert").html('添加成功').show();
                setTimeout(function () {
                    $("#successAlert").hide();
                    $("#trainningName2").val("");
                    $("#trainningTime").val("");
                    $("#location").val("");
                    $("#teacher").val("");
                    $("#trainningURL").val("");
                    $('#myModal').modal('hide');
                }, 2000);
            } else {
                $("#failureAlert").html('添加失败').show();
            }
        }
    })
}

$('#commonCapability').click(function () {
    loadCCapability();
})

$('#proCapability').click(function () {
    loadProCapability();
})

function loadTrainingMessage() {
    $.ajax({
        url: path + '/service/commonCapability/queryCCapability',
        dataType: "json",
        async: true,
        cache: false,
        type: "post",
        success: function (result) {
            $("#skillPoints").find("option").remove();
            $("#skillPoints").append("<option value=''>-- 请选择技能点 --</option>");
            for (var i = 0; i < cCapabilityList.length; i++) {
                $("#skillPoints").append("<option value='" + cCapabilityList[i].commCapabilityId + "'>" + cCapabilityList[i].name + "</option>");
            }
        }
    })
}


function detailTrainningplan(CourceId) {

    var trainCourceId = CourceId;
    $("#parentTrainingName").val("");
    $("#parentTrainingName").val(trainCourceId);

    $.ajax({
        url: path + "/service/TrainingPlan/queryTrainPlan",
        dataType: "json",
        async: true,
        data: {"trainCourceId": trainCourceId},
        cache: false,
        type: "post",
        success: function (result) {

            $("#trainningPlanDetail tbody").remove();

            var tbody = $("<tbody>");
            tbody.appendTo($("#trainningPlanDetail"));

            for (var i = 0; i < result.length; i++) {
                var tr = $("<tr></tr>");
                tr.appendTo(tbody);
                var td1 = $("<td>"
                    + result[i].parentTrainingName
                    + "</td>");
                var td2 = $("<td>"
                    + result[i].childTrainName
                    + "</td>");
                var td3 = $("<td>"
                    + result[i].trainTime
                    + "</td>");
                var td4 = $("<td>"
                    + result[i].trainRoom
                    + "</td>");
                var td5 = $("<td>"
                    + result[i].participants
                    + "</td>");
                var td6 = $("<td> <a class='btn btn-info btn-xs' href='javascript:void(0);' onclick=updateDetailTrainningplanMode('" + result[i].allocationPlanId + "')>Edit</a>"
                                 + "&nbsp&nbsp&nbsp"
                               + "<a class='btn btn-danger btn-xs' href='javascript:void(0);' onclick=deletedTrainningdetailPlan('" + result[i].allocationPlanId + "','" + result[i].TrainCourseId + "')>Deleted</a>"
                          +"</td>");
                td1.appendTo(tr);
                td2.appendTo(tr);
                td3.appendTo(tr);
                td4.appendTo(tr);
                td5.appendTo(tr);
                td6.appendTo(tr);
            }
            $("#trainningPlanDetail").append("</tbdoy>");
        }
    })
}


function loadKnowledgePoint() {
    $.ajax({
        url: path + '/service/knowledge/getKnowledgePointByPid',
        dataType: "json",
        async: true,
        data: {
            "pid": "0",
            "status": "0",
        },
        cache: false,
        type: "post",
        success: function (knowledgePointList) {
            $("#addKnowledgePoint").find("option").remove();
            $("#addKnowledgePoint").append("<option value=''>-- Please Select --</option>");
            for (var i = 0; i < knowledgePointList.length; i++) {
                $("#addKnowledgePoint").append("<option value='" + knowledgePointList[i].knowledgePointId + "'>" + knowledgePointList[i].pointTitle + "</option>");
            }
        }
    })
}

$("#addKnowledgePoint").change(function(){

    $("#addChildKnowledgePoints").empty();
    var KnowledgePointByPid = $(this).val();


    $.ajax({
        url: path + '/service/knowledge/getKnowledgePointByPid',
        dataType: "json",
        async: true,
        data: {
            "pid": KnowledgePointByPid,
            "status": "0",
        },
        cache: false,
        type: "post",
        success:function(knowledgePointList){

            $("#addChildKnowledgePoints").find("option").remove();
            $("#addChildKnowledgePoints").append("<option value=''>-- Please Select --</option>");
            for (var i = 0; i < knowledgePointList.length; i++) {
                $("#addChildKnowledgePoints").append("<option value='" + knowledgePointList[i].knowledgePointId + "'>" + knowledgePointList[i].pointTitle + "</option>");
            }
        },
        error:function(){
            alert("请求失败")
        }
    });
});


function addDetailTrainningplan() {

    loadKnowledgePoint();

    $("#addKnowledgePoint").empty();
    $("#addChildKnowledgePoints").empty();
    $("#addDetailtrainningTime").empty();
    $("#addlocation").empty();
    $("#addParticipants").empty();

    $('#addTrainingPlanDeatil').modal('show');
}


function saveTrainningdetailPlan() {

     var trainingCourceId = $("#parentTrainingName").val();
     var parentTrainingName = $("#addKnowledgePoint").val();
     var childTrainingName = $("#addChildKnowledgePoints").val();
     var trainningTime = $("#addDetailtrainningTime").val();
     var trainingRoom = $("#addlocation").val();
     var participantsNumber = $("#addParticipants").val();

    $.ajax({
        url: path + '/service/TrainingPlan/addTrainPlan',
        dataType: "json",
        async: true,
        data: {
            "trainingCourceId": trainingCourceId,
            "parentTrainingName": parentTrainingName,
            "childTrainingName": childTrainingName,
            "trainningTime": trainningTime,
            "trainingRoom": trainingRoom,
            "participantsNumber": participantsNumber
        },
        cache: false,
        type: "post",
        success: function (resultFlag) {
            if (resultFlag) {
                $("#addsuccessAlert").html('添加成功').show();
                setTimeout(function () {
                    $("#addsuccessAlert").hide();
                    $("#trainingCourceId").val("");
                    $("#addKnowledgePoint").val("");
                    $("#addChildKnowledgePoints").val("");
                    $("#addDetailtrainningTime").val("");
                    $("#addlocation").val("");
                    $("#addParticipants").val("");
                    $('#addTrainingPlanDeatil').modal('hide');
                }, 2000);
            } else {
                $("#addfailureAlert").html('添加失败').show();
            }
        }
    })

    detailTrainningplan(trainingCourceId);
}

function loadupdateKnowledgePoint() {
    $.ajax({
        url: path + '/service/knowledge/getKnowledgePointByPid',
        dataType: "json",
        async: true,
        data: {
            "pid": "0",
            "status": "0",
        },
        cache: false,
        type: "post",
        success: function (knowledgePointList) {
            $("#updatenowledgePoint").find("option").remove();
            $("#updatenowledgePoint").append("<option value=''>-- Please Select --</option>");
            for (var i = 0; i < knowledgePointList.length; i++) {
                $("#updatenowledgePoint").append("<option value='" + knowledgePointList[i].knowledgePointId + "'>" + knowledgePointList[i].pointTitle + "</option>");
            }



        }
    })
}

function loadupdateChildKnowledgePoint() {

    $("#updateChildKnowledge").empty();
    var KnowledgePointByPid = $(this).val();


    $.ajax({
        url: path + '/service/knowledge/getKnowledgePointByPid',
        dataType: "json",
        async: true,
        data: {
            "pid": KnowledgePointByPid,
            "status": "0",
        },
        cache: false,
        type: "post",
        success: function (knowledgePointList) {

            $("#updateChildKnowledge").find("option").remove();
            $("#updateChildKnowledge").append("<option value=''>-- Please Select --</option>");
            for (var i = 0; i < knowledgePointList.length; i++) {
                $("#updateChildKnowledge").append("<option value='" + knowledgePointList[i].knowledgePointId + "'>" + knowledgePointList[i].pointTitle + "</option>");
            }
        },
        error: function () {
            alert("请求失败")
        }
    });
}


$("#updatenowledgePoint").change(function(){

    loadupdateChildKnowledgePoint();
});



function updateDetailTrainningplanMode(id) {

    loadupdateKnowledgePoint();

    queryTrainPlanByAllocationId(id);

    $('#updateTrainingPlanDeatil').modal('show');
}

function queryTrainPlanByAllocationId(id) {

    $.ajax({
        url: path + '/service/TrainingPlan/queryTrainPlanByAllocationId',
        dataType: "json",
        async: true,
        data: {"allocationPlanId": id},
        cache: false,
        type: "post",
        success: function (result) {
            $("#updatenowledgePoint").val(result.parentTrainingName);
            $("#updateChildKnowledge").val(result.childTrainName);
            $("#updateDetailtrainningTime").val(result.trainTime);
            $("#updatelocation").val(result.trainRoom);
            $("#updateparticipants").val(result.participants);
            $("#updateAllocationPlanId").val(result.allocationPlanId)
        }
    })
}


function updateTrainningdetailPlan() {

     var trainingCourceId = $("#parentTrainingName").val();
     var updatenowledgePoint = $("#updatenowledgePoint").val();
     var updateChildKnowledge = $("#updateChildKnowledge").val();
     var updateDetailtrainningTime = $("#updateDetailtrainningTime").val();
     var updatelocation = $("#updatelocation").val();
     var updateparticipants = $("#updateparticipants").val();
     var updateAllocationPlanId = $("#updateAllocationPlanId").val();

    $.ajax({
        url: path + '/service/TrainingPlan/updateTrainPlan',
        dataType: "json",
        async: true,
        data: {
            "trainingCourceId": trainingCourceId,
            "parentTrainingName": updatenowledgePoint,
            "childTrainingName": updateChildKnowledge,
            "trainningTime": updateDetailtrainningTime,
            "trainingRoom": updatelocation,
            "participantsNumber": updateparticipants,
            "allocationPlanId": updateAllocationPlanId
        },
        cache: false,
        type: "post",
        success: function (resultFlag) {
            if (resultFlag) {
                $("#updatesuccessAlert").html('修改成功').show();
                setTimeout(function () {
                    $("#updatesuccessAlert").hide();
                    $("#updatenowledgePoint").val("");
                    $("#updateChildKnowledge").val("");
                    $("#updateDetailtrainningTime").val("");
                    $("#updateparentTrainingName").val("");
                    $("#updateparticipants").val("");
                    $('#updateTrainingPlanDeatil').modal('hide');
                }, 2000);
            } else {
                $("#updatefailureAlert").html('修改失败').show();
            }
        }
    })

    detailTrainningplan(trainingCourceId);
}

function deletedTrainningdetailPlan(id) {

    var parentTrainingId = $('#parentTrainingName').val();

    $.ajax({
        url: path + '/service/TrainingPlan/deleteTrainPlanByAllocationId',
        dataType: "json",
        async: true,
        data: {"allocationPlanId": id},
        cache: false,
        type: "post",
        success: function (resultFlag) {
        }
    })

    detailTrainningplan(parentTrainingId);
}
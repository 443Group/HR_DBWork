function getUserName() {
    $.ajax({
        url: '/user/name',
        type: 'GET',
        success: function (res) {
            $('.username').text(res);
        },
        error: function () {
            $('.username').text('未获得用户名');
        }
    });
}
function getUserInfo() {
    query = window.location.search.substring(0);
    $.ajax({
        url: '/user/info'+query,
        type: 'GET',
        success: function (res) {
            addUserInfo(res)
        },
        error: function () {
            alert("连接超时！")
        }
    });
}
function getDepList() {
    $.ajax({
        url: '/dep/list',
        type: 'GET',
        success: function (res) {
            addDepList(res)
        },
        error: function () {
            alert("连接超时！")
        }
    });
}
function getDepInfoFromUrl() {
    let info = getUrlPara('info');
    info = $.base64.decode(info);
}

function addDepList(list) {
    $.each(list, function(i, item){
        let content = '';
        let base64 = $.base64.encode(item);
        if(item["parentName"] ==="null")
            item["parentName"] = "无";
        content += '<td>'+item["depId"]+'</td>';
        content += '<td>'+item["depName"]+'</td>';
        content += '<td>'+item["mgrName"]+'</td>';
        content += '<td>'+item["addr"]+'</td>';
        content += '<td>'+item["phoneNumber"]+'</td>';
        content += '<td>'+item["parentName"]+'</td>';
        content += '<td><a class="btn-group btn btn-primary" href="/dep_info.html?info=' + base64 + '"><i class="icon_documents_alt"></i> 详细信息</a></td>';
        $("#list").append($("<tr></tr>").html(content));
    });
}
function addUserInfo(user){
    user["registerTime"] = user["registerTime"].replace("T","  ");

    $(".para1").text(user["employeeId"]);
    $(".para2").text(user["employeeName"]);
    $(".para3").text(user["postName"]);
    $(".para4").text(user["departmentName"]);
    $(".para5").text(user["titleName"]);
    $(".para6").text(user["politicalValue"]);
    $(".para7").text(user["email"]);
    $(".para8").text(user["phoneNumber"]);
    $(".para9").text(user["birthday"]);
    $(".para10").text(user["healthValue"]);
    $(".para11").text(user["registerTime"]);
}

function getUrlPara(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
    var r = window.location.search.substr(1).match(reg);
    if (r != null) return unescape(r[2]); return null;
}
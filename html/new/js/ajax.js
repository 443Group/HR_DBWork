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
    info = decodeURI(info);
    $.base64.utf8encode = true;
    info = unescape($.base64.decode(info));
    info = JSON.parse(info);

    $.ajax({
        url: '/dep/number'+info["depId"],
        type: 'GET',
        success: function (num) {
            $(".para8").text(num);
        },
        error: function () {
            alert("连接超时！")
        }
    });

    if(info["info"] == null)
        info["info"] = "无";
    $(".para1").text(info["depId"]);
    $(".para2").text(info["depName"]);
    $(".para3").text(info["mgrName"]);
    $(".para4").text(info["addr"]);
    $(".para5").text(info["phoneNumber"]);
    $(".para6").text(info["parentName"]);
    $(".para7").text(info["info"]);
}

function addDepList(list) {
    $.each(list, function(i, item){
        // alert(JSON.stringify(item));
        let content = '';
        if(item["parentName"] == null)
            item["parentName"] = "无";
        $.base64.utf8encode = true;
        let base64 = $.base64.encode(escape(JSON.stringify(item)));
        info = unescape($.base64.decode(base64));
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
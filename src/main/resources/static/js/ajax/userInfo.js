$().ready(function (){
    $.ajax({
        url: '/user/name',
        type: 'GET',
        success: function (res) {
            addUserInfo(res)
        },
        error: function () {
            $('.username').text('未获得用户名');
        }
    });
});

function addUserInfo(user){
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
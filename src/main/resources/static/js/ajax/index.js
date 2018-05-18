$().ready(function (){
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
});

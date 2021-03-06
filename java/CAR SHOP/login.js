$(document).ready(function () {
    $("#login").on('click', function () {
        var username = $("#username").val();
        var password = $("#password").val();
        $.ajax({
            type: "GET",
            url: "http://localhost/2020/AGSC/CAR%20SHOP/admin_login.php?username=" + username + "&password=" + password
        }).done(function (data) {
            console.log(data);
            if (data=='admin') {
                window.location.href = "admin-home.html";
                
            } else if(data=='Invalid') {
                alert('Invalid username please enter valid username and password')
            }else{
                window.location.href = "customer-home.html?"+data;
            }
        });
    })
});
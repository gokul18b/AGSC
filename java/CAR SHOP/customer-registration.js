
$(document).ready(function () {
	$("#register").on('click', function () {
		var one = $("#1").val();
        var two = $("#2").val();
		var three = $("#3").val();
		var four = $("#4").val();
		var five = $("#5").val();
		// var six = $("#6").val();
		// var seven = $("#7").val();
		// var eight = $("#8").val();
        $.ajax({
            type: "GET",
            url: "http://localhost/2020/AGSC/CAR%20SHOP/add_customer.php?fname=" + encodeURIComponent(one) + "&lname=" + two+ "&emailid=" + three+ "&password=" + four+ "&mobile=" + five
        }).done(function (data) {
			alert(data)
            $("#1").val("");
			$("#2").val("");
			$("#3").val("");
			$("#4").val("");
			$("#5").val("");
		 
        });
    });	
});


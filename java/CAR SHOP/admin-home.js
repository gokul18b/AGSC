
$(document).ready(function () {
	loading();
	$("#register1").on('click', function () {
		var one = $("#1").val();
        var two = $("#2").val();
		var three = $("#3").val();
		var four = $("#4").val();
		var five = $("#5").val();
		var six = $("#6").val();
		var seven = $("#7").val();
		var eight = $("#8").val();
        $.ajax({
            type: "GET",
            url: "http://localhost/2020/AGSC/CAR%20SHOP/add_car.php?bname=" + encodeURIComponent(one) + "&carname=" + two+ "&model=" + three+ "&engine=" + four+ "&width=" + five+ "&height=" + six+ "&price=" + seven+ "&year=" + eight
        }).done(function (data) {
           alert(data);
		   $("#1").val("");
			$("#2").val("");
			$("#3").val("");
			$("#4").val("");
			$("#5").val("");
			$("#6").val("");
			$("#7").val("");
			$("#8").val("");
			loading();
        });
	});
});
function logout(){
	window.location.href="index.html";
}
function booking_history(){
	$.ajax({
		type: "GET",
		url: "http://localhost/2020/AGSC/CAR%20SHOP/booking_cars.php"
	}).done(function (data) {
		var html='';
		data = JSON.parse(data);
		for(var i=0;i<data.length;i++){
			var row=data[i];
			html += ` <tr><th scope="row">`+(i+1)+`</th>
						 <td>`+row.fname+` `+row.lname+`</td>
						 <td>`+row.mobile+`</td>
						 <td>`+row.cname+`</td>
						 <td>`+row.model+`</td>
						 <td>`+row.price+`</td>
						 <td>`+row.expected+`</td>
						 <td>`+row.suggest+`</td>
						 </tr>`;
			
		}
		 $("#body1").html(html);
	});
}
 function car_details(){
	
	$.ajax({
		type: "GET",
		url: "http://localhost/2020/AGSC/CAR%20SHOP/view_cars.php"
	}).done(function (data) {
		var html='';
		var data = JSON.parse(data);
		for(var i=0;i<data.length;i++){
			var row=data[i];
			html += `<div class="card col-md-" style="width: 18rem;margin:10px">
						<img class="card-img-top" src="./car.jpg" alt="Card image cap">
						<div class="card-body" >
							<h5 class="card-title">`+row.cname+`</h5>
							<p class="card-text">`+row.model+`</p>
						</div>
						<ul class="list-group list-group-flush">
							<li class="list-group-item">Branch : `+row.bname+`</li>
							<li class="list-group-item">Engine : `+row.engine+`</li>
							<li class="list-group-item">Width :`+row.width+` Height : `+row.height+`</li>
						</ul>
						<div class="card-body">
							<a href="#" class="card-link">Year : `+row.year+`</a>
							<a href="#" class="card-link">Price :`+row.price+`</a>
						</div>
					</div>`;
			
		}
		 $("#body2").html(html);
	});
 }

function loading(){
	booking_history();
	car_details();
}

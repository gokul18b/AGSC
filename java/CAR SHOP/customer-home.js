
$(document).ready(function () {
	loading();
	
});
function logout(){
	window.location.href="index.html";
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
							<li class="list-group-item">Branch : `+row.branch+`</li>
							<li class="list-group-item">Engine : `+row.engine+`</li>
							<li class="list-group-item">Width :`+row.width+` Height : `+row.height+`</li>
						</ul>
						<div class="card-body">
							<a href="#" class="card-link">Year : `+row.year+`</a>
							<a href="#" class="card-link">Price :`+row.price+`</a>
							 <input placeholder="EXpected Price"  class="form-control" id="a`+row.id+`">
						
						 <input placeholder="Suggested" class="form-control" id="b`+row.id+`"></div>
						 <button onclick="book('`+row.id+`')" type="submit" class="btn btn-primary">Book</button>
					</div>`;
			
		}
		 $("#body2").html(html);
	});
 }
function book(cid){
	const queryString = window.location.search;
		const urlParams = new URLSearchParams(queryString);
		const cusid = urlParams.get('id');
		 var expected = $("#a"+cid).val();
		 var suggested = $("#b"+cid).val();
		 $.ajax({
            type: "GET",
            url: "http://localhost/2020/AGSC/CAR%20SHOP/add_booking.php?cusid=" + encodeURIComponent(cusid) + "&cid=" + cid+ "&expected=" +expected+"&suggested="+suggested
        }).done(function (data) {
           alert(data);
		
        });
}
function loading(){
	
	car_details();
}

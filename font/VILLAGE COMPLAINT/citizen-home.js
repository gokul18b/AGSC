$(document).ready(function () {
	
	getComplaints();
    $("#register").on('click', function () {
		
		var one = $("#1").val();
		var two = $("#2").val();
		var three = $("#3").val();
		
		const queryString = window.location.search;
		const urlParams = new URLSearchParams(queryString);
		const id = urlParams.get('id')
		
		$.ajax({
			type: "GET",
			url: "http://localhost:8080/api/add_complaint/"+id+"/" +one + "/" + two+ "/" + three
		}).done(function (data) {
			alert(data);
			getComplaints();
			$("#1").val("");
		 $("#2").val("");
		 $("#3").val("");
		});
		
	});
	
	
});

function getComplaints(){
	const queryString = window.location.search;
	const urlParams = new URLSearchParams(queryString);
	const id = urlParams.get('id')
		$.ajax({
            type: "GET",
            url: "http://localhost:8080/api/get_complaints/"+id
        }).done(function (data) {
			var html='';
           for(var i=0;i<data.length;i++){
			   var row=data[i];
			   var status= row.status;
			   var dstatus='Action Requested';
			   if(status==1){
					dstatus='Action Requested';
			   }else if(status==2){
				   dstatus='In Review';
			   }else if(status==3){
				   dstatus='In progress';
			   }else if(status==4){
					dstatus='Verified'
			   }else if(status==5){
					dstatus='Completed'
			   }
			   html += `<tr>
							<th scope="row">`+(i+1)+`</th>
							<td>`+row.mobile+`</td>
							<td>`+row.reason+`</td>
							<td>`+row.address+`</td>
							<td>`+dstatus+`</td>                          
						</tr>`;
			   
		   }
            $("#body1").html(html);
			
        });
}
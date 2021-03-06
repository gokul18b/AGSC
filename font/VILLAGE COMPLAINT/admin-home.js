$(document).ready(function () {
	initiate();
	
	
});
function initiate(){
	getCitizen();
	getComplaints();
    getComplaintAction();
}

function getCitizen(){
		var j=0;
		$.ajax({
            type: "GET",
            url: "http://localhost:8080/api/get_citizen"
        }).done(function (data) {
			var html='';
           for(var i=0;i<data.length;i++){
			   var row=data[i];
			   html += `<tr>
							<th scope="row">`+(++j)+`</th>
							<td>`+row.firstname+`</td>
							<td>`+row.lastname+`</td>
							<td>`+row.mobile+`</td>
							<td>`+row.address+`</td>
							<td>`+row.city+`</td>
							<td>`+row.state+`</td>
							<td>`+row.pincode+`</td>                            
						</tr>`;
			   
		   }
            $("#body1").html(html);
			
        });
}

function getComplaints(){

		$.ajax({
            type: "GET",
            url: "http://localhost:8080/api/get_complaints"
        }).done(function (data) {
			var html='';
			var j=0;
           for(var i=0;i<data.length;i++){
			   var row=data[i];
			   var status = row.status;
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
							<th scope="row">`+(++j)+`</th>
							<td>`+row.mobile+`</td>
							<td>`+row.reason+`</td>
							<td>`+row.address+`</td>
							<td>`+dstatus+`</td>                          
						</tr>`;
			   
		   }
            $("#body2").html(html);
			
        });
}

function getComplaintAction(){

	$.ajax({
		type: "GET",
		url: "http://localhost:8080/api/get_complaints"
	}).done(function (data) {
		var html='';
	   for(var i=0;i<data.length;i++){
		   var row=data[i];
		   var status = row.status;
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
		   var j=0;
		   html += `<tr>
						<th scope="row">`+(++j)+`</th>
						<td>`+row.mobile+`</td>
						<td>`+row.reason+`</td>
						<td>`+row.address+`</td>
						<td><button onclick="updatestatus(`+row.id+`,`+row.status+`)" type="submit" class="btn btn-success">`+dstatus+`</button></td>                     
					</tr>`;
		   
	   }
		$("#body3").html(html);
		
	});
}

function updatestatus(id,status){
	if(status<5){
	$.ajax({
        type: "GET",
        url: "http://localhost:8080/api/complaint_action/" + encodeURIComponent(id) + "/" + (status+1)
    }).done(function (data) {
        alert(data)
         initiate();
	});
}
}
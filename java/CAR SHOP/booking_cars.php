<?php
header("Access-Control-Allow-Origin: *");
	$servername = "localhost";
	$username = "root";
	$password = "";
	$dbname = "car";

	
	
	// Create connection
	$conn = new mysqli($servername, $username, $password, $dbname);
	// Check connection
	if ($conn->connect_error) {
	  die("Connection failed: " . $conn->connect_error);
	}

	$sql = "SELECT customer.fname,customer.lname,customer.mobile,car.cname,car.model,car.price,booking.expected,booking.suggest FROM `booking` left join customer on (customer.id=booking.cusid) LEFT join car on (car.id=booking.cid)";
	$sth = mysqli_query($conn, $sql);
	$rows = array();
	while($r = mysqli_fetch_assoc($sth)) {
		$rows[] = $r;
	}
	print json_encode($rows);
	

	$conn->close();
?>
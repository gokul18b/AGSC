<?php
header("Access-Control-Allow-Origin: *");
	$servername = "localhost";
	$username = "root";
	$password = "";
	$dbname = "car";

	$cusid = $_GET['cusid'];
	$cid = $_GET['cid'];
	$expected = $_GET['expected'];
	$suggested = $_GET['suggested'];
	
	
	// Create connection
	$conn = new mysqli($servername, $username, $password, $dbname);
	// Check connection
	if ($conn->connect_error) {
	  die("Connection failed: " . $conn->connect_error);
	}

	$sql = "INSERT INTO `booking` (`id`, `cid`, `cusid`,`expected`,`suggest`) VALUES (NULL, $cid, $cusid,'$expected','$suggested')";

	if ($conn->query($sql) === TRUE) {
	  echo "Customer Booking Successfully completed";
	} else {
	  echo "Error: " . $sql . "<br>" . $conn->error;
	}

	$conn->close();
?>
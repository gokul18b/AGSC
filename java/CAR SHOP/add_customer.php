<?php
	$servername = "localhost";
	$username = "root";
	$password = "";
	$dbname = "car";

	$fname = $_GET['fname'];
	$lname = $_GET['lname'];
	$emailid = $_GET['emailid'];
	$password = $_GET['password'];
	$mobile = $_GET['mobile'];
	
	// Create connection
	$conn = new mysqli($servername, $username, $password, $dbname);
	// Check connection
	if ($conn->connect_error) {
	  die("Connection failed: " . $conn->connect_error);
	}

	$sql = "INSERT INTO `customer` (`id`, `fname`, `lname`, `email`, `password`, `mobile`) VALUES (NULL, '$fname', '$lname', '$emailid', '$password', '$mobile');";
	if ($conn->query($sql) === TRUE) {
	  echo "Customer Registration Successfully completed";
	} else {
	  echo "Error: " . $sql . "<br>" . $conn->error;
	}

	$conn->close();
?>
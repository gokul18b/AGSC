<?php
header("Access-Control-Allow-Origin: *");
	$servername = "localhost";
	$username = "root";
	$password = "";
	$dbname = "car";

	$bname = $_GET['bname'];
	$carname = $_GET['carname'];
	$model = $_GET['model'];
	$engine = $_GET['engine'];
	$width = $_GET['width'];
	$height = $_GET['height'];
	$price = $_GET['price'];
	$year = $_GET['year'];
	
	// Create connection
	$conn = new mysqli($servername, $username, $password, $dbname);
	// Check connection
	if ($conn->connect_error) {
	  die("Connection failed: " . $conn->connect_error);
	}

	$sql = "INSERT INTO `car` (`id`, `bname`, `cname`, `model`, `engine`, `width`, `height`, `year`,`price`) VALUES (NULL, '$bname', '$carname', '$model', '$engine', '$width', '$height', '$year', '$price');";
	if ($conn->query($sql) === TRUE) {
	  echo "Customer Registration Successfully completed";
	} else {
	  echo "Error: " . $sql . "<br>" . $conn->error;
	}

	$conn->close();
?>
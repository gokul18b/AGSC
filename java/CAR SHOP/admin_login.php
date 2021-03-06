<?php
header("Access-Control-Allow-Origin: *");
	$servername = "localhost";
	$username = "root";
	$password = "";
	$dbname = "car";

	$uname = $_GET['username'];
	$pass = $_GET['password'];
	
	// Create connection
	$conn = new mysqli($servername, $username, $password, $dbname);
	// Check connection
	if ($conn->connect_error) {
	  die("Connection failed: " . $conn->connect_error);
	}

	$sql = "select * from admin where username='$uname' and password='$pass'";
	$sth = mysqli_query($conn, $sql);

	$row=mysqli_num_rows($sth);
	if($row>0){
		echo 'admin';
	} else{
		$sql1 = "select * from customer where email='$uname' and password='$pass'";
		$sth1 = mysqli_query($conn, $sql1);
		$row1=mysqli_num_rows($sth1);
		
		if($row1>0){
			
			while($r = mysqli_fetch_assoc($sth1)) {
				
				echo 'id='.$r['id'];
			}
			
		} else{
			echo 'Invalid';
		}
	}
	
	

	$conn->close();
?>
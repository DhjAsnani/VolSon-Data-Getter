<?php
require "init.php";
$name = $_POST["user"];
$user_name = $_POST["user_name"];
$user_pass = $_POST["user_pass"];

$query = "insert into user_info values('$name','$user_name','$user_pass');";
if(mysqli_query($conn,$query)){
  echo "<h3>Data insertion success..</h3";
}
else {
  echo "Error..".mysqli_error($conn);
}
 ?>

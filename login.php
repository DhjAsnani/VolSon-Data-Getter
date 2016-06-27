<?php
require 'init.php';
$user_name = $_POST['login_name'];
$user_pass = $_POST['login_pass'];
$query = "select user from user_info where user_name like '$user_name' and user_pass like '$user_pass';";
//echo "$query";
$result = mysqli_query($conn,$query);

if($result){
if(mysqli_num_rows($result)>0)
{
  $row = mysqli_fetch_assoc($result);
  $name = $row["user"];
  echo "Logged in, welcome $name";
}
else {
  echo "Invalid username or password";
}
}
 ?>

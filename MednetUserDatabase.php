<!--MednetUserDatabase4350.php-->
<xml version = "1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN"
"http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">

<html xmlns = "http://www.w3.org/1999/xhtml">
<head>
	<title>Daniel Sepe</title>
	<h3>Mednet User Database</h3>
</head>
<body>

<?php

$lnk = mysqli_connect("localhost", "Daniel", "password");
if (!$lnk) {
	die("Not Connected: " . mysqli_connect_error($lnk)) . '<br /';
}

if (mysqli_query($lnk,"CREATE DATABASE userBase")) {
	echo "Database created successfully!" . '<br />';
} else echo "Error: " . mysqli_error($lnk) . '<br />';

mysqli_select_db($lnk,"userBase");

$sql = "CREATE TABLE userInfoTable (
firstName varchar(30),
lastName varchar(30),
email varchar(30),
password varchar(30),
contactNumber varchar(10),
userKey varchar(20),
userType varchar(3),
securityInt int, -- question number (1,2,3,etc.)
securityAnswer varchar(30)
)";

if (mysqli_query($lnk,$sql)) {
	echo "Table created succesfully!" . '<br />';
} else echo "Error: " . mysqli_error($lnk) . '<br />';

if (mysqli_error($lnk)) echo "Error: User info has already been entered." . '<br />';
else {
	$info = "	INSERT INTO userInfoTable
							(firstName,lastName,email,password,contactNumber,userKey,userType,securityInt,securityAnswer)
				VALUES
							('Daniel','Sepe','dsepejr@gmail.com','somePassword','4044886817','0000001','No','1','Hot Pockets'),
							('Christopher','Luu','christoperdhluu@gmail.com','somePassword','1112221234','0000002','No','1','Lean Pockets'),
							('Jakub','Pietrasik','jakub.pietrasik.8@gmail.com','somePassword','2223334567','0000003','No','1','Pockets To-Go'),
							('Justin','Phung','justin.phung123@gmail.com','somePassword','3334445678','0000004','No','1','Crisp Pockets'),
							('Eric','Qiu','qiuzijie@gmail.com','somePassword','4445556789','0000005','No','1','Rocket Pockets')
			";
}

echo '<table border = 1>
	<tr>
		<th>First Name</th>
		<th>Last Name</th>
		<th>Email</th>
		<th>Password</th>
		<th>Contact Number</th>
		<th>Unique User Key</th>
		<th>Physician?</th>
		<th>Security Question #</th>
		<th>Security Answer</th>
	</tr>';

if (mysqli_query($lnk,$info)) {
	echo "User info added successfully!" . '<br />';
}

$selectData = "SELECT * FROM userInfoTable";
$myData = mysqli_query($lnk,$selectData);
while ($record = mysqli_fetch_array($myData)) {
	echo '<tr>';
	echo '<td>' . $record['firstName'] . '</td>';
	echo '<td>' . $record['lastName'] . '</td>';
	echo '<td>' . $record['email'] . '</td>';
	echo '<td>' . $record['password'] . '</td>';
	echo '<td>' . $record['contactNumber'] . '</td>';
	echo '<td align=middle>' . $record['userKey'] . '</td>';
	echo '<td align=middle>' . $record['userType'] . '</td>';
	echo '<td align=middle>' . $record['securityInt'] . '</td>';
	echo '<td>' . $record['securityAnswer'] . '</td>';
	echo '</tr>';
}
echo '</table>';

mysqli_close($lnk);

?>

<br />

</body>
</html>

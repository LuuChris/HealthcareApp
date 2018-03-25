<xml version = "1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN"
"http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">

<html xmlns = "http://www.w3.org/1999/xhtml">
<head>
	<title>Daniel Sepe</title>
	<h3>Mednet Patient Database</h3>
</head>
<body>

<?php

$lnk = mysqli_connect("localhost", "Daniel", "password");
if (!$lnk) {
	die("Not Connected: " . mysqli_connect_error($lnk)) . '<br /';
}

if (mysqli_query($lnk,"CREATE DATABASE patientBase")) {
	echo "Database created successfully!" . '<br />';
} else echo "Error: " . mysqli_error($lnk) . '<br />';

mysqli_select_db($lnk,"patientBase");

$sql = "CREATE TABLE patientInfoTable (
age varchar(3),
gender varchar(6),
address varchar(50),
ethnicity varchar(30),
medicalConditions varchar(30),
allergies varchar(50),
userKey varchar(20)
)";

if (mysqli_query($lnk,$sql)) {
	echo "Table created succesfully!" . '<br />';
} else echo "Error: " . mysqli_error($lnk) . '<br />';

if (mysqli_error($lnk)) echo "Error: Patient information has already been made." . '<br />';
else {
	$info = "	INSERT INTO patientInfoTable
							(userKey,age,gender,address,ethnicity,medicalConditions,allergies)
				VALUES
							('0000010','100','Male','123 Santa Claus Way','Caucasian','none','spoiled children')
			";
}

echo '<table border = 1>
	<tr>
		<th>User Key</th>
		<th>Age</th>
		<th>Gender</th>
		<th>Address</th>
		<th>Ethnicity</th>
		<th>Medical Conditions</th>
		<th>Allergies</th>
	</tr>';

if (mysqli_query($lnk,$info)) {
	echo "Player info added successfully!" . '<br />';
}// else echo "Error: " . mysqli_error($lnk) . '<br />';

$selectData = "SELECT * FROM patientInfoTable";
$myData = mysqli_query($lnk,$selectData);
while ($record = mysqli_fetch_array($myData)) {
	echo '<tr>';
	echo '<td>' . $record['userKey'] . '</td>';
	echo '<td>' . $record['age'] . '</td>';
	echo '<td>' . $record['gender'] . '</td>';
	echo '<td>' . $record['address'] . '</td>';
	echo '<td>' . $record['ethnicity'] . '</td>';
	echo '<td>' . $record['medicalConditions'] . '</td>';
	echo '<td>' . $record['allergies'] . '</td>';
	echo '</tr>';
}
echo '</table>';

mysqli_close($lnk);

?>

</body>
</html>

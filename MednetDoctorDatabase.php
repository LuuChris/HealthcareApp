<!--MednetDoctorDatabase4350.php-->
<xml version = "1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN"
"http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">

<html xmlns = "http://www.w3.org/1999/xhtml">
<head>
	<title>Daniel Sepe</title>
	<h3>Mednet Doctor Database</h3>
</head>
<body>

<?php

$lnk = mysqli_connect("localhost", "Daniel", "password");
if (!$lnk) {
	die("Not Connected: " . mysqli_connect_error($lnk)) . '<br /';
}

if (mysqli_query($lnk,"CREATE DATABASE doctorBase")) {
	echo "Database created successfully!" . '<br />';
} else echo "Error: " . mysqli_error($lnk) . '<br />';

mysqli_select_db($lnk,"doctorBase");

$sql = "CREATE TABLE doctorInfoTable (
userKey varchar(10),
specialty varchar(30),
insurance varchar(30),
workAvailStart varchar(4),
workAvailEnd varchar(4)
)";

if (mysqli_query($lnk,$sql)) {
	echo "Table created succesfully!" . '<br />';
} else echo "Error: " . mysqli_error($lnk) . '<br />';

if (mysqli_error($lnk)) echo "Error: Doctor info has already been entered." . '<br />';
else {
	$info = "	INSERT INTO doctorInfoTable
							(userKey,specialty,insurance,workAvailStart,workAvailEnd)
				VALUES
							('0000010','gift-giving','GlobalUnited','0000','2359')
			";
}

echo '<table border = 1>
	<tr>
		<th>User Key</th>
		<th>Specialty</th>
		<th>Insurance</th>
		<th>Work Availability (Start Time)</th>
		<th>Work Availability (End Time)</th>
	</tr>';

if (mysqli_query($lnk,$info)) {
	echo "Doctor info added successfully!" . '<br />';
}

$selectData = "SELECT * FROM doctorInfoTable";
$myData = mysqli_query($lnk,$selectData);
while ($record = mysqli_fetch_array($myData)) {
	echo '<tr>';
	echo '<td>' . $record['userKey'] . '</td>';
	echo '<td>' . $record['specialty'] . '</td>';
	echo '<td>' . $record['insurance'] . '</td>';
	echo '<td align=middle>' . $record['workAvailStart'] . '</td>';
	echo '<td align=middle>' . $record['workAvailEnd'] . '</td>';
	echo '</tr>';
}
echo '</table>';

mysqli_close($lnk);

?>

<br />

</body>
</html>

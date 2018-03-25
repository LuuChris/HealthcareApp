<!--Assignment8DisplayDatabase.php-->
<xml version = "1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN"
"http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">

<html xmlns = "http://www.w3.org/1999/xhtml">
<head>
	<title>Daniel Sepe</title>
	<h3>Mednet Ticket Database</h3>
</head>
<body>

<?php

$lnk = mysqli_connect("localhost", "Daniel", "password");
if (!$lnk) {
	die("Not Connected: " . mysqli_connect_error($lnk)) . '<br /';
}

if (mysqli_query($lnk,"CREATE DATABASE ticketBase")) {
	echo "Database created successfully!" . '<br />';
} else echo "Error: " . mysqli_error($lnk) . '<br />';

mysqli_select_db($lnk,"ticketBase");

$sql = "CREATE TABLE ticketInfoTable (
ticketID varchar(10),
dateCreated varchar(8),
description varchar(30)
)";

if (mysqli_query($lnk,$sql)) {
	echo "Table created succesfully!" . '<br />';
} else echo "Error: " . mysqli_error($lnk) . '<br />';

if (mysqli_error($lnk)) echo "Error: Ticket info has already been entered." . '<br />';
else {
	$info = "	INSERT INTO ticketInfoTable
							(ticketID,dateCreated,description)
				VALUES
							('1','03232018','someDescription'),
							('2','03242018','someDescription')
			";
}

echo '<table border = 1>
	<tr>
		<th>Ticket ID</th>
		<th>Date Created</th>
		<th>Description</th>
	</tr>';

if (mysqli_query($lnk,$info)) {
	echo "Ticket info added successfully!" . '<br />';
}

mysqli_select_db($lnk,"ticketBase");

$selectData = "SELECT * FROM ticketInfoTable";
$myData = mysqli_query($lnk,$selectData);
while ($record = mysqli_fetch_array($myData)) {
	echo '<tr>';
	echo '<td align=middle>' . $record['ticketID'] . '</td>';
	echo '<td>' . $record['dateCreated'] . '</td>';
	echo '<td>' . $record['description'] . '</td>';
	echo '</tr>';
}
echo '</table>';

mysqli_close($lnk);

?>

<br />

</body>
</html>

<html>
	<head>
		<meta http-equiv='refresh' content='3' />
	</head>
	<body>
	<?php
		//read the student.txt file content, put them on a table
		$filename='student.txt';
		if(file_exists($filename)){
			//open the file
			$file=file($filename);
			echo '<table border width=100%>';
				foreach($file as $record){
					$fields=explode(",",$record);
					echo '<tr>';
						foreach($fields as $f){
							echo '<td>'.$f.'</td>';
						}
					echo '</tr>';
				}
			echo '</table>';		
		}
	?>	
	</body>
</html>
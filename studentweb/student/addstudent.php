<?php	//scriptlet tag

	//this script, accepts querystring data(add-on data on the URL)
	//check if there are actually arriving from the client
	
	if(!empty($_GET['idno']) && !empty($_GET['name'])){
	
		$idno=$_GET['idno'];
		$name=$_GET['name'];
		$course=$_GET['course'];
		$year=$_GET['year'];
		
	//open or create a text file to save the data
	
		$file=fopen("student.txt","a");	//a=append new data to old data
		fwrite($file,$idno);
		//add a delimiter(character separator)
		fwrite($file,",");
		fwrite($file,$name);
		//add a delimiter(character separator)
		fwrite($file,",");
		fwrite($file,$course);
		//add a delimiter(character separator)
		fwrite($file,",");
		fwrite($file,$year);
		//add a record delimiter(character separator)
		fwrite($file,"\n");
		
		fclose($file);
		
	
		echo 'New Student added'; //send reply to client
	}
	else echo 'Please fill all fields'; //send reply to client
	
?>


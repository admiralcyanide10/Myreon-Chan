package com.example.jsonparsing;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class addStudent extends Activity implements OnClickListener, OnItemSelectedListener {

	EditText idno, givenname,familyname;
	Spinner course, yearlevel, campus;
	Button submit;
	String selectedCourse;
	String selectedYearlevel;
	String selectedCampus;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.addstudento);
		

		this.submit = (Button)findViewById(R.id.button1);
		this.idno = (EditText)findViewById(R.id.idno);
		this.givenname = (EditText)findViewById(R.id.givenname);
		this.familyname = (EditText)findViewById(R.id.familyname);
		this.course = (Spinner)findViewById(R.id.course);
		this.yearlevel = (Spinner)findViewById(R.id.yearlevel);
		this.campus = (Spinner)findViewById(R.id.campus);
		
		this.course.setOnItemSelectedListener(new OnItemSelectedListener(){

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				selectedCourse = course.getItemAtPosition(arg2).toString();	
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}});
		
		this.yearlevel.setOnItemSelectedListener(new OnItemSelectedListener(){

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				selectedYearlevel = yearlevel.getItemAtPosition(arg2).toString();
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}});
		this.campus.setOnItemSelectedListener(new OnItemSelectedListener(){

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				selectedCampus = campus.getItemAtPosition(arg2).toString();
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}});
		
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		StrictMode.setThreadPolicy(policy);	
		this.submit.setOnClickListener(this);
			
		
	}


	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
		String idno = this.idno.getText().toString();
		String givenname = this.givenname.getText().toString();
		String familyname = this.familyname.getText().toString();
		
		
		try {
			URL url = new URL("http://10.0.2.2/mywebapp/addstudent.php?idno="+idno+"&fname="+familyname+"&lname="+givenname+"&course="+this.selectedCourse+"&year="+this.selectedYearlevel+"&campus="+this.selectedCampus);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			
			InputStream is = conn.getInputStream();
			int c = 0;
			StringBuffer sb = new StringBuffer();
			while((c=is.read())!=-1)
			{
				sb.append((char)c);
			}
			is.close();
			conn.disconnect();
			Toast.makeText(this, "Student Added",Toast.LENGTH_LONG).show();
			startActivity(new Intent(this, MainActivity.class));
		
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}



	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
//		// TODO Auto-generated method stub
//		int id = arg1.getId();
//
//		switch(id)
//	{
//		case R.id.course:
//			
//		
//			break;
//			
//		case R.id.yearlevel:
//			
//			
//		case R.id.campus:
//			
//		}
	}



	

/*
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		return super.onOptionsItemSelected(item);
		
		
		
	}*/





	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}

	
}

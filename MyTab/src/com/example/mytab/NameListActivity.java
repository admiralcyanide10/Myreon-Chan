package com.example.mytab;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class NameListActivity extends Activity {
	
	ListView lv;
	ArrayList<String> list=new ArrayList<String>();
	ArrayAdapter<String> adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.namelist);
		
		list.add("Alpha");
		list.add("Bravo");
		list.add("Charlie");
		list.add("Delta");
		
		adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1);
		this.lv=(ListView) this.findViewById(R.id.listView1);
		this.lv.setAdapter(adapter);
	}

}

package com.example.midtermlab;

import java.util.ArrayList;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ListView;

public class MainActivity extends Activity {

	ListView lv;
	ArrayList<Person> list=new ArrayList<Person>();
	MyAdapter adapter;
	PersonDatabase db;
	AdapterView.AdapterContextMenuInfo info;
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        db=new PersonDatabase(this);
        
        if(db.getCount()>0){
        	list=db.getAllPerson();
        }
        
 
        this.lv=(ListView) this.findViewById(R.id.listView1);
        this.adapter=new MyAdapter(this,list);
        this.lv.setAdapter(adapter);
        
        this.registerForContextMenu(lv);
    
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		Intent intent=new Intent(this,UpdatePerson.class);
		this.startActivityForResult(intent, 0);
		return super.onOptionsItemSelected(item);
	}
	

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		// TODO Auto-generated method stub
		super.onCreateContextMenu(menu, v, menuInfo);
		info=(AdapterContextMenuInfo) menuInfo;
		getMenuInflater().inflate(R.menu.contextmenu, menu);
		String name=list.get(info.position).getName();
		menu.setHeaderTitle(name);
	}

	
	
	@Override
	public boolean onContextItemSelected(MenuItem item) {
		int id=item.getItemId();
		switch(id){
		case R.id.update: 
			Person itemSelected=list.get(info.position);
			Intent intent=new Intent(this,UpdateActivity.class);
			this.startActivityForResult(intent,1);
			
			
			break;
		case R.id.delete:
			list.remove(info.position);
			adapter.notifyDataSetChanged();
		}
		return super.onContextItemSelected(item);
	}


	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		
		if(requestCode==0 && resultCode==Activity.RESULT_OK){
			
			Bundle b=data.getExtras();
			
			Uri uri=b.getParcelable("image");
			String name=b.getString("name");
			
			switch(requestCode){
			
			case 0:
				list.add(new Person(uri, name));	
				break;
			case 1:			
			}
											
		
			db.addPerson(uri.toString(), name);
			this.adapter.notifyDataSetChanged();
			
		}
		
	}
    
	
}

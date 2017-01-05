package com.example.listview3;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnItemClickListener{
	
	ListView lv;
	ArrayList<Student> list=new ArrayList<Student>();
	ArrayList<String> source=new ArrayList<String>();
	ArrayList<String> list2=new ArrayList<String>();
	ArrayAdapter<String> adapter2;
    MyAdapter adapter;
	EditText txtSearch;
	
	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        lv=(ListView) this.findViewById(R.id.listView1);
        this.lv.setOnItemClickListener(this);
        
        list.add(new Student(R.drawable.img1,"Alpha, Bravo","BSIT"));
        list.add(new Student(R.drawable.img2,"Charlie, Hotel","BSCOA"));
        list.add(new Student(R.drawable.img3,"Mike, India","BSCREAM"));
        list.add(new Student(R.drawable.img4,"November, Kilo","BSHRM"));
        list.add(new Student(R.drawable.img5,"Oscar, Quebec","BSE"));
        list.add(new Student(R.drawable.img6,"Zulu, Uniform","AB"));
        list.add(new Student(R.drawable.img7,"Delta, Tango","BSA"));
        list.add(new Student(R.drawable.img8,"Juliet, Sierra","BSBA"));
      
        adapter=new MyAdapter(this,list);
        this.lv.setAdapter(adapter);
        
        this.txtSearch=(EditText) this.findViewById(R.id.editText1);
        this.lv=(ListView) this.findViewById(R.id.listView1);
        this.adapter2=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1);
        
        this.source.add("alpha");
        this.source.add("bravo");
        this.source.add("charlie");
        this.source.add("delta");
        this.source.add("echo");
        this.source.add("foxtrot");
        this.source.add("golf");
        this.source.add("hotel");
        this.source.add("india");
        this.source.add("juliet");
        this.source.add("kilo");
        this.source.add("lenovo");
        this.source.add("mike");
        this.source.add("november");
        this.source.add("oscar");
        this.source.add("panasonic");
        this.source.add("quebec");
        this.source.add("rodeo");
        this.source.add("sierra");
        this.source.add("tango");
        this.source.add("uniform");
        this.source.add("violet");
        this.source.add("william");
        this.source.add("xerox");
        this.source.add("yoyo");
        this.source.add("zulu");

        
        this.txtSearch.addTextChangedListener(new TextWatcher(){

			@Override
			public void afterTextChanged(Editable arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void beforeTextChanged(CharSequence arg0, int arg1,
					int arg2, int arg3) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onTextChanged(CharSequence arg0, int arg1, int arg2,
					int arg3) {
				// TODO Auto-generated method stub
				
				list.clear();	
				
				Pattern p=Pattern.compile(arg0.toString());
				for(int i=0;i<source.size();i++){
					Matcher m=p.matcher(source.get(i));
						if(m.find()){
							list2.add(source.get(i));		
						}
						adapter.notifyDataSetChanged();
				}
				
			}});
        

        

    }



	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
			AlertDialog.Builder builder=new AlertDialog.Builder(this);
				builder.setTitle(list.get(arg2).getStudentName());
				
				ImageView myiv=new ImageView(this);
					myiv.setImageResource(list.get(arg2).getImage());
				TextView myname=new TextView(this);
					myname.setText(list.get(arg2).getStudentName());
				TextView mycourse=new TextView(this);
					mycourse.setText(list.get(arg2).getCourse());
				
				LinearLayout mainLayout=new LinearLayout(this);	
						mainLayout.setOrientation(LinearLayout.HORIZONTAL);
						mainLayout.addView(myiv);
						
				LinearLayout subLayout=new LinearLayout(this);
					subLayout.setOrientation(LinearLayout.VERTICAL);
					subLayout.addView(myname);
					subLayout.addView(mycourse);
					
					mainLayout.addView(subLayout);
					
					builder.setView(mainLayout);
					builder.setNeutralButton("Okey", null);
					
			AlertDialog dialog=builder.create();
				dialog.show();
			
					
			String s=this.lv.getItemAtPosition(arg2).toString();
			Toast.makeText(this, s, Toast.LENGTH_SHORT).show();		
			}
		
	}
    
    

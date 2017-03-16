package com.example.prefinalreq;

import android.os.Bundle;
import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.view.Menu;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class MainActivity extends TabActivity {
	TabHost tabhost;
	private static final String Tab1 = "List";
    private static final String Tab2 = "Add";
    private static final String Tab3 = "About";
	@Override
    protected void onCreate(Bundle savedInstanceState) {
    	
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabhost = this.getTabHost();
        
        Intent intentL = new Intent(this,List.class);
        Intent intentA = new Intent(this,Add.class);
        Intent intentAb = new Intent(this,About.class);
        
        TabSpec namelist = tabhost.newTabSpec("namelist");
        	namelist.setIndicator("", getResources().getDrawable(R.drawable.gallery));
        	namelist.setContent(intentL);
        	
        TabSpec addlist = tabhost.newTabSpec("addlist");	
        	addlist.setIndicator("", getResources().getDrawable(R.drawable.add));
        	addlist.setContent(intentA);
        	
        TabSpec aboutlist = tabhost.newTabSpec("aboutlist");
        	aboutlist.setIndicator("", getResources().getDrawable(R.drawable.info));
        	aboutlist.setContent(intentAb);	
        	 
        	
        tabhost.addTab(namelist);	
        tabhost.addTab(addlist);
        tabhost.addTab(aboutlist);
        
        
    }
		
    
}

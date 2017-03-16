package com.example.midtermlab;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;

public class PersonDatabase extends SQLiteOpenHelper {
	
	static String DB="db_person";
	static String PERSON="tbl_person";

	public PersonDatabase(Context context){
		super(context, DB, null, 1);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String sql="CREATE TABLE "+PERSON+" (id integer primary key autoincrement,imageuri varchar(50),name varchar(50))";
		db.execSQL(sql);
	}
	
	public long addPerson(String imageuri,String name){
		long result=0;
			ContentValues cv=new ContentValues();
			cv.put("imageuri", imageuri);
			cv.put("name", name);
		SQLiteDatabase db=this.getWritableDatabase();
			result=db.insert(PERSON, null, cv);
			db.close();
		return result;	
	}
	
	public int updatePerson(String imageuri,String name){
		int result=0;
			ContentValues cv=new ContentValues();
			cv.put("imageuri", imageuri);
			cv.put("name", name);
		SQLiteDatabase db=this.getWritableDatabase();
			result=db.update(PERSON, cv, "where name=?", new String[]{"name"});
			db.close();
		return result;	
	}
	
	public int deletePerson(String name){
		int result=0;
		SQLiteDatabase db=this.getWritableDatabase();
		result=db.delete(PERSON, "where name=?", new String[]{"name"});
		return result;
	}
	
	public ArrayList<Person> getAllPerson(){
		ArrayList<Person> list=new ArrayList<Person>();
		SQLiteDatabase db=this.getWritableDatabase();
			Cursor c=db.query(PERSON, null, null, null, null, null, "name");
				c.moveToFirst();
				while(!c.isAfterLast()){
					String imageuri=c.getString(c.getColumnIndex("imageuri"));
					String name=c.getString(c.getColumnIndex("name"));
					
					Uri image=Uri.parse(imageuri);
					
					Person p=new Person(image,name);
					list.add(p);
					c.moveToNext();
				}
		return list;
	}
	
	public int getCount(){
		return this.getAllPerson().size();
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {

	}

}

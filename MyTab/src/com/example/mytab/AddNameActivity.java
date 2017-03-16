package com.example.mytab;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class AddNameActivity extends Activity implements OnClickListener {

	EditText txtName;
	Button btnOk,btnCancel;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.addname);
		
		this.txtName=(EditText) this.findViewById(R.id.editText1);
		this.btnOk=(Button) this.findViewById(R.id.button1);
		this.btnCancel=(Button) this.findViewById(R.id.button2);
		
		this.btnOk.setOnClickListener(this);
		this.btnCancel.setOnClickListener(this);
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		int id=arg0.getId();
		switch(id){
		case R.id.button1: 
			String name=this.txtName.getText().toString();
			break;
		case R.id.button2: 
			this.txtName.setText("");
			this.txtName.requestFocus();
		
		}
	}
	
}

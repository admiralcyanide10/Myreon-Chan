package com.example.jsonparsing;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.example.jsonparsing.R;
import com.example.jsonparsing.R.id;
import com.example.jsonparsing.R.layout;
import com.example.jsonparsing.R.menu;

import android.os.Bundle;
import android.os.StrictMode;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class login extends Activity implements OnClickListener {

	
	EditText txtUsername, pwdPassword;
	Button btnLogin;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginlayout);
        
        
        this.txtUsername = (EditText)this.findViewById(R.id.username);
        this.pwdPassword = (EditText)this.findViewById(R.id.password);
        this.btnLogin = (Button)this.findViewById(R.id.button1);
        
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        
        this.btnLogin.setOnClickListener(this);
        
    }


	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
		String username = this.txtUsername.getText().toString();
		String password = this.pwdPassword.getText().toString();
		
		try {
			URL url = new URL("http://10.0.2.2/mywebapp/login.php?username=" + username + "&password="+password);
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
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setTitle("http response");
			builder.setMessage(sb.toString());
			
			AlertDialog dialog = builder.create();
			dialog.show();
			
			if(sb.toString().equals("Login Accept") || sb.toString().equals("Login Accepted"))
			{
				Intent intent = new Intent(this, MainActivity.class);
				this.startActivity(intent);
			}
			
			
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.txtUsername.setText("");
		this.pwdPassword.setText("");
		this.txtUsername.requestFocus();
	}

    
}
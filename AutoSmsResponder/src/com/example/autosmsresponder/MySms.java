package com.example.autosmsresponder;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class MySms extends BroadcastReceiver implements LocationListener {
	private LocationManager locman;
	private Criteria criteria;
	private String provider;
	private Location location;
	
	@Override
	public void onReceive(Context arg0, Intent arg1) {
		// TODO Auto-generated method stub
		try {
			Bundle b=arg1.getExtras();
			String senderaddress="", message="";
			
			Object[] pdus=(Object[]) b.get("pdus");
			for(int i=0; i < pdus.length; i++){
				SmsMessage sms=SmsMessage.createFromPdu((byte[])pdus[i]);
				 senderaddress=sms.getDisplayOriginatingAddress().toString();
				 message=sms.getDisplayMessageBody().toString();
			}
			message=message.toLowerCase();
			if(message.equals("pauli na")){
				locman=(LocationManager) arg0.getSystemService(Context.LOCATION_SERVICE);
				criteria=new Criteria();
				
				criteria.setAccuracy(Criteria.ACCURACY_MEDIUM);
				criteria.setPowerRequirement(Criteria.ACCURACY_MEDIUM);
					
				provider = locman.getBestProvider(criteria, false);
				locman.requestLocationUpdates(provider, 1, 10, this);
				
				location = locman.getLastKnownLocation(provider);
				
				Toast.makeText(arg0, "Sender: "+senderaddress+" Message: "+message, Toast.LENGTH_LONG).show();				
				SmsManager smsm = SmsManager.getDefault();
				String lat = String.format("%.5f", location.getLatitude());
				String lng = String.format("%.5f", location.getLongitude());
				smsm.sendTextMessage(senderaddress, null, "Latitude: "+lat+"\nLongtitude: "+lng, null, null);
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void onLocationChanged(Location arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onProviderDisabled(String arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onProviderEnabled(String arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onStatusChanged(String arg0, int arg1, Bundle arg2) {
		// TODO Auto-generated method stub
		
	}

}

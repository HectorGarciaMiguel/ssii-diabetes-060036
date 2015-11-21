package com.example.seguimientodiabetes;


	 
	import android.content.BroadcastReceiver;
	import android.content.Context;
	import android.content.Intent;
	 
	public class Alarma extends BroadcastReceiver{
	      
	    @Override
	    public void onReceive(Context context, Intent intent)
	    {
	       Intent service1 = new Intent(context, NotificacionAlarma.class);
	       context.startService(service1);
	        
	    }   
	}
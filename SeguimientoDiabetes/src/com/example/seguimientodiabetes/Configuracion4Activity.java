package com.example.seguimientodiabetes;

import java.util.Calendar;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RemoteViews;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import com.seguimientodiabetes.seguimientodiabetes.R;

public class Configuracion4Activity extends Activity {

	TextView  ayunasHora, actividadMatutinaHora, antesComerHora, despuesComerHora, actividadVespertinaHora, antesCenarHora, nocheHora;
	CheckBox ayunasBox, actividadMatutinaBox, antesComerBox, despuesComerBox, actividadVespertinaBox, antesCenarBox, nocheBox;
		
	private int hora, minuto;
	
    static final int TIME_DIALOG_ID = 0;
    int picker = 0;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_configuracion4);
		
		
		ayunasHora = (TextView)findViewById(R.id.TextView1);
		actividadMatutinaHora = (TextView)findViewById(R.id.TextView2);
		antesComerHora = (TextView)findViewById(R.id.TextView3);
		despuesComerHora = (TextView)findViewById(R.id.TextView4);
		actividadVespertinaHora = (TextView)findViewById(R.id.TextView5);
		antesCenarHora = (TextView)findViewById(R.id.TextView6);
		nocheHora = (TextView)findViewById(R.id.TextView7);

		ayunasBox = (CheckBox)findViewById(R.id.CheckBox06);
		actividadMatutinaBox = (CheckBox)findViewById(R.id.CheckBox05);
		antesComerBox = (CheckBox)findViewById(R.id.CheckBox03);
		despuesComerBox = (CheckBox)findViewById(R.id.CheckBox02);
		actividadVespertinaBox = (CheckBox)findViewById(R.id.CheckBox01);
		antesCenarBox = (CheckBox)findViewById(R.id.CheckBox07);
		nocheBox = (CheckBox)findViewById(R.id.CheckBox04);
		
		/*****Escuchadores de textview hora***************************************************************************/
		
		ayunasHora.setOnClickListener(new View.OnClickListener() {
	        @SuppressWarnings("deprecation")
			public void onClick(View v) {
	        	picker = 1;
	        	Bundle args = new Bundle(); 
		       	args.putInt("hora", 06);	args.putInt("minuto", 00);
		       	showDialog(TIME_DIALOG_ID, args);	        }
	    });
		
		
		actividadMatutinaHora.setOnClickListener(new View.OnClickListener() {
			 @SuppressWarnings("deprecation")
				public void onClick(View v) {
		        	picker = 2;
		        	Bundle args = new Bundle(); 
		       		args.putInt("hora", 10);	args.putInt("minuto", 00);
		       		showDialog(TIME_DIALOG_ID, args);		        }
		    });
		
		
		antesComerHora.setOnClickListener(new View.OnClickListener() {
			 @SuppressWarnings("deprecation")
				public void onClick(View v) {
		        	picker = 3;
		        	Bundle args = new Bundle(); 
		       		args.putInt("hora", 13);	args.putInt("minuto", 30);
		       		showDialog(TIME_DIALOG_ID, args);		        }
		    });
		
		
		despuesComerHora.setOnClickListener(new View.OnClickListener() {
			 @SuppressWarnings("deprecation")
				public void onClick(View v) {
		        	picker = 4;
		        	Bundle args = new Bundle(); 
			       	args.putInt("hora", 15);	args.putInt("minuto", 00);
			       	showDialog(TIME_DIALOG_ID, args);		        }
		    });
		
		
		actividadVespertinaHora.setOnClickListener(new View.OnClickListener() {
			 @SuppressWarnings("deprecation")
				public void onClick(View v) {
		        	picker = 5;
		        	Bundle args = new Bundle(); 
		       		args.putInt("hora", 16);	args.putInt("minuto", 30);
		       		showDialog(TIME_DIALOG_ID, args);		        }
		    });
		
		
		
		antesCenarHora.setOnClickListener(new View.OnClickListener() {
			 @SuppressWarnings("deprecation")
				public void onClick(View v) {
		        	picker = 6;
		        	Bundle args = new Bundle(); 
			       	args.putInt("hora", 20);	args.putInt("minuto", 30);
		        	showDialog(TIME_DIALOG_ID, args);
		        }
		    });
		
		
		nocheHora.setOnClickListener(new View.OnClickListener() {
			 @SuppressWarnings("deprecation")
				public void onClick(View v) {
		        	picker = 7;
		        	Bundle args = new Bundle(); 
			       	args.putInt("hora", 22);	args.putInt("minuto", 30);
		        	showDialog(TIME_DIALOG_ID, args);
		        }
		    });
		
		
		/*********Escuchadores de box ***********************************************************/
		
		ayunasBox.setOnClickListener(new View.OnClickListener() {
			 @SuppressWarnings("deprecation")
				public void onClick(View v) {
		        	if (ayunasBox.isChecked()){
			       		picker = 1;
			       		Bundle args = new Bundle(); 
			       		args.putInt("hora", 06);	args.putInt("minuto", 00);
			       		showDialog(TIME_DIALOG_ID, args);
			       		if (ayunasHora.getText().length()==0){
			       			ayunasBox.setChecked(false);
			       		}
		       		}else{ 
		       			ayunasHora.setText("");
		       		}
			 }
		    });
		
		
		actividadMatutinaBox.setOnClickListener(new View.OnClickListener() {
			 @SuppressWarnings("deprecation")
				public void onClick(View v) {
		        	if (actividadMatutinaBox.isChecked()){
		        		hora = 10; minuto = 00;
			       		picker = 2;
			       		Bundle args = new Bundle(); 
			       		args.putInt("hora", 10);	args.putInt("minuto", 00);
			       		showDialog(TIME_DIALOG_ID, args);
			       		if (actividadMatutinaHora.getText().length()==0){
			       			actividadMatutinaBox.setChecked(false);
			       		}
		       		}else{ 
		       			actividadMatutinaHora.setText("");
		       		}
			 }
		    });
		
		
		
		antesComerBox.setOnClickListener(new View.OnClickListener() {
			 @SuppressWarnings("deprecation")
				public void onClick(View v) {
		        	if (antesComerBox.isChecked()){
			       		picker = 3;
			       		Bundle args = new Bundle(); 
			       		args.putInt("hora", 13);	args.putInt("minuto", 30);
			       		showDialog(TIME_DIALOG_ID, args);
			       		if (antesComerHora.getText().length()==0){
			       			antesComerBox.setChecked(false);
			       		}
		       		}else{ 
		       			antesComerHora.setText("");
		       		}
			 }
		    });
		
		
		despuesComerBox.setOnClickListener(new View.OnClickListener() {
			 @SuppressWarnings("deprecation")
				public void onClick(View v) {
		        	if (despuesComerBox.isChecked()){
			       		picker = 4;
			       		Bundle args = new Bundle(); 
			       		args.putInt("hora", 15);	args.putInt("minuto", 00);
			       		showDialog(TIME_DIALOG_ID, args);
			       		if (despuesComerHora.getText().length()==0){
			       			despuesComerBox.setChecked(false);
			       		}
		       		}else{ 
		       			despuesComerHora.setText("");
		       		}
			 }
		    });
		
		
		actividadVespertinaBox.setOnClickListener(new View.OnClickListener() {
			 @SuppressWarnings("deprecation")
				public void onClick(View v) {
		        	if (actividadVespertinaBox.isChecked()){
			       		picker = 5;
			       		Bundle args = new Bundle(); 
			       		args.putInt("hora", 16);	args.putInt("minuto", 30);
			       		showDialog(TIME_DIALOG_ID, args);
			       		if (actividadVespertinaHora.getText().length()==0){
			       			actividadVespertinaBox.setChecked(false);
			       		}
		       		}else{ 
		       			actividadVespertinaHora.setText("");
		       		}
			 }
		    });
		
		
		
		antesCenarBox.setOnClickListener(new View.OnClickListener() {
			 @SuppressWarnings("deprecation")
				public void onClick(View v) {
		        	if (antesCenarBox.isChecked()){
			       		picker = 6;
			       		Bundle args = new Bundle(); 
			       		args.putInt("hora", 20);	args.putInt("minuto", 30);
			       		showDialog(TIME_DIALOG_ID, args);
			       		if (antesCenarHora.getText().length()==0){
			       			antesCenarBox.setChecked(false);
			       		}
		       		}else{ 
		       			antesCenarHora.setText("");
		       		}
			 }
		    });
		
		
		
		nocheBox.setOnClickListener(new View.OnClickListener() {
			 @SuppressWarnings("deprecation")
				public void onClick(View v) {
		        	if (nocheBox.isChecked()){
			       		picker = 7;
			       		Bundle args = new Bundle(); 
			       		args.putInt("hora", 22);	args.putInt("minuto", 30); 
			       		showDialog(TIME_DIALOG_ID, args);
			       		if (nocheHora.getText().length()==0){
			       			nocheBox.setChecked(false);
			       		}
		       		}else{ 
		       			nocheHora.setText("");
		       		}
			 }
		    });
		
	}
	
	
	/*****Manejo de los timepickers******************************************************************************/
	
    TimePickerDialog.OnTimeSetListener pTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
			
			@Override
			public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
				hora = hourOfDay;
				minuto = minute;
                updateDisplay();				
			}
		}; 
    
   /** Updates the date in the TextView */
   private void updateDisplay() {
	   switch(picker){
	   case 1:	if (horaEnRango(hora, minuto, 6, 0, 9, 59)){  
		   			ayunasHora.setText(new StringBuilder().append(formatoHora(hora)).append(":") .append(formatoHora(minuto)));
		   			ayunasBox.setChecked(true);
	   			}else{
	   				Toast mensaje =Toast.makeText(getApplicationContext(),
		                    "Se considera medición matutina de 6:00 a 9:59", Toast.LENGTH_LONG);
					mensaje.show(); ayunasBox.setChecked(false); ayunasHora.setText("");
	   			}
		   break;
	   case 2:	if (horaEnRango(hora, minuto, 10, 0, 13, 29)){  
  					actividadMatutinaHora.setText(new StringBuilder().append(formatoHora(hora)).append(":") .append(formatoHora(minuto)));
  					actividadMatutinaBox.setChecked(true);
				}else{
					Toast mensaje =Toast.makeText(getApplicationContext(),
							"Se considera medición matutina de 10:00 a 13:29", Toast.LENGTH_LONG);
					mensaje.show();actividadMatutinaBox.setChecked(false); actividadMatutinaHora.setText("");
				}
		   break;
	   case 3:	if (horaEnRango(hora, minuto, 13, 30, 14, 59)){  
  					antesComerHora.setText(new StringBuilder().append(formatoHora(hora)).append(":") .append(formatoHora(minuto)));
  					antesComerBox.setChecked(true);
				}else{
					Toast mensaje =Toast.makeText(getApplicationContext(),
                	  "Se considera medición matutina de 13:30 a 14:59", Toast.LENGTH_LONG);
					mensaje.show();antesComerBox.setChecked(false); antesComerHora.setText("");
				}
		   break;
	   case 4:	if (horaEnRango(hora, minuto, 15, 0, 16, 29)){  
  					despuesComerHora.setText(new StringBuilder().append(formatoHora(hora)).append(":") .append(formatoHora(minuto)));
  					despuesComerBox.setChecked(true);
				}else{
					Toast mensaje =Toast.makeText(getApplicationContext(),
							"Se considera medición matutina de 15:00 a 16:29", Toast.LENGTH_LONG);
					mensaje.show();despuesComerBox.setChecked(false); despuesComerHora.setText("");
				}
		   break;
	   case 5:	if (horaEnRango(hora, minuto, 16, 30, 20, 29)){  
  					actividadVespertinaHora.setText(new StringBuilder().append(formatoHora(hora)).append(":") .append(formatoHora(minuto)));
  					actividadVespertinaBox.setChecked(true);
				}else{
					Toast mensaje =Toast.makeText(getApplicationContext(),
							"Se considera medición matutina de 16:30 a 20:29", Toast.LENGTH_LONG);
					mensaje.show();actividadVespertinaBox.setChecked(false); actividadVespertinaHora.setText("");
				}
		   break;
	   case 6:	if (horaEnRango(hora, minuto, 20, 30, 22, 29)){  
  					antesCenarHora.setText(new StringBuilder().append(formatoHora(hora)).append(":") .append(formatoHora(minuto)));
  					antesCenarBox.setChecked(true);
				}else{
					Toast mensaje =Toast.makeText(getApplicationContext(),
							"Se considera medición matutina de 20:30 a 22:29", Toast.LENGTH_LONG);
					mensaje.show();antesCenarBox.setChecked(false); antesCenarHora.setText("");
				}
		   break;
	   case 7:	if (horaEnRango(hora, minuto, 22, 30, 2, 00)){  
  					nocheHora.setText(new StringBuilder().append(formatoHora(hora)).append(":") .append(formatoHora(minuto)));
  					nocheBox.setChecked(true);
				}else{
					Toast mensaje =Toast.makeText(getApplicationContext(),
							"Se considera medición matutina de 22:30 a 2:00", Toast.LENGTH_LONG);
					mensaje.show();nocheBox.setChecked(false); nocheHora.setText("");
				}
		   break;
		   default: Log.d("pickers", "error manejando pickers");
	   }
   }
   
   protected Dialog onCreateDialog(int id, Bundle args) {
	   switch (id) {
       case TIME_DIALOG_ID:
           return new TimePickerDialog(this, pTimeSetListener, args.getInt("hora"), args.getInt("minuto"), true);
       }
       return null;
   }
   
   @SuppressWarnings("deprecation")
   @Override
   protected void onPrepareDialog(int id, Dialog dialog, Bundle args) {
       super.onPrepareDialog(id, dialog);
       switch (id) {
           case TIME_DIALOG_ID:
               ((TimePickerDialog) dialog).updateTime(args.getInt("hora"), args.getInt("minuto"));
               break;
       }
   }
	
   private static String formatoHora(int c) {
		if (c >= 10)
		   return String.valueOf(c);
		else
		   return "0" + String.valueOf(c);
	}
   
   
   // h1:m1 ->  [h2:m2 , h3:m3]
   public boolean horaEnRango(int h1, int m1, int h2, int m2, int h3, int m3){
	   
	   if (h1 == h2){
		if (m1 < m2){
			return false;
		}else{
			return true;
		}
	   }else{
		   if (h1 == h3){
			   if (m1 > m3){
				   return false;
			   }else{
				   return true;
			   }
		   }else{
			   if(h1 < h2 || h1 > h3){
				   return false;
			   }else{
				   return true;
			   }
		   }
	   }
	   
   }
   
   
	
	
	
	
	
	
	public void lanzarTerminar(View v){
		
		if(ayunasBox.isChecked()){
			
			int horaAlarma = Integer.parseInt(ayunasHora.getText().toString().substring(0, 2));
			int minutoAlarma = Integer.parseInt(ayunasHora.getText().toString().substring(4, 5));

			if (horaAlarma < 6 && horaAlarma > 10){
				Toast mensaje =Toast.makeText(getApplicationContext(),
	                    "Inserte hora de notificación después del desayuno (6:00-10:00)", Toast.LENGTH_SHORT);
		        mensaje.show();
			}else{
				
			    Calendar calendar = Calendar.getInstance();
			    calendar.set(Calendar.HOUR_OF_DAY, horaAlarma);
			    calendar.set(Calendar.MINUTE, minutoAlarma);
			    calendar.set(Calendar.SECOND, 00);
		
			    Intent myIntent = new Intent(Configuracion4Activity.this, Alarma.class);
			    PendingIntent pendingIntent = PendingIntent.getBroadcast(Configuracion4Activity.this, 0, myIntent,0);
			     
			    AlarmManager alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);
			    alarmManager.setRepeating(AlarmManager.RTC, calendar.getTimeInMillis(), 24 * 60 * 60 * 1000, pendingIntent);		
			 }
		}	
	    
	    
		if(antesCenarBox.isChecked()){
			
			int horaAlarma = Integer.parseInt(ayunasHora.getText().toString().substring(0, 2));
			int minutoAlarma = Integer.parseInt(ayunasHora.getText().toString().substring(4, 5));
			
			if (horaAlarma < 20 && horaAlarma > 22){
				Toast mensaje =Toast.makeText(getApplicationContext(),
	                    "Inserte hora de notificación antes de cenar (20:30-22:30)", Toast.LENGTH_SHORT);
		        mensaje.show();
			}else{
				
			    Calendar calendar = Calendar.getInstance();
			    calendar.set(Calendar.HOUR_OF_DAY, horaAlarma);
			    calendar.set(Calendar.MINUTE, minutoAlarma);
			    calendar.set(Calendar.SECOND, 00);
		
			    Intent myIntent = new Intent(Configuracion4Activity.this, Alarma.class);
			    PendingIntent pendingIntent = PendingIntent.getBroadcast(Configuracion4Activity.this, 0, myIntent,0);
			     
			    AlarmManager alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);
			    alarmManager.setRepeating(AlarmManager.RTC, calendar.getTimeInMillis(), 24 * 60 * 60 * 1000, pendingIntent);		
			 }
		}
	    
	    
	    
	    
	    
		Intent intent = new Intent(Configuracion4Activity.this, PrincipalActivity.class);
		startActivity(intent);
	}
	

	

	
	

	
	

}

package com.example.seguimientodiabetes;

import java.util.Calendar;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import com.seguimientodiabetes.seguimientodiabetes.R;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Configuracion3Activity extends Activity {

	EditText tiempoL, tiempoM, tiempoX, tiempoJ, tiempoV, tiempoS, tiempoD;
	TextView horaL, horaM, horaX, horaJ, horaV, horaS, horaD;
	Spinner planes;
	Spinner actividadL, actividadM, actividadX, actividadJ, actividadV, actividadS, actividadD;
	CheckBox activarPlanes;
	int edad;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_configuracion3);
		
		activarPlanes = (CheckBox) findViewById(R.id.checkBox1);		
		planes = (Spinner) findViewById(R.id.spinner1);
		
		tiempoL = (EditText)findViewById(R.id.editText1);
		tiempoM = (EditText)findViewById(R.id.editText2);
		tiempoX = (EditText)findViewById(R.id.editText3);
		tiempoJ = (EditText)findViewById(R.id.editText4);
		tiempoV = (EditText)findViewById(R.id.editText5);
		tiempoS = (EditText)findViewById(R.id.editText6);
		tiempoD = (EditText)findViewById(R.id.editText7);
		
		horaL = (TextView)findViewById(R.id.textView3);
		horaM = (TextView)findViewById(R.id.textView5);
		horaX = (TextView)findViewById(R.id.textView7);
		horaJ = (TextView)findViewById(R.id.textView9);
		horaV = (TextView)findViewById(R.id.textView11);
		horaS = (TextView)findViewById(R.id.textView13);
		horaD = (TextView)findViewById(R.id.textView15);
		
		actividadL = (Spinner) findViewById(R.id.spinner2);
		actividadM = (Spinner) findViewById(R.id.spinner3);
		actividadX = (Spinner) findViewById(R.id.spinner4);
		actividadJ = (Spinner) findViewById(R.id.spinner5);
		actividadV = (Spinner) findViewById(R.id.spinner6);
		actividadS = (Spinner) findViewById(R.id.spinner7);
		actividadD = (Spinner) findViewById(R.id.spinner8);

		
	
		
		
		
		SharedPreferences prefs =
 			     getSharedPreferences("MisPreferencias",Context.MODE_PRIVATE);
		
		String nacimiento = prefs.getString("nacimiento", null);
		final String estiloGuardada = prefs.getString("estiloVida", null);
		
		
		Calendar hoy = Calendar.getInstance();
		int anoNacimiento = Integer.parseInt((String) nacimiento.subSequence(nacimiento.length() - 4 , nacimiento.length()));
		final int edad = hoy.get(Calendar.YEAR) - anoNacimiento;
		
		final String[] arrayActividades = new String[] { " ", "Correr", "Andar", "Bicicleta", "Patinar", 
				"Tenis", "Padel", "Musculaci�n",  "Nadar", "Patinar", "Baloncesto"};

		ArrayAdapter<String> adaptadorActividades = new ArrayAdapter<String>(
				this, android.R.layout.simple_spinner_item, arrayActividades);

		adaptadorActividades
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		actividadL.setAdapter(adaptadorActividades);
		actividadM.setAdapter(adaptadorActividades);
		actividadX.setAdapter(adaptadorActividades);
		actividadJ.setAdapter(adaptadorActividades);
		actividadV.setAdapter(adaptadorActividades);
		actividadS.setAdapter(adaptadorActividades);
		actividadD.setAdapter(adaptadorActividades);
		
		
		
		planes.setOnItemSelectedListener(new OnItemSelectedListener() {

			public void onItemSelected(AdapterView<?> parent,
					android.view.View v, int position, long id) {
				}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub
				
			}
		});
		
		

		final String[] arrayPlanes = new String[] { "Ninguna actividad", "Actividad ligera", "Actividad media", "Actividad intensa", "Actividad excepcionalmente intensa"};

		ArrayAdapter<String> adaptadorPlanes = new ArrayAdapter<String>(
				this, android.R.layout.simple_spinner_item, arrayPlanes);

		adaptadorPlanes
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		
		planes.setAdapter(adaptadorPlanes);
		
		
		
		activarPlanes.setOnClickListener(new OnClickListener() {

			  public void onClick(View v) {
				  if (((CheckBox) v).isChecked()) {
						planes.setEnabled(true);

						switch (estiloGuardada){
							case "Actividad ligera":		planes.setSelection(1);
								break;
							case "Actividad media":			planes.setSelection(2);
								break;
							case "Actividad intensa":		planes.setSelection(3);
								break;
							case "Actividad excepcionalmente intensa":		planes.setSelection(4);
								break;
							default:
								Log.d("debug", "Error seleccion auto");
						}
		
					}else{
						planes.setSelection(0);
						planes.setEnabled(false);
					}
				  }
				});
		
		planes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

			public void onItemSelected(AdapterView<?> parent,
					android.view.View v, int position, long id) {
				
				switch (position) {
				
				case 0:
					actividadL.setSelection(0);
					actividadM.setSelection(0);
					actividadX.setSelection(0);
					actividadJ.setSelection(0);
					actividadV.setSelection(0);
					actividadS.setSelection(0);
					actividadD.setSelection(0);
					
					tiempoL.setText("");
					tiempoM.setText("");
					tiempoX.setText("");
					tiempoJ.setText("");
					tiempoV.setText("");
					tiempoS.setText("");
					tiempoD.setText("");
					
					horaL.setText("");
					horaM.setText("");
					horaX.setText("");
					horaJ.setText("");
					horaV.setText("");
					horaS.setText("");
					horaD.setText("");
				
				break;
				
				case 1:
					
					if(edad<19){
					
					actividadL.setSelection(2);
					actividadM.setSelection(0);
					actividadX.setSelection(5);
					actividadJ.setSelection(0);
					actividadV.setSelection(9);
					actividadS.setSelection(0);
					actividadD.setSelection(0);
					
					tiempoL.setText("45");
					tiempoM.setText("");
					tiempoX.setText("60");
					tiempoJ.setText("");
					tiempoV.setText("45");
					tiempoS.setText("");
					tiempoD.setText("");
					
					horaL.setText("18:00");
					horaM.setText("");
					horaX.setText("18:00");
					horaJ.setText("");
					horaV.setText("18:00");
					horaS.setText("");
					horaD.setText("");
					}
					else if(edad>=19 && edad<44){
						
						actividadL.setSelection(2);
						actividadM.setSelection(0);
						actividadX.setSelection(5);
						actividadJ.setSelection(0);
						actividadV.setSelection(9);
						actividadS.setSelection(0);
						actividadD.setSelection(0);
						
						tiempoL.setText("60");
						tiempoM.setText("");
						tiempoX.setText("90");
						tiempoJ.setText("");
						tiempoV.setText("45");
						tiempoS.setText("");
						tiempoD.setText("");
						
						horaL.setText("18:00");
						horaM.setText("");
						horaX.setText("18:00");
						horaJ.setText("");
						horaV.setText("18:00");
						horaS.setText("");
						horaD.setText("");
						
					}else if (edad>=45 && edad<69){
						
						actividadL.setSelection(2);
						actividadM.setSelection(0);
						actividadX.setSelection(2);
						actividadJ.setSelection(0);
						actividadV.setSelection(2);
						actividadS.setSelection(0);
						actividadD.setSelection(0);
						
						tiempoL.setText("45");
						tiempoM.setText("");
						tiempoX.setText("45");
						tiempoJ.setText("");
						tiempoV.setText("45");
						tiempoS.setText("");
						tiempoD.setText("");
						
						horaL.setText("12:00");
						horaM.setText("");
						horaX.setText("12:00");
						horaJ.setText("");
						horaV.setText("12:00");
						horaS.setText("");
						horaD.setText("");
						
						
						
					}else if (edad>=70){
						
						actividadL.setSelection(2);
						actividadM.setSelection(0);
						actividadX.setSelection(2);
						actividadJ.setSelection(0);
						actividadV.setSelection(2);
						actividadS.setSelection(0);
						actividadD.setSelection(0);
						
						tiempoL.setText("30");
						tiempoM.setText("");
						tiempoX.setText("30");
						tiempoJ.setText("");
						tiempoV.setText("30");
						tiempoS.setText("");
						tiempoD.setText("");
						
						horaL.setText("12:00");
						horaM.setText("");
						horaX.setText("12:00");
						horaJ.setText("");
						horaV.setText("12:00");
						horaS.setText("");
						horaD.setText("");
						
						
					}else {
						
				//Error					
					}
					
					
					
					
					
					break;
					
				case 2:
					if(edad<19){
						
						actividadL.setSelection(1);
						actividadM.setSelection(0);
						actividadX.setSelection(5);
						actividadJ.setSelection(0);
						actividadV.setSelection(1);
						actividadS.setSelection(0);
						actividadD.setSelection(3);
						
						tiempoL.setText("20");
						tiempoM.setText("");
						tiempoX.setText("60");
						tiempoJ.setText("");
						tiempoV.setText("20");
						tiempoS.setText("");
						tiempoD.setText("60");
						
						horaL.setText("18:00");
						horaM.setText("");
						horaX.setText("18:00");
						horaJ.setText("");
						horaV.setText("18:00");
						horaS.setText("");
						horaD.setText("12:00");		
					}
					else if(edad>=19 && edad<44){
						
						actividadL.setSelection(1);
						actividadM.setSelection(0);
						actividadX.setSelection(5);
						actividadJ.setSelection(0);
						actividadV.setSelection(1);
						actividadS.setSelection(0);
						actividadD.setSelection(3);
						
						tiempoL.setText("25");
						tiempoM.setText("");
						tiempoX.setText("90");
						tiempoJ.setText("");
						tiempoV.setText("25");
						tiempoS.setText("");
						tiempoD.setText("90");
						
						horaL.setText("18:00");
						horaM.setText("");
						horaX.setText("18:00");
						horaJ.setText("");
						horaV.setText("18:00");
						horaS.setText("");
						horaD.setText("12:00");	
						
					}else if (edad>=45 && edad<69){
						
						actividadL.setSelection(1);
						actividadM.setSelection(0);
						actividadX.setSelection(5);
						actividadJ.setSelection(0);
						actividadV.setSelection(1);
						actividadS.setSelection(0);
						actividadD.setSelection(8);
						
						tiempoL.setText("60");
						tiempoM.setText("");
						tiempoX.setText("60");
						tiempoJ.setText("");
						tiempoV.setText("60");
						tiempoS.setText("");
						tiempoD.setText("45");
						
						horaL.setText("12:00");
						horaM.setText("");
						horaX.setText("12:00");
						horaJ.setText("");
						horaV.setText("12:00");
						horaS.setText("");
						horaD.setText("18:00");
						
						
					}else if (edad>=70){
						
						actividadL.setSelection(1);
						actividadM.setSelection(0);
						actividadX.setSelection(5);
						actividadJ.setSelection(0);
						actividadV.setSelection(1);
						actividadS.setSelection(0);
						actividadD.setSelection(8);
						
						tiempoL.setText("45");
						tiempoM.setText("");
						tiempoX.setText("60");
						tiempoJ.setText("");
						tiempoV.setText("60");
						tiempoS.setText("");
						tiempoD.setText("30");
						
						horaL.setText("12:00");
						horaM.setText("");
						horaX.setText("12:00");
						horaJ.setText("");
						horaV.setText("12:00");
						horaS.setText("");
						horaD.setText("18:00");
						
						
					}else {
						
				//Error					
					}
					
					break;
				case 3:
					if(edad<19){
						
					actividadL.setSelection(8);
					actividadM.setSelection(0);
					actividadX.setSelection(2);
					actividadJ.setSelection(0);
					actividadV.setSelection(8);
					actividadS.setSelection(0);
					actividadD.setSelection(0);
					
					tiempoL.setText("45");
					tiempoM.setText("");
					tiempoX.setText("30");
					tiempoJ.setText("");
					tiempoV.setText("45");
					tiempoS.setText("");
					tiempoD.setText("120");
					
					horaL.setText("18:00");
					horaM.setText("");
					horaX.setText("18:00");
					horaJ.setText("");
					horaV.setText("18:00");
					horaS.setText("");
					horaD.setText("12:00");
					}
					else if(edad>=19 && edad<44){
							
						actividadL.setSelection(8);
						actividadM.setSelection(0);
						actividadX.setSelection(1);
						actividadJ.setSelection(0);
						actividadV.setSelection(8);
						actividadS.setSelection(0);
						actividadD.setSelection(3);
						
						tiempoL.setText("60");
						tiempoM.setText("");
						tiempoX.setText("30");
						tiempoJ.setText("");
						tiempoV.setText("60");
						tiempoS.setText("");
						tiempoD.setText("150");
						
						horaL.setText("18:00");
						horaM.setText("");
						horaX.setText("18:00");
						horaJ.setText("");
						horaV.setText("18:00");
						horaS.setText("");
						horaD.setText("12:00");
						
					}else if (edad>=45 && edad<69){
						
						actividadL.setSelection(2);
						actividadM.setSelection(0);
						actividadX.setSelection(8);
						actividadJ.setSelection(2);
						actividadV.setSelection(0);
						actividadS.setSelection(5);
						actividadD.setSelection(1);
						
						tiempoL.setText("120");
						tiempoM.setText("");
						tiempoX.setText("45");
						tiempoJ.setText("120");
						tiempoV.setText("");
						tiempoS.setText("120");
						tiempoD.setText("20");
						
						horaL.setText("18:00");
						horaM.setText("");
						horaX.setText("18:00");
						horaJ.setText("");
						horaV.setText("18:00");
						horaS.setText("");
						horaD.setText("12:00");
						
						
					}else if (edad>=70){
						
						actividadL.setSelection(0);
						actividadM.setSelection(0);
						actividadX.setSelection(0);
						actividadJ.setSelection(0);
						actividadV.setSelection(0);
						actividadS.setSelection(0);
						actividadD.setSelection(0);
						
						tiempoL.setText("");
						tiempoM.setText("");
						tiempoX.setText("");
						tiempoJ.setText("");
						tiempoV.setText("");
						tiempoS.setText("");
						tiempoD.setText("");
						
						horaL.setText("");
						horaM.setText("");
						horaX.setText("");
						horaJ.setText("");
						horaV.setText("");
						horaS.setText("");
						horaD.setText("");
						
						
					}else {
						
				//Error					
					}
					
					break;
					
					
				case 4: 
					if(edad<19){

					actividadL.setSelection(8);
					actividadM.setSelection(2);
					actividadX.setSelection(7);
					actividadJ.setSelection(2);
					actividadV.setSelection(8);
					actividadS.setSelection(3);
					actividadD.setSelection(5);
					
					tiempoL.setText("60");
					tiempoM.setText("45");
					tiempoX.setText("60");
					tiempoJ.setText("45");
					tiempoV.setText("60");
					tiempoS.setText("180");
					tiempoD.setText("90");
					
					horaL.setText("18:00");
					horaM.setText("18:00");
					horaX.setText("18:00");
					horaJ.setText("18:00");
					horaV.setText("18:00");
					horaS.setText("12:00");
					horaD.setText("12:00");
					}
					else if(edad>=19 && edad<44){
								
						actividadL.setSelection(0);
						actividadM.setSelection(0);
						actividadX.setSelection(0);
						actividadJ.setSelection(0);
						actividadV.setSelection(0);
						actividadS.setSelection(0);
						actividadD.setSelection(0);
						
						tiempoL.setText("");
						tiempoM.setText("");
						tiempoX.setText("");
						tiempoJ.setText("");
						tiempoV.setText("");
						tiempoS.setText("");
						tiempoD.setText("");
						
						horaL.setText("");
						horaM.setText("");
						horaX.setText("");
						horaJ.setText("");
						horaV.setText("");
						horaS.setText("");
						horaD.setText("");
					}else if (edad>=45 && edad<69){
						
						
						actividadL.setSelection(0);
						actividadM.setSelection(0);
						actividadX.setSelection(0);
						actividadJ.setSelection(0);
						actividadV.setSelection(0);
						actividadS.setSelection(0);
						actividadD.setSelection(0);
						
						tiempoL.setText("");
						tiempoM.setText("");
						tiempoX.setText("");
						tiempoJ.setText("");
						tiempoV.setText("");
						tiempoS.setText("");
						tiempoD.setText("");
						
						horaL.setText("");
						horaM.setText("");
						horaX.setText("");
						horaJ.setText("");
						horaV.setText("");
						horaS.setText("");
						horaD.setText("");
						
					}else if (edad>=70){
						
						
						actividadL.setSelection(0);
						actividadM.setSelection(0);
						actividadX.setSelection(0);
						actividadJ.setSelection(0);
						actividadV.setSelection(0);
						actividadS.setSelection(0);
						actividadD.setSelection(0);
						
						tiempoL.setText("");
						tiempoM.setText("");
						tiempoX.setText("");
						tiempoJ.setText("");
						tiempoV.setText("");
						tiempoS.setText("");
						tiempoD.setText("");
						
						horaL.setText("");
						horaM.setText("");
						horaX.setText("");
						horaJ.setText("");
						horaV.setText("");
						horaS.setText("");
						horaD.setText("");
						
					}else {
						
				//Error					
					}
					
					break;
					
					
					default:break;
					
				
				}
				

			}
			
			public void onNothingSelected(AdapterView<?> parent) {
			}
		});	
		
		
		
		
		
		
		
		
		
	}


	
	
	
	
	
	
	
	
	
	public void lanzarConfiguracion4(View v){
				
		
		
		if (	(actividadL.getSelectedItem().toString().length()!=0 && (tiempoL.getText().length()==0 || horaL.getText().length()==0 ) ) || 
				(actividadM.getSelectedItem().toString().length()!=0 && (tiempoM.getText().length()==0 || horaM.getText().length()==0 ) ) ||
				(actividadX.getSelectedItem().toString().length()!=0 && (tiempoX.getText().length()==0 || horaX.getText().length()==0 ) ) || 
				(actividadJ.getSelectedItem().toString().length()!=0 && (tiempoJ.getText().length()==0 || horaJ.getText().length()==0 ) ) || 
				(actividadV.getSelectedItem().toString().length()!=0 && (tiempoV.getText().length()==0 || horaV.getText().length()==0 ) ) || 
				(actividadS.getSelectedItem().toString().length()!=0 && (tiempoS.getText().length()==0 || horaS.getText().length()==0 ) ) || 
				(actividadD.getSelectedItem().toString().length()!=0 && (tiempoD.getText().length()==0 || horaD.getText().length()==0 ) )){
			
				Toast mensaje =Toast.makeText(getApplicationContext(),
	                    "No ha completado el campo tiempo u hora del ejercicio.", Toast.LENGTH_LONG);
				mensaje.show();
			}else{	
				
		       	int tiempoLUsuario = Integer.parseInt(tiempoL.getText().toString());
		       	int tiempoMUsuario = Integer.parseInt(tiempoM.getText().toString());
		       	int tiempoXUsuario = Integer.parseInt(tiempoX.getText().toString());
		       	int tiempoJUsuario = Integer.parseInt(tiempoJ.getText().toString());
		       	int tiempoVUsuario = Integer.parseInt(tiempoV.getText().toString());
		       	int tiempoSUsuario = Integer.parseInt(tiempoS.getText().toString());
		       	int tiempoDUsuario = Integer.parseInt(tiempoD.getText().toString());

		       	String horaLUsuario = horaL.getText().toString();
		       	String horaMUsuario = horaM.getText().toString();
		       	String horaXUsuario = horaX.getText().toString();
		       	String horaJUsuario = horaJ.getText().toString();
		       	String horaVUsuario = horaV.getText().toString();
		       	String horaSUsuario = horaS.getText().toString();
		       	String horaDUsuario = horaD.getText().toString();
		       	
		       	int horaL = Integer.parseInt(horaLUsuario.substring(0, 2)); int minutoL = Integer.parseInt(horaLUsuario.substring(4, 5));
		       	int horaM = Integer.parseInt(horaMUsuario.substring(0, 2)); int minutoM = Integer.parseInt(horaMUsuario.substring(4, 5));
		       	int horaX = Integer.parseInt(horaXUsuario.substring(0, 2)); int minutoX = Integer.parseInt(horaXUsuario.substring(4, 5));
		       	int horaJ = Integer.parseInt(horaJUsuario.substring(0, 2)); int minutoJ = Integer.parseInt(horaJUsuario.substring(4, 5));
		       	int horaV = Integer.parseInt(horaVUsuario.substring(0, 2)); int minutoV = Integer.parseInt(horaVUsuario.substring(4, 5));
		       	int horaS = Integer.parseInt(horaSUsuario.substring(0, 2)); int minutoS = Integer.parseInt(horaSUsuario.substring(4, 5));
		       	int horaD = Integer.parseInt(horaDUsuario.substring(0, 2)); int minutoD = Integer.parseInt(horaDUsuario.substring(4, 5));	
			
				
		    	if (	(actividadL.getSelectedItem().toString().length()!=0 && (tiempoLUsuario <= 120 || (horaEnRango(horaL, minutoL, 10, 0, 13, 29) || horaEnRango(horaL, minutoL, 16, 30, 20, 29) 	))) || 
						(actividadM.getSelectedItem().toString().length()!=0 && (tiempoMUsuario <= 120 || (horaEnRango(horaM, minutoM, 10, 0, 13, 29) || horaEnRango(horaM, minutoM, 16, 30, 20, 29)	))) ||
						(actividadX.getSelectedItem().toString().length()!=0 && (tiempoXUsuario <= 120 || (horaEnRango(horaX, minutoX, 10, 0, 13, 29) || horaEnRango(horaX, minutoX, 16, 30, 20, 29)	))) || 
						(actividadJ.getSelectedItem().toString().length()!=0 && (tiempoJUsuario <= 120 || (horaEnRango(horaJ, minutoJ, 10, 0, 13, 29) || horaEnRango(horaJ, minutoJ, 16, 30, 20, 29)	))) || 
						(actividadV.getSelectedItem().toString().length()!=0 && (tiempoVUsuario <= 120 || (horaEnRango(horaV, minutoV, 10, 0, 13, 29) || horaEnRango(horaV, minutoV, 16, 30, 20, 29)	))) || 
						(actividadS.getSelectedItem().toString().length()!=0 && (tiempoSUsuario <= 120 || (horaEnRango(horaS, minutoS, 10, 0, 13, 29) || horaEnRango(horaS, minutoS, 16, 30, 20, 29)	))) || 
						(actividadD.getSelectedItem().toString().length()!=0 && (tiempoDUsuario <= 120 || (horaEnRango(horaD, minutoD, 10, 0, 13, 29) || horaEnRango(horaD, minutoD, 16, 30, 20, 29)	)))){
					
			    		Toast mensaje =Toast.makeText(getApplicationContext(),
			                    "El tiempo de ejercicio no es recomendable superar 120min o la hora de ejercicio est� comprendido en 10:00-13:29 o 16:30-20:29", Toast.LENGTH_LONG);
						mensaje.show();
				}else{
		
		
					SharedPreferences prefs =
			 			     getSharedPreferences("MisPreferencias",Context.MODE_PRIVATE);
			 		
					SharedPreferences.Editor editor = prefs.edit();
					
					editor.putString("lunes", (actividadL.getSelectedItem().toString() + " " + tiempoLUsuario + " "+ horaLUsuario));
					editor.putString("martes", (actividadM.getSelectedItem().toString() + " " + tiempoMUsuario + " "+ horaMUsuario));
					editor.putString("miercoles", (actividadX.getSelectedItem().toString() + " " + tiempoXUsuario + " "+ horaXUsuario));
					editor.putString("jueves", (actividadJ.getSelectedItem().toString() + " " + tiempoJUsuario + " "+ horaJUsuario));
					editor.putString("viernes", (actividadV.getSelectedItem().toString() + " " + tiempoVUsuario + " "+ horaVUsuario));
					editor.putString("sabado", (actividadS.getSelectedItem().toString() + " " + tiempoSUsuario + " "+ horaSUsuario));
					editor.putString("domingo", (actividadD.getSelectedItem().toString() + " " + tiempoDUsuario + " "+ horaDUsuario));
					editor.commit();
					
					Intent intent = new Intent(Configuracion3Activity.this, Configuracion4Activity.class);
					startActivity(intent);
					}
			}
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
	
	
	
	
	

}

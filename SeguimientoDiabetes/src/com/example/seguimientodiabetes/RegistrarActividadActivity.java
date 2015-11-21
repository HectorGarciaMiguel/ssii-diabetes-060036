package com.example.seguimientodiabetes;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import com.seguimientodiabetes.seguimientodiabetes.R;

public class RegistrarActividadActivity extends Activity {

	
	
	Spinner actividad, dia;
	EditText tiempo, hora;
	Button registrar;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_registrar_actividad);
		
		
		
		
		hora = (EditText) findViewById(R.id.editText2);
		tiempo = (EditText) findViewById(R.id.editText1);
		actividad = (Spinner) findViewById(R.id.spinner1);
		dia = (Spinner) findViewById(R.id.spinner2);
		registrar = (Button) findViewById(R.id.button1);
		
		
		
		
		final String[] arrayActividades = new String[] { " ", "Correr", "Andar", "Bicicleta", "Patinar", 
				"Tenis", "Padel", "Musculación",  "Nadar", "Patinar", "Baloncesto"};

		ArrayAdapter<String> adaptadorActividades = new ArrayAdapter<String>(
				this, android.R.layout.simple_spinner_item, arrayActividades);

		adaptadorActividades
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		
		actividad.setAdapter(adaptadorActividades);

		
		
		
		final String[] arrayDias = new String[] { "lunes", "martes", "miercoles", "jueves", "viernes", 
				"sabado", "domingo"};

		ArrayAdapter<String> adaptadorDias = new ArrayAdapter<String>(
				this, android.R.layout.simple_spinner_item, arrayDias);

		adaptadorDias
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		
		dia.setAdapter(adaptadorDias);
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_registrar_actividad, menu);
		return true;
	}
	
	
	public void lanzarRegistrar(View v){
		SharedPreferences prefs =
			     getSharedPreferences("MisPreferencias",Context.MODE_PRIVATE);
		
		SharedPreferences.Editor editor = prefs.edit();
		
		
		
		switch (dia.getSelectedItemPosition()){
		
		case 0:
			editor.putString("lunes", ( actividad.getSelectedItem().toString() + " " + tiempo.getText() + " "+ hora.getText()));
			break;
		case 1:
			editor.putString("martes", ( actividad.getSelectedItem().toString() + " " + tiempo.getText() + " "+ hora.getText()));
			break;
		case 2:
			editor.putString("miercoles", ( actividad.getSelectedItem().toString() + " " + tiempo.getText() + " "+ hora.getText()));
			break;
		case 3:
			editor.putString("jueves", ( actividad.getSelectedItem().toString() + " " + tiempo.getText() + " "+ hora.getText()));
			break;
		case 4:
			editor.putString("viernes", ( actividad.getSelectedItem().toString() + " " + tiempo.getText() + " "+ hora.getText()));
			break;
		case 5:
			editor.putString("sabado", ( actividad.getSelectedItem().toString() + "" + tiempo.getText() + " "+ hora.getText()));
			break;
		case 6:
			editor.putString("domingo", ( actividad.getSelectedItem().toString() + " " + tiempo.getText() + " "+ hora.getText()));
			break;
			default:break;
					
		}
		
		
		editor.commit();
		
		
		Toast.makeText(this, "Actividad insertada correctamente",Toast.LENGTH_LONG).show();
		registrar.setEnabled(false);
		
		
	}
	
	
	
	
	

}

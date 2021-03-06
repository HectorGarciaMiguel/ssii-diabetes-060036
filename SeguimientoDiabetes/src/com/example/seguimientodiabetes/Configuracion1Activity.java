package com.example.seguimientodiabetes;

import java.util.Calendar;
import java.util.Date;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import com.seguimientodiabetes.seguimientodiabetes.R;

public class Configuracion1Activity extends Activity {

	Spinner diabetes,estiloVida, sexo;
	Button siguiente, info;
	EditText nacimiento, peso, altura;
	
	String nacimientoGuardada, diabetesGuardada, estiloGuardada, sexoGuardada;
	int alturaGuardada = 0;
	int pesoGuardada = 0;
	
	///////////////////////////////
	
	
    private int pYear;
    private int pMonth;
    private int pDay;

    static final int DATE_DIALOG_ID = 0;
    static final int ALERT_INFO = 1;


	//////////////////////////////77
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_configuracion1);
		
		
		nacimiento = (EditText)findViewById(R.id.editText1);
		sexo = (Spinner) findViewById(R.id.CmbOpciones1);
		peso = (EditText)findViewById(R.id.editText2);
		altura = (EditText)findViewById(R.id.editText3);
		diabetes = (Spinner) findViewById(R.id.CmbOpciones2);
		info = (Button)findViewById(R.id.button1);
		estiloVida = (Spinner) findViewById(R.id.CmbOpciones3);
		siguiente = (Button)findViewById(R.id.button2);
		
		

	
//////////////////////////////////////////////////////////////////////////		
		nacimiento.setOnClickListener(new View.OnClickListener() {
            @SuppressWarnings("deprecation")
			public void onClick(View v) {
                showDialog(DATE_DIALOG_ID);
            }
        });

 
        /** Get the current date */
       final Calendar cal = Calendar.getInstance();
        pYear = cal.get(Calendar.YEAR);
        pMonth = cal.get(Calendar.MONTH);
        pDay = cal.get(Calendar.DAY_OF_MONTH);
 
        /** Display the current date in the TextView */
       updateDisplay();

		final String[] arraySexo = new String[] { "Hombre", "Mujer" };

		ArrayAdapter<String> adaptadorSexo = new ArrayAdapter<String>(
				this, android.R.layout.simple_spinner_item, arraySexo);

		adaptadorSexo
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		sexo.setAdapter(adaptadorSexo);
		sexo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

			public void onItemSelected(AdapterView<?> parent,
					android.view.View v, int position, long id) {
			}

			public void onNothingSelected(AdapterView<?> parent) {
			}
		});	

		final String[] tipoDiabetes = new String[] {"Tipo 1", "Tipo 1 con bomba", "Tipo 2"};

		ArrayAdapter<String> adaptadorTipoDiabetes = new ArrayAdapter<String>(
				this, android.R.layout.simple_spinner_item, tipoDiabetes);

		adaptadorTipoDiabetes
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		diabetes.setAdapter(adaptadorTipoDiabetes);

		diabetes
				.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

					public void onItemSelected(AdapterView<?> parent,
							android.view.View v, int position, long id) {
					}

					public void onNothingSelected(AdapterView<?> parent) {
					}
				});

		final String[] arrayEstiloVida = new String[] {"Actividad ligera", "Actividad media", "Actividad intensa", "Actividad excepcionalmente intensa"};

		ArrayAdapter<String> adaptadorEstiloVida = new ArrayAdapter<String>(
				this, android.R.layout.simple_spinner_item, arrayEstiloVida);

		adaptadorEstiloVida
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		estiloVida.setAdapter(adaptadorEstiloVida);

		estiloVida.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

			public void onItemSelected(AdapterView<?> parent,
					android.view.View v, int position, long id) {
			}

			public void onNothingSelected(AdapterView<?> parent) {
			}
		});
		

	
	}

	
	
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event){
		if ((keyCode == KeyEvent.KEYCODE_BACK)){

			
			
			SharedPreferences prefs =
				     getSharedPreferences("MisPreferencias",Context.MODE_PRIVATE);
			
			if (prefs.getString("visitado", "").equals("true")){
				Intent intent = new Intent(Configuracion1Activity.this, PrincipalActivity.class);
				startActivity(intent);
			}else{
				
				Toast mensaje =Toast.makeText(getApplicationContext(),
	                    "No hay configuraci�n guardada. Contin�e, son s�lo 4 pasos", Toast.LENGTH_SHORT);
		        mensaje.show();

			}
			
			
			return true;
		}

		return super.onKeyDown(keyCode, event);
	}
	
	
	
	
	
	
	
	
	
	public void lanzarConfiguracion2(View v){
	
		SharedPreferences prefs =
  			     getSharedPreferences("MisPreferencias",Context.MODE_PRIVATE);
  		
		SharedPreferences.Editor editor = prefs.edit();
		
		editor.clear();
		       	
		if (peso.getText().length()==0 || altura.getText().length()==0){
			Toast mensaje =Toast.makeText(getApplicationContext(),
                    "Debe de introducir su peso y altura.", Toast.LENGTH_LONG);
			mensaje.show();
			peso.setText("");altura.setText("");

		}else{
			
			Calendar hoy = Calendar.getInstance();
			String nacimientoTexto = nacimiento.getText().toString();
			int anoNacimiento = Integer.parseInt((String) nacimientoTexto.subSequence(nacimientoTexto.length() - 4 , nacimientoTexto.length()));
						
			//ni�os a partir de 10 a�os
			if ( hoy.get(Calendar.YEAR) <  anoNacimiento + 10 || hoy.get(Calendar.YEAR) >  anoNacimiento + 120){  
				Toast mensaje =Toast.makeText(getApplicationContext(),
	                    "Debe de introducir una fecha de nacimiento correcto, edad comprendida de 10 a 120 a�os.", Toast.LENGTH_LONG);
				mensaje.show();
			}else{
		
	       	nacimientoGuardada = nacimiento.getText().toString();
	       	pesoGuardada = Integer.parseInt(peso.getText().toString());
	       	alturaGuardada = Integer.parseInt(altura.getText().toString());
	       	estiloGuardada = (String) estiloVida.getSelectedItem();
	       	diabetesGuardada = (String) diabetes.getSelectedItem();
	       	sexoGuardada = (String) sexo.getSelectedItem();
       	
	       	if (pesoGuardada > 30 && pesoGuardada <= 200 &&
   				alturaGuardada >= 100 && alturaGuardada <= 230){

	       		editor.putString("visitado", "true");
	       		editor.putString("tipoDiabetes", diabetesGuardada);
	       		editor.putString("estiloVida", estiloGuardada);
	       		editor.putString("sexo", sexoGuardada);
	       		editor.putString("nacimiento", nacimientoGuardada);
	       		editor.putInt("peso", pesoGuardada);
	       		editor.putInt("altura", alturaGuardada);
	       		editor.commit();

	       		if (prefs.getString("tipoDiabetes", null).equals("Tipo 1")){
	       			Intent intent = new Intent(Configuracion1Activity.this, Configuracion2Tipo1Activity.class);
	       			startActivity(intent);
	       		}
	       		//...
	       	}else{
   			
   			Toast mensaje =Toast.makeText(getApplicationContext(),
                    "Es posible que algun dato como peso y altura sea incorrecto.", Toast.LENGTH_LONG);
	        mensaje.show();
			peso.setText("");altura.setText("");

   			
	       	}
		}
		}
   		
	}
	
	
	
	public void lanzarInfo2(View v){
        showDialog(ALERT_INFO);

	}
	
	
	
	public void lanzarFecha(View v){
		
        showDialog(DATE_DIALOG_ID);

	}
	
	
	
	
    /** Callback received when the user "picks" a date in the dialog */
    DatePickerDialog.OnDateSetListener pDateSetListener =
           new DatePickerDialog.OnDateSetListener() {

               public void onDateSet(DatePicker view, int year, 
                                     int monthOfYear, int dayOfMonth) {
                   pYear = year;
                   pMonth = monthOfYear;
                   pDay = dayOfMonth;
                   updateDisplay();
                   
               }

           };
    
   /** Updates the date in the TextView */
   private void updateDisplay() {
   	nacimiento.setText(
           new StringBuilder()
                   // Month is 0 based so add 1
                   .append(pDay).append("/")
                   .append(pMonth + 1).append("/")
                   .append(pYear).append(""));
   }
    
   
   protected Dialog onCreateDialog(int id) {
   		Dialog dialog;
   		AlertDialog.Builder builder;
   	
       switch (id) {
       case DATE_DIALOG_ID:
           return new DatePickerDialog(this, 
                       pDateSetListener,
                       pYear, pMonth, pDay);
		case ALERT_INFO:
       	builder = new AlertDialog.Builder(this);
           builder.setMessage("Estilo de vida seg�n profesiones\n\n\n" +
           		"Actividad ligera: Oficinistas, m�dicos, enfermeras, jubilados...\n\n" +
           		"Actividad media: Abogados, amas de casa...\n\n" +
           		"Actividad intensa: Contrucci�n, industria ligera, pescadores...\n\n" +
           		"Actividad excepcional intensa: Soldados activos, mineros, deportistas...");
           dialog = builder.create();
           return dialog;
           
       }
       return null;
   }

	

}

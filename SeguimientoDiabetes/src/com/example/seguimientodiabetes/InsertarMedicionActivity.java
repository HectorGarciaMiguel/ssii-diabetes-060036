package com.example.seguimientodiabetes;



import logica_negocio.Recomendacion;
import logica_negocio.Tipo;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.text.Editable;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button; 
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class InsertarMedicionActivity extends Activity {

	Button registrar;
	EditText campoMedicion;
	Tipo t;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_insertar_medicion);
		

		registrar = (Button)findViewById(R.id.button1);
		campoMedicion = (EditText)findViewById(R.id.editText1);
		
		/////
		Spinner cmbOpciones;
		cmbOpciones = (Spinner)findViewById(R.id.CmbOpciones);
		
		final Tipo[] datos=new Tipo[] {Tipo.En_ayunas, Tipo.Antes_actividad_fisica_matutina, Tipo.Antes_comer,
				Tipo.Despues_comer, Tipo.Antes_actividad_fisica_vespertina, Tipo.Antes_cenar, Tipo.En_noche};

		 
		
		
		ArrayAdapter<Tipo> adaptador=new ArrayAdapter<Tipo>(this, android.R.layout.simple_spinner_item, datos);

		adaptador.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item);
		 
		int tipoSegunHora = Recomendacion.getTipoMedicionActualNumero();
		cmbOpciones.setAdapter(adaptador);
		cmbOpciones.setSelection(tipoSegunHora);

		

		cmbOpciones.setOnItemSelectedListener(
		        new AdapterView.OnItemSelectedListener() {
		       
		       
		      public void onItemSelected(AdapterView<?> parent, android.view.View v, int position, long id) {
			        
		    	  t = datos[position];
		      }
       
		 
		      public void onNothingSelected(AdapterView<?> parent) {
		      }
		});
		

		//////////
    		
	}
		
	public void pasarRecomendacionActivity(View v){

		//Recomendacion recomendacion = new Recomendacion( Integer.parseInt(campoMedicion.getText().toString()) );

		Intent i = new Intent(this, RecomendacionActivity.class);
    	Recomendacion rec = new Recomendacion( Integer.parseInt(campoMedicion.getText().toString()), t );
      	i.putExtra("conclusion", rec.getConclusion() );
		
        startActivity(i);		
		
	}


}
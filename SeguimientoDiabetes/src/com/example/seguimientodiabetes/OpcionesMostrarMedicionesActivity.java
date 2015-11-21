package com.example.seguimientodiabetes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.seguimientodiabetes.seguimientodiabetes.R;

public class OpcionesMostrarMedicionesActivity extends Activity {


	RadioButton rdbOne, rdbTwo;
	RadioGroup rdgGrupo;
	Button mostrarActividades;


	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_opciones_mostrar_mediciones);
	
		
		rdgGrupo = (RadioGroup)findViewById(R.id.rdgGrupo);
		mostrarActividades = (Button)findViewById(R.id.button1);
		rdbOne=(RadioButton)findViewById(R.id.rdbOne);
		rdbTwo=(RadioButton)findViewById(R.id.rdbTwo);
		
		
			
		}

		
		public void pasarMostrarMediciones(View v){
			
			
			
			if (rdbOne.isChecked()==true) {
				Intent intent = new Intent(OpcionesMostrarMedicionesActivity.this, MostrarMedicionesListaActivity.class);
				startActivity(intent);;
	        } else
	            if (rdbTwo.isChecked()==true) {
	            	Intent intent = new Intent(OpcionesMostrarMedicionesActivity.this, MostrarActividadesGraficaActivity.class);
					startActivity(intent);               
	            }
	    }    			 
			    	
	}

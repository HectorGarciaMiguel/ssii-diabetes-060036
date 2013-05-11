package com.example.seguimientodiabetes;



import logica_negocio.Recomendacion;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.text.Editable;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button; 
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class InsertarMedicionActivity extends Activity {

	Button registrar;
	EditText campoMedicion;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_insertar_medicion);
		

		registrar = (Button)findViewById(R.id.button1);
		campoMedicion = (EditText)findViewById(R.id.editText1);
    		
	}
		
	public void pasarRecomendacionActivity(View v){

		//Recomendacion recomendacion = new Recomendacion( Integer.parseInt(campoMedicion.getText().toString()) );

		Intent i = new Intent(this, RecomendacionActivity.class);
      	//i.putExtra("conclusion", Recomendacion.getConclusion().toString());
      	//i.putExtra("conclusion", Recomendacion.getTipoMedicionActual().toString());
		Recomendacion rec = new Recomendacion( Integer.parseInt(campoMedicion.getText().toString()) );
      	i.putExtra("conclusion", rec.getConclusion() );

		
        startActivity(i);		
		
	}


}
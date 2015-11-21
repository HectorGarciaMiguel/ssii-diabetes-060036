package com.example.seguimientodiabetes;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.Toast;
import com.seguimientodiabetes.seguimientodiabetes.R;

public class RecomendacionActivity extends Activity {

	TextView estado, insulina, alimentacion, ejercicio;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_recomendacion);

		estado = (TextView) findViewById(R.id.textView9);
		insulina = (TextView) findViewById(R.id.textView3);
		alimentacion = (TextView) findViewById(R.id.textView5);
		ejercicio = (TextView) findViewById(R.id.textView7);

		Toast.makeText(this, "Dato insertado correctamente", Toast.LENGTH_LONG)
				.show();

		////////////////////////////////////////////////////////

		Bundle bundle = getIntent().getExtras();
		
		estado.setText(bundle.getString("estado"));
		
		insulina.setText(bundle.getString("insulinaDosis"));
		
		alimentacion.setText(bundle.getString("alimentacionDieta") 
				+ "\n\nIngesta necesaria:\n"+ bundle.getString("alimentacionNecesaria"));
		
		ejercicio.setText(bundle.getString("ejercicioIngesta"));

	}



	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event){
		if ((keyCode == KeyEvent.KEYCODE_BACK)){
			
				Intent intent = new Intent(RecomendacionActivity.this, PrincipalActivity.class);
				startActivity(intent);
			return true;
		}
	
		return super.onKeyDown(keyCode, event);
	}



}
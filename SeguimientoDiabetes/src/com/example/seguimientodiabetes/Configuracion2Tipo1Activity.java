package com.example.seguimientodiabetes;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.seguimientodiabetes.seguimientodiabetes.R;


public class Configuracion2Tipo1Activity extends Activity {

	EditText prepandrial, nocturna;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_configuracion2_tipo1);
		
		

		prepandrial = (EditText)findViewById(R.id.editText1);
		nocturna = (EditText)findViewById(R.id.editText2);
		
		
	}



public void lanzarConfiguracion3(View v){

	
	SharedPreferences prefs =
			     getSharedPreferences("MisPreferencias",Context.MODE_PRIVATE);
		
	SharedPreferences.Editor editor = prefs.edit();
	
	
	if (prepandrial.getText().length()==0 || nocturna.getText().length()==0){
		Toast mensaje =Toast.makeText(getApplicationContext(),
                "Debe de introducir su dosis correcta recomendada por su m�dico.", Toast.LENGTH_SHORT);
		mensaje.show();
		prepandrial.setText("");nocturna.setText("");
	}else{
	
	
		int valorprepandrial = Integer.parseInt(prepandrial.getText().toString());
		int valornocturno = (Integer.parseInt(nocturna.getText().toString()));
	
		if (valorprepandrial > 0 && valornocturno > 0 &&
				valorprepandrial < 50 && valornocturno < 50){
	
			int dosis = 2 * valorprepandrial + valornocturno;
			editor.putInt("prepandrial", valorprepandrial);
			editor.putInt("dosis", dosis);
			editor.commit();
	
			Intent intent = new Intent(Configuracion2Tipo1Activity.this, Configuracion3Activity.class);
			startActivity(intent);
		
		}else{
		
			Toast mensaje =Toast.makeText(getApplicationContext(),
					"Compruebe la dosis introducida, debe ser mayor que 0 y menor a 50.", Toast.LENGTH_SHORT);
			mensaje.show();
		
		}
	}
}

}
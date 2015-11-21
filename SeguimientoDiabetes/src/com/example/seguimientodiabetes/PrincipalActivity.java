package com.example.seguimientodiabetes;



import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.seguimientodiabetes.seguimientodiabetes.R;

public class PrincipalActivity extends Activity {

	Button insertarMedicion, historialMediciones, seguimientoActividad, alimentacion, consejos;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_principal);
		
		
		insertarMedicion = (Button)findViewById(R.id.button1);
		historialMediciones = (Button)findViewById(R.id.button2);
		seguimientoActividad = (Button)findViewById(R.id.button6);
		alimentacion = (Button)findViewById(R.id.button7);
		consejos = (Button)findViewById(R.id.button8);

		
		
		seguimientoActividad.setEnabled(false);
		//alimentacion.setEnabled(false);
		//consejos.setEnabled(false);
		
		
		
   
		
	}


	public void pasarHistorialMedicionActivity (View v){
      	
    	Intent intent = new Intent(PrincipalActivity.this, OpcionesMostrarMedicionesActivity.class);
	   	startActivity(intent);
	
}
	public void pasarInsertarMedicionActivity (View v){
		      	
        	Intent intent = new Intent(PrincipalActivity.this, InsertarMedicionActivity.class);
		   	startActivity(intent);
		
	}
	
	public void pasarOpcionesMostrarActividadesActivity (View v){
		
		Intent intent = new Intent(PrincipalActivity.this, OpcionesMostrarActividadesActivity.class);
	   	startActivity(intent);
				
	}
	
	public void pasarConfiguracion (View v){
		
		Intent intent = new Intent(PrincipalActivity.this, Configuracion1Activity.class);
	   	startActivity(intent);
				
	}
	
	public void lanzarRegistrarActividad(View v){
		
		Intent intent = new Intent(PrincipalActivity.this, RegistrarActividadActivity.class);
	   	startActivity(intent);
		
	}
	
	
	public void onBackPressed(){
		Intent a = new Intent(Intent.ACTION_MAIN);
		a.addCategory(Intent.CATEGORY_HOME);
		a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		startActivity(a);
		}
	

}

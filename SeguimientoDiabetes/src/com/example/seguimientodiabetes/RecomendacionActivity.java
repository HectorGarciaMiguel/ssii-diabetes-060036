package com.example.seguimientodiabetes;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class RecomendacionActivity extends Activity {
	
	
	TextView conclusion;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_recomendacion);
		

		conclusion = (TextView)findViewById(R.id.textView2);
		
		Toast.makeText(this, "Dato insertado correctamente",Toast.LENGTH_LONG).show();

		
		Bundle bundle = getIntent().getExtras();
        conclusion.setText(bundle.getString("conclusion"));
		
		
		
	}


}
package com.example.seguimientodiabetes;


import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.seguimientodiabetes.seguimientodiabetes.R;


public class SplashActivity extends Activity {

    private ProgressBar mProgress;
    private int mProgressStatus = 0;
    private Handler mHandler = new Handler();
    public ProgressDialog myDialog; 
    public TextView textView1; 


	    @Override
	    public void onCreate(Bundle savedInstanceState) {

	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_splash);
	        
	         mProgress = (ProgressBar) findViewById(R.id.progressBar1);
	         textView1 = (TextView) findViewById(R.id.textView1);

	         
	         SharedPreferences prefs =
				     getSharedPreferences("MisPreferencias",Context.MODE_PRIVATE);
			
			if (prefs.getString("visitado", "").equals("true")){
				textView1.setText("Iniciando la aplicación...");
			}
			else{
				textView1.setText("Abriendo por primera vez.\n\nIniciando el asistente de configuración...");					
			}
	         
	         
	         
	         
	         
	         
	         
	         new Thread(new Runnable() {
	             public void run() {
	                 while (mProgressStatus < 100) {
	                     mProgressStatus = mProgressStatus + 1;
	                     try {
							Thread.sleep(30);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	                     // Update the progress bar
	                     mHandler.post(new Runnable() {
	                         public void run() {
	                             mProgress.setProgress(mProgressStatus);
	                            
	                         }
	                     });       
	                 }
	                 lanzarPrincipal();
	    	         finish();

	             }

			
	             
	             
   			   	
	         }).start();
	         
	         
	         
	         
	         
	    }
	    
	    
	    
	    
	    
		private void lanzarPrincipal() {
			
			
			SharedPreferences prefs =
				     getSharedPreferences("MisPreferencias",Context.MODE_PRIVATE);
			
			if (prefs.getString("visitado", "").equals("true")){
				Intent intent = new Intent(SplashActivity.this, PrincipalActivity.class);
				startActivity(intent);
			}
			else{
				Intent intent = new Intent(SplashActivity.this, Configuracion1Activity.class);
				startActivity(intent);
					
			}
			
			
		}
	}
	
	
	
	
	
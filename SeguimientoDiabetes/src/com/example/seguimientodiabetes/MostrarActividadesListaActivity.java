package com.example.seguimientodiabetes;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.seguimientodiabetes.seguimientodiabetes.R;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class MostrarActividadesListaActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_actividades_lista);
        
        ////////////////////////////////////////////////////////
        
        SharedPreferences prefs =
        	     getSharedPreferences("MisPreferencias",Context.MODE_PRIVATE);
        	 
        	String lunes = prefs.getString("lunes", "error");
        	String martes = prefs.getString("martes", "error");
        	String miercoles = prefs.getString("miercoles", "error");
        	String jueves = prefs.getString("jueves", "error");
        	String viernes = prefs.getString("viernes", "error");
        	String sabado = prefs.getString("sabado", "error");
        	String domingo = prefs.getString("domingo", "error");

        	
        	String[] arraylunes = lunes.split (" ");
        	String[] arraymartes = martes.split (" "); 
        	String[] arraymiercoles = miercoles.split (" "); 
        	String[] arrayjueves = jueves.split (" "); 
        	String[] arrayviernes = viernes.split (" "); 
        	String[] arraysabado = sabado.split (" "); 
        	String[] arraydomingo = domingo.split (" "); 

        
        
        
/////////////////////////////////////////////////////////////////
        ArrayList<Lista_entrada> datos = new ArrayList<Lista_entrada>();  

    	if (lunes.charAt(0)!=' '){
    		datos.add(new Lista_entrada(R.drawable.actividad, "Lunes", (arraylunes[0] + " " + arraylunes[1] + " minutos a las " + arraylunes[2]) ));
    	}
    	
    	if (martes.charAt(0)!=' '){
    		datos.add(new Lista_entrada(R.drawable.actividad, "Martes", (arraymartes[0] + " " + arraymartes[1] + " minutos a las " + arraymartes[2]) ));
    	}
    	
    	if (miercoles.charAt(0)!=' '){
    		datos.add(new Lista_entrada(R.drawable.actividad2, "Miércoles", (arraymiercoles[0] + " " + arraymiercoles[1] + " minutos a las " + arraymiercoles[2]) ));
    	}
    	
    	if (jueves.charAt(0)!=' '){
    		datos.add(new Lista_entrada(R.drawable.actividad, "Jueves", (arrayjueves[0] + " " + arrayjueves[1] + " minutos a las " + arrayjueves[2]) ));
    	}
    	
    	if (viernes.charAt(0)!=' '){
    		datos.add(new Lista_entrada(R.drawable.actividad3, "Viernes", (arrayviernes[0] + " " + arrayviernes[1] + " minutos a las " + arrayviernes[2]) ));
    	}
    	
    	if (sabado.charAt(0)!=' '){
    		datos.add(new Lista_entrada(R.drawable.actividad2, "Sábado", (arraysabado[0] + " " + arraysabado[1] + " minutos a las " + arraysabado[2]) ));
    	}
    	
    	if (domingo.charAt(0)!=' '){
    		datos.add(new Lista_entrada(R.drawable.actividad3, "Domingo", (arraydomingo[0] + " " + arraydomingo[1] + " minutos a las " + arraydomingo[2]) ));
    	}
    	
    	
    
        ListView lista = (ListView) findViewById(R.id.activity_mostrar_actividades_lista);
        lista.setAdapter(new Lista_adaptador(this, R.layout.actividad, datos){
		
			public void onEntrada(Object entrada, View view) {
		        if (entrada != null) {
		            TextView texto_superior_entrada = (TextView) view.findViewById(R.id.textView_superior); 
		            if (texto_superior_entrada != null) 
		            	texto_superior_entrada.setText(((Lista_entrada) entrada).get_textoEncima()); 

		            TextView texto_inferior_entrada = (TextView) view.findViewById(R.id.textView_inferior); 
		            if (texto_inferior_entrada != null)
		            	texto_inferior_entrada.setText(((Lista_entrada) entrada).get_textoDebajo()); 

		            ImageView imagen_entrada = (ImageView) view.findViewById(R.id.imageView_imagen); 
		            if (imagen_entrada != null)
		            	imagen_entrada.setImageResource(((Lista_entrada) entrada).get_idImagen());
		        }
			}
		});

        lista.setOnItemClickListener(new OnItemClickListener() { 
			
			public void onItemClick(AdapterView<?> pariente, View view, int posicion, long id) {
				Lista_entrada elegido = (Lista_entrada) pariente.getItemAtPosition(posicion); 

                CharSequence texto = "Seleccionado: " + elegido.get_textoDebajo();
                Toast toast = Toast.makeText(MostrarActividadesListaActivity.this, texto, Toast.LENGTH_LONG);
                toast.show();
			}
        });

    }


    
    
    
    
    

}
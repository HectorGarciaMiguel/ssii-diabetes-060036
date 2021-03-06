package com.example.seguimientodiabetes;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.seguimientodiabetes.seguimientodiabetes.R;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class MostrarMedicionesListaActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_mediciones_lista);
        
        ////////////////////////////////////////////////////////
        
        Date date = new Date();
        Calendar calendar1 = Calendar.getInstance();
        Calendar calendar2 = new GregorianCalendar();
        
     // Instanciamos el objeto Calendar
        Calendar calendar = Calendar.getInstance();
        // Obtenemos el valor del a�o, mes y d�a.
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int date2 = calendar.get(Calendar.DATE);
        int dia = calendar.get(Calendar.DAY_OF_WEEK);
        String a="";
        
        switch (dia){
        case 1: a= "Domingo";
        	break;
        case 2: a="Lunes";
    		break;
        case 3: a="Martes";
    		break;
    	case 4: a="Miercoles";
    		break;
    	case 5: a="Jueves";
    		break;
    	case 6: a="Viernes";
    		break;
    	case 7: a="Sabado";
    		break;
        
        }
        	 
        a = a + " " + (date2) + "/" + (month) + "/" + (year);
        

        	
        	String[] enAyunas = {"80", "Optimo"};
        	String[] actividadMatutina = {" ", " "};
        	String[] antesComer = {"150", "Alto"}; 
        	String[] despuesComer = {"70", "Bajo"};
        	String[] actividadVerpertina = {" ", " "};
        	String[] antesCenar = {"100", "Aceptable"};
        	String[] enNoche = {"", ""};

        
        
        
/////////////////////////////////////////////////////////////////
        ArrayList<Lista_entrada> datos = new ArrayList<Lista_entrada>();  

    		datos.add(new Lista_entrada(R.drawable.gota2, a, (enAyunas[0] + " mg/dl y estado " + enAyunas[1]) ));
    	    	
    		datos.add(new Lista_entrada(R.drawable.gota2, a, (antesComer[0] + " mg/dl y estado " + antesComer[1]) ));
    	
    		datos.add(new Lista_entrada(R.drawable.gota2, a, (despuesComer[0] + " mg/dl y estado " + despuesComer[1])  ));
    	
       		datos.add(new Lista_entrada(R.drawable.gota2, a, (antesCenar[0] + " mg/dl y estado " + antesCenar[1] ) ));
    	
       	
    	
   
    	
    
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
                Toast toast = Toast.makeText(MostrarMedicionesListaActivity.this, texto, Toast.LENGTH_LONG);
                toast.show();
			}
        });

    }


    
    
    
    
    

}
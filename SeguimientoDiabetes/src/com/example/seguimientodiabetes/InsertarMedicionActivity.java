package com.example.seguimientodiabetes;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import com.seguimientodiabetes.seguimientodiabetes.R;
import logica_negocio.Alimentacion;
import logica_negocio.Ejercicio;
import logica_negocio.Intensidad;
import logica_negocio.Recomendacion;
import logica_negocio.TipoDiabetico;
import logica_negocio.TipoMedicion;

public class InsertarMedicionActivity extends Activity {

	Button registrar;
	EditText campoMedicion;
	TipoMedicion tipoMedicion;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_insertar_medicion);

		registrar = (Button) findViewById(R.id.button1);
		campoMedicion = (EditText) findViewById(R.id.editText1);

		//////
		Spinner cmbOpciones;
		cmbOpciones = (Spinner) findViewById(R.id.CmbOpciones);

		final TipoMedicion[] datos = new TipoMedicion[] {
				TipoMedicion.En_ayunas,
				TipoMedicion.Antes_actividad_fisica_matutina,
				TipoMedicion.Antes_comer, TipoMedicion.Despues_comer,
				TipoMedicion.Antes_actividad_fisica_vespertina,
				TipoMedicion.Antes_cenar, TipoMedicion.En_noche };

		ArrayAdapter<TipoMedicion> adaptador = new ArrayAdapter<TipoMedicion>(
				this, android.R.layout.simple_spinner_item, datos);

		adaptador
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		int tipoSegunHora = getTipoMedicionActualNumero();
		cmbOpciones.setAdapter(adaptador);
		cmbOpciones.setSelection(tipoSegunHora);

		cmbOpciones
				.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

					public void onItemSelected(AdapterView<?> parent,
							android.view.View v, int position, long id) {

						tipoMedicion = datos[position];
					}

					public void onNothingSelected(AdapterView<?> parent) {
					}
				});

	

	}

	public void pasarRecomendacionActivity(View v) {
		
		
		//Recuperar datos personales
		int recomendadaMedico;
		int unidadesDiarias;
		Intensidad intensidad=Intensidad.Intensa;

		SharedPreferences prefs =
       	     getSharedPreferences("MisPreferencias",Context.MODE_PRIVATE);
       	 
		recomendadaMedico = prefs.getInt("prepandrial", 0);
		unidadesDiarias = prefs.getInt("dosis", 0);
		
		if (campoMedicion.getText().length()==0){
			Toast mensaje =Toast.makeText(getApplicationContext(),
                    "Se ha olvidado de introducir el resultado de la medici�n.", Toast.LENGTH_SHORT);
			mensaje.show();
			campoMedicion.setText("");
		}else{
		
	       	int campoMedicionUsuario = Integer.parseInt(campoMedicion.getText().toString());
			
			if (campoMedicionUsuario >= 20  && campoMedicionUsuario <= 350 ){
				Intent i = new Intent(this, RecomendacionActivity.class);
		
				///////////////////////////////////////////////////////////////	
				
				 Recomendacion recomendacion = new Recomendacion(recomendadaMedico, unidadesDiarias,
						 	campoMedicionUsuario, tipoMedicion, TipoDiabetico.Tipo1, intensidad);
				
				String estado = recomendacion.toEstado().toString(); 
				String insulinaDosis = recomendacion.getDosisInsulina();
				
				i.putExtra("estado",  estado);
				i.putExtra("insulinaDosis",  insulinaDosis);
				
				///////////////////////////////////////////////////////////////	
		
				Alimentacion alimentacion = new Alimentacion (1250, Integer.parseInt(campoMedicion.getText().toString()),
						tipoMedicion);
				
				String alimentacionDieta = alimentacion.getDieta();
				String alimentacionNecesaria = alimentacion.getIngestaNecesaria();
		
				i.putExtra("alimentacionDieta",  alimentacionDieta);
				i.putExtra("alimentacionNecesaria",  alimentacionNecesaria);
				
				///////////////////////////////////////////////////////////////	
				
				Ejercicio ejercicio = new Ejercicio (Integer.parseInt(campoMedicion.getText().toString()),
						tipoMedicion, intensidad);
				
				String ejercicioIngesta = ejercicio.getIngestaEjercicio();
				i.putExtra("ejercicioIngesta",  ejercicioIngesta);
		
				///////////////////////////////////////////////////////////////	
				
				registrar.setEnabled(false);
				startActivity(i);
			}else{
				Toast mensaje =Toast.makeText(getApplicationContext(),
	                    "Debe de introducir la medici�n de entre 20 y 350 mg/dl.", Toast.LENGTH_SHORT);
				mensaje.show();
				campoMedicion.setText("");
			}
		}
	}
	
	
	
	
	///////////////////////////////////////////////////////////////////////////////////
	
	public int getActualTimeMinutes() {
		Date hora = new Date();
		SimpleDateFormat formatoHora = new SimpleDateFormat("HH");
		SimpleDateFormat formatoMinuto = new SimpleDateFormat("mm");
		String numeroHora = formatoHora.format(hora);
		String numeroMinuto = formatoMinuto.format(hora);
		int horaActualMinutos = (Integer.parseInt(numeroHora.toString()) * 100)
				+ (Integer.parseInt(numeroMinuto.toString()));

		Log.d("hola",
				Integer.toString(Integer.parseInt(numeroHora.toString()) * 100));
		Log.d("hola",
				Integer.toString((Integer.parseInt(numeroMinuto.toString()))));
		Log.d("hola", Integer.toString(horaActualMinutos));

		return horaActualMinutos;
	}
	
	public int getTipoMedicionActualNumero() {

		int horaActualMinutos = getActualTimeMinutes();

		int tipo;

		if (horaActualMinutos >= 600 && horaActualMinutos <= 1000) {
			tipo = 0;
		} else {
			if (horaActualMinutos > 1000 && horaActualMinutos <= 1330) {
				tipo = 1;
			} else {
				if (horaActualMinutos > 1330 && horaActualMinutos <= 1500) {
					tipo = 2;
				} else {
					if (horaActualMinutos > 1500 && horaActualMinutos <= 1630) {
						tipo = 3;
					} else {
						if (horaActualMinutos > 1630
								&& horaActualMinutos <= 2030) {
							tipo = 4;
						} else {
							if (horaActualMinutos > 2030
									&& horaActualMinutos <= 2230) {
								tipo = 5;
							} else {
								if (horaActualMinutos > 2230
										&& horaActualMinutos <= 2400) {
									tipo = 6;
								} else {
									tipo = 6;
								}
							}

						}
					}
				}
			}
		}

		return tipo;

	}

	
	

}
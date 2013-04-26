package logica_negocio;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import android.text.format.Time;
import android.util.Log;

public class Recomendacion {

	private Integer glucosa;
	private String hora;
	private String fecha;
	
	private String estado;
	private DosisInsulina dosisInsulina;
	private Alimentacion alimentacion;
	private Ejercicio ejercicio;
	
	private static String conclusion;

	
	
	//constructor
	public Recomendacion (int valorMedicion)
	{

		glucosa = valorMedicion;
		//hora = getActualTime();
		//fecha = getActualDate();
		
		//Generar recomendación
		//estado = toEstado(glucosa); 
		conclusion = toEstado(glucosa);
		//dosisInsulina = new DosisInsulina();
		//alimentacion = new Alimentacion();
		//ejercicio = new Ejercicio();
		
		//Texto a mostrar por pantalla
		//conclusion = dosisInsulina.getConclusion() + alimentacion.getConclusion() + ejercicio.getConclusion();
		
		//Almacenar recomendación
			//guardar fecha
			//guardar hora
			//guardar glucosa
	}
	
	public static String getTipoMedicionActual(){

		Date hora = new Date();
		SimpleDateFormat formatoHora = new SimpleDateFormat("HH");
		SimpleDateFormat formatoMinuto = new SimpleDateFormat("mm");
		String numeroHora = formatoHora.format(hora);
		String numeroMinuto = formatoMinuto.format(hora);
		int horaActualMinutos = 
				(Integer.parseInt(numeroHora.toString()) * 100) + (Integer.parseInt(numeroMinuto.toString()));
		
		Log.d("hola", Integer.toString(Integer.parseInt(numeroHora.toString()) * 100));
		Log.d("hola", Integer.toString((Integer.parseInt(numeroMinuto.toString() ) )));
		Log.d("hola", Integer.toString(horaActualMinutos));
		
		if (horaActualMinutos >= 0600 && horaActualMinutos <= 1000){
			return "En ayunas";
		}
		else{
			if (horaActualMinutos > 1000 && horaActualMinutos <= 1330){
				return "Antes de actividad fisica (matutina)";
			}
			else{
				if (horaActualMinutos > 1330 && horaActualMinutos <= 1500){
					return "Antes de comer";
				}
				else{
					if (horaActualMinutos > 1500 && horaActualMinutos <= 1630){
						return "Despues de comer";
					}
					else{
						if (horaActualMinutos > 1630 && horaActualMinutos <= 2030){
							return "Antes de actividad fisica (verpertina)";
						}
						else{
							if (horaActualMinutos > 2030 && horaActualMinutos <= 2230){
								return "Antes de cenar";
							}
							else{
								if (horaActualMinutos > 2230 && horaActualMinutos <= 2400){
									return "En la noche";
								}
								else{
									return "En la noche";
								}
							}
								
						}
					}
				}
			}
		}

	}
		

	
	public String toEstado(int i){
		
		Object[][] intervaloAyunas = logica_negocio.Informacion.getIntervaloAyunas();
		int x=0;
		
		while (x <= intervaloAyunas.length){
			
			if( Integer.parseInt( intervaloAyunas[x][1].toString() )>i && 
					Integer.parseInt( intervaloAyunas[x][2].toString() )<i){
				
				return intervaloAyunas[x][0].toString();
			}
		
		}
		//error: el intervalo no contempla todos los casos
		return null;
	}
	
	public static String getConclusion(){
		return conclusion;
	}
	
	public static String getActualTime(){
		
		Date hora = new Date();
		SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
		return formatoHora.format(hora);
	}
	public String getActualDate(){
		
		Calendar cal = new GregorianCalendar();
	    Date fecha = cal.getTime();
	    SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
	    return formatoFecha.format(fecha);
    
	}
}

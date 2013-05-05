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
		conclusion = toEstado(glucosa, "tipoMedicion", "intensidad");
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
		

	
	public static String toEstado(int medicion, String tipoMedicion, String intensidad){
		
		if (tipoMedicion=="En ayunas" || tipoMedicion=="Antes de comer" || tipoMedicion=="Antes de cenar"){
			
			if(medicion<80){
				return "Malo";
			}
			else{
				if(80<=medicion && medicion<=109){
					return "Optimo";
				}
				else{
					if (110<=medicion && medicion<=129){
						return "Aceptable";
					}
					else{
						if (medicion>=130){
							return "Malo";
						}
						else{
							return "Error";
						}
					}
				}
			}
			
			
		}
		else
		{
			if (tipoMedicion=="Despues de comer"){
				
				if(medicion<80){
					return "Malo";
				}
				else{
					if(80<=medicion && medicion<=99){
						return "Aceptable";
					}
					else{
						if (100<=medicion && medicion<=179){
							return "Optimo";
						}
						else{
							if (medicion>=180){
								return "Malo";
							}
							else{
								return "Error";
							}
						}
					}
				}
				
				
			}
			else{
				if(tipoMedicion=="Antes de actividad fisica (matutina)" || tipoMedicion=="Antes de actividad fisica (vespertina)"){
			
					if(intensidad=="Baja"){
						
						if(medicion<=99){
							return "Aceptable Baja";
						}
						else{
							if(medicion>=100){
								return "Aceptable Alta";
							}
							else{
								return "Error";
							}
						}
						
					}
					else{
							
						if(intensidad=="Moderada" || intensidad=="Intenso"){
							
							if(medicion<=99){
								return "Aceptable Baja";
							}
							else{
								if(medicion>=100 && medicion <=179){
									return "Optima";
								}
								else{
									if(medicion>=180 && medicion <=299){
										return "Alta";
									}
									else{
										if (medicion>=300){
											return "Malo";
										}
										else{
											return "Error";
										}
									}
								}
							}
						}
					
				
					else{
					
						if(tipoMedicion=="En la noche"){
							
							if(medicion<80){
								return "Malo";
							}
							else{
								if(80<=medicion && medicion<=139){
									return "Optimo";
								}
								else{
									if (medicion>=140){
										return "Malo";
									}
									else{
										return "Error";
									}
								}
							}
						}
						
					}
						return "Error";
					}
				}
				else{
					return "Error";
				}
					
			}
				
			}
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

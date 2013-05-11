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
	
	/*private enum tipo{	En_ayunas, Antes_actividad_fisica_matutina, Antes_comer, 
		Despues_comer, Antes_actividad_fisica_vespertina, Antes_cenar, En_noche};
		
	private enum estado{Muy_bajo, Bajo, Optimo, Aceptable_bajo, Aceptable, Aceptable_alto, Alto, Muy_alto};*/
	
	
	private Tipo tipo;
	private Estado estado;
	
	private Intensidad intensidad;
	
	
	private DosisInsulina dosisInsulina;
	private Alimentacion alimentacion;
	private Ejercicio ejercicio;
	
	private static String conclusion;
	
	
	//constructor
	public Recomendacion (int valorMedicion, int i)
	{

		glucosa = valorMedicion;
		
		//Generar recomendación
		tipo = getTipoMedicionActual(i);
		estado = toEstado(glucosa, tipo, null); ///FALTA PASAR INTENSIDAD
		
		//dosisInsulina = new DosisInsulina();
		//alimentacion = new Alimentacion();
		//ejercicio = new Ejercicio();
		
		//Texto a mostrar por pantalla
		//conclusion = dosisInsulina.getConclusion() + alimentacion.getConclusion() + ejercicio.getConclusion();
		conclusion = tipo.toString() + " " + estado.toString();
		//Almacenar recomendación
			//guardar fecha
			//guardar hora
			//guardar glucosa
	}
	
	
	
	/////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////
public static int getTipoMedicionActualNumero(){

int horaActualMinutos = getActualTimeMinutes();

int tipo;

if (horaActualMinutos >= 600 && horaActualMinutos <= 1000){
tipo = 0;
}
else{
if (horaActualMinutos > 1000 && horaActualMinutos <= 1330){
tipo = 1;
}
else{
if (horaActualMinutos > 1330 && horaActualMinutos <= 1500){
tipo = 2;
}
else{
if (horaActualMinutos > 1500 && horaActualMinutos <= 1630){
tipo = 3;
}
else{
if (horaActualMinutos > 1630 && horaActualMinutos <= 2030){
tipo = 4;
}
else{
if (horaActualMinutos > 2030 && horaActualMinutos <= 2230){
tipo = 5;
}
else{
if (horaActualMinutos > 2230 && horaActualMinutos <= 2400){
tipo = 6;
}
else{
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
/////////////////////////////////////////////////////////

	public static Tipo getTipoMedicionActual(int i){
		
		Tipo tipo;
		
		switch(i){
		case 0:
			tipo = Tipo.En_ayunas;
			break;
		case 1:
			tipo = Tipo.Antes_actividad_fisica_matutina;
			break;
		case 2:
			tipo = Tipo.Antes_comer;
			break;
		case 3:
			tipo = Tipo.Despues_comer;
			break;
		case 4:
			tipo = Tipo.Antes_actividad_fisica_vespertina;
			break;
		case 5:
			tipo = Tipo.Antes_cenar;
			break;
		case 6:
			tipo = Tipo.En_noche;
			break;
		default:
			tipo = Tipo.Error;
			break;
		}
		
		return tipo;
	}

//////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////
	public Tipo getTipoMedicionActual(){

		int horaActualMinutos = getActualTimeMinutes();
		
		Tipo tipo;
		
		if (horaActualMinutos >= 600 && horaActualMinutos <= 1000){
			tipo = Tipo.En_ayunas;
		}
		else{
			if (horaActualMinutos > 1000 && horaActualMinutos <= 1330){
				tipo = Tipo.Antes_actividad_fisica_matutina;
			}
			else{
				if (horaActualMinutos > 1330 && horaActualMinutos <= 1500){
					tipo = Tipo.Antes_comer;
				}
				else{
					if (horaActualMinutos > 1500 && horaActualMinutos <= 1630){
						tipo = Tipo.Despues_comer;
					}
					else{
						if (horaActualMinutos > 1630 && horaActualMinutos <= 2030){
							tipo = Tipo.Antes_actividad_fisica_vespertina;
						}
						else{
							if (horaActualMinutos > 2030 && horaActualMinutos <= 2230){
								tipo = Tipo.Antes_cenar;
							}
							else{
								if (horaActualMinutos > 2230 && horaActualMinutos <= 2400){
									tipo = Tipo.En_noche;
								}
								else{
									tipo = Tipo.En_noche;
									}
							}
								
						}
					}
				}
			}
		}
		
		return tipo;

	}
	//////////////////////////////////////////////////////////////////////////////////////
	
	
	//////////////////////////////////////////////////////////////////////////////////////
	public static Estado toEstado(int medicion, Tipo tipoMedicion, Intensidad intensidad){
		
		Estado estado = Estado.Error;

		
		
		switch (tipoMedicion){
		
		case En_ayunas:
			
			if(medicion<80){
				estado = Estado.Muy_bajo;
			}
			else{
				if(80<=medicion && medicion<=109){
					estado = Estado.Optimo;
				}
				else{
					if (110<=medicion && medicion<=129){
						estado = Estado.Aceptable;
					}
					else{
						if (medicion>=130){
							estado = Estado.Muy_alto;
						}
						else{
							estado = Estado.Error;
						}
					}
				}
			}
			
			break; 

		case Antes_actividad_fisica_matutina:
			
			switch(intensidad){
			
			case Baja:
				if(medicion<=99){
					estado = Estado.Aceptable_bajo;
				}
				else{
					if(medicion>=100){
						estado = Estado.Aceptable_alto;
					}
					else{
						estado = Estado.Error;
					}
				}

				
				break;
				
				
			case Moderada:
				
				if(medicion<=99){
					estado =  Estado.Aceptable_bajo;
				}
				else{
					if(medicion>=100 && medicion <=179){
						estado = Estado.Optimo;
					}
					else{
						if(medicion>=180 && medicion <=299){
							estado = Estado.Alto;
						}
						else{
							if (medicion>=300){
								estado = Estado.Muy_alto;
							}
							else{
								estado = Estado.Error;
							}
						}
					}
				}
				

				break;
				
			case Intensa:
				
				if(medicion<=99){
					estado =  Estado.Aceptable_bajo;
				}
				else{
					if(medicion>=100 && medicion <=179){
						estado = Estado.Optimo;
					}
					else{
						if(medicion>=180 && medicion <=299){
							estado = Estado.Alto;
						}
						else{
							if (medicion>=300){
								estado = Estado.Muy_alto;
							}
							else{
								estado = Estado.Error;
							}
						}
					}
				}
				

				break;
				
			default: 
				estado = Estado.Error;
				break;
			
			}
			break;

		case Antes_comer:
			
			if(medicion<80){
				estado = Estado.Muy_bajo;
			}
			else{
				if(80<=medicion && medicion<=109){
					estado = Estado.Optimo;
				}
				else{
					if (110<=medicion && medicion<=129){
						estado = Estado.Aceptable;
					}
					else{
						if (medicion>=130){
							estado = Estado.Muy_alto;
						}
						else{
							estado = Estado.Error;
						}
					}
				}
			}
			
			break;

		case Despues_comer:
			
			if(medicion<80){
				estado = Estado.Muy_bajo;
			}
			else{
				if(80<=medicion && medicion<=99){
					estado =  Estado.Aceptable;
				}
				else{
					if (100<=medicion && medicion<=179){
						estado =  Estado.Optimo;
					}
					else{
						if (medicion>=180){
							estado =  Estado.Muy_alto;
						}
						else{
							estado =  Estado.Error;
						}
					}
				}
			}
			
			break; 

		case Antes_actividad_fisica_vespertina:
			
			break; 

		case Antes_cenar: 
					
			if(medicion<80){
				estado = Estado.Muy_bajo;
			}
			else{
				if(80<=medicion && medicion<=109){
					estado = Estado.Optimo;
				}
				else{
					if (110<=medicion && medicion<=129){
						estado = Estado.Aceptable;
					}
					else{
						if (medicion>=130){
							estado = Estado.Muy_alto;
						}
						else{
							estado = Estado.Error;
						}
					}
				}
			}
			
			break; 

		case En_noche: 
			
			if(medicion<80){
				estado =  Estado.Muy_bajo;
			}
			else{
				if(80<=medicion && medicion<=139){
					estado = Estado.Optimo;
				}
				else{
					if (medicion>=140){
						estado = Estado.Muy_alto;
					}
					else{
						estado = Estado.Error;
					}
				}
			}
			
			break; 

		default:
			estado = Estado.Error;

			break; 

	}

return estado;

}

	//////////////////////////////////////////////////////////////////////////////////////


	//////////////////////////////////////////////////////////////////////////////////
	
	
	public String getDosisInsulina(Tipo tipoMedicion, Estado estado){

		String resultado = "Init";
		
		switch (tipoMedicion){
	
			case En_ayunas:
				
				switch (estado){
				
				case Muy_bajo:
					resultado = "No insulina";
					break;
				case Optimo:
					
					break;
				case Aceptable:
					
					break;
					
				case Muy_alto:
					
					break;
				default: break;			
				}
				
				break; 

			case Antes_actividad_fisica_matutina:
				
				switch(intensidad){
				
				case Baja:
					
					switch (estado){
					
					case Aceptable_bajo:
						
						break;
					case Aceptable_alto:
						
						break;
					default: break;
					
					}
					break;
					
				case Moderada:
					switch (estado){
					
					case Aceptable_bajo:
						
						break;
					case Optimo:
						
						break;
					case Alto:
						
						break;
					case Muy_alto:
						
						break;
					default: break;
					
					}
					break;
					
				case Intensa:
					switch (estado){
					
					case Aceptable_bajo:
						
						break;
					case Optimo:
						
						break;
					case Alto:
						
						break;
					case Muy_alto:
						
						break;
					default: break;
					
					}
					break;
					
					default: break;
				}
				break; 

			case Antes_comer:
				switch (estado){
				
				case Muy_bajo:
					resultado = "No insulina";
					break;
				case Optimo:
					
					break;
				case Aceptable:
					
					break;
					
				case Muy_alto:
					
					break;
				default: break;			
				}
				
				break; 

			case Despues_comer:
				switch (estado){
				
				case Muy_bajo:
					resultado = "No insulina";
					break;
				case Aceptable:
					
					break;
				case Optimo:
					
					break;
					
				case Muy_alto:
					
					break;
				default: break;			
				}
				
				break; 

			case Antes_actividad_fisica_vespertina:
				
				break; 

			case Antes_cenar: 
				switch (estado){
				
				case Muy_bajo:
					resultado = "No insulina";
					break;
				case Optimo:
					
					break;
				case Aceptable:
					
					break;
					
				case Muy_alto:
					
					break;
				default: break;			
				}
				
				break; 

			case En_noche: 
				switch (estado){
				
				case Muy_bajo:
					resultado = "No insulina";
					break;
				case Optimo:
					
					break;	
				case Muy_alto:
					
					break;
				default: break;			
				}
				
				break; 

			default:
				break; 
	
		}
	
	return resultado;

	}
	
	
	
	
	public static int getActualTimeMinutes(){
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
		
		return horaActualMinutos;
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

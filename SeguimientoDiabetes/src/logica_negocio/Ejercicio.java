package logica_negocio;

import java.util.ArrayList;

public class Ejercicio {

	
	private int medicion;
	private TipoMedicion tipoMedicion;
	private EstadoMedicion estado;
	private Intensidad intensidad;
	
	
	public Ejercicio(int valorMedicion, TipoMedicion tipoMedicion, Intensidad intensidad){
		
		this.medicion = valorMedicion;
		this.tipoMedicion = tipoMedicion;
		this.intensidad = intensidad;

		this.estado = toEstado();
		
	}
	
	/////////////////////////////////////////////////////////////////

	public EstadoMedicion toEstado() {

		EstadoMedicion estado = EstadoMedicion.Error;

		switch (tipoMedicion) {

		case En_ayunas:

			if (this.medicion < 80) {
				estado = EstadoMedicion.Muy_bajo;
			} else {
				if (80 <= medicion && medicion <= 109) {
					estado = EstadoMedicion.Optimo;
				} else {
					if (110 <= medicion && medicion <= 129) {
						estado = EstadoMedicion.Aceptable;
					} else {
						if (medicion >= 130) {
							estado = EstadoMedicion.Muy_alto;
						} else {
							estado = EstadoMedicion.Error;
						}
					}
				}
			}

			break;

		case Antes_actividad_fisica_matutina:

			switch (intensidad) {

			case Baja:
				if (medicion <= 99) {
					estado = EstadoMedicion.Aceptable_bajo;
				} else {
					if (medicion >= 100) {
						estado = EstadoMedicion.Aceptable_alto;
					} else {
						estado = EstadoMedicion.Error;
					}
				}

				break;

			case Moderada:

				if (medicion <= 99) {
					estado = EstadoMedicion.Aceptable_bajo;
				} else {
					if (medicion >= 100 && medicion <= 179) {
						estado = EstadoMedicion.Optimo;
					} else {
						if (medicion >= 180 && medicion <= 299) {
							estado = EstadoMedicion.Alto;
						} else {
							if (medicion >= 300) {
								estado = EstadoMedicion.Muy_alto;
							} else {
								estado = EstadoMedicion.Error;
							}
						}
					}
				}

				break;

			case Intensa:

				if (medicion <= 99) {
					estado = EstadoMedicion.Aceptable_bajo;
				} else {
					if (medicion >= 100 && medicion <= 179) {
						estado = EstadoMedicion.Optimo;
					} else {
						if (medicion >= 180 && medicion <= 299) {
							estado = EstadoMedicion.Alto;
						} else {
							if (medicion >= 300) {
								estado = EstadoMedicion.Muy_alto;
							} else {
								estado = EstadoMedicion.Error;
							}
						}
					}
				}

				break;

			default:
				estado = EstadoMedicion.Error;
				break;

			}

			break;

		case Antes_comer:

			if (medicion < 80) {
				estado = EstadoMedicion.Muy_bajo;
			} else {
				if (80 <= medicion && medicion <= 109) {
					estado = EstadoMedicion.Optimo;
				} else {
					if (110 <= medicion && medicion <= 129) {
						estado = EstadoMedicion.Aceptable;
					} else {
						if (medicion >= 130) {
							estado = EstadoMedicion.Muy_alto;
						} else {
							estado = EstadoMedicion.Error;
						}
					}
				}
			}

			break;

		case Despues_comer:

			if (medicion < 80) {
				estado = EstadoMedicion.Muy_bajo;
			} else {
				if (80 <= medicion && medicion <= 99) {
					estado = EstadoMedicion.Aceptable;
				} else {
					if (100 <= medicion && medicion <= 179) {
						estado = EstadoMedicion.Optimo;
					} else {
						if (medicion >= 180) {
							estado = EstadoMedicion.Muy_alto;
						} else {
							estado = EstadoMedicion.Error;
						}
					}
				}
			}

			break;

		case Antes_actividad_fisica_vespertina:

			switch (intensidad) {

			case Baja:
				if (medicion <= 99) {
					estado = EstadoMedicion.Aceptable_bajo;
				} else {
					if (medicion >= 100) {
						estado = EstadoMedicion.Aceptable_alto;
					} else {
						estado = EstadoMedicion.Error;
					}
				}

				break;

			case Moderada:

				if (medicion <= 99) {
					estado = EstadoMedicion.Aceptable_bajo;
				} else {
					if (medicion >= 100 && medicion <= 179) {
						estado = EstadoMedicion.Optimo;
					} else {
						if (medicion >= 180 && medicion <= 299) {
							estado = EstadoMedicion.Alto;
						} else {
							if (medicion >= 300) {
								estado = EstadoMedicion.Muy_alto;
							} else {
								estado = EstadoMedicion.Error;
							}
						}
					}
				}

				break;

			case Intensa:

				if (medicion <= 99) {
					estado = EstadoMedicion.Aceptable_bajo;
				} else {
					if (medicion >= 100 && medicion <= 179) {
						estado = EstadoMedicion.Optimo;
					} else {
						if (medicion >= 180 && medicion <= 299) {
							estado = EstadoMedicion.Alto;
						} else {
							if (medicion >= 300) {
								estado = EstadoMedicion.Muy_alto;
							} else {
								estado = EstadoMedicion.Error;
							}
						}
					}
				}

				break;

			default:
				estado = EstadoMedicion.Error;
				break;

			}

			break;

		case Antes_cenar:

			if (medicion < 80) {
				estado = EstadoMedicion.Muy_bajo;
			} else {
				if (80 <= medicion && medicion <= 109) {
					estado = EstadoMedicion.Optimo;
				} else {
					if (110 <= medicion && medicion <= 129) {
						estado = EstadoMedicion.Aceptable;
					} else {
						if (medicion >= 130) {
							estado = EstadoMedicion.Muy_alto;
						} else {
							estado = EstadoMedicion.Error;
						}
					}
				}
			}

			break;

		case En_noche:

			if (medicion < 80) {
				estado = EstadoMedicion.Muy_bajo;
			} else {
				if (80 <= medicion && medicion <= 139) {
					estado = EstadoMedicion.Optimo;
				} else {
					if (medicion >= 140) {
						estado = EstadoMedicion.Muy_alto;
					} else {
						estado = EstadoMedicion.Error;
					}
				}
			}

			break;

		default:
			estado = EstadoMedicion.Error;

			break;

		}

		return estado;

	}

	////////////////////////////////////////////////////////////////
	
	public String getIngestaEjercicio(){
		
		String resultado = "Init";
		
		switch (intensidad) {

		case Baja:

			switch (estado) {

			case Aceptable_bajo:
				resultado = "La ingesta necesaria previa actividad física es de " +
						"entre 10-15 gr. de hidratos de carbono como por ejemplo " 
						+ getHidratosPreviaEjercicio(10);
				break;
			case Aceptable_alto:
				resultado = "La ingesta previa o durante actividad no es necesaria";
				break;
			default:
				break;

			}
			break;

		case Moderada:
			switch (estado) {

			case Aceptable_bajo:
				resultado = "La ingesta necesaria previa actividad física es de " +
						"entre 25-50 gr. de hidratos de carbono como por ejemplo " 
						+ getHidratosPreviaEjercicio(25);	
				resultado = resultado + "\ny en cuanto a la ingesta durante el ejercicio " +
						"es necesario entre 10-15 gr. de hidratos de carbono como " 
						+ getHidratosDuranteEjercicio(10);
				break;
			case Optimo:
				resultado = "La ingesta previa o durante actividad no es necesaria";
				break;
			case Alto:
				resultado = "La ingesta previa o durante actividad no es necesaria";
				break;
			case Muy_alto:
				resultado = "La ingesta previa o durante actividad no es necesaria";
				break;
			default:
				break;

			}
			break;

		case Intensa:
			switch (estado) {

			case Aceptable_bajo:
				resultado = "La ingesta necesaria previa actividad física es de " +
						"unos 50 gr. de hidratos de carbono como por ejemplo " 
						+ getHidratosPreviaEjercicio(50);	
				resultado = resultado + "\ny en cuanto a la ingesta durante el ejercicio " +
						"es necesario entre 25-50 gr. de hidratos de carbono como " 
						+ getHidratosDuranteEjercicio(25);
				break;
			case Optimo:
				resultado = "La ingesta necesaria previa actividad física es de " +
						"entre 25-50 gr. de hidratos de carbono como por ejemplo " 
						+ getHidratosPreviaEjercicio(25);	
				resultado = resultado + "\ny en cuanto a la ingesta durante el ejercicio " +
						"es necesario entre 10-15 gr. de hidratos de carbono como " 
						+ getHidratosDuranteEjercicio(10);
				break;
			case Alto:
				resultado = "La ingesta necesaria previa actividad física es de " +
						"entre 10-15 gr. de hidratos de carbono como por ejemplo " 
						+ getHidratosPreviaEjercicio(10);
				break;
			case Muy_alto:
				resultado = "La ingesta previa o durante actividad no es necesaria";
				break;
			default:
				break;

			}
			break;

		default:
			break;
		
		}
		return resultado;
	}
	
	
	public String getHidratosPreviaEjercicio(int hc){
		
		String resultado = "Init";
		ArrayList<String> Hidratos = new ArrayList<String>();

		
		switch (hc){
		
		case 10:
			Hidratos.add("una pieza de fruta");
			Hidratos.add("un trozo de pan blanco");
			Hidratos.add("100 ml de zumo de frutas");
			Hidratos.add("4 galletas María");

			resultado = Hidratos.get((int) (Math.random() * 4 + 1));
			
			break;
			
		case 25:
			Hidratos.add("una pieza de fruta y un trozo de pan");
			Hidratos.add("2 piezas de frutas");
			Hidratos.add("2 trozos de pan");
			Hidratos.add("200 ml de zumo de frutas");
			Hidratos.add("4 galletas María y 100 ml de zumo de frutas");
			Hidratos.add("8 galletas María");

			resultado = Hidratos.get((int) (Math.random() * 6 + 1));
			break;
			
		case 50:

			Hidratos.add("4 galletas María y un vaso de leche");
			Hidratos.add("2 trozos de pan y un vaso de leche");
			Hidratos.add("2 trozos de pan y un vaso de leche");
			Hidratos.add("2 trozos de pan y una pieza de fruta");
			Hidratos.add("un trozos de pan y 2 piezas de fruta");
			Hidratos.add("una pieza de fruta y 200 ml de zumo");
			Hidratos.add("200 ml de zumo de frutas y 4 galletas María");
			Hidratos.add("un trozo de pan, un vaso de leche y una pieza de fruta");

			resultado = Hidratos.get((int) (Math.random() * 8 + 1));
			break;
			
		default:
			resultado = "Error";
			break;
					
		}
		return resultado;
	}
	
	
	public String getHidratosDuranteEjercicio(int hc){
		
		String resultado = "Init";
		ArrayList<String> Hidratos = new ArrayList<String>();

		
		switch (hc){
		
		case 10:
			Hidratos.add("una pieza de fruta cada hora de ejercicio");
			Hidratos.add("un trozo de pan blanco cada hora de ejercicio");
			Hidratos.add("100 ml de zumo de frutas cada hora de ejercicio");
			Hidratos.add("4 galletas María cada hora de ejercicio");

			resultado = Hidratos.get((int) (Math.random() * 4 + 1));
			
			break;
			
		case 25:
			Hidratos.add("una pieza de fruta y un trozo de pan cada hora de ejercicio");
			Hidratos.add("2 piezas de frutas cada hora de ejercicio");
			Hidratos.add("2 trozos de pan cada hora de ejercicio");
			Hidratos.add("200 ml de zumo de frutas cada hora de ejercicio");
			Hidratos.add("4 galletas María y 100 ml de zumo de frutas cada hora de ejercicio");
			Hidratos.add("8 galletas María cada hora de ejercicio");

			resultado = Hidratos.get((int) (Math.random() * 6 + 1));
			break;
			
		default:
			resultado = "Error";
			break;
					
		}
		return resultado;
	}
	
	
}

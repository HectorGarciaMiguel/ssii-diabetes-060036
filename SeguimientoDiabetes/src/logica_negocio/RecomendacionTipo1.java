package logica_negocio;

import java.util.ArrayList;

public class RecomendacionTipo1 extends TipoRecomendacion {

	private int recomendadaMedico;
	private int unidadesDiarias;
	private int medicion;
	private TipoMedicion tipoMedicion;
	private Intensidad intensidad;
	
	private EstadoMedicion estado;

	

	// constructor
	
	  public RecomendacionTipo1 (int recomendadaMedico,int unidadesDiarias, int
	  valorMedicion, TipoMedicion tipo, Intensidad intensidad){				 
	  
			// Generar recomendación
		  this.recomendadaMedico = recomendadaMedico;
		  this.unidadesDiarias = unidadesDiarias;
		  this.medicion = valorMedicion;
		  this.tipoMedicion = tipo;
		  this.intensidad = intensidad;
		  
		  this.estado = toEstado();
	
		 }
	 
	/////////////////////////////////////////////////////////////

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

	//////////////////////////////////////////////////////////////

	public String getDosisInsulina() {

		String resultado = "Init";

		switch (tipoMedicion) {

		case En_ayunas:

			switch (estado) {

			case Muy_bajo:
				resultado = "Ninguna toma";
				break;
			case Optimo:
				resultado = "de absorción rápida y dosis " + recomendadaMedico
						+ " unidades";
				resultado = resultado + " y el pinchazo en la zona "
						+ getRotacion("Rapida");
				break;
			case Aceptable:
				resultado = "de absorción rápida y dosis " + recomendadaMedico
						+ " unidades";
				resultado = resultado + " y el pinchazo en la zona "
						+ getRotacion("Rapida");
				break;
			case Muy_alto:
				resultado = "de absorción ultrarápida y dosis "
						+ (recomendadaMedico - 95 / (1800 / unidadesDiarias))
						+ " unidades";
				resultado = resultado + " y el pinchazo en la zona "
						+ getRotacion("Rapida");
				break;
			default:
				break;
			}

			break;

		case Antes_actividad_fisica_matutina:
			
			
			
			switch (intensidad) {

			case Baja:

				switch (estado) {

				case Aceptable_bajo:
					resultado = "Ninguna toma";
					break;
				case Aceptable_alto:
					resultado = "Ninguna toma";
					break;
				default:
					break;

				}
				break;

			case Moderada:
				switch (estado) {

				case Aceptable_bajo:
					resultado = "Ninguna toma";
					break;
				case Optimo:
					resultado = "Ninguna toma";
					break;
				case Alto:
					resultado = "de absorción ultrarápida y dosis "
							+ (recomendadaMedico - 140 / (1800 / unidadesDiarias))
							+ " unidades";
					resultado = resultado + " y el pinchazo en la zona "
							+ getRotacion("Rapida");
					break;
				case Muy_alto:
					resultado = "de absorción ultrarápida y dosis "
							+ (recomendadaMedico - 140 / (1800 / unidadesDiarias))
							+ " unidades";
					resultado = resultado + " y el pinchazo en la zona "
							+ getRotacion("Rapida");
					break;
				default:
					break;

				}
				break;

			case Intensa:
				switch (estado) {

				case Aceptable_bajo:
					resultado = "Ninguna toma";
					break;
				case Optimo:
					resultado = "Ninguna toma";
					break;
				case Alto:
					resultado = "de absorción ultrarápida y dosis "
							+ (recomendadaMedico - 140 / (1800 / unidadesDiarias))
							+ " unidades";
					resultado = resultado + " y el pinchazo en la zona "
							+ getRotacion("Rapida");
					break;
				case Muy_alto:
					resultado = "de absorción ultrarápida y dosis "
							+ (recomendadaMedico - 140 / (1800 / unidadesDiarias))
							+ " unidades";
					resultado = resultado + " y el pinchazo en la zona "
							+ getRotacion("Rapida");
					break;
				default:
					break;

				}
				break;

			default:
				break;
			}
			
			
			
			
			break;

		case Antes_comer:
			switch (estado) {

			case Muy_bajo:
				resultado = "Ninguna toma";
				break;
			case Optimo:
				resultado = "de absorción intermedia y dosis "
						+ (recomendadaMedico) + " unidades";
				resultado = resultado + " y el pinchazo en la zona "
						+ getRotacion("Intermedia");
				break;
			case Aceptable:
				resultado = "de absorción intermedia y dosis "
						+ (recomendadaMedico) + " unidades";
				resultado = resultado + " y el pinchazo en la zona "
						+ getRotacion("Intermedia");
				break;
			case Muy_alto:
				resultado = "de absorción ultrarrápida y dosis "
						+ (recomendadaMedico - 95 / (1800 / unidadesDiarias))
						+ " unidades";
				resultado = resultado + " y el pinchazo en la zona "
						+ getRotacion("Rapida");
				break;
			default:
				break;
			}

			break;

		case Despues_comer:
			switch (estado) {

			case Muy_bajo:
				resultado = "Ninguna toma";
				break;
			case Aceptable:
				resultado = "Ninguna toma";
				break;
			case Optimo:
				resultado = "Ninguna toma";
				break;
			case Muy_alto:
				resultado = "de absorción rápida y dosis "
						+ (recomendadaMedico - 140 / (1800 / unidadesDiarias))
						+ " unidades";
				resultado = resultado + " y el pinchazo en la zona "
						+ getRotacion("Rapida");
				break;
			default:
				break;
			}

			break;

		case Antes_actividad_fisica_vespertina:

			
			switch (intensidad) {

			case Baja:

				switch (estado) {

				case Aceptable_bajo:
					resultado = "Ninguna toma";
					break;
				case Aceptable_alto:
					resultado = "Ninguna toma";
					break;
				default:
					break;

				}
				break;

			case Moderada:
				switch (estado) {

				case Aceptable_bajo:
					resultado = "Ninguna toma";
					break;
				case Optimo:
					resultado = "Ninguna toma";
					break;
				case Alto:
					resultado = "de absorción ultrarápida y dosis "
							+ (recomendadaMedico - 140 / (1800 / unidadesDiarias))
							+ " unidades";
					resultado = resultado + " y el pinchazo en la zona "
							+ getRotacion("Rapida");
					break;
				case Muy_alto:
					resultado = "de absorción ultrarápida y dosis "
							+ (recomendadaMedico - 140 / (1800 / unidadesDiarias))
							+ " unidades";
					resultado = resultado + " y el pinchazo en la zona "
							+ getRotacion("Rapida");
					break;
				default:
					break;

				}
				break;

			case Intensa:
				switch (estado) {

				case Aceptable_bajo:
					resultado = "Ninguna toma";
					break;
				case Optimo:
					resultado = "Ninguna toma";
					break;
				case Alto:
					resultado = "de absorción ultrarápida y dosis "
							+ (recomendadaMedico - 140 / (1800 / unidadesDiarias))
							+ " unidades";
					resultado = resultado + " y el pinchazo en la zona "
							+ getRotacion("Rapida");
					break;
				case Muy_alto:
					resultado = "de absorción ultrarápida y dosis "
							+ (recomendadaMedico - 140 / (1800 / unidadesDiarias))
							+ " unidades";
					resultado = resultado + " y el pinchazo en la zona "
							+ getRotacion("Rapida");
					break;
				default:
					break;

				}
				break;

			default:
				break;
			}
			
			
			
			
			break;

		case Antes_cenar:
			switch (estado) {

			case Muy_bajo:
				resultado = "Ninguna toma";
				break;
			case Optimo:
				resultado = "de absorción intermedia y dosis "
						+ (recomendadaMedico) + " unidades";
				resultado = resultado + " y el pinchazo en la zona "
						+ getRotacion("Intermedia");
				break;
			case Aceptable:
				resultado = "de absorción intermedia y dosis "
						+ (recomendadaMedico) + " unidades";
				resultado = resultado + " y el pinchazo en la zona "
						+ getRotacion("Intermedia");
				break;
			case Muy_alto:
				resultado = "de absorción ultrarrápida y dosis "
						+ (recomendadaMedico - 95 / (1800 / unidadesDiarias))
						+ " unidades";
				resultado = resultado + " y el pinchazo en la zona "
						+ getRotacion("Rapida");
				break;
			default:
				break;
			}

			break;

		case En_noche:
			switch (estado) {

			case Muy_bajo:
				resultado = "Ninguna toma";
				break;
			case Optimo:
				resultado = "de absorción lenta y dosis "
						+ (recomendadaMedico - 95 / (1800 / unidadesDiarias))
						+ " unidades";
				resultado = resultado + " y el pinchazo en la zona "
						+ getRotacion("Lenta");
				break;
			case Muy_alto:
				resultado = "de absorción rápida y dosis "
						+ (recomendadaMedico - 95 / (1800 / unidadesDiarias))
						+ " unidades";
				resultado = resultado + " y el pinchazo en la zona "
						+ getRotacion("Rapida");
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

	public String getRotacion(String tipoInsulina) {

		String resultado;

		if (tipoInsulina == "Rapida") {

			ArrayList<String> RotacionTipo1Rapida = new ArrayList<String>();
			RotacionTipo1Rapida.add("un par de dedos a la derecha del ombligo");
			RotacionTipo1Rapida
					.add("un par de dedos a la izquierda del ombligo");
			RotacionTipo1Rapida.add("un par de dedos hacia arriba del ombligo");

			resultado = RotacionTipo1Rapida.get((int) (Math.random() * 3 + 1));

		} else if (tipoInsulina == "Intermedia") {

			ArrayList<String> RotacionTipo1Intermedia = new ArrayList<String>();
			RotacionTipo1Intermedia
					.add("zona externa superior del  brazo izquierdo");
			RotacionTipo1Intermedia
					.add("zona externa superior del brazo derecho");
			RotacionTipo1Intermedia
					.add("zona anterior lateral externa del muslo izquierdo");
			RotacionTipo1Intermedia
					.add("zona anterior lateral externa del muslo derecho");

			resultado = RotacionTipo1Intermedia
					.get((int) (Math.random() * 4 + 1));

		} else if (tipoInsulina == "Lenta") {

			ArrayList<String> RotacionTipo1Lenta = new ArrayList<String>();
			RotacionTipo1Lenta
					.add("zona externa superior de la nalga izquierda");
			RotacionTipo1Lenta.add("zona externa superior de la nalga derecha");

			resultado = RotacionTipo1Lenta.get((int) (Math.random() * 2 + 1));

		} else {
			resultado = "Error";
		}

		return resultado;
	}
	

}

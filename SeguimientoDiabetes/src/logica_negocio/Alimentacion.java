package logica_negocio;

import java.util.ArrayList;

public class Alimentacion {

	private int caloriasNecesarias;
	private int medicion;
	private TipoMedicion tipoMedicion;
	private EstadoMedicion estado;
	private String alimentacion; 

	public Alimentacion(int caloriasNecesarias, int valorMedicion, TipoMedicion tipoMedicion) {

		this.caloriasNecesarias = caloriasNecesarias;
		this.medicion = valorMedicion;
		this.tipoMedicion = tipoMedicion;
		
		this.estado = toEstado();
		this.alimentacion = getAlimentacion();

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

	public String getAlimentacion() {

		String resultado = "Init";

		switch (tipoMedicion) {

		case En_ayunas:

			switch (estado) {

			case Muy_bajo:
				resultado = "desayuno normal";
				break;
			case Optimo:
				resultado = "desayuno normal";
				break;
			case Aceptable:
				resultado = "desayuno normal";
				break;
			case Muy_alto:
				resultado = "desayuno habitual evitando todo tipo de alimentos con un elevado índice glucémico";
				break;
			default:
				break;
			}

			break;

		case Antes_actividad_fisica_matutina:

			resultado = "No corresponde";

			break;

		case Antes_comer:
			switch (estado) {

			case Muy_bajo:
				resultado = "comida normal";
				break;
			case Optimo:
				resultado = "comida normal";
				break;
			case Aceptable:
				resultado = "comida normal";
				break;
			case Muy_alto:
				resultado = "comida habitual evitando todo tipo de alimentos con un elevado índice glucémico";
				break;
			default:
				break;
			}

			break;

		case Despues_comer:
			switch (estado) {

			case Muy_bajo:
				resultado = "merienda normal";
				break;
			case Aceptable:
				resultado = "merienda normal";
				break;
			case Optimo:
				resultado = "merienda normal";
				break;
			case Muy_alto:
				resultado = "merienda habitual evitando todo tipo de alimentos con un elevado índice glucémico";
				break;
			default:
				break;
			}

			break;

		case Antes_actividad_fisica_vespertina:

			resultado = "No corresponde";

			break;

		case Antes_cenar:
			switch (estado) {

			case Muy_bajo:
				resultado = "cena normal";
				break;
			case Optimo:
				resultado = "cena normal";
				break;
			case Aceptable:
				resultado = "cena normal";
				break;
			case Muy_alto:
				resultado = "cena habitual evitando todo tipo de alimentos con un elevado índice glucémico";
				break;
			default:
				break;
			}

			break;

		case En_noche:
			switch (estado) {

			case Muy_bajo:
				resultado = "tentenpié normal";
				break;
			case Optimo:
				resultado = "tentenpié normal";
				break;
			case Muy_alto:
				resultado = "tentenpié habitual evitando todo tipo de alimentos con un elevado índice glucémico";
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

	public String getDieta() {

		String dieta = "Init";

		if (caloriasNecesarias < 1250) {

			if (alimentacion == "desayuno normal") {
				dieta = "El desayuno es el 20% de las calorias diarias necesarias, calculadas son "
						+ (caloriasNecesarias * 0.2)
						+ "kcal que equivaldrían en:\n\n";
				dieta = dieta + "Desayuno\n" + "150 ml. de leche desnatada\n"
						+ "20 gr. de pan blanco o integral\n\n"
						+ "Mediamañana\n" + getFrutas("normal");
			} else if (alimentacion == "desayuno habitual evitando todo tipo de alimentos con un elevado índice glucémico") {
				dieta = "El desayuno es el 20% de las calorias diarias necesarias, calculadas son "
						+ (caloriasNecesarias * 0.20)
						+ "kcal que equivaldrían en:\n\n";
				dieta = dieta + "Desayuno\n" + "150 ml. de leche desnatada\n\n"
						+ "Mediamañana\n" + getFrutas("exceptoAIG");
			} else if (alimentacion == "comida normal") {
				dieta = "El comida es el 35% de las calorias diarias necesarias, calculadas son "
						+ (caloriasNecesarias * 0.35)
						+ "kcal que equivaldrían en:\n\n";
				dieta = dieta + "Comida\n" + getVerduras("normal") + "\n"
						+ getFarinaceos("normal") + "\n"
						+ getProteinas("normal") + "\n" + getFrutas("normal");
			} else if (alimentacion == "comida habitual evitando todo tipo de alimentos con un elevado índice glucémico") {
				dieta = "El comida es el 35% de las calorias diarias necesarias, calculadas son "
						+ (caloriasNecesarias * 0.35)
						+ "kcal que equivaldrían en:\n\n";
				dieta = dieta + "Comida\n" + getVerduras("exceptoAIG") + "\n"
						+ getFarinaceos("exceptoAIG") + "\n"
						+ getProteinas("exceptoAIG") + "\n"
						+ getFrutas("exceptoAIG");
			} else if (alimentacion == "merienda normal") {
				dieta = "El merienda es el 10% de las calorias diarias necesarias, calculadas son "
						+ (caloriasNecesarias * 0.1)
						+ "kcal que equivaldrían en:\n\n";
				dieta = dieta + "Merienda\n" + getFrutas("normal");
			} else if (alimentacion == "merienda habitual evitando todo tipo de alimentos con un elevado índice glucémico") {
				dieta = "El merienda es el 10% de las calorias diarias necesarias, calculadas son "
						+ (caloriasNecesarias * 0.1)
						+ "kcal que equivaldrían en:\n\n";
				dieta = dieta + "Merienda\n" + getFrutas("exceptoAIG");
			} else if (alimentacion == "cena normal") {
				dieta = "El comida es el 30% de las calorias diarias necesarias, calculadas son "
						+ (caloriasNecesarias * 0.30)
						+ "kcal que equivaldrían en:\n\n";
				dieta = dieta + "Cena\n" + getVerduras("normal") + "\n"
						+ getFarinaceos("normal") + "\n"
						+ getProteinas("normal") + "\n" + getFrutas("normal");
			} else if (alimentacion == "cena habitual evitando todo tipo de alimentos con un elevado índice glucémico") {
				dieta = "El cena es el 30% de las calorias diarias necesarias, calculadas son "
						+ (caloriasNecesarias * 0.30)
						+ "kcal que equivaldrían en:\n\n";
				dieta = dieta + "Cena\n" + getVerduras("exceptoAIG") + "\n"
						+ getFarinaceos("exceptoAIG") + "\n"
						+ getProteinas("exceptoAIG") + "\n"
						+ getFrutas("exceptoAIG");
			} else if (alimentacion == "tentenpié normal") {
				dieta = "El tentenpié antes de acostarse es el 5% de las calorias diarias necesarias, calculadas son "
						+ (caloriasNecesarias * 0.05)
						+ "kcal que equivaldrían en:\n\n";
				dieta = dieta
						+ "Antes de acostarse\n"
						+ "150 ml. de leche desnatada o 2 yogures naturales desnatados";
			} else if (alimentacion == "tentenpié habitual evitando todo tipo de alimentos con un elevado índice glucémico") {
				dieta = "El tentenpié antes de acostarse es el 5% de las calorias diarias necesarias, calculadas son "
						+ (caloriasNecesarias * 0.05)
						+ "kcal que equivaldrían en:\n\n";
				dieta = dieta
						+ "Antes de acostarse\n"
						+ "150 ml. de leche desnatada o 2 yogures naturales desnatados";
			} else if (alimentacion == "No corresponde") {
				dieta = "";
			} else {
				dieta = "Error";
			}

		} else if (caloriasNecesarias >= 1250 && caloriasNecesarias <= 1499) {

			if (alimentacion == "desayuno normal") {
				dieta = "El desayuno es el 20% de las calorias diarias necesarias, calculadas son "
						+ (caloriasNecesarias * 0.2)
						+ "kcal que equivaldrían en:\n\n";
				dieta = dieta + "Desayuno\n" + "200 ml. de leche desnatada\n"
						+ "20 gr. de pan blanco o integral\n\n"
						+ "Mediamañana\n" + getFrutas("normal");
			} else if (alimentacion == "desayuno habitual evitando todo tipo de alimentos con un elevado índice glucémico") {
				dieta = "El desayuno es el 20% de las calorias diarias necesarias, calculadas son "
						+ (caloriasNecesarias * 0.20)
						+ "kcal que equivaldrían en:\n\n";
				dieta = dieta + "Desayuno\n" + "200 ml. de leche desnatada\n\n"
						+ "Mediamañana\n" + getFrutas("exceptoAIG");
			} else if (alimentacion == "comida normal") {
				dieta = "El comida es el 35% de las calorias diarias necesarias, calculadas son "
						+ (caloriasNecesarias * 0.35)
						+ "kcal que equivaldrían en:\n\n";
				dieta = dieta + "Comida\n" + getVerduras("normal") + "\n"
						+ getFarinaceos("normal") + "\n"
						+ getProteinas("normal") + "\n" + getFrutas("normal");
			} else if (alimentacion == "comida habitual evitando todo tipo de alimentos con un elevado índice glucémico") {
				dieta = "El comida es el 35% de las calorias diarias necesarias, calculadas son "
						+ (caloriasNecesarias * 0.35)
						+ "kcal que equivaldrían en:\n\n";
				dieta = dieta + "Comida\n" + getVerduras("exceptoAIG") + "\n"
						+ getFarinaceos("exceptoAIG") + "\n"
						+ getProteinas("exceptoAIG") + "\n"
						+ getFrutas("exceptoAIG");
			} else if (alimentacion == "merienda normal") {
				dieta = "El merienda es el 10% de las calorias diarias necesarias, calculadas son "
						+ (caloriasNecesarias * 0.1)
						+ "kcal que equivaldrían en:\n\n";
				dieta = dieta + "Merienda\n" + getFrutas("normal");
			} else if (alimentacion == "merienda habitual evitando todo tipo de alimentos con un elevado índice glucémico") {
				dieta = "El merienda es el 10% de las calorias diarias necesarias, calculadas son "
						+ (caloriasNecesarias * 0.1)
						+ "kcal que equivaldrían en:\n\n";
				dieta = dieta + "Merienda\n" + getFrutas("exceptoAIG");
			} else if (alimentacion == "cena normal") {
				dieta = "El comida es el 30% de las calorias diarias necesarias, calculadas son "
						+ (caloriasNecesarias * 0.30)
						+ "kcal que equivaldrían en:\n\n";
				dieta = dieta + "Cena\n" + getVerduras("normal") + "\n"
						+ getFarinaceos("normal") + "\n"
						+ getProteinas("normal") + "\n" + getFrutas("normal");
			} else if (alimentacion == "cena habitual evitando todo tipo de alimentos con un elevado índice glucémico") {
				dieta = "El cena es el 30% de las calorias diarias necesarias, calculadas son "
						+ (caloriasNecesarias * 0.30)
						+ "kcal que equivaldrían en:\n\n";
				dieta = dieta + "Cena\n" + getVerduras("exceptoAIG") + "\n"
						+ getFarinaceos("exceptoAIG") + "\n"
						+ getProteinas("exceptoAIG") + "\n"
						+ getFrutas("exceptoAIG");
			} else if (alimentacion == "tentenpié normal") {
				dieta = "El tentenpié antes de acostarse es el 5% de las calorias diarias necesarias, calculadas son "
						+ (caloriasNecesarias * 0.05)
						+ "kcal que equivaldrían en:\n\n";
				dieta = dieta
						+ "Antes de acostarse\n"
						+ "200 ml. de leche desnatada o 2 yogures naturales desnatados";
			} else if (alimentacion == "tentenpié habitual evitando todo tipo de alimentos con un elevado índice glucémico") {
				dieta = "El tentenpié antes de acostarse es el 5% de las calorias diarias necesarias, calculadas son "
						+ (caloriasNecesarias * 0.05)
						+ "kcal que equivaldrían en:\n\n";
				dieta = dieta
						+ "Antes de acostarse\n"
						+ "150 ml. de leche desnatada o 2 yogures naturales desnatados";
			} else if (alimentacion == "No corresponde") {
				dieta = "";
			} else {
				dieta = "Error";
			}

		} else if (caloriasNecesarias >= 1500 && caloriasNecesarias <= 1749) {

			if (alimentacion == "desayuno normal") {
				dieta = "El desayuno es el 20% de las calorias diarias necesarias, calculadas son "
						+ (caloriasNecesarias * 0.2)
						+ "kcal que equivaldrían en:\n\n";
				dieta = dieta + "Desayuno\n" + "200 ml. de leche desnatada\n"
						+ "30 gr. de pan blanco o integral\n\n"
						+ "Mediamañana\n" + "50 gr. de pan blanco o integral\n"
						+ "20 gr. de atún sin aceite, queso o fiambre magro";
			} else if (alimentacion == "desayuno habitual evitando todo tipo de alimentos con un elevado índice glucémico") {
				dieta = "El desayuno es el 20% de las calorias diarias necesarias, calculadas son "
						+ (caloriasNecesarias * 0.20)
						+ "kcal que equivaldrían en:\n\n";
				dieta = dieta + "Desayuno\n" + "200 ml. de leche desnatada\n\n"
						+ "Mediamañana\n"
						+ "20 gr. de atún sin aceite, queso o fiambre magro";
			} else if (alimentacion == "comida normal") {
				dieta = "El comida es el 35% de las calorias diarias necesarias, calculadas son "
						+ (caloriasNecesarias * 0.35)
						+ "kcal que equivaldrían en:\n\n";
				dieta = dieta + "Comida\n" + getVerduras("normal") + "\n"
						+ getFarinaceos("normal") + "\n"
						+ getProteinas("normal") + "\n" + getFrutas("normal")
						+ "\n"
						+ "acompañandolo con 20 gr. de pan blanco o integral";
			} else if (alimentacion == "comida habitual evitando todo tipo de alimentos con un elevado índice glucémico") {
				dieta = "El comida es el 35% de las calorias diarias necesarias, calculadas son "
						+ (caloriasNecesarias * 0.35)
						+ "kcal que equivaldrían en:\n\n";
				dieta = dieta + "Comida\n" + getVerduras("exceptoAIG") + "\n"
						+ getFarinaceos("exceptoAIG") + "\n"
						+ getProteinas("exceptoAIG") + "\n"
						+ getFrutas("exceptoAIG");
			} else if (alimentacion == "merienda normal") {
				dieta = "El merienda es el 10% de las calorias diarias necesarias, calculadas son "
						+ (caloriasNecesarias * 0.1)
						+ "kcal que equivaldrían en:\n\n";
				dieta = dieta + "Merienda\n" + "200 ml. de leche desnatada\n"
						+ getFrutas("normal");
			} else if (alimentacion == "merienda habitual evitando todo tipo de alimentos con un elevado índice glucémico") {
				dieta = "El merienda es el 10% de las calorias diarias necesarias, calculadas son "
						+ (caloriasNecesarias * 0.1)
						+ "kcal que equivaldrían en:\n\n";
				dieta = dieta + "Merienda\n" + "200 ml. de leche desnatada\n"
						+ getFrutas("exceptoAIG");
			} else if (alimentacion == "cena normal") {
				dieta = "El comida es el 30% de las calorias diarias necesarias, calculadas son "
						+ (caloriasNecesarias * 0.30)
						+ "kcal que equivaldrían en:\n\n";
				dieta = dieta + "Cena\n" + getVerduras("normal") + "\n"
						+ getFarinaceos("normal") + "\n"
						+ getProteinas("normal") + "\n" + getFrutas("normal")
						+ "acompañandolo con 20 gr. de pan blanco o integral";
			} else if (alimentacion == "cena habitual evitando todo tipo de alimentos con un elevado índice glucémico") {
				dieta = "El cena es el 30% de las calorias diarias necesarias, calculadas son "
						+ (caloriasNecesarias * 0.30)
						+ "kcal que equivaldrían en:\n\n";
				dieta = dieta + "Cena\n" + getVerduras("exceptoAIG") + "\n"
						+ getFarinaceos("exceptoAIG") + "\n"
						+ getProteinas("exceptoAIG") + "\n"
						+ getFrutas("exceptoAIG");
			} else if (alimentacion == "tentenpié normal") {
				dieta = "El tentenpié antes de acostarse es el 5% de las calorias diarias necesarias, calculadas son "
						+ (caloriasNecesarias * 0.05)
						+ "kcal que equivaldrían en:\n\n";
				dieta = dieta
						+ "Antes de acostarse\n"
						+ "200 ml. de leche desnatada o 2 yogures naturales desnatados";
			} else if (alimentacion == "tentenpié habitual evitando todo tipo de alimentos con un elevado índice glucémico") {
				dieta = "El tentenpié antes de acostarse es el 5% de las calorias diarias necesarias, calculadas son "
						+ (caloriasNecesarias * 0.05)
						+ "kcal que equivaldrían en:\n\n";
				dieta = dieta
						+ "Antes de acostarse\n"
						+ "150 ml. de leche desnatada o 2 yogures naturales desnatados";
			} else if (alimentacion == "No corresponde") {
				dieta = "";
			} else {
				dieta = "Error";
			}

		} else if (caloriasNecesarias >= 1750 && caloriasNecesarias <= 1999) {

			if (alimentacion == "desayuno normal") {
				dieta = "El desayuno es el 20% de las calorias diarias necesarias, calculadas son "
						+ (caloriasNecesarias * 0.2)
						+ "kcal que equivaldrían en:\n\n";
				dieta = dieta
						+ "Desayuno\n"
						+ "200 ml. de leche desnatada\n"
						+ "40 gr. de pan blanco o integral\n"
						+ "20 gr. de atún sin aceite, queso o fiambre magro\n\n"
						+ "Mediamañana\n" + "50 gr. de pan blanco o integral\n"
						+ "20 gr. de atún sin aceite, queso o fiambre magro";
			} else if (alimentacion == "desayuno habitual evitando todo tipo de alimentos con un elevado índice glucémico") {
				dieta = "El desayuno es el 20% de las calorias diarias necesarias, calculadas son "
						+ (caloriasNecesarias * 0.20)
						+ "kcal que equivaldrían en:\n\n";
				dieta = dieta
						+ "Desayuno\n"
						+ "200 ml. de leche desnatada\n"
						+ "20 gr. de atún sin aceite, queso o fiambre magro\n\n"
						+ "Mediamañana\n"
						+ "20 gr. de atún sin aceite, queso o fiambre magro";
			} else if (alimentacion == "comida normal") {
				dieta = "El comida es el 35% de las calorias diarias necesarias, calculadas son "
						+ (caloriasNecesarias * 0.35)
						+ "kcal que equivaldrían en:\n\n";
				dieta = dieta + "Comida\n" + getVerduras("normal") + "\n"
						+ getFarinaceos("normal") + "\n"
						+ getProteinas("normal") + "\n" + getFrutas("normal")
						+ "\n"
						+ "acompañandolo con 20 gr. de pan blanco o integral";
			} else if (alimentacion == "comida habitual evitando todo tipo de alimentos con un elevado índice glucémico") {
				dieta = "El comida es el 35% de las calorias diarias necesarias, calculadas son "
						+ (caloriasNecesarias * 0.35)
						+ "kcal que equivaldrían en:\n\n";
				dieta = dieta + "Comida\n" + getVerduras("exceptoAIG") + "\n"
						+ getFarinaceos("exceptoAIG") + "\n"
						+ getProteinas("exceptoAIG") + "\n"
						+ getFrutas("exceptoAIG");
			} else if (alimentacion == "merienda normal") {
				dieta = "El merienda es el 10% de las calorias diarias necesarias, calculadas son "
						+ (caloriasNecesarias * 0.1)
						+ "kcal que equivaldrían en:\n\n";
				dieta = dieta + "Merienda\n" + "200 ml. de leche desnatada\n"
						+ "20 gr. de atún sin aceite, queso o fiambre magro";
			} else if (alimentacion == "merienda habitual evitando todo tipo de alimentos con un elevado índice glucémico") {
				dieta = "El merienda es el 10% de las calorias diarias necesarias, calculadas son "
						+ (caloriasNecesarias * 0.1)
						+ "kcal que equivaldrían en:\n\n";
				dieta = dieta + "Merienda\n" + "200 ml. de leche desnatada\n"
						+ "20 gr. de atún sin aceite, queso o fiambre magro";
			} else if (alimentacion == "cena normal") {
				dieta = "El comida es el 30% de las calorias diarias necesarias, calculadas son "
						+ (caloriasNecesarias * 0.30)
						+ "kcal que equivaldrían en:\n\n";
				dieta = dieta + "Cena\n" + getVerduras("normal") + "\n"
						+ getFarinaceos("normal") + "\n"
						+ getProteinas("normal") + "\n" + getFrutas("normal")
						+ "acompañandolo con 20 gr. de pan blanco o integral";
			} else if (alimentacion == "cena habitual evitando todo tipo de alimentos con un elevado índice glucémico") {
				dieta = "El cena es el 30% de las calorias diarias necesarias, calculadas son "
						+ (caloriasNecesarias * 0.30)
						+ "kcal que equivaldrían en:\n\n";
				dieta = dieta + "Cena\n" + getVerduras("exceptoAIG") + "\n"
						+ getFarinaceos("exceptoAIG") + "\n"
						+ getProteinas("exceptoAIG") + "\n"
						+ getFrutas("exceptoAIG");
			} else if (alimentacion == "tentenpié normal") {
				dieta = "El tentenpié antes de acostarse es el 5% de las calorias diarias necesarias, calculadas son "
						+ (caloriasNecesarias * 0.05)
						+ "kcal que equivaldrían en:\n\n";
				dieta = dieta
						+ "Antes de acostarse\n"
						+ "200 ml. de leche desnatada o 2 yogures naturales desnatados";
			} else if (alimentacion == "tentenpié habitual evitando todo tipo de alimentos con un elevado índice glucémico") {
				dieta = "El tentenpié antes de acostarse es el 5% de las calorias diarias necesarias, calculadas son "
						+ (caloriasNecesarias * 0.05)
						+ "kcal que equivaldrían en:\n\n";
				dieta = dieta
						+ "Antes de acostarse\n"
						+ "150 ml. de leche desnatada o 2 yogures naturales desnatados";
			} else if (alimentacion == "No corresponde") {
				dieta = "";
			} else {
				dieta = "Error";
			}

		} else if (caloriasNecesarias >= 2000) {

			if (alimentacion == "desayuno normal") {
				dieta = "El desayuno es el 20% de las calorias diarias necesarias, calculadas son "
						+ (caloriasNecesarias * 0.2)
						+ "kcal que equivaldrían en:\n\n";
				dieta = dieta
						+ "Desayuno\n"
						+ "200 ml. de leche desnatada\n"
						+ "40 gr. de pan blanco o integral\n"
						+ "25 gr. de atún sin aceite, queso o fiambre magro\n\n"
						+ "Mediamañana\n" + "60 gr. de pan blanco o integral\n"
						+ "20 gr. de atún sin aceite, queso o fiambre magro";
			} else if (alimentacion == "desayuno habitual evitando todo tipo de alimentos con un elevado índice glucémico") {
				dieta = "El desayuno es el 20% de las calorias diarias necesarias, calculadas son "
						+ (caloriasNecesarias * 0.20)
						+ "kcal que equivaldrían en:\n\n";
				dieta = dieta
						+ "Desayuno\n"
						+ "200 ml. de leche desnatada\n"
						+ "25 gr. de atún sin aceite, queso o fiambre magro\n\n"
						+ "Mediamañana\n"
						+ "20 gr. de atún sin aceite, queso o fiambre magro";
			} else if (alimentacion == "comida normal") {
				dieta = "El comida es el 35% de las calorias diarias necesarias, calculadas son "
						+ (caloriasNecesarias * 0.35)
						+ "kcal que equivaldrían en:\n\n";
				dieta = dieta + "Comida\n" + getVerduras("normal") + "\n"
						+ getFarinaceos("normal") + "\n"
						+ getProteinas("normal") + "\n" + getFrutas("normal")
						+ "\n"
						+ "acompañandolo con 40 gr. de pan blanco o integral";
			} else if (alimentacion == "comida habitual evitando todo tipo de alimentos con un elevado índice glucémico") {
				dieta = "El comida es el 35% de las calorias diarias necesarias, calculadas son "
						+ (caloriasNecesarias * 0.35)
						+ "kcal que equivaldrían en:\n\n";
				dieta = dieta + "Comida\n" + getVerduras("exceptoAIG") + "\n"
						+ getFarinaceos("exceptoAIG") + "\n"
						+ getProteinas("exceptoAIG") + "\n"
						+ getFrutas("exceptoAIG");
			} else if (alimentacion == "merienda normal") {
				dieta = "El merienda es el 10% de las calorias diarias necesarias, calculadas son "
						+ (caloriasNecesarias * 0.1)
						+ "kcal que equivaldrían en:\n\n";
				dieta = dieta + "Merienda\n"
						+ "60 gr. de pan blanco o integral\n"
						+ "25 gr. de atún sin aceite, queso o fiambre magro";
			} else if (alimentacion == "merienda habitual evitando todo tipo de alimentos con un elevado índice glucémico") {
				dieta = "El merienda es el 10% de las calorias diarias necesarias, calculadas son "
						+ (caloriasNecesarias * 0.1)
						+ "kcal que equivaldrían en:\n\n";
				dieta = dieta + "Merienda\n"
						+ "25 gr. de atún sin aceite, queso o fiambre magro";
			} else if (alimentacion == "cena normal") {
				dieta = "El comida es el 30% de las calorias diarias necesarias, calculadas son "
						+ (caloriasNecesarias * 0.30)
						+ "kcal que equivaldrían en:\n\n";
				dieta = dieta + "Cena\n" + getVerduras("normal") + "\n"
						+ getFarinaceos("normal") + "\n"
						+ getProteinas("normal") + "\n" + getFrutas("normal")
						+ "acompañandolo con 40 gr. de pan blanco o integral";
			} else if (alimentacion == "cena habitual evitando todo tipo de alimentos con un elevado índice glucémico") {
				dieta = "El cena es el 30% de las calorias diarias necesarias, calculadas son "
						+ (caloriasNecesarias * 0.30)
						+ "kcal que equivaldrían en:\n\n";
				dieta = dieta + "Cena\n" + getVerduras("exceptoAIG") + "\n"
						+ getFarinaceos("exceptoAIG") + "\n"
						+ getProteinas("exceptoAIG") + "\n"
						+ getFrutas("exceptoAIG");
			} else if (alimentacion == "tentenpié normal") {
				dieta = "El tentenpié antes de acostarse es el 5% de las calorias diarias necesarias, calculadas son "
						+ (caloriasNecesarias * 0.05)
						+ "kcal que equivaldrían en:\n\n";
				dieta = dieta
						+ "Antes de acostarse\n"
						+ "200 ml. de leche desnatada o 2 yogures naturales desnatados";
			} else if (alimentacion == "tentenpié habitual evitando todo tipo de alimentos con un elevado índice glucémico") {
				dieta = "El tentenpié antes de acostarse es el 5% de las calorias diarias necesarias, calculadas son "
						+ (caloriasNecesarias * 0.05)
						+ "kcal que equivaldrían en:\n\n";
				dieta = dieta
						+ "Antes de acostarse\n"
						+ "150 ml. de leche desnatada o 2 yogures naturales desnatados";
			} else if (alimentacion == "No corresponde") {
				dieta = "";
			} else {
				dieta = "Error";
			}

		} else {
			dieta = "Error";
		}

		return dieta;

	}

	public String getVerduras(String condicion) {

		String resultado;

		if (condicion == "normal") {

			ArrayList<String> VerduraNormal = new ArrayList<String>();
			VerduraNormal.add("300 gr. de acelgas");
			VerduraNormal.add("300 gr. de berenjenas");
			VerduraNormal.add("300 gr. de brecol");
			VerduraNormal.add("300 gr. de champiñones");
			VerduraNormal.add("300 gr. de col");
			VerduraNormal.add("300 gr. de espinacas");
			VerduraNormal.add("300 gr. de lechuga");
			VerduraNormal.add("300 gr. de pimientos");
			VerduraNormal.add("300 gr. de tomates");
			VerduraNormal.add("300 gr. de grelos");
			VerduraNormal.add("200 gr. de berros");
			VerduraNormal.add("200 gr. de judias verde");
			VerduraNormal.add("200 gr. de cardo");
			VerduraNormal.add("100 gr. de alcachofas");
			VerduraNormal.add("100 gr. de coles de bruselas");
			VerduraNormal.add("100 gr. de remolacha");
			VerduraNormal.add("100 gr. de zanahorias");

			resultado = VerduraNormal.get((int) (Math.random() * 17 + 1));

		} else if (condicion == "exceptoAIG") {

			ArrayList<String> VerduraExceptoAIG = new ArrayList<String>();
			VerduraExceptoAIG.add("300 gr. de acelgas");
			VerduraExceptoAIG.add("300 gr. de berenjenas");
			VerduraExceptoAIG.add("300 gr. de brecol");
			VerduraExceptoAIG.add("300 gr. de champiñones");
			VerduraExceptoAIG.add("300 gr. de col");
			VerduraExceptoAIG.add("300 gr. de espinacas");
			VerduraExceptoAIG.add("300 gr. de lechuga");
			VerduraExceptoAIG.add("300 gr. de pimientos");
			VerduraExceptoAIG.add("300 gr. de tomates");
			VerduraExceptoAIG.add("300 gr. de grelos");
			VerduraExceptoAIG.add("200 gr. de berros");
			VerduraExceptoAIG.add("200 gr. de judias verde");
			VerduraExceptoAIG.add("200 gr. de cardo");
			VerduraExceptoAIG.add("100 gr. de alcachofas");
			VerduraExceptoAIG.add("100 gr. de coles de bruselas");
			VerduraExceptoAIG.add("100 gr. de remolacha");
			VerduraExceptoAIG.add("100 gr. de zanahorias");

			resultado = VerduraExceptoAIG.get((int) (Math.random() * 17 + 1));

		} else {
			resultado = "Error";
		}

		return resultado;
	}

	public String getFarinaceos(String condicion) {

		String resultado;

		if (condicion == "normal") {

			ArrayList<String> FarinaceoNormal = new ArrayList<String>();
			FarinaceoNormal.add("120 gr. de guisantes");
			FarinaceoNormal.add("120 gr. de alubias frescas");
			FarinaceoNormal.add("100 gr. de patatas");
			FarinaceoNormal.add("40 gr. de garbanzos");
			FarinaceoNormal.add("40 gr. de lentejas");
			FarinaceoNormal.add("40 gr. de patatas fritas");
			FarinaceoNormal.add("40 gr. de pan blanco o integral");
			FarinaceoNormal.add("30 gr. de arroz");
			FarinaceoNormal.add("30 gr. de pasta");
			FarinaceoNormal.add("30 gr. de puré de patatas");

			resultado = FarinaceoNormal.get((int) (Math.random() * 10 + 1));

		} else if (condicion == "exceptoAIG") {

			ArrayList<String> FarinaceoExceptoAIG = new ArrayList<String>();
			FarinaceoExceptoAIG.add("120 gr. de guisantes");
			FarinaceoExceptoAIG.add("120 gr. de alubias frescas");
			FarinaceoExceptoAIG.add("40 gr. de garbanzos");
			FarinaceoExceptoAIG.add("40 gr. de lentejas");

			resultado = FarinaceoExceptoAIG.get((int) (Math.random() * 4 + 1));

		} else {
			resultado = "Error";
		}

		return resultado;
	}

	public String getProteinas(String condicion) {

		String resultado;

		if (condicion == "normal") {

			ArrayList<String> ProteinaNormal = new ArrayList<String>();
			ProteinaNormal.add("100 gr. de carne magra sin grasa");
			ProteinaNormal.add("100 gr. de pollo sin piel");
			ProteinaNormal.add("100 gr. de pechuga de pavo");
			ProteinaNormal.add("100 gr. de conejo o liebre");
			ProteinaNormal.add("100 gr. de caza");
			ProteinaNormal.add("100 gr. de ternera");
			ProteinaNormal.add("100 gr. de buey");
			ProteinaNormal.add("130 gr. de pescado azul");
			ProteinaNormal.add("130 gr. de pescado blanco");
			ProteinaNormal.add("2 huevos");

			resultado = ProteinaNormal.get((int) (Math.random() * 10 + 1));

		} else if (condicion == "exceptoAIG") {

			ArrayList<String> ProteinaNormal = new ArrayList<String>();
			ProteinaNormal.add("100 gr. de carne magra sin grasa");
			ProteinaNormal.add("100 gr. de pollo sin piel");
			ProteinaNormal.add("100 gr. de pechuga de pavo");
			ProteinaNormal.add("100 gr. de conejo o liebre");
			ProteinaNormal.add("100 gr. de caza");
			ProteinaNormal.add("100 gr. de ternera");
			ProteinaNormal.add("100 gr. de buey");
			ProteinaNormal.add("130 gr. de pescado azul");
			ProteinaNormal.add("130 gr. de pescado blanco");
			ProteinaNormal.add("2 huevos");

			resultado = ProteinaNormal.get((int) (Math.random() * 10 + 1));

		} else {
			resultado = "Error";
		}

		return resultado;
	}

	public String getFrutas(String condicion) {

		String resultado;

		if (condicion == "normal") {

			ArrayList<String> FrutaNormal = new ArrayList<String>();
			FrutaNormal.add("300 gr. de melón");
			FrutaNormal.add("300 gr. de sandía");
			FrutaNormal.add("150 gr. de fresas");
			FrutaNormal.add("150 gr. de albaricoque");
			FrutaNormal.add("150 gr. de ciruelas");
			FrutaNormal.add("150 gr. de mandarinas");
			FrutaNormal.add("150 gr. de naranjas");
			FrutaNormal.add("150 gr. de piña natural");
			FrutaNormal.add("120 gr. de manzana");
			FrutaNormal.add("120 gr. de melocotón");
			FrutaNormal.add("75 gr. de chirimoya");
			FrutaNormal.add("75 gr. de cerezas");
			FrutaNormal.add("75 gr. de plátano");
			FrutaNormal.add("75 gr. de uvas");
			FrutaNormal.add("75 gr. de higos");

			resultado = FrutaNormal.get((int) (Math.random() * 15 + 1));

		} else if (condicion == "exceptoAIG") {

			ArrayList<String> FrutaExceptoAIG = new ArrayList<String>();
			FrutaExceptoAIG.add("150 gr. de fresas");
			FrutaExceptoAIG.add("150 gr. de albaricoque");
			FrutaExceptoAIG.add("150 gr. de ciruelas");
			FrutaExceptoAIG.add("120 gr. de melocotón");
			FrutaExceptoAIG.add("75 gr. de chirimoya");
			FrutaExceptoAIG.add("75 gr. de cerezas");
			FrutaExceptoAIG.add("75 gr. de uvas");
			FrutaExceptoAIG.add("75 gr. de higos");

			resultado = FrutaExceptoAIG.get((int) (Math.random() * 8 + 1));

		} else {
			resultado = "Error";
		}

		return resultado;
	}

	// ////////////////////////////////////////////////////////////

	public String getIngestaNecesaria() {

		String resultado = "Init";

		switch (tipoMedicion) {

		case En_ayunas:

			switch (estado) {

			case Muy_bajo:
				resultado = "Debido al bajo nivel de glucosa en sangre es necesario hidratos de carbono de "
						+ "absorción rápida: " + getHidratos(tipoMedicion);
				break;
			case Optimo:
				resultado = "No es necesario";
				break;
			case Aceptable:
				resultado = "No es necesario";
				break;
			case Muy_alto:
				resultado = "No es necesario";
				break;
			default:
				break;
			}

			break;

		case Antes_actividad_fisica_matutina:

			resultado = "No corresponde";

			break;

		case Antes_comer:
			switch (estado) {

			case Muy_bajo:
				resultado = "Debido al bajo nivel de glucosa en sangre es necesario hidratos de carbono de "
						+ "absorción rápida: " + getHidratos(tipoMedicion);
				break;
			case Optimo:
				resultado = "No es necesario";
				break;
			case Aceptable:
				resultado = "No es necesario";
				break;
			case Muy_alto:
				resultado = "No es necesario";
				break;
			default:
				break;
			}

			break;

		case Despues_comer:
			switch (estado) {

			case Muy_bajo:
				resultado = "Debido al bajo nivel de glucosa en sangre es necesario hidratos de carbono de "
						+ "absorción rápida: " + getHidratos(tipoMedicion);
				break;
			case Aceptable:
				resultado = "No es necesario";
				break;
			case Optimo:
				resultado = "No es necesario";
				break;
			case Muy_alto:
				resultado = "No es necesario";
				break;
			default:
				break;
			}

			break;

		case Antes_actividad_fisica_vespertina:

			resultado = "No corresponde";

			break;

		case Antes_cenar:
			switch (estado) {

			case Muy_bajo:
				resultado = "Debido al bajo nivel de glucosa en sangre es necesario hidratos de carbono de "
						+ "absorción rápida: " + getHidratos(tipoMedicion);
				break;
			case Optimo:
				resultado = "No es necesario";
				break;
			case Aceptable:
				resultado = "No es necesario";
				break;
			case Muy_alto:
				resultado = "No es necesario";
				break;
			default:
				break;
			}

			break;

		case En_noche:
			switch (estado) {

			case Muy_bajo:
				resultado = "Debido al bajo nivel de glucosa en sangre es necesario hidratos de carbono de "
						+ "absorción rápida: " + getHidratos(tipoMedicion);
				break;
			case Optimo:
				resultado = "No es necesario";
				break;
			case Muy_alto:
				resultado = "No es necesario";
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

	public String getHidratos(TipoMedicion tipoMedicion) {

		String resultado = "Init";
		ArrayList<String> Hidratos = new ArrayList<String>();

		switch (tipoMedicion) {

		case En_ayunas:

			Hidratos.add("glucosa o azúcar");
			Hidratos.add("una cucharada de miel");
			Hidratos.add("un bol de copos de avena");
			Hidratos.add("un gofre");
			Hidratos.add("un bol de corn flakes");
			Hidratos.add("un donuts");
			Hidratos.add("un par de galletas María");
			Hidratos.add("pan blanco o integral");
			Hidratos.add("una pieza de plátano");
			Hidratos.add("una pieza de naranja");
			Hidratos.add("unos trozos de piña natural");

			resultado = "acompañando el desayuno con "
					+ Hidratos.get((int) (Math.random() * 11 + 1));

			break;

		case Antes_actividad_fisica_matutina:

			resultado = "No corresponde";

			break;

		case Antes_comer:

			Hidratos.add("patatas de cualquier forma");
			Hidratos.add("pan blanco o integral");
			Hidratos.add("arroz blanco");
			Hidratos.add("una pieza de plátano");
			Hidratos.add("una rodaja de sandía");
			Hidratos.add("trozos de piña natural");
			Hidratos.add("un refresco");
			Hidratos.add("glucosa o azúcar");
			Hidratos.add("un helado");

			resultado = "acompañando la comida con "
					+ Hidratos.get((int) (Math.random() * 9 + 1));

			break;

		case Despues_comer:

			Hidratos.add("glucosa o azúcar");
			Hidratos.add("una cucharada de miel");
			Hidratos.add("un bol de copos de avena");
			Hidratos.add("un gofre");
			Hidratos.add("un donuts");
			Hidratos.add("un par de galletas María");
			Hidratos.add("una pieza de plátano");
			Hidratos.add("una pieza de naranja");
			Hidratos.add("una pieza de manzana");

			resultado = "acompañando la merienda con "
					+ Hidratos.get((int) (Math.random() * 9 + 1));

			break;

		case Antes_actividad_fisica_vespertina:

			resultado = "No corresponde";

			break;

		case Antes_cenar:

			Hidratos.add("patatas de cualquier forma");
			Hidratos.add("pan blanco o integral");
			Hidratos.add("arroz blanco");
			Hidratos.add("una pieza de plátano");
			Hidratos.add("una rodaja de sandía");
			Hidratos.add("trozos de piña natural");
			Hidratos.add("un refresco");
			Hidratos.add("glucosa o azúcar");
			Hidratos.add("un helado");

			resultado = "acompañando la cena con "
					+ Hidratos.get((int) (Math.random() * 9 + 1));

			break;

		case En_noche:

			Hidratos.add("glucosa o azúcar");
			Hidratos.add("una cucharada de miel");
			Hidratos.add("un bol de copos de avena");
			Hidratos.add("un gofre");
			Hidratos.add("un donuts");
			Hidratos.add("un par de galletas María");
			Hidratos.add("una pieza de manzana");
			Hidratos.add("una pieza de naranja");
			Hidratos.add("una pieza de manzana");

			resultado = "acompañando el tentenpié de la noche con "
					+ Hidratos.get((int) (Math.random() * 9 + 1));

			break;

		default:
			break;

		}

		return resultado;

	}

}

package logica_negocio;

public class Recomendacion {

	private TipoRecomendacion tipoDiabetico;

	// constructor
	public Recomendacion(int recomendadaMedico, int unidadesDiarias,
			int valorMedicion, TipoMedicion tipoMedicion,
			TipoDiabetico tipoDiabetico, Intensidad intensidad) {

		switch (tipoDiabetico) {

		case Tipo1:
			this.tipoDiabetico = new RecomendacionTipo1(recomendadaMedico,
					unidadesDiarias, valorMedicion, tipoMedicion, intensidad);
			break;

		case Tipo1Bomba:
			this.tipoDiabetico = new RecomendacionTipo1Bomba(valorMedicion,
					tipoMedicion);
			break;

		case Tipo2:
			this.tipoDiabetico = new RecomendacionTipo2(valorMedicion,
					tipoMedicion);
			break;

		default:
			break;

		}
	}

	public EstadoMedicion toEstado() {

		return tipoDiabetico.toEstado();

	}

	public String getDosisInsulina() {

		return tipoDiabetico.getDosisInsulina();
	}


}

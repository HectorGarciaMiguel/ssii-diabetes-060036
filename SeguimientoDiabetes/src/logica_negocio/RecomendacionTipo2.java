package logica_negocio;

public class RecomendacionTipo2 extends TipoRecomendacion {

	private Integer glucosa;
	private TipoMedicion tipo;
	private EstadoMedicion estado;
	private Intensidad intensidad;
	
	
	private static String conclusion;
	
	
	//constructor
	public RecomendacionTipo2 (int valorMedicion, TipoMedicion t)
	{

		
	}




	@Override
	public EstadoMedicion toEstado() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String getDosisInsulina() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
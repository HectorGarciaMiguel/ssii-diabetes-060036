package logica_negocio;

enum Tipo{	
	Error, En_ayunas, Antes_actividad_fisica_matutina, Antes_comer, Despues_comer, 
	Antes_actividad_fisica_vespertina, Antes_cenar, En_noche};
	
enum Estado{Error, Muy_bajo, Bajo, Optimo, Aceptable_bajo, Aceptable, Aceptable_alto, Alto, Muy_alto}

enum Intensidad{Error, Baja, Moderada, Intensa}


public class Informacion {

	//private int valorIntervalo;
	//private String interpretacionIntervalo;
    //private Triplet[] intervalo = [(new Triplet<"bajo", 0, 79>), (new Triplet<"optimo", 80, 149>)];
	//private static Object[][] intervaloAyunas = {{"Bajo", 0, 79},{"Optimo", 80, 149},{"Alto", 150, 1000}};

	Tipo t;
	Estado e;	

	
	public Informacion(Tipo t){
		this.t = t;
	}
 
	public Informacion(Estado e){
		this.e = e;
	}

	public Tipo getTipo() {
		return t;
	}

	public void setTipo(Tipo t) {
		this.t = t;
	}

	public Estado getEstado() {
		return e;
	}

	public void setEstado(Estado e) {
		this.e = e;
	}
	
	
	
    
}

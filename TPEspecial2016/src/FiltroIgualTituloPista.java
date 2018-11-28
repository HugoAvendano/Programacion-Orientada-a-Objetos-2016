
public class FiltroIgualTituloPista implements Filtro {
	
	private String palabra;
	public FiltroIgualTituloPista(String palabra) {
		this.palabra=palabra;
	}

	public String getPalabra() {
		return palabra;
	}

	public void setPalabra(String palabra) {
		this.palabra = palabra;
	}

	@Override
	public Boolean cumple(Pista p) {
		String tituloPista=p.getNombre().toLowerCase();
		return tituloPista.contains(palabra.toLowerCase());
	}

}

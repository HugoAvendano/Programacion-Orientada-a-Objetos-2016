
public class FiltroIgualArtista implements Filtro {

	private String palabra;
	public FiltroIgualArtista(String palabra) {
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
		String nombreArtista=p.getArtistaInterprete().toLowerCase();
		return nombreArtista.contains(palabra.toLowerCase());
		
	}

}

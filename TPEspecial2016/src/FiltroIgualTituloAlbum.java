
public class FiltroIgualTituloAlbum implements Filtro {
	
	private String palabra;
	public FiltroIgualTituloAlbum() {
		// TODO Auto-generated constructor stub
	}

	public String getPalabra() {
		return palabra;
	}

	public void setPalabra(String palabra) {
		this.palabra = palabra;
	}
	
	@Override
	public Boolean cumple(Pista p) {
		String tituloAlbum=p.getTituloAlbum().toLowerCase();
		return tituloAlbum.contains(palabra.toLowerCase());
	}

}

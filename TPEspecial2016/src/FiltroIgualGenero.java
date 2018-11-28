
public class FiltroIgualGenero implements Filtro {

	private String palabra;
	public FiltroIgualGenero(String genero) {
		this.palabra=genero;
	}
	
	public String getPalabra() {
		return palabra;
	}

	public void setPalabra(String genero) {
		this.palabra = genero;
	}
	
	@Override
	public Boolean cumple(Pista p) {
		String genero= p.getGenero().toLowerCase();
		return genero.contains(palabra.toLowerCase());
	}


}

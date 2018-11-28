import java.util.ArrayList;
import java.util.List;

public class Pista extends ComponenteDeMusica {
	private Integer id,duracion,año;
	private String titulo,artista, tituloAlbum,genero;
	private List<String> comentarios;
	public Pista(Integer id,String titulo, Integer duracion, String artista, String tituloAlbum, Integer año, String genero ) {
		super(titulo);
		this.id=id;
		this.duracion=duracion;
		this.artista=artista;
		this.tituloAlbum=tituloAlbum;
		this.año=año;
		this.genero=genero;
		this.comentarios=new ArrayList<String>();
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	
	public int getDuracion() {
		return duracion;
	}
	public void setDuracion(Integer duracion) {
		this.duracion = duracion;
	}
	
	
	public String getArtistaInterprete() {
		return artista;
	}
	public void setArtista(String artista) {
		this.artista = artista;
	}
	
	
	public String getTituloAlbum() {
		return tituloAlbum;
	}
	public void setTituloAlbum(String tituloAlbum) {
		this.tituloAlbum = tituloAlbum;
	}
	
	
	public Integer getAño() {
		return año;
	}
	public void setAño(Integer año) {
		this.año = año;
	}
	
	
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}

	public void setComentario(String comentario){
		comentarios.add(comentario);
	}
	
	public List<String> getComentrios(){
		return this.comentarios;
	}
	
	@Override
	public int getCantidadPistas() {
		return 1;
	}
	
	@Override
	public List<Pista> pistasQueCumplen(Filtro f) {
		List<Pista> pistasCumplen = new ArrayList<Pista>();
		if (f.cumple(this)){
			pistasCumplen.add(this);
		}
		return pistasCumplen;
	}

	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pista other = (Pista) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "\nTitulo: "+ this.getNombre() +"- Artista/Interprete: " + artista+" - Album: "+ tituloAlbum+" - Genero: "+ genero
				+" - Año: " + año;
	}

	

}

	

	

	
	
	
	
	


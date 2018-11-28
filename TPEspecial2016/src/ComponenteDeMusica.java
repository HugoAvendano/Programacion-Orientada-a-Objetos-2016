import java.util.List;

	public abstract class ComponenteDeMusica {
	String nombre;
	public ComponenteDeMusica(String nombre) {
		this.nombre=nombre;
	}
	public String getNombre(){
		return this.nombre;
	}
	
	public void setNombre(String nombre){
		this.nombre=nombre;
	}
	public abstract int getCantidadPistas();
	public abstract int getDuracion();
	public abstract List<Pista> pistasQueCumplen(Filtro f);
}

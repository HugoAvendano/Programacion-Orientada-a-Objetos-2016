import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PlayListManual extends ComponenteDeMusica implements Iterable<ComponenteDeMusica> {

	List<ComponenteDeMusica>listaMusica;
	
	public PlayListManual(String nombre) {
		super(nombre);
		listaMusica=new ArrayList<ComponenteDeMusica>();
	}
	
	
	@Override
	public int getCantidadPistas() {
		int cantidad=0;
		for (ComponenteDeMusica componente : listaMusica) {
			cantidad+= componente.getCantidadPistas();
		}
		return cantidad;
	}

	
	@Override
	public int getDuracion() {
		int duracion=0;
		for (ComponenteDeMusica componente : listaMusica) {
			duracion+=componente.getDuracion();
		}
		return duracion;
	}
	
	
	@Override
	public List<Pista> pistasQueCumplen(Filtro f) {
		List <Pista> cumplen= new ArrayList<Pista>();
		for (ComponenteDeMusica elemento:listaMusica) {
			List<Pista> aux= new ArrayList<Pista>();
			aux=elemento.pistasQueCumplen(f);
			for (Pista pista : aux) {
				if (!cumplen.contains(pista))
					cumplen.add(pista);
			}
		}
		return cumplen;
	}
	
	public void addElemento(ComponenteDeMusica c){
		listaMusica.add(c);
	}
	
	public void intercambiarElemento(int elemento1, int elemento2){
		ComponenteDeMusica c1= listaMusica.get(elemento1);
		ComponenteDeMusica c2= listaMusica.get(elemento2);
		listaMusica.remove(elemento1);
		listaMusica.add(elemento1,c2);
		listaMusica.remove(elemento2);
		listaMusica.add(elemento2,c1);
	}
		
	
	

	@Override
	public String toString() {
		return "PlayList: " + this.nombre + listaMusica ;
	}

	public PlayListManual copy() {
		PlayListManual copia= new PlayListManual("Copia de "+ this.nombre);
		for (ComponenteDeMusica c : listaMusica) {
			copia.addElemento(c);
		}
	return copia;
	}
	
	
	
	@Override
	public Iterator<ComponenteDeMusica> iterator() {
		Iterator<ComponenteDeMusica> it = new IteradorComponenteMusica();
        return it;   
	}
	
	protected class IteradorComponenteMusica implements Iterator<ComponenteDeMusica>{
		protected int posicionArray;
		public IteradorComponenteMusica(){
			posicionArray=0;
		}
		@Override
		public boolean hasNext() {
			return(posicionArray<listaMusica.size());
		}

		@Override
		public ComponenteDeMusica next() {
			posicionArray++;
			return listaMusica.get(posicionArray-1);
		}

		@Override
		public void remove() {
			if(posicionArray<listaMusica.size()){
				listaMusica.remove(posicionArray-1);
				posicionArray--;
			}		
		}	
	}
}

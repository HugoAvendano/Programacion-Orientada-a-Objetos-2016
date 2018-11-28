
import java.util.List;

public class PlayListAutomatica extends ComponenteDeMusica{
		Filtro filtroAutomatico;
		PlayListManual listaMusica;
		
		public PlayListAutomatica(String nombre,PlayListManual listaMusica, Filtro f) {
		super(nombre);
		this.listaMusica=listaMusica;
		this.filtroAutomatico=f;
		}
		
		private final PlayListManual actualizar(){
			List<Pista> lista= listaMusica.pistasQueCumplen(filtroAutomatico);
			PlayListManual solucion= new PlayListManual("Automatica");
			for (Pista p : lista) {
				solucion.addElemento(p);
			}
		return solucion;
		}
		
		
	
		@Override
		public int getDuracion() {
			return actualizar().getDuracion();
		}
					
		
		@Override
		public int getCantidadPistas() {
			return actualizar().getCantidadPistas();
		}
	
		
		@Override
		public List<Pista> pistasQueCumplen(Filtro f) {
			return actualizar().pistasQueCumplen(f);
		}
		
		public List<Pista> getPistas(){
			return this.pistasQueCumplen(this.filtroAutomatico);
		}


		@Override
		public String toString() {
			return actualizar().toString();
		}

		
		
}	
	

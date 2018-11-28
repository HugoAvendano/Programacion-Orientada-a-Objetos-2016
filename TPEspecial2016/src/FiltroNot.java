
public class FiltroNot implements Filtro {
	Filtro f;
	public FiltroNot(Filtro f) {
		this.f=f;
	}

	@Override
	public Boolean cumple(Pista p) {
		return !f.cumple(p);
	}

}

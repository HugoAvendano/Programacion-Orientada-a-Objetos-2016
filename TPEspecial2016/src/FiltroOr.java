
public class FiltroOr implements Filtro {
	private Filtro f1;
	private Filtro f2;
	public FiltroOr(Filtro f1,Filtro f2) {
		this.f1=f1;
		this.f2=f2;
	}

	@Override
	public Boolean cumple(Pista p) {
		return f1.cumple(p) || f2.cumple(p);
	}

}

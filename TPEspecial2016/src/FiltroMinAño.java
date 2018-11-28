
public class FiltroMinA�o implements Filtro {

	private Integer min;
	public FiltroMinA�o(Integer min) {
		this.setA�o(min);
	}


	public Integer getA�oMinimo() {
		return min;
	}

	public void setA�o(Integer min) {
		this.min = min;
	}

	@Override
	public Boolean cumple(Pista p) {
		return p.getA�o()>min;
	}
}

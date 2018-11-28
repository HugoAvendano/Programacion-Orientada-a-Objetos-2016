
public class FiltroMinAño implements Filtro {

	private Integer min;
	public FiltroMinAño(Integer min) {
		this.setAño(min);
	}


	public Integer getAñoMinimo() {
		return min;
	}

	public void setAño(Integer min) {
		this.min = min;
	}

	@Override
	public Boolean cumple(Pista p) {
		return p.getAño()>min;
	}
}


public class FiltroMinDuracion implements Filtro {

	private Integer min;
	public FiltroMinDuracion(Integer min) {
		this.setMin(min);
	}

	public Integer getMin() {
		return min;
	}

	public void setMin(Integer min) {
		this.min = min;
	}

	@Override
	public Boolean cumple(Pista p) {
		return p.getDuracion()>min;
	}

}

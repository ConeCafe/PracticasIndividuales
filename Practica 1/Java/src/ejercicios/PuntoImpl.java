package ejercicios;


public class PuntoImpl implements Punto {

	private Double x;
	private Double y;
	
	public PuntoImpl(Double x, Double y) {
		this.x = x;
		this.y = y;
		
	}
	@Override
	public Double getX() {
		// TODO Auto-generated method stub
		return x;
	}

	@Override
	public Double getY() {
		// TODO Auto-generated method stub
		return y;
	}

	@Override
	public Cuadrante getCuadrante() {
		Cuadrante cuadrante;
		if(getX() < 0 && getY() < 0) {
			cuadrante = Cuadrante.TERCER_CUADRANTE;
		}else if(getX() < 0 && getY() > 0) {
			cuadrante = Cuadrante.SEGUNDO_CUADRANTE;
		}else if(getX() > 0 && getY() < 0) {
			cuadrante = Cuadrante.CUARTO_CUADRANTE;
		}else {
			cuadrante = Cuadrante.PRIMER_CUADRANTE;
		}
		return cuadrante;

	}

}

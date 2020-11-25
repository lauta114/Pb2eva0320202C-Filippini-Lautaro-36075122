package ar.edu.unlam.pb220202c.eva03;

public class Camion extends Vehiculo implements Imultable {
	private String Patente;
	private Integer VelocidadActual,limiteVelocidad,cantidadDeEjes;
	
	public Camion(String Patente, Integer VelocidadActual, Integer limiteVelocidad, Integer cantidadDeEjes) {
		super(Patente, VelocidadActual, limiteVelocidad);
		this.Patente = Patente;
		this.VelocidadActual = VelocidadActual;
		this.limiteVelocidad = limiteVelocidad;
		this.cantidadDeEjes = cantidadDeEjes;
	}

	@Override
	public Boolean enInfraccion() {
		if(this.VelocidadActual >limiteVelocidad)
			return true;
			return false;
	}
	
    @Override
	public String getPatente() {
		return Patente;
	}
    
    @Override
	public void setPatente(String patente) {
		Patente = patente;
	}
    
    @Override
	public Integer getVelocidadActual() {
		return VelocidadActual;
	}
    
    @Override
	public void setVelocidadActual(Integer velocidadActual) {
		VelocidadActual = velocidadActual;
	}
    
    @Override
	public Integer getLimiteVelocidad() {
		return limiteVelocidad;
	}
    
    @Override
	public void setLimiteVelocidad(Integer limiteVelocidad) {
		this.limiteVelocidad = limiteVelocidad;
	}

	@Override
	public void incrmentarVelocidad(Integer Velocidad) {
		this.VelocidadActual = Velocidad;
	}

	@Override
	public int compareTo(Vehiculo vehiculo) {
	
		return getPatente().compareTo(vehiculo.getPatente());
	}
	
	public Integer getCantidadDeEjes() {
		return cantidadDeEjes;
	}

	public void setCantidadDeEjes(Integer cantidadDeEjes) {
		this.cantidadDeEjes = cantidadDeEjes;
	}
	
}
package ar.edu.unlam.pb220202c.eva03;

public class VehiculoNotFounException extends Exception {

	public VehiculoNotFounException() {
		super("Error no puede ingresar sin haber abonado el servicio");
	}

}
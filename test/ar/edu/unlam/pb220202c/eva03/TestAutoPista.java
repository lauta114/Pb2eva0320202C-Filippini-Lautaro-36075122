package ar.edu.unlam.pb220202c.eva03;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestAutoPista {
	
	
	
	@Test
	public void queSePuedaRegistrarTelepase () {
		Autopista autopista = new Autopista ("Buenos Aires La plata");
		Vehiculo camion= new Camion("RTO456",40,80, 2);
		Vehiculo camion2= new Camion("RTI676",40,80, 2);
		Vehiculo vehiculo = new Automovil ("RTO456",80,130);
		Vehiculo vehiculo2 = new Automovil ("ROO400",80,130);
		assertTrue(autopista.registrarTelepase(4, vehiculo));
	}
	
	
	@Test (expected = VehiculoNotFounException.class)
	public void queAlSalirDelAutopistaNoestaEncirculacionLanceUnaExcepcion() throws VehiculoNotFounException {
		Autopista autopista = new Autopista ("Buenos Aires La plata");
		Vehiculo vehiculo = new Automovil ("RTO456",80,130);
		autopista.salirAutpista(vehiculo);
		assertEquals(0,autopista.cantidadDeVehiculosENCirculacion(),0.01);
	}
	
	
	@Test
	public void queVerifiqueQueSeObtengaUnaListaDeAutosInsfractoresOrdenadaPorPatente() throws VehiculoNotFounException{
		Autopista autopista = new Autopista ("Buenos Aires La plata");
		Vehiculo vehiculo = new Automovil ("RTO456",140,130);
		autopista.registrarTelepase(1, vehiculo);
		try {
		autopista.ingresarAutopista(1);
		}
		catch(VehiculoNotFounException a) {
			System.out.println(a.getMessage());
		}
		assertEquals(1,autopista.obtenerVehiculosConExcesosDeVelocidadOrdenadosPorPatente().size());
	}
	

	
	@Test
	public void queIngreseUnAutomovilAAutopista() throws VehiculoNotFounException {
		Autopista autopista = new Autopista ("Buenos Aires La plata");
		Vehiculo Automovil  = new Automovil ("RGO446",80,130);
		autopista.registrarTelepase(1, Automovil);
		try {
			autopista.ingresarAutopista(1);
			}
			catch(VehiculoNotFounException l) {
				System.out.println(l.getMessage());
			}
		assertEquals(1,autopista.cantidadDeVehiculosENCirculacion(),0.01);
	}
	
	
	@Test
	public void queIngreseCamionAAutopista() throws VehiculoNotFounException {
		Autopista autopista = new Autopista ("Buenos Aires La plata");
		Vehiculo Camion  = new Camion ("RUU634",60,80, 2);
		autopista.registrarTelepase(1, Camion);
		try {
			autopista.ingresarAutopista(1);
			}
			catch(VehiculoNotFounException d) {
				System.out.println(d.getMessage());
			}
		assertEquals(1,autopista.cantidadDeVehiculosENCirculacion(),0.01);
	}
	
	@Test
	public void queSalgaDeAutopista() throws VehiculoNotFounException{
		Autopista autopista = new Autopista ("Buenos Aires La plata");
		Vehiculo vehiculo = new Automovil ("RTO456",170,130);
		autopista.registrarTelepase(1, vehiculo);
		try {
			autopista.ingresarAutopista(1);
			}
			catch(VehiculoNotFounException b) {
				System.out.println(b.getMessage());
			}
		try {
			autopista.salirAutpista(vehiculo);
			}
			catch(VehiculoNotFounException c) {
				System.out.println(c.getMessage());
			}
		assertEquals(0,autopista.cantidadDeVehiculosENCirculacion(),0.01);
	}
	
}
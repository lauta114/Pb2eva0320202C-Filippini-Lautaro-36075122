package ar.edu.unlam.pb220202c.eva03;

import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

public class Autopista {
	
	private HashMap <Integer,Vehiculo> telepase;
	private HashSet <Vehiculo> vehiculosEnCirculacion;
	private String nombre;
	
	public Autopista(String nombre) {
		this.nombre = nombre;
		telepase = new HashMap<Integer,Vehiculo>(); 
		vehiculosEnCirculacion = new HashSet <>();
	}
	
	public Boolean registrarTelepase (Integer numeroTelpase, Vehiculo vehiculo) {
			if(vehiculo!=null && numeroTelpase!= null) {
			telepase.put(numeroTelpase, vehiculo);
			return true;}
			else {
				return false;
			}
	}

	public Boolean ingresarAutopista (Integer numeroTelepase) throws VehiculoNotFounException {
		if(telepase.containsKey(numeroTelepase)) {
			vehiculosEnCirculacion.add(telepase.get(numeroTelepase));
		}else {
		throw new 	VehiculoNotFounException();
		}
		return null;
	}
	
	public void salirAutpista (Vehiculo vehiculo) throws VehiculoNotFounException {
		if(!telepase.containsValue(vehiculo))
		throw new 	VehiculoNotFounException();
		vehiculosEnCirculacion.remove(vehiculo);
	}
	
	public HashSet <Vehiculo> vehiculosConExceso(){
		HashSet <Vehiculo> vehiculosExcedidos = new HashSet<>();
		for (Vehiculo vehiculo : vehiculosEnCirculacion) {
			if(vehiculo instanceof Camion) {
				if(((Camion) vehiculo).enInfraccion())
					vehiculosExcedidos.add(vehiculo);
			}
			if(vehiculo instanceof Automovil) {
				if(((Automovil) vehiculo).enInfraccion())
					vehiculosExcedidos.add(vehiculo);
			}
		}
		return vehiculosExcedidos;	
	}
	
	public TreeSet<Vehiculo> obtenerVehiculosConExcesosDeVelocidadOrdenadosPorPatente(){
	 TreeSet <Vehiculo> VehiculosConExcesoOrdenados  = new TreeSet <Vehiculo>();
	 VehiculosConExcesoOrdenados.addAll(vehiculosConExceso());
	 return VehiculosConExcesoOrdenados;
    }

	public Integer cantidadDeVehiculosENCirculacion() {
		return vehiculosEnCirculacion.size();
	}

}
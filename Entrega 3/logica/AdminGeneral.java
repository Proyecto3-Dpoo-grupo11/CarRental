package logica;

import java.util.HashMap;
import logica.EmpresaAlquiler;

/**
 * <!-- ACA DOCUMENTACION -->
 * <!--  TODO: Implementar los metodos -->
 */

public class AdminGeneral extends Usuario
{
	protected Roles cargo;
	
	/**
	 * <!-- CONSTRUCTOR -->
	 */
	
	public AdminGeneral(String username, String password, Roles cargo) {
		super(username, password);
		this.cargo = Roles.ADMINISTRADORGENERAL;
		}
	
	/**
	 * <!-- METODOS DEL ADMIN -->
	 */
	
	public void manejarEmpleados() {
		
		
		
		
		// TODO implement me
		
	}

	public void crearAdminSede(String username, String password, int codigoSede, Roles cargo) {
		// TODO implement me
		Usuario u = new AdminSede(username,password,codigoSede,cargo);		
		EmpresaAlquiler.mapaUsuarios.put(username, u);	
		}
	
	public void eliminarAdminSede(String username) {
		// TODO implement me	
		EmpresaAlquiler.mapaUsuarios.remove(username);
		
	}

	public void nuevoVehiculo(String categoria,String placa,String marca,String codigoReservaActual,String color,String tipoTransmision,Estados Estados,String modelo) {
		// TODO implement me
		
	Usuario u = new Vehiculo(categoria,placa,marca,codigoReservaActual,color,tipoTransmision,Estados,modelo);
	}
	
	public void borrarVehiculo() {
		// TODO implement me	
	}
	
	public void addSede() {
		// TODO implement me, tiene que agregar a EmpresaAlquiler.listaSedes	
	}
	
	public void eliminarSedes() {
		// TODO implement me	
	}
	
	//NO SE PUSO getters y setters porque no se necesitan y siempre daria el cargo.
}


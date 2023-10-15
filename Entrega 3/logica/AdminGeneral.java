package logica;

import java.util.ArrayList;
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
		super(username, password, cargo);
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

	public void nuevoVehiculo(String categoria, String placa, String marca, String codigoReservaActual, String modelo,
			String color, String tipoTransmision,Estados Estados, Sede sede) {
		// TODO implement me

		Vehiculo u =  new Vehiculo(categoria, placa, marca, codigoReservaActual, modelo, color, tipoTransmision,Estados);
		sede.listaVehiculos.add(u);
	}

	public void borrarVehiculo(String placa, Sede sede) {
		// TODO implement me
		ArrayList<Vehiculo> lista = sede.listaVehiculos;
		for (Vehiculo vehiculo : lista) {
			if (vehiculo.placa == placa) {
				lista.remove(vehiculo);

			}

		}
	}
	
	public void addSede(String codigoSede, String ubicacion, String horarioAtencion, ArrayList<Vehiculo> listaVehiculos,
			 ArrayList<Reserva> listaReservas) {
		// TODO implement me, tiene que agregar a EmpresaAlquiler.listaSedes
		Sede u = new Sede(codigoSede,ubicacion,horarioAtencion,listaVehiculos,listaReservas);
		EmpresaAlquiler.listaSedes.add(u);
	}
	
	public void eliminarSedes(String codigoSede) {
		// TODO implement me	
	
		
		for (Sede sedes : EmpresaAlquiler.listaSedes) {
			if (sedes.codigoSede==codigoSede) {
				EmpresaAlquiler.listaSedes.remove(sedes);
			}
			
		}
		
	}
	
	//NO SE PUSO getters y setters porque no se necesitan y siempre daria el cargo.
}


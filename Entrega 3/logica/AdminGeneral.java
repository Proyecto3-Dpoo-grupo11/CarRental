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
	private Sede sede;
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
	
	public void addEmpleado(String username, String password, Roles cargo) {
		sede.addEmpleado(username, password, cargo);
	}
    public void deleteEmpleado(String username) {
        sede.deleteEmpleado(username);
		
		
		// TODO implement me
		
	}

	public void crearAdminSede(String username, String password, String codigoSede, Roles cargo) {
		// TODO implement me
		Usuario u = new AdminSede(username,password,codigoSede,cargo);		
		EmpresaAlquiler.mapaUsuarios.put(username, u);
		
			
		}
		
	
	
	public void eliminarAdminSede(String username,String codigoSede) {
		// TODO implement me	
		EmpresaAlquiler.mapaUsuarios.remove(username);
		
		
		
	}

	public void nuevoVehiculo(String categoria, String placa, String marca, String codigoReservaActual, String modelo,
			String color, String tipoTransmision, Estados estados, String codigoSede) {
		// TODO implement me 

		Vehiculo u =  new Vehiculo(categoria, placa, marca, codigoReservaActual, modelo, color, tipoTransmision,estados);
		for (Sede sedes:EmpresaAlquiler.listaSedes ) {
			if(sedes.codigoSede==codigoSede) {
				sedes.listaVehiculos.add(u);
			}
		}
		
		
		sede.listaVehiculos.add(u);
	}

	public void borrarVehiculo(String placa,String codigoSede) {
		// TODO implement me
		
		for (Sede sedes : EmpresaAlquiler.listaSedes) {
			if (sedes.codigoSede == codigoSede) {
				ArrayList<Vehiculo> lista = sedes.listaVehiculos;
				for (Vehiculo vehiculo : lista) {
					if (vehiculo.placa == placa) {
						lista.remove(vehiculo);
					}

				}
			}
		}
	}
	
	public void addSede(String codigoSede, String ubicacion, String horarioAtencion) {
		//Corregir 
		HashMap<String,Reserva> mapaReserva = new HashMap<String, Reserva> ();
		ArrayList<Vehiculo> listaVehiculos = new ArrayList<Vehiculo>();
		//CREAR EL ADMIN SEDE, osea tienen que juntarlo con el metodo de add admin sede. no existe
		//el uno sin el otro. 

        Sede sede = new Sede(codigoSede, ubicacion, horarioAtencion, listaVehiculos, mapaReserva);
        EmpresaAlquiler.listaSedes.add(sede);
		
	}
	
	public void eliminarSedes(String codigoSede) {
		// TODO implement me	
	
		
		for (Sede sedes : EmpresaAlquiler.listaSedes) {
			if (sedes.codigoSede==codigoSede) {
				EmpresaAlquiler.listaSedes.remove(sedes);
			}
			
		}
		
	}
	public void modificarSeguro() {}
	
	//NO SE PUSO getters y setters porque no se necesitan y siempre daria el cargo.
}


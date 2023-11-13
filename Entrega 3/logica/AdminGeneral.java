package logica;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * <!-- ACA DOCUMENTACION -->
 * <!--  TODO: Implementar los metodos -->
 */

public class AdminGeneral extends Usuario
{
	private static final long serialVersionUID = 2L;
	protected Roles cargo;
	private Sede sede;
	private EmpresaAlquiler empresa;
	/**
	 * <!-- CONSTRUCTOR -->
	 */
	
	public AdminGeneral(String username, String password, Roles cargo, EmpresaAlquiler empresa) {
		super(username, password, cargo);
		this.cargo = Roles.ADMINISTRADORGENERAL;
		this.empresa = empresa;
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
		Usuario u = new AdminSede(username,password,cargo,codigoSede,sede, empresa);		
		empresa.mapaUsuarios.put(username, u);
		 int a=1;
		
			
		}
		
	
	
	public void eliminarAdminSede(String username,String codigoSede) {
		// TODO implement me	
		empresa.mapaUsuarios.remove(username);
		
		
		
	}

	public void nuevoVehiculo(String categoria, String placa, String marca, String codigoReservaActual, String modelo,
			String color, String tipoTransmision, Estados estados, String codigoSede) {
		// TODO implement me

		Vehiculo u = new Vehiculo(categoria, placa, marca, codigoReservaActual, color, tipoTransmision, estados, modelo,
				codigoSede);
		for (Sede sedes : empresa.listaSedes) {
			if (sedes.codigoSede == codigoSede) {
				sedes.listaVehiculos.add(u);
			}
		}
		// TODO hay que cambiar a sede.

		
	}

	public void borrarVehiculo(String placa, String codigoSede) {
		// TODO implement me

		for (Sede sedes : empresa.listaSedes) {
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
		HashMap<String,Empleado> mapaEmpleado = new HashMap<String, Empleado> ();
		//CREAR EL ADMIN SEDE, osea tienen que juntarlo con el metodo de add admin sede. no existe
		//el uno sin el otro. 

       Sede sede = new Sede(codigoSede, ubicacion, horarioAtencion, listaVehiculos,mapaReserva, mapaEmpleado);
       empresa.listaSedes.add(sede);
		
	}
	
	public void eliminarSedes(String codigoSede) {
		// TODO implement me	
	
		
		for (Sede sedes : empresa.listaSedes) {
			if (sedes.codigoSede==codigoSede) {
				empresa.listaSedes.remove(sedes);
		}
			
		}
		
	}
	public void modificarSeguro(String nombreSeguroViejo, String nombreSeguroNuevo, int tarifaNueva) {
		Seguro.mapaSeguro.remove(nombreSeguroViejo);
		Seguro nuevoSeguro= new Seguro(nombreSeguroNuevo, tarifaNueva);
		Seguro.mapaSeguro.put(nombreSeguroNuevo,nuevoSeguro);
		
		
	}
	public void cambiarContraseña(String userNameViejo,String userNameNuevo,String contraseñaNueva,Roles cargo) {
		empresa.mapaUsuarios.remove(userNameViejo);
		Usuario u = new AdminGeneral(userNameNuevo,contraseñaNueva,cargo, this.empresa);
		empresa.mapaUsuarios.put(userNameNuevo,u);
		
	}
	
	//NO SE PUSO getters y setters porque no se necesitan y siempre daria el cargo.
}


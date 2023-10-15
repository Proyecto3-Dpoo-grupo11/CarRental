package logica;

import java.util.ArrayList;

/**
 *   <!-- DOCUMENTACION ACA -->
 *   
 * <!-- Aunque en el UML se muestra el enum roles como atributo de usuario,-->
 * <!--  se construye desde cada uno de sus subclases. -->
 * <!--  TODO implementar los metodos y su relacion con lo de reserva -->
 */

public class Empleado extends Usuario {
	
	public int codigoSede;
	protected Roles cargo;

	public Empleado(String username, String password, int codigoSede, Roles cargo) {
		super(username, password, cargo);
		this.codigoSede = codigoSede;
		this.cargo = Roles.EMPLEADO;
		}
	
	/**
	 * <!-- METODOS REALIZABLES POR EMPLEADO -->
	 */

	
	public void mandarMantenimiento() {
		// TODO implement me	
	}
	
	public Void crearCliente(String username, String password, Roles cargo, String nombreCliente, String email, String telefono, String fechaNacimiento, String nacionalidad, String imagenCedula,String imagenLicencia, String metodoDePago, String numeroTarjeta, String fechaVencimiento) {
		Usuario u = new Cliente(username,password,cargo,nombreCliente,email,telefono,fechaNacimiento,nacionalidad,imagenCedula,imagenCedula,metodoDePago,numeroTarjeta,fechaVencimiento);
		EmpresaAlquiler.mapaUsuarios.put(username, u);
		// TODO implement me
		return null;	
	}
	
	public Void iniciarReserva(String codigoReserva, String tipoDeCarro,
			int sedeRecogida, int sedeEntrega, int nuevaSedeEntrega, String fechaHoraRecogida, String fechaHoraEntrega,
			String placaVehiculo, String usernameCliente, Tarifa tarifa, Seguro seguro, Vehiculo vehiculo, String rutaImagenConductorAdiciones) {
			// TODO implement me
			ArrayList<String> listaConductoresAdicionales= new ArrayList<String>();
			Reserva reserva= new Reserva(codigoReserva, listaConductoresAdicionales, tipoDeCarro, sedeRecogida, sedeEntrega, nuevaSedeEntrega, fechaHoraRecogida, fechaHoraEntrega, placaVehiculo, usernameCliente, tarifa, seguro, vehiculo, rutaImagenConductorAdiciones);
			addConductorAdicional(rutaImagenConductorAdiciones,reserva);
			int calculo =reserva.iniciarReserva();
		
		return null;	
	}
	
	
	public String cerrarGuardarReserva() {
		// TODO implement me
		return "";	
	}
	
	
	public void reporteCarrosMantenimiento() {
		// TODO implement me	
	}
	

	public void addConductorAdicional(String rutaImagen, Reserva reserva) {
		// TODO implement me	
		reserva.addConductorAdicional(rutaImagen);
	}

	/**
	 * <!-- GETTERS AND SETTERS -->
	 */

	public int getCodigoSede() {
		return codigoSede;
	}


	public void setCodigoSede(int codigoSede) {
		this.codigoSede = codigoSede;
	}

	
	public Roles getCargo() { //Para comprobar si el rol si es en las demas funciones.
		return cargo;
	}


	public void setCargo(Roles cargo) {
		this.cargo = cargo;
	}
	
}
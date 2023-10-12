package logica;
import java.util.ArrayList;

/**
 * <!-- DOCUMENTACION AQUI PORFA -->
 * TODO: Solamente implementar los metodos de abajo
 * 
 * TODO: Tambien tienen que pensar como se va a formatear el horario de atencion y 
 * luego cambiarlo en el archivo de preuba  -->
 */

public class Sede
{
	public int codigoSede;
	public String ubicacion;
	public String horarioAtencion;
	
	public ArrayList<Vehiculo> listaVehiculos;
	public ArrayList<Empleado> listaEmpleados;
	public ArrayList<Reserva> listaReservas;
	
	/**
	 * <!-- CONSTRUCTOR  -->
	 * @generated
	 */
	public Sede(int codigoSede, String ubicacion, String horarioAtencion, ArrayList<Vehiculo> listaVehiculos,
			ArrayList<Empleado> listaEmpleados, ArrayList<Reserva> listaReservas) {
		super();
		this.codigoSede = codigoSede;
		this.ubicacion = ubicacion;
		this.horarioAtencion = horarioAtencion;
		this.listaVehiculos = listaVehiculos;
		this.listaEmpleados = listaEmpleados;
		this.listaReservas = listaReservas;
	}
	
	/**
	 * <!-- FUNCIONES DEL ADMIN  -->
	 */
	
	public void crearEmpleado() {
		// TODO addlast a la lista de empleados	
	}
	
	public void eliminarEmpleado() {
		// TODO buscar y eliminar de la lista de empleados
	}
	
	public void addVehiculo() {
		//Aqui van a tener que crear nuevo objeto vehiculo y almacenarlo en el arraylist de aca.
	}

	
	/**
	 * <!-- GETTERS AND SETTERS -->
	 * @generated
	 */
	public String getUbicacion() {
		return ubicacion;
	}


	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}


	public String getHorarioAtencion() {
		return horarioAtencion;
	}


	public void setHorarioAtencion(String horarioAtencion) {
		this.horarioAtencion = horarioAtencion;
	}


	public ArrayList<Vehiculo> getListaVehiculos() {
		return listaVehiculos;
	}


	public void setListaVehiculos(ArrayList<Vehiculo> listaVehiculos) {
		this.listaVehiculos = listaVehiculos;
	}


	public ArrayList<Reserva> getListaReservas() {
		return listaReservas;
	}


	public void setListaReservas(ArrayList<Reserva> listaReservas) {
		this.listaReservas = listaReservas;
	}
}


package logica;

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
		super(username, password);
		this.codigoSede = codigoSede;
		this.cargo = Roles.EMPLEADO;
		}
	
	/**
	 * <!-- METODOS REALIZABLES POR EMPLEADO -->
	 */

	
	public void mandarMantenimiento() {
		// TODO implement me	
	}
	
	public Void crearCliente() {
		// TODO implement me
		return null;	
	}
	
	public Void iniciarReserva() {
		// TODO implement me
		return null;	
	}
	
	
	public String cerrarGuardarReserva() {
		// TODO implement me
		return "";	
	}
	
	
	public void reporteCarrosMantenimiento() {
		// TODO implement me	
	}
	

	public void addConductorAdicional() {
		// TODO implement me	
	}

	/**
	 * <!-- METODOS PARA LA PARTE DE USUARIO INTERACTIVA -->
	 */
	
	@Override
	public String mostrarMenu() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void ejecutarOpcion() {
		// TODO Auto-generated method stub
		return null;
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
package logica;

import java.util.ArrayList;

/**
 * <!--ACA DOCUMENTACION-->
 * TODO Lo de las imagenes png. Y hacer metodos para que el empleado pueda acceder a el
 *  numero tarjeta y fecha vencimiento, y ahi si ponerlas privadas en vez de protegido, y que el metodo 
 *  que acceda a estas primero pregunte if usuario.cargo = ROLES.EMPLEADO entonces que si pueda
 *  si se quisiera podria hacerse lo msimo con el admin y para cualquier funcion chequear los permisos. -->
 */

public class Cliente extends Usuario {
	
	private static final long serialVersionUID = 2L;
	protected Roles cargo;
	public String nombreCliente;
	public String email;
	public String telefono;
	public String fechaNacimiento;
	public String nacionalidad;	
	public String imagenCedula; //TODO .... No se como se hace para aceptar imagenes png
	public String imagenLicencia;
	public String metodoDePago; 
	protected String numeroTarjeta;
	protected String fechaVencimiento;
	
	/**
	 * <!--CONSTRUCTOR-->
	 */

	public Cliente(String username, String password, Roles cargo, String nombreCliente, String email, String telefono, String fechaNacimiento, String nacionalidad, String imagenCedula,String imagenLicencia, String metodoDePago, String numeroTarjeta, String fechaVencimiento) {
		super(username, password, cargo);
		this.cargo = Roles.CLIENTE;
		this.email = email;
		this.telefono = telefono;
		this.fechaNacimiento = fechaNacimiento;
		this.nacionalidad = nacionalidad;	
		this.imagenCedula = imagenCedula; //TODO ... Cambiar a imagen png
		this.imagenLicencia = imagenCedula;
		this.metodoDePago = metodoDePago; 
		this.numeroTarjeta = numeroTarjeta;
		this.fechaVencimiento = fechaVencimiento;
		
	}
	
	/**
	 * <!--METODOS QUE USA EL CLIENTE-->
	 */
	
	public String iniciarReserva(TipoVehiculo tipoDeCarro,
			String sedeRecogida, String sedeEntrega,String fechaHoraRecogida, String fechaHoraEntrega,
			String usernameCliente, String rutaImagenConductorAdiciones, int duracionPorDia) {
			
			ArrayList<String> listaConductoresAdicionales= new ArrayList<String>();
			
			Reserva reserva= new Reserva(Reserva.generarNumeroReserva(), listaConductoresAdicionales, tipoDeCarro, sedeRecogida, sedeEntrega, fechaHoraRecogida, fechaHoraEntrega, usernameCliente, rutaImagenConductorAdiciones, 0,0, Entrega.ESPERANDOASERENTREGADOACLIENTE);
			String Mensaje =reserva.iniciarReserva();
		
		return Mensaje ;	
	}
	
	private String cerrarGuardarReserva() {
		// TODO implement me
		return "";	
	}
	
	public void getMetodoDePago() {
		// TODO implement me
		setNumeroTarjeta(numeroTarjeta);
		setFechaVencimiento(fechaVencimiento);
	}
	
	
	
	
	/**
	 * <!--GETTERS SETTERS-->
	 */

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getImagenCedula() {
		return imagenCedula;
	}

	public void setImagenCedula(String imagenCedula) {
		this.imagenCedula = imagenCedula;
	}

	public String getImagenLicencia() {
		return imagenLicencia;
	}

	public void setImagenLicencia(String imagenLicencia) {
		this.imagenLicencia = imagenLicencia;
	}

	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}

	//La idea seria hacer un metodo arriba que solo te deje extraer estos valores si eres empleado, ya que recuerden
	//Que el empleado tambien puede crear un cliente. Si no se puede entonces dejenlos publicos y ya.
	private void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}

	public void setFechaVencimiento(String fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public void setMetodoDePago(String metodoDePago) {
		this.metodoDePago = metodoDePago;
	}
	
	public void getCerrarSesion() {
		cerrarGuardarReserva();
	}
	
	
}


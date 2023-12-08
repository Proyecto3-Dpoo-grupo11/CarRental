package logica;

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
	public String imagenCedula; 
	public String imagenLicencia;
	public String metodoDePago; 
	protected String numeroTarjeta;
	protected String fechaVencimiento;
	public double precioFinal;
	public int numeroTransaccion;
	
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
		this.imagenCedula = imagenCedula; 
		this.imagenLicencia = imagenCedula;
		this.metodoDePago = metodoDePago; 
		this.numeroTarjeta = numeroTarjeta;
		this.fechaVencimiento = fechaVencimiento;
		
	}
	
	/**
	 * <!--METODOS QUE USA EL CLIENTE-->
	 */
	
	public String iniciarReserva(TipoVehiculo tipoDeCarro,
			String sedeRecogida, String sedeEntrega,String nuevaSedeEntrega,String fechaHoraRecogida, String fechaHoraEntrega,
			String usernameCliente, String rutaImagenConductorAdiciones, int cantidadConductoresAdicionales, Entrega estadoEntrega,Sede sede,boolean descuento) {
			
			
			
			Reserva reserva= new Reserva(Reserva.generarNumeroReserva(), tipoDeCarro,sedeRecogida, sedeEntrega,nuevaSedeEntrega, fechaHoraRecogida, fechaHoraEntrega, usernameCliente, rutaImagenConductorAdiciones,cantidadConductoresAdicionales,estadoEntrega,sede, descuento );
			String Mensaje =reserva.iniciarReserva();
			setPrecioFinal(reserva.getCalculoPrecioFinal());
			setNumeroTransaccion(reserva.getNumeroTransaccion());
		
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

	public double getPrecioFinal() {
		return precioFinal;
	}

	public void setPrecioFinal(double precioFinal) {
		this.precioFinal = precioFinal;
	}

	public int getNumeroTransaccion() {
		return numeroTransaccion;
	}

	public void setNumeroTransaccion(int numeroTransaccion) {
		this.numeroTransaccion = numeroTransaccion;
	}
	
	
}


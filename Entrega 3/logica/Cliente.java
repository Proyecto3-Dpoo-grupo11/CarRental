package logica;

import java.util.ArrayList;
import java.util.Random;

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
	// Datos de la tarjeta del cliente
	public String numeroClaveTarjeta;
	public String fechaVencimiento;
	public int saldo;
	public int precioFinal;
	
	
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
		this.numeroClaveTarjeta = numeroTarjeta;
		this.fechaVencimiento = fechaVencimiento;
		
	}
	
	/**
	 * <!--METODOS QUE USA EL CLIENTE-->
	 */
	
	public String iniciarReserva(String codigoReserva, String tipoDeCarro,
			String sedeRecogida, String sedeEntrega, String nuevaSedeEntrega,String fechaHoraRecogida, String fechaHoraEntrega,
			String placaVehiculo, String usernameCliente, String rutaImagenConductorAdiciones, int cantidadConductoresAdicionales) {
			Reserva reserva= new Reserva(codigoReserva,tipoDeCarro,sedeRecogida,sedeEntrega, nuevaSedeEntrega,fechaHoraRecogida,fechaHoraEntrega,
					placaVehiculo,usernameCliente,rutaImagenConductorAdiciones, cantidadConductoresAdicionales,
					 Entrega.ENTREGADOACIENTE);
			String Mensaje =reserva.iniciarReserva();
			setPrecioFinal(reserva.getCalculoPrecioFinal());
			
			
			//TODO CAMBIAR A INSTANCIA SEDE
//			for(Sede sedes : EmpresaAlquiler.listaSedes) {
//				if (sedes.codigoSede==codigoSede) {
//					sedes.mapaReservas.put(reserva.codigoReserva,reserva);
//				}
					
				
			
		
		return Mensaje ;	
	}
	
	
	
	private String cerrarGuardarReserva() {
		// TODO implement me
		return "";	
	}
	
	public void getMetodoDePago() {
		// TODO implement me
		setNumeroTarjeta(numeroClaveTarjeta);
		setFechaVencimiento(fechaVencimiento);
	}
	
	public static String generarNumeroReserva() {
        // Create a Random object
        Random random = new Random();

        // Generate a random integer between 1 and 100 (inclusive)
        int randomNumber = random.nextInt(100) + 1;

        // Convert the random number to a string
        return String.valueOf(randomNumber);
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
		return numeroClaveTarjeta;
	}

	//La idea seria hacer un metodo arriba que solo te deje extraer estos valores si eres empleado, ya que recuerden
	//Que el empleado tambien puede crear un cliente. Si no se puede entonces dejenlos publicos y ya.
	private void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroClaveTarjeta = numeroTarjeta;
	}

	private String getFechaVencimiento() {
		return fechaVencimiento;
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

	public int getSaldo() {
		return saldo;
	}

	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}

	public int getPrecioFinal() {
		return precioFinal;
	}

	public void setPrecioFinal(int precioFinal) {
		this.precioFinal = precioFinal;
	}
	
	
	
	
}


package logica;
import java.util.ArrayList;


/**
 * <!-- ACA VA LA DOCUMENTACION -->
 * TODO constructor, un monton, implementar las relaciones y demas cosas, los metodos etc. 
 * 
 *  PERO ES MEJOR que empiecen desde implementar el metodo crear reserva en cliente y empleado y ahi trabajen 
 *  con esta clase como quieran.-->
 */
//Esta se llamaria cuando se inicie la reserva desde cliente o desde empleado


public class Reserva
{
	
	public String codigoReserva;
	public ArrayList<ConductoresAdicionales> listaConductoresAdicionales;
	public String tipoDeCarro; // yo sugiero cambiarlo a una enum, depende de si se pueden agregar mas tipos de vehiculos
	public int sedeRecogida;
	public int sedeEntrega;
	public String fechaHoraRecogida;
	public String fechaHoraEntrega;
	public String placaVehiculo;
	public String usernameCliente;
	public Tarifa tarifa;
	public Seguro seguro;
	
	/**
	 * <!-- CONSTRUCTOR -->
	 */
	
	public Reserva(String codigoReserva, ArrayList<ConductoresAdicionales> listaConductoresAdicionales,
			String tipoDeCarro, int sedeRecogida, int sedeEntrega, String fechaHoraRecogida, String fechaHoraEntrega,
			String placaVehiculo, String usernameCliente, Tarifa tarifa, Seguro seguro) {
		super();
		this.codigoReserva = codigoReserva;
		this.listaConductoresAdicionales = listaConductoresAdicionales;
		this.tipoDeCarro = tipoDeCarro;
		this.sedeRecogida = sedeRecogida;
		this.sedeEntrega = sedeEntrega;
		this.fechaHoraRecogida = fechaHoraRecogida;
		this.fechaHoraEntrega = fechaHoraEntrega;
		this.placaVehiculo = placaVehiculo;
		this.usernameCliente = usernameCliente;
		this.tarifa = tarifa;
		this.seguro = seguro;
	}

	/**
	 * <!-- METODOS DE LA RESERVA -->
	 */
	
	// Creo que no deberia ir aqui, ya el empleado tiene este metodo. Pero dejenlo hasta que terminemos por si algo
	public void addConductorAdicional() {
		// TODO implement me	
	}
	
	
	public String terminarReserva() {
		//ESTO NO SE PASA A CODIGO HASTA QUE resuelvan el formato de fechas y todo eso.
		
		//duracion = fechaHoraEntrega - fechaHoraRecogida
		//ocuparVehiculo(duracion);
		return fechaHoraEntrega;
	}
	
	// al terminar la reserva ya se deberia hacer eso automaticamente
	private void ocuparVehiculo(int duracion) {
		// TODO implement me	
		//ACA SOLO SE CAMBIARIA EL ESTADO USANDO EL ENUM
	}
	
	//importantisimo, con los getters y setters sale, solo es que formateen el texto
	public String generarFactura() {
		// TODO implement me	
		return "Su factura fue blablabla ";
	}
	
	/**
	 * <!-- GETTERS SETTERS -->
	 */

	public String getCodigoReserva() {
		return codigoReserva;
	}

	public void setCodigoReserva(String codigoReserva) {
		this.codigoReserva = codigoReserva;
	}

	public ArrayList<ConductoresAdicionales> getListaConductoresAdicionales() {
		return listaConductoresAdicionales;
	}

	public void setListaConductoresAdicionales(ArrayList<ConductoresAdicionales> listaConductoresAdicionales) {
		this.listaConductoresAdicionales = listaConductoresAdicionales;
	}

	public String getTipoDeCarro() {
		return tipoDeCarro;
	}

	public void setTipoDeCarro(String tipoDeCarro) {
		this.tipoDeCarro = tipoDeCarro;
	}

	public int getSedeRecogida() {
		return sedeRecogida;
	}

	public void setSedeRecogida(int sedeRecogida) {
		this.sedeRecogida = sedeRecogida;
	}

	public int getSedeEntrega() {
		return sedeEntrega;
	}

	public void setSedeEntrega(int sedeEntrega) {
		this.sedeEntrega = sedeEntrega;
	}

	public String getFechaHoraRecogida() {
		return fechaHoraRecogida;
	}

	public void setFechaHoraRecogida(String fechaHoraRecogida) {
		this.fechaHoraRecogida = fechaHoraRecogida;
	}

	public String getFechaHoraEntrega() {
		return fechaHoraEntrega;
	}

	public void setFechaHoraEntrega(String fechaHoraEntrega) {
		this.fechaHoraEntrega = fechaHoraEntrega;
	}

	public String getCodigoVehiculo() {
		return placaVehiculo;
	}

	public void setCodigoVehiculo(String codigoVehiculo) {
		this.placaVehiculo = codigoVehiculo;
	}

	public String getUsernameCliente() {
		return usernameCliente;
	}

	public void setUsernameCliente(String usernameCliente) {
		this.usernameCliente = usernameCliente;
	}

	public Tarifa getTarifa() {
		return tarifa;
	}

	public void setTarifa(Tarifa tarifa) {
		this.tarifa = tarifa;
	}

	public Seguro getSeguro() {
		return seguro;
	}

	public void setSeguro(Seguro seguro) {
		this.seguro = seguro;
	}
	
	
	
	
}

